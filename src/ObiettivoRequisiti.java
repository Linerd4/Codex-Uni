public class ObiettivoRequisiti {
	
    private Figura[] figure;
    private Regno[] regni;
    private Oggetto[] oggetti;
    private int tipoObiettivo;

    public ObiettivoRequisiti(Figura[] figure, Regno[] regni, Oggetto[] oggetti, int tipo) {
        
    	this.figure = new Figura[3];
        this.regni = new Regno[3];
        this.oggetti = new Oggetto[3];
        this.tipoObiettivo = tipo;
    }

    public Figura[] getFigure() {
        return figure;
    }

    public Regno[] getRegni() {
        return regni;
    }

    public Oggetto[] getOggetti() {
        return oggetti;
    }

    public int getTipoObiettivo() {
        return tipoObiettivo;
    }
}
