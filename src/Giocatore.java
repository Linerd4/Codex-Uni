import java.util.*;

public class Giocatore {
	private Dati dati;
	private Tavolo tavolo;
	private Comune comune;

	
	public Giocatore(Comune comune) {
		this.dati = new Dati();
		this.tavolo = new Tavolo();
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
	
	
	public Color getColore() {
		return dati.getColore();
	}
	
}
