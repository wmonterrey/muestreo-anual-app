package ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster;

import java.util.Date;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.SintomasZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;

import android.content.ContentValues;
import android.database.Cursor;

public class SintomasZikaClusterHelper {
	
	public static ContentValues crearSintomasZikaClusterContentValues(SintomasZikaCluster sintomas){
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.idSintoma, sintomas.getIdSintoma());
		cv.put(ConstantsDB.codigo, sintomas.getCodigo());
		if (sintomas.getFechaSint() != null) cv.put(ConstantsDB.fechaSint, sintomas.getFechaSint().getTime());
		cv.put(ConstantsDB.diaSint, sintomas.getDiaSint());
		cv.put(ConstantsDB.fiebre, sintomas.getFiebre());
		cv.put(ConstantsDB.astenia, sintomas.getAstenia());
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
	
	
	public static SintomasZikaCluster crearSintomasZikaCluster(Cursor cursorSintomas){
		SintomasZikaCluster mSintomasZikaCluster = new SintomasZikaCluster();
		mSintomasZikaCluster.setIdSintoma(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.idSintoma)));
		mSintomasZikaCluster.setCodigo(cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.codigo)));
		mSintomasZikaCluster.setFechaSint(new Date(cursorSintomas.getLong(cursorSintomas.getColumnIndex(ConstantsDB.fechaSint))));
		mSintomasZikaCluster.setDiaSint(cursorSintomas.getInt(cursorSintomas.getColumnIndex(ConstantsDB.diaSint)));
		mSintomasZikaCluster.setFiebre(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.fiebre)));
		mSintomasZikaCluster.setAstenia(cursorSintomas.getString(cursorSintomas.getColumnIndex(ConstantsDB.astenia)));
		
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
