package ni.org.ics.estudios.cohorte.muestreoanual.listeners;
public interface DownloadListener {
	void downloadComplete(String result);
	void progressUpdate(String message, int progress, int max);
}
