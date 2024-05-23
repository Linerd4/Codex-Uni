import java.util.List;

public class Carta {
    protected CartaDati dati;
    protected Angoli angoli;
    
    public Carta(CartaDati dati, Angoli angoli) {
    	
        this.dati = dati; 
        this.angoli = angoli; 
    }
    
    public int getLatoScelto() {
    	
    	return dati.getLatoScelto();
    }
	
    public List<Figura> getFigure() {
        return angoli.getFigure();
    }
    
    public void setLatoScelto(int lato) {

    	dati.setLatoScelto(lato);
    }
    
    
    public int[] getVisibilita() {
    	
    	return angoli.getVisibilita();
    }
	
     public int[] getPosizioni() {
        return angoli.getPosizioni();
    }
    
	public List<Carta> getSovrapposizioni(){
		
		return angoli.getSovrapposizioni();
	}

	public Regno getRegno() {
	
		return dati.getRegno();
	}
	
	public int getConsiderata() {
		return dati.getConsiderata();
	}
	
	public void setConsiderata(int considerazione) {
		dati.setConsiderata(considerazione);
	}
	
    
}

