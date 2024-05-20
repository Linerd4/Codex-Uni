import java.util.*;
import java.awt.Point;

public class Tavolo {
	
	private List<Carta> disponibili;
	private Carta matrice[][];
	private Carta obiettivo;
	
	
	/**
	 * Costruttore di Tavolo, crea solo una matrice di 100x100 elementi.
	 */
	public Tavolo() {
		
		matrice = new Carta[100][100];
		disponibili = new ArrayList<Carta>();
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
	 * Ottieni una delle carte disponibili da giocare per avere le sue informazioni.
	 * @param scelta
	 * @return carta
	 */
	public Carta getCartaDaDisponibili(int scelta) {
		
		return disponibili.get(scelta);
	}
	
	/**
	 * Scegli quale carta delle disponibili vuoi giocare.
	 * @param scelta
	 * @return carta
	 */
	public Carta giocaCartaDaDisponibili(int scelta) {
		
		Carta carta = disponibili.get(scelta);
		disponibili.remove(scelta);
		return carta;
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
	public void posizionaCartaInMatrice(Carta carta, Point posizione) {
		
		matrice[(int)posizione.getX()][(int) posizione.getY()] = carta;
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
	
	
	public Carta[][] getMatrice(){
		return matrice;
	}
	
	public Carta getObiettivo() {
		return obiettivo;
	}
	
	public List<Carta> getDisponibili(){
		return disponibili;
	}
	
	
	
	
	/**
	 * Viene analizzata la matrice. Non appena si trova una carta, si analizzano i suoi angoli in alto a destra, sinistra e relativi in basso.
	 * Se in alto a sinistra la cella della matrice e' vuota, allora prendila in considerazione e analizza le relative carte in alto a destra, sinistra, e relativi bassi
	 * Se le carte in quelle posizioni non ci sono oppure hanno attributo di visibilita' a 1 o un mix di entrambi, allora la casella e' buona per poterci posizionare una carta.
	 * 	
	 * @param carta
	 * @return
	 */
	
	
	public List<Point> analizzaMatrice(){
		
		List<Point> posizioniDisponibili = new ArrayList<Point>();
		
		
		for(int i = 0; i < 100; i++) {					// RIGHE
			
			for (int j = 0; j < 100; j++) {				// COLONNE
				
				if( (matrice[i][j] != null) ) {
					
					if(matrice[i-1][j-1] == null) controllaPosizione(posizioniDisponibili, i-1, j-1);
					if(matrice[i-1][j+1] == null) controllaPosizione(posizioniDisponibili, i-1, j+1);
					if(matrice[i+1][j-1] == null) controllaPosizione(posizioniDisponibili, i+1, j-1);
					if(matrice[i+1][j+1] == null) controllaPosizione(posizioniDisponibili, i+1, j+1);
				}
			}
		}
		
		return posizioniDisponibili;
	}
	
	
	
	
	
	
	
	public void controllaPosizione(List<Point> coordinate, int i, int j) {
		
		boolean posizionabile = true;
		
		if(coordinate.contains(new Point(i, j)))
			return;
		
		if(matrice[i-1][j-1] == null) 							// controlla l'angolo in alto a sinistra
			posizionabile = true;								// dunque analizza gli attributi in basso a destra
		else if (matrice[i-1][j-1].getVisibilita()[2] == 0)		// della carta in alto a sinistra
			posizionabile = false;
		else if (matrice[i-1][j-1].getVisibilita()[2] == 1) {
			posizionabile = true;
		}	
			
		
		if (!posizionabile)	return;
			
		
		if(matrice[i-1][j+1] == null) 							// controlla l'angolo in alto a destra
			posizionabile = true;								// dunque analizza gli attributi in basso a sinistra
		else if (matrice[i-1][j+1].getVisibilita()[3] == 0)		// della carta da analizzare
			posizionabile = false;
		else if (matrice[i-1][j+1].getVisibilita()[3] == 1) {
			posizionabile = true;

		}
		
		
		if (!posizionabile)	return;
		
		
		if(matrice[i+1][j-1] == null) 							// controlla l'angolo in basso a sinistra
			posizionabile = true;								// dunque analizza gli attributi in alto a destra
		else if (matrice[i+1][j-1].getVisibilita()[0] == 0)		// della carta da analizzare
			posizionabile = false;
		else if (matrice[i+1][j-1].getVisibilita()[0] == 1) {
			posizionabile = true;
		}
		
		
		if (!posizionabile)	return;
		
	
		if(matrice[i+1][j+1] == null) 							// controlla l'angolo in basso a destra
			posizionabile = true;								// dunque analizza gli attributi in alto a sinistra
		else if (matrice[i+1][j+1].getVisibilita()[1] == 0)		// della carta da analizzare
			posizionabile = false;
		else if (matrice[i+1][j+1].getVisibilita()[1] == 1) {
			posizionabile = true;
	
		}
	
		if (posizionabile)
			coordinate.add(new Point(i, j));
		
	}

}