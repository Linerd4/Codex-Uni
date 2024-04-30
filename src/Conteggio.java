package codex;

import java.util.*;

public class Conteggio extends Dati{
private int boccetta;
private int farfalle;
private int foglie;
private int funghi;
private int lupi;
private int pergamene;
private int piume;

public Conteggio(int boccetta,int farfalle,int foglie,int funghi,int lupi,int pergamene,int piume) {
	this.boccetta=boccetta;
	this.farfalle=farfalle;
	this.foglie=foglie;
	this.funghi=funghi;
	this.lupi=lupi;
	this.pergamene=pergamene;
	this.piume=piume;
}
public void aggiornaConteggio() {
	
}
public int getBoccetta() {
	return boccetta;
}
public int getFarfalle() {
	return farfalle;
}
public int getFoglie() {
	return foglie;
}
public int getFunghi() {
	return funghi;
}
public int getLupi() {
	return lupi;
}
public int getPergamene() {
	return pergamene;
}
public int getPiume() {
	return piume;
}





}
