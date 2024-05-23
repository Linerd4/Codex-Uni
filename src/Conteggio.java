import java.util.*;

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

	
	
	
	
public void aggiornaConteggio(CartaIniziale cartaIniziale) {
    // Ottieni le figure presenti sulla carta iniziale
    List<Figura> figure = cartaIniziale.getFigure();
    
    // Incrementa i contatori delle figure presenti sulla carta iniziale
    for (Figura figura : figure) {
        switch (figura) {
            case BOCCETTA:
                boccetta++;
                break;
            case FARFALLA:
                farfalle++;
                break;
            case FOGLIA:
                foglie++;
                break;
            case FUNGO:
                funghi++;
                break;
            case LUPO:
                lupi++;
                break;
            case PERGAMENA:
                pergamene++;
                break;
            case PIUMA:
                piume++;
                break;
            default:
                
                break;
        }
    }
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
