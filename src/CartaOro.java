public class CartaOro extends Carta {

    protected Requisiti requisiti;
    
    public CartaOro(CartaDati dati, Angoli angoli, Requisiti req) {
        super(dati ,angoli); 
        this.requisiti = req; 
    }


    public boolean verificaRequisiti(int figure[]) {

    	for(int i = 0 ; i < 4; i++) {
    		
    		if(requisiti.getQtaFigure()[i] < figure[i])
    			return false;
    	}
    	    	
        return true;
    }
}
