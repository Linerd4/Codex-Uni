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
    
    
    public void setLatoScelto(int lato) {

    	dati.setLatoScelto(lato);
    }
    
    
    public int[] getVisibilita() {
    	
    	return angoli.getVisibilita();
    }
    
    
    
	
	public List<Carta> getSovrapposizioni(){
		
		return angoli.getSovrapposizioni();
	}
	
    
}

