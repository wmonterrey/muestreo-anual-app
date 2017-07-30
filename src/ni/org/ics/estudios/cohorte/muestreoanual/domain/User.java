package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Simple objeto de dominio que representa un usuario
 * 
 * @author William Aviles
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String username;
	private Date created;
	private String password;
	private String completeName;
	private String email;
	private Boolean enabled=true;
	private Boolean muestra=false;
	private Boolean encuestaCasa=false;
	private Boolean encuestaParticipante=false;
	private Boolean encuestaLactancia=false;
	private Boolean encuestaSatisfaccion=false;
	private Boolean obsequio=false;
	private Boolean pesoTalla=false;
	private Boolean vacunas=false;
	private Boolean visitas=false;
	private Boolean recepcion=false;
	private Boolean consentimiento=false;
	private Boolean casazika=false;
	private Boolean tamizajezika=false;
	private Boolean datosparto=false;
	private String usuario;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Boolean getMuestra() {
		return muestra;
	}
	public void setMuestra(Boolean muestra) {
		this.muestra = muestra;
	}
	
	public Boolean getEncuestaCasa() {
		return encuestaCasa;
	}
	public void setEncuestaCasa(Boolean encuestaCasa) {
		this.encuestaCasa = encuestaCasa;
	}
	
	public Boolean getEncuestaParticipante() {
		return encuestaParticipante;
	}
	public void setEncuestaParticipante(Boolean encuestaParticipante) {
		this.encuestaParticipante = encuestaParticipante;
	}
	
	public Boolean getEncuestaLactancia() {
		return encuestaLactancia;
	}
	public void setEncuestaLactancia(Boolean encuestaLactancia) {
		this.encuestaLactancia = encuestaLactancia;
	}
	
	public Boolean getEncuestaSatisfaccion() {
		return encuestaSatisfaccion;
	}
	public void setEncuestaSatisfaccion(Boolean encuestaSatisfaccion) {
		this.encuestaSatisfaccion = encuestaSatisfaccion;
	}
	
	public Boolean getObsequio() {
		return obsequio;
	}
	public void setObsequio(Boolean obsequio) {
		this.obsequio = obsequio;
	}
	
	public Boolean getPesoTalla() {
		return pesoTalla;
	}
	public void setPesoTalla(Boolean pesoTalla) {
		this.pesoTalla = pesoTalla;
	}
	
	public Boolean getVacunas() {
		return vacunas;
	}
	public void setVacunas(Boolean vacunas) {
		this.vacunas = vacunas;
	}
	
	public Boolean getVisitas() {
		return visitas;
	}
	public void setVisitas(Boolean visitas) {
		this.visitas = visitas;
	}
	
	public Boolean getRecepcion() {
		return recepcion;
	}
	public void setRecepcion(Boolean recepcion) {
		this.recepcion = recepcion;
	}
	public Boolean getConsentimiento() {
		return consentimiento;
	}
	public void setConsentimiento(Boolean consentimiento) {
		this.consentimiento = consentimiento;
	}
	
	public Boolean getCasazika() {
		return casazika;
	}
	public void setCasazika(Boolean casazika) {
		this.casazika = casazika;
	}
	public Boolean getTamizajezika() {
		return tamizajezika;
	}
	public void setTamizajezika(Boolean tamizajezika) {
		this.tamizajezika = tamizajezika;
	}
	
	public Boolean getDatosparto() {
		return datosparto;
	}
	public void setDatosparto(Boolean datosparto) {
		this.datosparto = datosparto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
