import java.util.*;

public class Oggetti {
	
    private Oggetto oggetto_altosx, oggetto_altodx, oggetto_bassosx, oggetto_bassodx;


    public Oggetti(Oggetto oggetto[]) {
    	this.oggetto_altosx = oggetto[0];
    	this.oggetto_altodx = oggetto[1];
    	this.oggetto_bassosx = oggetto[2];
    	this.oggetto_bassodx = oggetto[3];
    }

    
    public void setOggetti(Oggetto[] oggetti) {
    	this.oggetto_altosx = oggetti[0];
    	this.oggetto_altodx = oggetti[1];
    	this.oggetto_bassosx = oggetti[2];
    	this.oggetto_bassodx = oggetti[3];
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
