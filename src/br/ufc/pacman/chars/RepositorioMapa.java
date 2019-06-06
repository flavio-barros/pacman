package br.ufc.pacman.chars;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMapa{
	
	private List<Blocos_Mapa> mapa;
	private int[][] mapa_Coo = {{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},//OK
								{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0},//OK
								{0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1,0},//OK
								{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//OK
								{0,1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,1,0},//OK
								{0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0},//OK
								{0,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0},//OK
								{0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0},//OK
								{1,1,1,1,1,0,1,0,1,1,0,1,1,0,1,0,1,1,1,1,1},//OK
								{0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},//OK
								{1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1},//OK
								{0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0},//OK
								{0,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,0},//OK
								{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0},//OK
								{0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1,0},//OK
								{0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},//OK
								{0,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0},//OK
								{0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0},//OK
								{0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0},//OK
								{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//OK
								{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}};//OK
	
	public RepositorioMapa() {
		this.mapa = new ArrayList<Blocos_Mapa>();
		boolean aux=false;
		for(int i = 0;i<this.mapa_Coo.length;i++){
			for(int j=0;j<this.mapa_Coo.length;j++){
				if(this.mapa_Coo[i][j]==1)
					aux = true;
				RepositorioMapa.this.addPersonagem(new Blocos_Mapa(j*25, i*25,aux));
				aux=false;
			}
		}
	}
	
	public void addPersonagem(Blocos_Mapa comp){
		this.mapa.add(comp);
	}

	public List<Blocos_Mapa> getMapa() {
		return mapa;
	}

	public int[][] getMapa_Coo() {
		return mapa_Coo;
	}	
}
