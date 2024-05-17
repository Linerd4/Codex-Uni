import java.util.*;

public class Giocatore {
	private Dati dati;
	private Tavolo tavolo;
	private Comune comune;
	private int numeroTurno;

	
	public Giocatore(Dati dati, Tavolo tavolo, Comune comune) {
		this.dati = dati;
		this.tavolo = tavolo;
		this.comune = comune;
		this.numeroTurno = 0;
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
	
	public int getNumeroTurni() {
		
		return numeroTurno;
	}
	
}
