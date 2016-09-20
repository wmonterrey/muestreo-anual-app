package ni.org.ics.estudios.cohorte.muestreoanual.database;

/**
 * Adaptador de la base de datos Cohorte
 * 
 * @author William Aviles
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Authority;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambiosCasas;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CodigosCasas;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoChik;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaSatisfaccion;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.LactanciaMaterna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Muestra;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Obsequio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.PesoyTalla;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Pinchazo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RazonNoData;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionBHC;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.RecepcionSero;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempPbmc;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhc;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Vacuna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.VisitaTerreno;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.SintomasZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster.TamizajeZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster.CasaZikaClusterHelper;
import ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster.ParticipanteZikaClusterHelper;
import ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster.SintomasZikaClusterHelper;
import ni.org.ics.estudios.cohorte.muestreoanual.helpers.zikacluster.TamizajeZikaClusterHelper;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.ConstantsDB;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.FileUtils;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class CohorteAdapter {

	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static class DatabaseHelper extends CohorteSQLiteOpenHelper {

		DatabaseHelper() {
			super(FileUtils.DATABASE_PATH, ConstantsDB.DATABASE_NAME, null, ConstantsDB.DATABASE_VERSION);
			createStorage();
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(ConstantsDB.CREATE_USER_TABLE);
			db.execSQL(ConstantsDB.CREATE_ROLE_TABLE);
			db.execSQL(ConstantsDB.CREATE_CASA_TABLE);
			db.execSQL(ConstantsDB.CREATE_PART_TABLE);
			db.execSQL(ConstantsDB.CREATE_ENCCASA_TABLE);
			db.execSQL(ConstantsDB.CREATE_ENCPART_TABLE);
			db.execSQL(ConstantsDB.CREATE_ENCLAC_TABLE);
			db.execSQL(ConstantsDB.CREATE_PT_TABLE);
			db.execSQL(ConstantsDB.CREATE_MUESTRA_TABLE);
			db.execSQL(ConstantsDB.CREATE_OB_TABLE);
			db.execSQL(ConstantsDB.CREATE_VAC_TABLE);
			db.execSQL(ConstantsDB.CREATE_VIS_TABLE);
			db.execSQL(ConstantsDB.CREATE_RECONS_TABLE);
			db.execSQL(ConstantsDB.CREATE_CONSCHIK_TABLE);
			db.execSQL(ConstantsDB.CREATE_CEST_TABLE);
			db.execSQL(ConstantsDB.CREATE_BHC_TABLE);
			db.execSQL(ConstantsDB.CREATE_SERO_TABLE);
			db.execSQL(ConstantsDB.CREATE_TPBMC_TABLE);
			db.execSQL(ConstantsDB.CREATE_TRB_TABLE);
			db.execSQL(ConstantsDB.CREATE_PIN_TABLE);
			db.execSQL(ConstantsDB.CREATE_RND_TABLE);
			db.execSQL(ConstantsDB.CREATE_ENCSAT_TABLE);
			db.execSQL(ConstantsDB.CREATE_RECONS_TABLE_2015);
			db.execSQL(ConstantsDB.CREATE_ZIKA_TABLE);
			db.execSQL(ConstantsDB.CREATE_RECONSFLU_TABLE_2015);
			db.execSQL(ConstantsDB.CREATE_CC_TABLE);
			db.execSQL(ConstantsDB.CREATE_CAMBCASA_TABLE);
			//ZIKA
			db.execSQL(ConstantsDB.CREATE_TAM_ZIKA_TABLE);
			db.execSQL(ConstantsDB.CREATE_CASA_ZIKA_TABLE);
			db.execSQL(ConstantsDB.CREATE_PART_ZIKA_TABLE);
			db.execSQL(ConstantsDB.CREATE_SINT_ZIKA_TABLE);
		}

		@Override
		// upgrading will destroy all old data
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.USER_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.ROLE_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.CASA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.PART_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.ENC_CASA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.ENC_PART_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.LACT_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.PT_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.MUESTRA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.OB_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.VAC_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.VIS_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.RECONS_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.CONSCHIK_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.CEST_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.BHC_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.SERO_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TPBMC_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TRB_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.PIN_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.NO_DATA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.ENC_SAT_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.RECONS_TABLE_2015);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.RECONSFLU_TABLE_2015);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.ZIKA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.COD_REL_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.CAMB_CASA_TABLE);
			//ZIKA CLUSTER
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.TAM_ZIKA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.CASA_ZIKA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.PART_ZIKA_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + ConstantsDB.SINT_ZIKA_TABLE);
			
			onCreate(db);
		}
	}

	public CohorteAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper();
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	public static boolean createStorage() {
		return FileUtils.createFolder(FileUtils.DATABASE_PATH);
	}
	
	/**METODOS PARA CASAS**/

	/**
	 * Inserta una casa en la base de datos
	 * 
	 * @param casa
	 *            Objeto Casa que contiene la informacion
	 *
	 */
	public void crearCasa(Casa casa) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, casa.getCodCasa());
		cv.put(ConstantsDB.BARRIO, casa.getBarrio());
		cv.put(ConstantsDB.DIRECCION, casa.getDireccion());
		cv.put(ConstantsDB.MANZANA, casa.getManzana());
		cv.put(ConstantsDB.COORD, casa.getCoordenadas());
		cv.put(ConstantsDB.LATITUD, casa.getLatitud());
		cv.put(ConstantsDB.LONGITUD, casa.getLongitud());
		cv.put(ConstantsDB.TEL_CASA, casa.getTelCasa());
		cv.put(ConstantsDB.NOM_JEFE, casa.getJefenom());
		cv.put(ConstantsDB.NOM_JEFE_2, casa.getJefenom2());
		cv.put(ConstantsDB.APE_JEFE, casa.getJefeap());
		cv.put(ConstantsDB.APE_JEFE_2, casa.getJefeap2());
		cv.put(ConstantsDB.TELEFONO1, casa.getTelefono1());
		cv.put(ConstantsDB.TELEFONO2, casa.getTelefono2());
		cv.put(ConstantsDB.NOMCONTACTO, casa.getNomContacto());
		cv.put(ConstantsDB.DIRCONTACTO, casa.getDireContacto());
		cv.put(ConstantsDB.BARRIOCONTACTO, casa.getBarrioContacto());
		cv.put(ConstantsDB.OBARRIOCONTACTO, casa.getOtrobarrioContacto());
		cv.put(ConstantsDB.TELCONTACTO1, casa.getTelContacto1());
		cv.put(ConstantsDB.TELCONTACTO2, casa.getTelContacto2());
		cv.put(ConstantsDB.VIVIENDA, casa.getVivienda());
		cv.put(ConstantsDB.RESD, casa.getResd());
		cv.put(ConstantsDB.INTEN, casa.getInten());
		cv.put(ConstantsDB.ENC_CASA, casa.getEnCasa());
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
		mDb.insert(ConstantsDB.CASA_TABLE, null, cv);
	}

	/**
	 * Borra todas las casas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasCasas() {
		return mDb.delete(ConstantsDB.CASA_TABLE, null, null) > 0;
	}
	
	/**
	 * Lista todos los participantes de la base de datos
	 * 
	 * @return dataset con participantes
	 */
	public Cursor obtenerTodosPuntos() throws SQLException {
		Cursor c = null; 
		final String MY_QUERY = "SELECT * FROM casas a INNER JOIN participantes b ON a.codCasa=b.codCasa WHERE a.latitud>0 and b.est_par=1 and b.conmx ='No'";
		
		c = mDb.rawQuery(MY_QUERY, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Busca una casa de la base de datos
	 * 
	 * @return casa
	 */	

	public Cursor buscarCasa(Integer cod_casa) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.CASA_TABLE, null,
				ConstantsDB.COD_CASA + "=" + cod_casa, null, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	/**
	 * Actualiza una casa en la base de datos.
	 * 
	 * @param casa
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaCasa(Casa casa) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, casa.getCodCasa());
		cv.put(ConstantsDB.BARRIO, casa.getBarrio());
		cv.put(ConstantsDB.DIRECCION, casa.getDireccion());
		cv.put(ConstantsDB.MANZANA, casa.getManzana());
		cv.put(ConstantsDB.COORD, casa.getCoordenadas());
		cv.put(ConstantsDB.LATITUD, casa.getLatitud());
		cv.put(ConstantsDB.LONGITUD, casa.getLongitud());
		cv.put(ConstantsDB.TEL_CASA, casa.getTelCasa());
		cv.put(ConstantsDB.NOM_JEFE, casa.getJefenom());
		cv.put(ConstantsDB.NOM_JEFE_2, casa.getJefenom2());
		cv.put(ConstantsDB.APE_JEFE, casa.getJefeap());
		cv.put(ConstantsDB.APE_JEFE_2, casa.getJefeap2());
		cv.put(ConstantsDB.TELEFONO1, casa.getTelefono1());
		cv.put(ConstantsDB.TELEFONO2, casa.getTelefono2());
		cv.put(ConstantsDB.NOMCONTACTO, casa.getNomContacto());
		cv.put(ConstantsDB.DIRCONTACTO, casa.getDireContacto());
		cv.put(ConstantsDB.BARRIOCONTACTO, casa.getBarrioContacto());
		cv.put(ConstantsDB.OBARRIOCONTACTO, casa.getOtrobarrioContacto());
		cv.put(ConstantsDB.TELCONTACTO1, casa.getTelContacto1());
		cv.put(ConstantsDB.TELCONTACTO2, casa.getTelContacto2());
		cv.put(ConstantsDB.VIVIENDA, casa.getVivienda());
		cv.put(ConstantsDB.RESD, casa.getResd());
		cv.put(ConstantsDB.INTEN, casa.getInten());
		cv.put(ConstantsDB.ENC_CASA, casa.getEnCasa());
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
		return mDb.update(ConstantsDB.CASA_TABLE, cv, ConstantsDB.COD_CASA + "='"
				+ casa.getCodCasa() + "'", null) > 0;
	}


	/**METODOS PARA PARTICIPANTES**/

	/**
	 * Inserta un participante en la base de datos
	 * 
	 * @param participante
	 *            Objeto Participante que contiene la informacion
	 *
	 */
	public void crearParticipante(Participante participante) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, participante.getCodCasa());
		cv.put(ConstantsDB.CODIGO, participante.getCodigo());
		cv.put(ConstantsDB.FECHA, participante.getFecha().getTime());
		cv.put(ConstantsDB.ESTADO_PAR, participante.getEstPart());
		cv.put(ConstantsDB.NOMBRE1, participante.getNombre1());
		cv.put(ConstantsDB.NOMBRE2, participante.getNombre2());
		cv.put(ConstantsDB.APELLIDO1, participante.getApellido1());
		cv.put(ConstantsDB.APELLIDO2, participante.getApellido2());
		cv.put(ConstantsDB.SEXO, participante.getSexo());
		cv.put(ConstantsDB.FECHANAC, participante.getFechaNac().getTime());
		cv.put(ConstantsDB.EDAD, participante.getEdad());
		cv.put(ConstantsDB.BARRIO_PART, participante.getBarrioFicha1());
		cv.put(ConstantsDB.BARRIO_DESC, participante.getBarrioDesc());
		cv.put(ConstantsDB.MANZANA_PART, participante.getManzFicha1());
		cv.put(ConstantsDB.DIRE_FICHA1, participante.getDirecFicha1());
		cv.put(ConstantsDB.LATITUD, participante.getLatitud());
		cv.put(ConstantsDB.LONGITUD, participante.getLongitud());
		cv.put(ConstantsDB.RECONSDENG, participante.getReConsDeng());
		cv.put(ConstantsDB.CONPTO, participante.getConPto());
		cv.put(ConstantsDB.NOMBREPT1, participante.getNombrePt1());
		cv.put(ConstantsDB.NOMBREPT2, participante.getNombrePt2());
		cv.put(ConstantsDB.APELLIDOPT1, participante.getApellidoPt1());
		cv.put(ConstantsDB.APELLIDOPT2, participante.getApellidoPt2());
		cv.put(ConstantsDB.RELFAMT, participante.getRelacionFam());
		cv.put(ConstantsDB.NOMPADRE, participante.getNombrePadre());
		cv.put(ConstantsDB.NOMMADRE, participante.getNombreMadre());
		cv.put(ConstantsDB.ASISTE, participante.getAsiste());
		cv.put(ConstantsDB.telefono, participante.getTelefono());
		cv.put(ConstantsDB.US, participante.getUs());
		cv.put(ConstantsDB.HIDENG, participante.getHiDeng());
		if (participante.getCuanDeng() != null){
			cv.put(ConstantsDB.CUANDEN, participante.getCuanDeng().getTime());
		}
		cv.put(ConstantsDB.HOSPDEN, participante.getHospDeng());
		if (participante.getCuanHospDeng() != null){
			cv.put(ConstantsDB.CUANHOSPDEN, participante.getCuanHospDeng().getTime());
		}
		cv.put(ConstantsDB.ESTUDIO, participante.getEstudio());
		cv.put(ConstantsDB.PBMC, participante.getPbmc());
		cv.put(ConstantsDB.CONSDENG, participante.getConsDeng());
		cv.put(ConstantsDB.ZIKA, participante.getZika());
		cv.put(ConstantsDB.ADN, participante.getAdn());
		cv.put(ConstantsDB.CONSFLU, participante.getConsFlu());
		cv.put(ConstantsDB.CONSCHIK, participante.getConsChik());
		cv.put(ConstantsDB.MUESTRA, participante.getConmx());
		cv.put(ConstantsDB.MUESTRABHC, participante.getConmxbhc());
		cv.put(ConstantsDB.LACT_MAT, participante.getEncLacMat());
		cv.put(ConstantsDB.PESOTALLA, participante.getPesoTalla());
		cv.put(ConstantsDB.ENC_PAR, participante.getEncPart());
		cv.put(ConstantsDB.ENC_CASA, participante.getEnCasa());
		cv.put(ConstantsDB.OBSEQUIO, participante.getObsequio());
		cv.put(ConstantsDB.CONVAL, participante.getConvalesciente());
		cv.put(ConstantsDB.INFOVAC, participante.getInfoVacuna());
		cv.put(ConstantsDB.PAXGENE, participante.getPaxgene());
		cv.put(ConstantsDB.RETOMA, participante.getRetoma());
		cv.put(ConstantsDB.VOLRETOMA, participante.getVolRetoma());
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
		mDb.insert(ConstantsDB.PART_TABLE, null, cv);
	}

	/**
	 * Borra todos los participantes de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosParticipantes() {
		return mDb.delete(ConstantsDB.PART_TABLE, null, null) > 0;
	}
	
	/**
	 * Busca un participante de la base de datos
	 * 
	 * @return participante
	 */	

	public Cursor buscarParticipante(Integer codigo) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.PART_TABLE, null,
				ConstantsDB.CODIGO + "=" + codigo, null, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	/**
	 * Actualiza un participante en la base de datos.
	 * 
	 * @param participante
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaParticipante(Participante participante) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, participante.getCodCasa());
		cv.put(ConstantsDB.CODIGO, participante.getCodigo());
		cv.put(ConstantsDB.FECHA, participante.getFecha().getTime());
		cv.put(ConstantsDB.ESTADO_PAR, participante.getEstPart());
		cv.put(ConstantsDB.NOMBRE1, participante.getNombre1());
		cv.put(ConstantsDB.NOMBRE2, participante.getNombre2());
		cv.put(ConstantsDB.APELLIDO1, participante.getApellido1());
		cv.put(ConstantsDB.APELLIDO2, participante.getApellido2());
		cv.put(ConstantsDB.SEXO, participante.getSexo());
		cv.put(ConstantsDB.FECHANAC, participante.getFechaNac().getTime());
		cv.put(ConstantsDB.BARRIO_PART, participante.getBarrioFicha1());
		cv.put(ConstantsDB.BARRIO_DESC, participante.getBarrioDesc());
		cv.put(ConstantsDB.MANZANA_PART, participante.getManzFicha1());		
		cv.put(ConstantsDB.DIRE_FICHA1, participante.getDirecFicha1());
		cv.put(ConstantsDB.LATITUD, participante.getLatitud());
		cv.put(ConstantsDB.LONGITUD, participante.getLongitud());
		cv.put(ConstantsDB.RECONSDENG, participante.getReConsDeng());
		cv.put(ConstantsDB.CONPTO, participante.getConPto());
		cv.put(ConstantsDB.EDAD, participante.getEdad());
		cv.put(ConstantsDB.NOMBREPT1, participante.getNombrePt1());
		cv.put(ConstantsDB.NOMBREPT2, participante.getNombrePt2());
		cv.put(ConstantsDB.APELLIDOPT1, participante.getApellidoPt1());
		cv.put(ConstantsDB.APELLIDOPT2, participante.getApellidoPt2());
		cv.put(ConstantsDB.RELFAMT, participante.getRelacionFam());
		cv.put(ConstantsDB.NOMPADRE, participante.getNombrePadre());
		cv.put(ConstantsDB.NOMMADRE, participante.getNombreMadre());
		cv.put(ConstantsDB.ASISTE, participante.getAsiste());
		cv.put(ConstantsDB.telefono, participante.getTelefono());
		cv.put(ConstantsDB.US, participante.getUs());
		cv.put(ConstantsDB.HIDENG, participante.getHiDeng());
		if (participante.getCuanDeng() != null){
			cv.put(ConstantsDB.CUANDEN, participante.getCuanDeng().getTime());
		}
		cv.put(ConstantsDB.HOSPDEN, participante.getHospDeng());
		if (participante.getCuanHospDeng() != null){
			cv.put(ConstantsDB.CUANHOSPDEN, participante.getCuanHospDeng().getTime());
		}
		cv.put(ConstantsDB.ESTUDIO, participante.getEstudio());
		cv.put(ConstantsDB.PBMC, participante.getPbmc());
		cv.put(ConstantsDB.CONSDENG, participante.getConsDeng());
		cv.put(ConstantsDB.ZIKA, participante.getZika());
		cv.put(ConstantsDB.ADN, participante.getAdn());
		cv.put(ConstantsDB.CONSFLU, participante.getConsFlu());
		cv.put(ConstantsDB.CONSCHIK, participante.getConsChik());
		cv.put(ConstantsDB.MUESTRA, participante.getConmx());
		cv.put(ConstantsDB.MUESTRABHC, participante.getConmxbhc());
		cv.put(ConstantsDB.LACT_MAT, participante.getEncLacMat());
		cv.put(ConstantsDB.PESOTALLA, participante.getPesoTalla());
		cv.put(ConstantsDB.ENC_PAR, participante.getEncPart());
		cv.put(ConstantsDB.ENC_CASA, participante.getEnCasa());
		cv.put(ConstantsDB.OBSEQUIO, participante.getObsequio());
		cv.put(ConstantsDB.CONVAL, participante.getConvalesciente());
		cv.put(ConstantsDB.INFOVAC, participante.getInfoVacuna());
		cv.put(ConstantsDB.PAXGENE, participante.getPaxgene());
		cv.put(ConstantsDB.RETOMA, participante.getRetoma());
		cv.put(ConstantsDB.VOLRETOMA, participante.getVolRetoma());
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
		return mDb.update(ConstantsDB.PART_TABLE, cv, ConstantsDB.CODIGO + "="
				+ participante.getCodigo(), null) > 0;
	}
	
	
	/**METODOS PARA ENCUESTAS CASA**/

	/**
	 * Inserta una encuesta de casa en la base de datos
	 * 
	 * @param encuesta casa
	 *            Objeto EncuestaCasa que contiene la informacion
	 *
	 */
	public void crearEncuestaCasa(EncuestaCasa enccasa) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, enccasa.getEncCasaId().getCodCasa());
		cv.put(ConstantsDB.FECHA_ENC_CASA, enccasa.getEncCasaId().getFechaEncCasa().getTime());
		cv.put(ConstantsDB.CVIVEN1, enccasa.getCvivencasa1());
		cv.put(ConstantsDB.CVIVEN2, enccasa.getCvivencasa2());
		cv.put(ConstantsDB.CVIVEN3, enccasa.getCvivencasa3());
		cv.put(ConstantsDB.CVIVEN4, enccasa.getCvivencasa4());
		cv.put(ConstantsDB.CVIVEN5, enccasa.getCvivencasa5());
		cv.put(ConstantsDB.CVIVEN6, enccasa.getCvivencasa6());
		cv.put(ConstantsDB.CCUARTOS, enccasa.getCcuartos());
		cv.put(ConstantsDB.GRIFO, enccasa.getGrifo());
		cv.put(ConstantsDB.GRIFOCOM, enccasa.getGrifoComSN());
		cv.put(ConstantsDB.HORASAGUA, enccasa.gethorasagua());
		cv.put(ConstantsDB.MCASA, enccasa.getMcasa());
		cv.put(ConstantsDB.OCASA, enccasa.getOcasa());
		cv.put(ConstantsDB.PISO, enccasa.getPiso());
		cv.put(ConstantsDB.OPISO, enccasa.getOpiso());
		cv.put(ConstantsDB.TECHO, enccasa.getTecho());
		cv.put(ConstantsDB.OTECHO, enccasa.getOtecho());
		cv.put(ConstantsDB.CPROPIA, enccasa.getCpropia());
		cv.put(ConstantsDB.ABANICOS, enccasa.getCabanicos());
		cv.put(ConstantsDB.TVS, enccasa.getCtelevisores());
		cv.put(ConstantsDB.REFRI, enccasa.getCrefrigeradores());
		cv.put(ConstantsDB.MOTO, enccasa.getMoto());
		cv.put(ConstantsDB.CARRO, enccasa.getCarro());
		cv.put(ConstantsDB.LENA, enccasa.getCocinalena());
		cv.put(ConstantsDB.ANIMALES, enccasa.getAnimalesSN());
		cv.put(ConstantsDB.POLLOS, enccasa.getPollos());
		cv.put(ConstantsDB.POLLOSCASA, enccasa.getPolloscasa());
		cv.put(ConstantsDB.PATOS, enccasa.getPatos());
		cv.put(ConstantsDB.PATOSCASA, enccasa.getPatoscasa());
		cv.put(ConstantsDB.PERROS, enccasa.getPerros());
		cv.put(ConstantsDB.PERROSCASA, enccasa.getPerroscasa());
		cv.put(ConstantsDB.GATOS, enccasa.getGatos());
		cv.put(ConstantsDB.GATOSCASA, enccasa.getGatoscasa());
		cv.put(ConstantsDB.CERDOS, enccasa.getCerdos());
		cv.put(ConstantsDB.CERDOSCASA, enccasa.getCerdoscasa());		
		cv.put(ConstantsDB.ID_INSTANCIA, enccasa.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, enccasa.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, enccasa.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, enccasa.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, enccasa.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, enccasa.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, enccasa.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, enccasa.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, enccasa.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, enccasa.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, enccasa.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, enccasa.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, enccasa.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, enccasa.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.ENC_CASA_TABLE, null, cv);
	}

	/**
	 * Borra todas las encuestas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasEncCasas() {
		return mDb.delete(ConstantsDB.ENC_CASA_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una encuesta en la base de datos.
	 * 
	 * @param enccasa
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaEncCasa(EncuestaCasa enccasa) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.COD_CASA, enccasa.getEncCasaId().getCodCasa());
		cv.put(ConstantsDB.FECHA_ENC_CASA, enccasa.getEncCasaId().getFechaEncCasa().getTime());
		cv.put(ConstantsDB.CVIVEN1, enccasa.getCvivencasa1());
		cv.put(ConstantsDB.CVIVEN2, enccasa.getCvivencasa2());
		cv.put(ConstantsDB.CVIVEN3, enccasa.getCvivencasa3());
		cv.put(ConstantsDB.CVIVEN4, enccasa.getCvivencasa4());
		cv.put(ConstantsDB.CVIVEN5, enccasa.getCvivencasa5());
		cv.put(ConstantsDB.CVIVEN6, enccasa.getCvivencasa6());
		cv.put(ConstantsDB.CCUARTOS, enccasa.getCcuartos());
		cv.put(ConstantsDB.GRIFO, enccasa.getGrifo());
		cv.put(ConstantsDB.GRIFOCOM, enccasa.getGrifoComSN());
		cv.put(ConstantsDB.HORASAGUA, enccasa.gethorasagua());
		cv.put(ConstantsDB.MCASA, enccasa.getMcasa());
		cv.put(ConstantsDB.OCASA, enccasa.getOcasa());
		cv.put(ConstantsDB.PISO, enccasa.getPiso());
		cv.put(ConstantsDB.OPISO, enccasa.getOpiso());
		cv.put(ConstantsDB.TECHO, enccasa.getTecho());
		cv.put(ConstantsDB.OTECHO, enccasa.getOtecho());
		cv.put(ConstantsDB.CPROPIA, enccasa.getCpropia());
		cv.put(ConstantsDB.ABANICOS, enccasa.getCabanicos());
		cv.put(ConstantsDB.TVS, enccasa.getCtelevisores());
		cv.put(ConstantsDB.REFRI, enccasa.getCrefrigeradores());
		cv.put(ConstantsDB.MOTO, enccasa.getMoto());
		cv.put(ConstantsDB.CARRO, enccasa.getCarro());
		cv.put(ConstantsDB.LENA, enccasa.getCocinalena());
		cv.put(ConstantsDB.ANIMALES, enccasa.getAnimalesSN());
		cv.put(ConstantsDB.POLLOS, enccasa.getPollos());
		cv.put(ConstantsDB.POLLOSCASA, enccasa.getPolloscasa());
		cv.put(ConstantsDB.PATOS, enccasa.getPatos());
		cv.put(ConstantsDB.PATOSCASA, enccasa.getPatoscasa());
		cv.put(ConstantsDB.PERROS, enccasa.getPerros());
		cv.put(ConstantsDB.PERROSCASA, enccasa.getPerroscasa());
		cv.put(ConstantsDB.GATOS, enccasa.getGatos());
		cv.put(ConstantsDB.GATOSCASA, enccasa.getGatoscasa());
		cv.put(ConstantsDB.CERDOS, enccasa.getCerdos());
		cv.put(ConstantsDB.CERDOSCASA, enccasa.getCerdoscasa());		
		cv.put(ConstantsDB.ID_INSTANCIA, enccasa.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, enccasa.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, enccasa.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, enccasa.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, enccasa.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, enccasa.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, enccasa.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, enccasa.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, enccasa.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, enccasa.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, enccasa.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, enccasa.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, enccasa.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, enccasa.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.ENC_CASA_TABLE, cv, ConstantsDB.COD_CASA + "="
				+ enccasa.getEncCasaId().getCodCasa() + " and " + ConstantsDB.FECHA_ENC_CASA + "="
				+ enccasa.getEncCasaId().getFechaEncCasa().getTime(), null) > 0;
	}
	
	/**METODOS PARA ENCUESTAS PARTICIPANTES**/

	/**
	 * Inserta una encuesta de participante en la base de datos
	 * 
	 * @param encuesta participante
	 *            Objeto EncuestaParticipante que contiene la informacion
	 *
	 */
	public void crearEncuestaParticipante(EncuestaParticipante encpar) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, encpar.getEpId().getCodigo());
		cv.put(ConstantsDB.FECHA_ENC_PAR, encpar.getEpId().getFechaEncPar().getTime());
		cv.put(ConstantsDB.FIEBRE, encpar.getFiebre());
		cv.put(ConstantsDB.TFIEBRE, encpar.getTiemFieb());
		cv.put(ConstantsDB.LUGCONS, encpar.getLugarCons());
		cv.put(ConstantsDB.NOCS, encpar.getNoCs());
		cv.put(ConstantsDB.AUTOMED, encpar.getAutomed());
		cv.put(ConstantsDB.ESC, encpar.getEscuela());
		cv.put(ConstantsDB.GRADO, encpar.getGrado());
		cv.put(ConstantsDB.TURNO, encpar.getTurno());
		cv.put(ConstantsDB.NESC, encpar.getnEscuela());
		cv.put(ConstantsDB.OESC, encpar.getOtraEscuela());
		cv.put(ConstantsDB.CUIDAN, encpar.getCuidan());
		cv.put(ConstantsDB.CCUIDAN, encpar.getCuantosCuidan());
		cv.put(ConstantsDB.CQVIVE, encpar.getCqVive());
		cv.put(ConstantsDB.LUGPARTO, encpar.getLugarPart());
		cv.put(ConstantsDB.PAPAALF, encpar.getPapaAlf());
		cv.put(ConstantsDB.PAPANIVEL, encpar.getPapaNivel());
		cv.put(ConstantsDB.PAPATRA, encpar.getPapaTra());
		cv.put(ConstantsDB.PAPATIPOT, encpar.getPapaTipoTra());
		cv.put(ConstantsDB.MAMAALF, encpar.getMamaAlf());
		cv.put(ConstantsDB.MAMANIVEL, encpar.getMamaNivel());
		cv.put(ConstantsDB.MAMATRA, encpar.getMamaTra());
		cv.put(ConstantsDB.MAMATIPOT, encpar.getMamaTipoTra());
		cv.put(ConstantsDB.COMPARTEHAB, encpar.getComparteHab());
		cv.put(ConstantsDB.HAB1, encpar.getHab1());
		cv.put(ConstantsDB.HAB2, encpar.getHab2());
		cv.put(ConstantsDB.HAB3, encpar.getHab3());
		cv.put(ConstantsDB.HAB4, encpar.getHab4());
		cv.put(ConstantsDB.HAB5, encpar.getHab5());
		cv.put(ConstantsDB.HAB6, encpar.getHab6());
		cv.put(ConstantsDB.COMPARTECAMA, encpar.getComparteCama());
		cv.put(ConstantsDB.CAMA1, encpar.getCama1());
		cv.put(ConstantsDB.CAMA2, encpar.getCama2());
		cv.put(ConstantsDB.CAMA3, encpar.getCama3());
		cv.put(ConstantsDB.CAMA4, encpar.getCama4());
		cv.put(ConstantsDB.CAMA5, encpar.getCama5());
		cv.put(ConstantsDB.CAMA6, encpar.getCama6());
		cv.put(ConstantsDB.ASMA, encpar.getAsma());
		cv.put(ConstantsDB.SILB12, encpar.getSilb12m());
		cv.put(ConstantsDB.SIT1, encpar.getSitResf());
		cv.put(ConstantsDB.SIT2, encpar.getSitEjer());
		cv.put(ConstantsDB.SILB01, encpar.getSilbMesPas());
		cv.put(ConstantsDB.DIFHAB, encpar.getDifHablar());
		cv.put(ConstantsDB.VECDIFHAB, encpar.getVecHablar());
		cv.put(ConstantsDB.DIFDOR, encpar.getDifDormir());
		cv.put(ConstantsDB.SUENOPER, encpar.getSuenoPer());
		cv.put(ConstantsDB.TOS12, encpar.getTos12m());
		cv.put(ConstantsDB.VECESTOS, encpar.getVecesTos());
		cv.put(ConstantsDB.TOS3DIAS, encpar.getTos3Dias());
		cv.put(ConstantsDB.HOSP12M, encpar.getHosp12m());
		cv.put(ConstantsDB.MED12M, encpar.getMed12m());
		cv.put(ConstantsDB.DEP12M, encpar.getDep12m());
		cv.put(ConstantsDB.CRISIS, encpar.getCrisis());
		cv.put(ConstantsDB.FRECASMA, encpar.getFrecAsma());
		cv.put(ConstantsDB.FUMA, encpar.getFumaSN());
		cv.put(ConstantsDB.QUIENFUMA, encpar.getQuienFuma());
		cv.put(ConstantsDB.CIGMADRE, encpar.getCantCigarrosMadre());
		cv.put(ConstantsDB.CIGOTRO, encpar.getCantCigarrosOtros());
		cv.put(ConstantsDB.CIGPADRE, encpar.getCantCigarrosPadre());
		
		cv.put(ConstantsDB.rash, encpar.getRash());
		cv.put(ConstantsDB.mesActual, encpar.getMesActual());
		cv.put(ConstantsDB.yearActual, encpar.getYearActual());
		cv.put(ConstantsDB.rash_year, encpar.getRash_year());
		cv.put(ConstantsDB.rash_mes, encpar.getRash_mes());
		cv.put(ConstantsDB.rash_mesact, encpar.getRash_mesact());
		cv.put(ConstantsDB.rashCara, encpar.getRashCara());
		cv.put(ConstantsDB.rashMiembrosSup, encpar.getRashMiembrosSup());
		cv.put(ConstantsDB.rashTorax, encpar.getRashTorax());
		cv.put(ConstantsDB.rashAbdomen, encpar.getRashAbdomen());
		cv.put(ConstantsDB.rashMiembrosInf, encpar.getRashMiembrosInf());
		cv.put(ConstantsDB.rashDias, encpar.getRashDias());
		cv.put(ConstantsDB.ojoRojo, encpar.getOjoRojo());
		cv.put(ConstantsDB.ojoRojo_year, encpar.getOjoRojo_year());
		cv.put(ConstantsDB.ojoRojo_mes, encpar.getOjoRojo_mes());
		cv.put(ConstantsDB.ojoRojo_mesact, encpar.getOjoRojo_mesact());
		cv.put(ConstantsDB.ojoRojo_Dias, encpar.getOjoRojo_Dias());
		cv.put(ConstantsDB.hormigueo, encpar.getHormigueo());
		cv.put(ConstantsDB.hormigueo_year, encpar.getHormigueo_year());
		cv.put(ConstantsDB.hormigueo_mes, encpar.getHormigueo_mes());
		cv.put(ConstantsDB.hormigueo_mesact, encpar.getHormigueo_mesact());
		cv.put(ConstantsDB.hormigueo_Dias, encpar.getHormigueo_Dias());
		cv.put(ConstantsDB.consultaRashHormigueo, encpar.getConsultaRashHormigueo());
		cv.put(ConstantsDB.uSaludRashHormigueo, encpar.getuSaludRashHormigueo());
		cv.put(ConstantsDB.cSaludRashHormigueo, encpar.getcSaludRashHormigueo());
		cv.put(ConstantsDB.oCSRashHormigueo, encpar.getoCSRashHormigueo());
		cv.put(ConstantsDB.pSRashHormigueo, encpar.getpSRashHormigueo());
		cv.put(ConstantsDB.oPSRashHormigueo, encpar.getoPSRashHormigueo());
		cv.put(ConstantsDB.diagRashHormigueo, encpar.getDiagRashHormigueo());
		cv.put(ConstantsDB.chPapaMama, encpar.getChPapaMama());
		if (encpar.getFechana_papa() != null){
			cv.put(ConstantsDB.fechana_papa, encpar.getFechana_papa().getTime());
		}
		cv.put(ConstantsDB.cal_edad_papa, encpar.getCal_edad_papa());
		cv.put(ConstantsDB.cal_edad2_papa, encpar.getCal_edad2_papa());
		cv.put(ConstantsDB.nombpapa1, encpar.getNombpapa1());
		cv.put(ConstantsDB.nombpapa2, encpar.getNombpapa2());
		cv.put(ConstantsDB.apellipapa1, encpar.getApellipapa1());
		cv.put(ConstantsDB.apellipapa2, encpar.getApellipapa2());
		if (encpar.getFechana_mama() != null){
			cv.put(ConstantsDB.fechana_mama, encpar.getFechana_mama().getTime());
		}
		cv.put(ConstantsDB.cal_edad_mama, encpar.getCal_edad_mama());
		cv.put(ConstantsDB.cal_edad2_mama, encpar.getCal_edad2_mama());
		cv.put(ConstantsDB.nombmama1, encpar.getNombmama1());
		cv.put(ConstantsDB.nombmama2, encpar.getNombmama2());
		cv.put(ConstantsDB.apellimama1, encpar.getApellimama1());
		cv.put(ConstantsDB.apellimama2, encpar.getApellimama2());
		
		cv.put(ConstantsDB.ID_INSTANCIA, encpar.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, encpar.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, encpar.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, encpar.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, encpar.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, encpar.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, encpar.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, encpar.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, encpar.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, encpar.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, encpar.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, encpar.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, encpar.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, encpar.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.ENC_PART_TABLE, null, cv);
	}

	/**
	 * Borra todas las encuestas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasEncParticipantes() {
		return mDb.delete(ConstantsDB.ENC_PART_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una encuesta en la base de datos.
	 * 
	 * @param encpar
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaEncParticipante(EncuestaParticipante encpar) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, encpar.getEpId().getCodigo());
		cv.put(ConstantsDB.FECHA_ENC_PAR, encpar.getEpId().getFechaEncPar().getTime());
		cv.put(ConstantsDB.FIEBRE, encpar.getFiebre());
		cv.put(ConstantsDB.TFIEBRE, encpar.getTiemFieb());
		cv.put(ConstantsDB.LUGCONS, encpar.getLugarCons());
		cv.put(ConstantsDB.NOCS, encpar.getNoCs());
		cv.put(ConstantsDB.AUTOMED, encpar.getAutomed());
		cv.put(ConstantsDB.ESC, encpar.getEscuela());
		cv.put(ConstantsDB.GRADO, encpar.getGrado());
		cv.put(ConstantsDB.TURNO, encpar.getTurno());
		cv.put(ConstantsDB.NESC, encpar.getnEscuela());
		cv.put(ConstantsDB.OESC, encpar.getOtraEscuela());
		cv.put(ConstantsDB.CUIDAN, encpar.getCuidan());
		cv.put(ConstantsDB.CCUIDAN, encpar.getCuantosCuidan());
		cv.put(ConstantsDB.CQVIVE, encpar.getCqVive());
		cv.put(ConstantsDB.LUGPARTO, encpar.getLugarPart());
		cv.put(ConstantsDB.PAPAALF, encpar.getPapaAlf());
		cv.put(ConstantsDB.PAPANIVEL, encpar.getPapaNivel());
		cv.put(ConstantsDB.PAPATRA, encpar.getPapaTra());
		cv.put(ConstantsDB.PAPATIPOT, encpar.getPapaTipoTra());
		cv.put(ConstantsDB.MAMAALF, encpar.getMamaAlf());
		cv.put(ConstantsDB.MAMANIVEL, encpar.getMamaNivel());
		cv.put(ConstantsDB.MAMATRA, encpar.getMamaTra());
		cv.put(ConstantsDB.MAMATIPOT, encpar.getMamaTipoTra());
		cv.put(ConstantsDB.COMPARTEHAB, encpar.getComparteHab());
		cv.put(ConstantsDB.HAB1, encpar.getHab1());
		cv.put(ConstantsDB.HAB2, encpar.getHab2());
		cv.put(ConstantsDB.HAB3, encpar.getHab3());
		cv.put(ConstantsDB.HAB4, encpar.getHab4());
		cv.put(ConstantsDB.HAB5, encpar.getHab5());
		cv.put(ConstantsDB.HAB6, encpar.getHab6());
		cv.put(ConstantsDB.COMPARTECAMA, encpar.getComparteCama());
		cv.put(ConstantsDB.CAMA1, encpar.getCama1());
		cv.put(ConstantsDB.CAMA2, encpar.getCama2());
		cv.put(ConstantsDB.CAMA3, encpar.getCama3());
		cv.put(ConstantsDB.CAMA4, encpar.getCama4());
		cv.put(ConstantsDB.CAMA5, encpar.getCama5());
		cv.put(ConstantsDB.CAMA6, encpar.getCama6());
		cv.put(ConstantsDB.ASMA, encpar.getAsma());
		cv.put(ConstantsDB.SILB12, encpar.getSilb12m());
		cv.put(ConstantsDB.SIT1, encpar.getSitResf());
		cv.put(ConstantsDB.SIT2, encpar.getSitEjer());
		cv.put(ConstantsDB.SILB01, encpar.getSilbMesPas());
		cv.put(ConstantsDB.DIFHAB, encpar.getDifHablar());
		cv.put(ConstantsDB.VECDIFHAB, encpar.getVecHablar());
		cv.put(ConstantsDB.DIFDOR, encpar.getDifDormir());
		cv.put(ConstantsDB.SUENOPER, encpar.getSuenoPer());
		cv.put(ConstantsDB.TOS12, encpar.getTos12m());
		cv.put(ConstantsDB.VECESTOS, encpar.getVecesTos());
		cv.put(ConstantsDB.TOS3DIAS, encpar.getTos3Dias());
		cv.put(ConstantsDB.HOSP12M, encpar.getHosp12m());
		cv.put(ConstantsDB.MED12M, encpar.getMed12m());
		cv.put(ConstantsDB.DEP12M, encpar.getDep12m());
		cv.put(ConstantsDB.CRISIS, encpar.getCrisis());
		cv.put(ConstantsDB.FRECASMA, encpar.getFrecAsma());
		cv.put(ConstantsDB.FUMA, encpar.getFumaSN());
		cv.put(ConstantsDB.QUIENFUMA, encpar.getQuienFuma());
		cv.put(ConstantsDB.CIGMADRE, encpar.getCantCigarrosMadre());
		cv.put(ConstantsDB.CIGOTRO, encpar.getCantCigarrosOtros());
		cv.put(ConstantsDB.CIGPADRE, encpar.getCantCigarrosPadre());
		
		cv.put(ConstantsDB.rash, encpar.getRash());
		cv.put(ConstantsDB.mesActual, encpar.getMesActual());
		cv.put(ConstantsDB.yearActual, encpar.getYearActual());
		cv.put(ConstantsDB.rash_year, encpar.getRash_year());
		cv.put(ConstantsDB.rash_mes, encpar.getRash_mes());
		cv.put(ConstantsDB.rash_mesact, encpar.getRash_mesact());
		cv.put(ConstantsDB.rashCara, encpar.getRashCara());
		cv.put(ConstantsDB.rashMiembrosSup, encpar.getRashMiembrosSup());
		cv.put(ConstantsDB.rashTorax, encpar.getRashTorax());
		cv.put(ConstantsDB.rashAbdomen, encpar.getRashAbdomen());
		cv.put(ConstantsDB.rashMiembrosInf, encpar.getRashMiembrosInf());
		cv.put(ConstantsDB.rashDias, encpar.getRashDias());
		cv.put(ConstantsDB.ojoRojo, encpar.getOjoRojo());
		cv.put(ConstantsDB.ojoRojo_year, encpar.getOjoRojo_year());
		cv.put(ConstantsDB.ojoRojo_mes, encpar.getOjoRojo_mes());
		cv.put(ConstantsDB.ojoRojo_mesact, encpar.getOjoRojo_mesact());
		cv.put(ConstantsDB.ojoRojo_Dias, encpar.getOjoRojo_Dias());
		cv.put(ConstantsDB.hormigueo, encpar.getHormigueo());
		cv.put(ConstantsDB.hormigueo_year, encpar.getHormigueo_year());
		cv.put(ConstantsDB.hormigueo_mes, encpar.getHormigueo_mes());
		cv.put(ConstantsDB.hormigueo_mesact, encpar.getHormigueo_mesact());
		cv.put(ConstantsDB.hormigueo_Dias, encpar.getHormigueo_Dias());
		cv.put(ConstantsDB.consultaRashHormigueo, encpar.getConsultaRashHormigueo());
		cv.put(ConstantsDB.uSaludRashHormigueo, encpar.getuSaludRashHormigueo());
		cv.put(ConstantsDB.cSaludRashHormigueo, encpar.getcSaludRashHormigueo());
		cv.put(ConstantsDB.oCSRashHormigueo, encpar.getoCSRashHormigueo());
		cv.put(ConstantsDB.pSRashHormigueo, encpar.getpSRashHormigueo());
		cv.put(ConstantsDB.oPSRashHormigueo, encpar.getoPSRashHormigueo());
		cv.put(ConstantsDB.diagRashHormigueo, encpar.getDiagRashHormigueo());
		cv.put(ConstantsDB.chPapaMama, encpar.getChPapaMama());
		if (encpar.getFechana_papa() != null){
			cv.put(ConstantsDB.fechana_papa, encpar.getFechana_papa().getTime());
		}
		cv.put(ConstantsDB.cal_edad_papa, encpar.getCal_edad_papa());
		cv.put(ConstantsDB.cal_edad2_papa, encpar.getCal_edad2_papa());
		cv.put(ConstantsDB.nombpapa1, encpar.getNombpapa1());
		cv.put(ConstantsDB.nombpapa2, encpar.getNombpapa2());
		cv.put(ConstantsDB.apellipapa1, encpar.getApellipapa1());
		cv.put(ConstantsDB.apellipapa2, encpar.getApellipapa2());
		if (encpar.getFechana_mama() != null){
			cv.put(ConstantsDB.fechana_mama, encpar.getFechana_mama().getTime());
		}
		cv.put(ConstantsDB.cal_edad_mama, encpar.getCal_edad_mama());
		cv.put(ConstantsDB.cal_edad2_mama, encpar.getCal_edad2_mama());
		cv.put(ConstantsDB.nombmama1, encpar.getNombmama1());
		cv.put(ConstantsDB.nombmama2, encpar.getNombmama2());
		cv.put(ConstantsDB.apellimama1, encpar.getApellimama1());
		cv.put(ConstantsDB.apellimama2, encpar.getApellimama2());
	
		
		cv.put(ConstantsDB.ID_INSTANCIA, encpar.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, encpar.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, encpar.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, encpar.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, encpar.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, encpar.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, encpar.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, encpar.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, encpar.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, encpar.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, encpar.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, encpar.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, encpar.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, encpar.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.ENC_PART_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ encpar.getEpId().getCodigo() + " and " +ConstantsDB.FECHA_ENC_PAR + "="
				+ encpar.getEpId().getFechaEncPar().getTime(), null) > 0;
	}
	
	/**METODOS PARA ENCUESTAS LACTANCIA**/

	/**
	 * Inserta una encuesta de lactancia en la base de datos
	 * 
	 * @param encuesta lactancia
	 *            Objeto LactanciaMaterna que contiene la informacion
	 *
	 */
	public void crearLactanciaMaterna(LactanciaMaterna enclac) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, enclac.getLmId().getCodigo());
		cv.put(ConstantsDB.FECHA_ENC_LACT, enclac.getLmId().getFechaEncLM().getTime());
		cv.put(ConstantsDB.EDAD, enclac.getEdad());
		cv.put(ConstantsDB.DIOPECHO, enclac.getDioPecho());
		cv.put(ConstantsDB.TIEMPECHO, enclac.getTiemPecho());
		cv.put(ConstantsDB.MESDIOPECHO, enclac.getMesDioPecho());
		cv.put(ConstantsDB.PECHOEXC, enclac.getPechoExc());
		cv.put(ConstantsDB.PECHOEXCANT, enclac.getPechoExcAntes());
		cv.put(ConstantsDB.TPECHOEXCANT, enclac.getTiempPechoExcAntes());
		cv.put(ConstantsDB.MPECHOEXCANT, enclac.getMestPechoExc());
		cv.put(ConstantsDB.FORMALIM, enclac.getFormAlim());
		cv.put(ConstantsDB.OTRALIM, enclac.getOtraAlim());
		cv.put(ConstantsDB.EDADLIQDP, enclac.getEdadLiqDistPecho());
		cv.put(ConstantsDB.MESLIQDL, enclac.getMesDioLiqDisLeche());
		cv.put(ConstantsDB.EDADLIQDL, enclac.getEdadLiqDistLeche());
		cv.put(ConstantsDB.MESLIQDP, enclac.getMesDioLiqDisPecho());
		cv.put(ConstantsDB.EDADALIMS, enclac.getEdAlimSolidos());
		cv.put(ConstantsDB.MESALIMS, enclac.getMesDioAlimSol());
		cv.put(ConstantsDB.ID_INSTANCIA, enclac.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, enclac.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, enclac.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, enclac.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, enclac.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, enclac.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, enclac.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, enclac.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, enclac.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, enclac.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, enclac.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, enclac.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, enclac.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, enclac.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.LACT_TABLE, null, cv);
	}

	/**
	 * Borra todas las encuestas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasLactanciaMaterna() {
		return mDb.delete(ConstantsDB.LACT_TABLE, null, null) > 0;
	}
	
	/**
	 * Lista todas las encuestas de lactancia de la base de datos
	 * 
	 * @return dataset con encuestas
	 */
	public Cursor obtenerTodasLactanciaMaterna(Integer codigo) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.LACT_TABLE, null,
				ConstantsDB.CODIGO + "=" + codigo, null, null, null, ConstantsDB.TODAY, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	/**
	 * Actualiza una encuesta en la base de datos.
	 * 
	 * @param enclac
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaLactanciaMaterna(LactanciaMaterna enclac) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, enclac.getLmId().getCodigo());
		cv.put(ConstantsDB.FECHA_ENC_LACT, enclac.getLmId().getFechaEncLM().getTime());
		cv.put(ConstantsDB.EDAD, enclac.getEdad());
		cv.put(ConstantsDB.DIOPECHO, enclac.getDioPecho());
		cv.put(ConstantsDB.TIEMPECHO, enclac.getTiemPecho());
		cv.put(ConstantsDB.MESDIOPECHO, enclac.getMesDioPecho());
		cv.put(ConstantsDB.PECHOEXC, enclac.getPechoExc());
		cv.put(ConstantsDB.PECHOEXCANT, enclac.getPechoExcAntes());
		cv.put(ConstantsDB.TPECHOEXCANT, enclac.getTiempPechoExcAntes());
		cv.put(ConstantsDB.MPECHOEXCANT, enclac.getMestPechoExc());
		cv.put(ConstantsDB.FORMALIM, enclac.getFormAlim());
		cv.put(ConstantsDB.OTRALIM, enclac.getOtraAlim());
		cv.put(ConstantsDB.EDADLIQDP, enclac.getEdadLiqDistPecho());
		cv.put(ConstantsDB.MESLIQDL, enclac.getMesDioLiqDisLeche());
		cv.put(ConstantsDB.EDADLIQDL, enclac.getEdadLiqDistLeche());
		cv.put(ConstantsDB.MESLIQDP, enclac.getMesDioLiqDisPecho());
		cv.put(ConstantsDB.EDADALIMS, enclac.getEdAlimSolidos());
		cv.put(ConstantsDB.MESALIMS, enclac.getMesDioAlimSol());
		cv.put(ConstantsDB.ID_INSTANCIA, enclac.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, enclac.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, enclac.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, enclac.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, enclac.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, enclac.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, enclac.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, enclac.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, enclac.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, enclac.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, enclac.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, enclac.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, enclac.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, enclac.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.LACT_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ enclac.getLmId().getCodigo() + " and " +ConstantsDB.FECHA_ENC_LACT + "="
				+ enclac.getLmId().getFechaEncLM().getTime(), null) > 0;
	}
	
	/**METODOS PARA PT**/

	/**
	 * Inserta un pt en la base de datos
	 * 
	 * @param pt
	 *            Objeto PesoyTalla que contiene la informacion
	 *
	 */
	public void crearPT(PesoyTalla pt) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, pt.getPtId().getCodigo());
		cv.put(ConstantsDB.FECHA_PT, pt.getPtId().getFechaPT().getTime());
		cv.put(ConstantsDB.PESO1, pt.getPeso1());
		cv.put(ConstantsDB.PESO2, pt.getPeso2());
		cv.put(ConstantsDB.PESO3, pt.getPeso3());
		cv.put(ConstantsDB.TALLA1, pt.getTalla1());
		cv.put(ConstantsDB.TALLA2, pt.getTalla2());
		cv.put(ConstantsDB.TALLA3, pt.getTalla3());
		cv.put(ConstantsDB.IMC1, pt.getImc1());
		cv.put(ConstantsDB.IMC2, pt.getImc2());
		cv.put(ConstantsDB.IMC3, pt.getImc3());
		cv.put(ConstantsDB.DIFPESO, pt.getDifPeso());
		cv.put(ConstantsDB.DIFTALLA, pt.getDifTalla());
		cv.put(ConstantsDB.ID_INSTANCIA, pt.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, pt.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, pt.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, pt.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, pt.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, pt.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, pt.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, pt.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, pt.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, pt.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, pt.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, pt.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, pt.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, pt.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.PT_TABLE, null, cv);
	}

	/**
	 * Borra todas las mediciones de pt de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasPT() {
		return mDb.delete(ConstantsDB.PT_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una pt en la base de datos.
	 * 
	 * @param pt
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaPT(PesoyTalla pt) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, pt.getPtId().getCodigo());
		cv.put(ConstantsDB.FECHA_PT, pt.getPtId().getFechaPT().getTime());
		cv.put(ConstantsDB.PESO1, pt.getPeso1());
		cv.put(ConstantsDB.PESO2, pt.getPeso2());
		cv.put(ConstantsDB.PESO3, pt.getPeso3());
		cv.put(ConstantsDB.TALLA1, pt.getTalla1());
		cv.put(ConstantsDB.TALLA2, pt.getTalla2());
		cv.put(ConstantsDB.TALLA3, pt.getTalla3());
		cv.put(ConstantsDB.IMC1, pt.getImc1());
		cv.put(ConstantsDB.IMC2, pt.getImc2());
		cv.put(ConstantsDB.IMC3, pt.getImc3());
		cv.put(ConstantsDB.DIFPESO, pt.getDifPeso());
		cv.put(ConstantsDB.DIFTALLA, pt.getDifTalla());
		cv.put(ConstantsDB.ID_INSTANCIA, pt.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, pt.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, pt.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, pt.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, pt.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, pt.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, pt.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, pt.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, pt.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, pt.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, pt.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, pt.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, pt.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, pt.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.PT_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ pt.getPtId().getCodigo() + " and " +ConstantsDB.FECHA_PT + "="
				+ pt.getPtId().getFechaPT().getTime(), null) > 0;
	}
	
	/**METODOS PARA OB**/

	/**
	 * Inserta un obsequio en la base de datos
	 * 
	 * @param ob
	 *            Objeto Obsequio que contiene la informacion
	 *
	 */
	public void crearOB(Obsequio ob) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, ob.getObId().getCodigo());
		cv.put(ConstantsDB.FECHA_OB, ob.getObId().getFechaEntrega().getTime());
		cv.put(ConstantsDB.OBSEQ, ob.getObseqSN());
		cv.put(ConstantsDB.CARNET, ob.getCarnetSN());
		cv.put(ConstantsDB.PERRETIRA, ob.getPersRecCarnet());
		cv.put(ConstantsDB.PERRETIRAREL, ob.getRelacionFam());
		cv.put(ConstantsDB.PERRETIRAOREL, ob.getOtroRelacionFam());
		cv.put(ConstantsDB.OBS_TEL, ob.getTelefono());
		cv.put(ConstantsDB.CDOM, ob.getCmDomicilio());
		cv.put(ConstantsDB.BARRIO, ob.getBarrio());
		cv.put(ConstantsDB.DIRECCION, ob.getDire());
		cv.put(ConstantsDB.OBS, ob.getObservaciones());
		cv.put(ConstantsDB.ID_INSTANCIA, ob.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, ob.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, ob.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, ob.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, ob.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, ob.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, ob.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, ob.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, ob.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, ob.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, ob.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, ob.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, ob.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, ob.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.OB_TABLE, null, cv);
	}

	/**
	 * Borra todos los obsequios de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosOB() {
		return mDb.delete(ConstantsDB.OB_TABLE, null, null) > 0;
	}	

	/**
	 * Actualiza un obsequio en la base de datos.
	 * 
	 * @param ob
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaOB(Obsequio ob) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, ob.getObId().getCodigo());
		cv.put(ConstantsDB.FECHA_OB, ob.getObId().getFechaEntrega().getTime());
		cv.put(ConstantsDB.OBSEQ, ob.getObseqSN());
		cv.put(ConstantsDB.CARNET, ob.getCarnetSN());
		cv.put(ConstantsDB.PERRETIRA, ob.getPersRecCarnet());
		cv.put(ConstantsDB.PERRETIRAREL, ob.getRelacionFam());
		cv.put(ConstantsDB.PERRETIRAOREL, ob.getOtroRelacionFam());
		cv.put(ConstantsDB.OBS_TEL, ob.getTelefono());
		cv.put(ConstantsDB.CDOM, ob.getCmDomicilio());
		cv.put(ConstantsDB.BARRIO, ob.getBarrio());
		cv.put(ConstantsDB.DIRECCION, ob.getDire());
		cv.put(ConstantsDB.OBS, ob.getObservaciones());
		cv.put(ConstantsDB.ID_INSTANCIA, ob.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, ob.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, ob.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, ob.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, ob.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, ob.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, ob.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, ob.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, ob.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, ob.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, ob.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, ob.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, ob.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, ob.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.OB_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ ob.getObId().getCodigo() + " and " +ConstantsDB.FECHA_OB + "="
				+ ob.getObId().getFechaEntrega().getTime(), null) > 0;
	}
	
	/**METODOS PARA VACUNAS**/

	/**
	 * Inserta una vacuna en la base de datos
	 * 
	 * @param vacuna
	 *            Objeto Vacuna que contiene la informacion
	 *
	 */
	public void crearVacuna(Vacuna vacuna) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, vacuna.getVacunaId().getCodigo());
		cv.put(ConstantsDB.FECHA_VACUNA, vacuna.getVacunaId().getFechaVacuna().getTime());
		if (vacuna.getFechaVac() != null){
			cv.put(ConstantsDB.FV, vacuna.getFechaVac().getTime());
		}
		cv.put(ConstantsDB.VACUNA, vacuna.getVacuna());
		cv.put(ConstantsDB.TIPOVAC, vacuna.getTipovacuna());
		cv.put(ConstantsDB.TARJETA, vacuna.getTarjetaSN());
		cv.put(ConstantsDB.NDOSIS, vacuna.getNdosis());
		if (vacuna.getFechaInf1() != null){
			cv.put(ConstantsDB.FECHAINF1, vacuna.getFechaInf1().getTime());
		}
		if (vacuna.getFechaInf2() != null){
			cv.put(ConstantsDB.FECHAINF2, vacuna.getFechaInf2().getTime());
		}
		if (vacuna.getFechaInf3() != null){
			cv.put(ConstantsDB.FECHAINF3, vacuna.getFechaInf3().getTime());
		}
		if (vacuna.getFechaInf4() != null){
			cv.put(ConstantsDB.FECHAINF4, vacuna.getFechaInf4().getTime());
		}
		if (vacuna.getFechaInf5() != null){
			cv.put(ConstantsDB.FECHAINF5, vacuna.getFechaInf5().getTime());
		}
		if (vacuna.getFechaInf6() != null){
			cv.put(ConstantsDB.FECHAINF6, vacuna.getFechaInf6().getTime());
		}
		if (vacuna.getFechaInf7() != null){
			cv.put(ConstantsDB.FECHAINF7, vacuna.getFechaInf7().getTime());
		}
		if (vacuna.getFechaInf8() != null){
			cv.put(ConstantsDB.FECHAINF8, vacuna.getFechaInf8().getTime());
		}
		if (vacuna.getFechaInf9() != null){
			cv.put(ConstantsDB.FECHAINF9, vacuna.getFechaInf9().getTime());
		}
		if (vacuna.getFechaInf10() != null){
			cv.put(ConstantsDB.FECHAINF10, vacuna.getFechaInf10().getTime());
		}
		cv.put(ConstantsDB.ID_INSTANCIA, vacuna.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, vacuna.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, vacuna.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, vacuna.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, vacuna.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, vacuna.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, vacuna.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, vacuna.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, vacuna.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, vacuna.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, vacuna.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, vacuna.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, vacuna.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, vacuna.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.VAC_TABLE, null, cv);
	}

	/**
	 * Borra todas las Vacunas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasVacunas() {
		return mDb.delete(ConstantsDB.VAC_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una Vacuna en la base de datos.
	 * 
	 * @param Vacuna
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaVacuna(Vacuna vacuna) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, vacuna.getVacunaId().getCodigo());
		cv.put(ConstantsDB.FECHA_VACUNA, vacuna.getVacunaId().getFechaVacuna().getTime());
		if (vacuna.getFechaVac() != null){
			cv.put(ConstantsDB.FV, vacuna.getFechaVac().getTime());
		}
		cv.put(ConstantsDB.VACUNA, vacuna.getVacuna());
		cv.put(ConstantsDB.TIPOVAC, vacuna.getTipovacuna());
		cv.put(ConstantsDB.TARJETA, vacuna.getTarjetaSN());
		cv.put(ConstantsDB.NDOSIS, vacuna.getNdosis());
		if (vacuna.getFechaInf1() != null){
			cv.put(ConstantsDB.FECHAINF1, vacuna.getFechaInf1().getTime());
		}
		if (vacuna.getFechaInf2() != null){
			cv.put(ConstantsDB.FECHAINF2, vacuna.getFechaInf2().getTime());
		}
		if (vacuna.getFechaInf3() != null){
			cv.put(ConstantsDB.FECHAINF3, vacuna.getFechaInf3().getTime());
		}
		if (vacuna.getFechaInf4() != null){
			cv.put(ConstantsDB.FECHAINF4, vacuna.getFechaInf4().getTime());
		}
		if (vacuna.getFechaInf5() != null){
			cv.put(ConstantsDB.FECHAINF5, vacuna.getFechaInf5().getTime());
		}
		if (vacuna.getFechaInf6() != null){
			cv.put(ConstantsDB.FECHAINF6, vacuna.getFechaInf6().getTime());
		}
		if (vacuna.getFechaInf7() != null){
			cv.put(ConstantsDB.FECHAINF7, vacuna.getFechaInf7().getTime());
		}
		if (vacuna.getFechaInf8() != null){
			cv.put(ConstantsDB.FECHAINF8, vacuna.getFechaInf8().getTime());
		}
		if (vacuna.getFechaInf9() != null){
			cv.put(ConstantsDB.FECHAINF9, vacuna.getFechaInf9().getTime());
		}
		if (vacuna.getFechaInf10() != null){
			cv.put(ConstantsDB.FECHAINF10, vacuna.getFechaInf10().getTime());
		}
		cv.put(ConstantsDB.ID_INSTANCIA, vacuna.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, vacuna.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, vacuna.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, vacuna.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, vacuna.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, vacuna.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, vacuna.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, vacuna.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, vacuna.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, vacuna.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, vacuna.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, vacuna.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, vacuna.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, vacuna.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.VAC_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ vacuna.getVacunaId().getCodigo() + " and " +ConstantsDB.FECHA_VACUNA + "="
				+ vacuna.getVacunaId().getFechaVacuna().getTime(), null) > 0;
	}
	
	/**METODOS PARA VISITAS**/

	/**
	 * Inserta una visita en la base de datos
	 * 
	 * @param visita
	 *            Objeto VisitaTerreno que contiene la informacion
	 *
	 */
	public void crearVisita(VisitaTerreno visita) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, visita.getVisitaId().getCodigo());
		cv.put(ConstantsDB.FECHA_VISITA, visita.getVisitaId().getFechaVisita().getTime());
		cv.put(ConstantsDB.VISITASN, visita.getVisitaSN());
		cv.put(ConstantsDB.MOTNOVIS, visita.getMotNoVisita());
		cv.put(ConstantsDB.ACOMP_VIS, visita.getAcomp());
		cv.put(ConstantsDB.REL_VIS, visita.getRelacionFam());
		cv.put(ConstantsDB.ASENT_VIS, visita.getAsentimiento());
		cv.put(ConstantsDB.CDOM_VIS, visita.getcDom());
		cv.put(ConstantsDB.BARRIO_VIS, visita.getBarrio());
		cv.put(ConstantsDB.MANZ_VIS, visita.getManzana());
		cv.put(ConstantsDB.DIRE_VIS, visita.getDireccion());
		cv.put(ConstantsDB.COORD_VIS, visita.getCoordenadas());
		cv.put(ConstantsDB.LAT_VIS, visita.getLatitud());
		cv.put(ConstantsDB.LON_VIS, visita.getLongitud());
		cv.put(ConstantsDB.ID_INSTANCIA, visita.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, visita.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, visita.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, visita.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, visita.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, visita.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, visita.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, visita.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, visita.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, visita.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, visita.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, visita.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, visita.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, visita.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.VIS_TABLE, null, cv);
	}

	/**
	 * Borra todas las VisitaTerreno de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasVisitaTerrenos() {
		return mDb.delete(ConstantsDB.VIS_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una VisitaTerreno en la base de datos.
	 * 
	 * @param VisitaTerreno
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaVisitaTerreno(VisitaTerreno visita) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, visita.getVisitaId().getCodigo());
		cv.put(ConstantsDB.FECHA_VISITA, visita.getVisitaId().getFechaVisita().getTime());
		cv.put(ConstantsDB.VISITASN, visita.getVisitaSN());
		cv.put(ConstantsDB.MOTNOVIS, visita.getMotNoVisita());
		cv.put(ConstantsDB.ACOMP_VIS, visita.getAcomp());
		cv.put(ConstantsDB.REL_VIS, visita.getRelacionFam());
		cv.put(ConstantsDB.ASENT_VIS, visita.getAsentimiento());
		cv.put(ConstantsDB.CDOM_VIS, visita.getcDom());
		cv.put(ConstantsDB.BARRIO_VIS, visita.getBarrio());
		cv.put(ConstantsDB.MANZ_VIS, visita.getManzana());
		cv.put(ConstantsDB.DIRE_VIS, visita.getDireccion());
		cv.put(ConstantsDB.COORD_VIS, visita.getCoordenadas());
		cv.put(ConstantsDB.LAT_VIS, visita.getLatitud());
		cv.put(ConstantsDB.LON_VIS, visita.getLongitud());
		cv.put(ConstantsDB.ID_INSTANCIA, visita.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, visita.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, visita.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, visita.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, visita.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, visita.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, visita.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, visita.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, visita.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, visita.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, visita.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, visita.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, visita.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, visita.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.VIS_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ visita.getVisitaId().getCodigo() + " and " +ConstantsDB.FECHA_VISITA + "="
				+ visita.getVisitaId().getFechaVisita().getTime(), null) > 0;
	}
	
	
	/**METODOS PARA RECONS**/

	/**
	 * Inserta un reconsentimiento en la base de datos
	 * 
	 * @param reconsentimiento
	 *            Objeto ReConsentimientoDen que contiene la informacion
	 *
	 */
	public void crearReConsentimiento(ReConsentimientoDen reconsentimiento) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsdenId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsdenId().getFechaCons().getTime());
		cv.put(ConstantsDB.autsup, reconsentimiento.getAutsup());
		cv.put(ConstantsDB.parteaden, reconsentimiento.getParteADen());
		cv.put(ConstantsDB.rechazoden, reconsentimiento.getRechazoDen());
		cv.put(ConstantsDB.otrorechazoden, reconsentimiento.getOtroRechazoDen());
		cv.put(ConstantsDB.incden, reconsentimiento.getIncDen());
		cv.put(ConstantsDB.autsup2, reconsentimiento.getAutsup2());
		cv.put(ConstantsDB.excden, reconsentimiento.getExcDen());
		cv.put(ConstantsDB.enfcronsn, reconsentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, reconsentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, reconsentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, reconsentimiento.getTomaTx());
		cv.put(ConstantsDB.cualestx, reconsentimiento.getCualesTx());
		cv.put(ConstantsDB.autsup3, reconsentimiento.getAutsup3());
		cv.put(ConstantsDB.cmdomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.autsup4, reconsentimiento.getAutsup4());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.manzana, reconsentimiento.getManzana());
		cv.put(ConstantsDB.telefono, reconsentimiento.getTelefono());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.partebden, reconsentimiento.getParteBDen());
		cv.put(ConstantsDB.partecden, reconsentimiento.getParteCDen());
		cv.put(ConstantsDB.partedden, reconsentimiento.getParteDDen());
		cv.put(ConstantsDB.asentimientoesc, reconsentimiento.getAsentimientoesc());
		cv.put(ConstantsDB.parteeden, reconsentimiento.getParteEDen());
		cv.put(ConstantsDB.firmcarta, reconsentimiento.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.coordenadas, reconsentimiento.getCoordenadas());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.RECONS_TABLE, null, cv);
	}

	/**
	 * Borra todas las ReConsentimiento de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosReConsentimientos() {
		return mDb.delete(ConstantsDB.RECONS_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza un ReConsentimiento en la base de datos.
	 * 
	 * @param ReConsentimiento
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaReConsentimiento(ReConsentimientoDen reconsentimiento) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsdenId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsdenId().getFechaCons().getTime());
		cv.put(ConstantsDB.autsup, reconsentimiento.getAutsup());
		cv.put(ConstantsDB.parteaden, reconsentimiento.getParteADen());
		cv.put(ConstantsDB.rechazoden, reconsentimiento.getRechazoDen());
		cv.put(ConstantsDB.otrorechazoden, reconsentimiento.getOtroRechazoDen());
		cv.put(ConstantsDB.incden, reconsentimiento.getIncDen());
		cv.put(ConstantsDB.autsup2, reconsentimiento.getAutsup2());
		cv.put(ConstantsDB.excden, reconsentimiento.getExcDen());
		cv.put(ConstantsDB.enfcronsn, reconsentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, reconsentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, reconsentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, reconsentimiento.getTomaTx());
		cv.put(ConstantsDB.cualestx, reconsentimiento.getCualesTx());
		cv.put(ConstantsDB.autsup3, reconsentimiento.getAutsup3());
		cv.put(ConstantsDB.cmdomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.autsup4, reconsentimiento.getAutsup4());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.manzana, reconsentimiento.getManzana());
		cv.put(ConstantsDB.telefono, reconsentimiento.getTelefono());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.partebden, reconsentimiento.getParteBDen());
		cv.put(ConstantsDB.partecden, reconsentimiento.getParteCDen());
		cv.put(ConstantsDB.partedden, reconsentimiento.getParteDDen());
		cv.put(ConstantsDB.asentimientoesc, reconsentimiento.getAsentimientoesc());
		cv.put(ConstantsDB.parteeden, reconsentimiento.getParteEDen());
		cv.put(ConstantsDB.firmcarta, reconsentimiento.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.coordenadas, reconsentimiento.getCoordenadas());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.RECONS_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ reconsentimiento.getReconsdenId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ reconsentimiento.getReconsdenId().getFechaCons().getTime(), null) > 0;
	}
	
	
	/**METODOS PARA CONSCHIK**/

	/**
	 * Inserta un consentimiento de chikv en la base de datos
	 * 
	 * @param consentimiento
	 *            Objeto ConsentimientoChik que contiene la informacion
	 *
	 */
	public void crearConsentimientoChik(ConsentimientoChik consentimiento) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, consentimiento.getConsChikId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, consentimiento.getConsChikId().getFechaCons().getTime());
		cv.put(ConstantsDB.autsup, consentimiento.getAutsup());
		cv.put(ConstantsDB.partefden, consentimiento.getParteFDen());
		cv.put(ConstantsDB.rechazoden, consentimiento.getRechazoDen());
		cv.put(ConstantsDB.otrorechazoden, consentimiento.getOtroRechazoDen());
		cv.put(ConstantsDB.incden, consentimiento.getIncDen());
		cv.put(ConstantsDB.autsup2, consentimiento.getAutsup2());
		cv.put(ConstantsDB.excden, consentimiento.getExcDen());
		cv.put(ConstantsDB.enfcronsn, consentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, consentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, consentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, consentimiento.getTomaTx());
		cv.put(ConstantsDB.cualestx, consentimiento.getCualesTx());
		cv.put(ConstantsDB.autsup3, consentimiento.getAutsup3());
		cv.put(ConstantsDB.cmdomicilio, consentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, consentimiento.getBarrio());
		cv.put(ConstantsDB.autsup4, consentimiento.getAutsup4());
		cv.put(ConstantsDB.dire, consentimiento.getDire());
		cv.put(ConstantsDB.manzana, consentimiento.getManzana());
		cv.put(ConstantsDB.telefono, consentimiento.getTelefono());
		cv.put(ConstantsDB.asentimiento, consentimiento.getAsentimiento());
		cv.put(ConstantsDB.firmcarta, consentimiento.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, consentimiento.getRelacionFam());
		cv.put(ConstantsDB.coordenadas, consentimiento.getCoordenadas());
		cv.put(ConstantsDB.ID_INSTANCIA, consentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, consentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, consentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, consentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, consentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, consentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, consentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, consentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, consentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, consentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, consentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, consentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, consentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, consentimiento.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.CONSCHIK_TABLE, null, cv);
	}

	/**
	 * Borra todas las ConsentimientoChik de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosConsentimientoChik() {
		return mDb.delete(ConstantsDB.CONSCHIK_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza un ConsentimientoChik en la base de datos.
	 * 
	 * @param ConsentimientoChikXml
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaConsentimientoChik(ConsentimientoChik consentimiento) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, consentimiento.getConsChikId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, consentimiento.getConsChikId().getFechaCons().getTime());
		cv.put(ConstantsDB.autsup, consentimiento.getAutsup());
		cv.put(ConstantsDB.partefden, consentimiento.getParteFDen());
		cv.put(ConstantsDB.rechazoden, consentimiento.getRechazoDen());
		cv.put(ConstantsDB.otrorechazoden, consentimiento.getOtroRechazoDen());
		cv.put(ConstantsDB.incden, consentimiento.getIncDen());
		cv.put(ConstantsDB.autsup2, consentimiento.getAutsup2());
		cv.put(ConstantsDB.excden, consentimiento.getExcDen());
		cv.put(ConstantsDB.enfcronsn, consentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, consentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, consentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, consentimiento.getTomaTx());
		cv.put(ConstantsDB.cualestx, consentimiento.getCualesTx());
		cv.put(ConstantsDB.autsup3, consentimiento.getAutsup3());
		cv.put(ConstantsDB.cmdomicilio, consentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, consentimiento.getBarrio());
		cv.put(ConstantsDB.autsup4, consentimiento.getAutsup4());
		cv.put(ConstantsDB.dire, consentimiento.getDire());
		cv.put(ConstantsDB.manzana, consentimiento.getManzana());
		cv.put(ConstantsDB.telefono, consentimiento.getTelefono());
		cv.put(ConstantsDB.asentimiento, consentimiento.getAsentimiento());
		cv.put(ConstantsDB.firmcarta, consentimiento.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, consentimiento.getRelacionFam());
		cv.put(ConstantsDB.coordenadas, consentimiento.getCoordenadas());
		cv.put(ConstantsDB.ID_INSTANCIA, consentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, consentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, consentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, consentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, consentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, consentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, consentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, consentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, consentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, consentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, consentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, consentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, consentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, consentimiento.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.CONSCHIK_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ consentimiento.getConsChikId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ consentimiento.getConsChikId().getFechaCons().getTime(), null) > 0;
	}
	
	
	/**METODOS PARA CAMBIO DE ESTUDIO**/

	/**
	 * Inserta un CambioEstudio en la base de datos
	 * 
	 * @param datosCambio
	 *            Objeto CambioEstudio que contiene la informacion
	 *
	 */
	public void crearCambioEstudio(CambioEstudio datosCambio) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, datosCambio.getCambioEstudioId().getCodigo());
		cv.put(ConstantsDB.FECHA_CAMBIO, datosCambio.getCambioEstudioId().getFechaCambio().getTime());

		cv.put(ConstantsDB.parteaden, datosCambio.getParteADen());
		cv.put(ConstantsDB.rechazoden, datosCambio.getRechazoDen());
		cv.put(ConstantsDB.parteaflu, datosCambio.getParteAFlu());
		cv.put(ConstantsDB.rechazoflu, datosCambio.getRechazoFlu());

		cv.put(ConstantsDB.incden, datosCambio.getIncDen());
		cv.put(ConstantsDB.excden, datosCambio.getExcDen());
		cv.put(ConstantsDB.incflu, datosCambio.getIncFlu());
		cv.put(ConstantsDB.excflu, datosCambio.getExcFlu());

		
		cv.put(ConstantsDB.enfcronsn, datosCambio.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, datosCambio.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, datosCambio.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, datosCambio.getTomaTx());
		cv.put(ConstantsDB.cualestx, datosCambio.getCualesTx());
		
		
		cv.put(ConstantsDB.asentimiento, datosCambio.getAsentimiento());
		cv.put(ConstantsDB.asentimientoesc, datosCambio.getAsentimientoesc());
		
		cv.put(ConstantsDB.partebflu, datosCambio.getParteBFlu());
		cv.put(ConstantsDB.partecflu, datosCambio.getParteCFlu());
		
		cv.put(ConstantsDB.partebden, datosCambio.getParteBDen());
		cv.put(ConstantsDB.partecden, datosCambio.getParteCDen());
		cv.put(ConstantsDB.partedden, datosCambio.getParteDDen());
		cv.put(ConstantsDB.parteeden, datosCambio.getParteEDen());
		cv.put(ConstantsDB.partefden, datosCambio.getParteFDen());
		
		cv.put(ConstantsDB.firmcarta, datosCambio.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, datosCambio.getRelacionFam());
		cv.put(ConstantsDB.ID_INSTANCIA, datosCambio.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, datosCambio.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, datosCambio.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, datosCambio.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, datosCambio.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, datosCambio.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, datosCambio.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, datosCambio.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, datosCambio.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, datosCambio.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, datosCambio.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, datosCambio.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, datosCambio.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, datosCambio.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.CEST_TABLE, null, cv);
	}

	/**
	 * Borra todas las CambioEstudio de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosCambioEstudio() {
		return mDb.delete(ConstantsDB.CEST_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza un CambioEstudio en la base de datos.
	 * 
	 * @param CambioEstudioXml
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaCambioEstudio(CambioEstudio datosCambio) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, datosCambio.getCambioEstudioId().getCodigo());
		cv.put(ConstantsDB.FECHA_CAMBIO, datosCambio.getCambioEstudioId().getFechaCambio().getTime());

		cv.put(ConstantsDB.parteaden, datosCambio.getParteADen());
		cv.put(ConstantsDB.rechazoden, datosCambio.getRechazoDen());
		cv.put(ConstantsDB.parteaflu, datosCambio.getParteAFlu());
		cv.put(ConstantsDB.rechazoflu, datosCambio.getRechazoFlu());

		cv.put(ConstantsDB.incden, datosCambio.getIncDen());
		cv.put(ConstantsDB.excden, datosCambio.getExcDen());
		cv.put(ConstantsDB.incflu, datosCambio.getIncFlu());
		cv.put(ConstantsDB.excflu, datosCambio.getExcFlu());

		
		cv.put(ConstantsDB.enfcronsn, datosCambio.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, datosCambio.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, datosCambio.getoEnfCronica());
		cv.put(ConstantsDB.tomatx, datosCambio.getTomaTx());
		cv.put(ConstantsDB.cualestx, datosCambio.getCualesTx());
		
		
		cv.put(ConstantsDB.asentimiento, datosCambio.getAsentimiento());
		cv.put(ConstantsDB.asentimientoesc, datosCambio.getAsentimientoesc());
		
		cv.put(ConstantsDB.partebflu, datosCambio.getParteBFlu());
		cv.put(ConstantsDB.partecflu, datosCambio.getParteCFlu());
		
		cv.put(ConstantsDB.partebden, datosCambio.getParteBDen());
		cv.put(ConstantsDB.partecden, datosCambio.getParteCDen());
		cv.put(ConstantsDB.partedden, datosCambio.getParteDDen());
		cv.put(ConstantsDB.parteeden, datosCambio.getParteEDen());
		cv.put(ConstantsDB.partefden, datosCambio.getParteFDen());
		
		cv.put(ConstantsDB.firmcarta, datosCambio.getFirmcarta());
		cv.put(ConstantsDB.relacionfam, datosCambio.getRelacionFam());
		cv.put(ConstantsDB.ID_INSTANCIA, datosCambio.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, datosCambio.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, datosCambio.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, datosCambio.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, datosCambio.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, datosCambio.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, datosCambio.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, datosCambio.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, datosCambio.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, datosCambio.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, datosCambio.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, datosCambio.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, datosCambio.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, datosCambio.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.CEST_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ datosCambio.getCambioEstudioId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ datosCambio.getCambioEstudioId().getFechaCambio().getTime(), null) > 0;
	}
	
	
	/**METODOS PARA RECEPCION BHC**/

	/**
	 * Inserta una rec bhc en la base de datos
	 * 
	 * @param recbhc
	 *            Objeto RecepcionBHC que contiene la informacion
	 *
	 */
	public void crearRecepcionBHC(RecepcionBHC recbhc) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, recbhc.getRecBhcId().getCodigo());
		cv.put(ConstantsDB.FECHA_BHC, recbhc.getRecBhcId().getFechaRecBHC().getTime());
		cv.put(ConstantsDB.PAXGENE, recbhc.getPaxgene());
		cv.put(ConstantsDB.VOLBHC, recbhc.getVolumen());
		cv.put(ConstantsDB.LUGAR, recbhc.getLugar());
		cv.put(ConstantsDB.OBSBHC, recbhc.getObservacion());
		cv.put(ConstantsDB.USUARIO, recbhc.getUsername());
		cv.put(ConstantsDB.STATUS, recbhc.getEstado());
		cv.put(ConstantsDB.TODAY, recbhc.getFecreg().getTime());
		mDb.insert(ConstantsDB.BHC_TABLE, null, cv);
	}

	/**
	 * Borra todas las RecepcionBHC de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarRecepcionBHC() {
		return mDb.delete(ConstantsDB.BHC_TABLE, null, null) > 0;
	}
	
	/**
	 * Busca una RecepcionBHC de la base de datos
	 * 
	 * @return RecepcionBHC
	 */	

	public Cursor buscarRecepcionBHC(Integer codigo, Date fecha_bhc) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.BHC_TABLE, null,
				ConstantsDB.CODIGO + "=" + codigo + " and " + 
						ConstantsDB.FECHA_BHC + "=" + fecha_bhc.getTime(), null, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Lista todas las RecepcionBHC de la base de datos
	 * 
	 * @return dataset con RecepcionBHC
	 */
	public Cursor obtenerRecepcionBHC(Date today) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.BHC_TABLE, null,
				ConstantsDB.FECHA_BHC + "=" + today.getTime(), null, null, null, ConstantsDB.TODAY + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	/**
	 * Actualiza una RecepcionBHC en la base de datos.
	 * 
	 * @param RecepcionBHC
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaRecepcionBHC(RecepcionBHC recbhc) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, recbhc.getRecBhcId().getCodigo());
		cv.put(ConstantsDB.FECHA_BHC, recbhc.getRecBhcId().getFechaRecBHC().getTime());
		cv.put(ConstantsDB.PAXGENE, recbhc.getPaxgene());
		cv.put(ConstantsDB.VOLBHC, recbhc.getVolumen());
		cv.put(ConstantsDB.LUGAR, recbhc.getLugar());
		cv.put(ConstantsDB.OBSBHC, recbhc.getObservacion());
		cv.put(ConstantsDB.USUARIO, recbhc.getUsername());
		cv.put(ConstantsDB.STATUS, recbhc.getEstado());
		cv.put(ConstantsDB.TODAY, recbhc.getFecreg().getTime());
		return mDb.update(ConstantsDB.BHC_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ recbhc.getRecBhcId().getCodigo() + " and " +ConstantsDB.FECHA_BHC + "="
				+ recbhc.getRecBhcId().getFechaRecBHC().getTime(), null) > 0;
	}
	
	/**METODOS PARA RECEPCION SERO**/

	/**
	 * Inserta una rec sero en la base de datos
	 * 
	 * @param recsero
	 *            Objeto RecepcionSero que contiene la informacion
	 *
	 */
	public void crearRecepcionSero(RecepcionSero recsero) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, recsero.getRecSeroId().getCodigo());
		cv.put(ConstantsDB.FECHA_SERO, recsero.getRecSeroId().getFechaRecSero().getTime());
		cv.put(ConstantsDB.VOLSERO, recsero.getVolumen());
		cv.put(ConstantsDB.LUGAR, recsero.getLugar());
		cv.put(ConstantsDB.OBSSERO, recsero.getObservacion());
		cv.put(ConstantsDB.USUARIO, recsero.getUsername());
		cv.put(ConstantsDB.STATUS, recsero.getEstado());
		cv.put(ConstantsDB.TODAY, recsero.getFecreg().getTime());
		mDb.insert(ConstantsDB.SERO_TABLE, null, cv);
	}

	/**
	 * Borra todas las RecepcionSero de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarRecepcionSero() {
		return mDb.delete(ConstantsDB.SERO_TABLE, null, null) > 0;
	}
	
	/**
	 * Busca una RecepcionSero de la base de datos
	 * 
	 * @return RecepcionSero
	 */	

	public Cursor buscarRecepcionSero(Integer codigo, Date fecha_sero) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.SERO_TABLE, null,
				ConstantsDB.CODIGO + "=" + codigo + " and " + 
						ConstantsDB.FECHA_SERO + "=" + fecha_sero.getTime(), null, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Lista todas las RecepcionSero de la base de datos
	 * 
	 * @return dataset con RecepcionSero
	 */
	public Cursor obtenerRecepcionSero(Date today) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.SERO_TABLE, null,
				ConstantsDB.FECHA_SERO + "=" + today.getTime(), null, null, null, ConstantsDB.TODAY + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	/**
	 * Actualiza una RecepcionSero en la base de datos.
	 * 
	 * @param RecepcionSero
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaRecepcionSero(RecepcionSero recsero) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, recsero.getRecSeroId().getCodigo());
		cv.put(ConstantsDB.FECHA_SERO, recsero.getRecSeroId().getFechaRecSero().getTime());
		cv.put(ConstantsDB.VOLSERO, recsero.getVolumen());
		cv.put(ConstantsDB.LUGAR, recsero.getLugar());
		cv.put(ConstantsDB.OBSSERO, recsero.getObservacion());
		cv.put(ConstantsDB.USUARIO, recsero.getUsername());
		cv.put(ConstantsDB.STATUS, recsero.getEstado());
		cv.put(ConstantsDB.TODAY, recsero.getFecreg().getTime());
		return mDb.update(ConstantsDB.SERO_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ recsero.getRecSeroId().getCodigo() + " and " +ConstantsDB.FECHA_SERO + "="
				+ recsero.getRecSeroId().getFechaRecSero().getTime(), null) > 0;
	}
	
	/**METODOS PARA TEMP PBMC**/

	/**
	 * Inserta una temp pbmc en la base de datos
	 * 
	 * @param temppbmc
	 *            Objeto TempPbmc que contiene la informacion
	 *
	 */
	public void crearTempPbmc(TempPbmc temppbmc) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.RECURSO, temppbmc.getTempPbmcId().getRecurso());
		cv.put(ConstantsDB.FECHA_TEMP, temppbmc.getTempPbmcId().getFechaTempPbmc().getTime());
		cv.put(ConstantsDB.TEMP, temppbmc.getTemperatura());
		cv.put(ConstantsDB.LUGARTEMP, temppbmc.getLugar());
		cv.put(ConstantsDB.OBSTEMP, temppbmc.getObservacion());
		cv.put(ConstantsDB.USUARIO, temppbmc.getUsername());
		cv.put(ConstantsDB.STATUS, temppbmc.getEstado());
		cv.put(ConstantsDB.TODAY, temppbmc.getFecreg().getTime());
		mDb.insert(ConstantsDB.TPBMC_TABLE, null, cv);
	}

	/**
	 * Borra todas las TempPbmc de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTempPbmc() {
		return mDb.delete(ConstantsDB.TPBMC_TABLE, null, null) > 0;
	}
	
	/**
	 * Lista todas las TempPbmc de la base de datos
	 * 
	 * @return dataset con TempPbmc
	 */
	public Cursor obtenerTempPbmc(Date today) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.TPBMC_TABLE, null,
				ConstantsDB.TODAY + "=" + today.getTime(), null, null, null, ConstantsDB.FECHA_TEMP + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	/**
	 * Actualiza una TempPbmc en la base de datos.
	 * 
	 * @param TempPbmc
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaTempPbmc(TempPbmc temppbmc) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.RECURSO, temppbmc.getTempPbmcId().getRecurso());
		cv.put(ConstantsDB.FECHA_TEMP, temppbmc.getTempPbmcId().getFechaTempPbmc().getTime());
		cv.put(ConstantsDB.TEMP, temppbmc.getTemperatura());
		cv.put(ConstantsDB.LUGARTEMP, temppbmc.getLugar());
		cv.put(ConstantsDB.OBSTEMP, temppbmc.getObservacion());
		cv.put(ConstantsDB.USUARIO, temppbmc.getUsername());
		cv.put(ConstantsDB.STATUS, temppbmc.getEstado());
		cv.put(ConstantsDB.TODAY, temppbmc.getFecreg().getTime());
		return mDb.update(ConstantsDB.TPBMC_TABLE, cv, ConstantsDB.RECURSO + "='" 
				+ temppbmc.getTempPbmcId().getRecurso() + "' and " +ConstantsDB.FECHA_TEMP + "="
				+ temppbmc.getTempPbmcId().getFechaTempPbmc().getTime(), null) > 0;
	}
	
	/**METODOS PARA TEMP ROJO**/

	/**
	 * Inserta una temp rojo en la base de datos
	 * 
	 * @param temprojo
	 *            Objeto TempRojoBhc que contiene la informacion
	 *
	 */
	public void crearTempRojoBhc(TempRojoBhc temprojo) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.RECURSO, temprojo.getTempRojoBhcId().getRecurso());
		cv.put(ConstantsDB.FECHA_TEMP, temprojo.getTempRojoBhcId().getFechaTempRojoBhc().getTime());
		cv.put(ConstantsDB.TEMP, temprojo.getTemperatura());
		cv.put(ConstantsDB.LUGARTEMP, temprojo.getLugar());
		cv.put(ConstantsDB.OBSTEMP, temprojo.getObservacion());
		cv.put(ConstantsDB.USUARIO, temprojo.getUsername());
		cv.put(ConstantsDB.STATUS, temprojo.getEstado());
		cv.put(ConstantsDB.TODAY, temprojo.getFecreg().getTime());
		mDb.insert(ConstantsDB.TRB_TABLE, null, cv);
	}

	/**
	 * Borra todas las TempRojoBhc de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTempRojoBhc() {
		return mDb.delete(ConstantsDB.TRB_TABLE, null, null) > 0;
	}
	
	/**
	 * Lista todas las TempRojoBhc de la base de datos
	 * 
	 * @return dataset con TempRojoBhc
	 */
	public Cursor obtenerTempRojoBhc(Date today) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.TRB_TABLE, null,
				ConstantsDB.TODAY + "=" + today.getTime(), null, null, null, ConstantsDB.FECHA_TEMP + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	/**
	 * Actualiza una TempRojoBhc en la base de datos.
	 * 
	 * @param TempRojoBhc
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaTempRojoBhc(TempRojoBhc temprojo) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.RECURSO, temprojo.getTempRojoBhcId().getRecurso());
		cv.put(ConstantsDB.FECHA_TEMP, temprojo.getTempRojoBhcId().getFechaTempRojoBhc().getTime());
		cv.put(ConstantsDB.TEMP, temprojo.getTemperatura());
		cv.put(ConstantsDB.LUGARTEMP, temprojo.getLugar());
		cv.put(ConstantsDB.OBSTEMP, temprojo.getObservacion());
		cv.put(ConstantsDB.USUARIO, temprojo.getUsername());
		cv.put(ConstantsDB.STATUS, temprojo.getEstado());
		cv.put(ConstantsDB.TODAY, temprojo.getFecreg().getTime());
		return mDb.update(ConstantsDB.TRB_TABLE, cv, ConstantsDB.RECURSO + "='" 
				+ temprojo.getTempRojoBhcId().getRecurso() + "' and " +ConstantsDB.FECHA_TEMP + "="
				+ temprojo.getTempRojoBhcId().getFechaTempRojoBhc().getTime(), null) > 0;
	}
	
	/**METODOS PARA PINCHAZOS**/

	/**
	 * Inserta un pinchazo en la base de datos
	 * 
	 * @param pinchazo
	 *            Objeto Pinchazo que contiene la informacion
	 *
	 */
	public void crearPinchazo(Pinchazo pinchazo) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, pinchazo.getPinId().getCodigo());
		cv.put(ConstantsDB.FECHA_PIN, pinchazo.getPinId().getFechaPinchazo().getTime());
		cv.put(ConstantsDB.PINCHAZOS, pinchazo.getNumPin());
		cv.put(ConstantsDB.LUGAR, pinchazo.getLugar());
		cv.put(ConstantsDB.OBSPIN, pinchazo.getObservacion());
		cv.put(ConstantsDB.USUARIO, pinchazo.getUsername());
		cv.put(ConstantsDB.STATUS, pinchazo.getEstado());
		cv.put(ConstantsDB.TODAY, pinchazo.getFecreg().getTime());
		mDb.insert(ConstantsDB.PIN_TABLE, null, cv);
	}

	/**
	 * Borra todas las Pinchazo de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarPinchazo() {
		return mDb.delete(ConstantsDB.PIN_TABLE, null, null) > 0;
	}
	
	/**
	 * Busca una Pinchazo de la base de datos
	 * 
	 * @return Pinchazo
	 */	

	public Cursor buscarPinchazo(Integer codigo, Date fecha_pin) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.PIN_TABLE, null,
				ConstantsDB.CODIGO + "=" + codigo + " and " + 
						ConstantsDB.FECHA_PIN + "=" + fecha_pin.getTime(), null, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	/**
	 * Lista todas las Pinchazo de la base de datos
	 * 
	 * @return dataset con Pinchazo
	 */
	public Cursor obtenerPinchazo() throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.PIN_TABLE, null,
				null, null, null, null, ConstantsDB.TODAY + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Lista todas las Pinchazo de la base de datos
	 * 
	 * @return dataset con Pinchazo
	 */
	public Cursor obtenerPinchazo(Date today) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.PIN_TABLE, null,
				ConstantsDB.FECHA_PIN + "=" + today.getTime(), null, null, null, ConstantsDB.TODAY + " Desc", null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	/**
	 * Actualiza una Pinchazo en la base de datos.
	 * 
	 * @param Pinchazo
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaPinchazo(Pinchazo pinchazo) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, pinchazo.getPinId().getCodigo());
		cv.put(ConstantsDB.FECHA_PIN, pinchazo.getPinId().getFechaPinchazo().getTime());
		cv.put(ConstantsDB.PINCHAZOS, pinchazo.getNumPin());
		cv.put(ConstantsDB.LUGAR, pinchazo.getLugar());
		cv.put(ConstantsDB.OBSPIN, pinchazo.getObservacion());
		cv.put(ConstantsDB.USUARIO, pinchazo.getUsername());
		cv.put(ConstantsDB.STATUS, pinchazo.getEstado());
		cv.put(ConstantsDB.TODAY, pinchazo.getFecreg().getTime());
		return mDb.update(ConstantsDB.PIN_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ pinchazo.getPinId().getCodigo() + " and " +ConstantsDB.FECHA_PIN + "="
				+ pinchazo.getPinId().getFechaPinchazo().getTime(), null) > 0;
	}
	
	/**
	 * Inserta un RazonNoData en la base de datos
	 * 
	 * @param RazonNoData
	 *            Objeto RazonNoData que contiene la informacion
	 *
	 */
	public void crearRazonNoData(RazonNoData rnd) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, rnd.getRndId().getCodigo());
		cv.put(ConstantsDB.TODAY, rnd.getRndId().getFechaRegistro().getTime());
		cv.put(ConstantsDB.RAZON, rnd.getRazon());
		cv.put(ConstantsDB.ORAZON, rnd.getOtraRazon());
		cv.put(ConstantsDB.USUARIO, rnd.getUsername());
		cv.put(ConstantsDB.STATUS, rnd.getEstado());
		mDb.insert(ConstantsDB.NO_DATA_TABLE, null, cv);
	}
	
	/**
	 * Borra todas las RazonNoData de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarRazonNoData() {
		return mDb.delete(ConstantsDB.NO_DATA_TABLE, null, null) > 0;
	}
	
	
	/**
	 * Actualiza una RazonNoData en la base de datos.
	 * 
	 * @param RazonNoData
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaRazonNoData(RazonNoData rnd) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, rnd.getRndId().getCodigo());
		cv.put(ConstantsDB.TODAY, rnd.getRndId().getFechaRegistro().getTime());
		cv.put(ConstantsDB.RAZON, rnd.getRazon());
		cv.put(ConstantsDB.ORAZON, rnd.getOtraRazon());
		cv.put(ConstantsDB.USUARIO, rnd.getUsername());
		cv.put(ConstantsDB.STATUS, rnd.getEstado());
		return mDb.update(ConstantsDB.NO_DATA_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ rnd.getRndId().getCodigo() + " and " +ConstantsDB.TODAY + "="
				+ rnd.getRndId().getFechaRegistro().getTime(), null) > 0;
	}
	
	/**METODOS PARA ENCUESTAS SATISFACCION**/

	/**
	 * Inserta una encuesta de satisfaccion en la base de datos
	 * 
	 * @param encuesta satistaccion
	 *            Objeto EncuestaSatisfaccion que contiene la informacion
	 *
	 */
	public void crearEncuestaSatisfaccion(EncuestaSatisfaccion enssat) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.FECHA_ENC_SAT, enssat.getFechaEncuesta().getTime());
		cv.put(ConstantsDB.ESTUDIOSAT, enssat.getEstudio());
		cv.put(ConstantsDB.ATENPEREST, enssat.getAtenPerEst());
		cv.put(ConstantsDB.TIEMATEN, enssat.getTiemAten());
		cv.put(ConstantsDB.ATENPERADM, enssat.getAtenPerAdm());
		cv.put(ConstantsDB.ATENPERENFERM, enssat.getAtenPerEnferm());
		cv.put(ConstantsDB.ATENPERMED, enssat.getAtenPerMed());
		cv.put(ConstantsDB.AMBATEN, enssat.getAmbAten());
		cv.put(ConstantsDB.ATENPERLAB, enssat.getAtenPerLab());
		cv.put(ConstantsDB.EXPLDXENF, enssat.getExplDxEnf());
		cv.put(ConstantsDB.FLUDENSN, enssat.getFludenSN());
		cv.put(ConstantsDB.FLUCONIMP, enssat.getFluConImp());
		cv.put(ConstantsDB.DENCONIMP, enssat.getDenConImp());
		cv.put(ConstantsDB.EXPLPELIGENF, enssat.getExplPeligEnf());
		cv.put(ConstantsDB.EXPMEDCUID, enssat.getExpMedCuid());
		cv.put(ConstantsDB.ID_INSTANCIA, enssat.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, enssat.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, enssat.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, enssat.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, enssat.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, enssat.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, enssat.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, enssat.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, enssat.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, enssat.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, enssat.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, enssat.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, enssat.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, enssat.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.ENC_SAT_TABLE, null, cv);
	}

	/**
	 * Borra todas las encuestas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasEncuestaSatisfaccion() {
		return mDb.delete(ConstantsDB.ENC_SAT_TABLE, null, null) > 0;
	}


	/**
	 * Actualiza una encuesta en la base de datos.
	 * 
	 * @param satisfaccion
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaEncuestaSatisfaccion(EncuestaSatisfaccion encsat) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.FECHA_ENC_SAT, encsat.getFechaEncuesta().getTime());
		cv.put(ConstantsDB.ESTUDIOSAT, encsat.getEstudio());
		cv.put(ConstantsDB.ATENPEREST, encsat.getAtenPerEst());
		cv.put(ConstantsDB.TIEMATEN, encsat.getTiemAten());
		cv.put(ConstantsDB.ATENPERADM, encsat.getAtenPerAdm());
		cv.put(ConstantsDB.ATENPERENFERM, encsat.getAtenPerEnferm());
		cv.put(ConstantsDB.ATENPERMED, encsat.getAtenPerMed());
		cv.put(ConstantsDB.AMBATEN, encsat.getAmbAten());
		cv.put(ConstantsDB.ATENPERLAB, encsat.getAtenPerLab());
		cv.put(ConstantsDB.EXPLDXENF, encsat.getExplDxEnf());
		cv.put(ConstantsDB.FLUDENSN, encsat.getFludenSN());
		cv.put(ConstantsDB.FLUCONIMP, encsat.getFluConImp());
		cv.put(ConstantsDB.DENCONIMP, encsat.getDenConImp());
		cv.put(ConstantsDB.EXPLPELIGENF, encsat.getExplPeligEnf());
		cv.put(ConstantsDB.EXPMEDCUID, encsat.getExpMedCuid());
		cv.put(ConstantsDB.ID_INSTANCIA, encsat.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, encsat.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, encsat.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, encsat.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, encsat.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, encsat.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, encsat.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, encsat.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, encsat.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, encsat.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, encsat.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, encsat.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, encsat.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, encsat.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.ENC_SAT_TABLE, cv, ConstantsDB.FECHA_ENC_SAT + "="
				+ encsat.getFechaEncuesta().getTime(), null) > 0;
	}

	
	/**
	 * Busca un password de la base de datos
	 * 
	 * @return password
	 */	

	public String buscarPassword(String user) throws SQLException {
		Cursor c = null;
		String pass=null;
		c = mDb.query(true, ConstantsDB.USER_TABLE, null,
				ConstantsDB.USERNAME + "='" + user +"' and "+ ConstantsDB.ENABLED + "=1", null, null, null, null, null);

		if (c != null && c.getCount()>0) {
			c.moveToFirst();
			pass = c.getString(c.getColumnIndex(ConstantsDB.PASSWORD));
		}
		if (!c.isClosed()) c.close();
		return pass;
	}
	
	/**
	 * Busca un usuario de la base de datos
	 * 
	 * @return true or false
	 */	

	public boolean existeUsuario(String user) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.USER_TABLE, null,
				ConstantsDB.USERNAME + "='" + user +"'", null, null, null, null, null);

		if (c != null && c.getCount()>0) {
			c.moveToFirst();
			if (!c.isClosed()) c.close();
			return true;
		}
		if (!c.isClosed()) c.close();
		return false;
	}

	/**
	 * Inserta un usuario en la base de datos
	 * 
	 * @param usuario
	 *            Objeto Usuario que contiene la informacion
	 *
	 */
	public void crearUsuario(User user) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.USERNAME, user.getUsername());
		cv.put(ConstantsDB.ENABLED, user.getEnabled());
		cv.put(ConstantsDB.PASSWORD, user.getPassword());
		cv.put(ConstantsDB.U_ECASA, user.getEncuestaCasa());
		cv.put(ConstantsDB.U_EPART, user.getEncuestaParticipante());
		cv.put(ConstantsDB.U_ELACT, user.getEncuestaLactancia());
		cv.put(ConstantsDB.U_ESAT, user.getEncuestaSatisfaccion());
		cv.put(ConstantsDB.U_MUESTRA, user.getMuestra());
		cv.put(ConstantsDB.U_OBSEQUIO, user.getObsequio());
		cv.put(ConstantsDB.U_PYT, user.getPesoTalla());
		cv.put(ConstantsDB.U_VAC, user.getVacunas());
		cv.put(ConstantsDB.U_VISITA, user.getVisitas());
		cv.put(ConstantsDB.U_RECEPCION, user.getRecepcion());
		cv.put(ConstantsDB.U_CONS, user.getConsentimiento());
		cv.put(ConstantsDB.U_CASAZIKA, user.getCasazika());
		cv.put(ConstantsDB.U_TAMZIKA, user.getTamizajezika());
		mDb.insert(ConstantsDB.USER_TABLE, null, cv);
	}
	
	/**
	 * Inserta un usuario en la base de datos
	 * 
	 * @param usuario
	 *            Objeto Usuario que contiene la informacion
	 *
	 */
	public void crearUsuarioFromLogin(User user, String pass) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.USERNAME, user.getUsername());
		cv.put(ConstantsDB.ENABLED, user.getEnabled());
		cv.put(ConstantsDB.PASSWORD, pass);
		cv.put(ConstantsDB.U_ECASA, user.getEncuestaCasa());
		cv.put(ConstantsDB.U_EPART, user.getEncuestaParticipante());
		cv.put(ConstantsDB.U_ELACT, user.getEncuestaLactancia());
		cv.put(ConstantsDB.U_ESAT, user.getEncuestaSatisfaccion());
		cv.put(ConstantsDB.U_MUESTRA, user.getMuestra());
		cv.put(ConstantsDB.U_OBSEQUIO, user.getObsequio());
		cv.put(ConstantsDB.U_PYT, user.getPesoTalla());
		cv.put(ConstantsDB.U_VAC, user.getVacunas());
		cv.put(ConstantsDB.U_VISITA, user.getVisitas());
		cv.put(ConstantsDB.U_RECEPCION, user.getRecepcion());
		cv.put(ConstantsDB.U_CONS, user.getConsentimiento());
		cv.put(ConstantsDB.U_RECEPCION, user.getRecepcion());
		cv.put(ConstantsDB.U_CONS, user.getConsentimiento());
		cv.put(ConstantsDB.U_CASAZIKA, user.getCasazika());
		cv.put(ConstantsDB.U_TAMZIKA, user.getTamizajezika());
		mDb.insert(ConstantsDB.USER_TABLE, null, cv);
	}

	/**
	 * Borra todos los usuarios de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosUsuarios() {
		return mDb.delete(ConstantsDB.USER_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza un usuario en la base de datos
	 * 
	 * @param usuario
	 *            Objeto Usuario que contiene la informacion
	 *
	 */
	public boolean actualizarUsuario(User user) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.USERNAME, user.getUsername());
		cv.put(ConstantsDB.ENABLED, user.getEnabled());
		//cv.put(ConstantsDB.PASSWORD, user.getPassword());
		cv.put(ConstantsDB.U_ECASA, user.getEncuestaCasa());
		cv.put(ConstantsDB.U_EPART, user.getEncuestaParticipante());
		cv.put(ConstantsDB.U_ELACT, user.getEncuestaLactancia());
		cv.put(ConstantsDB.U_ESAT, user.getEncuestaSatisfaccion());
		cv.put(ConstantsDB.U_MUESTRA, user.getMuestra());
		cv.put(ConstantsDB.U_OBSEQUIO, user.getObsequio());
		cv.put(ConstantsDB.U_PYT, user.getPesoTalla());
		cv.put(ConstantsDB.U_VAC, user.getVacunas());
		cv.put(ConstantsDB.U_VISITA, user.getVisitas());
		cv.put(ConstantsDB.U_RECEPCION, user.getRecepcion());
		cv.put(ConstantsDB.U_CONS, user.getConsentimiento());
		cv.put(ConstantsDB.U_CASAZIKA, user.getCasazika());
		cv.put(ConstantsDB.U_TAMZIKA, user.getTamizajezika());
		return mDb.update(ConstantsDB.USER_TABLE, cv, ConstantsDB.USERNAME + "='"
				+ user.getUsername() + "'", null) > 0;
	}
	
	/**
	 * Actualiza un usuario en la base de datos
	 * 
	 * @param usuario
	 *            Objeto Usuario que contiene la informacion
	 *
	 */
	public boolean actualizarUsuarioFromLogin(User user, String pass) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.USERNAME, user.getUsername());
		cv.put(ConstantsDB.ENABLED, user.getEnabled());
		cv.put(ConstantsDB.PASSWORD, pass);
		cv.put(ConstantsDB.U_ECASA, user.getEncuestaCasa());
		cv.put(ConstantsDB.U_EPART, user.getEncuestaParticipante());
		cv.put(ConstantsDB.U_ELACT, user.getEncuestaLactancia());
		cv.put(ConstantsDB.U_ESAT, user.getEncuestaSatisfaccion());
		cv.put(ConstantsDB.U_MUESTRA, user.getMuestra());
		cv.put(ConstantsDB.U_OBSEQUIO, user.getObsequio());
		cv.put(ConstantsDB.U_PYT, user.getPesoTalla());
		cv.put(ConstantsDB.U_VAC, user.getVacunas());
		cv.put(ConstantsDB.U_VISITA, user.getVisitas());
		cv.put(ConstantsDB.U_RECEPCION, user.getRecepcion());
		cv.put(ConstantsDB.U_CONS, user.getConsentimiento());
		cv.put(ConstantsDB.U_CASAZIKA, user.getCasazika());
		cv.put(ConstantsDB.U_TAMZIKA, user.getTamizajezika());
		return mDb.update(ConstantsDB.USER_TABLE, cv, ConstantsDB.USERNAME + "='"
				+ user.getUsername() + "'", null) > 0;
	}
	
	/**METODOS PARA MUESTRAS**/

	/**
	 * Inserta una muestra en la base de datos
	 * 
	 * @param muestra
	 *            Objeto Muestra que contiene la informacion
	 *
	 */
	public void crearMuestra(Muestra muestra) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, muestra.getmId().getCodigo());
		cv.put(ConstantsDB.FECHA_MUESTRA, muestra.getmId().getFechaMuestra().getTime());
		cv.put(ConstantsDB.MFIEBRE, muestra.getFiebreM());
		cv.put(ConstantsDB.CONSULTA, muestra.getConsulta());
		cv.put(ConstantsDB.BHC, muestra.getTuboBHC());
		cv.put(ConstantsDB.ROJO, muestra.getTuboRojo());
		cv.put(ConstantsDB.LEU, muestra.getTuboLeu());
		
		cv.put(ConstantsDB.bhc_razonNo, muestra.getBhc_razonNo());
		cv.put(ConstantsDB.rojo_razonNo, muestra.getRojo_razonNo());
		cv.put(ConstantsDB.pbmc_razonNo, muestra.getPbmc_razonNo());
		
		cv.put(ConstantsDB.bhc_otraRazonNo, muestra.getBhc_otraRazonNo());
		cv.put(ConstantsDB.rojo_otraRazonNo, muestra.getRojo_otraRazonNo());
		cv.put(ConstantsDB.pbmc_otraRazonNo, muestra.getPbmc_otraRazonNo());
		
		cv.put(ConstantsDB.horaBHC, muestra.getHoraBHC());
		cv.put(ConstantsDB.horaPBMC, muestra.getHoraPBMC());
		cv.put(ConstantsDB.horaInicioPax, muestra.getHoraInicioPax());
		
		cv.put(ConstantsDB.horaFinPax, muestra.getHoraFinPax());
		cv.put(ConstantsDB.codPax, muestra.getCodPax());
		cv.put(ConstantsDB.terreno, muestra.getTerreno());
		
		
		cv.put(ConstantsDB.PIN, muestra.getPinchazos());
		cv.put(ConstantsDB.ID_INSTANCIA, muestra.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, muestra.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, muestra.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, muestra.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, muestra.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, muestra.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, muestra.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, muestra.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, muestra.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, muestra.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, muestra.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, muestra.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, muestra.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, muestra.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.MUESTRA_TABLE, null, cv);
	}

	/**
	 * Borra todas las muestras de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodasMuestras() {
		return mDb.delete(ConstantsDB.MUESTRA_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza una muestra en la base de datos.
	 * 
	 * @param muestra
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaMuestra(Muestra muestra) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, muestra.getmId().getCodigo());
		cv.put(ConstantsDB.FECHA_MUESTRA, muestra.getmId().getFechaMuestra().getTime());
		cv.put(ConstantsDB.MFIEBRE, muestra.getFiebreM());
		cv.put(ConstantsDB.CONSULTA, muestra.getConsulta());
		cv.put(ConstantsDB.BHC, muestra.getTuboBHC());
		cv.put(ConstantsDB.ROJO, muestra.getTuboRojo());
		cv.put(ConstantsDB.LEU, muestra.getTuboLeu());
		
		cv.put(ConstantsDB.bhc_razonNo, muestra.getBhc_razonNo());
		cv.put(ConstantsDB.rojo_razonNo, muestra.getRojo_razonNo());
		cv.put(ConstantsDB.pbmc_razonNo, muestra.getPbmc_razonNo());
		
		cv.put(ConstantsDB.bhc_otraRazonNo, muestra.getBhc_otraRazonNo());
		cv.put(ConstantsDB.rojo_otraRazonNo, muestra.getRojo_otraRazonNo());
		cv.put(ConstantsDB.pbmc_otraRazonNo, muestra.getPbmc_otraRazonNo());
		
		cv.put(ConstantsDB.horaBHC, muestra.getHoraBHC());
		cv.put(ConstantsDB.horaPBMC, muestra.getHoraPBMC());
		cv.put(ConstantsDB.horaInicioPax, muestra.getHoraInicioPax());
		
		cv.put(ConstantsDB.horaFinPax, muestra.getHoraFinPax());
		cv.put(ConstantsDB.codPax, muestra.getCodPax());
		cv.put(ConstantsDB.terreno, muestra.getTerreno());
		
		cv.put(ConstantsDB.PIN, muestra.getPinchazos());
		cv.put(ConstantsDB.ID_INSTANCIA, muestra.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, muestra.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, muestra.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, muestra.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, muestra.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, muestra.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, muestra.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, muestra.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, muestra.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, muestra.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, muestra.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, muestra.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, muestra.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, muestra.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.MUESTRA_TABLE, cv,ConstantsDB.CODIGO + "=" 
				+ muestra.getmId().getCodigo() + " and " +ConstantsDB.FECHA_MUESTRA + "="
				+ muestra.getmId().getFechaMuestra().getTime(), null) > 0;
	}

	/**
	 * Inserta un rol en la base de datos
	 * 
	 * @param rol
	 *            Objeto Rol que contiene la informacion
	 *
	 */
	public void crearRol(Authority role) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.USERNAME, role.getAuthId().getUsername());
		cv.put(ConstantsDB.AUTH, role.getAuthId().getAuthority());
		mDb.insert(ConstantsDB.ROLE_TABLE, null, cv);
	}

	/**
	 * Borra todos los roles de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosRoles() {
		return mDb.delete(ConstantsDB.ROLE_TABLE, null, null) > 0;
	}
	
	public boolean borrarTodosRoles(String username) {
		return mDb.delete(ConstantsDB.ROLE_TABLE, ConstantsDB.USERNAME + "='" + username + "'", null) > 0;
	}
	
	/**
	 * Busca un rol de la base de datos
	 * 
	 * @return true or false
	 */	
	
	public Boolean buscarRol(String username, String Rol) throws SQLException {
		Cursor c = null;
		c = mDb.query(true, ConstantsDB.ROLE_TABLE, null,
				ConstantsDB.USERNAME + "='" + username + "' and " + ConstantsDB.AUTH + "='" + Rol + "'" , null, null, null, null, null);

		if (c != null && c.getCount()>0) {
			c.moveToFirst();
			return true;
		}
		return false;
	}
	
	
	/**METODOS PARA RECONS 2015**/

	/**
	 * Inserta un reconsentimiento en la base de datos
	 * 
	 * @param reconsentimiento
	 *            Objeto ReConsentimientoDen que contiene la informacion
	 *
	 */
	public void crearReConsentimiento2015(ReConsentimientoDen2015 reconsentimiento) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsdenId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsdenId().getFechaCons().getTime());
		cv.put(ConstantsDB.visExit, reconsentimiento.getVisExit());
		cv.put(ConstantsDB.razonVisNoExit, reconsentimiento.getRazonVisNoExit());
		cv.put(ConstantsDB.personaDejoCarta, reconsentimiento.getPersonaDejoCarta());
		cv.put(ConstantsDB.personaCasa, reconsentimiento.getPersonaCasa());
		cv.put(ConstantsDB.relacionFamPersonaCasa, reconsentimiento.getRelacionFamPersonaCasa());
		cv.put(ConstantsDB.otraRelacionPersonaCasa, reconsentimiento.getOtraRelacionPersonaCasa());
		cv.put(ConstantsDB.telefonoPersonaCasa, reconsentimiento.getTelefonoPersonaCasa());
		cv.put(ConstantsDB.emancipado, reconsentimiento.getEmancipado());
		cv.put(ConstantsDB.descEmancipado, reconsentimiento.getDescEmancipado());
		cv.put(ConstantsDB.incDen, reconsentimiento.getIncDen());
		cv.put(ConstantsDB.excDen, reconsentimiento.getExcDen());
		cv.put(ConstantsDB.enfCronSN, reconsentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, reconsentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, reconsentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomaTx, reconsentimiento.getTomaTx());
		cv.put(ConstantsDB.cualesTx, reconsentimiento.getCualesTx());
		cv.put(ConstantsDB.assite, reconsentimiento.getAssite());
		cv.put(ConstantsDB.centrosalud, reconsentimiento.getCentrosalud());
		cv.put(ConstantsDB.ocentrosalud, reconsentimiento.getOcentrosalud());
		cv.put(ConstantsDB.puestosalud, reconsentimiento.getPuestosalud());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.parteADen, reconsentimiento.getParteADen());
		cv.put(ConstantsDB.parteBDen, reconsentimiento.getParteBDen());
		cv.put(ConstantsDB.parteCDen, reconsentimiento.getParteCDen());
		cv.put(ConstantsDB.parteDDen, reconsentimiento.getParteDDen());
		cv.put(ConstantsDB.rechDen, reconsentimiento.getRechDen());
		cv.put(ConstantsDB.nombrept, reconsentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, reconsentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, reconsentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, reconsentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, reconsentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.mismoTutorSN, reconsentimiento.getMismoTutorSN());
		cv.put(ConstantsDB.motivoDifTutor, reconsentimiento.getMotivoDifTutor());
		cv.put(ConstantsDB.otroMotivoDifTutor, reconsentimiento.getOtroMotivoDifTutor());
		cv.put(ConstantsDB.quePaisTutor, reconsentimiento.getQuePaisTutor());
		cv.put(ConstantsDB.alfabetoTutor, reconsentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, reconsentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, reconsentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, reconsentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, reconsentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, reconsentimiento.getApellidotest2());
		cv.put(ConstantsDB.cmDomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.otrobarrio, reconsentimiento.getOtrobarrio());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.autsup, reconsentimiento.getAutsup());
		cv.put(ConstantsDB.telefonoClasif1, reconsentimiento.getTelefonoClasif1());
		cv.put(ConstantsDB.telefonoConv1, reconsentimiento.getTelefonoConv1());
		cv.put(ConstantsDB.telefonoCel1, reconsentimiento.getTelefonoCel1());
		cv.put(ConstantsDB.telefono2SN, reconsentimiento.getTelefono2SN());
		cv.put(ConstantsDB.telefonoClasif2, reconsentimiento.getTelefonoClasif2());
		cv.put(ConstantsDB.telefonoConv2, reconsentimiento.getTelefonoConv2());
		cv.put(ConstantsDB.telefonoCel2, reconsentimiento.getTelContactoCel2());
		cv.put(ConstantsDB.telefono3SN, reconsentimiento.getTelefono3SN());
		cv.put(ConstantsDB.telefonoClasif3, reconsentimiento.getTelefonoClasif3());
		cv.put(ConstantsDB.telefonoConv3, reconsentimiento.getTelefonoConv3());
		cv.put(ConstantsDB.telefonoCel3, reconsentimiento.getTelefonoCel3());		
		cv.put(ConstantsDB.jefenom, reconsentimiento.getJefenom());
		cv.put(ConstantsDB.jefenom2, reconsentimiento.getJefenom2());
		cv.put(ConstantsDB.jefeap, reconsentimiento.getJefeap());
		cv.put(ConstantsDB.jefeap2, reconsentimiento.getJefeap2());
		cv.put(ConstantsDB.nomContacto, reconsentimiento.getNomContacto());
		cv.put(ConstantsDB.barrioContacto, reconsentimiento.getBarrioContacto());
		cv.put(ConstantsDB.otrobarrioContacto, reconsentimiento.getOtrobarrioContacto());
		cv.put(ConstantsDB.direContacto, reconsentimiento.getDireContacto());
		cv.put(ConstantsDB.telContacto1, reconsentimiento.getTelContacto1());
		cv.put(ConstantsDB.telContactoConv1, reconsentimiento.getTelContactoConv1());	
		cv.put(ConstantsDB.telContactoCel1, reconsentimiento.getTelContactoCel1());
		cv.put(ConstantsDB.telContacto2SN, reconsentimiento.getTelContacto2SN());
		cv.put(ConstantsDB.telContactoClasif2, reconsentimiento.getTelContactoClasif2());
		cv.put(ConstantsDB.telContactoConv2, reconsentimiento.getTelContactoConv2());
		cv.put(ConstantsDB.telContactoCel2, reconsentimiento.getTelContactoCel2());
		cv.put(ConstantsDB.nombrepadre, reconsentimiento.getNombrepadre());
		cv.put(ConstantsDB.nombrepadre2, reconsentimiento.getNombrepadre2());
		cv.put(ConstantsDB.apellidopadre, reconsentimiento.getApellidopadre());
		cv.put(ConstantsDB.apellidopadre2, reconsentimiento.getApellidopadre2());
		cv.put(ConstantsDB.nombremadre, reconsentimiento.getNombremadre());	
		cv.put(ConstantsDB.nombremadre2, reconsentimiento.getNombremadre2());
		cv.put(ConstantsDB.apellidomadre, reconsentimiento.getApellidomadre());
		cv.put(ConstantsDB.apellidomadre2, reconsentimiento.getApellidomadre2());
		cv.put(ConstantsDB.copiaFormato, reconsentimiento.getCopiaFormato());
		cv.put(ConstantsDB.firmo_cartcons, reconsentimiento.getFirmo_cartcons());
		cv.put(ConstantsDB.fecho_cartcons, reconsentimiento.getFecho_cartcons());
		cv.put(ConstantsDB.huella_dig, reconsentimiento.getHuella_dig());
		cv.put(ConstantsDB.fech_firm_testigo, reconsentimiento.getFech_firm_testigo());
		cv.put(ConstantsDB.entiende, reconsentimiento.getEntiende());
		cv.put(ConstantsDB.georef, reconsentimiento.getGeoref());		
		cv.put(ConstantsDB.Manzana, reconsentimiento.getManzana());
		cv.put(ConstantsDB.georef_razon, reconsentimiento.getGeoref_razon());
		cv.put(ConstantsDB.georef_otraRazon, reconsentimiento.getGeoref_otraRazon());
		cv.put(ConstantsDB.local, reconsentimiento.getLocal());
		cv.put(ConstantsDB.otrorecurso1, reconsentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, reconsentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.RECONS_TABLE_2015, null, cv);
	}

	/**
	 * Borra todas las ReConsentimiento de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosReConsentimientos2015() {
		return mDb.delete(ConstantsDB.RECONS_TABLE_2015, null, null) > 0;
	}

	/**
	 * Actualiza un ReConsentimiento en la base de datos.
	 * 
	 * @param ReConsentimiento
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaReConsentimiento2015(ReConsentimientoDen2015 reconsentimiento) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsdenId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsdenId().getFechaCons().getTime());
		cv.put(ConstantsDB.visExit, reconsentimiento.getVisExit());
		cv.put(ConstantsDB.razonVisNoExit, reconsentimiento.getRazonVisNoExit());
		cv.put(ConstantsDB.personaDejoCarta, reconsentimiento.getPersonaDejoCarta());
		cv.put(ConstantsDB.personaCasa, reconsentimiento.getPersonaCasa());
		cv.put(ConstantsDB.relacionFamPersonaCasa, reconsentimiento.getRelacionFamPersonaCasa());
		cv.put(ConstantsDB.otraRelacionPersonaCasa, reconsentimiento.getOtraRelacionPersonaCasa());
		cv.put(ConstantsDB.telefonoPersonaCasa, reconsentimiento.getTelefonoPersonaCasa());
		cv.put(ConstantsDB.emancipado, reconsentimiento.getEmancipado());
		cv.put(ConstantsDB.descEmancipado, reconsentimiento.getDescEmancipado());
		cv.put(ConstantsDB.incDen, reconsentimiento.getIncDen());
		cv.put(ConstantsDB.excDen, reconsentimiento.getExcDen());
		cv.put(ConstantsDB.enfCronSN, reconsentimiento.getEnfCronSN());
		cv.put(ConstantsDB.enfCronica, reconsentimiento.getEnfCronica());
		cv.put(ConstantsDB.oEnfCronica, reconsentimiento.getoEnfCronica());
		cv.put(ConstantsDB.tomaTx, reconsentimiento.getTomaTx());
		cv.put(ConstantsDB.cualesTx, reconsentimiento.getCualesTx());
		cv.put(ConstantsDB.assite, reconsentimiento.getAssite());
		cv.put(ConstantsDB.centrosalud, reconsentimiento.getCentrosalud());
		cv.put(ConstantsDB.ocentrosalud, reconsentimiento.getOcentrosalud());
		cv.put(ConstantsDB.puestosalud, reconsentimiento.getPuestosalud());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.parteADen, reconsentimiento.getParteADen());
		cv.put(ConstantsDB.parteBDen, reconsentimiento.getParteBDen());
		cv.put(ConstantsDB.parteCDen, reconsentimiento.getParteCDen());
		cv.put(ConstantsDB.parteDDen, reconsentimiento.getParteDDen());
		cv.put(ConstantsDB.rechDen, reconsentimiento.getRechDen());
		cv.put(ConstantsDB.nombrept, reconsentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, reconsentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, reconsentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, reconsentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, reconsentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.mismoTutorSN, reconsentimiento.getMismoTutorSN());
		cv.put(ConstantsDB.motivoDifTutor, reconsentimiento.getMotivoDifTutor());
		cv.put(ConstantsDB.otroMotivoDifTutor, reconsentimiento.getOtroMotivoDifTutor());
		cv.put(ConstantsDB.quePaisTutor, reconsentimiento.getQuePaisTutor());
		cv.put(ConstantsDB.alfabetoTutor, reconsentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, reconsentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, reconsentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, reconsentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, reconsentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, reconsentimiento.getApellidotest2());
		cv.put(ConstantsDB.cmDomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.otrobarrio, reconsentimiento.getOtrobarrio());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.autsup, reconsentimiento.getAutsup());
		cv.put(ConstantsDB.telefonoClasif1, reconsentimiento.getTelefonoClasif1());
		cv.put(ConstantsDB.telefonoConv1, reconsentimiento.getTelefonoConv1());
		cv.put(ConstantsDB.telefonoCel1, reconsentimiento.getTelefonoCel1());
		cv.put(ConstantsDB.telefono2SN, reconsentimiento.getTelefono2SN());
		cv.put(ConstantsDB.telefonoClasif2, reconsentimiento.getTelefonoClasif2());
		cv.put(ConstantsDB.telefonoConv2, reconsentimiento.getTelefonoConv2());
		cv.put(ConstantsDB.telefonoCel2, reconsentimiento.getTelContactoCel2());
		cv.put(ConstantsDB.telefono3SN, reconsentimiento.getTelefono3SN());
		cv.put(ConstantsDB.telefonoClasif3, reconsentimiento.getTelefonoClasif3());
		cv.put(ConstantsDB.telefonoConv3, reconsentimiento.getTelefonoConv3());
		cv.put(ConstantsDB.telefonoCel3, reconsentimiento.getTelefonoCel3());		
		cv.put(ConstantsDB.jefenom, reconsentimiento.getJefenom());
		cv.put(ConstantsDB.jefenom2, reconsentimiento.getJefenom2());
		cv.put(ConstantsDB.jefeap, reconsentimiento.getJefeap());
		cv.put(ConstantsDB.jefeap2, reconsentimiento.getJefeap2());
		cv.put(ConstantsDB.nomContacto, reconsentimiento.getNomContacto());
		cv.put(ConstantsDB.barrioContacto, reconsentimiento.getBarrioContacto());
		cv.put(ConstantsDB.otrobarrioContacto, reconsentimiento.getOtrobarrioContacto());
		cv.put(ConstantsDB.direContacto, reconsentimiento.getDireContacto());
		cv.put(ConstantsDB.telContacto1, reconsentimiento.getTelContacto1());
		cv.put(ConstantsDB.telContactoConv1, reconsentimiento.getTelContactoConv1());	
		cv.put(ConstantsDB.telContactoCel1, reconsentimiento.getTelContactoCel1());
		cv.put(ConstantsDB.telContacto2SN, reconsentimiento.getTelContacto2SN());
		cv.put(ConstantsDB.telContactoClasif2, reconsentimiento.getTelContactoClasif2());
		cv.put(ConstantsDB.telContactoConv2, reconsentimiento.getTelContactoConv2());
		cv.put(ConstantsDB.telContactoCel2, reconsentimiento.getTelContactoCel2());
		cv.put(ConstantsDB.nombrepadre, reconsentimiento.getNombrepadre());
		cv.put(ConstantsDB.nombrepadre2, reconsentimiento.getNombrepadre2());
		cv.put(ConstantsDB.apellidopadre, reconsentimiento.getApellidopadre());
		cv.put(ConstantsDB.apellidopadre2, reconsentimiento.getApellidopadre2());
		cv.put(ConstantsDB.nombremadre, reconsentimiento.getNombremadre());	
		cv.put(ConstantsDB.nombremadre2, reconsentimiento.getNombremadre2());
		cv.put(ConstantsDB.apellidomadre, reconsentimiento.getApellidomadre());
		cv.put(ConstantsDB.apellidomadre2, reconsentimiento.getApellidomadre2());
		cv.put(ConstantsDB.copiaFormato, reconsentimiento.getCopiaFormato());
		cv.put(ConstantsDB.firmo_cartcons, reconsentimiento.getFirmo_cartcons());
		cv.put(ConstantsDB.fecho_cartcons, reconsentimiento.getFecho_cartcons());
		cv.put(ConstantsDB.huella_dig, reconsentimiento.getHuella_dig());
		cv.put(ConstantsDB.fech_firm_testigo, reconsentimiento.getFech_firm_testigo());
		cv.put(ConstantsDB.entiende, reconsentimiento.getEntiende());
		cv.put(ConstantsDB.georef, reconsentimiento.getGeoref());		
		cv.put(ConstantsDB.Manzana, reconsentimiento.getManzana());
		cv.put(ConstantsDB.georef_razon, reconsentimiento.getGeoref_razon());
		cv.put(ConstantsDB.georef_otraRazon, reconsentimiento.getGeoref_otraRazon());
		cv.put(ConstantsDB.local, reconsentimiento.getLocal());
		cv.put(ConstantsDB.otrorecurso1, reconsentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, reconsentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.RECONS_TABLE_2015, cv, ConstantsDB.CODIGO + "=" 
				+ reconsentimiento.getReconsdenId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ reconsentimiento.getReconsdenId().getFechaCons().getTime(), null) > 0;
	}
	
	
	/**METODOS PARA ZIKA**/

	/**
	 * Inserta un consentimiento en la base de datos
	 * 
	 * @param consentimiento
	 *            Objeto ConsentimientoZika que contiene la informacion
	 *
	 */
	public void crearConsentimientoZika(ConsentimientoZika consentimiento) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, consentimiento.getConsZikaId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, consentimiento.getConsZikaId().getFechaCons().getTime());
		cv.put(ConstantsDB.parteDDen, consentimiento.getParteDDen());
		cv.put(ConstantsDB.rechDDen, consentimiento.getRechDDen());
		cv.put(ConstantsDB.nombrept, consentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, consentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, consentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, consentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, consentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, consentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.mismoTutorSN, consentimiento.getMismoTutorSN());
		cv.put(ConstantsDB.motivoDifTutor, consentimiento.getMotivoDifTutor());
		cv.put(ConstantsDB.otroMotivoDifTutor, consentimiento.getOtroMotivoDifTutor());
		cv.put(ConstantsDB.quePaisTutor, consentimiento.getQuePaisTutor());
		cv.put(ConstantsDB.alfabetoTutor, consentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, consentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, consentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, consentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, consentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, consentimiento.getApellidotest2());
		cv.put(ConstantsDB.otrorecurso1, consentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, consentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, consentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, consentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, consentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, consentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, consentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, consentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, consentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, consentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, consentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, consentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, consentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, consentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, consentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, consentimiento.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.ZIKA_TABLE, null, cv);
	}

	/**
	 * Borra todas las ConsentimientoZika de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosConsentimientoZika() {
		return mDb.delete(ConstantsDB.ZIKA_TABLE, null, null) > 0;
	}

	/**
	 * Actualiza un ConsentimientoZika en la base de datos.
	 * 
	 * @param ConsentimientoZika
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaConsentimientoZika(ConsentimientoZika consentimiento) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, consentimiento.getConsZikaId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, consentimiento.getConsZikaId().getFechaCons().getTime());
		cv.put(ConstantsDB.parteDDen, consentimiento.getParteDDen());
		cv.put(ConstantsDB.rechDDen, consentimiento.getRechDDen());
		cv.put(ConstantsDB.nombrept, consentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, consentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, consentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, consentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, consentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, consentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.mismoTutorSN, consentimiento.getMismoTutorSN());
		cv.put(ConstantsDB.motivoDifTutor, consentimiento.getMotivoDifTutor());
		cv.put(ConstantsDB.otroMotivoDifTutor, consentimiento.getOtroMotivoDifTutor());
		cv.put(ConstantsDB.quePaisTutor, consentimiento.getQuePaisTutor());
		cv.put(ConstantsDB.alfabetoTutor, consentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, consentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, consentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, consentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, consentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, consentimiento.getApellidotest2());
		cv.put(ConstantsDB.otrorecurso1, consentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, consentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, consentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, consentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, consentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, consentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, consentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, consentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, consentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, consentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, consentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, consentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, consentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, consentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, consentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, consentimiento.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.ZIKA_TABLE, cv, ConstantsDB.CODIGO + "=" 
				+ consentimiento.getConsZikaId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ consentimiento.getConsZikaId().getFechaCons().getTime(), null) > 0;
	}
	
	
	/**
	 * Inserta un CodigosCasas en la base de datos
	 * 
	 * @param CodigosCasas
	 *            Objeto CodigosCasas que contiene la informacion
	 *
	 */
	public void crearCodigosCasas(CodigosCasas ccs) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.TODAY, ccs.getFechaRegistro().getTime());
		cv.put(ConstantsDB.COD_CASA_R, ccs.getCodCasa());
		cv.put(ConstantsDB.COD_COMUN, ccs.getCodigoComun());
		cv.put(ConstantsDB.COD_RELA, ccs.getCodigoRelacionado());
		cv.put(ConstantsDB.USUARIO, ccs.getUsername());
		cv.put(ConstantsDB.STATUS, ccs.getEstado());
		mDb.insert(ConstantsDB.COD_REL_TABLE, null, cv);
	}
	
	/**
	 * Borra todas las CodigosCasas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarCodigosCasas() {
		return mDb.delete(ConstantsDB.COD_REL_TABLE, null, null) > 0;
	}
	
	
	/**
	 * Actualiza una CodigosCasas en la base de datos.
	 * 
	 * @param CodigosCasas
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaCodigosCasas(CodigosCasas ccs) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.TODAY, ccs.getFechaRegistro().getTime());
		cv.put(ConstantsDB.COD_CASA_R, ccs.getCodCasa());
		cv.put(ConstantsDB.COD_COMUN, ccs.getCodigoComun());
		cv.put(ConstantsDB.COD_RELA, ccs.getCodigoRelacionado());
		cv.put(ConstantsDB.USUARIO, ccs.getUsername());
		cv.put(ConstantsDB.STATUS, ccs.getEstado());
		return mDb.update(ConstantsDB.COD_REL_TABLE, cv, ConstantsDB.TODAY + "="
				+ ccs.getFechaRegistro().getTime(), null) > 0;
	}
	
	
	/**
	 * Inserta un CambiosCasas en la base de datos
	 * 
	 * @param CambiosCasas
	 *            Objeto CambiosCasas que contiene la informacion
	 *
	 */
	public void crearCambiosCasas(CambiosCasas ccs) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.TODAY, ccs.getFechaRegistro().getTime());
		cv.put(ConstantsDB.codigo, ccs.getCodigo());
		cv.put(ConstantsDB.codCasaAnterior, ccs.getCodCasaAnterior());
		cv.put(ConstantsDB.codCasaActual, ccs.getCodCasaActual());
		cv.put(ConstantsDB.USUARIO, ccs.getUsername());
		cv.put(ConstantsDB.STATUS, ccs.getEstado());
		mDb.insert(ConstantsDB.CAMB_CASA_TABLE, null, cv);
	}
	
	/**
	 * Borra todas las CambiosCasas de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarCambiosCasas() {
		return mDb.delete(ConstantsDB.CAMB_CASA_TABLE, null, null) > 0;
	}
	
	
	/**
	 * Actualiza una CambiosCasas en la base de datos.
	 * 
	 * @param CambiosCasas
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaCambiosCasas(CambiosCasas ccs) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.TODAY, ccs.getFechaRegistro().getTime());
		cv.put(ConstantsDB.codigo, ccs.getCodigo());
		cv.put(ConstantsDB.codCasaAnterior, ccs.getCodCasaAnterior());
		cv.put(ConstantsDB.codCasaActual, ccs.getCodCasaActual());
		cv.put(ConstantsDB.USUARIO, ccs.getUsername());
		cv.put(ConstantsDB.STATUS, ccs.getEstado());
		return mDb.update(ConstantsDB.CAMB_CASA_TABLE, cv, ConstantsDB.TODAY + "="
				+ ccs.getFechaRegistro().getTime(), null) > 0;
	}
	
	
	
	/**METODOS PARA RECONS 2015**/

	/**
	 * Inserta un reconsentimiento en la base de datos
	 * 
	 * @param reconsentimiento
	 *            Objeto ReConsentimientoDen que contiene la informacion
	 *
	 */
	public void crearReConsentimientoFlu2015(ReConsentimientoFlu2015 reconsentimiento) {
		ContentValues cv = new ContentValues();	
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsfluId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsfluId().getFechaCons().getTime());
		cv.put(ConstantsDB.visExit, reconsentimiento.getVisExit());
		cv.put(ConstantsDB.razonVisNoExit, reconsentimiento.getNoexitosa());
		cv.put(ConstantsDB.nombrept, reconsentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, reconsentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, reconsentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, reconsentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, reconsentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.alfabetoTutor, reconsentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, reconsentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, reconsentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, reconsentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, reconsentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, reconsentimiento.getApellidotest2());
		cv.put(ConstantsDB.cmDomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.otrobarrio, reconsentimiento.getOtrobarrio());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.telContacto1, reconsentimiento.getTelefContact());
		cv.put(ConstantsDB.telefonoConv1, reconsentimiento.getTelefonoConv1());
		cv.put(ConstantsDB.telefonoCel1, reconsentimiento.getTelefonoCel1());
		cv.put(ConstantsDB.telefonoCel2, reconsentimiento.getTelefonoCel2());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.parteAFlu, reconsentimiento.getParteAFlu());
		cv.put(ConstantsDB.parteBFlu, reconsentimiento.getParteBFlu());
		cv.put(ConstantsDB.parteCFlu, reconsentimiento.getParteCFlu());
		cv.put(ConstantsDB.rechFlu, reconsentimiento.getPorqueno());
		cv.put(ConstantsDB.contacto_futuro, reconsentimiento.getContacto_futuro());
		cv.put(ConstantsDB.local, reconsentimiento.getLocal());
		cv.put(ConstantsDB.otrorecurso1, reconsentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, reconsentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		mDb.insert(ConstantsDB.RECONSFLU_TABLE_2015, null, cv);
	}

	/**
	 * Borra todas las ReConsentimiento de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTodosReConsentimientosFlu2015() {
		return mDb.delete(ConstantsDB.RECONSFLU_TABLE_2015, null, null) > 0;
	}

	/**
	 * Actualiza un ReConsentimiento en la base de datos.
	 * 
	 * @param ReConsentimiento
	 *            Objeto que contiene la info
	 * @return verdadero o falso
	 */
	public boolean actualizaReConsentimientoFlu2015(ReConsentimientoFlu2015 reconsentimiento) {
		ContentValues cv = new ContentValues();
		cv.put(ConstantsDB.CODIGO, reconsentimiento.getReconsfluId().getCodigo());
		cv.put(ConstantsDB.FECHA_CONS, reconsentimiento.getReconsfluId().getFechaCons().getTime());
		cv.put(ConstantsDB.visExit, reconsentimiento.getVisExit());
		cv.put(ConstantsDB.razonVisNoExit, reconsentimiento.getNoexitosa());
		cv.put(ConstantsDB.nombrept, reconsentimiento.getNombrept());
		cv.put(ConstantsDB.nombrept2, reconsentimiento.getNombrept2());
		cv.put(ConstantsDB.apellidopt, reconsentimiento.getApellidopt());
		cv.put(ConstantsDB.apellidopt2, reconsentimiento.getApellidopt2());
		cv.put(ConstantsDB.relacionFam, reconsentimiento.getRelacionFam());
		cv.put(ConstantsDB.otraRelacionFam, reconsentimiento.getOtraRelacionFam());
		cv.put(ConstantsDB.alfabetoTutor, reconsentimiento.getAlfabetoTutor());
		cv.put(ConstantsDB.testigoSN, reconsentimiento.getTestigoSN());
		cv.put(ConstantsDB.nombretest1, reconsentimiento.getNombretest1());
		cv.put(ConstantsDB.nombretest2, reconsentimiento.getNombretest2());
		cv.put(ConstantsDB.apellidotest1, reconsentimiento.getApellidotest1());
		cv.put(ConstantsDB.apellidotest2, reconsentimiento.getApellidotest2());
		cv.put(ConstantsDB.cmDomicilio, reconsentimiento.getCmDomicilio());
		cv.put(ConstantsDB.barrio, reconsentimiento.getBarrio());
		cv.put(ConstantsDB.otrobarrio, reconsentimiento.getOtrobarrio());
		cv.put(ConstantsDB.dire, reconsentimiento.getDire());
		cv.put(ConstantsDB.telContacto1, reconsentimiento.getTelefContact());
		cv.put(ConstantsDB.telefonoConv1, reconsentimiento.getTelefonoConv1());
		cv.put(ConstantsDB.telefonoCel1, reconsentimiento.getTelefonoCel1());
		cv.put(ConstantsDB.telefonoCel2, reconsentimiento.getTelefonoCel2());
		cv.put(ConstantsDB.asentimiento, reconsentimiento.getAsentimiento());
		cv.put(ConstantsDB.parteAFlu, reconsentimiento.getParteAFlu());
		cv.put(ConstantsDB.parteBFlu, reconsentimiento.getParteBFlu());
		cv.put(ConstantsDB.parteCFlu, reconsentimiento.getParteCFlu());
		cv.put(ConstantsDB.rechFlu, reconsentimiento.getPorqueno());
		cv.put(ConstantsDB.contacto_futuro, reconsentimiento.getContacto_futuro());
		cv.put(ConstantsDB.local, reconsentimiento.getLocal());
		cv.put(ConstantsDB.otrorecurso1, reconsentimiento.getOtrorecurso1());
		cv.put(ConstantsDB.otrorecurso2, reconsentimiento.getOtrorecurso2());
		cv.put(ConstantsDB.ID_INSTANCIA, reconsentimiento.getMovilInfo().getIdInstancia());
		cv.put(ConstantsDB.FILE_PATH, reconsentimiento.getMovilInfo().getInstancePath());
		cv.put(ConstantsDB.STATUS, reconsentimiento.getMovilInfo().getEstado());
		cv.put(ConstantsDB.WHEN_UPDATED, reconsentimiento.getMovilInfo().getUltimoCambio());
		cv.put(ConstantsDB.START, reconsentimiento.getMovilInfo().getStart());
		cv.put(ConstantsDB.END, reconsentimiento.getMovilInfo().getEnd());
		cv.put(ConstantsDB.DEVICE_ID, reconsentimiento.getMovilInfo().getDeviceid());
		cv.put(ConstantsDB.SIM_SERIAL, reconsentimiento.getMovilInfo().getSimserial());
		cv.put(ConstantsDB.PHONE_NUMBER, reconsentimiento.getMovilInfo().getPhonenumber());
		cv.put(ConstantsDB.TODAY, reconsentimiento.getMovilInfo().getToday().getTime());
		cv.put(ConstantsDB.USUARIO, reconsentimiento.getMovilInfo().getUsername());
		cv.put(ConstantsDB.DELETED, reconsentimiento.getMovilInfo().getEliminado());
		cv.put(ConstantsDB.REC1, reconsentimiento.getMovilInfo().getRecurso1());
		cv.put(ConstantsDB.REC2, reconsentimiento.getMovilInfo().getRecurso2());
		return mDb.update(ConstantsDB.RECONSFLU_TABLE_2015, cv, ConstantsDB.CODIGO + "=" 
				+ reconsentimiento.getReconsfluId().getCodigo() + " and " +ConstantsDB.FECHA_CONS + "="
				+ reconsentimiento.getReconsfluId().getFechaCons().getTime(), null) > 0;
	}
	
	/**METODOS PARA TamizajeZikaCluster**/
	
	/**
	 * Inserta una TamizajeZikaCluster en la base de datos
	 * 
	 * @param TamizajeZikaCluster
	 *            Objeto TamizajeZikaCluster que contiene la informacion
	 *
	 */
	public void crearTamizajeZikaCluster(TamizajeZikaCluster tamizaje) {
		ContentValues cv = TamizajeZikaClusterHelper.crearTamizajeZikaClusterContentValues(tamizaje);
		mDb.insert(ConstantsDB.TAM_ZIKA_TABLE, null, cv);
	}
	
	/**
	 * Edita una TamizajeZikaCluster en la base de datos
	 * 
	 * @param TamizajeZikaCluster
	 *            Objeto TamizajeZikaCluster que contiene la informacion
	 *
	 */
	public boolean editarTamizajeZikaCluster(TamizajeZikaCluster tamizaje) {
		ContentValues cv = TamizajeZikaClusterHelper.crearTamizajeZikaClusterContentValues(tamizaje);
		return mDb.update(ConstantsDB.TAM_ZIKA_TABLE, cv, ConstantsDB.idTamizaje + "='" 
				+ tamizaje.getIdTamizaje() +"'", null) > 0;
	}
	
	/**
	 * Borra todos los TamizajeZikaCluster de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarTamizajeZikaCluster() {
		return mDb.delete(ConstantsDB.TAM_ZIKA_TABLE, null, null) > 0;
	}
	
	/**
	 * Obtiene una TamizajeZikaCluster de la base de datos
	 * 
	 * @return TamizajeZikaCluster
	 */
	public TamizajeZikaCluster getTamizajeZikaCluster(String filtro, String orden) throws SQLException {
		TamizajeZikaCluster mTamizajeZikaCluster = null;
		Cursor cursorTamizajeZikaCluster = crearCursor(ConstantsDB.TAM_ZIKA_TABLE, filtro, null, orden);
		if (cursorTamizajeZikaCluster != null && cursorTamizajeZikaCluster.getCount() > 0) {
			cursorTamizajeZikaCluster.moveToFirst();
			mTamizajeZikaCluster=TamizajeZikaClusterHelper.crearTamizajeZikaCluster(cursorTamizajeZikaCluster);
		}
		if (!cursorTamizajeZikaCluster.isClosed()) cursorTamizajeZikaCluster.close();
		return mTamizajeZikaCluster;
	}
	
	/**
	 * Obtiene una lista de TamizajeZikaCluster de la base de datos
	 * 
	 * @return List<TamizajeZikaCluster>
	 */
	public List<TamizajeZikaCluster> getTamizajeZikaClusters(String filtro, String orden) throws SQLException {
		List<TamizajeZikaCluster> mTamizajeZikaClusters = new ArrayList<TamizajeZikaCluster>();
		Cursor cursorTamizajeZikaCluster = crearCursor(ConstantsDB.TAM_ZIKA_TABLE, filtro, null, orden);
		if (cursorTamizajeZikaCluster != null && cursorTamizajeZikaCluster.getCount() > 0) {
			cursorTamizajeZikaCluster.moveToFirst();
			mTamizajeZikaClusters.clear();
			do{
				TamizajeZikaCluster mTamizajeZikaCluster = null;
				mTamizajeZikaCluster = TamizajeZikaClusterHelper.crearTamizajeZikaCluster(cursorTamizajeZikaCluster);
				mTamizajeZikaClusters.add(mTamizajeZikaCluster);
			} while (cursorTamizajeZikaCluster.moveToNext());
		}
		if (!cursorTamizajeZikaCluster.isClosed()) cursorTamizajeZikaCluster.close();
		return mTamizajeZikaClusters;
	}
	
	
	/**METODOS PARA CasaZikaCluster**/
	
	/**
	 * Inserta una CasaZikaCluster en la base de datos
	 * 
	 * @param CasaZikaCluster
	 *            Objeto CasaZikaCluster que contiene la informacion
	 *
	 */
	public void crearCasaZikaCluster(CasaZikaCluster casa) {
		ContentValues cv = CasaZikaClusterHelper.crearCasaZikaClusterContentValues(casa);
		mDb.insert(ConstantsDB.CASA_ZIKA_TABLE, null, cv);
	}
	
	/**
	 * Edita una CasaZikaCluster en la base de datos
	 * 
	 * @param CasaZikaCluster
	 *            Objeto CasaZikaCluster que contiene la informacion
	 *
	 */
	public boolean editarCasaZikaCluster(CasaZikaCluster casa) {
		ContentValues cv = CasaZikaClusterHelper.crearCasaZikaClusterContentValues(casa);
		return mDb.update(ConstantsDB.CASA_ZIKA_TABLE, cv, ConstantsDB.codigo_casa + "=" 
				+ casa.getCodigo_casa(), null) > 0;
	}
	
	/**
	 * Borra todos los CasaZikaCluster de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarCasaZikaCluster() {
		return mDb.delete(ConstantsDB.CASA_ZIKA_TABLE, null, null) > 0;
	}
	
	/**
	 * Obtiene una CasaZikaCluster de la base de datos
	 * 
	 * @return CasaZikaCluster
	 */
	public CasaZikaCluster getCasaZikaCluster(String filtro, String orden) throws SQLException {
		CasaZikaCluster mCasaZikaCluster = null;
		Cursor cursorCasaZikaCluster = crearCursor(ConstantsDB.CASA_ZIKA_TABLE, filtro, null, orden);
		if (cursorCasaZikaCluster != null && cursorCasaZikaCluster.getCount() > 0) {
			cursorCasaZikaCluster.moveToFirst();
			mCasaZikaCluster=CasaZikaClusterHelper.crearCasaZikaCluster(cursorCasaZikaCluster);
		}
		if (!cursorCasaZikaCluster.isClosed()) cursorCasaZikaCluster.close();
		return mCasaZikaCluster;
	}
	
	/**
	 * Obtiene una lista de CasaZikaCluster de la base de datos
	 * 
	 * @return List<CasaZikaCluster>
	 */
	public List<CasaZikaCluster> getCasaZikaClusters(String filtro, String orden) throws SQLException {
		List<CasaZikaCluster> mCasaZikaClusters = new ArrayList<CasaZikaCluster>();
		Cursor cursorCasaZikaCluster = crearCursor(ConstantsDB.CASA_ZIKA_TABLE, filtro, null, orden);
		if (cursorCasaZikaCluster != null && cursorCasaZikaCluster.getCount() > 0) {
			cursorCasaZikaCluster.moveToFirst();
			mCasaZikaClusters.clear();
			do{
				CasaZikaCluster mCasaZikaCluster = null;
				mCasaZikaCluster = CasaZikaClusterHelper.crearCasaZikaCluster(cursorCasaZikaCluster);
				mCasaZikaClusters.add(mCasaZikaCluster);
			} while (cursorCasaZikaCluster.moveToNext());
		}
		if (!cursorCasaZikaCluster.isClosed()) cursorCasaZikaCluster.close();
		return mCasaZikaClusters;
	}
	
	/**METODOS PARA ParticipanteZikaCluster**/
	
	/**
	 * Inserta una ParticipanteZikaCluster en la base de datos
	 * 
	 * @param ParticipanteZikaCluster
	 *            Objeto ParticipanteZikaCluster que contiene la informacion
	 *
	 */
	public void crearParticipanteZikaCluster(ParticipanteZikaCluster participante) {
		ContentValues cv = ParticipanteZikaClusterHelper.crearParticipanteZikaClusterContentValues(participante);
		mDb.insert(ConstantsDB.PART_ZIKA_TABLE, null, cv);
	}
	
	/**
	 * Edita una ParticipanteZikaCluster en la base de datos
	 * 
	 * @param ParticipanteZikaCluster
	 *            Objeto ParticipanteZikaCluster que contiene la informacion
	 *
	 */
	public boolean editarParticipanteZikaCluster(ParticipanteZikaCluster participante) {
		ContentValues cv = ParticipanteZikaClusterHelper.crearParticipanteZikaClusterContentValues(participante);
		return mDb.update(ConstantsDB.PART_ZIKA_TABLE, cv, ConstantsDB.codigo + "=" 
				+ participante.getCodigo(), null) > 0;
	}
	
	/**
	 * Borra todos los ParticipanteZikaCluster de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarParticipanteZikaCluster() {
		return mDb.delete(ConstantsDB.PART_ZIKA_TABLE, null, null) > 0;
	}
	
	/**
	 * Obtiene una ParticipanteZikaCluster de la base de datos
	 * 
	 * @return ParticipanteZikaCluster
	 */
	public ParticipanteZikaCluster getParticipanteZikaCluster(String filtro, String orden) throws SQLException {
		ParticipanteZikaCluster mParticipanteZikaCluster = null;
		Cursor cursorParticipanteZikaCluster = crearCursor(ConstantsDB.PART_ZIKA_TABLE, filtro, null, orden);
		if (cursorParticipanteZikaCluster != null && cursorParticipanteZikaCluster.getCount() > 0) {
			cursorParticipanteZikaCluster.moveToFirst();
			mParticipanteZikaCluster=ParticipanteZikaClusterHelper.crearParticipanteZikaCluster(cursorParticipanteZikaCluster);
		}
		if (!cursorParticipanteZikaCluster.isClosed()) cursorParticipanteZikaCluster.close();
		return mParticipanteZikaCluster;
	}
	
	/**
	 * Obtiene una lista de ParticipanteZikaCluster de la base de datos
	 * 
	 * @return List<ParticipanteZikaCluster>
	 */
	public List<ParticipanteZikaCluster> getParticipanteZikaClusters(String filtro, String orden) throws SQLException {
		List<ParticipanteZikaCluster> mParticipanteZikaClusters = new ArrayList<ParticipanteZikaCluster>();
		Cursor cursorParticipanteZikaCluster = crearCursor(ConstantsDB.PART_ZIKA_TABLE, filtro, null, orden);
		if (cursorParticipanteZikaCluster != null && cursorParticipanteZikaCluster.getCount() > 0) {
			cursorParticipanteZikaCluster.moveToFirst();
			mParticipanteZikaClusters.clear();
			do{
				ParticipanteZikaCluster mParticipanteZikaCluster = null;
				mParticipanteZikaCluster = ParticipanteZikaClusterHelper.crearParticipanteZikaCluster(cursorParticipanteZikaCluster);
				mParticipanteZikaClusters.add(mParticipanteZikaCluster);
			} while (cursorParticipanteZikaCluster.moveToNext());
		}
		if (!cursorParticipanteZikaCluster.isClosed()) cursorParticipanteZikaCluster.close();
		return mParticipanteZikaClusters;
	}
	
	
	/**METODOS PARA SintomasZikaCluster**/
	
	/**
	 * Inserta una SintomasZikaCluster en la base de datos
	 * 
	 * @param SintomasZikaCluster
	 *            Objeto SintomasZikaCluster que contiene la informacion
	 *
	 */
	public void crearSintomasZikaCluster(SintomasZikaCluster sintomas) {
		ContentValues cv = SintomasZikaClusterHelper.crearSintomasZikaClusterContentValues(sintomas);
		mDb.insert(ConstantsDB.SINT_ZIKA_TABLE, null, cv);
	}
	
	/**
	 * Edita una SintomasZikaCluster en la base de datos
	 * 
	 * @param SintomasZikaCluster
	 *            Objeto SintomasZikaCluster que contiene la informacion
	 *
	 */
	public boolean editarSintomasZikaCluster(SintomasZikaCluster sintomas) {
		ContentValues cv = SintomasZikaClusterHelper.crearSintomasZikaClusterContentValues(sintomas);
		return mDb.update(ConstantsDB.SINT_ZIKA_TABLE, cv, ConstantsDB.idSintoma + "='" 
				+ sintomas.getIdSintoma()+"'", null) > 0;
	}
	
	/**
	 * Borra todos los SintomasZikaCluster de la base de datos
	 * 
	 * @return verdadero o falso
	 */
	public boolean borrarSintomasZikaCluster() {
		return mDb.delete(ConstantsDB.SINT_ZIKA_TABLE, null, null) > 0;
	}
	
	/**
	 * Obtiene una SintomasZikaCluster de la base de datos
	 * 
	 * @return SintomasZikaCluster
	 */
	public SintomasZikaCluster getSintomasZikaCluster(String filtro, String orden) throws SQLException {
		SintomasZikaCluster mSintomasZikaCluster = null;
		Cursor cursorSintomasZikaCluster = crearCursor(ConstantsDB.SINT_ZIKA_TABLE, filtro, null, orden);
		if (cursorSintomasZikaCluster != null && cursorSintomasZikaCluster.getCount() > 0) {
			cursorSintomasZikaCluster.moveToFirst();
			mSintomasZikaCluster=SintomasZikaClusterHelper.crearSintomasZikaCluster(cursorSintomasZikaCluster);
		}
		if (!cursorSintomasZikaCluster.isClosed()) cursorSintomasZikaCluster.close();
		return mSintomasZikaCluster;
	}
	
	/**
	 * Obtiene una lista de SintomasZikaCluster de la base de datos
	 * 
	 * @return List<SintomasZikaCluster>
	 */
	public List<SintomasZikaCluster> getSintomasZikaClusters(String filtro, String orden) throws SQLException {
		List<SintomasZikaCluster> mSintomasZikaClusters = new ArrayList<SintomasZikaCluster>();
		Cursor cursorSintomasZikaCluster = crearCursor(ConstantsDB.SINT_ZIKA_TABLE, filtro, null, orden);
		if (cursorSintomasZikaCluster != null && cursorSintomasZikaCluster.getCount() > 0) {
			cursorSintomasZikaCluster.moveToFirst();
			mSintomasZikaClusters.clear();
			do{
				SintomasZikaCluster mSintomasZikaCluster = null;
				mSintomasZikaCluster = SintomasZikaClusterHelper.crearSintomasZikaCluster(cursorSintomasZikaCluster);
				mSintomasZikaClusters.add(mSintomasZikaCluster);
			} while (cursorSintomasZikaCluster.moveToNext());
		}
		if (!cursorSintomasZikaCluster.isClosed()) cursorSintomasZikaCluster.close();
		return mSintomasZikaClusters;
	}
	
	

	/**
	 * Crea un cursor desde la base de datos
	 * 
	 * @return cursor
	 */
	public Cursor crearCursor(String tabla, String whereString, String projection[], String ordenString) throws SQLException {
		Cursor c = null;
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(tabla);
		c = qb.query(mDb,projection,whereString,null,null,null,ordenString);
		return c;
	}
}
