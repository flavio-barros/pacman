package br.ufc.pacman.main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import br.ufc.pacman.chars.RepositorioPersonagem;
import br.ufc.pacman.gui.DrawPanel;
import br.ufc.pacman.handler.Teclado;
import br.ufc.pacman.thread.MovePersonagens;
import br.ufc.pacman.chars.RepositorioComida;
import br.ufc.pacman.chars.RepositorioFantasmas;
import br.ufc.pacman.chars.RepositorioMapa;
import br.ufc.pacman.chars.Pacman;
import br.ufc.pacman.chars.RepositorioPilula;

@SuppressWarnings("serial")
public class GameMain extends JFrame{
	
	private DrawPanel painelDeDesenho;
	private RepositorioPersonagem repositorio;
	private Teclado teclado;
	private MovePersonagens movePersonagens;
	private RepositorioMapa mapaRep;
	private RepositorioComida comidaRep;
	private RepositorioFantasmas fantasmasRep;
	private RepositorioPilula pilulaRep;
	
	public GameMain(){
		
		//alocando memoria para variaveis de instancia
		this.repositorio = criarRepositorio();
		this.pilulaRep = new RepositorioPilula();
		this.mapaRep = new RepositorioMapa();
		this.comidaRep = new RepositorioComida();
		this.fantasmasRep = new RepositorioFantasmas();
		this.painelDeDesenho = new DrawPanel(this.repositorio,this.mapaRep,this.comidaRep,this.fantasmasRep,this.pilulaRep);
		this.movePersonagens = new MovePersonagens((Pacman)this.repositorio.getPersonagem().get(0), 
												this.painelDeDesenho,this.repositorio,this.mapaRep,this.comidaRep,
												this.fantasmasRep,this.pilulaRep);
		this.teclado = new Teclado((Pacman)this.repositorio.getPersonagem().get(0), this.painelDeDesenho, this.movePersonagens);
		
		//registrando eventos no painel de desenho
		//this.painelDeDesenho.addMouseListener(mouse);
		this.painelDeDesenho.addKeyListener(teclado);
		this.painelDeDesenho.setFocusable(true);
		
		//pegar referencia para um container
		Container c = this.getContentPane();
		//definição do layout para o container
		c.setLayout(new BorderLayout());
		
		//adicionando componentes
		c.add(painelDeDesenho);
		
		//setando configurações
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(400, 10);//posiocionando a janela nas coordenandas indicadas
		this.setTitle("PACMAN");
		this.setVisible(true);
		this.pack();
		
		//this.movePersonagens.start();
		
	}
	
	private RepositorioPersonagem criarRepositorio(){
		RepositorioPersonagem repositorio = new RepositorioPersonagem();
		Pacman p = new Pacman(325, 125);
		repositorio.addPersonagem(p);
		return repositorio;
	}

	public static void main(String[] args) {
		new GameMain();
	}

}