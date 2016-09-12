package ni.org.ics.estudios.cohorte.muestreoanual.tasks;

import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.listeners.UploadListener;
import android.os.AsyncTask;

public abstract class UploadTask extends
AsyncTask<String, String, String> {

	protected static final String TAG = UploadTask.class.getSimpleName();

	protected UploadListener mStateListener;
	protected CohorteAdapter va = new CohorteAdapter();

	@Override
	protected void onProgressUpdate(String... values) {
		synchronized (this) {
			if (mStateListener != null) {
				// update progress and total
				mStateListener.progressUpdate(values[0], Integer.valueOf(values[1]), Integer.valueOf(values[2]));
			}
		}

	}

	@Override
	protected void onPostExecute(String result) {
		synchronized (this) {
			if (mStateListener != null)
				mStateListener.uploadComplete(result);
		}
	}

	public void setUploadListener(UploadListener sl) {
		synchronized (this) {
			mStateListener = sl;
		}
	}
}

