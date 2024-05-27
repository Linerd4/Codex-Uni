public class Posizione implements GetItemAngoli{
	
	// L'angolo della carta e' posizionato sopra o sotto?
	// 0: sotto
	// 1: sopra
	
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

		
	public int getAltoSx() {
		return altosx;
	}
	
		
	public int getAltoDx() {
		return altodx;
	}
	
	
	public int getBassoSx() {
		return bassosx;
	}
	
	
	public int getBassoDx() {
		return bassodx;
	}
	
	
	public void setAltoSx(int newaltosx) {
		altosx = newaltosx;
	}
	
		
	public void setAltoDx(int newaltodx) {
		altodx = newaltodx;
	}
	
	
	public void setBassoSx(int newbassosx) {
		bassosx = newbassosx;
	}
	
	
	public void setBassoDx(int newbassodx) {
		bassodx = newbassodx;
	}
	
	
}