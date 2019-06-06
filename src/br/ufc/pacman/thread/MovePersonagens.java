package br.ufc.pacman.thread;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.swing.JOptionPane;

import br.ufc.pacman.chars.Player;
import br.ufc.pacman.chars.RepositorioComida;
import br.ufc.pacman.chars.RepositorioFantasmas;
import br.ufc.pacman.chars.RepositorioMapa;
import br.ufc.pacman.chars.Pacman;
import br.ufc.pacman.chars.Personagem;
import br.ufc.pacman.chars.RepositorioPersonagem;
import br.ufc.pacman.chars.RepositorioPilula;
import br.ufc.pacman.gui.DrawPanel;
import br.ufc.pacman.sons.Sons;
import br.ufc.pacman.util.Colisao;
import br.ufc.pacman.util.JogadorRanking;
import br.ufc.pacman.util.MoveFantasmas;
import br.ufc.pacman.util.Ranking;


public class MovePersonagens extends Thread {
	
	private Pacman pacman;
	private DrawPanel painelDeDesenho;
	private RepositorioMapa maparep;
	private RepositorioComida comidaRep;
	private RepositorioFantasmas fantasmasRep;
	private RepositorioPilula pilulaRep;
	public Sons som;
	
	public static boolean iniciarJogo = true;
	
	private File arquivo = new File("ranking.dat");
	
	public static int ultimaDirecaoValida = Personagem.leste;
	private boolean flag = false;
	public MovePersonagens(Pacman pacman, DrawPanel painelDeDesenho, RepositorioPersonagem repositorio,
							RepositorioMapa maparep,RepositorioComida comidaRep,RepositorioFantasmas fantasmasRep,
							RepositorioPilula pilulaRep) {
		this.pacman = pacman;
		this.painelDeDesenho = painelDeDesenho;
		this.maparep = maparep;
		this.comidaRep = comidaRep;
		this.fantasmasRep = fantasmasRep;
		this.pilulaRep = pilulaRep;
		this.som = new Sons();
	}
	
