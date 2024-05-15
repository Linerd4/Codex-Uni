import java.util.*;

public class Figure {
	
    private Figura figura_altosx, figura_altodx, figura_bassosx, figura_bassodx;


    public Figure(Figura[] figura) {
    	this.figura_altosx = figura[0];
    	this.figura_altodx = figura[1];
    	this.figura_bassosx = figura[2];
    	this.figura_bassodx = figura[3];
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
