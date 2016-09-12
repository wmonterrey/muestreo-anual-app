package ni.org.ics.estudios.cohorte.muestreoanual.parsers;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


/**
 * Objeto para capturar informacion del Xml producido por ODK en el formulario casa
 * 
 * @author William Aviles
 **/

public class EncuestaCasaXml {
	
	
	
	@Element(required=false)
	private Integer cvivencasa1;
	@Element(required=false)
	private Integer cvivencasa2;
	@Element(required=false)
	private Integer cvivencasa3;
	@Element(required=false)
	private Integer cvivencasa4;
	@Element(required=false)
	private Integer cvivencasa5;
	@Element(required=false)
	private Integer cvivencasa6;
	@Element(required=false)
	private Integer ccuartos;
	@Element(required=false)
	private Integer grifo;
	@Element(required=false)
	private Integer grifoComSN;
	@Element(required=false)
	private Integer horasagua;
	@Element(required=false)
	private String mcasa;
	@Element(required=false)
	private String ocasa;
	@Element(required=false)
	private Integer piso;
	@Element(required=false)
	private String opiso;
	@Element(required=false)
	private Integer techo;
	@Element(required=false)
	private String otecho;
	@Element(required=false)
	private Integer cpropia;
	@Element(required=false)
	private Integer cabanicos;
	@Element(required=false)
	private Integer ctelevisores;
	@Element(required=false)
	private Integer crefrigeradores;
	@Element(required=false)
	private Integer moto;
	@Element(required=false)
	private Integer carro;
	@Element(required=false)
	private Integer cocinalena;
	@Element(required=false)
	private Integer animalesSN;
	@Element(required=false)
	private Integer pollos;
	@Element(required=false)
	private Integer polloscasa;
	@Element(required=false)
	private Integer patos;
	@Element(required=false)
	private Integer patoscasa;
	@Element(required=false)
	private Integer perros;
	@Element(required=false)
	private Integer perroscasa;
	@Element(required=false)
	private Integer gatos;
	@Element(required=false)
	private Integer gatoscasa;
	@Element(required=false)
	private Integer cerdos;
	@Element(required=false)
	private Integer cerdoscasa;
	
	@Element(required=false)
	private String titulo1;
	@Element(required=false)
	private String titulo2;
	@Element(required=false)
	private String titulo3;
	@Element(required=false)
	private String titulo4;
	
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
	
	public EncuestaCasaXml(){
		
	}

	public Integer getCvivencasa1() {
		return cvivencasa1;
	}

	public void setCvivencasa1(Integer cvivencasa1) {
		this.cvivencasa1 = cvivencasa1;
	}

	public Integer getCvivencasa2() {
		return cvivencasa2;
	}

	public void setCvivencasa2(Integer cvivencasa2) {
		this.cvivencasa2 = cvivencasa2;
	}

	public Integer getCvivencasa3() {
		return cvivencasa3;
	}

	public void setCvivencasa3(Integer cvivencasa3) {
		this.cvivencasa3 = cvivencasa3;
	}

	public Integer getCvivencasa4() {
		return cvivencasa4;
	}

	public void setCvivencasa4(Integer cvivencasa4) {
		this.cvivencasa4 = cvivencasa4;
	}

	public Integer getCvivencasa5() {
		return cvivencasa5;
	}

	public void setCvivencasa5(Integer cvivencasa5) {
		this.cvivencasa5 = cvivencasa5;
	}

	public Integer getCvivencasa6() {
		return cvivencasa6;
	}

	public void setCvivencasa6(Integer cvivencasa6) {
		this.cvivencasa6 = cvivencasa6;
	}

	public Integer getCcuartos() {
		return ccuartos;
	}

	public void setCcuartos(Integer ccuartos) {
		this.ccuartos = ccuartos;
	}

	public Integer getGrifo() {
		return grifo;
	}

	public void setGrifo(Integer grifo) {
		this.grifo = grifo;
	}

