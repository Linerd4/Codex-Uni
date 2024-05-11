import java.util.*;

public class Oggetti {
	
    private Oggetto oggetto_altosx, oggetto_altodx, oggetto_bassosx, oggetto_bassodx;


    public Oggetti(Oggetto oggetto_altosx, Oggetto oggetto_altodx, Oggetto oggetto_bassosx, Oggetto oggetto_bassodx) {
    	this.oggetto_altosx = oggetto_altosx;
    	this.oggetto_altodx = oggetto_altodx;
    	this.oggetto_bassosx = oggetto_bassosx;
    	this.oggetto_bassodx = oggetto_bassodx;
    }

    
    public Oggetto getOggetto_altosx() {
        return oggetto_altosx;
    }

    
    public Oggetto getOggetto_altodx() {
        return oggetto_altodx;
    }

    
    public Oggetto getOggetto_bassosx() {
        return oggetto_bassosx;
    }


    public Oggetto getOggetto_bassodx() {
        return oggetto_bassodx;
    }

}
