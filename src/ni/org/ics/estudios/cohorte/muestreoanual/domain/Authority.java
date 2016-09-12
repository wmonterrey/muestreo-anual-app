package ni.org.ics.estudios.cohorte.muestreoanual.domain;





/**
 * Simple objeto de dominio que representa un rol
 * 
 * @author William Aviles
 **/

public class Authority {
	
	private AuthorityId authId;
	private User user;
	private Rol rol;
	
	
	
	public AuthorityId getAuthId() {
		return authId;
	}
	public void setAuthId(AuthorityId authId) {
		this.authId = authId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
