package ni.org.ics.estudios.cohorte.muestreoanual.parsers.zikacluster;

import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.parsers.Meta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


/**
 * Objeto para capturar informacion del Xml producido por ODK en el formulario casa
 * 
 * @author William Aviles
 **/

public class TamizajeIndiceXml {
	
	@Element(required=false)
	private String titulo1;
	@Element(required=false)
	private String titulo2;
	@Element(required=false)
	private String genero;
	@Element(required=false)
	private String acepta_cons;
	@Element(required=false)
	private String porque_no;
	@Element(required=false)
	private String desc_porque_no;
	@Element(required=false)
	private String titulo3;
	@Element(required=false)
	private String codigo_casa;
	@Element(required=false)
	private String clasific_ci;
	@Element(required=false)
	private String codigo_TrZ_ci;
	@Element(required=false)
	private String codigo_TrZ;
	@Element(required=false)
	private Date fechana;
	@Element(required=false)
	private String cal_edad_ci;
	@Element(required=false)
	private String cal_edad2_ci;
	@Element(required=false)
	private String cal_edad2m_ci;
	@Element(required=false)
	private String titulo4;
	@Element(required=false)
	private String titulo5;
	@Element(required=false)
	private String titulo6;
	@Element(required=false)
	private String incTrZ;
	@Element(required=false)
	private String titulo7;
	@Element(required=false)
	private String asentimiento;
	@Element(required=false)
	private String titulo8;
	@Element(required=false)
	private String barrio;
	@Element(required=false)
	private String jefeFam;
	@Element(required=false)
	private String jefenom;
	@Element(required=false)
	private String jefenom2;
	@Element(required=false)
	private String jefeap;
	@Element(required=false)
	private String jefeap2;
	@Element(required=false)
	private String tutorCI;
	@Element(required=false)
	private String nombrept;
	@Element(required=false)
	private String nombrept2;
	@Element(required=false)
	private String apellidopt;
	@Element(required=false)
	private String apellidopt2;
	@Element(required=false)
	private String relaciontutor;
	@Element(required=false)
	private String nompadre_ci;
	@Element(required=false)
	private String nombrepadre;
	@Element(required=false)
	private String nombrepadre2;
	@Element(required=false)
	private String apellidopadre;
	@Element(required=false)
	private String apellidopadre2;
	@Element(required=false)
	private String nommadre_ci;
	@Element(required=false)
	private String nombremadre;
	@Element(required=false)
	private String nombremadre2;
	@Element(required=false)
	private String apellidomadre;
	@Element(required=false)
	private String apellidomadre2;
	@Element(required=false)
	private String direccion;
	@Element(required=false)
	private String telefono1;
	@Element(required=false)
	private String telefono2;
	@Element(required=false)
	private String nombreCI;
	@Element(required=false)
	private String nombre1;
	@Element(required=false)
	private String nombre2;
	@Element(required=false)
	private String apellido1;
	@Element(required=false)
	private String apellido2;
	@Element(required=false)
	private String dondesalud;
	@Element(required=false)
	private String centrosalud;
	@Element(required=false)
	private String ocentrosalud;
	@Element(required=false)
	private String puestosal;
	@Element(required=false)
	private String otropuestosal;
	@Element(required=false)
	private String solocssf;
	@Element(required=false)
	private String titulo10;
	@Element(required=false)
	private String alfabeto;
	@Element(required=false)
	private String testigo;
	@Element(required=false)
	private String titulo11;
	@Element(required=false)
	private String testigo_grupo;
	@Element(required=false)
	private String nombretest1;
	@Element(required=false)
	private String nombretest2;
	@Element(required=false)
	private String apellidotest1;
	@Element(required=false)
	private String apellidotest2;
	@Element(required=false)
	private String parteATrZ;
	@Element(required=false)
	private String asentimientoesc;
	@Element(required=false)
	private String titulo12;
	@Element(required=false)
	private String parteBTrZ;
	@Element(required=false)
	private String parteCTrZ;
	@Element(required=false)
	private String porqueno;
	@Element(required=false)
	private String georef;
	@Element(required=false)
	private String Manzana;
	@Element(required=false)
	private String georef_razon;
	@Element(required=false)
	private String georef_otraRazon;
	@Element(required=false)
	private String recurso1;
	@Element(required=false)
	private String otrorecurso1;
	
