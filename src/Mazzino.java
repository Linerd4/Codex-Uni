import java.util.*;

public class Mazzino {

	private List<Carta> mazzino;
	private Mazzo correlato;
	
	
	public Mazzino(List<Carta> carte, Mazzo correlato){

		mazzino = new ArrayList<Carta>();
		
		mazzino.add(carte.get(0));
		mazzino.add(carte.get(1));
		
		this.correlato = correlato;
		
	}
	
	//attenzione, se scelta > 1 si rompe tutto
	// non sono del tutto sicuro che possa funzionare, bisogna assolutamente debuggare qua!
	public Carta pescaCarta(int scelta) {
		
		Carta carta = mazzino.get(scelta);
		
		mazzino.remove(scelta);
		mazzino.add(correlato.pescaCarta());
		
		return carta;
	}
	
	
	
	public List<Carta> getMazzino(){
		return mazzino;
	}
	
	
}
