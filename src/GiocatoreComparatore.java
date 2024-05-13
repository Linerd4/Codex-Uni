import java.util.Comparator;

public class GiocatoreComparatore implements Comparator{

	public int compare(Object o1, Object o2) {
		Giocatore g1 = (Giocatore)o1;
		Giocatore g2 = (Giocatore)o2;
		
		if (g1.getPunteggio() == g2.getPunteggio()) 	return 0;
		else if (g1.getPunteggio() > g2.getPunteggio()) return 1;
		else 											return -1;
	}
}
