/*
 * Copyright (C) 2013 ICS.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ni.org.ics.estudios.cohorte.muestreoanual.utils;

/**
 * Constantes usadas en la base de datos de la aplicacion
 * 
 * @author William Aviles
 * 
 */
public class ConstantsDB {

	public static final String VIS_EXITO = "VisitaExitosa";
	
	//Base de datos y tablas
	public static final String DATABASE_NAME = "cohorte.sqlite3";
	public static final int DATABASE_VERSION = 3;
	public static final String USER_TABLE = "usuarios";
	public static final String ROLE_TABLE = "roles";
	public static final String CASA_TABLE = "casas";
	public static final String PART_TABLE = "participantes";
	public static final String ENC_CASA_TABLE = "encuestacasas";
	public static final String ENC_PART_TABLE = "encuestaparticipantes";
	public static final String LACT_TABLE = "lactanciamaterna";
	public static final String PT_TABLE = "pesoytalla";
	public static final String MUESTRA_TABLE = "muestras";
	public static final String OB_TABLE = "obsequios";
	public static final String VAC_TABLE = "vacunas";
	public static final String VIS_TABLE = "visitasterreno";
	public static final String RECONS_TABLE = "reconsentimientoden";
	public static final String RECONS_TABLE_2015 = "reconsentimientoden2015";
	public static final String RECONSFLU_TABLE_2015 = "reconsentimientoflu2015";
	public static final String ZIKA_TABLE = "consentimientozika";
	public static final String CONSCHIK_TABLE = "consentimientochik";
	public static final String CEST_TABLE = "cambioestudio";
	public static final String BHC_TABLE = "recepcionbhc";
	public static final String SERO_TABLE = "recepcionsero";
	public static final String TPBMC_TABLE = "temp_pbmc";
	public static final String TRB_TABLE = "temp_rojo_bhc";
	public static final String PIN_TABLE = "pinchazos";
	public static final String ENC_SAT_TABLE = "encuestasatisfaccion";
	public static final String NO_DATA_TABLE = "nodata";
	public static final String COD_REL_TABLE = "codigos_casas";
	public static final String CAMB_CASA_TABLE = "cambios_casas";
	
	//Tablas ZIKA
	public static final String TAM_ZIKA_TABLE = "tamizajes_zika";
	public static final String CASA_ZIKA_TABLE = "casas_zika";
	public static final String PART_ZIKA_TABLE = "participantes_zika";

	//Campos roles
	public static final String AUTH = "authority";

	//Campos usuarios
	public static final String USERNAME = "username";
	public static final String ENABLED = "enabled";
	public static final String PASSWORD = "password";
	public static final String U_MUESTRA = "muestra";
	public static final String U_ECASA = "ecasa";
	public static final String U_EPART = "eparticipante";
	public static final String U_ELACT = "elactancia";
	public static final String U_ESAT = "esatisfaccion";
	public static final String U_OBSEQUIO = "obsequio";
	public static final String U_PYT = "pesotalla";
	public static final String U_VAC = "vacunas";
	public static final String U_VISITA = "visitas";
	public static final String U_RECEPCION = "recepcion";
	public static final String U_CONS = "consentimiento";
	public static final String U_CASAZIKA = "casazika";
	public static final String U_TAMZIKA = "tamizajezika";

	//Campos casa
	public static final String COD_CASA = "codCasa";
	public static final String BARRIO = "barrio";
	public static final String DIRECCION = "direccion";
	public static final String MANZANA = "manzana";
	public static final String COORD = "coordenadas";
	public static final String LATITUD = "latitud";
	public static final String LONGITUD = "longitud";
	public static final String TEL_CASA = "telCasa";
	public static final String NOM_JEFE = "jefenom";
	public static final String NOM_JEFE_2 = "jefenom2";
	public static final String APE_JEFE = "jefeap";
	public static final String APE_JEFE_2 = "jefeap2";
	public static final String TELEFONO1 = "telefono1";
	public static final String TELEFONO2 = "telefono2";
	public static final String NOMCONTACTO = "nom_contacto";
	public static final String DIRCONTACTO = "dire_contacto";
	public static final String BARRIOCONTACTO = "barrio_contacto";
	public static final String OBARRIOCONTACTO = "otrobarriocontacto";
	public static final String TELCONTACTO1 = "tel_contacto1";
	public static final String TELCONTACTO2 = "tel_contacto2";
	public static final String VIVIENDA = "vivienda";
	public static final String RESD = "resd";
	public static final String INTEN = "inten";
	public static final String ENC_CASA = "en_casa";

	//Campos participante
	public static final String CODIGO = "codigo";
	public static final String FECHA = "fecha";
	public static final String ESTADO_PAR = "est_par";
	public static final String NOMBRE1 = "nombre1";
	public static final String NOMBRE2 = "nombre2";
	public static final String APELLIDO1 = "apellido1";
	public static final String APELLIDO2 = "apellido2";
	public static final String SEXO = "sexo";
	public static final String FECHANAC = "fechanac";
	public static final String EDAD = "edad";
	public static final String NOMBREPT1 = "nombre_pt1";
	public static final String NOMBREPT2 = "nombre_pt2";
	public static final String APELLIDOPT1 = "apellido_pt1";
	public static final String APELLIDOPT2 = "apellido_pt2";
	public static final String RELFAMT = "relacion_fam";
	public static final String NOMPADRE = "nombre_padre";
	public static final String NOMMADRE = "nombre_madre";
	public static final String ASISTE = "asiste";
	public static final String US = "us";
	public static final String HIDENG = "hideng";
	public static final String CUANDEN = "cuanDeng";
	public static final String HOSPDEN = "hosp_deng";
	public static final String CUANHOSPDEN = "cuandhospdeng";
	public static final String ESTUDIO = "estudio";
	public static final String PBMC = "pbmc";
	public static final String CONSFLU = "cons_flu";
	public static final String CONSDENG = "cons_deng";
	public static final String ZIKA = "zika";
	public static final String ADN = "adn";
	public static final String CONSCHIK = "cons_chik";
	public static final String MUESTRA = "conmx";
	public static final String MUESTRABHC = "conmxbhc";
	public static final String LACT_MAT = "enc_lacmat";
	public static final String PESOTALLA = "peso_talla";
	public static final String ENC_PAR = "en_part";
	public static final String OBSEQUIO = "obsequio";
	public static final String CONVAL = "convalesciente";
	public static final String INFOVAC = "info_vacuna";
	public static final String PAXGENE = "paxgene";
	public static final String RETOMA = "retoma";
	public static final String VOLRETOMA = "vol_retoma";
	public static final String MANZANA_PART = "manzana_participante";
	public static final String BARRIO_PART = "barrio_participante";
	public static final String BARRIO_DESC = "barrio_descripcion";
	public static final String DIRE_FICHA1 = "direccion_ficha1";
	public static final String RECONSDENG = "recons_deng";
	public static final String CONPTO = "conpto";
	

	//Campos encuesta casa
	public static final String FECHA_ENC_CASA = "fecha_encuesta";
	public static final String CVIVEN1 = "cvivencasa1";
	public static final String CVIVEN2 = "cvivencasa2";
	public static final String CVIVEN3 = "cvivencasa3";
	public static final String CVIVEN4 = "cvivencasa4";
	public static final String CVIVEN5 = "cvivencasa5";
	public static final String CVIVEN6 = "cvivencasa6";
	public static final String CCUARTOS = "ccuartos";
	public static final String GRIFO = "grifo";
	public static final String GRIFOCOM = "grifocomsn";
	public static final String HORASAGUA = "horasagua";
	public static final String MCASA = "mcasa";
	public static final String OCASA = "ocasa";
	public static final String PISO = "piso";
	public static final String OPISO = "opiso";
	public static final String TECHO = "techo";
	public static final String OTECHO = "otecho";
	public static final String CPROPIA = "cpropia";
	public static final String ABANICOS = "cabanicos";
	public static final String TVS = "ctelevisores";
	public static final String REFRI = "crefrigeradores";
	public static final String MOTO = "moto";
	public static final String CARRO = "carro";
	public static final String LENA = "cocinalena";
	public static final String ANIMALES = "animalessn";
	public static final String POLLOS = "pollos";
	public static final String POLLOSCASA = "polloscasa";
	public static final String PATOS = "patos";
	public static final String PATOSCASA = "patoscasa";
	public static final String PERROS = "perros";
	public static final String PERROSCASA = "perroscasa";
	public static final String GATOS = "gatos";
	public static final String GATOSCASA = "gatoscasa";
	public static final String CERDOS = "cerdos";
	public static final String CERDOSCASA = "cerdoscasa";

