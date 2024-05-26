import java.util.*;
import java.util.List;

public class Conteggio {
	
	private int boccetta;
	private int farfalle;
	private int foglie;
	private int funghi;
	private int lupi;
	private int pergamene;
	private int piume;

	
	public Conteggio() {
		this.boccetta = 0;
		this.farfalle = 0;
		this.foglie = 0;
		this.funghi = 0;
		this.lupi = 0;
		this.pergamene = 0;
		this.piume = 0;
	}

	
	public void aggiornaConteggio(Carta matrice[][]) {
		
		Carta carta = null;
		
		int tempBoccetta = 0;
		int tempFarfalle = 0;
		int tempFoglie = 0;
		int tempFunghi = 0;
		int tempLupi = 0;
		int tempPergamene = 0;
		int tempPiume = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				
				if(matrice[i][j] != null) {
					
					carta = matrice[i][j];
					

					
					List<Oggetto> oggetti = carta.getOggetti();
					List<Figura> figure = carta.getFigure();
					int[] visibil = carta.getVisibilita();
					int[] posiz = carta.getPosizioni();
					
					for(int z = 0; i < 4; i++) {
						
						if( (visibil[z] == 1) && (posiz[z]==1) ) {
							
							for (Figura figura : figure) {
								switch (figura) {
									case FARFALLA:
										tempFarfalle++;
										break;
					                
									case FOGLIA:
										tempFoglie++;
										break;
					                
									case FUNGO:
										tempFunghi++;
										break;
					                
									case LUPO:
										tempLupi++;
					                	break;
					                
									default:
										break;
					        	}
					    	}
							
							for (Oggetto ogg: oggetti) {
								switch (ogg) {
									case BOCCETTA:
										tempBoccetta++;
										break;
					                
									case PERGAMENA:
										tempPergamene++;
										break;
					                
									case PIUMA:
										tempPiume++;
										break;
					                
									default:
										break;
					        	}
					    	}							
						}
					}	
				}
			}
		}
		
		
		this.boccetta = tempBoccetta;
		this.farfalle = tempFarfalle;
		this.foglie = tempFoglie;
		this.funghi = tempFunghi;
		this.lupi = tempLupi;
		this.pergamene = tempPergamene;
		this.piume = tempPiume;
		
	}
	
	public int getBoccetta() {
		return boccetta;
	}
	
	
	public int getFarfalle() {
		return farfalle;
	}
	
	
	public int getFoglie() {
		return foglie;
	}
	
	
	public int getFunghi() {
		return funghi;
	}
	
	
	public int getLupi() {
		return lupi;
	}
	
	
	public int getPergamene() {
		return pergamene;
	}
	
	
	public int getPiume() {
		return piume;
	}
	

}
