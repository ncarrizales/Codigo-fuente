package Negocio;

public class Matriz {

	private int matriz[][];
	private int fila;
	private int columna;
	
	public Matriz()
	{
		fila = 5;
		columna = 5;
		
		matriz = new int[fila][columna];
	}
	
	public Matriz(int f, int c)
	{
		fila = f;
		columna = c;
		
		matriz = new int[fila][columna];
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public void cargarMatriz()
	{
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				matriz[i][j] = 0;
			}
		}
	}
	
	public void setDato(int f,int c, int dato)
	{
		matriz[f][c] = dato;
	}
	
	public int getDato(int f,int c)
	{
		return matriz[f][c];
	}
	
	
	public void mostrarMatriz()
	{
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
			 	System.out.print( matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
