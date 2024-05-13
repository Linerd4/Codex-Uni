import java.util.*;

public class Tavolo {
	
	private List<Carta> disponibili;
	private List<Carta> listaCarte;
	private Carta matrice[][];
	private Carta obiettivo;
	
	
	/**
	 * Costruttore di Tavolo, crea solo una matrice di 100x100 elementi.
	 */
	public Tavolo() {
		
		matrice = new Carta[100][100];
		disponibili = new ArrayList<Carta>();
		listaCarte = new ArrayList<Carta>();
	}
	
	
	/**
	 * Seleziona il lato da giocare della carta. Attenzione: prima dell'implementazione e' importante avere definito la classe Carta.
	 * @param lato
	 */
	public void setLatoCartaDaGiocare(int lato) {
	
	}
	
	
	/**
	 * Una volta che e' stata scelta la carta obiettivo, impostala nell'attributo obiettivo.
	 * @param carta
	 */
	public void setObiettivoPrincipale(Carta carta) {
		
		this.obiettivo = carta;
	}
	
	
	/**
	 * Scegli una delle tre carte a disposizione sul proprio tavolo di gioco.
	 * @param scelta
	 * @return carta
	 */
	public Carta scegliCartaDaGiocare(int scelta) {
		
		return disponibili.get(scelta);
	}
	
	
	/**
	 * Aggiungi una carta al proprio mazzo di carte disponibili.
	 * @param carta
	 */
	public void scegliCartaDaComune(Carta carta) {
		
		disponibili.add(carta);
	}
	
	
	/**
	 * Inserisci la carta nell'array, e inserisci nella matrice il riferimento alla carta appena inserita.
	 * @param carta
	 * @param riga
	 * @param colonna
	 */
	public void posizionaCartaInMatrice(Carta carta, int riga, int colonna) {
		
		listaCarte.add(carta);
		matrice[riga][colonna] = listaCarte.get(listaCarte.size()-1);
	}
	
	
	/**
	 * Ottieni le carte disponibili che il giocatore chiamante possiede.
	 * @return Carta[]
	 */
	public Carta[] getCarteDisponibili(){
		
		return (Carta[]) disponibili.toArray();
	}
	
	
	/**
	 * Restituisci la carta che e' presente alla riga e alla colonna forniti.
	 * Restituisce NULL (tecnicamente) se non e' stata posizionata una carta in quella posizione
	 * @param riga
	 * @param colonna
	 * @return
	 */
	public Carta getCarta(int riga, int colonna) {
		
		return matrice[riga][colonna];
	}
	
	
}
