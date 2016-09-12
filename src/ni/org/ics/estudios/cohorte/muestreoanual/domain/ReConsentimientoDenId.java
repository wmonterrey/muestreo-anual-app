package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;
import java.util.Date;


public class ReConsentimientoDenId implements Serializable {
	/**
	 * Objeto que representa la clave unica de una encuesta de participante
	 * 
	 * @author Brenda Lopez
	 **/

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Date fechaCons;

	public ReConsentimientoDenId() {

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReConsentimientoDenId))
			return false;
		ReConsentimientoDenId castOther = (ReConsentimientoDenId) other;
		return (this.getCodigo() == castOther.getCodigo())
				&& (this.getFechaCons() == castOther.getFechaCons());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * 3 + this.getCodigo();
		result = 37 * result + Integer.valueOf(this.getFechaCons().toString());
		return result;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFechaCons() {
		return fechaCons;
	}

	public void setFechaCons(Date fechaCons) {
		this.fechaCons = fechaCons;
	}
	
	@Override
	public String toString(){
		return this.codigo.toString();
	}

}