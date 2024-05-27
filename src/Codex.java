import java.io.FileNotFoundException;

public class Codex {

	public static void main(String[] args) throws FileNotFoundException {

		
			Partita partita = new Partita(2);
			
			partita.flussoDiGioco();
			partita.conclusione();
	}

}
