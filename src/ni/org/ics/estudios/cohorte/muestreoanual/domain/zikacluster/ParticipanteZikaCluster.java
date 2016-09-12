package ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster;

import java.io.Serializable;
import java.util.Date;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

public class ParticipanteZikaCluster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer codigo;
	private Integer codigo_indice;
	private Integer codigo_casa;
	private String indice;
	private String cohorte;
	private Date fechana;
	private String nombrept;
	private String nombrept2;
	private String apellidopt;
	private String apellidopt2;
	private String nombrepadre;
	private String nombrepadre2;
	private String apellidopadre;
	private String apellidopadre2;
	private String nombremadre;
	private String nombremadre2;
	private String apellidomadre;
	private String apellidomadre2;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String dondesalud;
	private String centrosalud;
	private String ocentrosalud;
	private String puestosal;
	private String otropuestosal;
	private String solocssf;
	private String idTamizaje;
	private char encuesta='0';
	private char sint1='0';
	private char sint2='0';
	private char sint3='0';
	private char sint4='0';
	private char sint5='0';
	private char sint6='0';
	private char sint7='0';
	private char sint8='0';
	private char sint9='0';
	private char sint10='0';
	private char sint11='0';
	private char sint12='0';
	private char sint13='0';
	private char sint14='0';
	private char sint15='0';
	private char sint16='0';
	private char sint17='0';
	private char sint18='0';
	private char sint19='0';
	private char sint20='0';
	private char sint21='0';
	private char sint22='0';
	private char sint23='0';
	private char sint24='0';
	private char sint25='0';
	private char sint26='0';
	private char sint27='0';
	private char sint28='0';
	private MovilInfo movilInfo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo_indice() {
		return codigo_indice;
	}

	public void setCodigo_indice(Integer codigo_indice) {
		this.codigo_indice = codigo_indice;
	}
	
	public Integer getCodigo_casa() {
		return codigo_casa;
	}
	
	public void setCodigo_casa(Integer codigo_casa) {
		this.codigo_casa = codigo_casa;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getCohorte() {
		return cohorte;
	}

	public void setCohorte(String cohorte) {
		this.cohorte = cohorte;
	}
	
	public Date getFechana() {
		return fechana;
	}

	public void setFechana(Date fechana) {
		this.fechana = fechana;
	}

	public String getNombrept() {
		return nombrept;
	}

	public void setNombrept(String nombrept) {
		this.nombrept = nombrept;
	}

	public String getNombrept2() {
		return nombrept2;
	}

	public void setNombrept2(String nombrept2) {
		this.nombrept2 = nombrept2;
	}

	public String getApellidopt() {
		return apellidopt;
	}

	public void setApellidopt(String apellidopt) {
		this.apellidopt = apellidopt;
	}

	public String getApellidopt2() {
		return apellidopt2;
	}

	public void setApellidopt2(String apellidopt2) {
		this.apellidopt2 = apellidopt2;
	}

	public String getNombrepadre() {
		return nombrepadre;
	}

	public void setNombrepadre(String nombrepadre) {
		this.nombrepadre = nombrepadre;
	}

	public String getNombrepadre2() {
		return nombrepadre2;
	}

	public void setNombrepadre2(String nombrepadre2) {
		this.nombrepadre2 = nombrepadre2;
	}

	public String getApellidopadre() {
		return apellidopadre;
	}

	public void setApellidopadre(String apellidopadre) {
		this.apellidopadre = apellidopadre;
	}

	public String getApellidopadre2() {
		return apellidopadre2;
	}

	public void setApellidopadre2(String apellidopadre2) {
		this.apellidopadre2 = apellidopadre2;
	}

	public String getNombremadre() {
		return nombremadre;
	}

	public void setNombremadre(String nombremadre) {
		this.nombremadre = nombremadre;
	}

	public String getNombremadre2() {
		return nombremadre2;
	}

	public void setNombremadre2(String nombremadre2) {
		this.nombremadre2 = nombremadre2;
	}

	public String getApellidomadre() {
		return apellidomadre;
	}

	public void setApellidomadre(String apellidomadre) {
		this.apellidomadre = apellidomadre;
	}

	public String getApellidomadre2() {
		return apellidomadre2;
	}

	public void setApellidomadre2(String apellidomadre2) {
		this.apellidomadre2 = apellidomadre2;
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

	public String getDondesalud() {
		return dondesalud;
	}

	public void setDondesalud(String dondesalud) {
		this.dondesalud = dondesalud;
	}

	public String getCentrosalud() {
		return centrosalud;
	}

	public void setCentrosalud(String centrosalud) {
		this.centrosalud = centrosalud;
	}

	public String getOcentrosalud() {
		return ocentrosalud;
	}

	public void setOcentrosalud(String ocentrosalud) {
		this.ocentrosalud = ocentrosalud;
	}

	public String getPuestosal() {
		return puestosal;
	}

	public void setPuestosal(String puestosal) {
		this.puestosal = puestosal;
	}

	public String getOtropuestosal() {
		return otropuestosal;
	}

	public void setOtropuestosal(String otropuestosal) {
		this.otropuestosal = otropuestosal;
	}

	public String getSolocssf() {
		return solocssf;
	}

	public void setSolocssf(String solocssf) {
		this.solocssf = solocssf;
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

	public char getSint1() {
		return sint1;
	}

	public void setSint1(char sint1) {
		this.sint1 = sint1;
	}

	public char getSint2() {
		return sint2;
	}

	public void setSint2(char sint2) {
		this.sint2 = sint2;
	}

	public char getSint3() {
		return sint3;
	}

	public void setSint3(char sint3) {
		this.sint3 = sint3;
	}

	public char getSint4() {
		return sint4;
	}

	public void setSint4(char sint4) {
		this.sint4 = sint4;
	}

	public char getSint5() {
		return sint5;
	}

	public void setSint5(char sint5) {
		this.sint5 = sint5;
	}

	public char getSint6() {
		return sint6;
	}

	public void setSint6(char sint6) {
		this.sint6 = sint6;
	}

	public char getSint7() {
		return sint7;
	}

	public void setSint7(char sint7) {
		this.sint7 = sint7;
	}

	public char getSint8() {
		return sint8;
	}

	public void setSint8(char sint8) {
		this.sint8 = sint8;
	}

	public char getSint9() {
		return sint9;
	}

	public void setSint9(char sint9) {
		this.sint9 = sint9;
	}

	public char getSint10() {
		return sint10;
	}

	public void setSint10(char sint10) {
		this.sint10 = sint10;
	}

	public char getSint11() {
		return sint11;
	}

	public void setSint11(char sint11) {
		this.sint11 = sint11;
	}

	public char getSint12() {
		return sint12;
	}

	public void setSint12(char sint12) {
		this.sint12 = sint12;
	}

	public char getSint13() {
		return sint13;
	}

	public void setSint13(char sint13) {
		this.sint13 = sint13;
	}

	public char getSint14() {
		return sint14;
	}

	public void setSint14(char sint14) {
		this.sint14 = sint14;
	}

	public char getSint15() {
		return sint15;
	}

	public void setSint15(char sint15) {
		this.sint15 = sint15;
	}

	public char getSint16() {
		return sint16;
	}

	public void setSint16(char sint16) {
		this.sint16 = sint16;
	}

	public char getSint17() {
		return sint17;
	}

	public void setSint17(char sint17) {
		this.sint17 = sint17;
	}

	public char getSint18() {
		return sint18;
	}

	public void setSint18(char sint18) {
		this.sint18 = sint18;
	}

	public char getSint19() {
		return sint19;
	}

	public void setSint19(char sint19) {
		this.sint19 = sint19;
	}

	public char getSint20() {
		return sint20;
	}

	public void setSint20(char sint20) {
		this.sint20 = sint20;
	}

	public char getSint21() {
		return sint21;
	}

	public void setSint21(char sint21) {
		this.sint21 = sint21;
	}

	public char getSint22() {
		return sint22;
	}

	public void setSint22(char sint22) {
		this.sint22 = sint22;
	}

	public char getSint23() {
		return sint23;
	}

	public void setSint23(char sint23) {
		this.sint23 = sint23;
	}

	public char getSint24() {
		return sint24;
	}

	public void setSint24(char sint24) {
		this.sint24 = sint24;
	}

	public char getSint25() {
		return sint25;
	}

	public void setSint25(char sint25) {
		this.sint25 = sint25;
	}

	public char getSint26() {
		return sint26;
	}

	public void setSint26(char sint26) {
		this.sint26 = sint26;
	}

	public char getSint27() {
		return sint27;
	}

	public void setSint27(char sint27) {
		this.sint27 = sint27;
	}

	public char getSint28() {
		return sint28;
	}

	public void setSint28(char sint28) {
		this.sint28 = sint28;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}
	
}
