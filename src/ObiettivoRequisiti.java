public class ObiettivoRequisiti {
    private Figura[] figure;
    private Regno[] regni;
    private Oggetto[] oggetti;
    private int tipoObiettivo;

    public ObiettivoRequisiti() {
        figure = new Figura[3];
        regni = new Regno[3];
        oggetti = new Oggetto[3];
        this.tipoObiettivo = 0;
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
