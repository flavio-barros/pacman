package br.ufc.pacman.chars;

public class Blocos_Mapa extends Blocos_Basicos {

	private boolean isParede;
	
	public Blocos_Mapa(int x, int y,boolean isParede) {
		super(x, y);
		this.isParede = isParede;
	}

	public boolean isParede() {
		return isParede;
	}

}
