import java.util.*;
import java.util.Scanner;
import java.io.*;


public class Mazzo {

	
	/**
	 * Una lista generica di carte, che possono essere di tipo Risorsa, Oro, Iniziali e Obiettivo.
	 */
	protected List<Carta> mazzo = new ArrayList<Carta>();
	
	
	/**
	 * Costruttore di Mazzo. Prende in input il tipo del mazzo.
	 * @param tipo
	 * @throws FileNotFoundException 
	 */
	public Mazzo (int tipoMazzo) throws FileNotFoundException{
		
		switch(tipoMazzo) {
		
			case 0:
				mazzo = creaMazzoRisorse(); 	break;
			case 1:
				mazzo = creaMazzoOro();			break;
			case 2:
				mazzo = creaMazzoObiettivo();	break;
			case 3:
				mazzo = creaMazzoIniziale();	break;
				
		}
	}
	
	
	/**
	 * Crea un mazzo di carte Iniziali.
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<Carta> creaMazzoIniziale() throws FileNotFoundException{
		
		List<Carta> mazzoIniziale = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("Iniziali.txt")));
		
		String str;
		
		for(int c = 0; c < 6; c++) {
			str = sc.nextLine();
			
			CartaDati dati = new CartaDati(Regno.NULL, 0);
			
			//FIGURA
			Figura[] figure1 = new Figura[4];
			int cont = 0;
			for(int i = 0; i < 4; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figure1[cont] = Figura.FOGLIA;		break;
					case '2' : figure1[cont] = Figura.LUPO;			break;
					case '3' : figure1[cont] = Figura.FARFALLA;		break;
					case '4' : figure1[cont] = Figura.FUNGO;		break;
					case '5' : figure1[cont] = Figura.NULL;			break;
				}
				cont++;
			}
			
			Figura[] figure2 = new Figura[3];
			cont = 0;
			for(int i = 8; i < 11; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figure2[cont] = Figura.FOGLIA;		break;
					case '2' : figure2[cont] = Figura.LUPO;			break;
					case '3' : figure2[cont] = Figura.FARFALLA;		break;
					case '4' : figure2[cont] = Figura.FUNGO;		break;
					case '5' : figure2[cont] = Figura.NULL;			break;
				}
				cont++;
			}
			
			Visibilità visibilites1 = new Visibilità( Character.getNumericValue(str.charAt(4)), Character.getNumericValue(str.charAt(5)), Character.getNumericValue(str.charAt(6)), Character.getNumericValue(str.charAt(7)));
			
			str = sc.nextLine();
			
			Figura[] figure3 = new Figura[4];
			cont = 0;
			for(int i = 0; i < 4; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figure3[cont] = Figura.FOGLIA;		break;
					case '2' : figure3[cont] = Figura.LUPO;			break;
					case '3' : figure3[cont] = Figura.FARFALLA;		break;
					case '4' : figure3[cont] = Figura.FUNGO;		break;
					case '5' : figure3[cont] = Figura.NULL;			break;
				}
				cont++;
			}
			

			
			Figure figureTemp1 = new Figure(figure1);
//			Figure figureTemp2 = new Figure(figure2);
			Figure figureTemp3 = new Figure(figure3);	// questo sarebbe il retro
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
		
		
		Collections.shuffle(mazzoIniziale);
		return mazzoIniziale;
	}


	/**
	 * Crea un mazzo di carte Obiettivo.
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<Carta> creaMazzoObiettivo() throws FileNotFoundException{
		
		List<Carta> mazzoObiettivo = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("Obiettivo.txt")));		
		
		String str = null;
		
		for(int c = 0; c < 16; c++) {
			
			str = sc.nextLine();
			
			Figura[] figure = new Figura[3];
			int cont = 0;
			for(int i = 0; i < 3; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figure[cont] = Figura.FOGLIA;		break;
					case '2' : figure[cont] = Figura.LUPO;			break;
					case '3' : figure[cont] = Figura.FARFALLA;		break;
					case '4' : figure[cont] = Figura.FUNGO;			break;
					case '5' : figure[cont] = Figura.NULL;			break;
				}
				cont++;
			}
			
			
			Regno[] regni = new Regno[3];
			cont = 0;
			for(int i = 3; i < 6; i++) {
				
				switch(  str.charAt(i) ) {
					case '1' : 	regni[cont] = Regno.VEGETALE;		break;
					case '2' : 	regni[cont] = Regno.ANIMALE;		break;
					case '3' : 	regni[cont] = Regno.FUNGALE;		break;
					case '4' : 	regni[cont] = Regno.INSETTALE;		break;
					case '5' : 	regni[cont] = Regno.NULL;			break;
				}
				cont++;
			}
			
			
			Oggetto[] oggetti = new Oggetto[3];
			cont = 0;
			for(int i = 6; i < 9; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : 	oggetti[cont] = Oggetto.PERGAMENA;	break;
					case '2' : 	oggetti[cont] = Oggetto.BOCCETTA;	break;
					case '3' : 	oggetti[cont] = Oggetto.PIUMA;		break;
					case '4' : 	oggetti[cont] = Oggetto.ANGOLO;		break;
					case '5' : 	oggetti[cont] = Oggetto.NULL;		break;
				}
				cont++;
			}
			
			int tipo = Character.getNumericValue(str.charAt(9));
			ObiettivoRequisiti req = new ObiettivoRequisiti(figure, regni, oggetti, tipo);
			CartaObiettivo carta = new CartaObiettivo(req);
			mazzoObiettivo.add(carta);
			
		}

		
		Collections.shuffle(mazzoObiettivo);
		return mazzoObiettivo;
	}


	/**
	 * Crea un mazzo di carte Oro.
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<Carta> creaMazzoOro() throws FileNotFoundException{
		List<Carta> mazzoOro = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("Oro.txt")));
		
		String str;
		
		for(int c = 0; c < 40; c++) {
			str = sc.nextLine();
			
			Regno regnoTemp = null;
			
			switch( str.charAt(0) ) {
				
				case '1' :		regnoTemp = Regno.VEGETALE;		break;
				case '2' :		regnoTemp = Regno.ANIMALE;		break;
				case '3' :		regnoTemp = Regno.FUNGALE;		break;
				case '4' :		regnoTemp = Regno.INSETTALE;	break;
				case '5' :		regnoTemp = Regno.NULL;			break;
			}
			
			
			CartaDati dati = new CartaDati(regnoTemp, Character.getNumericValue(str.charAt(1)));
			
			Oggetto[] oggetti = new Oggetto[4];
			int cont = 0;
			for(int i = 2; i < 6; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : oggetti[cont] = Oggetto.PERGAMENA;	break;
					case '2' : oggetti[cont] = Oggetto.BOCCETTA;	break;
					case '3' : oggetti[cont] = Oggetto.PIUMA;		break;
					case '4' : oggetti[cont] = Oggetto.ANGOLO;		break;
					case '5' : oggetti[cont] = Oggetto.NULL;		break;
				}
				cont++;
			}
			
			
			//FIGURA
			Figura[] figure = new Figura[4];
			cont = 0;
			for(int i = 6; i < 10; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figure[cont] = Figura.FOGLIA;		break;
					case '2' : figure[cont] = Figura.LUPO;			break;
					case '3' : figure[cont] = Figura.FARFALLA;		break;
					case '4' : figure[cont] = Figura.FUNGO;			break;
					case '5' : figure[cont] = Figura.NULL;			break;
				}
				cont++;
			}

			
			Figura[] figureRichieste = new Figura[5];
			cont = 0;
			for(int i = 14; i < 19; i++) {
				
				switch( str.charAt(i) ) {
					case '1' : figureRichieste[cont] = Figura.FOGLIA;		break;
					case '2' : figureRichieste[cont] = Figura.LUPO;			break;
					case '3' : figureRichieste[cont] = Figura.FARFALLA;		break;
					case '4' : figureRichieste[cont] = Figura.FUNGO;		break;
					case '5' : figureRichieste[cont] = Figura.NULL;			break;
				}
				cont++;
			}
			
			
			Oggetto oggettoRichiesto = null;
			switch( str.charAt(19) ) {
				case '1' : oggettoRichiesto = Oggetto.PERGAMENA;	break;
				case '2' : oggettoRichiesto = Oggetto.BOCCETTA;		break;
				case '3' : oggettoRichiesto = Oggetto.PIUMA;		break;
				case '4' : oggettoRichiesto = Oggetto.ANGOLO;		break;
				case '5' : oggettoRichiesto = Oggetto.NULL;			break;
			}
			
			
			Oggetti oggettiTemp = new Oggetti(oggetti);	
			Figure figureTemp = new Figure(figure);
			Visibilità visibilites = new Visibilità(Character.getNumericValue(str.charAt(10)), Character.getNumericValue(str.charAt(11)), Character.getNumericValue(str.charAt(12)), Character.getNumericValue(str.charAt(13)));
			Requisiti requisiti = new Requisiti(oggettoRichiesto, figureRichieste);
			Angoli angoli = new Angoli(oggettiTemp, figureTemp, visibilites);
			CartaOro carta = new CartaOro(dati, angoli, requisiti);
			mazzoOro.add(carta);	
		}
		
		
		
		Collections.shuffle(mazzoOro);
		return mazzoOro;
	}


	/**
	 * Crea un mazzo di carte Risorsa.
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<Carta> creaMazzoRisorse() throws FileNotFoundException{
		
		List<Carta> mazzoRisorse = new ArrayList<Carta>();
		Scanner sc = new Scanner(new
				FileInputStream(
				new File("Risorse.txt")));
		
		String str = null;
		
		for(int c = 0; c < 40; c++) {
			str = sc.nextLine();
			
			Regno regnoTemp = null;
			
			switch(str.charAt(0)) {
				
				case '1':		regnoTemp = Regno.VEGETALE; 	break;
				case '2':		regnoTemp = Regno.ANIMALE; 		break;
				case '3':		regnoTemp = Regno.FUNGALE; 		break;
				case '4':		regnoTemp = Regno.INSETTALE; 	break;
				case '5':		regnoTemp = Regno.NULL; 		break;
			}
			
			
			CartaDati dati = new CartaDati(regnoTemp, Character.getNumericValue(str.charAt(1)));
			
			Oggetto[] oggetti = new Oggetto[4];
			int cont = 0;
			for(int i = 2; i < 6; i++) {
				
				switch( str.charAt(i) ) {
					case '1': oggetti[cont] = Oggetto.PERGAMENA;	break;
					case '2': oggetti[cont] = Oggetto.BOCCETTA;		break;
					case '3': oggetti[cont] = Oggetto.PIUMA;		break;
					case '4': oggetti[cont] = Oggetto.ANGOLO;		break;
					case '5': oggetti[cont] = Oggetto.NULL;			break;
				}
				cont++;
			}
			
			
			//FIGURA
			Figura[] figure = new Figura[4];
			cont = 0;
			for(int i = 6; i < 10; i++) {
				
				switch( str.charAt(i) ) {
					case '1': figure[cont] = Figura.FOGLIA;		break;
					case '2': figure[cont] = Figura.LUPO;		break;
					case '3': figure[cont] = Figura.FARFALLA;	break;
					case '4': figure[cont] = Figura.FUNGO;		break;
					case '5': figure[cont] = Figura.NULL;		break;
				}
				cont++;
			}
				

			
			Oggetti oggettiTemp = new Oggetti(oggetti);	
			Figure figureTemp = new Figure(figure);
			Visibilità visibilites = new Visibilità(Character.getNumericValue(str.charAt(10)), Character.getNumericValue(str.charAt(11)), Character.getNumericValue(str.charAt(12)), Character.getNumericValue(str.charAt(13)));
			Angoli angoli = new Angoli(oggettiTemp, figureTemp, visibilites);
			Carta carta = new Carta(dati, angoli);
			
			mazzoRisorse.add(carta);	
		}	
		
		
		Collections.shuffle(mazzoRisorse);
		return mazzoRisorse;
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
	 * Aggiungi una carta al mazzo.
	 * @param carta
	 */
	public void aggiungiCarta(Carta carta) {
		
		mazzo.add(carta);
	}

	
	public int getNumeroCarteNelMazzo() {
		
		return mazzo.size();
	}
	
	
}
