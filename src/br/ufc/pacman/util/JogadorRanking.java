package br.ufc.pacman.util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JogadorRanking implements Comparable<JogadorRanking>, Serializable{
	
	private String nome;
	private int pontos;
	
	public JogadorRanking(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public int compareTo(JogadorRanking jr) {
		if(jr.getPontos() > this.pontos) return 1;
		if(jr.getPontos() < this.pontos) return -1;
		return 0;
	}

}
