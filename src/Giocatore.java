import java.util.*;

public class Giocatore {
	private Dati dati;
	private Tavolo tavolo;
	private Comune comune;

	
	public Giocatore(Dati dati, Tavolo tavolo, Comune comune) {
		this.dati = dati;
		this.tavolo = tavolo;
		this.comune = comune;
	}

	
	public void turnoGiocatore() {
	}

	
	public void giocaCarta() {
	}

	
	public void pescaCarta() {
	}
	
	
	public int getPunteggio() {
		return dati.getPunteggio();
	}
	
	
	public String getNome() {
		return dati.getNome();
	}
	
	
	public Colore getColore() {
		return dati.getColore();
	}
	
}
