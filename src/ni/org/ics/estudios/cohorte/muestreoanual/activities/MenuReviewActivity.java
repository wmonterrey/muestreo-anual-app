package ni.org.ics.estudios.cohorte.muestreoanual.activities;



import java.util.ArrayList;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.MenuReviewAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaSatisfaccion;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.LactanciaMaterna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Muestra;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Obsequio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.PesoyTalla;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Vacuna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.VisitaTerreno;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;





import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MenuReviewActivity extends Activity {

	private static ArrayList<ReConsentimientoFlu2015> mReConsentimientoFlu = new ArrayList<ReConsentimientoFlu2015>();
	private ArrayList<VisitaTerreno> mVisitasTerreno = new ArrayList<VisitaTerreno>();
	private ArrayList<PesoyTalla> mPyTs = new ArrayList<PesoyTalla>();
	private ArrayList<EncuestaCasa> mEncuestasCasas = new ArrayList<EncuestaCasa>();
	private ArrayList<EncuestaParticipante> mEncuestasParticipantes = new ArrayList<EncuestaParticipante>();
	private ArrayList<LactanciaMaterna> mEncuestasLactancias = new ArrayList<LactanciaMaterna>();
	private ArrayList<Vacuna> mVacunas = new ArrayList<Vacuna>();
	private ArrayList<EncuestaSatisfaccion> mEncuestasS = new ArrayList<EncuestaSatisfaccion>();
	private ArrayList<ReConsentimientoDen2015> mReConsentimientoDen = new ArrayList<ReConsentimientoDen2015>();
	private ArrayList<Muestra> mMuestras = new ArrayList<Muestra>();
	private ArrayList<Obsequio> mObsequios = new ArrayList<Obsequio>();
	private ArrayList<ConsentimientoZika> mConsentimientoZika = new ArrayList<ConsentimientoZika>();
	private GridView gridView;
	private TextView textView;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_screen);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		getData();
		String[] menu_info = getResources().getStringArray(R.array.menu_review);
		textView = (TextView) findViewById(R.id.label);
		textView.setText(getString(R.string.main_report));
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new MenuReviewAdapter(this, R.layout.menu_item_2, menu_info, mReConsentimientoFlu.size()
				,mVisitasTerreno.size(),mPyTs.size(),mEncuestasCasas.size(),mEncuestasParticipantes.size(),
				mEncuestasLactancias.size(),mVacunas.size(),mEncuestasS.size(),mReConsentimientoDen.size(),mMuestras.size(), mObsequios.size(),mConsentimientoZika.size()));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Bundle arguments = new Bundle();
				Intent i;
				switch(position){

				case 0:
					arguments.putString(Constants.TITLE, getString(R.string.info_reconflu));
					if (mReConsentimientoFlu!=null) arguments.putSerializable(Constants.OBJECTO , mReConsentimientoFlu);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 1:
					arguments.putString(Constants.TITLE, getString(R.string.info_visit));
					if (mVisitasTerreno!=null) arguments.putSerializable(Constants.OBJECTO , mVisitasTerreno);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 2:
					arguments.putString(Constants.TITLE, getString(R.string.info_weight));
					if (mPyTs!=null) arguments.putSerializable(Constants.OBJECTO , mPyTs);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 3:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey2));
					if (mEncuestasCasas!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasCasas);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 4:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey1));
					if (mEncuestasParticipantes!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasParticipantes);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 5:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey3));
					if (mEncuestasLactancias!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasLactancias);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 6:
					arguments.putString(Constants.TITLE, getString(R.string.info_vacc));
					if (mVacunas!=null) arguments.putSerializable(Constants.OBJECTO , mVacunas);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 7:
					arguments.putString(Constants.TITLE, getString(R.string.main_survey));
					if (mEncuestasS!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasS);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 8:
					arguments.putString(Constants.TITLE, getString(R.string.info_recon));
					if (mReConsentimientoDen!=null) arguments.putSerializable(Constants.OBJECTO , mReConsentimientoDen);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 9:
					arguments.putString(Constants.TITLE, getString(R.string.info_sample));
					if (mMuestras!=null) arguments.putSerializable(Constants.OBJECTO , mMuestras);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 10:
					arguments.putString(Constants.TITLE, getString(R.string.info_gift));
					if (mObsequios!=null) arguments.putSerializable(Constants.OBJECTO , mObsequios);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 11:
					arguments.putString(Constants.TITLE, getString(R.string.info_zika));
					if (mConsentimientoZika!=null) arguments.putSerializable(Constants.OBJECTO , mConsentimientoZika);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				default:
					i = new Intent(getApplicationContext(),
							MenuReviewActivity.class);
					break;
				}
				i.putExtras(arguments);
				startActivity(i);
			}
		});

	}

	private void getData() {
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mReConsentimientoFlu = ca.getListaReConsentimientoFlu2015Hoy();
		mVisitasTerreno=ca.getListaVisitaTerrenoHoy();
		mPyTs = ca.getListaPesoyTallasHoy();
		mEncuestasCasas = ca.getListaEncuestaCasasHoy();
		mEncuestasParticipantes = ca.getListaEncuestaParticipantesHoy();
		mEncuestasLactancias = ca.getListaLactanciaMaternasHoy();
		mVacunas=ca.getListaVacunasHoy();
		mReConsentimientoDen=ca.getListaReConsentimientoDen2015Hoy();
		mMuestras=ca.getListaMuestrasHoy();
		mObsequios=ca.getListaObsequiosHoy();
		mConsentimientoZika=ca.getListaConsentimientoZikaHoy();
		mEncuestasS = ca.getEncuestaSatisfaccionHoy();
		ca.close();	
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
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			finish();
			return true;
		case R.id.MENU_HOME:
			i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
	
