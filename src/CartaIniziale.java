import java.util.List;

public class CartaIniziale extends Carta {
    
	
	private Angoli angoliRetro;
    private Figura[] figure;
    
    
    public CartaIniziale(CartaDati dati, Angoli angoli1, Figura[] figure, Angoli angoli2) {
    	
    	super(dati, angoli1);
        angoliRetro = angoli2; 
        this.figure = figure;
    }
    
    
    public Figura[] getFigureFrontali() {
    	return figure;
    }
    
    
    public List<Figura> getFigureRetro() {
        return angoliRetro.getFigure();
    }
    
    
    public List<Oggetto> getOggettiRetro() {
        return angoliRetro.getOggetti();
    }
    
    
    public int[] getVisibilitaRetro() {
    	return angoliRetro.getVisibilita();
    }
    
    
    public int[] getPosizioniRetro() {
        return angoliRetro.getPosizioni();
    }
    
    
	public List<Carta> getSovrapposizioniRetro(){
		return angoliRetro.getSovrapposizioni();
	}
    
	
}