	public Integer getGrifoComSN() {
		return grifoComSN;
	}

	public void setGrifoComSN(Integer grifoComSN) {
		this.grifoComSN = grifoComSN;
	}

	public Integer getHorasagua() {
		return horasagua;
	}

	public void setHorasagua(Integer horasagua) {
		this.horasagua = horasagua;
	}

	public String getMcasa() {
		return mcasa;
	}

	public void setMcasa(String mcasa) {
		this.mcasa = mcasa;
	}

	public String getOcasa() {
		return ocasa;
	}

	public void setOcasa(String ocasa) {
		this.ocasa = ocasa;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getOpiso() {
		return opiso;
	}

	public void setOpiso(String opiso) {
		this.opiso = opiso;
	}

	public Integer getTecho() {
		return techo;
	}

	public void setTecho(Integer techo) {
		this.techo = techo;
	}

	public String getOtecho() {
		return otecho;
	}

	public void setOtecho(String otecho) {
		this.otecho = otecho;
	}

	public Integer getCpropia() {
		return cpropia;
	}

	public void setCpropia(Integer cpropia) {
		this.cpropia = cpropia;
	}

	public Integer getCabanicos() {
		return cabanicos;
	}

	public void setCabanicos(Integer cabanicos) {
		this.cabanicos = cabanicos;
	}

	public Integer getCtelevisores() {
		return ctelevisores;
	}

	public void setCtelevisores(Integer ctelevisores) {
		this.ctelevisores = ctelevisores;
	}

	public Integer getCrefrigeradores() {
		return crefrigeradores;
	}

	public void setCrefrigeradores(Integer crefrigeradores) {
		this.crefrigeradores = crefrigeradores;
	}

	public Integer getMoto() {
		return moto;
	}

	public void setMoto(Integer moto) {
		this.moto = moto;
	}

	public Integer getCarro() {
		return carro;
	}

	public void setCarro(Integer carro) {
		this.carro = carro;
	}

	public Integer getCocinalena() {
		return cocinalena;
	}

	public void setCocinalena(Integer cocinalena) {
		this.cocinalena = cocinalena;
	}

	public Integer getAnimalesSN() {
		return animalesSN;
	}

	public void setAnimalesSN(Integer animalesSN) {
		this.animalesSN = animalesSN;
	}

	public Integer getPollos() {
		return pollos;
	}

	public void setPollos(Integer pollos) {
		this.pollos = pollos;
	}

	public Integer getPolloscasa() {
		return polloscasa;
	}

	public void setPolloscasa(Integer polloscasa) {
		this.polloscasa = polloscasa;
	}

	public Integer getPatos() {
		return patos;
	}

	public void setPatos(Integer patos) {
		this.patos = patos;
	}

	public Integer getPatoscasa() {
		return patoscasa;
	}

	public void setPatoscasa(Integer patoscasa) {
		this.patoscasa = patoscasa;
	}

	public Integer getPerros() {
		return perros;
	}

	public void setPerros(Integer perros) {
		this.perros = perros;
	}

	public Integer getPerroscasa() {
		return perroscasa;
	}

	public void setPerroscasa(Integer perroscasa) {
		this.perroscasa = perroscasa;
	}

	public Integer getGatos() {
		return gatos;
	}

	public void setGatos(Integer gatos) {
		this.gatos = gatos;
	}

	public Integer getGatoscasa() {
		return gatoscasa;
	}

	public void setGatoscasa(Integer gatoscasa) {
		this.gatoscasa = gatoscasa;
	}

	public Integer getCerdos() {
		return cerdos;
	}

	public void setCerdos(Integer cerdos) {
		this.cerdos = cerdos;
	}

	public Integer getCerdoscasa() {
		return cerdoscasa;
	}

	public void setCerdoscasa(Integer cerdoscasa) {
		this.cerdoscasa = cerdoscasa;
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

	

}
