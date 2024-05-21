public class CartaObiettivo extends Carta {
	
    protected ObiettivoRequisiti requisiti;
    
    public CartaObiettivo(ObiettivoRequisiti req) {
        super(new CartaDati(), new Angoli()); 
        this.requisiti = req; 
    }
    
    public ObiettivoRequisiti getRequisiti() {
    	return requisiti;
    }
    
}