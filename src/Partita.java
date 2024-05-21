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

			giocatori.get(i).pescaCarta();
			giocatori.get(i).pescaCarta();
			giocatori.get(i).pescaCarta();
			
		}
		classifica = new Classifica(giocatori);
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
	

	
	
	
	
	
	public void conclusione() {
		
		
		for(Giocatore c : giocatori)
			c.verificaObiettivo();
		
		classifica.ordinaClassifica();
		
		System.out.println("Il giocatore vincitore e'" + classifica.getGiocatore(0) + "!");
		
		return;
	}
	
	
	
}