	//Campos encuesta participante
	public static final String FECHA_ENC_PAR = "fecha_encuesta";
	public static final String FIEBRE = "fiebre";
	public static final String TFIEBRE = "tiemfieb";
	public static final String LUGCONS = "lugarcons";
	public static final String NOCS = "nocs";
	public static final String AUTOMED = "automed";
	public static final String ESC = "escuela";
	public static final String GRADO = "grado";
	public static final String TURNO = "turno";
	public static final String NESC = "nescuela";
	public static final String OESC = "otraescuela";
	public static final String CUIDAN = "cuidan";
	public static final String CCUIDAN = "cuantoscuidan";
	public static final String CQVIVE = "cqvive";
	public static final String LUGPARTO = "num_parto";
	public static final String PAPAALF = "papaalf";
	public static final String PAPANIVEL = "papanivel";
	public static final String PAPATRA = "papatra";
	public static final String PAPATIPOT = "papatipotra";
	public static final String MAMAALF = "mamaalf";
	public static final String MAMANIVEL = "mamanivel";
	public static final String MAMATRA = "mamatra";
	public static final String MAMATIPOT = "mamatipotra";
	public static final String COMPARTEHAB = "compartehab";
	public static final String HAB1 = "hab1";
	public static final String HAB2 = "hab2";
	public static final String HAB3 = "hab3";
	public static final String HAB4 = "hab4";
	public static final String HAB5 = "hab5";
	public static final String HAB6 = "hab6";
	public static final String COMPARTECAMA = "compartecama";
	public static final String CAMA1 = "cama1";
	public static final String CAMA2 = "cama2";
	public static final String CAMA3 = "cama3";
	public static final String CAMA4 = "cama4";
	public static final String CAMA5 = "cama5";
	public static final String CAMA6 = "cama6";
	public static final String ASMA = "asma";
	public static final String SILB12 = "silb12m";
	public static final String SIT1 = "sitresf";
	public static final String SIT2 = "sitejer";
	public static final String SILB01 = "silbmespas";
	public static final String DIFHAB = "difhablar";
	public static final String VECDIFHAB = "vechablar";
	public static final String DIFDOR = "difdormir";
	public static final String SUENOPER = "suenoper";
	public static final String TOS12 = "tos12m";
	public static final String VECESTOS = "vecestos";
	public static final String TOS3DIAS = "tos3dias";
	public static final String HOSP12M = "hosp12m";
	public static final String MED12M = "med12m";
	public static final String DEP12M = "dep12m";
	public static final String CRISIS = "crisis";
	public static final String FRECASMA = "frecasma";
	public static final String FUMA = "fumasn";
	public static final String QUIENFUMA = "quienfuma";
	public static final String CIGMADRE = "cant_cigarros_madre";
	public static final String CIGOTRO = "cant_cigarros_otros";
	public static final String CIGPADRE = "cant_cigarros_padre";
	
	public static final String rash = "rash";
	public static final String mesActual = "mesActual";
	public static final String yearActual = "yearActual";
	public static final String rash_year = "rash_year";
	public static final String rash_mes = "rash_mes";
	public static final String rash_mesact = "rash_mesact";
	public static final String rashCara = "rashCara";
	public static final String rashMiembrosSup = "rashMiembrosSup";
	public static final String rashTorax = "rashTorax";
	public static final String rashAbdomen = "rashAbdomen";
	public static final String rashMiembrosInf = "rashMiembrosInf";
	public static final String rashDias = "rashDias";
	public static final String ojoRojo = "ojoRojo";
	public static final String ojoRojo_year = "ojoRojo_year";
	public static final String ojoRojo_mes = "ojoRojo_mes";
	public static final String ojoRojo_mesact = "ojoRojo_mesact";
	public static final String ojoRojo_Dias = "ojoRojo_Dias";
	public static final String hormigueo = "hormigueo";
	public static final String hormigueo_year = "hormigueo_year";
	public static final String hormigueo_mes = "hormigueo_mes";
	public static final String hormigueo_mesact = "hormigueo_mesact";
	public static final String hormigueo_Dias = "hormigueo_Dias";
	public static final String consultaRashHormigueo = "consultaRashHormigueo";
	public static final String uSaludRashHormigueo = "uSaludRashHormigueo";
	public static final String cSaludRashHormigueo = "cSaludRashHormigueo";
	public static final String oCSRashHormigueo = "oCSRashHormigueo";
	public static final String pSRashHormigueo = "pSRashHormigueo";
	public static final String oPSRashHormigueo = "oPSRashHormigueo";
	public static final String diagRashHormigueo = "diagRashHormigueo";	
	public static final String chPapaMama = "chPapaMama";	
	public static final String fechana_papa = "fechana_papa";	
	public static final String cal_edad_papa = "cal_edad_papa";	
	public static final String cal_edad2_papa = "cal_edad2_papa";	
	public static final String nombpapa1 = "nombpapa1";	
	public static final String nombpapa2 = "nombpapa2";	
	public static final String apellipapa1 = "apellipapa1";	
	public static final String apellipapa2 = "apellipapa2";	
	public static final String fechana_mama = "fechana_mama";
	public static final String cal_edad_mama = "cal_edad_mama";
	public static final String cal_edad2_mama = "cal_edad2_mama";
	public static final String nombmama1 = "nombmama1";
	public static final String nombmama2 = "nombmama2";
	public static final String apellimama1 = "apellimama1";
	public static final String apellimama2 = "apellimama2";
	
	//Campos encuesta lactancia materna
	public static final String FECHA_ENC_LACT = "fecha_encuesta";
	public static final String DIOPECHO = "diopecho";
	public static final String TIEMPECHO = "tiempecho";
	public static final String MESDIOPECHO = "mesdiopecho";
	public static final String PECHOEXC = "pechoexc";
	public static final String PECHOEXCANT = "pechoexcantes";
	public static final String TPECHOEXCANT = "tiempopechoexcantes";
	public static final String MPECHOEXCANT = "mespechoexcantes";
	public static final String FORMALIM = "formalim";
	public static final String OTRALIM = "otraalim";
	public static final String EDADLIQDP = "edadliqdistpecho";
	public static final String MESLIQDL = "mesdioliqdisleche";
	public static final String EDADLIQDL = "edadliqdistleche";
	public static final String MESLIQDP = "mesdioliqdispecho";
	public static final String EDADALIMS = "edalimsolidos";
	public static final String MESALIMS = "mesdioalimsol";

	//Campos peso y talla
	public static final String FECHA_PT = "fecha_pt";
	public static final String PESO1 = "peso1";
	public static final String PESO2 = "peso2";
	public static final String PESO3 = "peso3";
	public static final String TALLA1 = "talla1";
	public static final String TALLA2 = "talla2";
	public static final String TALLA3 = "talla3";
	public static final String IMC1 = "imc1";
	public static final String IMC2 = "imc2";
	public static final String IMC3 = "imc3";
	public static final String DIFPESO = "difpeso";
	public static final String DIFTALLA = "diftalla";

	//Campos muestras
	public static final String FECHA_MUESTRA = "fecha_muestra";
	public static final String MFIEBRE = "fiebre";
	public static final String CONSULTA = "consulta";
	public static final String BHC = "tuboBHC";
	public static final String ROJO = "tuboRojo";
	public static final String LEU = "tuboLeu";
	
