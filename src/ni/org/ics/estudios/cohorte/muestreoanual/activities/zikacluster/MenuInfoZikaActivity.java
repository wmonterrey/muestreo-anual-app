package ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster;



import java.util.Calendar;
import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.ReviewActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.nuevos.NewSintomaIniClusterActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.zikacluster.MenuInfoZikaAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.TamizajeZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;




import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class MenuInfoZikaActivity extends Activity {

	private Integer codigo;
	private static ParticipanteZikaCluster mParticipante = new ParticipanteZikaCluster();
	private static TamizajeZikaCluster mTamizaje = new TamizajeZikaCluster();
	private static CasaZikaCluster mCasa = new CasaZikaCluster();
	private GridView gridView;
	private TextView textView;
	private AlertDialog alertDialog;
	private static final int EXIT = 1;
	private boolean mExitShowing;
	private boolean pendiente = false;
	private static final String EXIT_SHOWING = "exitshowing";

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_zika);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(EXIT_SHOWING)) {
				mExitShowing = savedInstanceState.getBoolean(EXIT_SHOWING, false);
			}
		}
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		textView = (TextView) findViewById(R.id.label);
		getParticipanteData();
		String[] menu_zika_info = getResources().getStringArray(R.array.menu_zika_info);;
		gridView = (GridView) findViewById(R.id.gridView1);
		boolean esIndice = mParticipante.getIndice().matches("1");
		gridView.setAdapter(new MenuInfoZikaAdapter(this, R.layout.menu_item_2, menu_zika_info,esIndice, mParticipante));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Bundle arguments = new Bundle();
				Intent i;
				switch(position){
				
				case 0:
					i = new Intent(getApplicationContext(),
							MiembrosClusterZikaActivity.class);
					i.putExtra(ConstantsDB.CODIGO, codigo);
					startActivity(i);
					break;
				case 1:
					i = new Intent(getApplicationContext(),
							NewSintomaIniClusterActivity.class);
					i.putExtra(ConstantsDB.CODIGO, codigo);
					startActivity(i);
					break;
				case 2:
					i = new Intent(getApplicationContext(),
							MenuSintomasZikaActivity.class);
					i.putExtra(ConstantsDB.CODIGO, codigo);
					startActivity(i);
					break;
				case 4:
					arguments.putString(Constants.TITLE, getString(R.string.zika_datos_tam));
					if (mTamizaje!=null) arguments.putSerializable(Constants.OBJECTO , mTamizaje);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					i.putExtras(arguments);
					startActivity(i);	
					break;
				case 5:
					arguments.putString(Constants.TITLE, getString(R.string.zika_datos_part));
					if (mParticipante!=null) arguments.putSerializable(Constants.OBJECTO , mParticipante);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					i.putExtras(arguments);
					startActivity(i);
					break;
				case 6:
					arguments.putString(Constants.TITLE, getString(R.string.zika_datos_casa));
					if (mCasa!=null) arguments.putSerializable(Constants.OBJECTO , mCasa);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					i.putExtras(arguments);
					startActivity(i);
					break;
				default:
					arguments.putString(Constants.TITLE, getString(R.string.info_participante));
					if (mParticipante!=null) arguments.putSerializable(Constants.OBJECTO , mParticipante);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					i.putExtras(arguments);
					startActivity(i);					
					break;
				}
			}
		});

	}


	private void getParticipanteData() {
		CohorteAdapter ca = new CohorteAdapter();
		ca.open();
			mParticipante = ca.getParticipanteZikaCluster(ConstantsDB.CODIGO  + "=" + codigo, null);
			mCasa = ca.getCasaZikaCluster(ConstantsDB.codigo_casa  + "=" + mParticipante.getCodigo_casa(), null);
			mTamizaje = ca.getTamizajeZikaCluster(ConstantsDB.idTamizaje  + "='" + mParticipante.getIdTamizaje()+"'", null);
		ca.close();
		refreshView();
	}	

	private void refreshView() {
		pendiente = false;
		String labelHeader = "<b>"+mParticipante.getCodigo()+" - "+ mParticipante.getNombre1();
		if (mParticipante.getNombre2()!=null) labelHeader = labelHeader + " "+  mParticipante.getNombre2();
		labelHeader = labelHeader +" "+ mParticipante.getApellido1();
		if (mParticipante.getApellido2()!=null) labelHeader = labelHeader + " "+  mParticipante.getApellido2();
		textView.setText(Html.fromHtml(labelHeader));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(EXIT_SHOWING, mExitShowing);
	}

	@Override
	protected void onResume() {
		getParticipanteData();
		if (mExitShowing) {
			createDialog(EXIT);
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (alertDialog != null && alertDialog.isShowing()) {
			alertDialog.dismiss();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			if (pendiente){
				createDialog(EXIT);
			}
			else{
				finish();
			}
			return true;
		case R.id.MENU_HOME:
			if (pendiente){
				createDialog(EXIT);
			}
			else{
				i = new Intent(getApplicationContext(),
						MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed (){
		if (pendiente){
			createDialog(EXIT);
		}
		else{
			finish();
		}
	}

	private void createDialog(int dialog) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(dialog){
		case EXIT:
			builder.setTitle(this.getString(R.string.confirm));
			builder.setMessage(this.getString(R.string.confirm_pendiente));
			builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// Finish app
					dialog.dismiss();
					
					mExitShowing=false;
				}

			});
			builder.setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					dialog.dismiss();
					mExitShowing=false;
				}
			});
			mExitShowing=true;
			break;
		default:
			break;
		}
		alertDialog = builder.create();
		alertDialog.show();
	}
	
	public int getAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if(dateOfBirth!= null) {
            now.setTime(new Date());
            born.setTime(dateOfBirth);  
            if(born.after(now)) {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
            if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
                age-=1;
            }
        }  
        return age;
    }
}
	
