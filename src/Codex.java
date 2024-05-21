import java.io.FileNotFoundException;

public class Codex {

	public static void main(String[] args) throws FileNotFoundException {

		
			Partita partita = new Partita(3);
			
			partita.flussoDiGioco();
			partita.conclusione();
	}

}
