package 
br.ufc.pacman.chars;

import java.awt.Color;

public class Personagem extends Blocos_Basicos{
	
	private int direcao;
	public Color color;
	
	public static final int norte = 0;
	public static final int leste = 1;
	public static final int sul = 2;
	public static final int oeste = 3;
	
	public boolean isVisivel = true;
	
	public Personagem(int x,int y,int direcao, Color color) {
		super(x,y);
		this.direcao = direcao;
		this.color = color;
	}
	
	public void move(int direcao){
		if(direcao == Personagem.sul){
			this.setY(this.getY()+5);
		}else if(direcao == Personagem.norte){
			this.setY(this.getY()-5);
		}else if(direcao == Personagem.oeste){
			this.setX(this.getX()-5);
		}else if(direcao == Personagem.leste){
			this.setX(this.getX()+5);
		}
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public int getNorte() {
		return norte;
	}

	public int getLeste() {
		return leste;
	}

	public int getSul() {
		return sul;
	}

	public int getOeste() {
		return oeste;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void desfazer(int direcao){
		if(direcao == Personagem.sul){
			this.setDirecao(Personagem.norte);
			this.move(this.getDirecao());
		}else if(direcao == Personagem.norte){
			this.setDirecao(Personagem.sul);
			this.move(this.getDirecao());
		}else if(direcao == Personagem.oeste){
			this.setDirecao(Personagem.leste);
			this.move(this.getDirecao());
		}else if(direcao == Personagem.leste){
			this.setDirecao(Personagem.oeste);
			this.move(this.getDirecao());
		}
	}
}
