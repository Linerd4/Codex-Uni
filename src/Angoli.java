import java.util.*;

public class Angoli {

	private Oggetti oggetti;
	private Figure figure;
	private Posizione posizioni;
	private Sovrapposizione sovrapposizioni;
	private Visibilità visibilita;
	
	
	/**
	 * Un costruttore che prende zero paramentri, utile solo per la costruzione di una carta obiettivo.
	 */
	public Angoli() {
		this.oggetti = null;
		this.figure = null;
		this.posizioni = null;
		this.sovrapposizioni = null;
		this.visibilita = null;
		
	}
	
	
	public Angoli(Oggetti oggetti, Figure figure, Visibilità visibilita) {
		
		this.oggetti = oggetti;
		this.figure = figure;
		this.posizioni = new Posizione(1, 1, 1, 1);
		this.sovrapposizioni = new Sovrapposizione(null, null, null, null);
		this.visibilita = visibilita;
	}
	
	
	/**
	 * Restituisce gli oggetti che sono presenti all'interno di una carta.
	 * Come valore di return viene restituito il riferimento ad una lista contentente gli oggetti agli angoli nel seguente ordine:
	 * ALTOSX - ALTODX - BASSOSX - BASSODX
	 * @return
	 */
	public List<Oggetto> getOggetti(){
		
		List<Oggetto> listaOggetti = new ArrayList<Oggetto>();
		
		listaOggetti.add(oggetti.getOggetto_altosx());
		listaOggetti.add(oggetti.getOggetto_altodx());
		listaOggetti.add(oggetti.getOggetto_bassosx());
		listaOggetti.add(oggetti.getOggetto_bassodx());
		

		return listaOggetti;
	}
	
	
	/**
	 * Restituisce le figure che sono presenti all'interno di una carta.
	 * Come valore di return viene restituito il riferimento ad una lista contentente le figure agli angoli nel seguente ordine:
	 * ALTOSX - ALTODX - BASSOSX - BASSODX
	 * @return
	 */
	public List<Figura> getFigure(){
		
		List<Figura> listaFigure = new ArrayList<Figura>();
		
		listaFigure.add(figure.getFigura_altosx());
		listaFigure.add(figure.getFigura_altodx());
		listaFigure.add(figure.getFigura_bassosx());
		listaFigure.add(figure.getFigura_bassodx());

		return listaFigure;
	}
	
	
	/**
	 * Restituisce la posizione (0 = sotto, 1 = sopra) degli angoli di una carta.
	 * Come valore di return viene restituito un array di numeri interi nel seguente ordine:
	 * ALTOSX - ALTODX - BASSOSX - BASSODX
	 * @return 
	 * @return
	 */
	public int[] getPosizioni(){
		
		int listaPosizioni[] = new int[4];
		
		listaPosizioni[1] = posizioni.getAltoSx();
		listaPosizioni[0] = posizioni.getAltoDx();
		listaPosizioni[3] = posizioni.getBassoSx();
		listaPosizioni[2] = posizioni.getBassoDx();

		return listaPosizioni;
	}
	
	
	/**
	 * Restituisce le carte posizionata agli angoli di una carta.
	 * Come valore di return viene restituito una lista di carte nel seguente ordine:
	 * ALTOSX - ALTODX - BASSOSX - BASSODX ; attenzione, da ricontrollare l'implementazione non appena e' stata definita la classe Sovrapposizione
	 * @return
	 */
	public List<Carta> getSovrapposizioni(){
		
		List<Carta> listaSovrapposizioni = new ArrayList<Carta>();
		
		listaSovrapposizioni.add(sovrapposizioni.getAltoSx());
		listaSovrapposizioni.add(sovrapposizioni.getAltoDx());
		listaSovrapposizioni.add(sovrapposizioni.getBassoSx());
		listaSovrapposizioni.add(sovrapposizioni.getBassoDx());
		
		return listaSovrapposizioni;
	}
	
	
	
	public void setSovrapposizioni(List<Carta> sovrapp) {
	
		sovrapposizioni =  new Sovrapposizione(sovrapp.get(0), sovrapp.get(1), sovrapp.get(2), sovrapp.get(3));
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
		
		listaVisibilita[1] = visibilita.getAltoSx();
		listaVisibilita[0] = visibilita.getAltoDx();
		listaVisibilita[3] = visibilita.getBassoSx();
		listaVisibilita[2] = visibilita.getBassoDx();


		return listaVisibilita;
	}
	
	
	/**
	 * Imposta le visibilita' (presente / assente) dei singoli angoli.
	 * @param vis
	 */
	public void setVisibilita(int[] vis) {
		
		visibilita.setAltoSx(vis[0]);
		visibilita.setAltoDx(vis[1]);
		visibilita.setBassoSx(vis[2]);
		visibilita.setBassoDx(vis[3]);
	}
	
	
	/**
	 * Imposta le singole posizioni (sopra / sotto) dei singoli angoli.
	 * @param pos
	 */
	public void setPosizione(int[] pos) {
		
		posizioni.setAltoSx(pos[0]);
		posizioni.setAltoDx(pos[1]);
		posizioni.setBassoSx(pos[2]);
		posizioni.setBassoDx(pos[3]);
	}


	public void setOggetti(List<Oggetto> oggetti2) {
		oggetti.setOggetto_altosx(oggetti2.get(0));
		oggetti.setOggetto_altodx(oggetti2.get(1));
		oggetti.setOggetto_bassosx(oggetti2.get(2));
		oggetti.setOggetto_bassodx(oggetti2.get(3));
		
	}


	public void setFigure(List<Figura> figure2) {
		
		figure.setFigura_altosx(figure2.get(0));
		figure.setFigura_altodx(figure2.get(1));
		figure.setFigura_bassosx(figure2.get(2));
		figure.setFigura_bassodx(figure2.get(3));
	
	}
	
		
	
}
