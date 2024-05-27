public class Visibilità implements GetItemAngoli{
	
	private int altoSx;
	private int altoDx;
	private int bassoSx;
	private int bassoDx;

	
	public Visibilità(int altoSx, int altoDx, int bassoSx, int bassoDx) {
		
		this.altoDx = altoDx;
		this.altoSx = altoSx;
		this.bassoDx = bassoDx;
		this.bassoSx = bassoSx;
	}


	public int getAltoSx() {
		return altoSx;
	}

	
	public int getAltoDx() {
		return altoDx;
	}

	
	public int getBassoSx() {
		return bassoSx;
	}

	
	public int getBassoDx() {
		return bassoDx;
	}	
	
	
	public void setAltoSx(int newAltoSx) {
		altoSx = newAltoSx;
	}
	
	public void setAltoDx(int newAltoDx) {
		altoDx = newAltoDx;
	}

	public void setBassoSx(int newBassoSx) {
		bassoSx = newBassoSx;
	}
	
	public void setBassoDx(int newBassoDx) {
		bassoDx = newBassoDx;
	}
}
