package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import java.io.File;
import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.AbstractAsyncActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapterGetObjects;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015Id;
import ni.org.ics.estudios.cohorte.muestreoanual.parsers.ReConsentimientoFlu2015Xml;
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


public class NewRecFlu2015Activity extends AbstractAsyncActivity {

	protected static final String TAG = NewRecFlu2015Activity.class.getSimpleName();

	private static Integer casaId = 0;
	private static Integer codigo = 0;
	public static final int ADD_PART =1;
	private String username;
	private SharedPreferences settings;
	private static Participante mParticipante = new Participante();
	private boolean visExitosa = false;

	private static ReConsentimientoFlu2015 mReConsentimiento = new ReConsentimientoFlu2015();
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
		casaId = getIntent().getIntExtra(ConstantsDB.COD_CASA,-1);
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		visExitosa = getIntent().getBooleanExtra(ConstantsDB.VIS_EXITO,false);
		getData();
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
		message.setText(getString(R.string.verify_rcflu));

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addReConsentimientoFlu();
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
				parseReConsentimientoFlu(idInstancia,instanceFilePath,cambio);
			}
			else{
				showToast(getApplicationContext().getString(R.string.err_not_completed),1);
			}
		}
		else{
			finish();
		}
		super.onActivityResult(requestCode, resultCode, intent);
	}

	public void parseReConsentimientoFlu(Integer idInstancia, String instanceFilePath, String ultimoCambio) {
		Serializer serializer = new Persister();
		File source = new File(instanceFilePath);
		try {
			ReConsentimientoFlu2015Xml em = new ReConsentimientoFlu2015Xml();
			em = serializer.read(ReConsentimientoFlu2015Xml.class, source);
			ReConsentimientoFlu2015Id reconsId = new ReConsentimientoFlu2015Id();
			reconsId.setCodigo(codigo);
			reconsId.setFechaCons(new Date());
			mReConsentimiento.setReconsfluId(reconsId);
			mReConsentimiento.setVisExit(em.getVisExit());
			mReConsentimiento.setNoexitosa(em.getNoexitosa());
			mReConsentimiento.setNombrept(em.getNombrept());
			mReConsentimiento.setNombrept2(em.getNombrept2());
			mReConsentimiento.setApellidopt(em.getApellidopt());
			mReConsentimiento.setApellidopt2(em.getApellidopt2());
			mReConsentimiento.setRelacionFam(em.getRelacionFam());
			mReConsentimiento.setOtraRelacionFam(em.getOtraRelacionFam());
			mReConsentimiento.setAlfabetoTutor(em.getAlfabetoTutor());
			mReConsentimiento.setTestigoSN(em.getTestigoSN());
			mReConsentimiento.setNombretest1(em.getNombretest1());
			mReConsentimiento.setNombretest2(em.getNombretest2());
			mReConsentimiento.setApellidotest1(em.getApellidotest1());
			mReConsentimiento.setApellidotest2(em.getApellidotest2());
			mReConsentimiento.setCmDomicilio(em.getCmDomicilio());
			mReConsentimiento.setBarrio(em.getBarrio());
			mReConsentimiento.setOtrobarrio(em.getOtrobarrio());
			mReConsentimiento.setDire(em.getDire());
			mReConsentimiento.setTelefContact(em.getTelefContact());
			mReConsentimiento.setTelefonoConv1(em.getTelefonoConv1());
			mReConsentimiento.setTelefonoCel1(em.getTelefonoCel1());
			mReConsentimiento.setTelefonoCel2(em.getTelefonoCel2());
			mReConsentimiento.setAsentimiento(em.getAsentimiento());
			mReConsentimiento.setParteAFlu(em.getParteAFlu());
			mReConsentimiento.setPorqueno(em.getPorqueno());
			mReConsentimiento.setContacto_futuro(em.getContacto_futuro());
			mReConsentimiento.setParteBFlu(em.getParteBFlu());
			mReConsentimiento.setParteCFlu(em.getParteCFlu());
			mReConsentimiento.setLocal(em.getLocal());
			mReConsentimiento.setOtrorecurso1(em.getOtrorecurso1());
			mReConsentimiento.setOtrorecurso2(em.getOtrorecurso2());
			
			mReConsentimiento.setMovilInfo(new MovilInfo(idInstancia,
					instanceFilePath,
					Constants.STATUS_NOT_SUBMITTED,
					ultimoCambio,
					em.getStart(),
					em.getEnd(),
					em.getDeviceid(),
					em.getSimserial(),
					em.getPhonenumber(),
					em.getToday(),
					username,
					false, em.getRecurso1(), em.getRecurso2()));
			
			//Guarda en la base de datos local
			CohorteAdapter ca = new CohorteAdapter();
			ca.open();
			ca.crearReConsentimientoFlu2015(mReConsentimiento);
			if (em.getVisExit().matches("1")) {
				mParticipante.setConsFlu("No");
				mParticipante.setMovilInfo(new MovilInfo(idInstancia,
						instanceFilePath,
						Constants.STATUS_NOT_SUBMITTED,
						ultimoCambio,
						em.getStart(),
						em.getEnd(),
						em.getDeviceid(),
						em.getSimserial(),
						em.getPhonenumber(),
						em.getToday(),
						username,
						false, em.getRecurso1(), em.getRecurso2()));
				ca.actualizaParticipante(mParticipante);
				ca.close();
				showToast(getApplicationContext().getString(R.string.success),0);
				Intent i = new Intent(getApplicationContext(),
						MenuInfoActivity.class);
				i.putExtra(ConstantsDB.COD_CASA, casaId);
				i.putExtra(ConstantsDB.CODIGO, codigo);
				i.putExtra(ConstantsDB.VIS_EXITO, visExitosa);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
			else{
				showToast(getApplicationContext().getString(R.string.success),0);
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
		} catch (Exception e) {
			// Presenta el error al parsear el xml
			showToast(e.toString(),1);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private void addReConsentimientoFlu() {
		try{
			//campos de proveedor de collect
			String[] projection = new String[] {
					"_id","jrFormId","displayName"};
			//cursor que busca el formulario
			Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
					"jrFormId = 'ICDR_Recons_FLU2015' and displayName = 'ICDR_Recons_FLU2015'", null, null);
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
			String valores[] = new String[2];
			valores[0] = "edad";
			valores[1] = mParticipante.getEdad().toString();
			odkA.putExtra("vc", valores);
			startActivityForResult(odkA,ADD_PART);
		}
		catch(Exception e){
			//No existe el formulario en el equipo
			Log.e(TAG, e.getMessage(), e);
			showToast(e.getLocalizedMessage(),1);
		}
	}

	private void getData() {
		CohorteAdapterGetObjects ca = new CohorteAdapterGetObjects();
		ca.open();
		mParticipante = ca.getParticipante(codigo);
		ca.close();	
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
