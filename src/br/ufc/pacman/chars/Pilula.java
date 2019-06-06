package br.ufc.pacman.chars;

public class Pilula{

	private int x,y,width,height;
	private final int dimensao = 15;

	public boolean isVisivel;

	public Pilula(int x, int y) {
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
