import java.awt.Point;
import java.util.*;

public class Giocatore {
	private Dati dati;
	private Tavolo tavolo;
	private Comune comune;
	private int numeroTurno;

	
	public Giocatore(Dati dati, Tavolo tavolo, Comune comune) {
		this.dati = dati;
		this.tavolo = tavolo;
		this.comune = comune;
		this.numeroTurno = 0;
	}


	public void giocaCarta() {
	    
		System.out.println("Turno di " + dati.getNome());
		
		Grafica.stampaTavoloDiGioco(tavolo.getMatrice(), tavolo.analizzaMatrice());
		
		Grafica.stampaMazzini(comune.getMazzini(), comune.getObiettivi());
		
		
		char[][] playBuf = new char[9][79];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 79; j++)
				playBuf[i][j] = ' ';
		}
		
		System.out.println("\n\n");
		
		System.out.println("             Carte risorsa possedute                       Carta obiettivo posseduta\n");
		
		Grafica.stampaDisponibili(tavolo.getDisponibili(), playBuf);
		Grafica.stampaCartaObiettivo(tavolo.getObiettivo(), playBuf, 71, 4);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 79; j++)
				System.out.print(playBuf[i][j]);
			System.out.println();
		}
	    
	    Scanner sc = new Scanner(System.in);
	    int scelta = 0;
	    int soprasotto;
	    boolean cartaNonValida = true;
	    
	    
	    do {
	    	
	    	do {
	    		System.out.println("\n\nQuale carta vuoi giocare? (1 - 2 - 3)");
	    		scelta = Character.getNumericValue(sc.nextLine().charAt(0));
	    	} while( (scelta<=0) || (scelta>=4) );
	        
	        
	    	do {

	    		System.out.println("\nVuoi giocarla di fronte (1) oppure di retro (2)? ");
	        	soprasotto = Character.getNumericValue(sc.nextLine().charAt(0));
	    	} while((soprasotto<=0) || (soprasotto>=3));
	    		
	    		
	        Carta cartaScelta = tavolo.getCartaDaDisponibili(scelta - 1);
	        
	        if(soprasotto == 2) {
	        	
	        	int[] vuoto = new int[4];
	        	List<Figura> vuotoFigura = new ArrayList<Figura>();
	        	List<Oggetto> vuotoOggetto = new ArrayList<Oggetto>();
	        	
	        	for(int i = 0; i < 4; i++) {
	        		vuoto[i] = 1;
	        		vuotoFigura.add(Figura.NULL);
	        		vuotoOggetto.add(Oggetto.NULL);
	        	}
	        	
	        	cartaScelta.setPosizioni(vuoto);
	        	cartaScelta.setVisibilita(vuoto);
	        }
	        
	        cartaScelta.setLatoScelto(soprasotto);

	        if (cartaScelta instanceof CartaOro && cartaScelta.getLatoScelto() == 1) {
	            CartaOro cartaOro = (CartaOro) cartaScelta;
	            if (!cartaOro.verificaRequisiti(dati.getFigure())) {
	                System.out.println("Il lato scelto della carta oro non soddisfa i requisiti. Gioca l'altro lato oppure scegli una carta risorsa.");
	                cartaNonValida = true;
	            } else {
	                cartaNonValida = false;
	            }
	        } else {
	            cartaNonValida = false;
	        }
	    } while(cartaNonValida);

	    List<Point> posizioniValide = tavolo.analizzaMatrice();

	    int posizioneSceltaNellaMatrice = 0;
	    do {
	    	System.out.println("\nDove vuoi posizionare la carta? (Inserire uno dei numeri posizionati agli angoli del proprio tavolo");
	    	posizioneSceltaNellaMatrice = Character.getNumericValue(sc.nextLine().charAt(0));
	    	
	    } while((posizioneSceltaNellaMatrice<=0) || (posizioneSceltaNellaMatrice>posizioniValide.size()));

	    
	    if(tavolo.getCartaDaDisponibili(scelta - 1) instanceof CartaOro)
	    	dati.setPunteggio(dati.getPunteggio() + tavolo.getCartaDaDisponibili(scelta - 1).getPunti());
	    
	        
	    tavolo.posizionaCartaInMatrice(tavolo.giocaCartaDaDisponibili(scelta - 1), posizioniValide.get(posizioneSceltaNellaMatrice - 1));
	
	    dati.aggiornaConteggio(tavolo.getMatrice());
	        
	    numeroTurno++;
	    
	}

	
	public void pescaCarta() {
				
		Scanner sc = new Scanner(System.in);
		String scelta = null; 
		
		
		do {
			
			System.out.println("\nDa quale mazzo vuoi pescare? Da\n1) Mazzo Risorsa\n2) Mazzo Oro\n3) Prendi una delle due carte risorsa scoperte\n4) Prendi una delle due carte oro scoperte");
			scelta = sc.nextLine();
			
			switch(Character.getNumericValue(scelta.charAt(0))) {
			
				case 1:
					tavolo.scegliCartaDaComune(comune.assegnaCartaRisorsa());
					break;
				
					
				case 2:
					tavolo.scegliCartaDaComune(comune.assegnaCartaOro());
					break;
					
					
				case 3:
					
					int scelta2 = 0;
					do{
						System.out.println("Quale delle due carte risorsa vuoi prendere? (1: la prima | 2: la seconda)");
						scelta2 = Character.getNumericValue(sc.nextLine().charAt(0));
					
					}while( (scelta2 <= 0) || (scelta2 >= 3) );
					tavolo.scegliCartaDaComune(comune.scegliRisorsaMazzino(scelta2 - 1));
					break;
					
					
				case 4:
					int scelta3 = 0;
					do {
						System.out.println("Quale delle due carte oro vuoi prendere? (1: la prima | 2: la seconda)");
						scelta3 = Character.getNumericValue(sc.nextLine().charAt(0));
							
					}while( (scelta3 <= 0) || (scelta3 >= 3) );
					tavolo.scegliCartaDaComune(comune.scegliOroMazzino(scelta3 - 1));
					break;
					
				default:
					System.out.println("Scelta invalida, riprova.");
					break;
			}
			
		}while(((Character.getNumericValue(scelta.charAt(0))) <= 0) || (Character.getNumericValue(scelta.charAt(0))) >= 5);
	
		
		
	}
	
	
	public int getPunteggio() {
		return dati.getPunteggio();
	}
	
	
	public String getNome() {
		return dati.getNome();
	}
	
	
	public Colore getColore() {
		return dati.getColore();
	}
	
	
	public int getNumeroTurni() {
		
		return numeroTurno;
	}


	public CartaObiettivo getObiettivo() {
		return tavolo.getObiettivo();
	}


	public void verificaObiettivo(CartaObiettivo obiettivo) {
		
		ObiettivoRequisiti requisiti = obiettivo.getRequisiti();
		Carta[][] matrice = tavolo.getMatrice();
	
		List<Carta> combinazioniCarte;
		
		
		
		if(requisiti.getTipoObiettivo() == 1) {		// diagonale
			
			for(int i = 0; i < 100; i++) {	
				for(int j = 0; j < 100; j++) {
					
					combinazioniCarte = new ArrayList<Carta>();
					
					if( (matrice[i][j]!=null) && (matrice[i][j].getRegno() == requisiti.getRegni()[0]) ) {
						
						combinazioniCarte.add(matrice[i][j]);
						if( ( matrice[i+1][j-1]!=null ) && (matrice[i+1][j-1].getRegno() == requisiti.getRegni()[1])) {
							combinazioniCarte.add(matrice[i+1][j-1]);
							
							
							if(( matrice[i+2][j-2]!=null ) && (matrice[i+2][j-2].getRegno() == requisiti.getRegni()[2])) {
								combinazioniCarte.add(matrice[i+2][j-2]);
								
								for(Carta c : combinazioniCarte) c.setConsiderata(1);
								dati.setPunteggio(dati.getPunteggio() + 2);
								
							}
						}
					}
					
					combinazioniCarte = null;
				
				
				}	
			}
		}
		
		else if (requisiti.getTipoObiettivo() == 2) {		// L
			
			
			
			for(int i = 0; i < 100; i++) {	
				for(int j = 0; j < 100; j++) {
					
					combinazioniCarte = new ArrayList<Carta>();
					
					if( (matrice[i][j] != null) && (matrice[i][j].getRegno() == requisiti.getRegni()[0])) {
						
						combinazioniCarte.add(matrice[i][j]);
						if(( matrice[i+2][j]!=null ) && (matrice[i+2][j].getRegno() == requisiti.getRegni()[1])) {
							combinazioniCarte.add(matrice[i+2][j]);
							
							
							if(( matrice[i+3][j+1]!=null ) && (matrice[i+3][j+1].getRegno() == requisiti.getRegni()[2])) {
								combinazioniCarte.add(matrice[i+3][j+1]);
								
								for(Carta c : combinazioniCarte) c.setConsiderata(1);
								dati.setPunteggio(dati.getPunteggio() + 3);
								
								
							}
						}
					}
					
					combinazioniCarte = null;
				}
			}		
		}
		
		else if (requisiti.getTipoObiettivo() == 3) {	// tris
		
			int qtaTris = 0;
			
			switch(requisiti.getFigure()[0]) {
			
				case FARFALLA:	qtaTris = dati.getFigure()[0];
				case FOGLIA:	qtaTris = dati.getFigure()[1];
				case FUNGO:		qtaTris = dati.getFigure()[2];
				case LUPO:		qtaTris = dati.getFigure()[3];
				default:		break;
			}
			
			int punteggioDaApportare = qtaTris / 3;
			dati.setPunteggio(dati.getPunteggio() + punteggioDaApportare * 2);
				
		}
		
		else if (requisiti.getTipoObiettivo() == 4) {	// oggetto
			
			if(requisiti.getOggetti()[0] != requisiti.getOggetti()[1]) {		// se i tre oggetti sono diversi
				
				int minimo = dati.getQtaOggetti()[0];
				
				for(int i = 0; i < 3; i++) {
					if(dati.getQtaOggetti()[i] < minimo)
						minimo = dati.getQtaOggetti()[i];
				}
				
				int punteggioApportato = minimo / 3;
				dati.setPunteggio(dati.getPunteggio() + punteggioApportato * 2);

			}else {
				
				int qtaTris = 0;
				
				switch(requisiti.getOggetti()[0]) {
				
					case BOCCETTA:	qtaTris = dati.getFigure()[0];
					case PERGAMENA:	qtaTris = dati.getFigure()[1];
					case PIUMA:		qtaTris = dati.getFigure()[2];
					default:		break;
				}
				
				int punteggioDaApportare = qtaTris / 3;
				dati.setPunteggio(dati.getPunteggio() + punteggioDaApportare * 2);
			}
		}
		
	
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(tavolo.getMatrice()[i][j] != null)
					tavolo.getMatrice()[i][j].setConsiderata(0);
			}
		}
	}

	
	public void verificaObiettiviComuni(List<CartaObiettivo> carte) {
		
		for(int i = 0; i < 2; i++)
			verificaObiettivo(carte.get(i));
	}


	public void pescaCartaInizializzazione(int i) {
		switch(i) {
		
			case 1:
				tavolo.scegliCartaDaComune(comune.assegnaCartaRisorsa());
				break;
				
			case 2:
				tavolo.scegliCartaDaComune(comune.assegnaCartaOro());
				break;
				
			case 3:
				Scanner sc = new Scanner(System.in);
				CartaIniziale iniz = (CartaIniziale) comune.assegnaCartaIniziale();
				int latoscelto = 0;
				
				char[][] bufIniz = new char[9][32];
				for(int z = 0; z < 9; z++)
					for(int y = 0; y < 32; y++)
						bufIniz[z][y] = ' ';
				
				
				System.out.println("       (1)              (2)");
				Grafica.stampaCartaIniziale(iniz, bufIniz, 4, 7);
				iniz.setLatoScelto(1);
				Grafica.stampaCartaIniziale(iniz, bufIniz, 4, 24);
				iniz.setLatoScelto(0);
				
				for(int z = 0; z < 9; z++) {
					for(int y = 0; y < 32; y++)
						System.out.print(bufIniz[z][y]);
					System.out.print("\n");
				}
				
				
				do {
					//Stampa la carta iniziale, sia fronte che retro
					
					System.out.println("Vuoi giocare la carta iniziale sul fronte (1) o sul retro (2)?");
					
					String temp = sc.nextLine();
					
					System.out.println(temp.charAt(0));
					
					latoscelto = Character.getNumericValue(temp.charAt(0));
					
				}while( (latoscelto <= 0) || (latoscelto >= 3) );
				
				iniz.setLatoScelto(latoscelto - 1);
				tavolo.posizionaCartaInMatrice(iniz, new Point(50, 50));
				
				break;		
		}
	}
	
	
	
	
	public void setPunteggio(int punt) {
		
		dati.setPunteggio(punt);
	}
	
	
}