package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Simple objeto de dominio que representa los datos demograficos de la casa
 * donde habitan 1 o mas participantes de los
 * 
 * estudios
 * 
 * @author Brenda Lopez
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Casa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer codCasa;
	private Integer barrio;
	private String direccion;
	private Integer manzana;
	private Double latitud;
	private Double longitud;
	private Integer telCasa;
	private String coordenadas;
	private String jefenom;
	private String jefenom2;
	private String jefeap;
	private String jefeap2;
	private Integer telefono1;
	private Integer telefono2;
	private String nomContacto;
	private String direContacto;
	private Integer barrioContacto;
	private String otrobarrioContacto;
	private Integer telContacto1;
	private Integer telContacto2;
	private Integer vivienda;
	private Integer resd;
	private Integer inten;
	private String enCasa;
	private MovilInfo movilInfo;

	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	
	public Integer getBarrio() {
		return barrio;
	}

	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getManzana() {
		return manzana;
	}

	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Integer getTelCasa() {
		return telCasa;
	}

	public void setTelCasa(Integer telCasa) {
		this.telCasa = telCasa;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
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

	public Integer getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1 = telefono1;
	}

	public Integer getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	public String getNomContacto() {
		return nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getDireContacto() {
		return direContacto;
	}

	public void setDireContacto(String direContacto) {
		this.direContacto = direContacto;
	}

	public Integer getBarrioContacto() {
		return barrioContacto;
	}

	public void setBarrioContacto(Integer barrioContacto) {
		this.barrioContacto = barrioContacto;
	}

	public String getOtrobarrioContacto() {
		return otrobarrioContacto;
	}

	public void setOtrobarrioContacto(String otrobarrioContacto) {
		this.otrobarrioContacto = otrobarrioContacto;
	}

	public Integer getTelContacto1() {
		return telContacto1;
	}

	public void setTelContacto1(Integer telContacto1) {
		this.telContacto1 = telContacto1;
	}

	public Integer getTelContacto2() {
		return telContacto2;
	}

	public void setTelContacto2(Integer telContacto2) {
		this.telContacto2 = telContacto2;
	}

	public Integer getVivienda() {
		return vivienda;
	}

	public void setVivienda(Integer vivienda) {
		this.vivienda = vivienda;
	}

	public Integer getResd() {
		return resd;
	}

	public void setResd(Integer resd) {
		this.resd = resd;
	}

	public Integer getInten() {
		return inten;
	}

	public void setInten(Integer inten) {
		this.inten = inten;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}



	public String getEnCasa() {
		return enCasa;
	}

	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

	@Override
	public String toString(){
		return this.codCasa.toString();
	}
}
