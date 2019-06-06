package br.ufc.pacman.util;

import java.awt.Color;
import java.util.Random;

import br.ufc.pacman.chars.FantasmaAzul;
import br.ufc.pacman.chars.FantasmaLaranja;
import br.ufc.pacman.chars.FantasmaRosa;
import br.ufc.pacman.chars.FantasmaVermelho;
import br.ufc.pacman.chars.Pacman;
import br.ufc.pacman.chars.Personagem;
import br.ufc.pacman.chars.RepositorioFantasmas;
import br.ufc.pacman.chars.RepositorioMapa;

public class MoveFantasmas {
	
	Random gerador = new Random();
	
	public static void MovimentaFantasmas(RepositorioFantasmas fantasmasRep,RepositorioMapa mapaRep, Pacman pacman){
		Random gerador = new Random();
		
		for(int i=0; i < fantasmasRep.getFantasma().size();i++){
			
			Personagem fantRef = fantasmasRep.getFantasma().get(i);
			
			if(fantRef.getClass() == FantasmaLaranja.class && fantRef.isVisivel){
				while(true){
					fantRef.move(fantRef.getDirecao());
					if(Colisao.isColisaoParede(fantRef, mapaRep)){
						fantRef.desfazer(fantRef.getDirecao());
						fantRef.setDirecao(gerador.nextInt(4));
						break;
					}else if(Colisao.isFantasma(fantRef, fantasmasRep)){
						fantRef.desfazer(fantRef.getDirecao());
						break;
					}
					break;
				}
			}
			
			if(fantRef.getClass() == FantasmaAzul.class && fantRef.isVisivel){
				while(true){
					fantRef.move(fantRef.getDirecao());
					if(Colisao.isColisaoParede(fantRef, mapaRep)){
						fantRef.desfazer(fantRef.getDirecao());
						fantRef.setDirecao(gerador.nextInt(4));
						break;
					}else if(Colisao.isFantasma(fantRef, fantasmasRep)){
						fantRef.desfazer(fantRef.getDirecao());
						break;
					}
					break;
				}
			}
			
			if(fantRef.getClass() == FantasmaVermelho.class && fantRef.isVisivel){
				while(true){
					fantRef.move(fantRef.getDirecao());
					if(Colisao.isColisaoParede(fantRef, mapaRep)){
						fantRef.desfazer(fantRef.getDirecao());
						fantRef.setDirecao(gerador.nextInt(4));
						break;
					}else if(Colisao.isFantasma(fantRef, fantasmasRep)){
						fantRef.desfazer(fantRef.getDirecao());
						break;
					}
					break;
				}
			}
			
			if(fantRef.getClass() == FantasmaRosa.class && fantRef.isVisivel){
				while(true){
					fantRef.move(fantRef.getDirecao());
					if(Colisao.isColisaoParede(fantRef, mapaRep)){
						fantRef.desfazer(fantRef.getDirecao());
						fantRef.setDirecao(gerador.nextInt(4));
						break;
					}else if(Colisao.isFantasma(fantRef, fantasmasRep)){
						fantRef.desfazer(fantRef.getDirecao());
						break;
					}
					break;
				}
			}
			
			
		}
	}
	
	public static void restauraCoresFantasmas(RepositorioFantasmas fantasmasRep){
		
		for(int i = 0; i < fantasmasRep.getFantasma().size();i++){
			Personagem fRef = fantasmasRep.getFantasma().get(i);
			if(fRef.getClass() == FantasmaLaranja.class){
				FantasmaLaranja fantasma = (FantasmaLaranja) fRef;
				fantasma.setColor(Color.ORANGE);
				fantasma.isVisivel = true;
			}else if(fRef.getClass() == FantasmaVermelho.class){
				FantasmaVermelho fantasma = (FantasmaVermelho) fRef;
				fantasma.setColor(Color.RED);
				fantasma.isVisivel = true;
			}else if(fRef.getClass() == FantasmaAzul.class){
				FantasmaAzul fantasma = (FantasmaAzul) fRef;
				fantasma.setColor(Color.CYAN);
				fantasma.isVisivel = true;
			}else if(fRef.getClass() == FantasmaRosa.class){
				FantasmaRosa fantasma = (FantasmaRosa) fRef;
				fantasma.setColor(Color.PINK);
				fantasma.isVisivel = true;
			}
		}
		
	}
}//end of class