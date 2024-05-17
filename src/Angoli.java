import java.util.*;

public class Angoli {

	private Oggetti oggetti;
	private Figure figure;
	private Posizione posizioni;
	private Sovrapposizione sovrapposizioni;
	private Visibilità visibilita;
	
	
	public Angoli(Oggetti oggetti, Figure figure, Visibilità visibilita) {
		
		this.oggetti = oggetti;
		this.figure = figure;
		this.posizioni = null;
		this.sovrapposizioni = null;
		this.visibilita = visibilita;
	}
	
	
	/**
	 * Restituisce gli oggetti che sono presenti all'interno di una carta.
	 * Come valore di return viene restituito il riferimento ad una lista contentente gli oggetti agli angoli nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX
	 * @return
	 */
	public List<Oggetto> getOggetti(){
		
		List<Oggetto> listaOggetti = new ArrayList<Oggetto>();
		
		listaOggetti.add(oggetti.getOggetto_altodx());
		listaOggetti.add(oggetti.getOggetto_altosx());
		listaOggetti.add(oggetti.getOggetto_bassodx());
		listaOggetti.add(oggetti.getOggetto_bassosx());

		return listaOggetti;
	}
	
	
	/**
	 * Restituisce le figure che sono presenti all'interno di una carta.
	 * Come valore di return viene restituito il riferimento ad una lista contentente le figure agli angoli nel seguente ordine:
	 * ALTODX - ALTOSX - BASSODX - BASSOSX
	 * @return
	 */
	public List<Figura> getFigure(){
		
		List<Figura> listaFigure = new ArrayList<Figura>();
		
		listaFigure.add(figure.getFigura_altodx());
		listaFigure.add(figure.getFigura_altosx());
		listaFigure.add(figure.getFigura_bassodx());
		listaFigure.add(figure.getFigura_bassosx());

		return listaFigure;
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
		
		List<Carta> listaSovrapposizioni = new ArrayList<Carta>();
		
		listaSovrapposizioni.add(sovrapposizioni.getAltoDx());
		listaSovrapposizioni.add(sovrapposizioni.getAltoSx());
		listaSovrapposizioni.add(sovrapposizioni.getBassoDx());
		listaSovrapposizioni.add(sovrapposizioni.getBassoSx());
		
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
		
		listaVisibilita[0] = visibilita.getAltoDx();
		listaVisibilita[1] = visibilita.getAltoSx();
		listaVisibilita[2] = visibilita.getBassoDx();
		listaVisibilita[3] = visibilita.getBassoSx();

		return listaVisibilita;
	}
	
}
