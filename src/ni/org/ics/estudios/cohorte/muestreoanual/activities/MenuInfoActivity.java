package ni.org.ics.estudios.cohorte.muestreoanual.activities;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.adapters.MenuInfoAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.DatosPartoBB;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.DatosVisitaTerreno;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Documentos;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.LactanciaMaterna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Muestra;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.NewVacuna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Obsequio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.PesoyTalla;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.VisitaTerreno;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.ui.GridViewWithHeaderAndFooter;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;




import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MenuInfoActivity extends Activity {

	private Integer codigo;
	private static Participante mParticipante = new Participante();
	private static User mUser = new User();
	private static ArrayList<ReConsentimientoFlu2015> mReConsentimientoFlu = new ArrayList<ReConsentimientoFlu2015>();
	private ArrayList<VisitaTerreno> mVisitasTerreno = new ArrayList<VisitaTerreno>();
	private ArrayList<PesoyTalla> mPyTs = new ArrayList<PesoyTalla>();
	private ArrayList<EncuestaCasa> mEncuestasCasas = new ArrayList<EncuestaCasa>();
	private ArrayList<EncuestaParticipante> mEncuestasParticipantes = new ArrayList<EncuestaParticipante>();
	private ArrayList<LactanciaMaterna> mEncuestasLactancias = new ArrayList<LactanciaMaterna>();
	private ArrayList<NewVacuna> mVacunas = new ArrayList<NewVacuna>();
	private ArrayList<ReConsentimientoDen2015> mReConsentimientoDen = new ArrayList<ReConsentimientoDen2015>();
	private ArrayList<Muestra> mMuestras = new ArrayList<Muestra>();
	private ArrayList<Obsequio> mObsequios = new ArrayList<Obsequio>();
	private ArrayList<ConsentimientoZika> mConsentimientoZikas = new ArrayList<ConsentimientoZika>();
	private ArrayList<DatosPartoBB> mDatosPartoBBs = new ArrayList<DatosPartoBB>();
	private ArrayList<DatosVisitaTerreno> mDatosVisitaTerreno = new ArrayList<DatosVisitaTerreno>();
	private ArrayList<Documentos> mDocumentos = new ArrayList<Documentos>();
	private String username;
	private SharedPreferences settings;
	private GridViewWithHeaderAndFooter gridView;
	private TextView textView;
	private AlertDialog alertDialog;
	private static final int EXIT = 1;
	private boolean mExitShowing;
	private boolean visExitosa = false;
	private boolean pendiente = false;
	private static final String EXIT_SHOWING = "exitshowing";
	public static final int VISITA =100;
    private MenuItem reConsFluItem; 
    private MenuItem pesoTallaItem;      
    private MenuItem encCasaItem;      
    private MenuItem encPartItem;      
    private MenuItem encLactItem;      
    private MenuItem vacunaItem;      
	private MenuItem visitaItem;
	private MenuItem reConsDenItem;
	private MenuItem muestraItem;
	private MenuItem obsequioItem;
	private MenuItem zikaItem;
	private MenuItem partoItem;
	private MenuItem datosCasaItem;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_screen);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(EXIT_SHOWING)) {
				mExitShowing = savedInstanceState.getBoolean(EXIT_SHOWING, false);
				visExitosa = savedInstanceState.getBoolean("YAVISITADO", false);
			}
		}
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		visExitosa = getIntent().getBooleanExtra(ConstantsDB.VIS_EXITO,false);
		
		String[] menu_info = getResources().getStringArray(R.array.menu_info);
		gridView = (GridViewWithHeaderAndFooter) findViewById(R.id.gridView1);
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View headerView = layoutInflater.inflate(R.layout.test_header_view, null);
		gridView.addHeaderView(headerView);
		textView = (TextView) findViewById(R.id.label);
		getParticipanteData();
		
		
		gridView.setAdapter(new MenuInfoAdapter(this, R.layout.menu_item_2, menu_info, mReConsentimientoFlu.size()
				,mVisitasTerreno.size(),mPyTs.size(),mEncuestasCasas.size(),mEncuestasParticipantes.size(),
				mEncuestasLactancias.size(),mVacunas.size(),mReConsentimientoDen.size(),mMuestras.size(),mObsequios.size(),mConsentimientoZikas.size(), mDatosPartoBBs.size(), mDatosVisitaTerreno.size() , mDocumentos.size()));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Bundle arguments = new Bundle();
				Intent i;
				switch(position){
				
				case 0:
					arguments.putString(Constants.TITLE, getString(R.string.info_participante));
					if (mParticipante!=null) arguments.putSerializable(Constants.OBJECTO , mParticipante);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					break;
				case 1:
					arguments.putString(Constants.TITLE, getString(R.string.info_reconflu));
					if (mReConsentimientoFlu!=null) arguments.putSerializable(Constants.OBJECTO , mReConsentimientoFlu);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 2:
					arguments.putString(Constants.TITLE, getString(R.string.info_visit));
					if (mVisitasTerreno!=null) arguments.putSerializable(Constants.OBJECTO , mVisitasTerreno);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 3:
					arguments.putString(Constants.TITLE, getString(R.string.info_weight));
					if (mPyTs!=null) arguments.putSerializable(Constants.OBJECTO , mPyTs);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 4:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey2));
					if (mEncuestasCasas!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasCasas);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 5:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey1));
					if (mEncuestasParticipantes!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasParticipantes);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 6:
					arguments.putString(Constants.TITLE, getString(R.string.info_survey3));
					if (mEncuestasLactancias!=null) arguments.putSerializable(Constants.OBJECTO , mEncuestasLactancias);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 7:
					arguments.putString(Constants.TITLE, getString(R.string.info_vacc));
					if (mVacunas!=null) arguments.putSerializable(Constants.OBJECTO , mVacunas);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 8:
					arguments.putInt("codCasa", mParticipante.getCodCasa());
					arguments.putInt("codComun", mParticipante.getCodigo());
					
					i = new Intent(getApplicationContext(),
							ListParticipantesCasaActivity.class);
					break;
				case 9:
					arguments.putString(Constants.TITLE, getString(R.string.info_recon));
					if (mReConsentimientoDen!=null) arguments.putSerializable(Constants.OBJECTO , mReConsentimientoDen);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 10:
					arguments.putString(Constants.TITLE, getString(R.string.info_sample));
					if (mMuestras!=null) arguments.putSerializable(Constants.OBJECTO , mMuestras);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 11:
					arguments.putString(Constants.TITLE, getString(R.string.info_gift));
					if (mObsequios!=null) arguments.putSerializable(Constants.OBJECTO , mObsequios);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 12:
					arguments.putString(Constants.TITLE, getString(R.string.info_zika));
					if (mConsentimientoZikas!=null) arguments.putSerializable(Constants.OBJECTO , mConsentimientoZikas);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 13:
					arguments.putString(Constants.TITLE, getString(R.string.datos_parto));
					if (mDatosPartoBBs!=null) arguments.putSerializable(Constants.OBJECTO , mDatosPartoBBs);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;
				case 14:
					arguments.putString(Constants.TITLE, getString(R.string.datos_casa));
					if (mDatosVisitaTerreno!=null) arguments.putSerializable(Constants.OBJECTO , mDatosVisitaTerreno);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;					
				case 15:
					arguments.putString(Constants.TITLE, getString(R.string.info_docs));
					if (mDocumentos!=null) arguments.putSerializable(Constants.OBJECTO , mDocumentos);
					i = new Intent(getApplicationContext(),
							ListReviewActivity.class);
					break;					
				default:
					arguments.putString(Constants.TITLE, getString(R.string.info_participante));
					if (mParticipante!=null) arguments.putSerializable(Constants.OBJECTO , mParticipante);
					i = new Intent(getApplicationContext(),
							ReviewActivity.class);
					break;
				}
				i.putExtras(arguments);
				startActivity(i);
			}
		});

	}

	private void getParticipanteData() {
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mParticipante = ca.getParticipante(codigo);
		mReConsentimientoFlu = ca.getListaReConsentimientoFlu2015(codigo);
		mVisitasTerreno=ca.getListaVisitaTerreno(codigo);
		mPyTs = ca.getListaPesoyTallas(codigo);
		if(mParticipante.getCodCasa()!=9999) mEncuestasCasas = ca.getListaEncuestaCasas(mParticipante.getCodCasa());
		mEncuestasParticipantes = ca.getListaEncuestaParticipantes(codigo);
		mEncuestasLactancias = ca.getListaLactanciaMaternas(codigo);
		mReConsentimientoDen=ca.getListaReConsentimientoDen2015(codigo);
		mMuestras=ca.getListaMuestras(codigo);
		mObsequios=ca.getListaObsequios(codigo);
		mConsentimientoZikas=ca.getListaConsentimientoZika(codigo);
		mDatosVisitaTerreno = ca.getListaDatosVisitaTerreno(codigo);
		mUser = ca.getUser(username);
		ca.close();
		CohorteAdapter caTemp = new CohorteAdapter();
		caTemp.open();
		String filtro = ConstantsDB.CODIGO + "=" + codigo;
		mDatosPartoBBs = caTemp.getDatosPartoBBs(filtro, null);
		mVacunas=caTemp.getNewVacunas(filtro, null);
		mDocumentos =caTemp.getDocumentoss(filtro, null);
		caTemp.close();
		refreshView();
	}	

	private void refreshView() {
		pendiente = false;
		Integer edad = getAge(mParticipante.getFechaNac());
		String labelHeader = "<b>"+mParticipante.getCodigo()+" - "+ mParticipante.getNombre1();
		if (mParticipante.getNombre2()!=null) labelHeader = labelHeader + " "+  mParticipante.getNombre2();
		labelHeader = labelHeader +" "+ mParticipante.getApellido1();
		if (mParticipante.getApellido2()!=null) labelHeader = labelHeader + " "+  mParticipante.getApellido2();
		labelHeader = labelHeader +" - ("+ mParticipante.getEstudio()+")";
		if (edad==0){
			edad = mParticipante.getEdad();
			labelHeader = labelHeader +" - "+ edad +"M</b><br />";
		}
		else{
			labelHeader = labelHeader +" - "+ edad +"A</b><br />";
		}
		
		
		Integer relacionFam = mParticipante.getRelacionFam();
		String relacion = null;
		switch(relacionFam){
		case 1:
			relacion = "Madre";
			break;
		case 2:
			relacion = "Padre";
			break;
		case 3:
			relacion = "Abuelo (a)";
			break;
		case 4:
			relacion = "Tío (a)";
			break;
		case 5:
			relacion = "Hermano (a)";
			break;
		case 6:
			relacion = "Otra relación familiar";
			break;
		default:
			relacion = "Sin Relación Familiar";
		}
		labelHeader = labelHeader + "<small><font color='black'>"+mParticipante.getNombrePt1();
		labelHeader = labelHeader +" - ("+ relacion +")" +"</font></small><br />";
		labelHeader = labelHeader + "<small><font color='black'>Personas en casa: "+mParticipante.getCuantasPers()+"</font></small><br />";

		if (mParticipante.getEstPart().equals(0)){
			labelHeader = labelHeader + "<small><font color='red'>" + getString(R.string.retired_error) + "</font></small><br />";
		}
		else{
			if (mParticipante.getPosZika().matches("Si")) labelHeader = labelHeader + "<small><font color='red'>Participante positivo a ZIKA</font></small><br />";
			
			if (mParticipante.getConsFlu().matches("Si")|| mParticipante.getPesoTalla().matches("Si")
					|| mParticipante.getEnCasa().matches("Si")||mParticipante.getEncPart().matches("Si")
					|| mParticipante.getEncLacMat().matches("Si")||mParticipante.getInfoVacuna().matches("Si")
					|| mParticipante.getConsDeng().matches("Si") || mParticipante.getObsequio().matches("Si")
					|| mParticipante.getConmx().matches("No") || mParticipante.getConmxbhc().matches("No")|| mParticipante.getZika().matches("Si")
					|| mParticipante.getAdn().matches("Si")|| mParticipante.getDatosParto().matches("Si")|| mParticipante.getDatosVisita().matches("Si")){
				labelHeader = labelHeader + "<small><font color='red'>Pendiente: <br /></font></small>";

				//Primero muestras
				//'#B941E0'purple
				//'#11BDF7' blue
				//'#32B507' green
				if(mUser.getMuestra()){
					if (mParticipante.getConvalesciente().matches("Na")){	
						labelHeader = labelHeader + "<small><font color='red'>" + getString(R.string.convless14) + "</font></small><br />";
					}
					else{
						if(mParticipante.getEstudio().equals("Cohorte BB")){
							if (mParticipante.getEdad()>=6){
								if (mParticipante.getConmx().matches("No")){
									if (mParticipante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='red'>Tomar 2cc en tubo Rojo<br /></font></small>";
									}
									pendiente =true;
								}
								if (mParticipante.getConmxbhc().matches("No")){
									if (mParticipante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
									}
									pendiente =true;
								}
							}
						}
						else if(mParticipante.getEstudio().equals("Influenza")){
							if(mParticipante.getEdad()>=6 && mParticipante.getEdad()<24){
								if (mParticipante.getConmx().matches("No")){
									if (mParticipante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='red'>Tomar 1cc en tubo Rojo<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='#B941E0'>No tomar BHC<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='red'>Tomar 2cc en tubo Rojo<br /></font></small>";
									}
									pendiente =true;
								}
								if (mParticipante.getConmxbhc().matches("No") && mParticipante.getPbmc().matches("No")){
									if (mParticipante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
									}
									pendiente =true;
								}
							}
							else {
								if (mParticipante.getConmx().matches("No")){
									if (mParticipante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='red'>Tomar 1cc en tubo Rojo<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='red'>Tomar 6cc en tubo Rojo<br /></font></small>";
									}
									pendiente =true;
								}
								if (mParticipante.getConmxbhc().matches("No")){
									if (mParticipante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
									}
									pendiente =true;
								}
							}
						}	
						else if(mParticipante.getEstudio().equals("Influenza  Cohorte BB")){
							if(mParticipante.getEdad()>=6 && mParticipante.getEdad()<24){
								if (mParticipante.getConmx().matches("No")){
									if (mParticipante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 2cc en tubo PBMC<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='red'>Tomar 1cc en tubo Rojo<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='#B941E0'>No tomar BHC<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='red'>Tomar 2cc en tubo Rojo<br /></font></small>";
									}
									pendiente =true;
								}
								if (mParticipante.getConmxbhc().matches("No") && mParticipante.getPbmc().matches("No")){
									if (mParticipante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
									}
									pendiente =true;
								}
							}
							else {
								if (mParticipante.getConmx().matches("No")){
									if (mParticipante.getPbmc().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font></small>";
										labelHeader = labelHeader + "<small><font color='red'>Tomar 1cc en tubo Rojo<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='red'>Tomar 6cc en tubo Rojo<br /></font></small>";
									}
									pendiente =true;
								}
								if (mParticipante.getConmxbhc().matches("No")){
									if (mParticipante.getPaxgene().matches("Si")){
										labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
									}
									else{
										labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
									}
									pendiente =true;
								}
							}
						}	
						else if(mParticipante.getEstudio().equals("Dengue")){
							if (mParticipante.getConmx().matches("No")){
								if (mParticipante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font></small>";
								}
								else{
									labelHeader = labelHeader + "<small><font color='red'>Tomar 6cc en tubo Rojo<br /></font></small>";
								}
								pendiente =true;
							}
							if (mParticipante.getConmxbhc().matches("No")){
								if (mParticipante.getPaxgene().matches("Si")){
									labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
								}
								else{
									labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
								}
								pendiente =true;
							}
						}
						else if(mParticipante.getEstudio().equals("Dengue  Influenza")){
							if (mParticipante.getConmx().matches("No")){
								if (mParticipante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<small><font color='#11BDF7'>Tomar 6cc en tubo PBMC<br /></font></small>";
									labelHeader = labelHeader + "<small><font color='red'>Tomar 1cc en tubo Rojo<br /></font></small>";
								}
								else{
									labelHeader = labelHeader + "<small><font color='red'>Tomar 6cc en tubo Rojo<br /></font></small>";
								}
								pendiente =true;
							}
							if (mParticipante.getConmxbhc().matches("No")){
								if (mParticipante.getPaxgene().matches("Si")){
									labelHeader = labelHeader + "<small><font color='#32B507'>Tomar 1cc para BHC (Paxgene)<br /></font></small>";
								}
								else{
									labelHeader = labelHeader + "<small><font color='#B941E0'>Tomar 1cc para BHC<br /></font></small>";
								}
								pendiente =true;
							}
						}
						if (mParticipante.getConvalesciente().matches("Si")&& mParticipante.getEdad()>=24){
							if (mParticipante.getConmx().matches("No")){
								if (mParticipante.getPbmc().matches("Si")){
									labelHeader = labelHeader + "<small><font color='#de3163'>Tomar 5cc de convaleciente<br /></font></small>";
								}
								else{
									labelHeader = labelHeader + "<small><font color='#de3163'>Tomar 5cc de convaleciente<br /></font></small>";
								}
							}
						}
						if ((mParticipante.getRetoma()!=null && mParticipante.getVolRetoma()!=null)){
							if ((mParticipante.getRetoma().matches("Si")) && mUser.getMuestra()){
								labelHeader = labelHeader + "<small><font color='red'>" + getString(R.string.retoma) +": " + mParticipante.getVolRetoma() + "cc </font></small><br />";
							}
						}
					}						
				}
				
				//Nuevo orden				

				if (mParticipante.getEnCasa().matches("Si") && mUser.getEncuestaCasa()) {
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.house_survey_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getEncPart().matches("Si") && mUser.getEncuestaParticipante()) {
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.part_survey_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getConsFlu().matches("Si") && mUser.getConsentimiento()){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.consflu_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getConsDeng().matches("Si") && mUser.getConsentimiento()) {
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.consden_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getZika().matches("Si") && mUser.getConsentimiento()) {
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.zika_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getEncLacMat().matches("Si") && mUser.getEncuestaLactancia()){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.maternal_survey_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getPesoTalla().matches("Si") && mUser.getPesoTalla()){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.weigth_heigth_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getDatosParto().matches("Si") && mUser.getDatosparto()){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.parto_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getInfoVacuna().matches("Si") && mUser.getVacunas()){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.vaccines_missing) + "</font></small><br />";
					pendiente=true;
				}
				if (mParticipante.getDatosVisita().matches("Si") && mUser.getVisitas()){
					labelHeader = labelHeader + "<small><font color='blue'>Pediente datos casa</font></small><br />";
					pendiente=true;
				}
				if ((mParticipante.getObsequio().matches("Si"))){
					labelHeader = labelHeader + "<small><font color='blue'>" + getString(R.string.gift_missing) + "</font></small><br />";
				}
				if (mParticipante.getAdn().matches("Si")) {
					labelHeader = labelHeader + "<small><font color='red'>Pendiente de ADN, Informar a LAB para toma.</font></small><br />";
				}
			}
			else{
				labelHeader = labelHeader + "<small><font color='blue'>No tiene procedimientos pendientes<br /></font></small>";
			}				
		}
		textView.setText(Html.fromHtml(labelHeader));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		if (mParticipante.getEstPart().equals(0)){
			getMenuInflater().inflate(R.menu.general, menu);
		}
		else{
			getMenuInflater().inflate(R.menu.menu_info, menu);
		    reConsFluItem = menu.findItem(R.id.RECONSFLU); 
		    pesoTallaItem = menu.findItem(R.id.WEIGHT);      
		    encCasaItem = menu.findItem(R.id.SURVEY2);      
		    encPartItem = menu.findItem(R.id.SURVEY1);      
		    encLactItem = menu.findItem(R.id.SURVEY3);      
		    vacunaItem = menu.findItem(R.id.VACC);      
		    visitaItem = menu.findItem(R.id.MENU_VISIT);
		    reConsDenItem = menu.findItem(R.id.RECONS);
		    muestraItem = menu.findItem(R.id.SAMPLE);
		    obsequioItem = menu.findItem(R.id.GIFT);
		    zikaItem = menu.findItem(R.id.ZIKA);
		    partoItem = menu.findItem(R.id.PARTO);
		    datosCasaItem = menu.findItem(R.id.DAT_CASA);
		    
		}
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
		outState.putBoolean("YAVISITADO", visExitosa);
	}

	@Override
	protected void onResume() {
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
			if (pendiente){
				createDialog(EXIT);
			}
			else{
				finish();
			}
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

		case R.id.MENU_VISIT:
			if(mUser.getVisitas()){
				i = new Intent(getApplicationContext(),
						NewVisitaActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
				i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
				i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
				startActivity(i);
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		
		case R.id.DAT_CASA:
			if(mUser.getVisitas()){
				if(mParticipante.getDatosVisita().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewDatosVisitaActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;		
			
		case R.id.RECONSFLU:
			if(mUser.getConsentimiento()){
				if(mParticipante.getConsFlu().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewRecFlu2015Activity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		
		case R.id.WEIGHT:
			if(mUser.getPesoTalla()){
				if(mParticipante.getPesoTalla().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewPtActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		
		case R.id.SURVEY2:
			if(mUser.getEncuestaCasa()){
				if(mParticipante.getEnCasa().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewEcActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.SURVEY1:
			if(mUser.getEncuestaParticipante()){
				if(mParticipante.getEncPart().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewEpActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.SURVEY3:
			if(mUser.getEncuestaLactancia()){
				if(mParticipante.getEncLacMat().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewElActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;			
		case R.id.VACC:
			if(mUser.getVacunas()){
				if(mParticipante.getInfoVacuna().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewNewVaccActivity.class);
					//i = new Intent(getApplicationContext(),
					//		VacunaActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.RECONS:
			if(mUser.getConsentimiento()){
				if(mParticipante.getConsDeng().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewRec2015Activity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.SAMPLE:
			if(mUser.getMuestra()){
				if(mParticipante.getConmx().matches("No")||mParticipante.getConmxbhc().matches("No")){
					if (mParticipante.getConvalesciente().matches("Na")){
						Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.convless14),Toast.LENGTH_LONG);
						toast.show();
					}
					else{
					i = new Intent(getApplicationContext(),
							NewSampleActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
					}
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.GIFT:
			if(mUser.getObsequio()){
				if(mParticipante.getObsequio().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewObActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.ZIKA:
			if(mUser.getConsentimiento()){
				if(mParticipante.getZika().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewZikaActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.PARTO:
			if(mUser.getDatosparto()){
				if(mParticipante.getDatosParto().matches("Si")){
					i = new Intent(getApplicationContext(),
							NewDatosPartoBBActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
					startActivity(i);
				}
				else{
					Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.e_error),Toast.LENGTH_LONG);
					toast.show();
				}
			}
			else{
				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.perm_error),Toast.LENGTH_LONG);
				toast.show();
			}
			return true;
		case R.id.DOC:	
			i = new Intent(getApplicationContext(),
					DocumentosActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.putExtra(ConstantsDB.COD_CASA, mParticipante.getCodCasa());
			i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
			i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
			startActivity(i);
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
					Intent i = new Intent(getApplicationContext(),
							RazonNoDataActivity.class);
					i.putExtra(ConstantsDB.CODIGO, mParticipante.getCodigo());
					startActivity(i);
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

	public boolean onPrepareOptionsMenu(Menu menu)
	{
	    reConsFluItem.setVisible(false);
	    pesoTallaItem.setVisible(false);
	    encCasaItem.setVisible(false);
	    encPartItem.setVisible(false);
	    encLactItem.setVisible(false);
	    vacunaItem.setVisible(false);
	    visitaItem.setVisible(false);
	    reConsDenItem.setVisible(false);
	    muestraItem.setVisible(false);
	    obsequioItem.setVisible(false);
	    zikaItem.setVisible(false);
	    partoItem.setVisible(false);
	    datosCasaItem.setVisible(false);
		if ((mUser.getVisitas()&&!visExitosa)){
			visitaItem.setVisible(true);
		}
		else{
			if((mParticipante.getConmx().matches("No") || mParticipante.getConmxbhc().matches("No"))  && mUser.getMuestra()) muestraItem.setVisible(true);
			if((mParticipante.getEnCasa().matches("Si") && mUser.getEncuestaCasa())) encCasaItem.setVisible(true);
			if((mParticipante.getEncPart().matches("Si") && mUser.getEncuestaParticipante())) encPartItem.setVisible(true);
			if ((mParticipante.getConsFlu().matches("Si") && mUser.getConsentimiento())) reConsFluItem.setVisible(true);
			if ((mParticipante.getConsDeng().matches("Si") && mUser.getConsentimiento())) reConsDenItem.setVisible(true);
		    if((mParticipante.getPesoTalla().matches("Si") && mUser.getPesoTalla())) pesoTallaItem.setVisible(true);
		    if((mParticipante.getEncLacMat().matches("Si") && mUser.getEncuestaLactancia())) encLactItem.setVisible(true);
		    if((mParticipante.getInfoVacuna().matches("Si") && mUser.getVacunas())) vacunaItem.setVisible(true);
		    if ((mParticipante.getZika().matches("Si") && mUser.getConsentimiento())) zikaItem.setVisible(true);
		    if ((mParticipante.getObsequio().matches("Si") && mUser.getObsequio())) obsequioItem.setVisible(true);
		    if ((mParticipante.getDatosParto().matches("Si") && mUser.getDatosparto())) partoItem.setVisible(true);
		    if ((mParticipante.getDatosVisita().matches("Si") && mUser.getVisitas())) datosCasaItem.setVisible(true);
		    visitaItem.setVisible(false);
		}
	    return true;
	}
}
	
