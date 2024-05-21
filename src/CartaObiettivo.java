
public class CartaObiettivo extends Carta {
    protected ObiettivoRequisiti requisiti;
    
    public CartaObiettivo() {
        super(); 
        requisiti = new ObiettivoRequisiti(); 
    }
    
    public ObiettivoRequisiti getRequisiti() {
    	return requisiti;
    }
    
}