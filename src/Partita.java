import java.util.*;
import java.io.FileNotFoundException;

public class Partita {

	private List<Giocatore> giocatori;
	private Classifica classifica;
	private Comune comune;
	private int numeroGiocatori;
	private int giocatoreCorrente;
	private boolean flusso;
	
	
	/**
	 * Il costruttore della classe Partita inizializza tutto il tavolo di gioco, i mazzi con le relative carte e i giocatori con il loro nome e colore
	 * @param n
	 * @throws FileNotFoundException
	 */
	public Partita(int n) throws FileNotFoundException {
		
		this.comune = new Comune();
		comune.mischiaCarte();
		
		this.numeroGiocatori = n;
		Scanner sc = new Scanner(System.in);
		String nome;
		Colore colore;
		
		giocatori = new ArrayList<Giocatore>();
		
		for(int i = 0; i < n; i++) {
			
			System.out.println("Inserisci il nome del giocatore numero" + i+1 + ": ");
			nome = sc.nextLine();
			System.out.println("Inserisci il colore del giocatore numero" + i+1 + ": ");
			System.out.println("1. Blu\n2. Rosso\n3. Verde\n4. Giallo\n5. Nero\n");
			colore = (Colore) sc.nextLine();
			// ci sarebbe da sistemare la casistica blah blah blah
					
			Conteggio conteggio = new Conteggio();
			Dati dati = new Dati(nome, colore, conteggio);
			Tavolo tavolo = new Tavolo();
			
			Giocatore giocatore = new Giocatore(dati, tavolo, comune);
			
			giocatori.add(giocatore);

		}
		classifica = new Classifica(giocatori);
	}
	
	
	
	
	
	public void flussoDiGioco() {
		
		Random rand = new Random();
		int turnoDi = rand.nextInt(numeroGiocatori);
		
		
		do {
			
			
			
			
		}
		while(!verificaConclusione(turnoDi));
		
		
		
	}
	
	
	
	public boolean verificaConclusione(int turnoDi) {
		
		boolean risultato;
		
		boolean condizioneMazziVuoti;
		boolean condizionePuntMagVenti;
		boolean condizioneTurni;
		
		int[] mazzi = comune.getNumeroCartePerMazzo();
		
		int[] puntiGiocatori = new int[this.numeroGiocatori];
		for(int i = 0; i < numeroGiocatori; i++)
			puntiGiocatori[i] = giocatori.get(turnoDi).getPunteggio();

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
			
			if(turno != turniGiocatori[i])
				condizioneTurni = false;
			
		}
			
		risultato = ((condizioneMazziVuoti || condizionePuntMagVenti) && condizioneTurni);
		return risultato;
	}
	
	
	
	
	
	
	
	
}
