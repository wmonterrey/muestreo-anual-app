package ni.org.ics.estudios.cohorte.muestreoanual.parsers;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


/**
 * Objeto para capturar informacion del Xml producido por ODK en el formulario casa
 * 
 * @author William Aviles
 **/

public class TerrenoXml {
	
	@Element(required=false)
	private Integer edad;
	@Element(required=false)
	private Integer visitaSN;
	@Element(required=false)
	private Integer motNoVisita;
	@Element(required=false)
	private String acomp;
	@Element(required=false)
	private Integer relacionFam;
	@Element(required=false)
	private Integer asentimiento;
	@Element(required=false)
	private Integer cDom;
	@Element(required=false)
	private Integer barrio;
	@Element(required=false)
	private Integer manzana;
	@Element(required=false)
	private String direccion;
	@Element(required=false)
	private String coordenadas;
	
	
	
	@Element(required=false)
	private String punto;
	
	@Element(required=false)
	private String informacion;
	@Element(required=false)
	private String confirmar;
	
	@Element(required=false)
	private String titulo1;
	
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
	private Date today;
	
	@Element
	private Integer recurso1;
	@Element
	private Integer recurso2;
	@Attribute
	private String id;
	
	
	@Element(required=false)
	private Meta meta;
	
	public TerrenoXml(){
		
	}

	public Integer getVisitaSN() {
		return visitaSN;
	}

	public void setVisitaSN(Integer visitaSN) {
		this.visitaSN = visitaSN;
	}

	public Integer getMotNoVisita() {
		return motNoVisita;
	}

	public void setMotNoVisita(Integer motNoVisita) {
		this.motNoVisita = motNoVisita;
	}

	public String getAcomp() {
		return acomp;
	}

	public void setAcomp(String acomp) {
		this.acomp = acomp;
	}

	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
	}
	
	

	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	public Integer getcDom() {
		return cDom;
	}

	public void setcDom(Integer cDom) {
		this.cDom = cDom;
	}

	public Integer getBarrio() {
		return barrio;
	}

	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}

	public Integer getManzana() {
		return manzana;
	}

	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getPunto() {
		return punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getRecurso1() {
		return recurso1;
	}

	public void setRecurso1(Integer recurso1) {
		this.recurso1 = recurso1;
	}

	public Integer getRecurso2() {
		return recurso2;
	}

	public void setRecurso2(Integer recurso2) {
		this.recurso2 = recurso2;
	}

	public String getTitulo1() {
		return titulo1;
	}

	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}
	
	

	
}
