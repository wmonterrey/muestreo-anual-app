package ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.nuevos;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import ni.org.ics.estudios.cohorte.muestreoanual.AbstractAsyncActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.SelecPartActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.MenuInfoZikaActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.TamizajeZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.parsers.zikacluster.TamizajeIndiceXml;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.FileUtils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class NewCasoIndiceActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewCasoIndiceActivity.class.getSimpleName();

	public static final int ADD_TAM =1;
	public static final int SEARCH_PART =2;
	private String username;
	private SharedPreferences settings;

	private static TamizajeZikaCluster mTamizaje = new TamizajeZikaCluster();
	private static CasaZikaCluster mCasaTamizaje = new CasaZikaCluster();
	private static ParticipanteZikaCluster mParticipanteZika = new ParticipanteZikaCluster();
	private static boolean esCohorte=false;
	Dialog dialogInit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!FileUtils.storageReady()) {
			Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error, R.string.storage_error),Toast.LENGTH_LONG);
			toast.show();
			finish();
		}
		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		createInitDialog();
	}

	/**
	 * Presenta dialogo inicial
	 */

	private void createInitDialog() {
		dialogInit = new Dialog(this, R.style.FullHeightDialog); 
		dialogInit.setContentView(R.layout.yesno); 
		dialogInit.setCancelable(false);

		//to set the message
		TextView message =(TextView) dialogInit.findViewById(R.id.yesnotext);
		message.setText(getString(R.string.verify_nz));

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				createSecondDialog();
			}
		});

		Button no = (Button) dialogInit.findViewById(R.id.yesnoNo);
		no.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// Cierra
				dialogInit.dismiss();
				finish();
			}
		});
		dialogInit.show();
	}
	
	
	private void createSecondDialog() {
		dialogInit = new Dialog(this, R.style.FullHeightDialog); 
		dialogInit.setContentView(R.layout.yesno); 
		dialogInit.setCancelable(false);

		//to set the message
		TextView message =(TextView) dialogInit.findViewById(R.id.yesnotext);
		message.setText(getString(R.string.verify_coh));

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				esCohorte = true;
				Intent i = new Intent(getApplicationContext(),
						SelecPartActivity.class);
				i.putExtra(Constants.MENU_INFO, false);
				i.putExtra(Constants.MENU_ZIKA, true);
				startActivityForResult(i,SEARCH_PART);
			}
		});

		Button no = (Button) dialogInit.findViewById(R.id.yesnoNo);
		no.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// Cierra
				esCohorte = false;
				addTamizaje(false,0);
			}
		});
		dialogInit.show();
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
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		if (requestCode == ADD_TAM){
			//Si todo salio bien en ODK Collect
			if (resultCode == RESULT_OK) {
				Uri instanceUri = intent.getData();
				//Busca la instancia resultado
				String[] projection = new String[] {
						"_id","instanceFilePath", "status","displaySubtext"};
				Cursor c = getContentResolver().query(instanceUri, projection,
						null, null, null);
				c.moveToFirst();
				//Captura la id de la instancia y la ruta del archivo para agregarlo al participante
				Integer idInstancia = c.getInt(c.getColumnIndex("_id"));
				String instanceFilePath = c.getString(c.getColumnIndex("instanceFilePath"));
				String complete = c.getString(c.getColumnIndex("status"));
				String cambio = c.getString(c.getColumnIndex("displaySubtext"));
				//cierra el cursor
				if (c != null) {
					c.close();
				}
				if (complete.matches("complete")){
					//Parsear el resultado obteniendo un participante si esta completa
					parseTamizajeIndice(idInstancia,instanceFilePath,cambio);
				}
				else{
					showToast(getApplicationContext().getString(R.string.err_not_completed),1);
				}
			}
			else{
				finish();
			}
		}
		if (requestCode == SEARCH_PART){
			if (resultCode == RESULT_OK) {
				Integer codigo =  intent.getIntExtra("codigo",0);
				addTamizaje(true,codigo);
			}
			else{
				finish();
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);
	}

	public void parseTamizajeIndice(Integer idInstancia, String instanceFilePath, String ultimoCambio) {
		Serializer serializer = new Persister();
		File source = new File(instanceFilePath);
		try {
			TamizajeIndiceXml tamizajeIndice = new TamizajeIndiceXml();
			tamizajeIndice = serializer.read(TamizajeIndiceXml.class, source);
			String idTamizaje = new UUID(username.hashCode(),new Date().hashCode()).toString();
			mTamizaje.setIdTamizaje(idTamizaje);
			mTamizaje.setFechaTamizaje(tamizajeIndice.getToday());
			mTamizaje.setGenero(tamizajeIndice.getGenero());
			mTamizaje.setAcepta_cons(tamizajeIndice.getAcepta_cons());
			mTamizaje.setPorque_no(tamizajeIndice.getPorque_no());
			mTamizaje.setDesc_porque_no(tamizajeIndice.getDesc_porque_no());
			mTamizaje.setIncTrZ(tamizajeIndice.getIncTrZ());
			mTamizaje.setAsentimiento(tamizajeIndice.getAsentimiento());
			mTamizaje.setAlfabeto(tamizajeIndice.getAlfabeto());
			mTamizaje.setTestigo(tamizajeIndice.getTestigo());
			mTamizaje.setNombretest1(tamizajeIndice.getNombretest1());
			mTamizaje.setNombretest2(tamizajeIndice.getNombretest2());
			mTamizaje.setApellidotest1(tamizajeIndice.getApellidotest1());
			mTamizaje.setApellidotest2(tamizajeIndice.getApellidotest2());
			mTamizaje.setParteATrZ(tamizajeIndice.getParteATrZ());
			mTamizaje.setAsentimientoesc(tamizajeIndice.getAsentimientoesc());
			mTamizaje.setParteBTrZ(tamizajeIndice.getParteBTrZ());
			mTamizaje.setParteCTrZ(tamizajeIndice.getParteCTrZ());
			mTamizaje.setPorqueno(tamizajeIndice.getPorqueno());
			Integer or = 0;
			if(tamizajeIndice.getOtrorecurso1()!= null) or = Integer.valueOf(tamizajeIndice.getOtrorecurso1());
			mTamizaje.setMovilInfo(new MovilInfo(idInstancia,
					instanceFilePath,
					Constants.STATUS_NOT_SUBMITTED,
					ultimoCambio,
					tamizajeIndice.getStart(),
					tamizajeIndice.getEnd(),
					tamizajeIndice.getDeviceid(),
					tamizajeIndice.getSimserial(),
					tamizajeIndice.getPhonenumber(),
					tamizajeIndice.getToday(),
					username,
					false, Integer.valueOf(tamizajeIndice.getRecurso1()), or));
			
			
			mCasaTamizaje.setCodigo_casa(Integer.valueOf(tamizajeIndice.getCodigo_casa()));
			mCasaTamizaje.setBarrio(tamizajeIndice.getBarrio());
			mCasaTamizaje.setJefenom(tamizajeIndice.getJefenom());
			mCasaTamizaje.setJefenom2(tamizajeIndice.getJefenom2());
			mCasaTamizaje.setJefeap(tamizajeIndice.getJefeap());
			mCasaTamizaje.setJefeap2(tamizajeIndice.getJefeap2());
			mCasaTamizaje.setDireccion(tamizajeIndice.getDireccion());
			mCasaTamizaje.setTelefono1(tamizajeIndice.getTelefono1());
			mCasaTamizaje.setTelefono2(tamizajeIndice.getTelefono2());
			mCasaTamizaje.setGeoref(tamizajeIndice.getGeoref());
			mCasaTamizaje.setManzana(tamizajeIndice.getManzana());
			mCasaTamizaje.setGeoref_razon(tamizajeIndice.getGeoref_razon());
			mCasaTamizaje.setGeoref_otraRazon(tamizajeIndice.getGeoref_otraRazon());
			mCasaTamizaje.setIdTamizaje(idTamizaje);
			mCasaTamizaje.setMovilInfo(new MovilInfo(idInstancia,
					instanceFilePath,
					Constants.STATUS_NOT_SUBMITTED,
					ultimoCambio,
					tamizajeIndice.getStart(),
					tamizajeIndice.getEnd(),
					tamizajeIndice.getDeviceid(),
					tamizajeIndice.getSimserial(),
					tamizajeIndice.getPhonenumber(),
					tamizajeIndice.getToday(),
					username,
					false, Integer.valueOf(tamizajeIndice.getRecurso1()), or));
			
			Integer codigoPart = 0;
			if(esCohorte)  codigoPart = Integer.valueOf(tamizajeIndice.getCodigo_TrZ());
			if(!esCohorte)  codigoPart = Integer.valueOf(tamizajeIndice.getCodigo_TrZ_ci());
			mParticipanteZika.setCodigo(codigoPart);
			mParticipanteZika.setCodigo_indice(codigoPart);
			mParticipanteZika.setCodigo_casa(Integer.valueOf(tamizajeIndice.getCodigo_casa()));
			mParticipanteZika.setIndice("1");
			if(esCohorte) mParticipanteZika.setCohorte("1");
			if(!esCohorte) mParticipanteZika.setCohorte("0");
			
			
			mParticipanteZika.setFechana(tamizajeIndice.getFechana());
			mParticipanteZika.setNombrept(tamizajeIndice.getNombrept());
			mParticipanteZika.setNombrept2(tamizajeIndice.getNombrept2());
			mParticipanteZika.setApellidopt(tamizajeIndice.getApellidopt());
			mParticipanteZika.setApellidopt2(tamizajeIndice.getApellidopt2());
			mParticipanteZika.setNombrepadre(tamizajeIndice.getNombrepadre());
			mParticipanteZika.setNombrepadre2(tamizajeIndice.getNombrepadre2());
			mParticipanteZika.setApellidopadre(tamizajeIndice.getApellidopadre());
			mParticipanteZika.setApellidopadre2(tamizajeIndice.getApellidopadre2());
			mParticipanteZika.setNombremadre(tamizajeIndice.getNombremadre());
			mParticipanteZika.setNombremadre2(tamizajeIndice.getNombremadre2());
			mParticipanteZika.setApellidomadre(tamizajeIndice.getApellidomadre());
			mParticipanteZika.setApellidomadre2(tamizajeIndice.getApellidomadre2());
			mParticipanteZika.setNombre1(tamizajeIndice.getNombre1());
			mParticipanteZika.setNombre2(tamizajeIndice.getNombre2());
			mParticipanteZika.setApellido1(tamizajeIndice.getApellido1());
			mParticipanteZika.setApellido2(tamizajeIndice.getApellido2());
			mParticipanteZika.setDondesalud(tamizajeIndice.getDondesalud());
			mParticipanteZika.setCentrosalud(tamizajeIndice.getCentrosalud());
			mParticipanteZika.setOcentrosalud(tamizajeIndice.getOcentrosalud());
			mParticipanteZika.setPuestosal(tamizajeIndice.getPuestosal());
			mParticipanteZika.setOtropuestosal(tamizajeIndice.getOtropuestosal());
			mParticipanteZika.setSolocssf(tamizajeIndice.getSolocssf());
			mParticipanteZika.setIdTamizaje(idTamizaje);
			
			mParticipanteZika.setMovilInfo(new MovilInfo(idInstancia,
					instanceFilePath,
					Constants.STATUS_NOT_SUBMITTED,
					ultimoCambio,
					tamizajeIndice.getStart(),
					tamizajeIndice.getEnd(),
					tamizajeIndice.getDeviceid(),
					tamizajeIndice.getSimserial(),
					tamizajeIndice.getPhonenumber(),
					tamizajeIndice.getToday(),
					username,
					false, Integer.valueOf(tamizajeIndice.getRecurso1()), or));
			
			//Guarda en la base de datos local
			CohorteAdapter ca = new CohorteAdapter();
			ca.open();
			ca.crearTamizajeZikaCluster(mTamizaje);
			ca.crearCasaZikaCluster(mCasaTamizaje);
			ca.crearParticipanteZikaCluster(mParticipanteZika);
			ca.close();
			showToast(getApplicationContext().getString(R.string.success),0);
			Intent i = new Intent(getApplicationContext(),
					MenuInfoZikaActivity.class);
			i.putExtra(ConstantsDB.CODIGO, codigoPart);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
		} catch (Exception e) {
			// Presenta el error al parsear el xml
			showToast(e.toString(),1);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private void addTamizaje(boolean cohorte, Integer codigo) {
		try{
			//campos de proveedor de collect
			String[] projection = new String[] {
					"_id","jrFormId","displayName"};
			//cursor que busca el formulario
			Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
					"jrFormId = 'TR_Zika_Tamizaje' and displayName = 'TR_Zika_Tamizaje'", null, null);
			c.moveToFirst();
			//captura el id del formulario
			Integer id = Integer.parseInt(c.getString(0));
			//cierra el cursor
			if (c != null) {
				c.close();
			}
			//forma el uri para ODK Collect
			Uri formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
			//Arranca la actividad ODK Collect en busca de resultado
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			if(cohorte){
				CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
				ca.open();
				Participante mParticipante = ca.getParticipante(codigo);
				Casa mCasa = ca.getCasa(mParticipante.getCodCasa());
				ca.close();
				String valores[] = new String[42];
				valores[0] = "genero";			valores[1] = "1"; if(mParticipante.getSexo().equals("F")) valores[1] = "2";
				valores[2] = "clasific_ci";		valores[3] = "1";
				valores[4] = "codigo_TrZ";		valores[5] = mParticipante.getCodigo().toString();
				valores[6] = "fechana";			valores[7] = mParticipante.getFechaNac().toString();
				valores[8] = "barrio";			valores[9] = mCasa.getBarrio().toString();
				valores[10] = "jefenom";		valores[11] = mCasa.getJefenom();
				valores[12] = "jefenom2";		valores[13] = mCasa.getJefenom2();
				valores[14] = "jefeap";			valores[15] = mCasa.getJefeap();
				valores[16] = "jefeap2";		valores[17] = mCasa.getJefeap2();
				valores[18] = "nombrept";		valores[19] = mParticipante.getNombrePt1();
				valores[20] = "nombrept2";		valores[21] = mParticipante.getNombrePt2();
				valores[22] = "apellidopt";		valores[23] = mParticipante.getApellidoPt1();
				valores[24] = "apellidopt2";	valores[25] = mParticipante.getApellidoPt2();
				valores[26] = "relaciontutor";	valores[27] = mParticipante.getRelacionFam().toString();
				valores[28] = "nombrepadre";	valores[29] = mParticipante.getNombrePadre();
				valores[30] = "nombremadre";	valores[31] = mParticipante.getNombreMadre();
				valores[32] = "direccion";		valores[33] = mCasa.getDireccion();
				valores[34] = "nombre1";		valores[35] = mParticipante.getNombre1();
				valores[36] = "nombre2";		valores[37] = mParticipante.getNombre2();
				valores[38] = "apellido1";		valores[39] = mParticipante.getApellido1();
				valores[40] = "apellido2";		valores[41] = mParticipante.getApellido2();
				odkA.putExtra("vc", valores);
			}
			else{
				String valores[] = new String[2];
				valores[0] = "clasific_ci";
				valores[1] = "0";
				odkA.putExtra("vc", valores);
			}
			startActivityForResult(odkA,ADD_TAM);
		}
		catch(Exception e){
			//No existe el formulario en el equipo
			Log.e(TAG, e.getMessage(), e);
			showToast(e.getLocalizedMessage(),1);
		}
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
