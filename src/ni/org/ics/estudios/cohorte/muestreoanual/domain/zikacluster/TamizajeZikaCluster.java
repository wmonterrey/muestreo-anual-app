package ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster;

import java.io.Serializable;
import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/


public class TamizajeZikaCluster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String idTamizaje;
	private Date fechaTamizaje;
	private String genero;
	private String acepta_cons;
	private String porque_no;
	private String desc_porque_no;
	private String incTrZ;
	private String asentimiento;
	private String alfabeto;
	private String testigo;
	private String nombretest1;
	private String nombretest2;
	private String apellidotest1;
	private String apellidotest2;
	private String parteATrZ;
	private String asentimientoesc;
	private String parteBTrZ;
	private String parteCTrZ;
	private String porqueno;
	private MovilInfo movilInfo;

	
	public String getIdTamizaje() {
		return idTamizaje;
	}

	public void setIdTamizaje(String idTamizaje) {
		this.idTamizaje = idTamizaje;
	}
	
	public Date getFechaTamizaje() {
		return fechaTamizaje;
	}

	public void setFechaTamizaje(Date fechaTamizaje) {
		this.fechaTamizaje = fechaTamizaje;
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
	
	public String getIncTrZ() {
		return incTrZ;
	}

	public void setIncTrZ(String incTrZ) {
		this.incTrZ = incTrZ;
	}

	public String getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(String asentimiento) {
		this.asentimiento = asentimiento;
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

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}
}
