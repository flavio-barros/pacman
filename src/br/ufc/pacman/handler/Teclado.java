package br.ufc.pacman.handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.ufc.pacman.chars.*;
import br.ufc.pacman.gui.DrawPanel;
import br.ufc.pacman.sons.Sons;
import br.ufc.pacman.thread.MovePersonagens;

public class Teclado extends KeyAdapter{
	
	private Pacman pacman;
	private DrawPanel painelDeDesenho;
	private MovePersonagens movePersonagens;
		
	public static int ultimaDirecao;
	
	private boolean flag = true; //flag para iniciar a thread somente uma vez
	
	public Teclado(Pacman pacman, DrawPanel painelDeDesenho, MovePersonagens movePersonagens) {
		this.pacman = pacman;
		this.painelDeDesenho = painelDeDesenho;
		this.movePersonagens = movePersonagens;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Player.isMenuVisivel()){
			switch(key){
				case KeyEvent.VK_UP:
					if(Player.rankingSelecionado){
						Player.iniciarSelecionado = true;
						Player.rankingSelecionado = false;
						this.painelDeDesenho.repaint();
					}else if(Player.sairSelecionado){
						Player.sairSelecionado = false;
						Player.rankingSelecionado = true;
						this.painelDeDesenho.repaint();
					}
				break;
				case KeyEvent.VK_DOWN:
					if(Player.iniciarSelecionado){
						Player.iniciarSelecionado = false;
						Player.rankingSelecionado = true;
						this.painelDeDesenho.repaint();
					}else if(Player.rankingSelecionado){
						Player.rankingSelecionado = false;
						Player.sairSelecionado = true;
						this.painelDeDesenho.repaint();
					}
				break;
				case KeyEvent.VK_ENTER:
					if(Player.iniciarSelecionado){
						MovePersonagens.iniciarJogo = true;
						Player.resetVariaveis();
						if(flag){
							this.movePersonagens.start();
							flag = false;
						}
						Player.setMenuVisivel(false);
						Player.setGameIniciou(true);
						this.painelDeDesenho.repaint();
					}else if(Player.rankingSelecionado){
						Player.setMenuVisivel(false);
						Player.setRankingVisivel(true);
						this.painelDeDesenho.repaint();
					}else if(Player.sairSelecionado){
						System.exit(0);
					}
				break;
			}
		}else if(Player.isGameIniciou()){
		
			switch(key){
				case KeyEvent.VK_UP:
					this.pacman.setDirecao(this.pacman.getNorte());
					if(ultimaDirecao != Personagem.norte){
						ultimaDirecao = Personagem.norte;
					}
				break;
				case KeyEvent.VK_DOWN:
					this.pacman.setDirecao(this.pacman.getSul());
					if(ultimaDirecao != Personagem.sul){
						ultimaDirecao = Personagem.sul;
					}
				break;
				case KeyEvent.VK_LEFT:
					this.pacman.setDirecao(this.pacman.getOeste());
					if(ultimaDirecao != Personagem.oeste){
						ultimaDirecao = Personagem.oeste;
					}
				break;
				case KeyEvent.VK_RIGHT:
					this.pacman.setDirecao(this.pacman.getLeste());
					if(ultimaDirecao != Personagem.leste){
						ultimaDirecao = Personagem.leste;
					}
				break;
				case KeyEvent.VK_SPACE:
					if(Player.pause){
						if(Player.isEfeitoPilula()){
							Sons.somPilulaFundo();
						}else Sons.somFundo();
						
						Player.pause = false;
					}else if(!Player.pause){
						if(Player.isEfeitoPilula()){
							Sons.somPilulaFundoParar();
						}else Sons.somFundoParar();
						Player.pause = true;
					}
				break;
			}
				
		}else if(Player.isRankingVisivel()){
			switch(key){
				case KeyEvent.VK_ENTER:
					Player.setRankingVisivel(false);
					Player.setMenuVisivel(true);
					this.painelDeDesenho.repaint();
				break;
			}
		}else if(Player.isGameOver()){
			switch(key){
			case KeyEvent.VK_ENTER:
				Player.setGameOver(false);
				//Player.setRankingVisivel(false);
				Player.setMenuVisivel(true);
				this.painelDeDesenho.repaint();
			break;
		}
		}
	}	
}
