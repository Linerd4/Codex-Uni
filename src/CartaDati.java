public class CartaDati {
    private Regno regno;
    private int punti;
    private int latoScelto;
    private int id;
    private int considerata;
    private Giocatore giocatore;
	private Object figura_altosx;
	private Object figura_altodx;
	private Object figura_bassosx;
	private Object figura_bassodx;

    public CartaDati(Regno regno, int punti, int latoScelto, int id, int considerata, Giocatore giocatore) {
    	this.regno = regno;
    	this.punti = punti;
    	this.latoScelto = latoScelto;
    	this.id = id;
    	this.considerata = considerata;
    	this.giocatore = giocatore;
    }

    public Regno getRegno() {
        return regno;
    }

    public int getPunti() {
        return punti;
    }

    public int getId() {
        return id;
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
        	this.figura_altosx = null;
        	this.figura_altodx = null;
        	this.figura_bassosx = null;
        	this.figura_bassodx = null;
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