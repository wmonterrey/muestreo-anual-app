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

public class SintomasXml {
	
	@Element(required=false)
	private Date fechaSint;
	@Element(required=false)
	private Integer diaSint;
	@Element(required=false)
	private String sintomas1;
	@Element(required=false)
	private String fiebre;
	@Element(required=false)
	private String astenia;
	@Element(required=false)
	private String recurso1;
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
	
	public SintomasXml(){
		
	}

	

	public Date getFechaSint() {
		return fechaSint;
	}



	public void setFechaSint(Date fechaSint) {
		this.fechaSint = fechaSint;
	}



	public Integer getDiaSint() {
		return diaSint;
	}



	public void setDiaSint(Integer diaSint) {
		this.diaSint = diaSint;
	}



	public String getFiebre() {
		return fiebre;
	}



	public void setFiebre(String fiebre) {
		this.fiebre = fiebre;
	}



	public String getAstenia() {
		return astenia;
	}



	public void setAstenia(String astenia) {
		this.astenia = astenia;
	}



	public String getRecurso1() {
		return recurso1;
	}



	public void setRecurso1(String recurso1) {
		this.recurso1 = recurso1;
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

	public String getImei() {
		return imei;
	}



	public void setImei(String imei) {
		this.imei = imei;
	}

}
