package br.ufc.pacman.chars;

import java.util.ArrayList;
import java.util.List;

public class RepositorioComida {
	
	private List<Comida> comidaRep;
	private RepositorioMapa mr = new RepositorioMapa();
	private List<Blocos_Mapa> mapa = mr.getMapa();
	private int[] coo_invalidas = {0,20,21,41,42,44,60,62,63,83,84,104,105,125,126,135,137,146,
									147,148,149,150,154,155,156,157,158,159,160,164,165,166,167,
									175,178,181,
									189,190,191,192,193,195,196,198,199,200,202,203,205,206,207,208,209,
									217,223,
									231,232,233,234,238,239,240,241,242,243,244,248,249,250,251,
									252,259,265,272,273,294,315,317,333,336,357,378,399,420,293,314,335,356,377,
									398,419,440};
	private boolean flag = false;
	
	public RepositorioComida() {
		this.comidaRep = new ArrayList<Comida>();
		for(int i = 0;i<this.mapa.size();i++){
			this.flag = false;
			for(int j=0;j<this.coo_invalidas.length;j++){
				if(i==coo_invalidas[j]) flag = true;
			}
			if(flag) continue;
			if(!mapa.get(i).isParede()){
				RepositorioComida.this.addComida(new Comida(mapa.get(i).getX()+10, mapa.get(i).getY()+10));
			}
		}
	}
	
	public List<Comida> getComida() {
		return this.comidaRep;
	}
	
	public void addComida(Comida comida){
		this.comidaRep.add(comida);
	}
	
	public void regenerarComidas(){
		for(int i = 0;i < this.comidaRep.size();i++){
			this.comidaRep.get(i).isVisivel = true;
		}
	}
}
