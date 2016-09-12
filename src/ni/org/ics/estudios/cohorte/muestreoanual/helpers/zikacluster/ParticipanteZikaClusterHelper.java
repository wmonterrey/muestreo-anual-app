package ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster;

import java.util.Date;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;

import android.content.ContentValues;
import android.database.Cursor;

public class ParticipanteZikaClusterHelper {
	
	public static ContentValues crearParticipanteZikaClusterContentValues(ParticipanteZikaCluster participante){
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.codigo, participante.getCodigo());
		cv.put(ConstantsDB.codigo_indice, participante.getCodigo_indice());
		cv.put(ConstantsDB.codigo_casa, participante.getCodigo_casa());
		cv.put(ConstantsDB.indice, participante.getIndice());
		cv.put(ConstantsDB.cohorte, participante.getCohorte());
		if (participante.getFechana() != null) cv.put(ConstantsDB.fechana, participante.getFechana().getTime());
		cv.put(ConstantsDB.nombrept, participante.getNombrept());
		cv.put(ConstantsDB.nombrept2, participante.getNombrept2());
		cv.put(ConstantsDB.apellidopt, participante.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, participante.getApellidopt2());
		cv.put(ConstantsDB.nombrepadre, participante.getNombrepadre());
		cv.put(ConstantsDB.nombrepadre2, participante.getNombrepadre2());
		cv.put(ConstantsDB.apellidopadre, participante.getApellidopadre());
		cv.put(ConstantsDB.apellidopadre2, participante.getApellidopadre2());
		cv.put(ConstantsDB.nombremadre, participante.getNombremadre());
		cv.put(ConstantsDB.nombremadre2, participante.getNombremadre2());
		cv.put(ConstantsDB.apellidomadre, participante.getApellidomadre());
		cv.put(ConstantsDB.apellidomadre2, participante.getApellidomadre2());
		cv.put(ConstantsDB.nombre1, participante.getNombre1());
		cv.put(ConstantsDB.nombre2, participante.getNombre2());
		cv.put(ConstantsDB.apellido1, participante.getApellido1());
		cv.put(ConstantsDB.apellido2, participante.getApellido2());
		cv.put(ConstantsDB.dondesalud, participante.getDondesalud());
		cv.put(ConstantsDB.centrosalud, participante.getCentrosalud());
		cv.put(ConstantsDB.ocentrosalud, participante.getOcentrosalud());
		cv.put(ConstantsDB.puestosal, participante.getPuestosal());
		cv.put(ConstantsDB.otropuestosal, participante.getOtropuestosal());
		cv.put(ConstantsDB.solocssf, participante.getSolocssf());
		cv.put(ConstantsDB.idTamizaje, participante.getIdTamizaje());
		cv.put(ConstantsDB.encuesta, String.valueOf(participante.getEncuesta()));
		cv.put(ConstantsDB.sint1, String.valueOf(participante.getSint1()));
		cv.put(ConstantsDB.sint2, String.valueOf(participante.getSint2()));
		cv.put(ConstantsDB.sint3, String.valueOf(participante.getSint3()));
		cv.put(ConstantsDB.sint4, String.valueOf(participante.getSint4()));
		cv.put(ConstantsDB.sint5, String.valueOf(participante.getSint5()));
		cv.put(ConstantsDB.sint6, String.valueOf(participante.getSint6()));
		cv.put(ConstantsDB.sint7, String.valueOf(participante.getSint7()));
		cv.put(ConstantsDB.sint8, String.valueOf(participante.getSint8()));
		cv.put(ConstantsDB.sint9, String.valueOf(participante.getSint9()));
		cv.put(ConstantsDB.sint10, String.valueOf(participante.getSint10()));
		cv.put(ConstantsDB.sint11, String.valueOf(participante.getSint11()));
		cv.put(ConstantsDB.sint12, String.valueOf(participante.getSint12()));
		cv.put(ConstantsDB.sint13, String.valueOf(participante.getSint13()));
		cv.put(ConstantsDB.sint14, String.valueOf(participante.getSint14()));
		cv.put(ConstantsDB.sint15, String.valueOf(participante.getSint15()));
		cv.put(ConstantsDB.sint16, String.valueOf(participante.getSint16()));
		cv.put(ConstantsDB.sint17, String.valueOf(participante.getSint17()));
		cv.put(ConstantsDB.sint18, String.valueOf(participante.getSint18()));
		cv.put(ConstantsDB.sint19, String.valueOf(participante.getSint19()));
		cv.put(ConstantsDB.sint20, String.valueOf(participante.getSint20()));
		cv.put(ConstantsDB.sint21, String.valueOf(participante.getSint21()));
		cv.put(ConstantsDB.sint22, String.valueOf(participante.getSint22()));
		cv.put(ConstantsDB.sint23, String.valueOf(participante.getSint23()));
		cv.put(ConstantsDB.sint24, String.valueOf(participante.getSint24()));
		cv.put(ConstantsDB.sint25, String.valueOf(participante.getSint25()));
		cv.put(ConstantsDB.sint26, String.valueOf(participante.getSint26()));
		cv.put(ConstantsDB.sint27, String.valueOf(participante.getSint27()));
		cv.put(ConstantsDB.sint28, String.valueOf(participante.getSint28()));

