package br.ufc.pacman.chars;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonagem {
	
	private List<Blocos_Basicos> personagens;
	
	public RepositorioPersonagem(){
		
		this.personagens = new ArrayList<Blocos_Basicos>();
	}

	public List<Blocos_Basicos> getPersonagem() {
		return this.personagens;
	}
	
	public void addPersonagem(Blocos_Basicos personagem){
		this.personagens.add(personagem);
	}
	
	

}
