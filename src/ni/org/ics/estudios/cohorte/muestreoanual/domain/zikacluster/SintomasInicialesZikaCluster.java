package ni.org.ics.estudios.cohorte.muestreoanual.domain.zikacluster;

import java.util.Date;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

public class SintomasInicialesZikaCluster{

	/**
	 * 
	 */

	private Integer codigo;
	private Date fis;
	private Date fif;
	private String sintInicial1;
	private String sintInicial2;
	private String sintInicial3;
	private String sintInicial4;
	private String otrorecurso1;
	private String otrorecurso2;
	private MovilInfo movilInfo;

	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFis() {
		return fis;
	}


	public void setFis(Date fis) {
		this.fis = fis;
	}

	public Date getFif() {
		return fif;
	}

	public void setFif(Date fif) {
		this.fif = fif;
	}

	public String getSintInicial1() {
		return sintInicial1;
	}

	public void setSintInicial1(String sintInicial1) {
		this.sintInicial1 = sintInicial1;
	}

	public String getSintInicial2() {
		return sintInicial2;
	}

	public void setSintInicial2(String sintInicial2) {
		this.sintInicial2 = sintInicial2;
	}

	public String getSintInicial3() {
		return sintInicial3;
	}

	public void setSintInicial3(String sintInicial3) {
		this.sintInicial3 = sintInicial3;
	}

	public String getSintInicial4() {
		return sintInicial4;
	}


	public void setSintInicial4(String sintInicial4) {
		this.sintInicial4 = sintInicial4;
	}

	public String getOtrorecurso1() {
		return otrorecurso1;
	}


	public void setOtrorecurso1(String otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}

	public String getOtrorecurso2() {
		return otrorecurso2;
	}


	public void setOtrorecurso2(String otrorecurso2) {
		this.otrorecurso2 = otrorecurso2;
	}

	
	
	public MovilInfo getMovilInfo() {
		return movilInfo;
	}
	
	
	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

}