	public static final String bhc_razonNo = "bhc_razonNo";
	public static final String bhc_otraRazonNo = "bhc_otraRazonNo";
	public static final String rojo_razonNo = "rojo_razonNo";
	public static final String rojo_otraRazonNo = "rojo_otraRazonNo";
	public static final String pbmc_razonNo = "pbmc_razonNo";
	public static final String pbmc_otraRazonNo = "pbmc_otraRazonNo";
	public static final String horaBHC = "horaBHC";
	public static final String horaPBMC = "horaPBMC";
	
	public static final String horaInicioPax = "horaInicioPax";
	public static final String horaFinPax = "horaFinPax";
	public static final String codPax = "codPax";
	public static final String terreno = "terreno";
	
	
	public static final String PIN = "pinchazos";

	//Campos obsequios
	public static final String FECHA_OB = "fecha_ob";
	public static final String OBSEQ = "obseqsn";
	public static final String CARNET = "carnetsn";
	public static final String PERRETIRA = "persona_retira";
	public static final String PERRETIRAREL = "rel_fam";
	public static final String PERRETIRAOREL = "o_rel_fam";
	public static final String OBS_TEL = "telefono";
	public static final String CDOM = "cdom";
	public static final String OBS = "observaciones";


	//Campos vacunas
	public static final String FECHA_VACUNA = "fecha_vacuna";
	public static final String VACUNA = "vacuna";
	public static final String FV = "fechaVacunado";
	public static final String TIPOVAC = "tipovacuna";
	public static final String TARJETA = "tarjetasn";
	public static final String NDOSIS = "ndosis";
	public static final String FECHAINF1 = "fechainf1";
	public static final String FECHAINF2 = "fechainf2";
	public static final String FECHAINF3 = "fechainf3";
	public static final String FECHAINF4 = "fechainf4";
	public static final String FECHAINF5 = "fechainf5";
	public static final String FECHAINF6 = "fechainf6";
	public static final String FECHAINF7 = "fechainf7";
	public static final String FECHAINF8 = "fechainf8";
	public static final String FECHAINF9 = "fechainf9";
	public static final String FECHAINF10 = "fechainf10";

	//Campos visitasterreno 
	public static final String FECHA_VISITA = "fecha_visita";
	public static final String VISITASN = "visitasn";
	public static final String MOTNOVIS = "motnovisita";
	public static final String ACOMP_VIS = "acomp";
	public static final String REL_VIS = "relacion_fam";
	public static final String ASENT_VIS = "asentimiento";
	public static final String CDOM_VIS = "cdom";
	public static final String BARRIO_VIS = "barrio";
	public static final String MANZ_VIS = "manzana";
	public static final String DIRE_VIS = "direccion";
	public static final String COORD_VIS = "coordenadas";
	public static final String LAT_VIS = "latitud";
	public static final String LON_VIS = "longitud";

	//Campos reconsentimiento
	public static final String FECHA_CONS = "fecha_cons";
	public static final String autsup = "autsup";
	public static final String parteaden = "parteaden";
	public static final String rechazoden = "rechazoden";
	public static final String partefden = "partefden";
	public static final String otrorechazoden = "otrorechazoden";
	public static final String incden = "incden";
	public static final String autsup2 = "autsup2";
	public static final String excden = "excden";
	public static final String enfcronsn = "enfcronsn";
	public static final String enfCronica = "enfCronica";
	public static final String oEnfCronica = "oEnfCronica";
	public static final String tomatx = "tomatx";
	public static final String cualestx = "cualestx";
	public static final String autsup3 = "autsup3";
	public static final String cmdomicilio = "cmdomicilio";
	public static final String barrio = "barrio";
	public static final String autsup4 = "autsup4";
	public static final String dire = "dire";
	public static final String manzana = "manzana";
	public static final String telefono = "telefono";	
	public static final String asentimiento = "asentimiento";
	public static final String partebden = "partebden";
	public static final String partecden = "partecden";
	public static final String partedden = "partedden";
	public static final String asentimientoesc = "asentimientoesc";
	public static final String parteeden = "parteeden";
	public static final String firmcarta = "firmcarta";
	public static final String relacionfam = "relacionfam";
	public static final String coordenadas = "coordenadas";
	
	//Campos cambio estudio
	public static final String FECHA_CAMBIO = "fecha_cambio";
	public static final String parteaflu = "parteaflu";
	public static final String rechazoflu = "rechazoflu";
	public static final String partebflu = "partebflu";
	public static final String partecflu = "partecflu";
	public static final String incflu = "incflu";
	public static final String excflu = "excflu";

	//Campos recepcion BHC
	public static final String FECHA_BHC = "fecha_bhc";
	public static final String VOLBHC = "volbhc";
	public static final String LUGAR = "lugar_toma";
	public static final String OBSBHC = "observacion";

	//Campos recepcion SERO
	public static final String FECHA_SERO = "fecha_sero";
	public static final String VOLSERO = "volsero";
	public static final String OBSSERO = "observacion";


	//Campos temperatura PBMC y RojoBhc
	public static final String FECHA_TEMP = "fecha_temp";
	public static final String RECURSO = "recurso";
	public static final String TEMP = "temperatura";
	public static final String LUGARTEMP = "lugar_temp";
	public static final String OBSTEMP = "observacion";

	//Campos no data
	public static final String RAZON = "razon";
	public static final String ORAZON = "orazon";
	
	//Campos codigos casas
	public static final String COD_CASA_R = "codCasa";
	public static final String COD_COMUN = "codigoComun";
	public static final String COD_RELA = "codigoRelacionado";
	
	//Campos cambios casas
	public static final String codigo = "codigo";
	public static final String codCasaAnterior = "codCasaAnterior";
	public static final String codCasaActual = "codCasaActual";

	//Campos pinchazos
	public static final String FECHA_PIN = "fecha_pinchazo";
	public static final String PINCHAZOS = "num_pin";
	public static final String OBSPIN = "observacion";

	//Campos encuesta satisfaccion
	public static final String FECHA_ENC_SAT = "fecha_encuesta";
	public static final String ESTUDIOSAT="estudio";
	public static final String ATENPEREST="atenperest";
	public static final String TIEMATEN="tiematen";
	public static final String ATENPERADM="atenperadm";
	public static final String ATENPERENFERM="atenperenferm";
	public static final String ATENPERMED="atenpermed";
	public static final String AMBATEN="ambaten";
	public static final String ATENPERLAB="atenperlab";
	public static final String EXPLDXENF="expldxenf";
	public static final String FLUDENSN="fludensn";
	public static final String FLUCONIMP="fluconimp";
	public static final String DENCONIMP="denconimp";
	public static final String EXPLPELIGENF="explpeligenf";
	public static final String EXPMEDCUID="expmedcuid";

	//Campos comunes para manejo ODK
	public static final String ID_INSTANCIA = "id_instancia";
	public static final String FILE_PATH = "path_instancia";
	public static final String STATUS = "estado";
	public static final String WHEN_UPDATED = "ultimo_cambio";

	//Campos comunes para metadata movil
	public static final String START = "creado";
	public static final String END = "finalizado";
	public static final String DEVICE_ID = "identificador_equipo";
	public static final String SIM_SERIAL = "serie_sim";
	public static final String PHONE_NUMBER = "numero_telefono";
	public static final String TODAY = "fecha_registro";
	public static final String USUARIO = "username";
	public static final String DELETED = "eliminado";
	public static final String REC1 = "recurso1";
	public static final String REC2 = "recurso2";
	
	//Campos reconsentimiento 2015
	
