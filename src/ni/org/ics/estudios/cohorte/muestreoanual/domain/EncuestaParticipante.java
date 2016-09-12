package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * Simple objeto de dominio que representa los datos de la encuesta de los
 * participantes en el estudio
 * 
 * @author William Aviles
 **/

public class EncuestaParticipante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private EncuestaParticipanteId epId;
	private Integer fiebre;
	private Integer tiemFieb;
	private Integer lugarCons;
	private Integer noCs;
	private String automed;
	private Integer escuela;
	private Integer grado;
	private Integer turno;
	private Integer nEscuela;
	private String otraEscuela;
	private Integer cuidan;
	private Integer cuantosCuidan;
	private Integer cqVive;
	private Integer lugarPart;
	private Integer papaAlf;
	private Integer papaNivel;
	private Integer papaTra;
	private Integer papaTipoTra;
	private Integer mamaAlf;
	private Integer mamaNivel;
	private Integer mamaTra;
	private Integer mamaTipoTra;
	private Integer comparteHab;
	private Integer hab1;
	private Integer hab2;
	private Integer hab3;
	private Integer hab4;
	private Integer hab5;
	private Integer hab6;
	private Integer comparteCama;
	private Integer cama1;
	private Integer cama2;
	private Integer cama3;
	private Integer cama4;
	private Integer cama5;
	private Integer cama6;
	private Integer asma;
	private Integer silb12m;
	private Integer sitResf;
	private Integer sitEjer;
	private Integer silbMesPas;
	private Integer difHablar;
	private Integer vecHablar;
	private Integer difDormir;
	private Integer suenoPer;
	private Integer tos12m;
	private Integer vecesTos;
	private Integer tos3Dias;
	private Integer hosp12m;
	private Integer med12m;
	private Integer dep12m;
	private Integer crisis;
	private Integer frecAsma;
	private Integer FumaSN;
	private String quienFuma;
	private Integer cantCigarrosMadre;
	private Integer cantCigarrosPadre;
	private Integer cantCigarrosOtros;
	private MovilInfo movilInfo;
	
	private Integer rash;
	private Integer mesActual;
	private Integer yearActual;
	private Integer rash_year;
	private Integer rash_mes;
	private Integer rash_mesact;
	private Integer rashCara;
	private Integer rashMiembrosSup;
	private Integer rashTorax;
	private Integer rashAbdomen;
	private Integer rashMiembrosInf;
	private Integer rashDias;
	private Integer ojoRojo;
	private Integer ojoRojo_year;
	private Integer ojoRojo_mes;
	private Integer ojoRojo_mesact;
	private Integer ojoRojo_Dias;
	private Integer hormigueo;
	private Integer hormigueo_year;
	private Integer hormigueo_mes;
	private Integer hormigueo_mesact;
	private Integer hormigueo_Dias;
	private Integer consultaRashHormigueo;
	private Integer uSaludRashHormigueo;
	private Integer cSaludRashHormigueo;
	private String oCSRashHormigueo;
	private Integer pSRashHormigueo;
	private String oPSRashHormigueo;
	private String diagRashHormigueo;
	private String chPapaMama;
	private Date fechana_papa;
	private Integer cal_edad_papa;
	private Integer cal_edad2_papa;
	private String nombpapa1;
	private String nombpapa2;
	private String apellipapa1;
	private String apellipapa2;
	private Date fechana_mama;
	private Integer cal_edad_mama;
	private Integer cal_edad2_mama;
	private String nombmama1;
	private String nombmama2;
	private String apellimama1;
	private String apellimama2;

	public EncuestaParticipanteId getEpId() {
		return epId;
	}

	public void setEpId(EncuestaParticipanteId epId) {
		this.epId = epId;
	}

	public Integer getFiebre() {
		return fiebre;
	}

	public void setFiebre(Integer fiebre) {
		this.fiebre = fiebre;
	}

	public Integer getTiemFieb() {
		return tiemFieb;
	}

	public void setTiemFieb(Integer tiemFieb) {
		this.tiemFieb = tiemFieb;
	}

	public Integer getLugarCons() {
		return lugarCons;
	}

	public void setLugarCons(Integer lugarCons) {
		this.lugarCons = lugarCons;
	}

	public Integer getNoCs() {
		return noCs;
	}

	public void setNoCs(Integer noCs) {
		this.noCs = noCs;
	}

	public String getAutomed() {
		return automed;
	}

	public void setAutomed(String automed) {
		this.automed = automed;
	}

	public Integer getEscuela() {
		return escuela;
	}

	public void setEscuela(Integer escuela) {
		this.escuela = escuela;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Integer getnEscuela() {
		return nEscuela;
	}

	public void setnEscuela(Integer nEscuela) {
		this.nEscuela = nEscuela;
	}

	public String getOtraEscuela() {
		return otraEscuela;
	}

	public void setOtraEscuela(String otraEscuela) {
		this.otraEscuela = otraEscuela;
	}

	public Integer getCuidan() {
		return cuidan;
	}

	public void setCuidan(Integer cuidan) {
		this.cuidan = cuidan;
	}
	
	public Integer getCuantosCuidan() {
		return cuantosCuidan;
	}

	public void setCuantosCuidan(Integer cuantosCuidan) {
		this.cuantosCuidan = cuantosCuidan;
	}

	public Integer getCqVive() {
		return cqVive;
	}

	public void setCqVive(Integer cqVive) {
		this.cqVive = cqVive;
	}
	
	public Integer getLugarPart() {
		return lugarPart;
	}

	public void setLugarPart(Integer lugarPart) {
		this.lugarPart = lugarPart;
	}

	public Integer getPapaAlf() {
		return papaAlf;
	}

	public void setPapaAlf(Integer papaAlf) {
		this.papaAlf = papaAlf;
	}

	public Integer getPapaNivel() {
		return papaNivel;
	}

	public void setPapaNivel(Integer papaNivel) {
		this.papaNivel = papaNivel;
	}

	public Integer getPapaTra() {
		return papaTra;
	}

	public void setPapaTra(Integer papaTra) {
		this.papaTra = papaTra;
	}

	public Integer getPapaTipoTra() {
		return papaTipoTra;
	}

	public void setPapaTipoTra(Integer papaTipoTra) {
		this.papaTipoTra = papaTipoTra;
	}

	public Integer getMamaAlf() {
		return mamaAlf;
	}

	public void setMamaAlf(Integer mamaAlf) {
		this.mamaAlf = mamaAlf;
	}

	public Integer getMamaNivel() {
		return mamaNivel;
	}

	public void setMamaNivel(Integer mamaNivel) {
		this.mamaNivel = mamaNivel;
	}

	public Integer getMamaTra() {
		return mamaTra;
	}

	public void setMamaTra(Integer mamaTra) {
		this.mamaTra = mamaTra;
	}

	public Integer getMamaTipoTra() {
		return mamaTipoTra;
	}

	public void setMamaTipoTra(Integer mamaTipoTra) {
		this.mamaTipoTra = mamaTipoTra;
	}

	public Integer getComparteHab() {
		return comparteHab;
	}

	public void setComparteHab(Integer comparteHab) {
		this.comparteHab = comparteHab;
	}

	public Integer getHab1() {
		return hab1;
	}

	public void setHab1(Integer hab1) {
		this.hab1 = hab1;
	}

	public Integer getHab2() {
		return hab2;
	}

	public void setHab2(Integer hab2) {
		this.hab2 = hab2;
	}

	public Integer getHab3() {
		return hab3;
	}

	public void setHab3(Integer hab3) {
		this.hab3 = hab3;
	}

	public Integer getHab4() {
		return hab4;
	}

	public void setHab4(Integer hab4) {
		this.hab4 = hab4;
	}

	public Integer getHab5() {
		return hab5;
	}

	public void setHab5(Integer hab5) {
		this.hab5 = hab5;
	}

	public Integer getHab6() {
		return hab6;
	}

	public void setHab6(Integer hab6) {
		this.hab6 = hab6;
	}

	public Integer getComparteCama() {
		return comparteCama;
	}

	public void setComparteCama(Integer comparteCama) {
		this.comparteCama = comparteCama;
	}

	public Integer getCama1() {
		return cama1;
	}

	public void setCama1(Integer cama1) {
		this.cama1 = cama1;
	}

	public Integer getCama2() {
		return cama2;
	}

	public void setCama2(Integer cama2) {
		this.cama2 = cama2;
	}

	public Integer getCama3() {
		return cama3;
	}

	public void setCama3(Integer cama3) {
		this.cama3 = cama3;
	}

	public Integer getCama4() {
		return cama4;
	}

	public void setCama4(Integer cama4) {
		this.cama4 = cama4;
	}

	public Integer getCama5() {
		return cama5;
	}

	public void setCama5(Integer cama5) {
		this.cama5 = cama5;
	}

	public Integer getCama6() {
		return cama6;
	}

	public void setCama6(Integer cama6) {
		this.cama6 = cama6;
	}

	public Integer getAsma() {
		return asma;
	}

	public void setAsma(Integer asma) {
		this.asma = asma;
	}

	public Integer getSilb12m() {
		return silb12m;
	}

	public void setSilb12m(Integer silb12m) {
		this.silb12m = silb12m;
	}

	public Integer getSitResf() {
		return sitResf;
	}

	public void setSitResf(Integer sitResf) {
		this.sitResf = sitResf;
	}

	public Integer getSitEjer() {
		return sitEjer;
	}

	public void setSitEjer(Integer sitEjer) {
		this.sitEjer = sitEjer;
	}

	public Integer getSilbMesPas() {
		return silbMesPas;
	}

	public void setSilbMesPas(Integer silbMesPas) {
		this.silbMesPas = silbMesPas;
	}

	public Integer getDifHablar() {
		return difHablar;
	}

	public void setDifHablar(Integer difHablar) {
		this.difHablar = difHablar;
	}

	public Integer getVecHablar() {
		return vecHablar;
	}

	public void setVecHablar(Integer vecHablar) {
		this.vecHablar = vecHablar;
	}

	public Integer getDifDormir() {
		return difDormir;
	}

	public void setDifDormir(Integer difDormir) {
		this.difDormir = difDormir;
	}

	public Integer getSuenoPer() {
		return suenoPer;
	}

	public void setSuenoPer(Integer suenoPer) {
		this.suenoPer = suenoPer;
	}

	public Integer getTos12m() {
		return tos12m;
	}

	public void setTos12m(Integer tos12m) {
		this.tos12m = tos12m;
	}

	public Integer getVecesTos() {
		return vecesTos;
	}

	public void setVecesTos(Integer vecesTos) {
		this.vecesTos = vecesTos;
	}

	public Integer getTos3Dias() {
		return tos3Dias;
	}

	public void setTos3Dias(Integer tos3Dias) {
		this.tos3Dias = tos3Dias;
	}

	public Integer getHosp12m() {
		return hosp12m;
	}

	public void setHosp12m(Integer hosp12m) {
		this.hosp12m = hosp12m;
	}

	public Integer getMed12m() {
		return med12m;
	}

	public void setMed12m(Integer med12m) {
		this.med12m = med12m;
	}

	public Integer getDep12m() {
		return dep12m;
	}

	public void setDep12m(Integer dep12m) {
		this.dep12m = dep12m;
	}

	public Integer getCrisis() {
		return crisis;
	}

	public void setCrisis(Integer crisis) {
		this.crisis = crisis;
	}

	public Integer getFrecAsma() {
		return frecAsma;
	}

	public void setFrecAsma(Integer frecAsma) {
		this.frecAsma = frecAsma;
	}

	public Integer getFumaSN() {
		return FumaSN;
	}

	public void setFumaSN(Integer fumaSN) {
		FumaSN = fumaSN;
	}

	public String getQuienFuma() {
		return quienFuma;
	}

	public void setQuienFuma(String quienFuma) {
		this.quienFuma = quienFuma;
	}
	
	public Integer getCantCigarrosMadre() {
		return cantCigarrosMadre;
	}

	public void setCantCigarrosMadre(Integer cantCigarrosMadre) {
		this.cantCigarrosMadre = cantCigarrosMadre;
	}

	public Integer getCantCigarrosPadre() {
		return cantCigarrosPadre;
	}

	public void setCantCigarrosPadre(Integer cantCigarrosPadre) {
		this.cantCigarrosPadre = cantCigarrosPadre;
	}

	public Integer getCantCigarrosOtros() {
		return cantCigarrosOtros;
	}

	public void setCantCigarrosOtros(Integer cantCigarrosOtros) {
		this.cantCigarrosOtros = cantCigarrosOtros;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}
	
	@Override
	public String toString() {
		return this.epId.getCodigo().toString();
	}

	public Integer getRash() {
		return rash;
	}

	public void setRash(Integer rash) {
		this.rash = rash;
	}

	public Integer getMesActual() {
		return mesActual;
	}

	public void setMesActual(Integer mesActual) {
		this.mesActual = mesActual;
	}

	public Integer getYearActual() {
		return yearActual;
	}

	public void setYearActual(Integer yearActual) {
		this.yearActual = yearActual;
	}

	public Integer getRash_year() {
		return rash_year;
	}

	public void setRash_year(Integer rash_year) {
		this.rash_year = rash_year;
	}

	public Integer getRash_mes() {
		return rash_mes;
	}

	public void setRash_mes(Integer rash_mes) {
		this.rash_mes = rash_mes;
	}

	public Integer getRash_mesact() {
		return rash_mesact;
	}

	public void setRash_mesact(Integer rash_mesact) {
		this.rash_mesact = rash_mesact;
	}

	public Integer getRashCara() {
		return rashCara;
	}

	public void setRashCara(Integer rashCara) {
		this.rashCara = rashCara;
	}

	public Integer getRashMiembrosSup() {
		return rashMiembrosSup;
	}

	public void setRashMiembrosSup(Integer rashMiembrosSup) {
		this.rashMiembrosSup = rashMiembrosSup;
	}

	public Integer getRashTorax() {
		return rashTorax;
	}

	public void setRashTorax(Integer rashTorax) {
		this.rashTorax = rashTorax;
	}

	public Integer getRashAbdomen() {
		return rashAbdomen;
	}

	public void setRashAbdomen(Integer rashAbdomen) {
		this.rashAbdomen = rashAbdomen;
	}

	public Integer getRashMiembrosInf() {
		return rashMiembrosInf;
	}

	public void setRashMiembrosInf(Integer rashMiembrosInf) {
		this.rashMiembrosInf = rashMiembrosInf;
	}

	public Integer getRashDias() {
		return rashDias;
	}

	public void setRashDias(Integer rashDias) {
		this.rashDias = rashDias;
	}

	public Integer getOjoRojo() {
		return ojoRojo;
	}

	public void setOjoRojo(Integer ojoRojo) {
		this.ojoRojo = ojoRojo;
	}

	public Integer getOjoRojo_year() {
		return ojoRojo_year;
	}

	public void setOjoRojo_year(Integer ojoRojo_year) {
		this.ojoRojo_year = ojoRojo_year;
	}

	public Integer getOjoRojo_mes() {
		return ojoRojo_mes;
	}

	public void setOjoRojo_mes(Integer ojoRojo_mes) {
		this.ojoRojo_mes = ojoRojo_mes;
	}

	public Integer getOjoRojo_mesact() {
		return ojoRojo_mesact;
	}

	public void setOjoRojo_mesact(Integer ojoRojo_mesact) {
		this.ojoRojo_mesact = ojoRojo_mesact;
	}

	public Integer getOjoRojo_Dias() {
		return ojoRojo_Dias;
	}

	public void setOjoRojo_Dias(Integer ojoRojo_Dias) {
		this.ojoRojo_Dias = ojoRojo_Dias;
	}

	public Integer getHormigueo() {
		return hormigueo;
	}

	public void setHormigueo(Integer hormigueo) {
		this.hormigueo = hormigueo;
	}

	public Integer getHormigueo_year() {
		return hormigueo_year;
	}

	public void setHormigueo_year(Integer hormigueo_year) {
		this.hormigueo_year = hormigueo_year;
	}

	public Integer getHormigueo_mes() {
		return hormigueo_mes;
	}

	public void setHormigueo_mes(Integer hormigueo_mes) {
		this.hormigueo_mes = hormigueo_mes;
	}

	public Integer getHormigueo_mesact() {
		return hormigueo_mesact;
	}

	public void setHormigueo_mesact(Integer hormigueo_mesact) {
		this.hormigueo_mesact = hormigueo_mesact;
	}

	public Integer getHormigueo_Dias() {
		return hormigueo_Dias;
	}

	public void setHormigueo_Dias(Integer hormigueo_Dias) {
		this.hormigueo_Dias = hormigueo_Dias;
	}

	public Integer getConsultaRashHormigueo() {
		return consultaRashHormigueo;
	}

	public void setConsultaRashHormigueo(Integer consultaRashHormigueo) {
		this.consultaRashHormigueo = consultaRashHormigueo;
	}

	public Integer getuSaludRashHormigueo() {
		return uSaludRashHormigueo;
	}

	public void setuSaludRashHormigueo(Integer uSaludRashHormigueo) {
		this.uSaludRashHormigueo = uSaludRashHormigueo;
	}

	public Integer getcSaludRashHormigueo() {
		return cSaludRashHormigueo;
	}

	public void setcSaludRashHormigueo(Integer cSaludRashHormigueo) {
		this.cSaludRashHormigueo = cSaludRashHormigueo;
	}

	public String getoCSRashHormigueo() {
		return oCSRashHormigueo;
	}

	public void setoCSRashHormigueo(String oCSRashHormigueo) {
		this.oCSRashHormigueo = oCSRashHormigueo;
	}

	public Integer getpSRashHormigueo() {
		return pSRashHormigueo;
	}

	public void setpSRashHormigueo(Integer pSRashHormigueo) {
		this.pSRashHormigueo = pSRashHormigueo;
	}

	public String getoPSRashHormigueo() {
		return oPSRashHormigueo;
	}

	public void setoPSRashHormigueo(String oPSRashHormigueo) {
		this.oPSRashHormigueo = oPSRashHormigueo;
	}

	public String getDiagRashHormigueo() {
		return diagRashHormigueo;
	}

	public void setDiagRashHormigueo(String diagRashHormigueo) {
		this.diagRashHormigueo = diagRashHormigueo;
	}

	public String getChPapaMama() {
		return chPapaMama;
	}

	public void setChPapaMama(String chPapaMama) {
		this.chPapaMama = chPapaMama;
	}

	public Date getFechana_papa() {
		return fechana_papa;
	}

	public void setFechana_papa(Date fechana_papa) {
		this.fechana_papa = fechana_papa;
	}

	public Integer getCal_edad_papa() {
		return cal_edad_papa;
	}

	public void setCal_edad_papa(Integer cal_edad_papa) {
		this.cal_edad_papa = cal_edad_papa;
	}

	public Integer getCal_edad2_papa() {
		return cal_edad2_papa;
	}

	public void setCal_edad2_papa(Integer cal_edad2_papa) {
		this.cal_edad2_papa = cal_edad2_papa;
	}

	public String getNombpapa1() {
		return nombpapa1;
	}

	public void setNombpapa1(String nombpapa1) {
		this.nombpapa1 = nombpapa1;
	}

	public String getNombpapa2() {
		return nombpapa2;
	}

	public void setNombpapa2(String nombpapa2) {
		this.nombpapa2 = nombpapa2;
	}

	public String getApellipapa1() {
		return apellipapa1;
	}

	public void setApellipapa1(String apellipapa1) {
		this.apellipapa1 = apellipapa1;
	}

	public String getApellipapa2() {
		return apellipapa2;
	}

	public void setApellipapa2(String apellipapa2) {
		this.apellipapa2 = apellipapa2;
	}

	public Date getFechana_mama() {
		return fechana_mama;
	}

	public void setFechana_mama(Date fechana_mama) {
		this.fechana_mama = fechana_mama;
	}

	public Integer getCal_edad_mama() {
		return cal_edad_mama;
	}

	public void setCal_edad_mama(Integer cal_edad_mama) {
		this.cal_edad_mama = cal_edad_mama;
	}

	public Integer getCal_edad2_mama() {
		return cal_edad2_mama;
	}

	public void setCal_edad2_mama(Integer cal_edad2_mama) {
		this.cal_edad2_mama = cal_edad2_mama;
	}

	public String getNombmama1() {
		return nombmama1;
	}

	public void setNombmama1(String nombmama1) {
		this.nombmama1 = nombmama1;
	}

	public String getNombmama2() {
		return nombmama2;
	}

	public void setNombmama2(String nombmama2) {
		this.nombmama2 = nombmama2;
	}

	public String getApellimama1() {
		return apellimama1;
	}

	public void setApellimama1(String apellimama1) {
		this.apellimama1 = apellimama1;
	}

	public String getApellimama2() {
		return apellimama2;
	}

	public void setApellimama2(String apellimama2) {
		this.apellimama2 = apellimama2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
