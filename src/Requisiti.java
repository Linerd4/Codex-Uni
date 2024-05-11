import java.util.*;

public class Requisiti {

	private List<Figura> figure;
	private Oggetto oggetto;
	
	
	/**
	 * Costruttore di Requisiti, prendi come parametri un oggetto (non obbligatorio, se non c'e' impostare a NULL) e una lista di figure
	 * @param oggetto
	 * @param figure
	 */
	public Requisiti(Oggetto oggetto, List<Figura> figure){
		
		this.oggetto = oggetto;
		this.figure = figure;
	}
	
	
	/**
	 * Restistuisci una lista di figure.
	 * @return
	 */
	public List<Figura> getFigure() {
		
		return figure;
	}
	
	
	/**
	 * Restituisci l'oggetto requisito.
	 * @return
	 */
	public Oggetto getOggetto() {
		
		return oggetto;
	}
	
}
