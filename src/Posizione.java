package src;


import java.util.*;

public class Posizione{
	private int altosx;
	private int altodx;
	private int bassosx;
	private int bassodx;

public Posizione(int altosx, int altodx, int bassosx, int bassodx) {
	this.altosx = altosx;
	this.altodx = altodx;
	this.bassosx = bassosx;
	this.bassodx = bassodx;
}

	
public int getAltosx() {
	return altosx;
}
public int getAltodx() {
	return altodx;
}
public int getBassosx() {
	return bassosx;
}
public int getBassodx() {
	return bassodx;
}


}