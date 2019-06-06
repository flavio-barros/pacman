package br.ufc.pacman.chars;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFantasmas {
	
private List<Personagem> fantasmasRep;
	
	public RepositorioFantasmas(){
		
		this.fantasmasRep = new ArrayList<Personagem>();
		FantasmaLaranja fl = new FantasmaLaranja(175, 175, Personagem.sul);
		FantasmaAzul fa = new FantasmaAzul(325, 175, Personagem.oeste);
		FantasmaVermelho fv= new FantasmaVermelho(200, 275, Personagem.sul);
		FantasmaRosa fr= new FantasmaRosa(300, 275, Personagem.sul);
		
		this.fantasmasRep.add(fl);
		this.fantasmasRep.add(fa);
		this.fantasmasRep.add(fv);
		this.fantasmasRep.add(fr);
	}

	public List<Personagem> getFantasma() {
		return this.fantasmasRep;
	}
	
	public void addFanatasma(Personagem fantasma){
		this.fantasmasRep.add(fantasma);
	}
	
	public void resetarFantasmas(){
		
		for(Personagem p : fantasmasRep){
			if(p instanceof FantasmaAzul){
				p = (FantasmaAzul) p;
				((FantasmaAzul) p).voltarPosicaoInicial();
			}else if(p instanceof FantasmaRosa){
				p = (FantasmaRosa) p;
				((FantasmaRosa) p).voltarPosicaoInicial();
			}else if(p instanceof FantasmaVermelho){
				p = (FantasmaVermelho) p;
				((FantasmaVermelho) p).voltarPosicaoInicial();
			}else if(p instanceof FantasmaLaranja){
				p = (FantasmaLaranja) p;
				((FantasmaLaranja) p).voltarPosicaoInicial();
			}
		}
	}

}
