package br.ufc.pacman.chars;

public class Comida {

	private int x,y,width,height;
	private final int dimensao = 5;

	public boolean isVisivel;

	public Comida(int x, int y) {
		this.x = x;
		this.y = y;
		this.height = this.dimensao;
		this.width = this.dimensao;
		this.isVisivel = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDimensao() {
		return dimensao;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

}
