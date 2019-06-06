package br.ufc.pacman.chars;

import java.awt.Color;

public class Pacman extends Personagem {

	public Pacman(int x, int y) {
		super(x, y,Personagem.leste,Color.YELLOW);
	}

	@Override
	public void desfazer(int direcao){
		if(direcao == Personagem.sul){
			this.setY(this.getY()-5);
		}else if(direcao == Personagem.norte){
			this.setY(this.getY()+5);
		}else if(direcao == Personagem.oeste){
			this.setX(this.getX()+5);
		}else if(direcao == Personagem.leste){
			this.setX(this.getX()-5);
		}
	}
	
	public void voltarPosicaoOriginal(){
		this.setX(325);
		this.setY(125);
		this.setDirecao(Personagem.leste);
	}
	
}
