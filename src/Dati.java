import java.util.*;

public class Dati {
	private String nome;
	private Colore colore;
	private Conteggio conteggio;
	private int punteggio;

	
	public Dati(String nome, Colore colore, Conteggio conteggio) {
		this.nome = nome;
		this.colore = colore;
		this.conteggio = conteggio;
		this.punteggio = 0;
	}

	
	public int[] getQtaOggetti() {
		
		int[] qtaoggetti = new int[3];
		qtaoggetti[0] = conteggio.getBoccetta();
		qtaoggetti[1] = conteggio.getPergamene();
		qtaoggetti[2] = conteggio.getPiume();
		
		return qtaoggetti;		
	}
	
	
	
	public int[] getFigure() {
		
		int[] qtafigure = new int[4];
		qtafigure[0] = conteggio.getFarfalle();
		qtafigure[1] = conteggio.getFoglie();
		qtafigure[2] = conteggio.getFunghi();
		qtafigure[3] = conteggio.getLupi();
	
		return qtafigure;
	
	}
	
	
	
	public String getNome() {
		return nome;
	}

	
	public Colore getColore() {
		return colore;
	}

	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setPunteggio(int punti) {
		this.punteggio = punti;
	}
	
	public void aumentaPunteggio() {
		
	}

}
