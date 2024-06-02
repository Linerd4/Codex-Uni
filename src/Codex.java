import java.io.FileNotFoundException;
import java.util.Scanner;

public class Codex {

	public static void main(String[] args) throws FileNotFoundException {

		
		System.out.println("  ____          _                _   _       _                   _ _     ");
		System.out.println(" / ___|___   __| | _____  __    | \\ | | __ _| |_ _   _ _ __ __ _| (_)___ ");
		System.out.println("| |   / _ \\ / _` |/ _ \\ \\/ /    |  \\| |/ _` | __| | | | '__/ _` | | / __|");
		System.out.println("| |__| (_) | (_| |  __/>  <     | |\\  | (_| | |_| |_| | | | (_| | | \\__ \\");
		System.out.println(" \\____\\___/ \\__,_|\\___/_/\\_\\    |_| \\_|\\__,_|\\__|\\__,_|_|  \\__,_|_|_|___/");
		
		
		int players = 0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n\n\nLegenda:\n");
		System.out.println("A - Regno Animale		l - Lupo			b - Boccetta");
		System.out.println("F - Regno Fungale		Φ - Fungo			p - Penna");
		System.out.println("I - Regno Insettale		f - Farfalla			π - Piuma");
		System.out.println("V - Regno Vegetale		₣ - Foglia\n\n\n\n");
		
		
		do {
			System.out.println("\n\n\nBenvenuti a Codex! In quanti giocatori siete? (Minimo 2, Massimo 4) ");
			players = Character.getNumericValue((sc.nextLine().charAt(0)));
		}
		while((players != 2)&&(players != 3)&&(players != 4));
		
		
			for(int i = 0; i < 100; i++)
				System.out.println("\n");
		
			Partita partita = new Partita(players);
			
			partita.flussoDiGioco();
			partita.conclusione();
	}

}
