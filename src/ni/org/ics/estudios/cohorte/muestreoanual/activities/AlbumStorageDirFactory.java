package ni.org.ics.estudios.cohorte.muestreoanual.activities;

import java.io.File;

abstract class AlbumStorageDirFactory {
	public abstract File getAlbumStorageDir(String albumName);
}
