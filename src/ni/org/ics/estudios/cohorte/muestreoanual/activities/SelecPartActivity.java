package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import java.util.ArrayList;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.ParticipanteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterEnvio;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

public class SelecPartActivity extends ListActivity {


	private Spinner mMetodoView;
	private EditText mCodigoView;
	private TextView mPartTextView;
	private ImageButton mBarcodeButton;
	private ImageButton mFindButton;
	private ImageButton mSelectButton;
	private String username;
	private SharedPreferences settings;
	private boolean desdeMenuPrincipal=false;
	private boolean desdeMenuZika=false;
	private AlertDialog alertDialog;
	
	public static final int BARCODE_CAPTURE = 2;

	private Integer codigo;
	private Integer codigoComun;
	private Integer codigoCasa;
	private Integer codigoCasaAnt;
	
	private ArrayAdapter<Participante> mParticipanteAdapter;
	private List<Participante> mParticipantes = new ArrayList<Participante>();
	private Participante participanteComun = new Participante();
	
	
	private String cadenaBusqueda;
	private Integer opcion;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selec_part_list);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		desdeMenuPrincipal = getIntent().getBooleanExtra(Constants.MENU_INFO, true);
		desdeMenuZika = getIntent().getBooleanExtra(Constants.MENU_ZIKA, true);
		codigoCasa = getIntent().getIntExtra(ConstantsDB.COD_CASA,-1);
		codigoComun = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		
		mMetodoView = (Spinner) findViewById(R.id.metodo_busqueda);
		List<String> list = new ArrayList<String>();
		list.add(getString(R.string.desc_barcode));
		list.add(getString(R.string.enter_code));
		list.add(getString(R.string.enter_name));
		list.add(getString(R.string.enter_lastname));
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		mMetodoView.setAdapter(dataAdapter);

		mMetodoView.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				if (position==0){
					mCodigoView.setVisibility(View.GONE);
					mFindButton.setVisibility(View.GONE);
					mBarcodeButton.setVisibility(View.VISIBLE);
				}
				else{
					mCodigoView.setVisibility(View.VISIBLE);
					mFindButton.setVisibility(View.VISIBLE);
					mBarcodeButton.setVisibility(View.GONE);
					mCodigoView.requestFocus();
					opcion = position;
					switch(position){
					case 1:
						mCodigoView.setHint(getString(R.string.enter_code));
						mCodigoView.setInputType(InputType.TYPE_CLASS_NUMBER);
						break;
					case 2:
						mCodigoView.setHint(getString(R.string.enter_name));
						mCodigoView.setInputType(InputType.TYPE_CLASS_TEXT);
						break;
					case 3:	
						mCodigoView.setHint(getString(R.string.enter_lastname));
						mCodigoView.setInputType(InputType.TYPE_CLASS_TEXT);
						break;
					default:
						mCodigoView.setHint(getString(R.string.enter_code));
						break;

					}
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});

		mBarcodeButton = (ImageButton) findViewById(R.id.barcode_button);
		mFindButton = (ImageButton) findViewById(R.id.find_button);
		mSelectButton = (ImageButton) findViewById(R.id.select_button);

		mBarcodeButton.setOnClickListener(new View.OnClickListener()  {
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

		mFindButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				switch(opcion){
				case 1:
					mParticipantes.clear();
					try{
						codigo = Integer.valueOf(mCodigoView.getText().toString());
					}
					catch(Exception e){
						mCodigoView.requestFocus();
						mCodigoView.setError(getString(R.string.code_error));
						return;
					}

					if (!(codigo>=1 && codigo<=75000)){
						mCodigoView.requestFocus();
						mCodigoView.setError(getString(R.string.code_error));
						return;
					}
					buscarParticipante(codigo);
					break;
				case 2:
					cadenaBusqueda = mCodigoView.getText().toString();
					if (!(cadenaBusqueda!=null)){
						mCodigoView.requestFocus();
						mCodigoView.setError(getString(R.string.search_hint));
						return;
					}
					buscarParticipanteNombres(cadenaBusqueda);
					break;
				case 3:
					cadenaBusqueda = mCodigoView.getText().toString();
					if (!(cadenaBusqueda!=null)){
						mCodigoView.requestFocus();
						mCodigoView.setError(getString(R.string.search_hint));
						return;
					}
					buscarParticipanteApellidos(cadenaBusqueda);
					break;
				default:
					break;
				}
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(mFindButton.getWindowToken(), 0);
			}
		});

		mSelectButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				
			}
		});

		mFindButton.setVisibility(View.GONE);
		mSelectButton.setVisibility(View.GONE);

		mCodigoView = (EditText) findViewById(R.id.codigo);
		mCodigoView.setVisibility(View.GONE);

		mPartTextView = (TextView) findViewById(R.id.participante);
		mPartTextView.setVisibility(View.GONE);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
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
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		Integer codigoScanned =0;
		if (requestCode == BARCODE_CAPTURE && intent != null) {
			String sb = intent.getStringExtra("SCAN_RESULT");
			if (sb != null && sb.length() > 0) {

				try{
					codigoScanned = Integer.parseInt(sb);
					CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
					ca.open();
					Participante mParticipante = ca.getParticipante(codigoScanned);
					ca.close();
					if (mParticipante.getCodigo() != null){
						codigo = mParticipante.getCodigo();
						if (desdeMenuPrincipal){
							Intent i = new Intent(getApplicationContext(),
									MenuInfoActivity.class);
							i.putExtra(ConstantsDB.CODIGO, codigo);
							i.putExtra(ConstantsDB.VIS_EXITO, false);
							startActivity(i);
						}
						else if (desdeMenuZika){
							Intent intent1 = new Intent();
							intent1.putExtra("codigo", codigo);
							setResult(RESULT_OK, intent1);
							finish();
						}
						else{
							createConfirmDialog();
						}
					}
					else {
						//mSearchText.setText(sb);
						showToast("("+codigoScanned+") - " + getString(R.string.code_notfound));
					}
				}
				catch(Exception e){
					showToast(getString(R.string.scan_error));
					return;
				}
			}
		}

		super.onActivityResult(requestCode, resultCode, intent);

	}

	public void buscarParticipante(Integer codigoScanned){
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		Participante mParticipante = ca.getParticipante(codigoScanned);
		ca.close();
		if (mParticipante.getCodigo() != null){
			mParticipantes.add(mParticipante);
		}
		else {
			//mSearchText.setText(sb);
			showToast("("+codigoScanned+") - " + getString(R.string.code_notfound));
		}
		refreshView();
	}
	
	public void buscarParticipanteNombres(String name){
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mParticipantes = ca.getListaParticipantesName(name);
		ca.close();
		refreshView();
	}
	
	public void buscarParticipanteApellidos(String lastname){
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mParticipantes = ca.getListaParticipantesLastName(lastname);
		ca.close();
		refreshView();
	}
	
	private void refreshView() {
		mParticipanteAdapter = new ParticipanteAdapter(this, R.layout.complex_list_item,
				mParticipantes);
		setListAdapter(mParticipanteAdapter);
	}

	private void showToast(String mensaje){
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText(mensaje);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();

	}
	
	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {

		Participante mParticipante = (Participante) getListAdapter().getItem(position);
		codigo = mParticipante.getCodigo();
		codigoCasaAnt = mParticipante.getCodCasa();
		if (desdeMenuPrincipal){
			Intent i = new Intent(getApplicationContext(),
					MenuInfoActivity.class);
			i.putExtra(ConstantsDB.CODIGO, codigo);
			i.putExtra(ConstantsDB.VIS_EXITO, false);
			startActivity(i);
		}
		else if (desdeMenuZika){
			Intent intent1 = new Intent();
			intent1.putExtra("codigo", codigo);
			setResult(RESULT_OK, intent1);
			finish();
		}
		else{
			createConfirmDialog();
		}
	}
	
	private void createConfirmDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.confirm));
		builder.setMessage("Desea agregar al participante " + codigo + " a la casa " + codigoCasa + "?");
		builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Finish app
				dialog.dismiss();
				CohorteAdapterEnvio catemp = new CohorteAdapterEnvio();
				catemp.open();
				catemp.createCambioCasa(codigo, codigoCasaAnt, codigoCasa, username);
				CohorteAdapterGetObjects co = new CohorteAdapterGetObjects();
				co.open();
				participanteComun = co.getParticipante(codigoComun);
				co.close();
				catemp.updateCasaParticipante(codigoCasa,codigo,username,participanteComun.getEnCasa());
				catemp.close();
				Toast.makeText(getApplicationContext(),"Actualizado!!!!!",Toast.LENGTH_LONG).show();
				finish();
			}
		});
		builder.setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Do nothing
				dialog.dismiss();
			}
		});
		alertDialog = builder.create();
		alertDialog.show();
	}

}
