public class Comune {

	private Mazzo mazzoRisorse;
	private Mazzo mazzoOro;
	private Mazzo mazzoObiettivo;
	private Mazzo mazzoIniziale;
	private Mazzino dueRisorse;
	private Mazzino dueOro;
	private Mazzino dueObiettivi;
	
	public Comune() {
		
		mazzoRisorse = new Mazzo(40);
		mazzoOro = new Mazzo(40);
		mazzoObiettivo = new Mazzo(16);
		mazzoIniziale = new Mazzo(6);
		dueRisorse = new Mazzino(2);
		dueOro = new Mazzino(2);
		dueObiettivi = new Mazzino(2);
	}
	
	
	/**
	 * Pesca una carta dal mazzo delle carte iniziali.
	 * @return Carta
	 */
	public Carta assegnaCartaIniziale() {
		
		return mazzoIniziale.pescaCarta();
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
		
		return dueRisorse.pescaCarta();
	}
	
	
	/**
	 * Scegli una delle due carte oro visibili.
	 * @return
	 */
	public Carta scegliOroMazzino(int scelta) {
		
		return dueOro.pescaCarta();
	}
	
	
}
