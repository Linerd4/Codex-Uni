/*
 * Importante: l'ordine di ritorno degli angoli e' il seguente:
 * 
 * AltoSinistra - AltoDestra - BassoSinistra - BassoDestra
 * 
 */

import java.util.List;

public class Carta {
    
	protected CartaDati dati;
    protected Angoli angoli;
    
    
    public Carta(CartaDati dati, Angoli angoli) {
    	
        this.dati = dati; 
        this.angoli = angoli; 
    }
    
    
    /**
     * Ritorna un intero che indica quale lato della carta e' stata scelta (fronte / retro).
     * @return
     */
    public int getLatoScelto() {
    	
    	return dati.getLatoScelto();
    }
	
    
    /**
     * Ritorna la lista delle figure presenti agli angoli.
     * @return
     */
    public List<Figura> getFigure() {
        return angoli.getFigure();
    }
    
    
    /**
     * Ritorna la lista degli oggetti presenti agli angoli.
     * @return
     */
    public List<Oggetto> getOggetti() {
        return angoli.getOggetti();
    }
    
    
    /**
     * Imposta il lato da giocare della carta scelto (fronte / retro).
     * @param lato
     */
    public void setLatoScelto(int lato) {
    	dati.setLatoScelto(lato);
    }
    
    
    /**
     * Ottieni la visibilita' dei singoli angoli (presente / assente).
     * @return
     */
    public int[] getVisibilita() {
    	return angoli.getVisibilita();
    }
    
    
    /**
     * Imposta la visibilita' dei singoli angoli (presente / assente).
     * @param vis2
     */
    public void setVisibilita(int[] vis2) {
    	angoli.setVisibilita(vis2);
    }
    
	
    
    public int[] getPosizioni() {
        return angoli.getPosizioni();
    }
     
    
    public void setPosizioni(int[] pos) {
    	angoli.setPosizione(pos);
    }
    
    
	public List<Carta> getSovrapposizioni(){
		return angoli.getSovrapposizioni();
	}
	
	public void setSovrapposizioni(List<Carta> sovrapp) {
		
		angoli.setSovrapposizioni(sovrapp);
	}

	
	public Regno getRegno() {
		return dati.getRegno();
	}
	
	
	public int getConsiderata() {
		return dati.getConsiderata();
	}
	
	
	public void setConsiderata(int considerazione) {
		dati.setConsiderata(considerazione);
	}
	
	public int getPunti() {
		return dati.getPunti();
	}
    
}

