package br.ufc.pacman.chars;

import java.awt.Color;

public class FantasmaRosa extends Personagem {
	
	private int xInicial = 300;
	private int yInicial = 275;
	
	public FantasmaRosa(int x, int y, int direcao) {
		super(x, y, direcao,Color.PINK);
	}
	
	public void voltarPosicaoInicial(){
		this.x = this.xInicial;
		this.y = this.yInicial;
	}

}
