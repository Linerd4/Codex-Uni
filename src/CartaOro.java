public class CartaOro extends Carta {
    
	protected Requisiti requisiti;
    
    public CartaOro(CartaDati dati, Angoli angoli, Requisiti req) {
        super(dati ,angoli); 
        this.requisiti = req; 
    }
}