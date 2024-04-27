import java.util.*;

public class Mazzo {

	/**
	 * Una lista generica di carte, che possono essere di tipo Risorsa, Oro, Iniziali e Obiettivo.
	 */
	protected List<Carta> mazzo = new ArrayList<Carta>();
	
	
	
	/**
	 * Specifica la dimensione massima del mazzo.
	 * Il suo valore sarà pari a:
	 * @value 40 se si tratta di un mazzo di tipo Oro o Risorse
	 * @value 16 se si tratta di tipo Iniziale o Obiettivo
	 * @value 2 se si tratta della classe figlia Mazzino 
	 *  
	 */
	protected int dimensioneMassimaMazzo;
	
	public int getDimensioneMassimaMazzo() {
		return dimensioneMassimaMazzo;
	}
	
	
	
	/**
	 * Costruttore di Mazzo. Prende in input la dimensione massima del mazzo.
	 * @param dimensione
	 */
	Mazzo (int dimensione){
		dimensioneMassimaMazzo = dimensione;	
	}
	
	
	
	/**
	 * Mischia il mazzo di carte.
	 * Viene richiamata la funzione shuffle() di Collections.
	 */
	public void mischia() {
		Collections.shuffle(mazzo);
	}
	
	
	
	/**
	 * Restituisce l'ultima carta del mazzo e la rimuove dal mazzo.
	 * Se il mazzo è vuoto viene restituito null.
	 * @return Carta / Null
	 */
	public Carta pescaCarta() {
		
		if(mazzo.size() > 0) {
			Carta pescata = mazzo.get(mazzo.size() - 1);
			mazzo.remove(mazzo.size() - 1);
			return pescata;
		} else
			return null;
	}
	
	
	
	/**
	 * Aggiungi una carta al mazzo se quest'ultimo non ha raggiunto la sua dimensione massima.
	 * @param carta
	 */
	public void aggiungiCarta(Carta carta) {
		
		if(mazzo.size() < ((Mazzo) mazzo).getDimensioneMassimaMazzo() )
			mazzo.add(carta);
		else
			return;
	}




	
	
}
