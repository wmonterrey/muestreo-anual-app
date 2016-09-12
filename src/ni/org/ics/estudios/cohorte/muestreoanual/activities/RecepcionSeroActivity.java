/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.AbstractAsyncActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.MainActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionSero;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionSeroId;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author William Aviles
 */
public class RecepcionSeroActivity extends AbstractAsyncActivity{

	protected static final String TAG = RecepcionSeroActivity.class.getSimpleName();
	private Integer codigo;
	private Double volumen;
	private String observacion;
	private String lugarText;
	private ImageButton mBarcodeButton;
	private EditText editCodigo;
	private EditText editVolumen;
	private EditText editObs;
	private TextView labelVolumen;
	private Spinner lugar;
	private Date todayWithZeroTime = null;
	private String username;
	private SharedPreferences settings;

	public static final int BARCODE_CAPTURE = 2;
	private static final int MENU_VIEW = Menu.FIRST + 2;

	private AlertDialog mAlertDialog;
	private boolean mAlertShowing;
	private static final String ALERT_SHOWING = "alertshowing";
	
	private boolean mAlertExitShowing;
	private static final String ALERT_EXIT_SHOWING = "alertexitshowing";
	private static final String KEEP_CODIGO = "keepcodigo";


	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recepcionsero);
		editCodigo = (EditText) findViewById(R.id.codigo);
		editCodigo.setFocusable(true);
		editCodigo.setEnabled(false);
		editCodigo.requestFocus();
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

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		try {
			todayWithZeroTime =formatter.parse(formatter.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);

		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(ALERT_SHOWING)) {
				mAlertShowing = savedInstanceState.getBoolean(ALERT_SHOWING, false);
			}
			if (savedInstanceState.containsKey(ALERT_EXIT_SHOWING)) {
				mAlertExitShowing = savedInstanceState.getBoolean(ALERT_EXIT_SHOWING, false);
			}
			if (savedInstanceState.containsKey(KEEP_CODIGO)) {
				codigo = savedInstanceState.getInt(KEEP_CODIGO, -1);
			}

		}

		labelVolumen = ((TextView) findViewById(R.id.label_volumen));
		editVolumen = ((EditText) findViewById(R.id.volumen));
		editVolumen.setFocusableInTouchMode(true);
		editVolumen.setOnFocusChangeListener(new OnFocusChangeListener()
		{
			@Override
			public void onFocusChange(View v, boolean hasFocus) 
			{
				if (hasFocus == false)
				{  
					try{
						volumen = Double.valueOf(editVolumen.getText().toString());
					}
					catch(Exception e){
						return;
					}

					if (!(volumen>=1 && volumen<=7)){
						labelVolumen.setText("Volumen Inv�lido");
						labelVolumen.setTextColor(Color.RED);
					}
					else{
						labelVolumen.setText("Volumen");
						labelVolumen.setTextColor(Color.BLACK);
					}
				}
			}
		});
		editObs = ((EditText) findViewById(R.id.obs));
		lugar = (Spinner) findViewById(R.id.lugar);
		List<String> list = new ArrayList<String>();
		list.add("Seleccionar..");
		list.add("Auditorio");
		list.add("Terreno");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(R.layout.spinner_item);
		lugar.setAdapter(dataAdapter);

		final Button saveButton = (Button) findViewById(R.id.save);
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//captura entrada de la muestra
				editObs.requestFocus();
				try{
					volumen = Double.valueOf(editVolumen.getText().toString());
				}
				catch(Exception e){
					showToast("No ingres� volumen v�lido!!!",1);
					return;
				}
				observacion = editObs.getText().toString();
				lugarText = lugar.getSelectedItem().toString();
				if(validarEntrada()){
					RecepcionSero tubo = new RecepcionSero();
					RecepcionSeroId tuboId = new RecepcionSeroId();
					tuboId.setCodigo(codigo);
					tuboId.setFechaRecSero(todayWithZeroTime);
					tubo.setRecSeroId(tuboId);
					tubo.setVolumen(volumen);
					tubo.setObservacion(observacion);
					tubo.setLugar(lugarText);
					tubo.setUsername(username);
					tubo.setEstado(Constants.STATUS_NOT_SUBMITTED);
					tubo.setFecreg(new Date());
					CohorteAdapter ca = new CohorteAdapter();
					ca.open();
					ca.crearRecepcionSero(tubo);
					ca.close();
					showToast("Registro Guardado",0);
					reiniciar();
				}
			}

		});

		final Button endButton = (Button) findViewById(R.id.finish);
		endButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//finaliza la actividad
				createExitDialog();
			}

		});
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(ALERT_SHOWING, mAlertShowing);
		outState.putBoolean(ALERT_EXIT_SHOWING, mAlertExitShowing);
		if (codigo!=null) outState.putInt(KEEP_CODIGO, codigo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		getMenuInflater().inflate(R.menu.general, menu);
		menu.add(0, MENU_VIEW, 0, getString(R.string.list))
		.setIcon(R.drawable.ic_btn_search);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
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
		case MENU_VIEW:
			i = new Intent(getApplicationContext(),
					ListRojosActivity.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {

		if (requestCode == BARCODE_CAPTURE && intent != null) {
			String sb = intent.getStringExtra("SCAN_RESULT");
			if (sb != null && sb.length() > 0) {
				try{
					codigo = Integer.parseInt(sb);
				}
				catch(Exception e){
					showToast("Lectura Inv�lida!!!!",1);
					return;
				}
			}
			if (codigo>0 && codigo <=10000){
				CohorteAdapter ca = new CohorteAdapter();
				ca.open();
				Cursor c  = null;
				c = ca.buscarRecepcionSero(codigo, todayWithZeroTime);
				if (c != null && c.getCount() > 0) {
					showToast("Ya ingres� este c�digo!!!!",1);
				}else{
					editCodigo.setText(codigo.toString());
				}
				ca.close();
			}
			else
			{
				showToast("Lectura Inv�lida!!!!",1);
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);
	}

	private boolean validarEntrada() {
		//Valida la entrada 
		//Valida la entrada 
		if (codigo == null){
			showToast(this.getString( R.string.error_codigo),1);
			return false;
		}
		else if (volumen == null){
			showToast(this.getString( R.string.error_volumen),1);
			return false;
		}
		else if (lugarText.matches("Seleccionar..")){
			showToast(this.getString( R.string.error_lugar),1);
			return false;
		}
		else if (!(volumen>=1 && volumen<=7)){
			showToast(this.getString( R.string.error_volumen),1);
			return false;
		}
		else if (!(codigo>0 && codigo<=10000)){
			showToast(this.getString( R.string.error_codigo),1);
			return false;
		}
		else{
			return true;
		}
	}

	private void reiniciar(){
		editCodigo.setText(null);
		codigo = null;
		editVolumen.setText(null);
		volumen = null;
		lugarText = null;
		editObs.setText(null);
		observacion =null;
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


	
	@Override
	public void onBackPressed (){
		createExitDialog();
	}
	@SuppressWarnings("deprecation")
	private void createExitDialog() {
		// Pregunta si desea salir o no
		mAlertDialog = new AlertDialog.Builder(this).create();
		mAlertDialog.setIcon(android.R.drawable.ic_dialog_info);
		mAlertDialog.setTitle(getString(R.string.confirm));
		mAlertDialog.setMessage(getString(R.string.exit));

		DialogInterface.OnClickListener uploadDialogListener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				switch (i) {
				case DialogInterface.BUTTON1: // yes
					mAlertExitShowing = false;
					finish();
				case DialogInterface.BUTTON2: // no
					mAlertExitShowing = false;
					dialog.dismiss();
					break;
				}
			}
		};
		mAlertDialog.setCancelable(false);
		mAlertDialog.setButton(getString(R.string.yes), uploadDialogListener);
		mAlertDialog.setButton2(getString(R.string.no), uploadDialogListener);
		mAlertExitShowing = true;
		mAlertDialog.show();
	}

}
