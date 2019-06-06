package br.ufc.pacman.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import br.ufc.pacman.chars.Comida;
import br.ufc.pacman.chars.FantasmaAzul;
import br.ufc.pacman.chars.FantasmaLaranja;
import br.ufc.pacman.chars.FantasmaRosa;
import br.ufc.pacman.chars.FantasmaVermelho;
import br.ufc.pacman.chars.Pilula;
import br.ufc.pacman.chars.Player;
import br.ufc.pacman.chars.RepositorioPilula;
import br.ufc.pacman.chars.RepositorioComida;
import br.ufc.pacman.chars.RepositorioFantasmas;
import br.ufc.pacman.chars.RepositorioMapa;
import br.ufc.pacman.chars.Personagem;
import br.ufc.pacman.chars.RepositorioPersonagem;
import br.ufc.pacman.thread.MovePersonagens;
import br.ufc.pacman.util.JogadorRanking;
import br.ufc.pacman.util.Ranking;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel{
	
	private RepositorioPersonagem repositorio;
	private RepositorioMapa maparep;
	private RepositorioComida comidaRep;
	private RepositorioFantasmas fantasmasRep;
	private RepositorioPilula pilulaRep;
	private Ranking ranking = new Ranking();
	
	BufferedImage fantasmaVermelhoNorte;
	BufferedImage fantasmaVermelhoSul;
	BufferedImage fantasmaVermelhoLeste;
	BufferedImage fantasmaVermelhoOeste;
	BufferedImage fantasmaAzulNorte;
	BufferedImage fantasmaAzulSul;
	BufferedImage fantasmaAzulLeste;
	BufferedImage fantasmaAzulOeste;
	BufferedImage fantasmaRosaNorte;
	BufferedImage fantasmaRosaSul;
	BufferedImage fantasmaRosaLeste;
	BufferedImage fantasmaRosaOeste;
	BufferedImage fantasmaLaranjaNorte;
	BufferedImage fantasmaLaranjaSul;
	BufferedImage fantasmaLaranjaLeste;
	BufferedImage fantasmaLaranjaOeste;
	
	BufferedImage fantasmaPego;
	
	BufferedImage pacmanNorte;
	BufferedImage pacmanSul;
	BufferedImage pacmanLeste;
	BufferedImage pacmanOeste;
	
	ImageObserver io;
			
	public DrawPanel(RepositorioPersonagem repositorio, RepositorioMapa maparep, RepositorioComida comidaRep,
					RepositorioFantasmas fantasmasRep, RepositorioPilula pilulaRep) {
		this.repositorio = repositorio;
		this.maparep = maparep;
		this.comidaRep = comidaRep;
		this.fantasmasRep = fantasmasRep;
		this.pilulaRep = pilulaRep;
		this.setPreferredSize(new Dimension(525,550));
		this.setBackground(Color.BLACK);
		
		//carregando as imagens
		try {
			   this.fantasmaVermelhoNorte = ImageIO.read(new File("imgs/fantasmaVermelhoNorte.png"));
			   this.fantasmaVermelhoSul = ImageIO.read(new File("imgs/fantasmaVermelhoSul.png"));
			   this.fantasmaVermelhoLeste = ImageIO.read(new File("imgs/fantasmaVermelhoLeste.png"));
			   this.fantasmaVermelhoOeste = ImageIO.read(new File("imgs/fantasmaVermelhoOeste.png"));
			   this.fantasmaAzulNorte = ImageIO.read(new File("imgs/fantasmaAzulNorte.png"));
			   this.fantasmaAzulSul = ImageIO.read(new File("imgs/fantasmaAzulSul.png"));
			   this.fantasmaAzulLeste = ImageIO.read(new File("imgs/fantasmaAzulLeste.png"));
			   this.fantasmaAzulOeste = ImageIO.read(new File("imgs/fantasmaAzulOeste.png"));
			   this.fantasmaRosaNorte = ImageIO.read(new File("imgs/fantasmaRosaNorte.png"));
			   this.fantasmaRosaSul = ImageIO.read(new File("imgs/fantasmaRosaSul.png"));
			   this.fantasmaRosaLeste = ImageIO.read(new File("imgs/fantasmaRosaLeste.png"));
			   this.fantasmaRosaOeste = ImageIO.read(new File("imgs/fantasmaRosaOeste.png"));
			   this.fantasmaLaranjaNorte = ImageIO.read(new File("imgs/fantasmaLaranjaNorte.png"));
			   this.fantasmaLaranjaSul = ImageIO.read(new File("imgs/fantasmaLaranjaSul.png"));
			   this.fantasmaLaranjaLeste = ImageIO.read(new File("imgs/fantasmaLaranjaLeste.png"));
			   this.fantasmaLaranjaOeste = ImageIO.read(new File("imgs/fantasmaLaranjaOeste.png"));
			   this.fantasmaPego = ImageIO.read(new File("imgs/fantasmaPego.png"));
			   
			   this.pacmanNorte = ImageIO.read(new File("imgs/pacmanNorte.png"));
			   this.pacmanSul = ImageIO.read(new File("imgs/pacmanSul.png"));
			   this.pacmanLeste = ImageIO.read(new File("imgs/pacmanLeste.png"));
			   this.pacmanOeste = ImageIO.read(new File("imgs/pacmanOeste.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics tela = g.create();
		
		if(Player.isMenuVisivel()){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif",Font.BOLD, 80));
			g.drawString("Pacman", 85, 100);
			
			g.setFont(new Font("SansSerif",Font.BOLD, 40));
			
			if(Player.iniciarSelecionado)
				g.setColor(Color.YELLOW);
			else
				g.setColor(Color.WHITE);
			
			g.drawString("Iniciar", 160, 200);
			
			if(Player.rankingSelecionado)
				g.setColor(Color.YELLOW);
			else
				g.setColor(Color.WHITE);
			g.drawString("Ranking", 160, 270);
			
			if(Player.sairSelecionado)
				g.setColor(Color.YELLOW);
			else
				g.setColor(Color.WHITE);
			g.drawString("Sair", 160, 340);
			
		}else if(Player.isGameOver()){
			g.setColor(Color.RED);
			g.setFont(new Font("SansSerif",Font.BOLD, 40));
			g.drawString("GAME OVER",120,200);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SansSerif",Font.BOLD, 20));
			g.drawString("Voltar",230,300);
		}else if (Player.isRankingVisivel()){
			g.setColor(Color.WHITE);
			this.ranking.carregar();
			int cont = 1;
			int y = 100;
			
			g.setFont(new Font("SansSerif",Font.BOLD, 30));
			g.drawString("Ranking", 190, 45);
			g.setFont(new Font("SansSerif",Font.BOLD, 20));
			for(JogadorRanking jr : this.ranking.getRanking()){
				g.drawString(cont+" - "+jr.getNome()+" - "+jr.getPontos()+" pontos", 50, y);
				y+=30;
				cont++;
			}
			
			g.setColor(Color.YELLOW);
			g.drawString("Voltar", 220, 430);
			
		}else if(Player.isGameIniciou()){
			//printing the map
			for(int i=0;i<this.maparep.getMapa().size();i++){
				int[][] aux = maparep.getMapa_Coo();
				for(int j=0;j<aux.length;j++){
					for(int l=0;l<aux.length;l++){
						if(aux[j][l]==1){
						g.setColor(Color.DARK_GRAY);
						g.fillRect(l*maparep.getMapa().get(0).getDimensao(), j*maparep.getMapa().get(0).getDimensao(), maparep.getMapa().get(0).getDimensao(), maparep.getMapa().get(0).getDimensao());
						}
					}
				}
			}
			
			for(Comida c : comidaRep.getComida()){
				g.setColor(Color.WHITE);
				if(c.isVisivel)
					g.fillOval(c.getX(), c.getY(), c.getDimensao(), c.getDimensao());
			}
			
			for(int i=0;i<this.repositorio.getPersonagem().size();i++){
				Personagem pRef = (Personagem) this.repositorio.getPersonagem().get(i);
				if(MovePersonagens.ultimaDirecaoValida == Personagem.leste){
					g.drawImage(pacmanLeste, pRef.getX(), pRef.getY(), io);
				}else if(MovePersonagens.ultimaDirecaoValida == Personagem.oeste){
					g.drawImage(pacmanOeste, pRef.getX(), pRef.getY(), io);
				}else if(MovePersonagens.ultimaDirecaoValida == Personagem.norte){
					g.drawImage(pacmanNorte, pRef.getX(), pRef.getY(), io);
				}else if(MovePersonagens.ultimaDirecaoValida == Personagem.sul){
					g.drawImage(pacmanSul, pRef.getX(), pRef.getY(), io);
				}
			}
			
			for(Pilula p : pilulaRep.getPilula()){
				g.setColor(Color.WHITE);
				if(p.isVisivel)
					g.fillOval(p.getX(), p.getY(), p.getDimensao(), p.getDimensao());
			}
			
			for(Personagem p : this.fantasmasRep.getFantasma()){
				g.setColor(p.getColor());
				
				if(p.isVisivel && !Player.isEfeitoPilula()){
					if(p instanceof FantasmaVermelho){
						if(p.getDirecao() == Personagem.norte)
							g.drawImage(fantasmaVermelhoNorte, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.sul)
							g.drawImage(fantasmaVermelhoSul, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.leste)
							g.drawImage(fantasmaVermelhoLeste, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.oeste)
						g.drawImage(fantasmaVermelhoOeste, p.getX(), p.getY(), io);
					}else if(p instanceof FantasmaRosa){
						if(p.getDirecao() == Personagem.norte)
							g.drawImage(fantasmaRosaNorte, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.sul)
							g.drawImage(fantasmaRosaSul, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.leste)
							g.drawImage(fantasmaRosaLeste, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.oeste)
						g.drawImage(fantasmaRosaOeste, p.getX(), p.getY(), io);
					}else if(p instanceof FantasmaLaranja){
						if(p.getDirecao() == Personagem.norte)
							g.drawImage(fantasmaLaranjaNorte, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.sul)
							g.drawImage(fantasmaLaranjaSul, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.leste)
							g.drawImage(fantasmaLaranjaLeste, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.oeste)
						g.drawImage(fantasmaLaranjaOeste, p.getX(), p.getY(), io);
					}else if(p instanceof FantasmaAzul){
						if(p.getDirecao() == Personagem.norte)
							g.drawImage(fantasmaAzulNorte, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.sul)
							g.drawImage(fantasmaAzulSul, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.leste)
							g.drawImage(fantasmaAzulLeste, p.getX(), p.getY(), io);
						else if(p.getDirecao() == Personagem.oeste)
						g.drawImage(fantasmaAzulOeste, p.getX(), p.getY(), io);
					}
					
				}else if(p.isVisivel && Player.isEfeitoPilula()){
					g.drawImage(fantasmaPego, p.getX(), p.getY(), io);
				}
				if(Player.pause){
					//g.setColor(Color.DARK_GRAY);
					//g.fillRect(150, 175, 225, 75);
					g.setColor(Color.RED);
					g.setFont(new Font("SansSerif",Font.BOLD, 50));
					g.drawString("PAUSE", 168, 230);
				}
				
			}
			
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("SansSerif",Font.BOLD, 15));
			g.drawString("Pontos: "+Player.getPontos(), 0, 540);
			
			g.drawString("Vidas: "+Player.getVidas(), 150, 540);
			
			g.drawString("Fase: "+Player.getFase(), 300, 540);
			
			tela.dispose();
		}
	}
	
}

