
public class CartaIniziale extends Carta {
    
	private Angoli angoliRetro;
    private Figure figure;
    
    public CartaIniziale(CartaDati dati, Angoli angoli1, Figure figure, Angoli angoli2) {
    	
    	super(dati, angoli1);
        angoliRetro = angoli2; 
        this.figure = figure;
    }
}