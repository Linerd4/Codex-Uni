import java.util.*;

public class Mazzino extends Mazzo {

	/**
	 * Se è stata pescata una carta dal mazzino di due carte visibili sul tavolo, allora
	 * rimpiazza la carta mancante con l'ultima carta che viene pescata dal mazzo più
	 * grande.
	 * 
	 * @param mazzoOriginale
	 */
	
	
	public Mazzino(int dimensione){

	}
	
	
	/**
	 * Se si ha pescato dal mazzino, si dovrà invocare questa funzione per riempire il mazzino di due carte visibile a tutti i giocatori.
	 * Esempio per riempire il mazzino nelle altre funzioni:
	 * 
	 * riempiMazzino(grandeMazzo.pescaCarta());
	 * 
	 * @param carta
	 */
	public void riempiMazzino(Carta carta) {
		
		if(mazzo.size() < ((Mazzo) mazzo).getDimensioneMassimaMazzo() )
			
			mazzo.add(carta);
		
		else
			
			return;
	}
	
	
	/**
	 * Restituisci il mazzino.
	 * @return mazzo
	 */
	public ArrayList<Carta> getMazzo() {
		
		return (ArrayList<Carta>) mazzo;		
	}
	
	
	public Carta pescaCarta(int scelta) {
		
		return mazzo.get(scelta);
	}
	
	
	
}
