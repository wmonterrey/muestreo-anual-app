package ni.org.ics.estudios.cohorte.muestreoanual.tasks;

import ni.org.ics.estudios.cohorte.muestreoanual.database.CohorteAdapter;
import ni.org.ics.estudios.cohorte.muestreoanual.listeners.DownloadListener;
import android.os.AsyncTask;

public abstract class DownloadTask extends
AsyncTask<String, String, String> {

	protected static final String TAG = DownloadTask.class.getSimpleName();

	protected DownloadListener mStateListener;
	protected CohorteAdapter ca = new CohorteAdapter();

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
				mStateListener.downloadComplete(result);
		}
	}

	public void setDownloadListener(DownloadListener sl) {
		synchronized (this) {
			mStateListener = sl;
		}
	}
}