	public static final String visExit = "visExit";
	public static final String razonVisNoExit = "razonVisNoExit";
	public static final String personaDejoCarta = "personaDejoCarta";
	public static final String personaCasa = "personaCasa";
	public static final String relacionFamPersonaCasa = "relacionFamPersonaCasa";
	public static final String otraRelacionPersonaCasa = "otraRelacionPersonaCasa";
	public static final String telefonoPersonaCasa = "telefonoPersonaCasa";
	public static final String emancipado = "emancipado";
	public static final String descEmancipado = "descEmancipado";
	public static final String incDen = "incDen";
	public static final String excDen = "excDen";
	public static final String enfCronSN = "enfCronSN";
	//public static final String enfCronica = "enfCronica";
	//public static final String oEnfCronica = "oEnfCronica";
	public static final String tomaTx = "tomaTx";
	public static final String cualesTx = "cualesTx";
	public static final String assite = "assite";
	public static final String centrosalud = "centrosalud";
	public static final String ocentrosalud = "ocentrosalud";
	public static final String puestosalud = "puestosalud";
	//public static final String asentimiento = "asentimiento";
	public static final String parteADen = "parteADen";
	public static final String parteBDen = "parteBDen";
	public static final String parteCDen = "parteCDen";
	public static final String parteDDen = "parteDDen";
	public static final String parteAFlu = "parteAFlu";
	public static final String parteBFlu = "parteBFlu";
	public static final String parteCFlu = "parteCFlu";
	public static final String rechDen = "rechDen";
	public static final String rechDDen = "rechDDen";
	public static final String rechFlu = "rechFlu";
	public static final String contacto_futuro = "contacto_futuro";
	public static final String nombrept = "nombrept";
	public static final String nombrept2 = "nombrept2";
	public static final String apellidopt = "apellidopt";
	public static final String apellidopt2 = "apellidopt2";
	public static final String relacionFam = "relacionFam";
	public static final String otraRelacionFam = "otraRelacionFam";
	public static final String mismoTutorSN = "mismoTutorSN";
	public static final String motivoDifTutor = "motivoDifTutor";
	public static final String otroMotivoDifTutor = "otroMotivoDifTutor";
	public static final String quePaisTutor = "quePaisTutor";
	public static final String alfabetoTutor = "alfabetoTutor";
	public static final String testigoSN = "testigoSN";
	public static final String nombretest1 = "nombretest1";
	public static final String nombretest2 = "nombretest2";
	public static final String apellidotest1 = "apellidotest1";
	public static final String apellidotest2 = "apellidotest2";
	public static final String cmDomicilio = "cmDomicilio";
	//public static final String barrio = "barrio";
	public static final String otrobarrio = "otrobarrio";
	//public static final String dire = "dire";
	//public static final String autsup = "autsup";
	public static final String telefonoClasif1 = "telefonoClasif1";
	public static final String telefonoConv1 = "telefonoConv1";
	public static final String telefonoCel1 = "telefonoCel1";
	public static final String telefono2SN = "telefono2SN";
	public static final String telefonoClasif2 = "telefonoClasif2";
	public static final String telefonoConv2 = "telefonoConv2";
	public static final String telefonoCel2 = "telefonoCel2";
	public static final String telefono3SN = "telefono3SN";
	public static final String telefonoClasif3 = "telefonoClasif3";
	public static final String telefonoConv3 = "telefonoConv3";
	public static final String telefonoCel3 = "telefonoCel3";
	public static final String jefenom = "jefenom";
	public static final String jefenom2 = "jefenom2";
	public static final String jefeap = "jefeap";
	public static final String jefeap2 = "jefeap2";
	public static final String nomContacto = "nomContacto";
	public static final String barrioContacto = "barrioContacto";
	public static final String otrobarrioContacto = "otrobarrioContacto";
	public static final String direContacto = "direContacto";
	public static final String telContacto1 = "telContacto1";
	public static final String telContactoConv1 = "telContactoConv1";
	public static final String telContactoCel1 = "telContactoCel1";
	public static final String telContacto2SN = "telContacto2SN";
	public static final String telContactoClasif2 = "telContactoClasif2";
	public static final String telContactoConv2 = "telContactoConv2";
	public static final String telContactoCel2 = "telContactoCel2";
	public static final String nombrepadre = "nombrepadre";
	public static final String nombrepadre2 = "nombrepadre2";
	public static final String apellidopadre = "apellidopadre";
	public static final String apellidopadre2 = "apellidopadre2";
	public static final String nombremadre = "nombremadre";
	public static final String nombremadre2 = "nombremadre2";
	public static final String apellidomadre = "apellidomadre";
	public static final String apellidomadre2 = "apellidomadre2";
	public static final String copiaFormato = "copiaFormato";
	public static final String firmo_cartcons = "firmo_cartcons";
	public static final String fecho_cartcons = "fecho_cartcons";
	public static final String huella_dig = "huella_dig";
	public static final String fech_firm_testigo = "fech_firm_testigo";
	public static final String entiende = "entiende";
	public static final String georef = "georef";
	public static final String Manzana = "Manzana";
	public static final String georef_razon = "georef_razon";
	public static final String georef_otraRazon = "georef_otraRazon";
	public static final String local = "local";
	public static final String otrorecurso1 = "otrorecurso1";
	public static final String otrorecurso2 = "otrorecurso2";
	
	//Campos zika tabla tamizaje
	public static final String idTamizaje = "idTamizaje";
	public static final String fechaTamizaje = "fechaTamizaje";
	public static final String genero = "genero";
	public static final String acepta_cons = "acepta_cons";
	public static final String porque_no = "porque_no";
	public static final String desc_porque_no = "desc_porque_no";
	public static final String incTrZ = "incTrZ";
	public static final String alfabeto = "alfabeto";
	public static final String testigo = "testigo";
	public static final String parteATrZ = "parteATrZ";
	public static final String parteBTrZ = "parteBTrZ";
	public static final String parteCTrZ = "parteCTrZ";
	public static final String porqueno = "porqueno";
	
	
	//Campos zika tabla casas
	public static final String codigo_casa = "codigo_casa";
	public static final String direccion = "direccion";
	public static final String telefono1 = "telefono1";
	public static final String telefono2 = "telefono2";
	public static final String encuesta = "encuesta";
	public static final String encuestaEnt = "encuestaEnt";

	//Campos zika tabla participantes
	public static final String codigo_indice = "codigo_indice";
	public static final String indice = "indice";
	public static final String cohorte = "cohorte";
	public static final String fechana = "fechana";
	public static final String nombre1 = "nombre1";
	public static final String nombre2 = "nombre2";
	public static final String apellido1 = "apellido1";
	public static final String apellido2 = "apellido2";
	public static final String dondesalud = "dondesalud";
	public static final String puestosal = "puestosal";
	public static final String otropuestosal = "otropuestosal";
	public static final String solocssf = "solocssf";
	public static final String sint1 = "sint1";
	public static final String sint2 = "sint2";
	public static final String sint3 = "sint3";
	public static final String sint4 = "sint4";
	public static final String sint5 = "sint5";
	public static final String sint6 = "sint6";
	public static final String sint7 = "sint7";
	public static final String sint8 = "sint8";
	public static final String sint9 = "sint9";
	public static final String sint10 = "sint10";
	public static final String sint11 = "sint11";
	public static final String sint12 = "sint12";
	public static final String sint13 = "sint13";
	public static final String sint14 = "sint14";
	public static final String sint15 = "sint15";
	public static final String sint16 = "sint16";
	public static final String sint17 = "sint17";
	public static final String sint18 = "sint18";
	public static final String sint19 = "sint19";
	public static final String sint20 = "sint20";
	public static final String sint21 = "sint21";
	public static final String sint22 = "sint22";
	public static final String sint23 = "sint23";
	public static final String sint24 = "sint24";
	public static final String sint25 = "sint25";
	public static final String sint26 = "sint26";
	public static final String sint27 = "sint27";
	public static final String sint28 = "sint28";
	

	public static final String CREATE_USER_TABLE = "create table "
			+ USER_TABLE + " ("
			+ USERNAME + " text not null, "  
			+ ENABLED  + " boolean, " 
			+ PASSWORD + " text not null, "
			+ U_MUESTRA + " boolean, "
			+ U_ECASA + " boolean, "
			+ U_EPART + " boolean, "
			+ U_ELACT + " boolean, "
			+ U_ESAT + " boolean, "
			+ U_OBSEQUIO + " boolean, "
			+ U_PYT + " boolean, "
			+ U_VAC + " boolean, "
			+ U_VISITA + " boolean, "
			+ U_RECEPCION + " boolean, "
			+ U_CONS + " boolean, "
			+ U_CASAZIKA + " boolean, "
			+ U_TAMZIKA + " boolean, "
			+ "primary key (" + USERNAME + "));";

