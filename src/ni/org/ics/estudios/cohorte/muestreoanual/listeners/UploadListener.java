package ni.org.ics.estudios.cohorte.muestreoanual.listeners;

public interface UploadListener {
    void uploadComplete(String result);
    void progressUpdate(String message, int progress, int max);
}
