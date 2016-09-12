package ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster;

import java.util.Date;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.TamizajeZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;

import android.content.ContentValues;
import android.database.Cursor;

public class TamizajeZikaClusterHelper {
	
	public static ContentValues crearTamizajeZikaClusterContentValues(TamizajeZikaCluster tamizaje){
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.idTamizaje, tamizaje.getIdTamizaje());
		if (tamizaje.getFechaTamizaje() != null) cv.put(ConstantsDB.fechaTamizaje, tamizaje.getFechaTamizaje().getTime());
		cv.put(ConstantsDB.genero, tamizaje.getGenero());
		cv.put(ConstantsDB.acepta_cons, tamizaje.getAcepta_cons());
		cv.put(ConstantsDB.porque_no, tamizaje.getPorque_no());
		cv.put(ConstantsDB.desc_porque_no, tamizaje.getDesc_porque_no());
		cv.put(ConstantsDB.incTrZ, tamizaje.getIncTrZ());
		cv.put(ConstantsDB.asentimiento, tamizaje.getAsentimiento());
		cv.put(ConstantsDB.alfabeto, tamizaje.getAlfabeto());
		cv.put(ConstantsDB.testigo, tamizaje.getTestigo());
		cv.put(ConstantsDB.nombretest1, tamizaje.getNombretest1());
		cv.put(ConstantsDB.nombretest2, tamizaje.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, tamizaje.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, tamizaje.getApellidotest2());
		cv.put(ConstantsDB.parteATrZ, tamizaje.getParteATrZ());
		cv.put(ConstantsDB.asentimientoesc, tamizaje.getAsentimientoesc());
		cv.put(ConstantsDB.parteBTrZ, tamizaje.getParteBTrZ());
		cv.put(ConstantsDB.parteCTrZ, tamizaje.getParteCTrZ());
		cv.put(ConstantsDB.porqueno, tamizaje.getPorqueno());
		cv.put(ConstantsDB.ID_INSTANCIA, tamizaje.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, tamizaje.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, tamizaje.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, tamizaje.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, tamizaje.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, tamizaje.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, tamizaje.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, tamizaje.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, tamizaje.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, tamizaje.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, tamizaje.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, tamizaje.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, tamizaje.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, tamizaje.getMovilInfo().getRecurso2());
		return cv; 
	}	
	
	
	public static TamizajeZikaCluster crearTamizajeZikaCluster(Cursor cursorTamizaje){
		
		TamizajeZikaCluster mTamizajeZikaCluster = new TamizajeZikaCluster();
		mTamizajeZikaCluster.setIdTamizaje(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.idTamizaje)));
		mTamizajeZikaCluster.setFechaTamizaje(new Date(cursorTamizaje.getLong(cursorTamizaje.getColumnIndex(ConstantsDB.fechaTamizaje))));
		mTamizajeZikaCluster.setGenero(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.genero)));
		mTamizajeZikaCluster.setAcepta_cons(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.acepta_cons)));
		mTamizajeZikaCluster.setPorque_no(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.porque_no)));
		mTamizajeZikaCluster.setDesc_porque_no(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.desc_porque_no)));
		mTamizajeZikaCluster.setIncTrZ(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.incTrZ)));
		mTamizajeZikaCluster.setAsentimiento(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.asentimiento)));
		mTamizajeZikaCluster.setAlfabeto(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.alfabeto)));
		mTamizajeZikaCluster.setTestigo(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.testigo)));
		mTamizajeZikaCluster.setNombretest1(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.nombretest1)));
		mTamizajeZikaCluster.setNombretest2(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.nombretest2)));
		mTamizajeZikaCluster.setApellidotest1(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.apellidotest1)));
		mTamizajeZikaCluster.setApellidotest2(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.apellidotest2)));
		mTamizajeZikaCluster.setParteATrZ(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.parteATrZ)));
		mTamizajeZikaCluster.setAsentimientoesc(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.asentimientoesc)));
		mTamizajeZikaCluster.setParteBTrZ(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.parteBTrZ)));
		mTamizajeZikaCluster.setParteCTrZ(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.parteCTrZ)));
		mTamizajeZikaCluster.setPorqueno(cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.porqueno)));
		Date fecha = new Date(cursorTamizaje.getLong(cursorTamizaje.getColumnIndex(ConstantsDB.TODAY)));
		Boolean borrado = cursorTamizaje.getInt(cursorTamizaje.getColumnIndex(ConstantsDB.DELETED))>0;
		mTamizajeZikaCluster.setMovilInfo(new MovilInfo(cursorTamizaje.getInt(cursorTamizaje.getColumnIndex(ConstantsDB.ID_INSTANCIA)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.FILE_PATH)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.STATUS)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.WHEN_UPDATED)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.START)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.END)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.DEVICE_ID)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.SIM_SERIAL)),
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.PHONE_NUMBER)),
				fecha,
				cursorTamizaje.getString(cursorTamizaje.getColumnIndex(ConstantsDB.USUARIO)),
				borrado,
				cursorTamizaje.getInt(cursorTamizaje.getColumnIndex(ConstantsDB.REC1)),
				cursorTamizaje.getInt(cursorTamizaje.getColumnIndex(ConstantsDB.REC2))));
		return mTamizajeZikaCluster;
	}
	
	
}
