import java.util.*;

public class Oggetti {
	
    private Oggetto oggetto_altosx, oggetto_altodx, oggetto_bassosx, oggetto_bassodx;


    public Oggetti(Oggetto oggetto[]) {
    	this.oggetto_altosx = oggetto[0];
    	this.oggetto_altodx = oggetto[1];
    	this.oggetto_bassosx = oggetto[2];
    	this.oggetto_bassodx = oggetto[3];
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
