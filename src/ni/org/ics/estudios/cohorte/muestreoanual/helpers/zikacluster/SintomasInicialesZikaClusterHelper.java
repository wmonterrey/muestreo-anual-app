package ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster;

import java.util.Date;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.SintomasInicialesZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;

import android.content.ContentValues;
import android.database.Cursor;

public class SintomasInicialesZikaClusterHelper {
	
	public static ContentValues crearSintomasInicialesZikaClusterContentValues(SintomasInicialesZikaCluster sintomas){
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.codigo, sintomas.getCodigo());
		if (sintomas.getFif() != null) cv.put(ConstantsDB.fif, sintomas.getFif().getTime());
		if (sintomas.getFis() != null) cv.put(ConstantsDB.fis, sintomas.getFis().getTime());
		cv.put(ConstantsDB.sintInicial1, sintomas.getSintInicial1());
		cv.put(ConstantsDB.sintInicial2, sintomas.getSintInicial2());
		cv.put(ConstantsDB.sintInicial3, sintomas.getSintInicial3());
		cv.put(ConstantsDB.sintInicial4, sintomas.getSintInicial4());
		cv.put(ConstantsDB.otrorecurso1, sintomas.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, sintomas.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, sintomas.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, sintomas.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, sintomas.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, sintomas.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, sintomas.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, sintomas.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, sintomas.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, sintomas.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, sintomas.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, sintomas.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, sintomas.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, sintomas.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, sintomas.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, sintomas.getMovilInfo().getRecurso2());
		return cv; 
	}	
	
	
	public static SintomasInicialesZikaCluster crearSintomasInicialesZikaCluster(Cursor cursorSintomas){
		SintomasInicialesZikaCluster mSintomasZikaCluster = new SintomasInicialesZikaCluster();
		
		mSintomasZikaCluster.setCodigo(cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.codigo)));
		if(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.fif)) >0) mSintomasZikaCluster.setFif(new Date(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.fif))));
		if(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.fis)) >0) mSintomasZikaCluster.setFis(new Date(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.fis))));
		mSintomasZikaCluster.setSintInicial1(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.sintInicial1)));
		mSintomasZikaCluster.setSintInicial2(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.sintInicial2)));
		mSintomasZikaCluster.setSintInicial3(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.sintInicial3)));
		mSintomasZikaCluster.setSintInicial4(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.sintInicial4)));
		mSintomasZikaCluster.setOtrorecurso1(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.otrorecurso1)));
		mSintomasZikaCluster.setOtrorecurso2(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.otrorecurso2)));
		
		Date fecha = new Date(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.TODAY)));
		Boolean borrado = cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.DELETED))>0;
		mSintomasZikaCluster.setMovilInfo(new MovilInfo(cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.ID_INSTANCIA)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.FILE_PATH)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.STATUS)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.WHEN_UPDATED)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.START)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.END)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.DEVICE_ID)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.SIM_SERIAL)),
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.PHONE_NUMBER)),
				fecha,
				cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.USUARIO)),
				borrado,
				cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.REC1)),
				cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.REC2))));
		return mSintomasZikaCluster;
	}
	
	
}
