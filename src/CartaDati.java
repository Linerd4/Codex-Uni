public class CartaDati {
    
	private Regno regno;
    private int punti;
    private int latoScelto;
    private int considerata;
	private Figura figura_altosx;
	private Figura figura_altodx;
	private Figura figura_bassosx;
	private Figura figura_bassodx;

    public CartaDati(Regno regno, int punti) {
    	this.regno = regno;
    	this.punti = punti;
    	this.latoScelto = 0;
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

    public void setLatoScelto(int latoScelto) {
        if (latoScelto == 0) {
            System.out.println("Il giocatore deve ancora decidere su quale lato giocare la carta.");
        } else if (latoScelto == 2) {
        	this.figura_altosx = Figura.NULL;
        	this.figura_altodx = Figura.NULL;
        	this.figura_bassosx = Figura.NULL;
        	this.figura_bassodx = Figura.NULL;
        }
            
        	int[] visibilita = getVisibilita();
            for (int i = 0; i < visibilita.length; i++) {
                if (visibilita[i] == 0) {
                    switch (i) {
                        case 0:
                            visibilita[i] = 1;
                            break;
                        case 1:
                            visibilita[i] = 1;
                            break;
                        case 2:
                            visibilita[i] = 1;
                            break;
                        case 3:
                            visibilita[i] = 1;
                            break;
                        default:
                            break;
                   
                }
            }
        }
    }

	private int[] getVisibilita() {
		// TODO Auto-generated method stub
		return null;
	}
}