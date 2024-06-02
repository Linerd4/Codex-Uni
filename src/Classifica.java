import java.util.*;

public class Classifica {

	private List<Giocatore> giocatori;
	
	
	/**
	 * Il costruttore della classe Classifica: prende in input i riferimenti degli oggetti di un altro arraylist che presumibilmente verra' fornito dalla classe Partita
	 * @param giocatori
	 */
	public Classifica(List<Giocatore> giocatori){
		
		this.giocatori = new ArrayList<Giocatore>();
		this.giocatori = giocatori;
	}
	
	
	public Giocatore getGiocatore(int index) {
		return giocatori.get(index);
	}
	
	
	/**
	 * Riordina la lista dei giocatori sulla base dei punteggi attuali. 
	 * @param <T>
	 */
	public void ordinaClassifica() {
		
		Collections.sort(giocatori, new GiocatoreComparatore().reversed());
	}
	
	
	
	public void stampaClassifica() {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nClassifica attuale:");
		for(int i = 0; i < giocatori.size(); i++) {
			System.out.println(i + ") " + giocatori.get(i).getNome() + "\t" + giocatori.get(i).getPunteggio() + " punti");
			
		}
		System.out.println();
	}
	
}
