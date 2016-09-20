package ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.nuevos;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import ni.org.ics.estudios.cohorte.muestreoanual.AbstractAsyncActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.activities.zikacluster.MenuSintomasZikaActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.SintomasZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.parsers.zikacluster.SintomasXml;
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


public class NewSintomaClusterActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewSintomaClusterActivity.class.getSimpleName();

	public static final int ADD_SINT =1;
	private String username;
	private SharedPreferences settings;

	private static SintomasZikaCluster mSintomasZika = new SintomasZikaCluster();
	Dialog dialogInit;
	private Integer codigo;

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
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		
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
		message.setText(getString(R.string.verify_mh));

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addSintomas();
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
		if (requestCode == ADD_SINT){
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
					parseSintomas(idInstancia,instanceFilePath,cambio);
				}
				else{
					showToast(getApplicationContext().getString(R.string.err_not_completed),1);
				}
			}
			else{
				finish();
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);
	}

	public void parseSintomas(Integer idInstancia, String instanceFilePath, String ultimoCambio) {
		Serializer serializer = new Persister();
		File source = new File(instanceFilePath);
		try {
			SintomasXml sintomas = new SintomasXml();
			sintomas = serializer.read(SintomasXml.class, source);
			String idSintomas = new UUID(username.hashCode(),new Date().hashCode()).toString();
			mSintomasZika.setIdSintoma(idSintomas);
			mSintomasZika.setCodigo(codigo);
			mSintomasZika.setFechaSint(sintomas.getFechaSint());
			mSintomasZika.setDiaSint(sintomas.getDiaSint());
			mSintomasZika.setFiebre(sintomas.getFiebre());
			mSintomasZika.setAstenia(sintomas.getAstenia());
			mSintomasZika.setMovilInfo(new MovilInfo(idInstancia,
					instanceFilePath,
					Constants.STATUS_NOT_SUBMITTED,
					ultimoCambio,
					sintomas.getStart(),
					sintomas.getEnd(),
					sintomas.getDeviceid(),
					sintomas.getSimserial(),
					sintomas.getPhonenumber(),
					sintomas.getToday(),
					username,
					false, Integer.valueOf(sintomas.getRecurso1()), 999));
			
			
			
			
			//Guarda en la base de datos local
			CohorteAdapter ca = new CohorteAdapter();
			ca.open();
			ParticipanteZikaCluster part = ca.getParticipanteZikaCluster(ConstantsDB.codigo +"="+ codigo, null);
			switch (sintomas.getDiaSint()){
				case 1: 	part.setSint1('1');		break;
				case 2:		part.setSint2('1');		break;
				case 3:		part.setSint3('1');		break;
				case 4:		part.setSint4('1');		break;
				case 5:		part.setSint5('1');		break;
				case 6:		part.setSint6('1');		break;
				case 7:		part.setSint7('1');		break;
				case 8:		part.setSint8('1');		break;
				case 9:		part.setSint9('1');		break;
				case 10:	part.setSint10('1');	break;
				case 11:	part.setSint11('1');	break;
				case 12:	part.setSint12('1');	break;
				case 13:	part.setSint13('1');	break;
				case 14:	part.setSint14('1');	break;
				case 15:	part.setSint15('1');	break;
				case 16:	part.setSint16('1');	break;
				case 17:	part.setSint17('1');	break;
				case 18:	part.setSint18('1');	break;
				case 19:	part.setSint19('1');	break;
				case 20:	part.setSint20('1');	break;
				case 21:	part.setSint21('1');	break;
				case 22:	part.setSint22('1');	break;
				case 23:	part.setSint23('1');	break;
				case 24:	part.setSint24('1');	break;
				case 25:	part.setSint25('1');	break;
				case 26:	part.setSint26('1');	break;
				case 27:	part.setSint27('1');	break;
				case 28:	part.setSint28('1');	break;
				default: 	break;
			}
			
			ca.crearSintomasZikaCluster(mSintomasZika);
			ca.editarParticipanteZikaCluster(part);
			ca.close();
			showToast(getApplicationContext().getString(R.string.success),0);
			Intent i = new Intent(getApplicationContext(),
					MenuSintomasZikaActivity.class);
			i.putExtra(ConstantsDB.CODIGO, codigo);
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
	private void addSintomas() {
		try{
			//campos de proveedor de collect
			String[] projection = new String[] {
					"_id","jrFormId","displayName"};
			//cursor que busca el formulario
			Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
					"jrFormId = 'TR_Zika_Sintomas' and displayName = 'TR_Zika_Sintomas'", null, null);
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
			startActivityForResult(odkA,ADD_SINT);
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
