package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;



/**
 * Simple objeto de dominio que representa los datos de la visita al terreno
 * 
 * @author Brenda Lopez
 **/

public class VisitaTerreno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private VisitaTerrenoId visitaId;
	private Integer visitaSN;
	private Integer motNoVisita;
	private String acomp;
	private Integer relacionFam;
	private Integer asentimiento;
	private Integer cDom;
	private Integer barrio;
	private Integer manzana;
	private String direccion;
	private String coordenadas;
	private Double latitud;
	private Double longitud;
	private MovilInfo movilInfo;


	public VisitaTerrenoId getVisitaId() {
		return visitaId;
	}

	public void setVisitaId(VisitaTerrenoId visitaId) {
		this.visitaId = visitaId;
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

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
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
}
