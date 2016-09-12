
package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import ni.org.ics.estudios.cohorte.muestreoanual.R;
import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.listeners.DownloadListener;
import ni.org.ics.estudios.cohorte.muestreoanual.preferences.PreferencesActivity;
import ni.org.ics.estudios.cohorte.muestreoanual.tasks.DownloadParticipanteTask;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.FileUtils;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class DownloadParticipanteActivity extends Activity implements DownloadListener{

	protected static final String TAG = DownloadParticipanteActivity.class.getSimpleName();

	private String username;
	private String password;
	private String url;
	private Integer codigo=0;
	private SharedPreferences settings;
	private DownloadParticipanteTask downloadParTask;
	private final static int PROGRESS_DIALOG = 1;
	private ProgressDialog mProgressDialog;

	// ***************************************
	// Metodos de la actividad
	// ***************************************
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(getString(R.string.app_name) + " > "
				+ getString(R.string.download));

		if (!FileUtils.storageReady()) {
			Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error, R.string.storage_error),Toast.LENGTH_LONG);
			toast.show();
			setResult(RESULT_CANCELED);
			finish();
		}
		
		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		url =
				settings.getString(PreferencesActivity.KEY_SERVER_URL, this.getString(R.string.default_server_url));
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		CohorteAdapter ca = new CohorteAdapter();
		ca.open();
		String pass = ca.buscarPassword(username);
		ca.close();
		
		password =
				pass;
		
		codigo = getIntent().getIntExtra(ConstantsDB.CODIGO,-1);
		downloadParTask = (DownloadParticipanteTask) getLastNonConfigurationInstance();
		if (downloadParTask == null) {
			downloadAllData();
		}
	}

	@SuppressWarnings("deprecation")
	private void downloadAllData(){   
		if (downloadParTask != null)
			return;
		showDialog(PROGRESS_DIALOG);
		downloadParTask = new DownloadParticipanteTask();
		downloadParTask.setDownloadListener(DownloadParticipanteActivity.this);
		downloadParTask.execute(url, username, password, codigo.toString());
	}

	@Override
	public void downloadComplete(String result) {

		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
		}

		if (result != null) {
			Intent intent = new Intent();
			intent.putExtra("resultado", result);
			setResult(RESULT_CANCELED, intent);
		} else {
			setResult(RESULT_OK);
		}

		downloadParTask = null;
		finish();
	}

	@Override
	public void progressUpdate(String message, int progress, int max) {

		mProgressDialog.setMax(max);
		mProgressDialog.setProgress(progress);
		mProgressDialog.setTitle(message);

	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return downloadParTask;
	}

	@Override
	protected void onDestroy() {
		if (downloadParTask != null) {
			downloadParTask.setDownloadListener(null);
		}
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (downloadParTask != null) {
			downloadParTask.setDownloadListener(this);
		}

		if (mProgressDialog != null && !mProgressDialog.isShowing()) {
			mProgressDialog.show();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();

		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == PROGRESS_DIALOG) {
			mProgressDialog = createDownloadDialog();
			return mProgressDialog;
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private ProgressDialog createDownloadDialog() {

		ProgressDialog dialog = new ProgressDialog(this);
		DialogInterface.OnClickListener loadingButtonListener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				downloadParTask.setDownloadListener(null);
				setResult(RESULT_CANCELED);
				finish();
			}
		};
		dialog.setTitle(getString(R.string.loading));
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setIndeterminate(false);
		dialog.setCancelable(false);
		dialog.setButton(getString(R.string.cancel),
				loadingButtonListener);
		return dialog;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {

		if (id == PROGRESS_DIALOG) {
			ProgressDialog progress = (ProgressDialog) dialog;
			progress.setTitle(getString(R.string.loading));
			progress.setProgress(0);
		}
	}

}
