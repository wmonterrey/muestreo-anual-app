package ni.org.ics.estudios.cohorte.muestreoanual.domain;

public class Dato {
	
	private String nombre;
	private String valor;
	
	
	
	public Dato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dato(String nombre, String valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
