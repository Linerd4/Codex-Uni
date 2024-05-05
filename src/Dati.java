import java.util.*;

public class Dati {
	private String nome;
	private Colore colore;
	private Conteggio conteggio;
	private int punteggio;

	public Dati(String nome, Colore colore, Conteggio conteggio, int punteggio) {
		this.nome = nome;
		this.colore = colore;
		this.conteggio = conteggio;
		this.punteggio = punteggio;
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
	public void aumentaPunteggio() {
		
	}

}
