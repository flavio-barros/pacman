package br.ufc.pacman.chars;

public class Blocos_Basicos {
	
	protected int x;
	protected int y;
	private final int dimensao = 25;
	
	public Blocos_Basicos(int x, int y) {
		this.x = x;
		this.y = y;
		//this.width = dimensao;
		//this.height = dimensao;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDimensao() {
		return dimensao;
	}
}
