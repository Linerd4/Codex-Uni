import java.io.FileNotFoundException;
import java.util.*;

public class Comune {

	private Mazzo mazzoRisorse;
	private Mazzo mazzoOro;
	private Mazzo mazzoObiettivo;
	private Mazzo mazzoIniziale;
	private Mazzino dueRisorse;
	private Mazzino dueOro;
	private Mazzino dueObiettivi;
	
	
	public Comune() throws FileNotFoundException {
		
		mazzoRisorse = new Mazzo(0);
		mazzoOro = new Mazzo(1);
		mazzoObiettivo = new Mazzo(2);
		mazzoIniziale = new Mazzo(3);
		
		
		List<Carta> duerisorse = new ArrayList<Carta>();
		duerisorse.add(mazzoRisorse.pescaCarta());
		duerisorse.add(mazzoRisorse.pescaCarta());
		dueRisorse = new Mazzino(duerisorse, mazzoRisorse);
		
		
		List<Carta> dueoro = new ArrayList<Carta>();
		dueoro.add(mazzoOro.pescaCarta());
		dueoro.add(mazzoOro.pescaCarta());	
		dueOro = new Mazzino(dueoro, mazzoOro);
		
		
		List<Carta> dueobiettivi = new ArrayList<Carta>();
		dueobiettivi.add(mazzoObiettivo.pescaCarta());
		dueobiettivi.add(mazzoObiettivo.pescaCarta());	
		dueObiettivi = new Mazzino(dueobiettivi, mazzoObiettivo);

	}
	
	
	/**
	 * Pesca una carta dal mazzo delle carte iniziali.
	 * @return Carta
	 */
	public Carta assegnaCartaIniziale() {
		
		return mazzoIniziale.pescaCarta();
	}
	
	
	public void mischiaCarte() {
		
		mazzoRisorse.mischia();
		mazzoOro.mischia();
		mazzoObiettivo.mischia();
		mazzoIniziale.mischia();
	}
	
	
	
	/**
	 * Questo metodo è utilizzato *soltanto* all'interno della classe partita.
	 * Restituisce un array di valori interi nei quali sono inserite le quantità di carte all'interno di MazzoRisorse e MazzoOro
	 * @return
	 */
	public int[] getNumeroCartePerMazzo() {
		
		int[] array = new int[2];
		
		array[0] = mazzoRisorse.getNumeroCarteNelMazzo();
		array[1] = mazzoOro.getNumeroCarteNelMazzo();
		
		return array; 
	}
	
	
	
	
	
	
	/**
	 * Pesca una carta dal mazzo delle carte risorsa.
	 * @return Carta
	 */
	public Carta assegnaCartaRisorsa() {
		
		return mazzoRisorse.pescaCarta();
	}
	
	
	/**
	 * Pesca una carta dal mazzo delle carte oro.
	 * @return Carta
	 */
	public Carta assegnaCartaOro() {
		
		return mazzoOro.pescaCarta();
	}
	
	
	/**
	 * Pesca una carta dal mazzo delle carte obiettivo.
	 * @return Carta
	 */
	public Carta assegnaCartaObiettivo() {
		
		return mazzoObiettivo.pescaCarta();
	}
	
	
	/**
	 * Scegli una delle due carte risorsa visibili.
	 * @param scelta
	 * @return
	 */
	public Carta scegliRisorsaMazzino(int scelta) {
		
		return dueRisorse.pescaCarta(scelta);
	}
	
	
	/**
	 * Scegli una delle due carte oro visibili.
	 * @return
	 */
	public Carta scegliOroMazzino(int scelta) {
		
		return dueOro.pescaCarta(scelta);
	}
	
	
	public List<Carta> getMazzini(){
		
		List<Carta> carteneimazzini = new ArrayList<Carta>();
		
		List<Carta> carteris = dueRisorse.getMazzino();
		List<Carta> carteoro = dueRisorse.getMazzino();
		
		carteneimazzini.add(carteris.get(0));
		carteneimazzini.add(carteris.get(1));
		carteneimazzini.add(carteoro.get(0));
		carteneimazzini.add(carteoro.get(1));

		return carteneimazzini;
	}
	
	
	public List<Carta> getObiettivi() {
		return dueObiettivi.getMazzino();
	}
	
	
}
