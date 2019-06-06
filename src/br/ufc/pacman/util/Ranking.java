package br.ufc.pacman.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufc.pacman.util.JogadorRanking;

public class Ranking{
	
	private List<JogadorRanking> ranking;
	
	public Ranking() {
		this.ranking = new ArrayList<JogadorRanking>();
	}
	
	public void addJogador(JogadorRanking jogador){
		this.ranking.add(jogador);
	}
	
	public void salvar(){
		try {
			ObjectOutput out = 
				new ObjectOutputStream(new FileOutputStream("ranking.dat"));
			out.writeObject(this.ranking);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void carregar(){
		try {
			ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("ranking.dat"));
			this.ranking = (ArrayList<JogadorRanking>)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public List<JogadorRanking> getRanking() {
		return ranking;
	}
}
