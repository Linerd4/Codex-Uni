import java.util.*;

public class Requisiti {

	private Figura[] figure;
	private Oggetto oggetto;
	
	
	/**
	 * Costruttore di Requisiti, prendi come parametri un oggetto (non obbligatorio, se non c'e' impostare a NULL) e una lista di figure
	 * @param oggetto
	 * @param figure
	 */
	public Requisiti(Oggetto oggetto, Figura[] figure){
		
		this.oggetto = oggetto;
		this.figure = figure;
	}
	
	
	/**
	 * Restistuisci una lista di figure.
	 * @return
	 */
	public Figura[] getFigure() {
		
		return figure;
	}
	
	
	public int[] getQtaFigure() {
		
		int qtaFarfalla = 0;
		int qtaFoglia = 0;
		int qtaFungo = 0;
		int qtaLupo = 0;
		
		int[] qta = new int[4];
		
		for(Figura fig : figure) {
			
			switch(fig) {
			
				case FARFALLA:
					qtaFarfalla++;
					break;
				
				case FOGLIA:
					qtaFoglia++;
					break;
					
				case FUNGO:
					qtaFungo++;
					break;
					
				case LUPO:
					qtaLupo++;
					break;
			}
			
		}
		
		qta[0] = qtaFarfalla;
		qta[1] = qtaFoglia;
		qta[2] = qtaFungo;
		qta[3] = qtaLupo;
		
		return qta;
	}
	
	
	
	/**
	 * Restituisci l'oggetto requisito.
	 * @return
	 */
	public Oggetto getOggetto() {
		
		return oggetto;
	}
	
}
