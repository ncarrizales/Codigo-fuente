package Negocio;

public class Jugador {
	private String nombre;
	private int identificador;
	private boolean estado;
	private int contador;
	
	public Jugador() {
		super();
		nombre = "";
		identificador = 0;
		estado = false;
		contador = 0;
	}
	public Jugador(String nombre, int identificador,boolean estado) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.estado = estado;
		contador = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
}
