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
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhc;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhcId;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
public class TempRojoActivity extends AbstractAsyncActivity {

	protected static final String TAG = TempRojoActivity.class.getSimpleName();
	private String recurso;
	private Double temperatura;
	private String observacion;
	private String lugarText;
	private ImageButton mBarcodeButton;
	private EditText editRecurso;
	private EditText editTemperatura;
	private EditText editObs;
	private TextView labelTemperatura;
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
		setContentView(R.layout.temprojo);
		editRecurso = (EditText) findViewById(R.id.recurso);
		editRecurso.setFocusable(true);
		editRecurso.setEnabled(false);
		editRecurso.requestFocus();
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
				recurso = savedInstanceState.getString(KEEP_CODIGO);
			}
		}

		labelTemperatura = ((TextView) findViewById(R.id.label_temp));
		editTemperatura = ((EditText) findViewById(R.id.temp));
		editTemperatura.setFocusableInTouchMode(true);
		editTemperatura.setOnFocusChangeListener(new OnFocusChangeListener()
		{
			@Override
			public void onFocusChange(View v, boolean hasFocus) 
			{
				if (hasFocus == false)
				{  
					try{
						temperatura = Double.valueOf(editTemperatura.getText().toString());
					}
					catch(Exception e){
						return;
					}

					if (!(temperatura>=0 && temperatura<=12)){
						labelTemperatura.setText("Temperatura Inv�lida (refrigerada)");
						labelTemperatura.setTextColor(Color.RED);
					}
					else{
						labelTemperatura.setText("Temperatura");
						labelTemperatura.setTextColor(Color.BLACK);
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
					temperatura = Double.valueOf(editTemperatura.getText().toString());
				}
				catch(Exception e){
					showToast("No ingres� temperatura v�lida!!!",1);
					return;
				}
				observacion = editObs.getText().toString();
				lugarText = lugar.getSelectedItem().toString();
				if(validarEntrada()){
					TempRojoBhc temp = new TempRojoBhc();
					TempRojoBhcId tempId = new TempRojoBhcId();
					tempId.setRecurso(recurso);
					tempId.setFechaTempRojoBhc(new Date());
					temp.setTempRojoBhcId(tempId);
					temp.setTemperatura(temperatura);
					temp.setObservacion(observacion);
					temp.setLugar(lugarText);
					temp.setUsername(username);
					temp.setEstado(Constants.STATUS_NOT_SUBMITTED);
					temp.setFecreg(todayWithZeroTime);
					CohorteAdapter ca = new CohorteAdapter();
					ca.open();
					ca.crearTempRojoBhc(temp);
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
		if (recurso!=null) outState.putString(KEEP_CODIGO, recurso);
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
					ListTempRojoBhcActivity.class);
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
				recurso = sb;
				editRecurso.setText(sb);
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);
	}

	private boolean validarEntrada() {
		//Valida la entrada 
		//Valida la entrada 
		if (recurso == null){
			showToast(this.getString( R.string.error_recurso),1);
			return false;
		}
		else if (temperatura == null){
			showToast(this.getString( R.string.error_temp),1);
			return false;
		}
		else if (lugarText.matches("Seleccionar..")){
			showToast(this.getString( R.string.error_lugar),1);
			return false;
		}
		else if (!(temperatura>=0 && temperatura<=12)){
			showToast(this.getString( R.string.error_temp),1);
			return false;
		}
		else{
			return true;
		}
	}

	private void reiniciar(){
		editRecurso.setText(null);
		recurso = null;
		editTemperatura.setText(null);
		temperatura = null;
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
