package br.ufc.pacman.chars;

import java.awt.Color;

public class FantasmaAzul extends Personagem {
	
	private int xInicial = 325;
	private int yInicial = 175;
	
	public FantasmaAzul(int x, int y, int direcao) {
		super(x, y, direcao,Color.CYAN);
	}
	
	public void voltarPosicaoInicial(){
		this.x = this.xInicial;
		this.y = this.yInicial;
	}
}
