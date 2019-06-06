package br.ufc.pacman.chars;

import java.awt.Color;

public class FantasmaLaranja extends Personagem {
	
	private int xInicial = 175;
	private int yInicial = 175;
	
	public FantasmaLaranja(int x, int y, int direcao) {
		super(x, y, direcao,Color.ORANGE);
	}
	
	public void voltarPosicaoInicial(){
		this.x = this.xInicial;
		this.y = this.yInicial;
	}
	
}
