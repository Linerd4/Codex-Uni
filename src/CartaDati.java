public class CartaDati {
    
	private Regno regno;
    private int punti;
    private int latoScelto;
    private int considerata;


    public CartaDati() {
    	
    	this.regno = Regno.NULL;
    	this.punti = 0;
    	this.latoScelto = 1;
    	this.considerata = 0;
    }
    
    
    public CartaDati(Regno regno, int punti) {
    	this.regno = regno;
    	this.punti = punti;
    	this.latoScelto = 1;
    	this.considerata = 0;
    }

    
    public Regno getRegno() {
        return regno;
    }

    
    public int getPunti() {
        return punti;
    }

    
    public int getConsiderata() {
        return considerata;
    }

    
    public void setConsiderata(int i) {
        considerata = i;
    }

    
    public int getLatoScelto() {
    	return latoScelto;
    }
    
    
    public void setLatoScelto(int latoScelto) {
    
    	this.latoScelto = latoScelto;
    }
            
 	
	
}