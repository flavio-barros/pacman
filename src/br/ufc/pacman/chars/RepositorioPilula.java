package br.ufc.pacman.chars;
import java.util.ArrayList;
import java.util.List;


public class RepositorioPilula {
	
	private List<Pilula> pilulaRep;
	
	private static int[] coo_validasX = {2,18,2,18};
	private static int[] coo_validasY = {2,2,15,15};

	public RepositorioPilula() {
		this.pilulaRep = new ArrayList<Pilula>();
		for(int i = 0; i < coo_validasX.length;i++){
			Pilula p = new Pilula(coo_validasX[i]*25+5,coo_validasY[i]*25+5);
			this.pilulaRep.add(p);
		}
		
	}
	
	public List<Pilula> getPilula() {
		return this.pilulaRep;
	}
	
	public void addPilula(Pilula pilula){
		this.pilulaRep.add(pilula);
	}
	
	public void regenerarPilulas(){
		for(int i = 0;i < this.pilulaRep.size();i++){
			this.pilulaRep.get(i).isVisivel = true;
		}
	}

}
