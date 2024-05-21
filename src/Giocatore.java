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
		
		// qui e' da stampare il proprio tavolo di gioco
		System.out.println(tavolo.getMatrice());
		// qui si stampa la carta obiettivo da sola
		System.out.println(tavolo.getObiettivo());
		// qui si stamano le carte disponibili da giocare
		System.out.println(tavolo.getDisponibili());
		
		Scanner sc = new Scanner(System.in);
		int scelta = 0;
		int soprasotto;
		boolean cartaNonValida = true;
		
		
		do {
			System.out.println("Quale carta vuoi giocare? (1 - 2 - 3");
			scelta = sc.nextInt();
			System.out.println("Vuoi giocarla sopra (1) oppure sotto (0) ?");
			
			soprasotto = sc.nextInt();	
			tavolo.getCartaDaDisponibili(scelta).setLatoScelto(soprasotto);
			
			if((tavolo.getCartaDaDisponibili(scelta) instanceof CartaOro)&&(tavolo.getCartaDaDisponibili(scelta).getLatoScelto() == 1)) {
				
				// CONTROLLA I REQUISITI
				if(cartaNonValida) System.out.println("Il lato scelto della carta oro non soddisfa i requisiti. Gioca l'altro lato oppure scegli una carta risorsa.");
			
			}else cartaNonValida = false;	
		
		}while(cartaNonValida);
		
		
		
		List<Point> posizioniValide = tavolo.analizzaMatrice();
		System.out.println(posizioniValide);
		
		System.out.println("Dove vuoi posizionare la carta?");
		int posizioneSceltaNellaMatrice = sc.nextInt();
		
		tavolo.posizionaCartaInMatrice(tavolo.giocaCartaDaDisponibili(scelta), posizioniValide.get(posizioneSceltaNellaMatrice));
		
		
	}

	
	public void pescaCarta() {
		
		
		System.out.println("Queste sono le carte risorse e oro scoperte:");
		
		//si ok, qui stampa solo la lista di indirizzi
		// va fatta la grafica che stampa tutte e quattro le carte
		System.out.println(comune.getMazzini());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Da quale mazzo vuoi pescare? Da\n1) Mazzo Risorsa\n2) Mazzo Oro\n3) Prendi una delle due carte risorsa scoperte\n4) Prendi una delle due carte oro scoperte");
		String scelta = sc.nextLine();
		
		switch(scelta) {
		
			case "1":
				tavolo.scegliCartaDaComune(comune.assegnaCartaRisorsa());
				
			case "2":
				tavolo.scegliCartaDaComune(comune.assegnaCartaOro());
				
			case "3":
				System.out.println("Quale delle due carte risorsa vuoi prendere? (1: la prima | 2: la seconda)");
				int scelta2 = sc.nextInt();
				tavolo.scegliCartaDaComune(comune.scegliRisorsaMazzino(scelta2));
				
			case "4":
				System.out.println("Quale delle due carte oro vuoi prendere? (1: la prima | 2: la seconda)");
				int scelta3 = sc.nextInt();
				tavolo.scegliCartaDaComune(comune.scegliOroMazzino(scelta3));
		}
		
		// per funzionare funzionera: bisogna aggiungere la verifica che l'utente abbia sempre due carte risorsa e una oro,
		// e questa attuale implementazione non fa questo controllo
		
		
		
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
	
		List<Carta> combinazioniCarte = new ArrayList<Carta>();
		
		if(requisiti.getTipoObiettivo() == 1) {		// diagonale
			
			for(int i = 0; i < 100; i++) {	
				for(int j = 0; j < 100; j++) {
					
					if(matrice[i][j].getRegno() == requisiti.getRegni()[0]) {
						
						combinazioniCarte.add(matrice[i][j]);
						if(matrice[i+1][j-1].getRegno() == requisiti.getRegni()[1]) {
							combinazioniCarte.add(matrice[i+1][j-1]);
							
							
							if(matrice[i+2][j-2].getRegno() == requisiti.getRegni()[2]) {
								combinazioniCarte.add(matrice[i+2][j-2]);
								
								for(Carta c : combinazioniCarte) c.setConsiderata(1);
								dati.setPunteggio(dati.getPunteggio() + 2);
								for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
								
							} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
						} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
					} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
				}	
			}
		}
		
		else if (requisiti.getTipoObiettivo() == 2) {	// L
			for(int i = 0; i < 100; i++) {	
				for(int j = 0; j < 100; j++) {
					
					if(matrice[i][j].getRegno() == requisiti.getRegni()[0]) {
						
						combinazioniCarte.add(matrice[i][j]);
						if(matrice[i+2][j].getRegno() == requisiti.getRegni()[1]) {
							combinazioniCarte.add(matrice[i+2][j]);
							
							
							if(matrice[i+3][j+1].getRegno() == requisiti.getRegni()[2]) {
								combinazioniCarte.add(matrice[i+3][j+1]);
								
								for(Carta c : combinazioniCarte) c.setConsiderata(1);
								dati.setPunteggio(dati.getPunteggio() + 2);
								for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
								
							} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
						} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
					} else for(Carta c : combinazioniCarte) combinazioniCarte.remove(c);
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
			dati.setPunteggio(dati.getPunteggio() + punteggioDaApportare);
				
		}
		
		else if (requisiti.getTipoObiettivo() == 4) {	// oggetto
			
			if(requisiti.getOggetti()[0] != requisiti.getOggetti()[1]) {		// se i tre oggetti sono diversi
				
				int minimo = dati.getQtaOggetti()[0];
				
				for(int i = 0; i < 3; i++) {
					if(dati.getQtaOggetti()[i] < minimo)
						minimo = dati.getQtaOggetti()[i];
				}
				
				int punteggioApportato = minimo / 3;
				dati.setPunteggio(dati.getPunteggio() + punteggioApportato);

			}else {
				
				int qtaTris = 0;
				
				switch(requisiti.getOggetti()[0]) {
				
					case BOCCETTA:	qtaTris = dati.getFigure()[0];
					case PERGAMENA:	qtaTris = dati.getFigure()[1];
					case PIUMA:		qtaTris = dati.getFigure()[2];
					default:		break;
				}
				
				int punteggioDaApportare = qtaTris / 3;
				dati.setPunteggio(dati.getPunteggio() + punteggioDaApportare);
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
	
}
