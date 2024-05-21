
public class CartaIniziale extends Carta {
    
	private Angoli angoliRetro;
    private Figura[] figure;
    
    public CartaIniziale(CartaDati dati, Angoli angoli1, Figura[] figure, Angoli angoli2) {
    	
    	super(dati, angoli1);
        angoliRetro = angoli2; 
        this.figure = figure;
    }
}