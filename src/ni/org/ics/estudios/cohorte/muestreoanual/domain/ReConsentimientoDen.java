package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;


/**
 * Simple objeto de dominio que representa los datos de reconsentimiento de Dengue
 * 
 * @author Brenda Lopez
 **/

public class ReConsentimientoDen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ReConsentimientoDenId reconsdenId;
	private Integer autsup;
	private Integer parteADen;
	private String rechazoDen;
	private String otroRechazoDen;
	private String incDen;
	private Integer autsup2;
	private String excDen;
	private Integer enfCronSN;
	private Integer enfCronica;
	private String oEnfCronica;
	private Integer tomaTx;
	private String cualesTx;
	private Integer autsup3;
	private Integer cmDomicilio;
	private Integer barrio;
	private Integer autsup4;
	private String dire;
	private Integer manzana;
	private Integer telefono;	
	private Integer asentimiento;
	private Integer parteBDen;
	private Integer parteCDen;
	private Integer parteDDen;
	private Integer asentimientoesc;
	private Integer parteEDen;
	private String firmcarta;
	private Integer relacionFam;
	private String coordenadas;
	private MovilInfo movilInfo;	

	public ReConsentimientoDenId getReconsdenId() {
		return reconsdenId;
	}

	public void setReconsdenId(ReConsentimientoDenId reconsdenId) {
		this.reconsdenId = reconsdenId;
	}

	public Integer getAutsup() {
		return autsup;
	}

	public void setAutsup(Integer autsup) {
		this.autsup = autsup;
	}

	public String getIncDen() {
		return incDen;
	}

	public void setIncDen(String incDen) {
		this.incDen = incDen;
	}

	public String getExcDen() {
		return excDen;
	}

	public void setExcDen(String excDen) {
		this.excDen = excDen;
	}

	public Integer getEnfCronSN() {
		return enfCronSN;
	}

	public void setEnfCronSN(Integer enfCronSN) {
		this.enfCronSN = enfCronSN;
	}
	
	public Integer getEnfCronica() {
		return enfCronica;
	}
	
	public void setEnfCronica(Integer enfCronica) {
		this.enfCronica = enfCronica;
	}
	
	public String getoEnfCronica() {
		return oEnfCronica;
	}

	public void setoEnfCronica(String oEnfCronica) {
		this.oEnfCronica = oEnfCronica;
	}
	
	public Integer getTomaTx() {
		return tomaTx;
	}

	public void setTomaTx(Integer tomaTx) {
		this.tomaTx = tomaTx;
	}

	public String getCualesTx() {
		return cualesTx;
	}

	public void setCualesTx(String cualesTx) {
		this.cualesTx = cualesTx;
	}

	public Integer getCmDomicilio() {
		return cmDomicilio;
	}

	public void setCmDomicilio(Integer cmDomicilio) {
		this.cmDomicilio = cmDomicilio;
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getAutsup2() {
		return autsup2;
	}

	public void setAutsup2(Integer autsup2) {
		this.autsup2 = autsup2;
	}
	
	public Integer getAutsup3() {
		return autsup3;
	}

	public void setAutsup3(Integer autsup3) {
		this.autsup3 = autsup3;
	}
	
	public Integer getAutsup4() {
		return autsup4;
	}

	public void setAutsup4(Integer autsup4) {
		this.autsup4 = autsup4;
	}

	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	public Integer getParteADen() {
		return parteADen;
	}

	public void setParteADen(Integer parteADen) {
		this.parteADen = parteADen;
	}

	public String getRechazoDen() {
		return rechazoDen;
	}

	public void setRechazoDen(String rechazoDen) {
		this.rechazoDen = rechazoDen;
	}
	
	public String getOtroRechazoDen() {
		return otroRechazoDen;
	}

	public void setOtroRechazoDen(String otroRechazoDen) {
		this.otroRechazoDen = otroRechazoDen;
	}

	public Integer getParteBDen() {
		return parteBDen;
	}

	public void setParteBDen(Integer parteBDen) {
		this.parteBDen = parteBDen;
	}

	public Integer getParteCDen() {
		return parteCDen;
	}

	public void setParteCDen(Integer parteCDen) {
		this.parteCDen = parteCDen;
	}

	public Integer getParteDDen() {
		return parteDDen;
	}

	public void setParteDDen(Integer parteDDen) {
		this.parteDDen = parteDDen;
	}

	public Integer getParteEDen() {
		return parteEDen;
	}

	public void setParteEDen(Integer parteEDen) {
		this.parteEDen = parteEDen;
	}
	
	public Integer getAsentimientoesc() {
		return asentimientoesc;
	}

	public void setAsentimientoesc(Integer asentimientoesc) {
		this.asentimientoesc = asentimientoesc;
	}

	public String getFirmcarta() {
		return firmcarta;
	}

	public void setFirmcarta(String firmcarta) {
		this.firmcarta = firmcarta;
	}

	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
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

	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
	}

}
