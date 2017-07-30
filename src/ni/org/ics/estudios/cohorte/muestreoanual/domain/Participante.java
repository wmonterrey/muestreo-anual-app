package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer codigo;
	private Integer codCasa;
	private Date fecha;
	private Integer estPart;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private Date fechaNac;
	private Integer edad;
	private String nombrePt1;
	private String nombrePt2;
	private String apellidoPt1;
	private String apellidoPt2;
	private Integer relacionFam;
	private String nombrePadre;
	private String nombreMadre;
	private String expediente;
	private Integer asiste;
	private String us;
	private Integer hiDeng;
	private Date cuanDeng;
	private Integer hospDeng;
	private Date cuanHospDeng;
	private String estudio;
	private String pbmc;
	private String consDeng;
	private String consFlu;
	private String consChik;
	private String conmx;
	private String conmxbhc;
	private String encLacMat;
	private String pesoTalla;
	private String encPart;
	private String enCasa;
	private String obsequio;
	private String convalesciente;
	private String infoVacuna;
	private String paxgene;
	private String retoma;
	private Double volRetoma;
	private Integer barrioFicha1;
	private Integer manzFicha1;
	private String barrioDesc;
	private String direcFicha1;
	private Double latitud;
	private Double longitud;
	private String reConsDeng;
	private String zika;
	private String adn;
	private String conPto;
	private String telefono;
	private MovilInfo movilInfo;
	private Integer cuantasPers;
	private String datosParto;
	private String posZika;
	private String datosVisita;
	private String mi;
	private String cand;
	private String casaCHF;

	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getEstPart() {
		return estPart;
	}

	public void setEstPart(Integer estado) {
		this.estPart = estado;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombrePt1() {
		return nombrePt1;
	}

	public void setNombrePt1(String nombrePt1) {
		this.nombrePt1 = nombrePt1;
	}

	public String getNombrePt2() {
		return nombrePt2;
	}

	public void setNombrePt2(String nombrePt2) {
		this.nombrePt2 = nombrePt2;
	}

	public String getApellidoPt1() {
		return apellidoPt1;
	}

	public void setApellidoPt1(String apellidoPt1) {
		this.apellidoPt1 = apellidoPt1;
	}

	public String getApellidoPt2() {
		return apellidoPt2;
	}

	public void setApellidoPt2(String apellidoPt2) {
		this.apellidoPt2 = apellidoPt2;
	}

	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	
	public Integer getAsiste() {
		return asiste;
	}

	public void setAsiste(Integer asiste) {
		this.asiste = asiste;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public Integer getHiDeng() {
		return hiDeng;
	}

	public void setHiDeng(Integer hiDeng) {
		this.hiDeng = hiDeng;
	}

	public Integer getHospDeng() {
		return hospDeng;
	}

	public void setHospDeng(Integer hospDeng) {
		this.hospDeng = hospDeng;
	}

	public Date getCuanDeng() {
		return cuanDeng;
	}

	public void setCuanDeng(Date cuanDeng) {
		this.cuanDeng = cuanDeng;
	}

	public Date getCuanHospDeng() {
		return cuanHospDeng;
	}

	public void setCuanHospDeng(Date cuanHospDeng) {
		this.cuanHospDeng = cuanHospDeng;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public String getPbmc() {
		return pbmc;
	}

	public void setPbmc(String pbmc) {
		this.pbmc = pbmc;
	}

	public String getConsDeng() {
		return consDeng;
	}

	public void setConsDeng(String consDeng) {
		this.consDeng = consDeng;
	}

	public String getConsFlu() {
		return consFlu;
	}

	public void setConsFlu(String consFlu) {
		this.consFlu = consFlu;
	}
	
	public String getConsChik() {
		return consChik;
	}

	public void setConsChik(String consChik) {
		this.consChik = consChik;
	}

	public String getConmx() {
		return conmx;
	}

	public void setConmx(String conmx) {
		this.conmx = conmx;
	}

	public String getEncLacMat() {
		return encLacMat;
	}

	public void setEncLacMat(String encLacMat) {
		this.encLacMat = encLacMat;
	}

	public String getPesoTalla() {
		return pesoTalla;
	}

	public void setPesoTalla(String pesoTalla) {
		this.pesoTalla = pesoTalla;
	}

	public String getEncPart() {
		return encPart;
	}

	public void setEncPart(String encPart) {
		this.encPart = encPart;
	}
	
	public String getEnCasa() {
		return enCasa;
	}

	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConmxbhc() {
		return conmxbhc;
	}

	public void setConmxbhc(String conmxbhc) {
		this.conmxbhc = conmxbhc;
	}

	public String getObsequio() {
		return obsequio;
	}

	public void setObsequio(String obsequio) {
		this.obsequio = obsequio;
	}

	public String getConvalesciente() {
		return convalesciente;
	}

	public void setConvalesciente(String convalesciente) {
		this.convalesciente = convalesciente;
	}

	public String getInfoVacuna() {
		return infoVacuna;
	}

	public void setInfoVacuna(String infoVacuna) {
		this.infoVacuna = infoVacuna;
	}

	public String getPaxgene() {
		return paxgene;
	}

	public void setPaxgene(String paxgene) {
		this.paxgene = paxgene;
	}

	public String getRetoma() {
		return retoma;
	}

	public void setRetoma(String retoma) {
		this.retoma = retoma;
	}

	public Double getVolRetoma() {
		return volRetoma;
	}

	public void setVolRetoma(Double volRetoma) {
		this.volRetoma = volRetoma;
	}

	public Integer getManzFicha1() {
		return manzFicha1;
	}

	public void setManzFicha1(Integer manzFicha1) {
		this.manzFicha1 = manzFicha1;
	}

	public Integer getBarrioFicha1() {
		return barrioFicha1;
	}

	public void setBarrioFicha1(Integer barrioFicha1) {
		this.barrioFicha1 = barrioFicha1;
	}

	public String getBarrioDesc() {
		return barrioDesc;
	}

	public void setBarrioDesc(String barrioDesc) {
		this.barrioDesc = barrioDesc;
	}

	public String getDirecFicha1() {
		return direcFicha1;
	}

	public void setDirecFicha1(String direcFicha1) {
		this.direcFicha1 = direcFicha1;
	}

	public String getReConsDeng() {
		return reConsDeng;
	}

	public void setReConsDeng(String reConsDeng) {
		this.reConsDeng = reConsDeng;
	}

	public String getConPto() {
		return conPto;
	}

	public void setConPto(String conPto) {
		this.conPto = conPto;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getZika() {
		return zika;
	}

	public void setZika(String zika) {
		this.zika = zika;
	}

	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	public Integer getCuantasPers() {
		return cuantasPers;
	}

	public void setCuantasPers(Integer cuantasPers) {
		this.cuantasPers = cuantasPers;
	}

	public String getDatosParto() {
		return datosParto;
	}

	public void setDatosParto(String datosParto) {
		this.datosParto = datosParto;
	}

	public String getPosZika() {
		return posZika;
	}

	public void setPosZika(String posZika) {
		this.posZika = posZika;
	}

	public String getDatosVisita() {
		return datosVisita;
	}

	public void setDatosVisita(String datosVisita) {
		this.datosVisita = datosVisita;
	}

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getCand() {
		return cand;
	}

	public void setCand(String cand) {
		this.cand = cand;
	}

	public String getCasaCHF() {
		return casaCHF;
	}

	public void setCasaCHF(String casaCHF) {
		this.casaCHF = casaCHF;
	}
	
	
	

}
