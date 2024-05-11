import java.util.*;

public class Figure {
	
    private Figura figura_altosx, figura_altodx, figura_bassosx, figura_bassodx;


    public Figure(Figura figura_altosx, Figura figura_altodx, Figura figura_bassosx, Figura figura_bassodx) {
    	this.figura_altosx = figura_altosx;
    	this.figura_altodx = figura_altodx;
    	this.figura_bassosx = figura_bassosx;
    	this.figura_bassodx = figura_bassodx;
    }

    public Figura getFigura_altosx() {
        return figura_altosx;
    }

    
    public Figura getFigura_altodx() {
        return figura_altodx;
    }

    
    public Figura getFigura_bassosx() {
        return figura_bassosx;
    }


    public Figura getFigura_bassodx() {
        return figura_bassodx;
    }

}
