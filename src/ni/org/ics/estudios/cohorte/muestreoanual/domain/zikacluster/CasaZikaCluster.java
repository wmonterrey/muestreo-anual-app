package ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster;

import java.io.Serializable;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

public class CasaZikaCluster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Integer codigo_casa;
	private String barrio;
	private String jefenom;
	private String jefenom2;
	private String jefeap;
	private String jefeap2;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String georef;
	private String Manzana;
	private String georef_razon;
	private String georef_otraRazon;
	private String idTamizaje;
	private char encuesta='0';
	private char encuestaEnt='0';
	private MovilInfo movilInfo;
		
	public Integer getCodigo_casa() {
		return codigo_casa;
	}
	
	public void setCodigo_casa(Integer codigo_casa) {
		this.codigo_casa = codigo_casa;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
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

	public String getIdTamizaje() {
		return idTamizaje;
	}

	public void setIdTamizaje(String idTamizaje) {
		this.idTamizaje = idTamizaje;
	}
	

	public char getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(char encuesta) {
		this.encuesta = encuesta;
	}
	
	public char getEncuestaEnt() {
		return encuestaEnt;
	}

	public void setEncuestaEnt(char encuestaEnt) {
		this.encuestaEnt = encuestaEnt;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}
	
	public MovilInfo getMovilInfo() {
		return movilInfo;
	}	
}
