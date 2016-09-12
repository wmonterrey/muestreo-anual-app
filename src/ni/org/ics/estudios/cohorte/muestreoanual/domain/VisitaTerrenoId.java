package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;
import java.util.Date;

public class VisitaTerrenoId implements Serializable {
	/**
	 * Objeto que representa la clave unica de una encuesta de participante
	 * 
	 * @author Brenda Lopez
	 **/

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Date fechaVisita;

	

	public VisitaTerrenoId() {

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VisitaTerrenoId))
			return false;
		VisitaTerrenoId castOther = (VisitaTerrenoId) other;
		return (this.getCodigo() == castOther.getCodigo())
				&& (this.getFechaVisita() == castOther.getFechaVisita());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * 3 + this.getCodigo();
		result = 37 * result + Integer.valueOf(this.getFechaVisita().toString());
		return result;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}



}