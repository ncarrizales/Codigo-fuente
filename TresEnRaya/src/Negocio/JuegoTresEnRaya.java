package Negocio;

public class JuegoTresEnRaya {

	private Matriz mt;
	private Jugador jugX;
	private Jugador jugO;
	
	public JuegoTresEnRaya() {
		mt = new Matriz(3,3);
		mt.cargarMatriz();
	}
	
	public void crearJugadorX(String nombre, int ident)
	{
		jugX = new Jugador(nombre, ident, false);
	}
	
	public Matriz getMt() {
		return mt;
	}

	public void setMt(Matriz mt) {
		this.mt = mt;
	}

	public Jugador getJugX() {
		return jugX;
	}

	public void setJugX(Jugador jugX) {
		this.jugX = jugX;
	}

	public Jugador getJugO() {
		return jugO;
	}

	public void setJugO(Jugador jugO) {
		this.jugO = jugO;
	}

	public void crearJugadorO(String nombre, int ident)
	{
		jugO = new Jugador(nombre, ident, false);		
	}
	
	public void ponerDato(int f, int c, int dato)
	{
		mt.setDato(f, c, dato);
	}
	
	public boolean verificarColumna(int c, int dato)
	{
		return( mt.getDato(0, c) == dato && mt.getDato(1, c) == dato && mt.getDato(2, c) == dato);
	}
	
	public boolean verificarFila(int f, int dato)
	{
		return( mt.getDato(f, 0) == dato && mt.getDato(f, 1) == dato && mt.getDato(f, 2) == dato);
	}
	
	public boolean verificarDiagonalDerecha(int dato)
	{
		return( mt.getDato(0, 0) == dato && mt.getDato(1, 1) == dato && mt.getDato(2, 2) == dato);
	}
	
	public boolean verificarDiagonalIzquierda(int dato)
	{
		return( mt.getDato(2, 2) == dato && mt.getDato(1, 1) == dato && mt.getDato(2, 0) == dato);
	}
}
