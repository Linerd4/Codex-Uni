public class CartaOro extends Carta {
<<<<<<< HEAD
    
	protected Requisiti requisiti;
    
    public CartaOro(CartaDati dati, Angoli angoli, Requisiti req) {
        super(dati ,angoli); 
        this.requisiti = req; 
=======
    protected Requisiti requisiti;

    public CartaOro() {
        super();
        requisiti = new Requisiti(null, new Figura[0]);
>>>>>>> 60b739617ff90e6a15e79e891c11a5341536ca28
    }

    public boolean verificaRequisiti(Tavolo tavolo) {
        Oggetto oggettoRequisito = requisiti.getOggetto();
        Figura[] figureRequisito = requisiti.getFigure();
        
        // Verifica se l'oggetto requisito della carta oro coincide con l'oggetto del tavolo
        if (oggettoRequisito != null && tavolo.getObiettivo().getOggetto() != oggettoRequisito) {
            return false;
        }

        // Verifica se tutte le figure requisito della carta oro sono presenti nel tavolo
        for (Figura figura : figureRequisito) {
            if (!tavolo.contieneFigura(figura)) {
                return false;
            }
        }

        return true;
    }
}
