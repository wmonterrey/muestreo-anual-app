package ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster;

import java.util.Date;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;

import android.content.ContentValues;
import android.database.Cursor;

public class CasaZikaClusterHelper {
	
	public static ContentValues crearCasaZikaClusterContentValues(CasaZikaCluster casa){
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.codigo_casa, casa.getCodigo_casa());
		cv.put(ConstantsDB.barrio, casa.getBarrio());
		cv.put(ConstantsDB.jefenom, casa.getJefenom());
		cv.put(ConstantsDB.jefenom2, casa.getJefenom2());
		cv.put(ConstantsDB.jefeap, casa.getJefeap());
		cv.put(ConstantsDB.jefeap2, casa.getJefeap2());
		cv.put(ConstantsDB.direccion, casa.getDireccion());
		cv.put(ConstantsDB.telefono1, casa.getTelefono1());
		cv.put(ConstantsDB.telefono2, casa.getTelefono2());
		cv.put(ConstantsDB.georef, casa.getGeoref());
		cv.put(ConstantsDB.Manzana, casa.getManzana());
		cv.put(ConstantsDB.georef_razon, casa.getGeoref_razon());
		cv.put(ConstantsDB.georef_otraRazon, casa.getGeoref_otraRazon());
		cv.put(ConstantsDB.idTamizaje, casa.getIdTamizaje());
		cv.put(ConstantsDB.encuesta, String.valueOf(casa.getEncuesta()));
		cv.put(ConstantsDB.encuestaEnt, String.valueOf(casa.getEncuestaEnt()));
		cv.put(ConstantsDB.ID_INSTANCIA, casa.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, casa.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, casa.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, casa.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, casa.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, casa.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, casa.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, casa.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, casa.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, casa.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, casa.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, casa.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, casa.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, casa.getMovilInfo().getRecurso2());
		return cv; 
	}	
	
	
	public static CasaZikaCluster crearCasaZikaCluster(Cursor cursorCasa){
		
		CasaZikaCluster mCasaZikaCluster = new CasaZikaCluster();
		mCasaZikaCluster.setCodigo_casa(cursorCasa.getInt(cursorCasa.getColumnIndex(ConstantsDB.codigo_casa)));
		mCasaZikaCluster.setBarrio(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.barrio)));
		mCasaZikaCluster.setJefenom(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.jefenom)));
		mCasaZikaCluster.setJefenom2(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.jefenom2)));
		mCasaZikaCluster.setJefeap(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.jefeap)));
		mCasaZikaCluster.setJefeap2(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.jefeap2)));
		mCasaZikaCluster.setDireccion(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.direccion)));
		mCasaZikaCluster.setTelefono1(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.telefono1)));
		mCasaZikaCluster.setTelefono2(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.telefono2)));
		mCasaZikaCluster.setGeoref(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.georef)));
		mCasaZikaCluster.setManzana(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.Manzana)));
		mCasaZikaCluster.setGeoref_razon(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.georef_razon)));
		mCasaZikaCluster.setGeoref_otraRazon(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.georef_otraRazon)));
		mCasaZikaCluster.setIdTamizaje(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.idTamizaje)));
		mCasaZikaCluster.setEncuesta(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.encuesta)).charAt(0));
		mCasaZikaCluster.setEncuestaEnt(cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.encuestaEnt)).charAt(0));
		Date fecha = new Date(cursorCasa.getLong(cursorCasa.getColumnIndex(ConstantsDB.TODAY)));
		Boolean borrado = cursorCasa.getInt(cursorCasa.getColumnIndex(ConstantsDB.DELETED))>0;
		mCasaZikaCluster.setMovilInfo(new MovilInfo(cursorCasa.getInt(cursorCasa.getColumnIndex(ConstantsDB.ID_INSTANCIA)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.FILE_PATH)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.STATUS)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.WHEN_UPDATED)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.START)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.END)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.DEVICE_ID)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.SIM_SERIAL)),
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.PHONE_NUMBER)),
				fecha,
				cursorCasa.getString(cursorCasa.getColumnIndex(ConstantsDB.USUARIO)),
				borrado,
				cursorCasa.getInt(cursorCasa.getColumnIndex(ConstantsDB.REC1)),
				cursorCasa.getInt(cursorCasa.getColumnIndex(ConstantsDB.REC2))));
		return mCasaZikaCluster;
	}
	
	
}
