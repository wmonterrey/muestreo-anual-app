package ni.org.ics.estudios.cohorte.muestreoanual.activities;
/**
 * Actividad que presenta la lista
 * 
 * @author William Aviles
 **/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.Temp2Adapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhc;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhcId;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.FileUtils;




import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListTempRojoBhcActivity extends ListActivity{

	private ImageButton mBarcodeButton;
	private EditText mSearchText;
	private TextWatcher mFilterTextWatcher;
	private ArrayAdapter<TempRojoBhc> mTempAdapter;
	private ArrayList<TempRojoBhc> mTemps = new ArrayList<TempRojoBhc>();
	private Date todayWithZeroTime = null;
	private Button mSearchButton;

	public static final int BARCODE_CAPTURE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.find_item);
		setTitle(getString(R.string.app_name));

		if (!FileUtils.storageReady()) {
			Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error, R.string.storage_error),Toast.LENGTH_LONG);
			toast.show();
			finish();
		}


		//Configuracion para la busqueda
		mFilterTextWatcher = new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (mTempAdapter != null) {
					mTempAdapter.getFilter().filter(s);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}
		};

		mSearchText = (EditText) findViewById(R.id.search_text);
		mSearchText.addTextChangedListener(mFilterTextWatcher);
		mSearchButton = (Button) findViewById(R.id.search_button);
		mSearchButton.setVisibility(View.GONE);

		mBarcodeButton = (ImageButton) findViewById(R.id.barcode_button);
		mBarcodeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.google.zxing.client.android.SCAN");
				try {
					startActivityForResult(i, BARCODE_CAPTURE);
				} catch (ActivityNotFoundException e) {
					Toast t = Toast.makeText(getApplicationContext(),
							getString(R.string.error, R.string.barcode_error),
							Toast.LENGTH_LONG);
					t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					t.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.MENU_BACK:
			finish();
			return true;
		case R.id.MENU_HOME:
			Intent i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {
		
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {

		if (requestCode == BARCODE_CAPTURE && intent != null) {
			String sb = intent.getStringExtra("SCAN_RESULT");
			if (sb != null && sb.length() > 0) {
				mSearchText.setText(sb);
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);

	}

	private void getTemps() {

		CohorteAdapter ca = new CohorteAdapter();
		
		ca.open();
		Cursor temppbmcs = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		try {
			todayWithZeroTime =formatter.parse(formatter.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temppbmcs = ca.obtenerTempRojoBhc(todayWithZeroTime);

		if (temppbmcs != null && temppbmcs.getCount() > 0) {

			mTemps.clear();

			TempRojoBhc mTemp;
			do{
				mTemp = new TempRojoBhc();
				TempRojoBhcId tempId = new TempRojoBhcId();
				tempId.setRecurso(temppbmcs.getString(temppbmcs.getColumnIndex(ConstantsDB.RECURSO)));
				tempId.setFechaTempRojoBhc(new Date(temppbmcs.getLong(temppbmcs.getColumnIndex(ConstantsDB.FECHA_TEMP))));
				mTemp.setTempRojoBhcId(tempId);
				mTemp.setTemperatura(temppbmcs.getDouble(temppbmcs.getColumnIndex(ConstantsDB.TEMP)));
				mTemp.setLugar(temppbmcs.getString(temppbmcs.getColumnIndex(ConstantsDB.LUGARTEMP)));
				mTemp.setObservacion(temppbmcs.getString(temppbmcs.getColumnIndex(ConstantsDB.OBSTEMP)));
				mTemp.setUsername(temppbmcs.getString(temppbmcs.getColumnIndex(ConstantsDB.USERNAME)));
				mTemp.setEstado(temppbmcs.getString(temppbmcs.getColumnIndex(ConstantsDB.STATUS)));
				mTemp.setFecreg(new Date(temppbmcs.getLong(temppbmcs.getColumnIndex(ConstantsDB.TODAY))));
				mTemps.add(mTemp);
			} while (temppbmcs.moveToNext());
		}
		
		refreshView();

		if (temppbmcs != null) {
			temppbmcs.close();
		}
		ca.close();
		
	}

	private void refreshView() {

		mTempAdapter = new Temp2Adapter(this, R.layout.complex_list_item,
				mTemps);
		setListAdapter(mTempAdapter);

	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		mSearchText.removeTextChangedListener(mFilterTextWatcher);

	}

	@Override
	protected void onResume() {
		super.onResume();
		getTemps();
		// filtrar nuevamente
		mSearchText.setText(mSearchText.getText().toString());
		showToast("Total de mediciones = "+ mTempAdapter.getCount() ,5);
	}
	
	private void showToast(String mensaje, int numImage){
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		ImageView image = (ImageView) layout.findViewById(R.id.image);

		switch(numImage){
		case 0:
			image.setImageResource(R.drawable.ic_ok);
			break;
		case 1:
			image.setImageResource(R.drawable.ic_error);
			break;
			
		case 2:
			image.setImageResource(R.drawable.bhctubes);
			break;
			
			
		case 3:
			image.setImageResource(R.drawable.redtubes);
			break;
			
		case 4:
			image.setImageResource(R.drawable.blue_thermo);
			break;
			
		case 5:
			image.setImageResource(R.drawable.red_thermo);
			break;
			
			
		default:
			image.setImageResource(R.drawable.ic_launcher);
			break;
		}


		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText(mensaje);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();

	}

}
