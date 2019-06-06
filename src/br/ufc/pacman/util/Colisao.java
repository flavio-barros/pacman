package br.ufc.pacman.util;

import br.ufc.pacman.chars.Comida;
import br.ufc.pacman.chars.FantasmaAzul;
import br.ufc.pacman.chars.FantasmaLaranja;
import br.ufc.pacman.chars.FantasmaRosa;
import br.ufc.pacman.chars.FantasmaVermelho;
import br.ufc.pacman.chars.Pilula;
import br.ufc.pacman.chars.Player;
import br.ufc.pacman.chars.RepositorioFantasmas;
import br.ufc.pacman.chars.RepositorioMapa;
import br.ufc.pacman.chars.Pacman;
import br.ufc.pacman.chars.Personagem;
import br.ufc.pacman.chars.RepositorioPilula;

public class Colisao {
		
	public static boolean isColisaoParede(Personagem p,RepositorioMapa maparep){
		
		int[][] mapa_coo = maparep.getMapa_Coo();
		int x,y;
		y = p.getY()/p.getDimensao();
		x = p.getX()/p.getDimensao();
		
		if(p.getX() >= 500){
			p.setX(0);
			return false;
		}
		
		if(p.getX() <= 0){
			p.setX(500);
			return false;
		}
		
		if(p.getDirecao() == p.getOeste()){
			if(p.getY()%p.getDimensao()>0){
				if(mapa_coo[y][x]==1 || mapa_coo[y+1][x]==1) return true;
			}else{
				if(mapa_coo[y][x]==1) return true;
			}
		}
		
		if(p.getDirecao() == p.getLeste()){
			if(p.getX()%p.getDimensao()>0)x++;
			if(p.getY()%p.getDimensao()>0)y++;
			if(p.getY()%p.getDimensao()>0){
				
				if(mapa_coo[y][x]==1 || mapa_coo[y-1][x]==1) return true;
			}else{
				if(mapa_coo[y][x]==1) return true;
			}
		}
		
		if(p.getDirecao() == p.getNorte()){
			if(p.getX()%p.getDimensao()>0){
				if(mapa_coo[y][x]==1 || mapa_coo[y][x+1]==1) return true;
			}else{
				if(mapa_coo[y][x]==1) return true;
			}
		}
		
		if(p.getDirecao() == p.getSul()){
			if(p.getY()%p.getDimensao()>0)y++;
			if(p.getX()%p.getDimensao()>0)x++;
			if(p.getX()%p.getDimensao()>0){
				if(mapa_coo[y][x]==1 || mapa_coo[y][x-1]==1) return true;
			}else{
				if(mapa_coo[y][x]==1) return true;
			}
		}
		return false;
	}
	
	public static boolean isComida(Pacman pacman,Comida comida){
		double x1,x2,y1,y2;
		
		x1 = pacman.getX()+12.5;
		y1 = pacman.getY()+12.5;
		
		x2 = comida.getX()+2.5;
		y2 = comida.getY()+2.5;
		
		double d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		d = Math.sqrt(d);
		
	 	double r = 12.5;//+2.5;
		
		if(d <= r) 
			return true;
		
		return false;
	}
	
	public static boolean isPilula(Pacman pacman,RepositorioPilula pilulaRep){
		double x1,y1,x2,y2,d,r;
		
		x1 = pacman.getX()+12.5;
		y1 = pacman.getY()+12.5;
		
		for(int i = 0; i < pilulaRep.getPilula().size();i++){
			Pilula pRef = pilulaRep.getPilula().get(i);
			
			x2 = pRef.getX()+7.5;
			y2 = pRef.getY()+7.5;
			
			d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
			d = Math.sqrt(d);
			
			r = 17;
			
			if(d <= r && pRef.isVisivel){
				if(Player.isEfeitoPilula()){
					System.out.println("Passei aqui");
					Player.setContEfeitoPilula(Player.getContEfeitoPilula() - 150);
				}
				Player.setEfeitoPilula(true);
				pRef.isVisivel = false;
				return true;
			}
		}
		return false;
	}
	
	public static boolean isFantasma(Personagem personagem,RepositorioFantasmas fantasmasRep){
		
		double x1,y1,x2,y2,d,r;
		
		x1 = personagem.getX()+12.5;
		y1 = personagem.getY()+12.5;
		
		for(int i = 0; i < fantasmasRep.getFantasma().size();i++){
			Personagem fRef = fantasmasRep.getFantasma().get(i);
			if(personagem.getColor() == fRef.getColor()) continue;
			
			x2 = fRef.getX()+12.5;
			y2 = fRef.getY()+12.5;
			
			d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
			d = Math.sqrt(d);
			
			r = 25;
			
			if(d <= r && fRef.isVisivel){
				if(personagem instanceof Pacman){
					if(Player.isEfeitoPilula()){
						Player.setPontos(Player.getPontos()+100);
						fRef.isVisivel = false;
						if(fRef instanceof FantasmaLaranja){
							FantasmaLaranja fantasma = (FantasmaLaranja) fRef;
							fantasma.voltarPosicaoInicial();
						}else if(fRef instanceof FantasmaVermelho){
							FantasmaVermelho fantasma = (FantasmaVermelho) fRef;
							fantasma.voltarPosicaoInicial();
						}else if(fRef instanceof FantasmaAzul){
							FantasmaAzul fantasma = (FantasmaAzul) fRef;
							fantasma.voltarPosicaoInicial();
						}else if(fRef instanceof FantasmaRosa){
							FantasmaRosa fantasma = (FantasmaRosa) fRef;
							fantasma.voltarPosicaoInicial();
						}
					}else{
						Player.setFoiPego(true);
					}
				}
				return true;
			}
		}
		return false;
	}

}