	public static final String CREATE_ROLE_TABLE = "create table "
			+ ROLE_TABLE + " ("
			+ USERNAME + " text not null, "  
			+ AUTH + " text not null, "
			+ "primary key (" + USERNAME + "," + AUTH + "));";

	public static final String CREATE_CASA_TABLE = "create table "
			+ CASA_TABLE + " ("
			+ COD_CASA + " integer not null, " 
			+ BARRIO + " integer not null, "  
			+ DIRECCION  + " text not null, " 
			+ MANZANA    + " integer not null, " 
			+ COORD  + " text, " 
			+ LATITUD    + " real, " 
			+ LONGITUD   + " real, "
			+ TEL_CASA   + " integer,"
			+ NOM_JEFE  + " text not null, " 
			+ NOM_JEFE_2  + " text, "
			+ APE_JEFE  + " text not null, "
			+ APE_JEFE_2  + " text, "
			+ TELEFONO1  + " integer, "
			+ TELEFONO2  + " integer, "
			+ NOMCONTACTO  + " text not null, "
			+ DIRCONTACTO  + " text not null, "
			+ BARRIOCONTACTO  + " integer not null, "
			+ OBARRIOCONTACTO  + " text, "
			+ TELCONTACTO1  + " integer, "
			+ TELCONTACTO2  + " integer, "
			+ VIVIENDA  + " integer not null, "
			+ RESD  + " integer not null, "
			+ INTEN  + " integer not null, "
			+ ENC_CASA  + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + COD_CASA + "));";

	public static final String CREATE_PART_TABLE = "create table "
			+ PART_TABLE + " ("
			+ COD_CASA + " integer not null, " 
			+ CODIGO + " integer not null, "  
			+ FECHA  + " date not null, " 
			+ ESTADO_PAR  + " integer not null, " 
			+ MANZANA_PART  + " integer, "
			+ BARRIO_PART  + " integer, "
			+ BARRIO_DESC  + " text, "
			+ DIRE_FICHA1  + " text, "
			+ RECONSDENG  + " text, "
			+ LATITUD    + " real, " 
			+ LONGITUD   + " real, "
			+ CONPTO  + " text, "
			+ NOMBRE1    + " text not null, " 
			+ NOMBRE2  + " text, " 
			+ APELLIDO1    + " text not null, " 
			+ APELLIDO2   + " text, "
			+ SEXO   + " text,"
			+ FECHANAC  + " date not null, " 
			+ EDAD  + " integer not null, "
			+ NOMBREPT1  + " text not null, "
			+ NOMBREPT2  + " text, "
			+ APELLIDOPT1  + " text not null, "
			+ APELLIDOPT2  + " text, "
			+ RELFAMT  + " integer not null, "
			+ NOMPADRE  + " text, "
			+ NOMMADRE  + " text, "
			+ ASISTE  + " integer, "
			+ US  + " text, "
			+ HIDENG  + " integer, "
			+ CUANDEN  + " date, "
			+ HOSPDEN  + " integer, "
			+ CUANHOSPDEN  + " date, "
			+ ESTUDIO  + " text, "
			+ PBMC  + " text, "
			+ CONSDENG  + " text, "
			+ CONSFLU  + " text, "
			+ CONSCHIK  + " text, "
			+ MUESTRA  + " text, "
			+ MUESTRABHC  + " text, "
			+ LACT_MAT  + " text, "
			+ PESOTALLA  + " text, "
			+ ENC_PAR  + " text, "
			+ ENC_CASA  + " text, "
			+ OBSEQUIO  + " text, "
			+ CONVAL  + " text, "
			+ INFOVAC  + " text, "
			+ PAXGENE  + " text, "
			+ RETOMA  + " text, "
			+ VOLRETOMA  + " real, "
			+ telefono + " text, "
			+ ZIKA  + " text, "
			+ ADN  + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + CODIGO + "));";

	public static final String CREATE_ENCCASA_TABLE = "create table "
			+ ENC_CASA_TABLE + " ("
			+ COD_CASA + " integer not null, " 
			+ FECHA_ENC_CASA  + " date not null, " 
			+ CVIVEN1  + " integer, "
			+ CVIVEN2  + " integer, "
			+ CVIVEN3  + " integer, "
			+ CVIVEN4  + " integer, "
			+ CVIVEN5  + " integer, "
			+ CVIVEN6  + " integer, "
			+ CCUARTOS  + " integer, "
			+ GRIFO  + " integer, "
			+ GRIFOCOM  + " integer, "
			+ HORASAGUA  + " integer, "
			+ MCASA  + " integer, "
			+ OCASA  + " text, "
			+ PISO  + " integer, "
			+ OPISO  + " text, "
			+ TECHO  + " integer, "
			+ OTECHO  + " text, "
			+ CPROPIA  + " integer, "
			+ ABANICOS  + " integer, "
			+ TVS  + " integer, "
			+ REFRI  + " integer, "
			+ MOTO  + " integer, "
			+ CARRO  + " integer, "
			+ LENA  + " integer, "
			+ ANIMALES  + " integer, "
			+ POLLOS  + " integer, "
			+ POLLOSCASA  + " integer, "
			+ PATOS  + " integer, "
			+ PATOSCASA  + " integer, "
			+ PERROS  + " integer, "
			+ PERROSCASA  + " integer, "
			+ GATOS  + " integer, "
			+ GATOSCASA  + " integer, "
			+ CERDOS  + " integer, "
			+ CERDOSCASA  + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + COD_CASA + "," + FECHA_ENC_CASA + "));";

	public static final String CREATE_ENCPART_TABLE = "create table "
			+ ENC_PART_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_ENC_PAR  + " date not null, "
			+ FIEBRE + " integer, "
			+ TFIEBRE + " integer, "
			+ LUGCONS + " integer, "
			+ NOCS + " integer, "
			+ AUTOMED + " text, "
			+ ESC + " integer, "
			+ GRADO + " integer, "
			+ TURNO + " integer, "
			+ NESC + " integer, "
			+ OESC + " text, "
			+ CUIDAN + " integer, "
			+ CCUIDAN + " integer, "
			+ CQVIVE + " integer, "
			+ LUGPARTO + " integer, "
			+ PAPAALF + " integer, "
			+ PAPANIVEL + " integer, "
			+ PAPATRA + " integer, "
			+ PAPATIPOT + " integer, "
			+ MAMAALF + " integer, "
			+ MAMANIVEL + " integer, "
			+ MAMATRA + " integer, "
			+ MAMATIPOT + " integer, "
			+ COMPARTEHAB + " integer, "
			+ HAB1 + " integer, "
			+ HAB2 + " integer, "
			+ HAB3 + " integer, "
			+ HAB4 + " integer, "
			+ HAB5 + " integer, "
			+ HAB6 + " integer, "
			+ COMPARTECAMA + " integer, "
			+ CAMA1 + " integer, "
			+ CAMA2 + " integer, "
			+ CAMA3 + " integer, "
			+ CAMA4 + " integer, "
			+ CAMA5 + " integer, "
			+ CAMA6 + " integer, "
			+ ASMA + " integer, "
			+ SILB12 + " integer, "
			+ SIT1 + " integer, "
			+ SIT2 + " integer, "
			+ SILB01 + " integer, "
			+ DIFHAB + " integer, "
			+ VECDIFHAB + " integer, "
			+ DIFDOR + " integer, "
			+ SUENOPER + " integer, "
			+ TOS12 + " integer, "
			+ VECESTOS + " integer, "
			+ TOS3DIAS + " integer, "
			+ HOSP12M + " integer, "
			+ MED12M + " integer, "
			+ DEP12M + " integer, "
			+ CRISIS + " integer, "
			+ FRECASMA + " integer, "
			+ FUMA + " integer, "
			+ QUIENFUMA + " text, "
			+ CIGMADRE + " integer, "
			+ CIGOTRO + " integer, "
			+ CIGPADRE + " integer, "
			+ rash + " integer, "
			+ mesActual + " integer, "
			+ yearActual + " integer, "
			+ rash_year + " integer, "
			+ rash_mes + " integer, "
			+ rash_mesact + " integer, "
			+ rashCara + " integer, "
			+ rashMiembrosSup + " integer, "
			+ rashTorax + " integer, "
			+ rashAbdomen + " integer, "
			+ rashMiembrosInf + " integer, "
			+ rashDias + " integer, "
			+ ojoRojo + " integer, "
			+ ojoRojo_year + " integer, "
			+ ojoRojo_mes + " integer, "
			+ ojoRojo_mesact + " integer, "
			+ ojoRojo_Dias + " integer, "
			+ hormigueo + " integer, "
			+ hormigueo_year + " integer, "
			+ hormigueo_mes + " integer, "
			+ hormigueo_mesact + " integer, "
			+ hormigueo_Dias + " integer, "
			+ consultaRashHormigueo + " integer, "
			+ uSaludRashHormigueo + " integer, "
			+ cSaludRashHormigueo + " integer, "
			+ oCSRashHormigueo + " text, "
			+ pSRashHormigueo + " integer, "
			+ oPSRashHormigueo + " text, "
			+ diagRashHormigueo + " text, "
			+ chPapaMama + " text, "
			+ fechana_papa + " date, "
			+ cal_edad_papa + " integer, "
			+ cal_edad2_papa + " integer, "
			+ nombpapa1 + " text, "
			+ nombpapa2 + " text, "
			+ apellipapa1 + " text, "
			+ apellipapa2 + " text, "
			+ fechana_mama + " date, "
			+ cal_edad_mama + " integer, "
			+ cal_edad2_mama + " integer, "
			+ nombmama1 + " text, "
			+ nombmama2 + " text, "
			+ apellimama1 + " text, "
			+ apellimama2 + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_ENC_PAR + "," + CODIGO + "));";