	@Element(required=false)
	private String start;
	@Element(required=false)
	private String end;
	@Element(required=false)
	private String deviceid;
	@Element(required=false)
	private String simserial;
	@Element(required=false)
	private String phonenumber;
	@Element(required=false)
	private String imei;
	@Element(required=false)
	private Date today;
	@Attribute
	private String id;
	
	
	@Element(required=false)
	private Meta meta;
	
	public TamizajeIndiceXml(){
		
	}

	

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getSimserial() {
		return simserial;
	}

	public void setSimserial(String simserial) {
		this.simserial = simserial;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}



	public String getTitulo1() {
		return titulo1;
	}



	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}



	public String getTitulo2() {
		return titulo2;
	}



	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getAcepta_cons() {
		return acepta_cons;
	}



	public void setAcepta_cons(String acepta_cons) {
		this.acepta_cons = acepta_cons;
	}



	public String getPorque_no() {
		return porque_no;
	}



	public void setPorque_no(String porque_no) {
		this.porque_no = porque_no;
	}



	public String getDesc_porque_no() {
		return desc_porque_no;
	}



	public void setDesc_porque_no(String desc_porque_no) {
		this.desc_porque_no = desc_porque_no;
	}



	public String getTitulo3() {
		return titulo3;
	}



	public void setTitulo3(String titulo3) {
		this.titulo3 = titulo3;
	}



	public String getCodigo_casa() {
		return codigo_casa;
	}



	public void setCodigo_casa(String codigo_casa) {
		this.codigo_casa = codigo_casa;
	}



	public String getClasific_ci() {
		return clasific_ci;
	}



	public void setClasific_ci(String clasific_ci) {
		this.clasific_ci = clasific_ci;
	}



	public String getCodigo_TrZ_ci() {
		return codigo_TrZ_ci;
	}



	public void setCodigo_TrZ_ci(String codigo_TrZ_ci) {
		this.codigo_TrZ_ci = codigo_TrZ_ci;
	}



	public String getCodigo_TrZ() {
		return codigo_TrZ;
	}



	public void setCodigo_TrZ(String codigo_TrZ) {
		this.codigo_TrZ = codigo_TrZ;
	}



	public Date getFechana() {
		return fechana;
	}



	public void setFechana(Date fechana) {
		this.fechana = fechana;
	}



	public String getCal_edad_ci() {
		return cal_edad_ci;
	}



	public void setCal_edad_ci(String cal_edad_ci) {
		this.cal_edad_ci = cal_edad_ci;
	}



	public String getCal_edad2_ci() {
		return cal_edad2_ci;
	}



	public void setCal_edad2_ci(String cal_edad2_ci) {
		this.cal_edad2_ci = cal_edad2_ci;
	}



	public String getCal_edad2m_ci() {
		return cal_edad2m_ci;
	}



	public void setCal_edad2m_ci(String cal_edad2m_ci) {
		this.cal_edad2m_ci = cal_edad2m_ci;
	}



	public String getTitulo4() {
		return titulo4;
	}



	public void setTitulo4(String titulo4) {
		this.titulo4 = titulo4;
	}



	public String getTitulo5() {
		return titulo5;
	}



	public void setTitulo5(String titulo5) {
		this.titulo5 = titulo5;
	}



	public String getTitulo6() {
		return titulo6;
	}



	public void setTitulo6(String titulo6) {
		this.titulo6 = titulo6;
	}



	public String getIncTrZ() {
		return incTrZ;
	}



	public void setIncTrZ(String incTrZ) {
		this.incTrZ = incTrZ;
	}



	public String getTitulo7() {
		return titulo7;
	}



	public void setTitulo7(String titulo7) {
		this.titulo7 = titulo7;
	}



	public String getAsentimiento() {
		return asentimiento;
	}



	public void setAsentimiento(String asentimiento) {
		this.asentimiento = asentimiento;
	}



	public String getTitulo8() {
		return titulo8;
	}



	public void setTitulo8(String titulo8) {
		this.titulo8 = titulo8;
	}



	public String getBarrio() {
		return barrio;
	}



	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}



	public String getJefeFam() {
		return jefeFam;
	}



	public void setJefeFam(String jefeFam) {
		this.jefeFam = jefeFam;
	}



	public String getJefenom() {
		return jefenom;
	}



	public void setJefenom(String jefenom) {
		this.jefenom = jefenom;
	}



	public String getJefenom2() {
		return jefenom2;
	}



	public void setJefenom2(String jefenom2) {
		this.jefenom2 = jefenom2;
	}



	public String getJefeap() {
		return jefeap;
	}



	public void setJefeap(String jefeap) {
		this.jefeap = jefeap;
	}



	public String getJefeap2() {
		return jefeap2;
	}



	public void setJefeap2(String jefeap2) {
		this.jefeap2 = jefeap2;
	}



	public String getTutorCI() {
		return tutorCI;
	}



	public void setTutorCI(String tutorCI) {
		this.tutorCI = tutorCI;
	}



	public String getNombrept() {
		return nombrept;
	}



	public void setNombrept(String nombrept) {
		this.nombrept = nombrept;
	}



	public String getNombrept2() {
		return nombrept2;
	}



	public void setNombrept2(String nombrept2) {
		this.nombrept2 = nombrept2;
	}



	public String getApellidopt() {
		return apellidopt;
	}



	public void setApellidopt(String apellidopt) {
		this.apellidopt = apellidopt;
	}



	public String getApellidopt2() {
		return apellidopt2;
	}



	public void setApellidopt2(String apellidopt2) {
		this.apellidopt2 = apellidopt2;
	}



	public String getRelaciontutor() {
		return relaciontutor;
	}



	public void setRelaciontutor(String relaciontutor) {
		this.relaciontutor = relaciontutor;
	}



	public String getNompadre_ci() {
		return nompadre_ci;
	}



	public void setNompadre_ci(String nompadre_ci) {
		this.nompadre_ci = nompadre_ci;
	}



	public String getNombrepadre() {
		return nombrepadre;
	}



	public void setNombrepadre(String nombrepadre) {
		this.nombrepadre = nombrepadre;
	}



	public String getNombrepadre2() {
		return nombrepadre2;
	}



	public void setNombrepadre2(String nombrepadre2) {
		this.nombrepadre2 = nombrepadre2;
	}



	public String getApellidopadre() {
		return apellidopadre;
	}



	public void setApellidopadre(String apellidopadre) {
		this.apellidopadre = apellidopadre;
	}



	public String getApellidopadre2() {
		return apellidopadre2;
	}



	public void setApellidopadre2(String apellidopadre2) {
		this.apellidopadre2 = apellidopadre2;
	}



	public String getNommadre_ci() {
		return nommadre_ci;
	}



	public void setNommadre_ci(String nommadre_ci) {
		this.nommadre_ci = nommadre_ci;
	}



	public String getNombremadre() {
		return nombremadre;
	}



	public void setNombremadre(String nombremadre) {
		this.nombremadre = nombremadre;
	}



	public String getNombremadre2() {
		return nombremadre2;
	}



	public void setNombremadre2(String nombremadre2) {
		this.nombremadre2 = nombremadre2;
	}



	public String getApellidomadre() {
		return apellidomadre;
	}



	public void setApellidomadre(String apellidomadre) {
		this.apellidomadre = apellidomadre;
	}



	public String getApellidomadre2() {
		return apellidomadre2;
	}



	public void setApellidomadre2(String apellidomadre2) {
		this.apellidomadre2 = apellidomadre2;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono1() {
		return telefono1;
	}



	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}



	public String getTelefono2() {
		return telefono2;
	}



	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}



	public String getNombreCI() {
		return nombreCI;
	}



	public void setNombreCI(String nombreCI) {
		this.nombreCI = nombreCI;
	}



	public String getNombre1() {
		return nombre1;
	}



	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}



	public String getNombre2() {
		return nombre2;
	}



	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}



	public String getApellido1() {
		return apellido1;
	}



	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public String getDondesalud() {
		return dondesalud;
	}



	public void setDondesalud(String dondesalud) {
		this.dondesalud = dondesalud;
	}



	public String getCentrosalud() {
		return centrosalud;
	}



	public void setCentrosalud(String centrosalud) {
		this.centrosalud = centrosalud;
	}



	public String getOcentrosalud() {
		return ocentrosalud;
	}



	public void setOcentrosalud(String ocentrosalud) {
		this.ocentrosalud = ocentrosalud;
	}



	public String getPuestosal() {
		return puestosal;
	}



	public void setPuestosal(String puestosal) {
		this.puestosal = puestosal;
	}



	public String getOtropuestosal() {
		return otropuestosal;
	}



	public void setOtropuestosal(String otropuestosal) {
		this.otropuestosal = otropuestosal;
	}



	public String getSolocssf() {
		return solocssf;
	}



	public void setSolocssf(String solocssf) {
		this.solocssf = solocssf;
	}



	public String getTitulo10() {
		return titulo10;
	}



	public void setTitulo10(String titulo10) {
		this.titulo10 = titulo10;
	}



	public String getAlfabeto() {
		return alfabeto;
	}



	public void setAlfabeto(String alfabeto) {
		this.alfabeto = alfabeto;
	}



	public String getTestigo() {
		return testigo;
	}



	public void setTestigo(String testigo) {
		this.testigo = testigo;
	}



	public String getTitulo11() {
		return titulo11;
	}



	public void setTitulo11(String titulo11) {
		this.titulo11 = titulo11;
	}



	public String getTestigo_grupo() {
		return testigo_grupo;
	}



	public void setTestigo_grupo(String testigo_grupo) {
		this.testigo_grupo = testigo_grupo;
	}



	public String getNombretest1() {
		return nombretest1;
	}



	public void setNombretest1(String nombretest1) {
		this.nombretest1 = nombretest1;
	}



	public String getNombretest2() {
		return nombretest2;
	}



	public void setNombretest2(String nombretest2) {
		this.nombretest2 = nombretest2;
	}



	public String getApellidotest1() {
		return apellidotest1;
	}



	public void setApellidotest1(String apellidotest1) {
		this.apellidotest1 = apellidotest1;
	}



	public String getApellidotest2() {
		return apellidotest2;
	}



	public void setApellidotest2(String apellidotest2) {
		this.apellidotest2 = apellidotest2;
	}



	public String getParteATrZ() {
		return parteATrZ;
	}



	public void setParteATrZ(String parteATrZ) {
		this.parteATrZ = parteATrZ;
	}



	public String getAsentimientoesc() {
		return asentimientoesc;
	}



	public void setAsentimientoesc(String asentimientoesc) {
		this.asentimientoesc = asentimientoesc;
	}



	public String getTitulo12() {
		return titulo12;
	}



	public void setTitulo12(String titulo12) {
		this.titulo12 = titulo12;
	}



	public String getParteBTrZ() {
		return parteBTrZ;
	}



	public void setParteBTrZ(String parteBTrZ) {
		this.parteBTrZ = parteBTrZ;
	}



	public String getParteCTrZ() {
		return parteCTrZ;
	}



	public void setParteCTrZ(String parteCTrZ) {
		this.parteCTrZ = parteCTrZ;
	}



	public String getPorqueno() {
		return porqueno;
	}



	public void setPorqueno(String porqueno) {
		this.porqueno = porqueno;
	}



	public String getGeoref() {
		return georef;
	}



	public void setGeoref(String georef) {
		this.georef = georef;
	}



	public String getManzana() {
		return Manzana;
	}



	public void setManzana(String manzana) {
		Manzana = manzana;
	}



	public String getGeoref_razon() {
		return georef_razon;
	}



	public void setGeoref_razon(String georef_razon) {
		this.georef_razon = georef_razon;
	}



	public String getGeoref_otraRazon() {
		return georef_otraRazon;
	}



	public void setGeoref_otraRazon(String georef_otraRazon) {
		this.georef_otraRazon = georef_otraRazon;
	}



	public String getRecurso1() {
		return recurso1;
	}



	public void setRecurso1(String recurso1) {
		this.recurso1 = recurso1;
	}



	public String getOtrorecurso1() {
		return otrorecurso1;
	}



	public void setOtrorecurso1(String otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}



	public String getImei() {
		return imei;
	}



	public void setImei(String imei) {
		this.imei = imei;
	}

}
