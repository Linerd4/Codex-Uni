import java.util.*;
import java.util.Scanner;
import java.io.*;


public class Mazzo {

	
	/**
	 * Una lista generica di carte, che possono essere di tipo Risorsa, Oro, Iniziali e Obiettivo.
	 */
	protected List<Carta> mazzo = new ArrayList<Carta>();
	protected int dimensioneMassimaMazzo;
	
	
	/**
	 * Costruttore di Mazzo. Prende in input la dimensione massima del mazzo.
	 * @param dimensione
	 * @throws FileNotFoundException 
	 */
	public Mazzo (int dimensione, int tipoMazzo) throws FileNotFoundException{
		dimensioneMassimaMazzo = dimensione;
		switch(tipoMazzo) {
		
			case 0:
				mazzo = creaMazzoRisorse();
			case 1:
				mazzo = creaMazzoOro();
			case 2:
				mazzo = creaMazzoObiettivo();
			case 3:
				mazzo = creaMazzoIniziale();
				
		}
	}
	
	
	
	
	
	private List<Carta> creaMazzoIniziale() throws FileNotFoundException{
		List<Carta> mazzoIniziale = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("src/Iniziali.txt")));
		
		String str;
		
		for(int c = 0; c < 6; c++) {
			str = sc.nextLine();
			
			CartaDati dati = new CartaDati(Regno.NULL, 0);
			
			//FIGURA
			Figura[] figure1 = new Figura[4];
			int cont = 0;
			for(int i = 0; i < 4; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: figure1[cont] = Figura.FOGLIA;
					case 2: figure1[cont] = Figura.LUPO;
					case 3: figure1[cont] = Figura.FARFALLA;
					case 4: figure1[cont] = Figura.FUNGO;
					case 5: figure1[cont] = Figura.NULL;
				}
				cont++;
			}
			
			Figura[] figure2 = new Figura[3];
			for(int i = 8; i < 11; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: figure2[cont] = Figura.FOGLIA;
					case 2: figure2[cont] = Figura.LUPO;
					case 3: figure2[cont] = Figura.FARFALLA;
					case 4: figure2[cont] = Figura.FUNGO;
					case 5: figure2[cont] = Figura.NULL;
				}
				cont++;
			}
			
			
			str = sc.nextLine();
			
			Figura[] figure3 = new Figura[3];
			for(int i = 0; i < 4; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: figure3[cont] = Figura.FOGLIA;
					case 2: figure3[cont] = Figura.LUPO;
					case 3: figure3[cont] = Figura.FARFALLA;
					case 4: figure3[cont] = Figura.FUNGO;
					case 5: figure3[cont] = Figura.NULL;
				}
				cont++;
			}
			

			
			Figure figureTemp1 = new Figure(figure1);
			Figure figureTemp2 = new Figure(figure2);
			Figure figureTemp3 = new Figure(figure3);	// questo sarebbe il retro
			Visibilità visibilites1 = new Visibilità((int) str.charAt(4), (int) str.charAt(5), (int) str.charAt(6), (int) str.charAt(7));
			Visibilità visibilites2 = new Visibilità(1, 1, 1, 1);
			
			Oggetto[] ogg = new Oggetto[4];
			for(int i = 0; i < 4; i++) ogg[i] = Oggetto.NULL;
			Oggetti oggettiTemp1 = new Oggetti(ogg);
			Oggetti oggettiTemp2 = new Oggetti(ogg);

			Angoli angoli1 = new Angoli(oggettiTemp1, figureTemp1, visibilites1);
			Angoli angoli2 = new Angoli(oggettiTemp2, figureTemp3, visibilites2);
			
			CartaIniziale carta = new CartaIniziale(dati, angoli1, figure2, angoli2);
			
			mazzoIniziale.add(carta);
			
		}	
		return mazzoIniziale;
	}





	private List<Carta> creaMazzoObiettivo() throws FileNotFoundException{
		
		List<Carta> mazzoObiettivo = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("src/Obiettivo.txt")));		
		
		String str = null;
		
		for(int c = 0; c < 16; c++) {
			
			str = sc.nextLine();
			
			Figura[] figure = new Figura[4];
			int cont = 0;
			for(int i = 0; i < 3; i++) {
				
				switch((int) str.charAt(i)) {
					case 1: figure[cont] = Figura.FOGLIA;
					case 2: figure[cont] = Figura.LUPO;
					case 3: figure[cont] = Figura.FARFALLA;
					case 4: figure[cont] = Figura.FUNGO;
					case 5: figure[cont] = Figura.NULL;
				}
				cont++;
			}
			
			
			Regno[] regni = new Regno[4];
			cont = 0;
			for(int i = 3; i < 6; i++) {
				
				switch((int) str.charAt(i)) {
					case 1: 	regni[cont] = Regno.VEGETALE;
					case 2: 	regni[cont] = Regno.ANIMALE;
					case 3: 	regni[cont] = Regno.FUNGALE;
					case 4: 	regni[cont] = Regno.INSETTALE;
					case 5: 	regni[cont] = Regno.NULL;
				}
				cont++;
			}
			
			
			Oggetto[] oggetti = new Oggetto[4];
			cont = 0;
			for(int i = 6; i < 9; i++) {
				
				switch((int) str.charAt(i)) {
					case 1: 	oggetti[cont] = Oggetto.PERGAMENA;
					case 2: 	oggetti[cont] = Oggetto.BOCCETTA;
					case 3: 	oggetti[cont] = Oggetto.PIUMA;
					case 4: 	oggetti[cont] = Oggetto.ANGOLO;
					case 5: 	oggetti[cont] = Oggetto.NULL;
				}
				cont++;
			}
			
			int tipo = (int) str.charAt(9);
			
			CartaObiettivo carta = new CartaObiettivo(figure, regni, oggetti, tipo);
			mazzoObiettivo.add(carta);
			
		}

		return mazzoObiettivo;
	}


	
	private List<Carta> creaMazzoOro() throws FileNotFoundException{
		List<Carta> mazzoOro = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("src/Oro.txt")));
		
		String str;
		
		for(int c = 0; c < 40; c++) {
			str = sc.nextLine();
			
			Regno regnoTemp = null;
			
			switch((int) str.charAt(0)) {
				
				case 1:		regnoTemp = Regno.VEGETALE;
				case 2:		regnoTemp = Regno.ANIMALE;
				case 3:		regnoTemp = Regno.FUNGALE;
				case 4:		regnoTemp = Regno.INSETTALE;
				case 5:		regnoTemp = Regno.NULL;
			}
			
			
			CartaDati dati = new CartaDati(regnoTemp, (int) str.charAt(1));
			
			Oggetto[] oggetti = new Oggetto[4];
			int cont = 0;
			for(int i = 2; i < 6; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: oggetti[cont] = Oggetto.PERGAMENA;
					case 2: oggetti[cont] = Oggetto.BOCCETTA;
					case 3: oggetti[cont] = Oggetto.PIUMA;
					case 4: oggetti[cont] = Oggetto.ANGOLO;
					case 5: oggetti[cont] = Oggetto.NULL;
				}
				cont++;
			}
			
			
			//FIGURA
			Figura[] figure = new Figura[4];
			cont = 0;
			for(int i = 6; i < 10; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: figure[cont] = Figura.FOGLIA;
					case 2: figure[cont] = Figura.LUPO;
					case 3: figure[cont] = Figura.FARFALLA;
					case 4: figure[cont] = Figura.FUNGO;
					case 5: figure[cont] = Figura.NULL;
				}
				cont++;
			}

			
			Figura[] figureRichieste = new Figura[4];
			cont = 0;
			for(int i = 14; i < 18; i++) {
				
				switch((int) str.charAt(i)) {
					case 1: figureRichieste[cont] = Figura.FOGLIA;
					case 2: figureRichieste[cont] = Figura.LUPO;
					case 3: figureRichieste[cont] = Figura.FARFALLA;
					case 4: figureRichieste[cont] = Figura.FUNGO;
					case 5: figureRichieste[cont] = Figura.NULL;
				}
				cont++;
			}
			
			
			Oggetto oggettoRichiesto;
			switch((int) str.charAt(18)) {
				case 1: oggettoRichiesto = Oggetto.PERGAMENA;
				case 2: oggettoRichiesto = Oggetto.BOCCETTA;
				case 3: oggettoRichiesto = Oggetto.PIUMA;
				case 4: oggettoRichiesto = Oggetto.ANGOLO;
				case 5: oggettoRichiesto = Oggetto.NULL;
			}
			
			
			Oggetti oggettiTemp = new Oggetti(oggetti);	
			Figure figureTemp = new Figure(figure);
			Visibilità visibilites = new Visibilità((int) str.charAt(10), (int) str.charAt(11), (int) str.charAt(12),	(int) str.charAt(13));
			Requisiti requisiti = new Requisiti(oggettoRichiesto, figureRichieste);
			Angoli angoli = new Angoli(oggettiTemp, figureTemp, visibilites);
			CartaOro carta = new CartaOro(dati, angoli, requisiti);
			mazzoOro.add(carta);	
		}
		return mazzoOro;
	}





	public List<Carta> creaMazzoRisorse() throws FileNotFoundException{
		
		List<Carta> mazzoRisorse = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("src/Risorse.txt")));
		
		String str;
		
		for(int c = 0; c < 40; c++) {
			str = sc.nextLine();
			
			Regno regnoTemp = null;
			
			switch((int) str.charAt(0)) {
				
				case 1:		regnoTemp = Regno.VEGETALE;
				case 2:		regnoTemp = Regno.ANIMALE;
				case 3:		regnoTemp = Regno.FUNGALE;
				case 4:		regnoTemp = Regno.INSETTALE;
				case 5:		regnoTemp = Regno.NULL;
			}
			
			
			CartaDati dati = new CartaDati(regnoTemp, str.charAt(1));
			
			Oggetto[] oggetti = new Oggetto[4];
			int cont = 0;
			for(int i = 2; i < 6; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: oggetti[cont] = Oggetto.PERGAMENA;
					case 2: oggetti[cont] = Oggetto.BOCCETTA;
					case 3: oggetti[cont] = Oggetto.PIUMA;
					case 4: oggetti[cont] = Oggetto.ANGOLO;
					case 5: oggetti[cont] = Oggetto.NULL;
				}
				cont++;
			}
			
			
			//FIGURA
			Figura[] figure = new Figura[4];
			cont = 0;
			for(int i = 6; i < 10; i++) {
				
				switch((int)str.charAt(i)) {
					case 1: figure[cont] = Figura.FOGLIA;
					case 2: figure[cont] = Figura.LUPO;
					case 3: figure[cont] = Figura.FARFALLA;
					case 4: figure[cont] = Figura.FUNGO;
					case 5: figure[cont] = Figura.NULL;
				}
				cont++;
			}
				

			
			Oggetti oggettiTemp = new Oggetti(oggetti);	
			Figure figureTemp = new Figure(figure);
			Visibilità visibilites = new Visibilità((int) str.charAt(10), (int) str.charAt(11), (int) str.charAt(12),	(int) str.charAt(13));
			Angoli angoli = new Angoli(oggettiTemp, figureTemp, visibilites);
			Carta carta = new Carta(dati, angoli);
			
			mazzoRisorse.add(carta);	
		}	
		return mazzoRisorse;
	}


	/**
	 * Specifica la dimensione massima del mazzo.
	 * Il suo valore sarà pari a:
	 * @value 40 se si tratta di un mazzo di tipo Oro o Risorse
	 * @value 16 se si tratta di tipo Iniziale o Obiettivo
	 * @value 2 se si tratta della classe figlia Mazzino 
	 *  
	 */
	public int getDimensioneMassimaMazzo() {
		return dimensioneMassimaMazzo;
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