	@Override
	public void run(){
		
		Ranking ranking = new Ranking();
		
		while(true){
			System.out.println();
			if(MovePersonagens.iniciarJogo){
				Player.resetVariaveis();
				
				//TEMPO PARA CARREGAR O JOGO
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//TOCANDO O SOM INICIAL
				Sons.somFaseInicio();
				//ESPERA A REPRODUÇÃO DO SOM TERMINAR
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Sons.somFundo();
				
				while(Player.getVidas() > 0){
					
					while(Player.pause){
						System.out.println();
					}
					
					//MOVIMENTA O FANTASMAS
					MoveFantasmas.MovimentaFantasmas(fantasmasRep, maparep,pacman);
					
					//MOVIMENTA O PACMAN
					this.pacman.move(pacman.getDirecao());
					if(Colisao.isColisaoParede(this.pacman, this.maparep)){
						this.pacman.desfazer(this.pacman.getDirecao());
						this.flag = true;
					}else MovePersonagens.ultimaDirecaoValida = this.pacman.getDirecao();
					
					if(this.flag){
						this.pacman.move(MovePersonagens.ultimaDirecaoValida);
						if(Colisao.isColisaoParede(this.pacman, this.maparep))
							this.pacman.desfazer(MovePersonagens.ultimaDirecaoValida);
					}
					this.flag = false;
					
					
					//TESTANDO COLISÃO COM A COMIDA
					for(int i = 0; i<this.comidaRep.getComida().size();i++){
						if(Colisao.isComida(this.pacman, this.comidaRep.getComida().get(i))){
							if(this.comidaRep.getComida().get(i).isVisivel){
								Player.pontuar();
								Player.comeu();
								//this.som.somComerComida();
								this.comidaRep.getComida().get(i).isVisivel = false;
							}
						}
					}
					
					if(Colisao.isPilula(pacman, pilulaRep)){
						for(int i = 0; i<fantasmasRep.getFantasma().size();i++){
							Personagem fRef = fantasmasRep.getFantasma().get(i);
							fRef.setColor(new Color(0f, 0f, 0.6f));
						}
					}
					
					if(Player.isEfeitoPilula()){
						
						if(Player.getContEfeitoPilula() == 0){
							Sons.somFundoParar();
							Sons.somPilulaFundo();
						}
						if(Player.getContEfeitoPilula() == 150){
							Sons.somPilulaFundoParar();
							Sons.somFundo();
						}
						Player.contEfeitoPilulaIncrementa();
						if(Player.getContEfeitoPilula() > 150){
							Player.setEfeitoPilula(false);
							Player.setContEfeitoPilula(0);
							MoveFantasmas.restauraCoresFantasmas(fantasmasRep);
						}
					}
					
					this.painelDeDesenho.repaint();
					
					//TESTANDO COLISAO COM FANTASMAS
					Colisao.isFantasma(pacman, fantasmasRep);
					
					
					//passar de fase
					if(Player.getQtdComida() == 147){
						Player.passarDeFase();
						this.comidaRep.regenerarComidas();
						this.pacman.voltarPosicaoOriginal();
						Player.setQtdComida(0);
						for(int i = 0; i < pilulaRep.getPilula().size();i++){
							this.pilulaRep.getPilula().get(i).isVisivel = true;
						}
						MovePersonagens.ultimaDirecaoValida = Personagem.leste;
						//TOCANDO O SOM INICIAL
						if(Player.isEfeitoPilula()){
							Sons.somPilulaFundoParar();
						}else Sons.somFundoParar();
						
						Sons.somFaseInicio();
						
						if(Player.isEfeitoPilula()){
							Sons.somPilulaFundo();
						}else Sons.somFundo();
						//ESPERA A REPRODUÇÃO DO SOM TERMINAR
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(Player.isFoiPego()){
						Player.setFoiPego(false);
						Player.morrer();
						Sons.somFundoParar();
						Sons.somMorrer();
						try {
							Thread.sleep(1300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Sons.somFundo();
						this.pacman.voltarPosicaoOriginal();
						
					}
					
					try {
						Thread.sleep(Player.velocidade);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//Resetando os dados
				this.pacman.voltarPosicaoOriginal();
				this.comidaRep.regenerarComidas();
				this.pilulaRep.regenerarPilulas();
				this.fantasmasRep.resetarFantasmas();
				
				
				Sons.somFundoParar();
				Sons.somPilulaFundoParar();
				Player.setGameIniciou(false);
				Player.setGameOver(true);	
				
				if(!arquivo.exists()){
					
					Ranking r = new Ranking();
					
					try {
						arquivo.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					r.salvar();
				}
				
				ranking.carregar();
				
				if(ranking.getRanking().size() < 10){
					String nome = JOptionPane.showInputDialog("Novo Recorde!!!!\nDigite seu nome:");
					if(nome == null) nome = "Jogador 1";
					JogadorRanking jr = new JogadorRanking(nome, Player.getPontos());
					ranking.addJogador(jr);
					Collections.sort(ranking.getRanking());
					Player.setGameOver(false);
					Player.setRankingVisivel(true);
					ranking.salvar();
				}else if(ranking.getRanking().size() == 10 && ranking.getRanking().get(9).getPontos() < Player.getPontos()){
					ranking.getRanking().remove(9);
					String nome = JOptionPane.showInputDialog("Novo Recorde!!!!\nDigite seu nome:");
					JogadorRanking jr = new JogadorRanking(nome, Player.getPontos());
					ranking.addJogador(jr);
					Collections.sort(ranking.getRanking());
					ranking.salvar();
					Player.setGameOver(false);
					Player.setRankingVisivel(true);
				}
				
				this.painelDeDesenho.repaint();

				MovePersonagens.iniciarJogo = false;
			}//fim do if(MovePersonagens.iniciarJogo)
		}//fim do laço inicial
	}//fim do método run
}//fim da classe
