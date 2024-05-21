public class ObiettivoRequisiti {
	
    private Figura[] figure;
    private Regno[] regni;
    private Oggetto[] oggetti;
    private int tipoObiettivo;

    public ObiettivoRequisiti(Figura[] figure, Regno[] regni, Oggetto[] oggetti, int tipo) {
        
    	this.figure = figure;
        this.regni = regni;
        this.oggetti = oggetti;
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