		cv.put(ConstantsDB.ID_INSTANCIA, participante.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, participante.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, participante.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, participante.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, participante.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, participante.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, participante.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, participante.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, participante.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, participante.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, participante.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, participante.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, participante.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, participante.getMovilInfo().getRecurso2());
		return cv; 
	}	
	
	
	public static ParticipanteZikaCluster crearParticipanteZikaCluster(Cursor cursorParticipante){
		
		ParticipanteZikaCluster mParticipanteZikaCluster = new ParticipanteZikaCluster();
		mParticipanteZikaCluster.setCodigo(cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.codigo)));
		mParticipanteZikaCluster.setCodigo_indice(cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.codigo_indice)));
		mParticipanteZikaCluster.setCodigo_casa(cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.codigo_casa)));
		mParticipanteZikaCluster.setIndice(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.indice)));
		mParticipanteZikaCluster.setCohorte(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.cohorte)));
		mParticipanteZikaCluster.setFechana(new Date(cursorParticipante.getLong(cursorParticipante.getColumnIndex(ConstantsDB.fechana))));
		mParticipanteZikaCluster.setNombrept(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombrept)));
		mParticipanteZikaCluster.setNombrept2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombrept2)));
		mParticipanteZikaCluster.setApellidopt(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidopt)));
		mParticipanteZikaCluster.setApellidopt2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidopt2)));
		mParticipanteZikaCluster.setNombrepadre(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombrepadre)));
		mParticipanteZikaCluster.setNombrepadre2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombrepadre2)));
		mParticipanteZikaCluster.setApellidopadre(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidopadre)));
		mParticipanteZikaCluster.setApellidopadre2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidopadre2)));
		mParticipanteZikaCluster.setNombremadre(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombremadre)));
		mParticipanteZikaCluster.setNombremadre2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombremadre2)));
		mParticipanteZikaCluster.setApellidomadre(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidomadre)));
		mParticipanteZikaCluster.setApellidomadre2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellidomadre2)));
		mParticipanteZikaCluster.setNombre1(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombre1)));
		mParticipanteZikaCluster.setNombre2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.nombre2)));
		mParticipanteZikaCluster.setApellido1(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellido1)));
		mParticipanteZikaCluster.setApellido2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.apellido2)));
		mParticipanteZikaCluster.setDondesalud(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.dondesalud)));
		mParticipanteZikaCluster.setCentrosalud(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.centrosalud)));
		mParticipanteZikaCluster.setOcentrosalud(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.ocentrosalud)));
		mParticipanteZikaCluster.setPuestosal(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.puestosal)));
		mParticipanteZikaCluster.setOtropuestosal(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.otropuestosal)));
		mParticipanteZikaCluster.setSolocssf(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.solocssf)));
		mParticipanteZikaCluster.setIdTamizaje(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.idTamizaje)));
		mParticipanteZikaCluster.setEncuesta(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.encuesta)).charAt(0));
		mParticipanteZikaCluster.setSint1(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint1)).charAt(0));
		mParticipanteZikaCluster.setSint2(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint2)).charAt(0));
		mParticipanteZikaCluster.setSint3(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint3)).charAt(0));
		mParticipanteZikaCluster.setSint4(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint4)).charAt(0));
		mParticipanteZikaCluster.setSint5(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint5)).charAt(0));
		mParticipanteZikaCluster.setSint6(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint6)).charAt(0));
		mParticipanteZikaCluster.setSint7(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint7)).charAt(0));
		mParticipanteZikaCluster.setSint8(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint8)).charAt(0));
		mParticipanteZikaCluster.setSint9(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint9)).charAt(0));
		mParticipanteZikaCluster.setSint10(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint10)).charAt(0));
		mParticipanteZikaCluster.setSint11(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint11)).charAt(0));
		mParticipanteZikaCluster.setSint12(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint12)).charAt(0));
		mParticipanteZikaCluster.setSint13(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint13)).charAt(0));
		mParticipanteZikaCluster.setSint14(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint14)).charAt(0));
		mParticipanteZikaCluster.setSint15(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint15)).charAt(0));
		mParticipanteZikaCluster.setSint16(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint16)).charAt(0));
		mParticipanteZikaCluster.setSint17(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint17)).charAt(0));
		mParticipanteZikaCluster.setSint18(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint18)).charAt(0));
		mParticipanteZikaCluster.setSint19(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint19)).charAt(0));
		mParticipanteZikaCluster.setSint20(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint20)).charAt(0));
		mParticipanteZikaCluster.setSint21(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint21)).charAt(0));
		mParticipanteZikaCluster.setSint22(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint22)).charAt(0));
		mParticipanteZikaCluster.setSint23(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint23)).charAt(0));
		mParticipanteZikaCluster.setSint24(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint24)).charAt(0));
		mParticipanteZikaCluster.setSint25(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint25)).charAt(0));
		mParticipanteZikaCluster.setSint26(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint26)).charAt(0));
		mParticipanteZikaCluster.setSint27(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint27)).charAt(0));
		mParticipanteZikaCluster.setSint28(cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.sint28)).charAt(0));
		Date fecha = new Date(cursorParticipante.getLong(cursorParticipante.getColumnIndex(ConstantsDB.TODAY)));
		Boolean borrado = cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.DELETED))>0;
		mParticipanteZikaCluster.setMovilInfo(new MovilInfo(cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.ID_INSTANCIA)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.FILE_PATH)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.STATUS)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.WHEN_UPDATED)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.START)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.END)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.DEVICE_ID)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.SIM_SERIAL)),
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.PHONE_NUMBER)),
				fecha,
				cursorParticipante.getString(cursorParticipante.getColumnIndex(ConstantsDB.USUARIO)),
				borrado,
				cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.REC1)),
				cursorParticipante.getInt(cursorParticipante.getColumnIndex(ConstantsDB.REC2))));
		return mParticipanteZikaCluster;
	}
	
	
}
