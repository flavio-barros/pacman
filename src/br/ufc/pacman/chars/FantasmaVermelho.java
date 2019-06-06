package br.ufc.pacman.chars;

import java.awt.Color;

public class FantasmaVermelho extends Personagem {
	
	private int xInicial = 200;
	private int yInicial = 275;
	
	public FantasmaVermelho(int x, int y, int direcao) {
		super(x, y, direcao,Color.RED);
	}
	
	public void voltarPosicaoInicial(){
		this.x = this.xInicial;
		this.y = this.yInicial;
	}
}
