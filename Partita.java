import java.util.*;
import java.io.FileNotFoundException;

public class Partita {

    private List<Giocatore> giocatori;
    private Classifica classifica;
    private Comune comune;
    private int numeroGiocatori;
    private int giocatoreCorrente;
    
    /**
     * Il costruttore della classe Partita inizializza tutto il tavolo di gioco, i mazzi con le relative carte e i giocatori con il loro nome e colore
     * @param n
     * @throws FileNotFoundException
     */
    public Partita(int n) throws FileNotFoundException {
        // Crea mazzi e mazzini, e riempili
        this.comune = new Comune();
        Scanner sc = new Scanner(System.in);   
        this.numeroGiocatori = n;

        String nome = null;
        Colore colore = null;
        
        giocatori = new ArrayList<Giocatore>();
        Set<Colore> coloriUsati = new HashSet<>();
        
        // Assegna il colore nero automaticamente al primo giocatore
        colore = Colore.NERO;
        giocatori.add(creaGiocatore("Primo Giocatore", colore));
        coloriUsati.add(colore);
        

        // Permette agli altri giocatori di scegliere tra i colori rimanenti
        for(int i = 1; i < n; i++) {
        	System.out.println("Inserisci il nome del giocatore numero " + (i + 1) + ": ");
            nome = sc.nextLine();
            colore = scegliColore(i, coloriUsati);
            
            giocatori.add(creaGiocatore(nome, colore));
            coloriUsati.add(colore);
        }
        
        classifica = new Classifica(giocatori);
        
        
    }
    
    
    private Giocatore creaGiocatore(String nome, Colore colore) {
      
    	Conteggio conteggio = new Conteggio();
        Dati dati = new Dati(nome, colore, conteggio);
        Tavolo tavolo = new Tavolo();
        Giocatore giocatore = new Giocatore(dati, tavolo, comune);
        
        giocatore.pescaCartaInizializzazione(1);
        giocatore.pescaCartaInizializzazione(1);
        giocatore.pescaCartaInizializzazione(2);
        giocatore.pescaCartaInizializzazione(3);
        
        CartaObiettivo[] dueObiettivi = new CartaObiettivo[2];
        dueObiettivi = comune.dueObiettiviPerGiocatore();
        
        
        System.out.println(dueObiettivi);
        String stringa = null;
        Scanner sc = new Scanner(System.in);
        
        do {
        	
        	System.out.println("Quale delle due carte obiettivo scegli?");
            System.out.println("1) La prima\n2) La seconda");

            System.out.println(sc.hasNextLine());
            stringa = sc.nextLine();
        	
        }while(((Character.getNumericValue(stringa.charAt(0))) <= 0) || ((Character.getNumericValue(stringa.charAt(0))) >= 3) || (stringa == "\n"));
        
        
        int obb = Character.getNumericValue(stringa.charAt(0) - 1 );

        tavolo.setObiettivoPrincipale(dueObiettivi[obb]);
        // la carta obiettivo non scelta viene persa, ma questo non provoca problemi.
        
        
        return giocatore;
    }
    
    
    public Colore scegliColore(int indiceGiocatore, Set<Colore> coloriUsati) {
        Scanner sc = new Scanner(System.in);
        int scelta;
        Colore coloreScelto;
        
        System.out.println("Giocatore " + (indiceGiocatore + 1) + ", scegli il tuo colore:");
        
        do {        
            System.out.println("1. Blu");
            System.out.println("2. Rosso");
            System.out.println("3. Verde");
            System.out.println("4. Giallo");
            System.out.print("Scelta: ");
            scelta = Character.getNumericValue(sc.nextLine().charAt(0));
            
            switch (scelta) {
                case 1:
                    coloreScelto = Colore.BLU;
                    break;
                    
                case 2:
                    coloreScelto = Colore.ROSSO;
                    break;
                    
                case 3:
                    coloreScelto = Colore.VERDE;
                    break;
                    
                case 4:
                    coloreScelto = Colore.GIALLO;
                    break;
                    
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    coloreScelto = null;
                    break;
            }
            
        } while (scelta == '\n' || coloreScelto == null || coloriUsati.contains(coloreScelto));
        
        
        return coloreScelto;
    }
    
	
    public void flussoDiGioco() {
		
		Random rand = new Random();
		giocatoreCorrente = rand.nextInt(numeroGiocatori);
		
		int oldGiocatore;

		do {
			
			giocatori.get(giocatoreCorrente).giocaCarta();
			giocatori.get(giocatoreCorrente).pescaCarta();
			
			
			
			oldGiocatore = giocatoreCorrente;
			
			if( giocatoreCorrente == (numeroGiocatori - 1) )
				giocatoreCorrente = 0;
			else
				giocatoreCorrente++;
			
			classifica.ordinaClassifica();
			
		}
		while(!verificaConclusione(oldGiocatore));
				
	}
	
	
    	public boolean verificaConclusione(int turnoDi) {
		
		boolean risultato;
		
		boolean condizioneMazziVuoti;
		boolean condizionePuntMagVenti;
		boolean condizioneTurni;
		
		int[] mazzi = comune.getNumeroCartePerMazzo();
		
		int[] puntiGiocatori = new int[this.numeroGiocatori];
		for(int i = 0; i < numeroGiocatori; i++)
			puntiGiocatori[i] = giocatori.get(i).getPunteggio();

		int[] turniGiocatori = new int[this.numeroGiocatori];
		for(int i = 0; i < numeroGiocatori; i++)
			turniGiocatori[i] = giocatori.get(i).getNumeroTurni();
		
		
		if( (mazzi[0] == 0) && (mazzi[1] == 0) )
			condizioneMazziVuoti = true;
		else
			condizioneMazziVuoti = false;
		
		
		int max = 0;
		for(int i = 0; i < numeroGiocatori; i++) {
			
			if (puntiGiocatori[i] > max)
				max = puntiGiocatori[i];
		}
		
		if (max >= 20)
			condizionePuntMagVenti= true;
		else
			condizionePuntMagVenti = false;
		
		
		int turno = turniGiocatori[0];
		condizioneTurni = true;
		for(int i = 1; i < numeroGiocatori; i++) {
			
			if(turno != turniGiocatori[i]) {
				condizioneTurni = false;
				break;
			}
		}
			
		risultato = ((condizioneMazziVuoti || condizionePuntMagVenti) && condizioneTurni);
		return risultato;
	}
		
	
    public void conclusione() {
		
		
		for(Giocatore c : giocatori) {
			c.verificaObiettivo(c.getObiettivo());
			c.verificaObiettiviComuni( comune.getObiettivi());
		}
		
		classifica.ordinaClassifica();
		
		System.out.println("Il giocatore vincitore e'" + classifica.getGiocatore(0) + "!");
		
		return;
	}
	
	
}