	public static final String CREATE_ENCLAC_TABLE = "create table "
			+ LACT_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_ENC_LACT  + " date not null, "
			+ EDAD + " integer, "
			+ DIOPECHO + " integer, "
			+ TIEMPECHO + " integer, "
			+ MESDIOPECHO + " integer, "
			+ PECHOEXC + " integer, "
			+ PECHOEXCANT + " integer, "
			+ TPECHOEXCANT + " integer, "
			+ MPECHOEXCANT + " integer, "
			+ FORMALIM + " integer, "
			+ OTRALIM + " text, "
			+ EDADLIQDP + " integer, "
			+ MESLIQDL + " integer, "
			+ EDADLIQDL + " integer, "
			+ MESLIQDP + " integer, "
			+ EDADALIMS + " integer, "
			+ MESALIMS + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_ENC_LACT + "," + CODIGO + "));";

	public static final String CREATE_PT_TABLE = "create table "
			+ PT_TABLE + " (" 
			+ CODIGO + " integer not null, " 
			+ FECHA_PT  + " date not null, "
			+ PESO1 + " real, "
			+ PESO2 + " real, "
			+ PESO3 + " real, "
			+ TALLA1 + " real, "
			+ TALLA2 + " real, "
			+ TALLA3 + " real, "
			+ IMC1 + " real, "
			+ IMC2 + " real, "
			+ IMC3 + " real, "
			+ DIFPESO + " real, "
			+ DIFTALLA + " real, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_PT + "," + CODIGO + "));";

	public static final String CREATE_MUESTRA_TABLE = "create table "
			+ MUESTRA_TABLE + " (" 
			+ CODIGO + " integer not null, " 
			+ FECHA_MUESTRA  + " date not null, "
			+ MFIEBRE + " integer, " 
			+ CONSULTA + " integer, " 
			+ BHC + " integer, " 
			+ ROJO + " integer, " 
			+ LEU + " integer, " 
			+ PIN + " integer, "
			+ bhc_razonNo + " integer, " 
			+ rojo_razonNo + " integer, " 
			+ pbmc_razonNo + " integer, " 
			+ bhc_otraRazonNo  + " text, "
			+ rojo_otraRazonNo  + " text, "
			+ pbmc_otraRazonNo  + " text, "
			+ horaBHC  + " text, "
			+ horaPBMC  + " text, "
			+ horaInicioPax  + " text, "
			+ horaFinPax  + " text, "
			+ codPax  + " text, "
			+ terreno  + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_MUESTRA + "," + CODIGO + "));";

	public static final String CREATE_OB_TABLE = "create table "
			+ OB_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_OB  + " date not null, "
			+ OBSEQ + " integer, "
			+ CARNET + " integer, "
			+ PERRETIRA  + " text, "
			+ PERRETIRAREL + " integer, "
			+ PERRETIRAOREL  + " text, "
			+ OBS_TEL + " integer, "
			+ CDOM  + " integer, "
			+ BARRIO  + " integer, "
			+ DIRECCION  + " text, "
			+ OBS + " text, "			
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key ("+ FECHA_OB + "," + CODIGO + "));";

	public static final String CREATE_VAC_TABLE = "create table "
			+ VAC_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_VACUNA  + " date not null, "
			+ VACUNA + " integer, "
			+ FV  + " date, "
			+ TIPOVAC + " text, "
			+ TARJETA + " integer, "
			+ NDOSIS + " integer, "
			+ FECHAINF1  + " date, "
			+ FECHAINF2  + " date, "
			+ FECHAINF3  + " date, "
			+ FECHAINF4  + " date, "
			+ FECHAINF5  + " date, "
			+ FECHAINF6  + " date, "
			+ FECHAINF7  + " date, "
			+ FECHAINF8  + " date, "
			+ FECHAINF9  + " date, "
			+ FECHAINF10  + " date, "		
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_VACUNA + "," + CODIGO + "));";

	public static final String CREATE_VIS_TABLE = "create table "
			+ VIS_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_VISITA  + " date not null, "
			+ VISITASN + " integer, "
			+ MOTNOVIS + " integer, "
			+ ACOMP_VIS + " text, "
			+ REL_VIS + " integer, "
			+ ASENT_VIS + " integer, "
			+ CDOM_VIS + " integer, "
			+ BARRIO_VIS + " integer, "
			+ MANZ_VIS + " integer, "
			+ DIRE_VIS + " text, "
			+ COORD_VIS + " text, "
			+ LAT_VIS + " real, "
			+ LON_VIS + " real, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_VISITA + "," + CODIGO + "));";

	public static final String CREATE_RECONS_TABLE = "create table "
			+ RECONS_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CONS  + " date not null, "
			+ autsup + " integer, "
			+ parteaden + " integer, "
			+ rechazoden  + " text, "
			+ otrorechazoden  + " text, "
			+ incden  + " text, "
			+ autsup2 + " integer, "
			+ excden  + " text, "
			+ enfcronsn + " integer, "
			+ enfCronica + " integer, "
			+ oEnfCronica  + " text, "
			+ tomatx + " integer, "
			+ cualestx  + " text, "
			+ autsup3 + " integer, "
			+ cmdomicilio + " integer, "
			+ barrio + " integer, "
			+ autsup4 + " integer, "
			+ dire + " integer, "
			+ manzana + " integer, "
			+ telefono + " integer, "
			+ asentimiento + " integer, "
			+ partebden + " integer, "
			+ partecden + " integer, "
			+ partedden + " integer, "
			+ asentimientoesc + " integer, "
			+ parteeden + " integer, "
			+ firmcarta  + " text, "
			+ relacionfam + " integer, "
			+ coordenadas  + " text, "	
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CONS + "," + CODIGO + "));";
	
	
	public static final String CREATE_CONSCHIK_TABLE = "create table "
			+ CONSCHIK_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CONS  + " date not null, "
			+ autsup + " integer, "
			+ partefden + " integer, "
			+ rechazoden  + " text, "
			+ otrorechazoden  + " text, "
			+ incden  + " text, "
			+ autsup2 + " integer, "
			+ excden  + " text, "
			+ enfcronsn + " integer, "
			+ enfCronica + " integer, "
			+ oEnfCronica  + " text, "
			+ tomatx + " integer, "
			+ cualestx  + " text, "
			+ autsup3 + " integer, "
			+ cmdomicilio + " integer, "
			+ barrio + " integer, "
			+ autsup4 + " integer, "
			+ dire + " integer, "
			+ manzana + " integer, "
			+ telefono + " integer, "
			+ asentimiento + " integer, "
			+ firmcarta  + " text, "
			+ relacionfam + " integer, "
			+ coordenadas  + " text, "	
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CONS + "," + CODIGO + "));";
	
	
	public static final String CREATE_CEST_TABLE = "create table "
			+ CEST_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CAMBIO  + " date not null, "
			+ parteaden + " integer, "
			+ rechazoden  + " text, "
			+ parteaflu + " integer, "
			+ rechazoflu  + " text, "
			+ incden  + " text, "
			+ excden  + " text, "
			+ incflu  + " text, "
			+ excflu  + " text, "
			+ enfcronsn + " integer, "
			+ enfCronica + " integer, "
			+ oEnfCronica  + " text, "
			+ tomatx + " integer, "
			+ cualestx  + " text, "
			+ asentimiento + " integer, "
			+ partebden + " integer, "
			+ partecden + " integer, "
			+ partedden + " integer, "
			+ parteeden + " integer, "
			+ partefden + " integer, "
			+ partebflu + " integer, "
			+ partecflu + " integer, "
			+ asentimientoesc + " integer, "
			+ firmcarta  + " text, "
			+ relacionfam + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CAMBIO + "," + CODIGO + "));";


	public static final String CREATE_BHC_TABLE = "create table "
			+ BHC_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_BHC  + " date not null, "
			+ PAXGENE  + " boolean, "
			+ VOLBHC  + " real, "
			+ LUGAR  + " text, "
			+ OBSBHC  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ TODAY  + " date, "
			+ "primary key (" + FECHA_BHC + "," + CODIGO + "));";

	public static final String CREATE_SERO_TABLE = "create table "
			+ SERO_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_SERO  + " date not null, "
			+ VOLSERO  + " real, "
			+ LUGAR  + " text, "
			+ OBSSERO  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ TODAY  + " date, "
			+ "primary key (" + FECHA_SERO + "," + CODIGO + "));";

	public static final String CREATE_TPBMC_TABLE = "create table "
			+ TPBMC_TABLE + " ("
			+ RECURSO + " text not null, " 
			+ FECHA_TEMP  + " date not null, "
			+ TEMP  + " real, "
			+ LUGARTEMP  + " text, "
			+ OBSTEMP  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ TODAY  + " date, "
			+ "primary key (" + FECHA_TEMP + "," + RECURSO + "));";

	public static final String CREATE_TRB_TABLE = "create table "
			+ TRB_TABLE + " ("
			+ RECURSO + " text not null, " 
			+ FECHA_TEMP  + " date not null, "
			+ TEMP  + " real, "
			+ LUGARTEMP  + " text, "
			+ OBSTEMP  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ TODAY  + " date, "
			+ "primary key (" + FECHA_TEMP + "," + RECURSO + "));";

	public static final String CREATE_PIN_TABLE = "create table "
			+ PIN_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_PIN  + " date not null, "
			+ PINCHAZOS  + " integer, "
			+ LUGAR  + " text, "
			+ OBSPIN  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ TODAY  + " date, "
			+ "primary key (" + FECHA_PIN + "," + CODIGO + "));";
	
	
	public static final String CREATE_RND_TABLE = "create table "
			+ NO_DATA_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ TODAY  + " date not null, "
			+ RAZON  + " integer, "
			+ ORAZON  + " text, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ "primary key (" + TODAY + "," + CODIGO + "));";
	
	public static final String CREATE_CC_TABLE = "create table "
			+ COD_REL_TABLE + " ("
			+ TODAY  + " date not null, "
			+ COD_CASA_R  + " integer, "
			+ COD_COMUN  + " integer, "
			+ COD_RELA  + " integer, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ "primary key (" + TODAY + "));";
	
	public static final String CREATE_CAMBCASA_TABLE = "create table "
			+ CAMB_CASA_TABLE + " ("
			+ TODAY  + " date not null, "
			+ codigo  + " integer, "
			+ codCasaAnterior  + " integer, "
			+ codCasaActual  + " integer, "
			+ USUARIO  + " text, " 
			+ STATUS + " text not null, "
			+ "primary key (" + TODAY + "));";

	public static final String CREATE_ENCSAT_TABLE = "create table "
			+ ENC_SAT_TABLE + " ("
			+ FECHA_ENC_SAT  + " date not null, "
			+ ESTUDIO + " text, "
			+ ATENPEREST + " integer, "
			+ TIEMATEN + " integer, "
			+ ATENPERADM + " integer, "
			+ ATENPERENFERM + " integer, "
			+ ATENPERMED + " integer, "
			+ AMBATEN + " integer, "
			+ ATENPERLAB + " integer, "
			+ EXPLDXENF + " integer, "
			+ FLUDENSN + " integer, "
			+ FLUCONIMP + " integer, "
			+ DENCONIMP + " integer, "
			+ EXPLPELIGENF + " integer, "
			+ EXPMEDCUID + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_ENC_SAT + "));";
	
	
	public static final String CREATE_RECONS_TABLE_2015 = "create table "
			+ RECONS_TABLE_2015 + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CONS  + " date not null, "
			+ visExit + " text, "
			+ razonVisNoExit + " text, "
			+ personaDejoCarta  + " text, "
			+ personaCasa  + " text, "
			+ relacionFamPersonaCasa  + " text, "
			+ otraRelacionPersonaCasa + " text, "
			+ telefonoPersonaCasa  + " integer, "
			+ emancipado + " text, "
			+ descEmancipado + " text, "
			+ incDen  + " text, "
			+ excDen + " text, "
			+ enfCronSN  + " integer, "
			+ enfCronica + " integer, "
			+ oEnfCronica + " text, "
			+ tomaTx + " integer, "
			+ cualesTx + " text, "
			+ assite + " integer, "
			+ centrosalud + " integer, "
			+ ocentrosalud + " text, "
			+ puestosalud  + " integer, "
			+ asentimiento  + " integer, "
			+ parteADen  + " integer, "
			+ parteBDen  + " integer, "
			+ parteCDen  + " integer, "
			+ parteDDen  + " integer, "
			+ rechDen + " text, "
			+ nombrept + " text, "
			+ nombrept2 + " text, "
			+ apellidopt + " text, "
			+ apellidopt2 + " text, "
			+ relacionFam  + " integer, "
			+ otraRelacionFam  + " text, "
			+ mismoTutorSN  + " integer, "
			+ motivoDifTutor  + " integer, "
			+ otroMotivoDifTutor  + " text, "
			+ quePaisTutor + " text, "
			+ alfabetoTutor + " integer, "
			+ testigoSN + " integer, "
			+ nombretest1 + " text, "
			+ nombretest2 + " text, "
			+ apellidotest1 + " text, "
			+ apellidotest2 + " text, "
			+ cmDomicilio  + " integer, "
			+ barrio  + " integer, "
			+ otrobarrio  + " text, "
			+ dire  + " text, "
			+ autsup  + " integer, "
			+ telefonoClasif1  + " integer, "
			+ telefonoConv1  + " integer, "
			+ telefonoCel1  + " integer, "
			+ telefono2SN  + " integer, "
			+ telefonoClasif2  + " integer, "
			+ telefonoConv2  + " integer, "
			+ telefonoCel2  + " integer, "
			+ telefono3SN  + " integer, "
			+ telefonoClasif3  + " integer, "
			+ telefonoConv3  + " integer, "
			+ telefonoCel3  + " integer, "
			+ jefenom  + " text, "
			+ jefenom2  + " text, "
			+ jefeap  + " text, "
			+ jefeap2  + " text, "
			+ nomContacto  + " text, "
			+ barrioContacto  + " integer, "
			+ otrobarrioContacto  + " text, "
			+ direContacto  + " text, "
			+ telContacto1  + " integer, "
			+ telContactoConv1  + " integer, "
			+ telContactoCel1  + " integer, "
			+ telContacto2SN  + " integer, "
			+ telContactoClasif2  + " integer, "
			+ telContactoConv2  + " integer, "
			+ telContactoCel2  + " integer, "
			+ nombrepadre  + " text, "
			+ nombrepadre2  + " text, "
			+ apellidopadre  + " text, "
			+ apellidopadre2  + " text, "
			+ nombremadre  + " text, "
			+ nombremadre2  + " text, "
			+ apellidomadre  + " text, "
			+ apellidomadre2  + " text, "
			+ copiaFormato  + " integer, "
			+ firmo_cartcons  + " integer, "
			+ fecho_cartcons  + " integer, "
			+ huella_dig  + " integer, "
			+ fech_firm_testigo  + " integer, "
			+ entiende  + " integer, "
			+ georef  + " text, "
			+ Manzana  + " integer, "
			+ georef_razon  + " text, "
			+ georef_otraRazon  + " text, "
			+ local  + " integer, "
			+ otrorecurso1  + " integer, "
			+ otrorecurso2  + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CONS + "," + CODIGO + "));";
	
	public static final String CREATE_ZIKA_TABLE = "create table "
			+ ZIKA_TABLE + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CONS  + " date not null, "
			+ parteDDen  + " integer, "
			+ rechDDen + " text, "
			+ nombrept + " text, "
			+ nombrept2 + " text, "
			+ apellidopt + " text, "
			+ apellidopt2 + " text, "
			+ relacionFam  + " integer, "
			+ otraRelacionFam  + " text, "
			+ mismoTutorSN  + " integer, "
			+ motivoDifTutor  + " integer, "
			+ otroMotivoDifTutor  + " text, "
			+ quePaisTutor + " text, "
			+ alfabetoTutor + " integer, "
			+ testigoSN + " integer, "
			+ nombretest1 + " text, "
			+ nombretest2 + " text, "
			+ apellidotest1 + " text, "
			+ apellidotest2 + " text, "
			+ otrorecurso1  + " integer, "
			+ otrorecurso2  + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CONS + "," + CODIGO + "));";
	
	
	public static final String CREATE_RECONSFLU_TABLE_2015 = "create table "
			+ RECONSFLU_TABLE_2015 + " ("
			+ CODIGO + " integer not null, " 
			+ FECHA_CONS  + " date not null, "
			+ visExit + " text, "
			+ razonVisNoExit + " text, "
			+ nombrept + " text, "
			+ nombrept2 + " text, "
			+ apellidopt + " text, "
			+ apellidopt2 + " text, "
			+ relacionFam  + " integer, "
			+ otraRelacionFam  + " text, "
			+ alfabetoTutor + " integer, "
			+ testigoSN + " integer, "
			+ nombretest1 + " text, "
			+ nombretest2 + " text, "
			+ apellidotest1 + " text, "
			+ apellidotest2 + " text, "
			+ cmDomicilio  + " integer, "
			+ barrio  + " integer, "
			+ otrobarrio  + " text, "
			+ dire  + " text, "
			+ telContacto1  + " integer, "
			+ telefonoConv1  + " integer, "
			+ telefonoCel1  + " integer, "
			+ telefonoCel2  + " integer, "
			+ asentimiento  + " integer, "
			+ parteAFlu  + " integer, "
			+ contacto_futuro  + " integer, "
			+ parteBFlu  + " integer, "
			+ parteCFlu  + " integer, "
			+ rechFlu + " integer, "
			+ local  + " integer, "
			+ otrorecurso1  + " integer, "
			+ otrorecurso2  + " integer, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + FECHA_CONS + "," + CODIGO + "));";
	
	
	//ZIKA CLUSTER
	
	public static final String CREATE_TAM_ZIKA_TABLE = "create table "
			+ TAM_ZIKA_TABLE + " ("
			+ idTamizaje + " text not null, " 
			+ fechaTamizaje  + " date not null, "
			+ genero + " text, "
			+ acepta_cons + " text, "
			+ porque_no  + " text, "
			+ desc_porque_no  + " text, "
			+ incTrZ  + " text, "
			+ asentimiento + " text, "
			+ alfabeto  + " text, "
			+ testigo + " text, "
			+ nombretest1 + " text, "
			+ nombretest2 + " text, "
			+ apellidotest1 + " text, "
			+ apellidotest2 + " text, "
			+ parteATrZ  + " text, "
			+ asentimientoesc  + " text, "
			+ parteBTrZ  + " text, "
			+ parteCTrZ  + " text, "
			+ porqueno  + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + idTamizaje + "));";
	
	public static final String CREATE_PART_ZIKA_TABLE = "create table "
			+ PART_ZIKA_TABLE + " ("
			+ codigo + " integer not null, "
			+ codigo_indice + " integer, "
			+ codigo_casa + " integer, " 
			+ indice + " text, "
			+ cohorte + " text, "
			+ fechana  + " date, "
			+ nombrept  + " text, "
			+ nombrept2  + " text, "
			+ apellidopt  + " text, "
			+ apellidopt2 + " text, "
			+ nombrepadre  + " text, "
			+ nombrepadre2 + " text, "
			+ apellidopadre + " text, "
			+ apellidopadre2 + " text, "
			+ nombremadre + " text, "
			+ nombremadre2 + " text, "
			+ apellidomadre  + " text, "
			+ apellidomadre2  + " text, "
			+ nombre1 + " text, "
			+ nombre2 + " text, "
			+ apellido1  + " text, "
			+ apellido2  + " text, "
			+ dondesalud  + " text, "
			+ centrosalud + " text, "
			+ ocentrosalud + " text, "
			+ puestosal + " text, "
			+ otropuestosal + " text, "
			+ solocssf + " text, "
			+ idTamizaje  + " text, "
			+ encuesta  + " text, "
			+ sint1  + " text, "
			+ sint2 + " text, "
			+ sint3 + " text, "
			+ sint4 + " text, "
			+ sint5  + " text, "
			+ sint6 + " text, "
			+ sint7 + " text, "
			+ sint8 + " text, "
			+ sint9 + " text, "
			+ sint10  + " text, "
			+ sint11  + " text, "
			+ sint12  + " text, "
			+ sint13  + " text, "
			+ sint14  + " text, "
			+ sint15  + " text, "
			+ sint16  + " text, "
			+ sint17  + " text, "
			+ sint18  + " text, "
			+ sint19  + " text, "
			+ sint20 + " text, "
			+ sint21 + " text, "
			+ sint22 + " text, "
			+ sint23 + " text, "
			+ sint24 + " text, "
			+ sint25 + " text, "
			+ sint26 + " text, "
			+ sint27 + " text, "
			+ sint28 + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + codigo + "));";
	
	
	public static final String CREATE_CASA_ZIKA_TABLE = "create table "
			+ CASA_ZIKA_TABLE + " ("
			+ codigo_casa + " integer not null, " 
			+ barrio + " text, "
			+ jefenom + " text, "
			+ jefenom2  + " text, "
			+ jefeap  + " text, "
			+ jefeap2  + " text, "
			+ direccion + " text, "
			+ telefono1  + " text, "
			+ telefono2 + " text, "
			+ georef + " text, "
			+ Manzana + " text, "
			+ georef_razon + " text, "
			+ georef_otraRazon + " text, "
			+ idTamizaje  + " text, "
			+ encuesta  + " text, "
			+ encuestaEnt  + " text, "
			+ ID_INSTANCIA + " integer not null," 
			+ FILE_PATH + " text not null," 
			+ STATUS + " text not null, "
			+ WHEN_UPDATED + " text not null, " 
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ USUARIO  + " text, " 
			+ DELETED  + " boolean, "
			+ REC1    + " integer, " 
			+ REC2    + " integer, "
			+ "primary key (" + codigo_casa + "));";

}
