import java.util.*;

public class Angoli {

	private Oggetti oggetti;
	private Figure figure;
	private Posizione posizioni;
	private Sovrapposizione sovrapposizioni;
	private Visibilita visibilita;
	
	
	public Angoli(Oggetti oggetti, Figure figure, Posizione posizioni, Sovrapposizione sovrapposizioni, Visibilita Vsibilita, Visibilita visibilita) {
		this.oggetti = oggetti;
		this.figure = figure;
		this.posizioni = posizioni;
		this.sovrapposizioni = sovrapposizioni;
		this.visibilita = visibilita;
	}
	
	
	/**
	 * Restituisce gli oggetti che sono presenti all'interno di una carta.
	 * Come valore di return viene restituito il riferimento ad una lista contentente gli oggetti agli angoli nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX
	 * @return
	 */
	public List<Oggetto> getOggetti(){
		
		List<Oggetto> listaOggetti = new ArrayList();
		
		listaOggetti.add(oggetti.getOggetto_altodx());
		listaOggetti.add(oggetti.getOggetto_altosx());
		listaOggetti.add(oggetti.getOggetto_bassodx());
		listaOggetti.add(oggetti.getOggetto_bassosx());

		return listaOggetti;
	}
	
	
	/**
	 * Restituisce la posizione (0 = sotto, 1 = sopra) degli angoli di una carta.
	 * Come valore di return viene restituito un array di numeri interi nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX
	 * @return 
	 * @return
	 */
	public int[] getPosizioni(){
		
		int listaPosizioni[] = new int[4];
		
		listaPosizioni[0] = posizioni.getAltodx();
		listaPosizioni[1] = posizioni.getAltosx();
		listaPosizioni[2] = posizioni.getBassodx();
		listaPosizioni[3] = posizioni.getBassosx();

		return listaPosizioni;
	}
	
	
	/**
	 * Restituisce le carte posizionata agli angoli di una carta.
	 * Come valore di return viene restituito una lista di carte nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX ; attenzione, da ricontrollare l'implementazione non appena e' stata definita la classe Sovrapposizione
	 * @return
	 */
	public List<Carta> getSovrapposizioni(){
		
		List<Carta> listaSovrapposizioni = new ArrayList();
		
		listaSovrapposizioni.add(sovrapposizioni.getSovrapposizione_altodx());
		listaSovrapposizioni.add(sovrapposizioni.getSovrapposizione_altosx());
		listaSovrapposizioni.add(sovrapposizioni.getSovrapposizione_bassodx());
		listaSovrapposizioni.add(sovrapposizioni.getSovrapposizione_bassosx());
		
		return listaSovrapposizioni;
	}
	
	
	/**
	 * Restituisce le visibilita (0 = non visibile, 1 = visibile) degli angoli di una carta.
	 * Come valore di return viene restituito un array di numeri interi nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX; attenzione, da ricontrollare l'implementazione non appena e' stata definita la classe Visibilita
	 * @return 
	 * @return
	 */
	public int[] getVisibilita(){
		
		int listaVisibilita[] = new int[4];
		
		listaVisibilita[0] = visibilita.getAltodx();
		listaVisibilita[1] = visibilita.getAltosx();
		listaVisibilita[2] = visibilita.getBassodx();
		listaVisibilita[3] = visibilita.getBassosx();

		return listaVisibilita;
	}
	
}
