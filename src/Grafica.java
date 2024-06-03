import java.awt.Point;
import java.util.List;

public class Grafica {

	
	private static char[][] buffer;
	
	
	public static void stampaTavoloDiGioco(Carta matrice[][], List<Point> posizioniDisponibili) {
		

		boolean quadratoNonVuoto = true;
		int controller = 0;
		
				
		while(quadratoNonVuoto) {
			
			quadratoNonVuoto = false;
			controller++;						// contiene il mezzo lato del quadrato nel quale c'e' NESSUNA carta
			
			for(int i = 0; i <= controller; i++) {
				
				if(matrice[50-controller][50-i] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50-controller][50+i] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50+controller][50-i] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50+controller][50+i] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50-i][50-controller] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50+i][50-controller] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50-i][50+controller] != null) {
					quadratoNonVuoto = true;
					break;
				}
				
				if(matrice[50+i][50+controller] != null) {
					quadratoNonVuoto = true;
					break;
				}	
			}
			
		}
		
		
		int ncolonne = (2 * controller + 1) * 15;
		
		int nrighe = (2 * controller + 1) * 9;
		
		
		buffer = new char[nrighe][ncolonne];
		
		for(int i = 0; i < nrighe; i++)
			for(int j = 0; j < ncolonne; j++)
				buffer[i][j] = ' ';
		
		stampaCartaIniziale((CartaIniziale) matrice[50][50], buffer, nrighe/2, ncolonne/2);
		
		stampaCarteNelBuffer(matrice, buffer, ncolonne, nrighe, controller - 1 );
		
		stampaPosizioniDisponibili(matrice, buffer, posizioniDisponibili, ncolonne/2, nrighe/2);


		
		for(int i = 0; i < nrighe; i++) {
			for(int j = 0; j < ncolonne; j++) {
				System.out.print(buffer[i][j]);
			}
			System.out.print("\n");
		}
		
	}
	

	

	
	public static void stampaDisponibili(List<Carta> cards, char[][] littlebuffer) {

		int counter = 0;
		stampaCartaNelBuffer(cards.get(counter), littlebuffer, 0, 0, 7, 4);
		
		counter++;
		stampaCartaNelBuffer(cards.get(counter), littlebuffer, 0, 0, 25, 4);
		
		counter++;
		stampaCartaNelBuffer(cards.get(counter), littlebuffer, 0, 0, 43, 4);
		
	}
		
		
		
		


	public static void stampaMazzini(List<Carta> mazzini, List<CartaObiettivo> obbs) {
		
		char[][] dueRisorse = new char[11][108];
		
		
		for(int i = 0; i < 11; i++) {
			for (int j = 0; j < 108; j++)
				dueRisorse[i][j] = ' ';
		}
		
		
		
		dueRisorse[0][18] = 'C';
		dueRisorse[0][19] = 'a';
		dueRisorse[0][20] = 'r';
		dueRisorse[0][21] = 't';
		dueRisorse[0][22] = 'e';
		dueRisorse[0][23] = ' ';
		dueRisorse[0][24] = 'r';
		dueRisorse[0][25] = 'i';
		dueRisorse[0][26] = 's';
		dueRisorse[0][27] = 'o';
		dueRisorse[0][28] = 'r';
		dueRisorse[0][29] = 's';
		dueRisorse[0][30] = 'a';
		dueRisorse[0][31] = ' ';
		dueRisorse[0][32] = '(';
		dueRisorse[0][33] = '1';
		dueRisorse[0][34] = ',';
		dueRisorse[0][35] = '2';
		dueRisorse[0][36] = ')';
		dueRisorse[0][37] = ' ';
		dueRisorse[0][38] = 'e';
		dueRisorse[0][39] = ' ';
		dueRisorse[0][40] = 'o';
		dueRisorse[0][41] = 'r';
		dueRisorse[0][42] = 'o';
		dueRisorse[0][43] = ' ';
		dueRisorse[0][44] = '(';
		dueRisorse[0][45] = '3';
		dueRisorse[0][46] = ',';
		dueRisorse[0][47] = '4';
		dueRisorse[0][48] = ')';
		dueRisorse[0][49] = ' ';
		dueRisorse[0][50] = 'c';
		dueRisorse[0][51] = 'o';
		dueRisorse[0][52] = 'm';
		dueRisorse[0][53] = 'u';
		dueRisorse[0][54] = 'n';
		dueRisorse[0][55] = 'i';
		
		int counter = 0;
		stampaCartaNelBuffer(mazzini.get(counter), dueRisorse, 0, 0, 7, 6);
		counter = 1;
		stampaCartaNelBuffer(mazzini.get(counter), dueRisorse, 0, 0, 25, 6);
		counter = 2;
		stampaCartaNelBuffer(mazzini.get(counter), dueRisorse, 0, 0, 43, 6);
		counter = 3;
		stampaCartaNelBuffer(mazzini.get(counter), dueRisorse, 0, 0, 61, 6);
		
		
		dueRisorse[0][80] = 'C';
		dueRisorse[0][81] = 'a';
		dueRisorse[0][82] = 'r';
		dueRisorse[0][83] = 't';
		dueRisorse[0][84] = 'e';
		dueRisorse[0][85] = ' ';
		dueRisorse[0][86] = 'o';
		dueRisorse[0][87] = 'b';
		dueRisorse[0][88] = 'i';
		dueRisorse[0][89] = 'e';
		dueRisorse[0][90] = 't';
		dueRisorse[0][91] = 't';
		dueRisorse[0][92] = 'i';
		dueRisorse[0][93] = 'v';
		dueRisorse[0][94] = 'o';
		dueRisorse[0][95] = ' ';
		dueRisorse[0][96] = 'c';
		dueRisorse[0][97] = 'o';
		dueRisorse[0][98] = 'm';
		dueRisorse[0][99] = 'u';
		dueRisorse[0][100] = 'n';
		dueRisorse[0][101] = 'i';
		
		
		stampaCartaObiettivo(obbs.get(0), dueRisorse, 82, 6);
		
		stampaCartaObiettivo(obbs.get(1), dueRisorse, 100, 6);
		
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 108; j++)
				System.out.print(dueRisorse[i][j]);
			System.out.print("\n");
		}
		
	}
	
	




	private static void stampaPosizioniDisponibili(Carta[][] matrice, char[][] buffer2,
			List<Point> posizioniDisponibili, int colCentre, int rigCentre) {
		
		int counter = 1;
		
		for(Point p : posizioniDisponibili) {
			
			int i = p.x - 50;	// questo varia in base alle righe!!!!!
			int j = p.y - 50;	// questo varia in base alle colonne!!!!!
			
			Integer temp = counter;
			
			String teeemp = temp.toString();
			
			buffer[rigCentre + i * 6][colCentre + j * 12] = teeemp.charAt(0);
			
			if(counter >= 10) buffer[rigCentre + i * 6][colCentre + j * 12 + 1] = teeemp.charAt(1);
							
			
			
			counter++;
			

		}
		
		
	}

	private static void stampaCarteNelBuffer(Carta[][] matrice, char[][] buffer, int nColonne, int nRighe, int controller) {
		
		int centroColonne = nColonne / 2;
		int centroRighe = nRighe / 2;
		
		for(int i = 1; i <= controller; i++) {		// fai passare i singoli quadrati
			
			for(int j = 0; j <= i; j++) {			// j : lo shift dal centro
				
				// matrice[50+-i][50 +- j]		SONO 4 COMBINAZIONI!
				
				if(matrice[50 + i][50 + j] != null)					// riga superiore e inferiore
					stampaCartaNelBuffer(matrice[50 + i][50 + j], buffer, i, j, centroColonne, centroRighe);
				
				if(matrice[50 - i][50 - j] != null)
					stampaCartaNelBuffer(matrice[50 - i][50 - j], buffer, -i, -j, centroColonne, centroRighe);
						
				if(matrice[50 + i][50 - j] != null)
					stampaCartaNelBuffer(matrice[50 + i][50 - j], buffer, i, -j, centroColonne, centroRighe);
							
				if(matrice[50 - i][50 + j] != null)
					stampaCartaNelBuffer(matrice[50 - i][50 + j], buffer, -i, j, centroColonne, centroRighe);
				

				
				
				// matrice[50 +- j][50 +- i]	PURE!
				
				if(matrice[50 + j][50 + i] != null) 			// colonna destra e sinistra
					stampaCartaNelBuffer(matrice[50 + j][50 + i], buffer, j, i, centroColonne, centroRighe);
					
				if(matrice[50 - j][50 - i] != null) 
					stampaCartaNelBuffer(matrice[50 - j][50 - i], buffer, -j, -i, centroColonne, centroRighe);
					
				if(matrice[50 + j][50 - i] != null) 
					stampaCartaNelBuffer(matrice[50 + j][50 - i], buffer, j, -i, centroColonne, centroRighe);
					
				if(matrice[50 - j][50 + i] != null) 
					stampaCartaNelBuffer(matrice[50 - j][50 + i], buffer, -j, i, centroColonne, centroRighe);
					
			}
		}
	}

	
	public static void stampaCartaObiettivo(CartaObiettivo carta, char[][] buffer, int colonnaCentrale, int rigaCentrale) {
	
		buffer[rigaCentrale-4][colonnaCentrale-7] = '+';
		buffer[rigaCentrale+4][colonnaCentrale-7] = '+';
		buffer[rigaCentrale-4][colonnaCentrale+7] = '+';
		buffer[rigaCentrale+4][colonnaCentrale+7] = '+';
		
		
		for(int i1 = 0; i1 < 7; i1++) {
			buffer[rigaCentrale-4][colonnaCentrale-i1] = '-';
			buffer[rigaCentrale+4][colonnaCentrale-i1] = '-';
			buffer[rigaCentrale-4][colonnaCentrale+i1] = '-';
			buffer[rigaCentrale+4][colonnaCentrale+i1] = '-';
			
		}
		
		for(int i2 = 0; i2 < 4; i2++) {
			buffer[rigaCentrale-i2][colonnaCentrale-7] = '|';
			buffer[rigaCentrale+i2][colonnaCentrale+7] = '|';
			buffer[rigaCentrale+i2][colonnaCentrale-7] = '|';
			buffer[rigaCentrale-i2][colonnaCentrale+7] = '|';
		}
		
		Regno[] regni = carta.getRequisiti().getRegni();
		char[] regnChar = new char[regni.length];
		
		for(int i = 0; i < 3; i++) {
			
			switch(regni[i]) {
			
				case ANIMALE: 	regnChar[i] = 'A'; break;
				case FUNGALE: 	regnChar[i] = 'F'; break;
				case INSETTALE: regnChar[i] = 'I'; break;
				case VEGETALE: 	regnChar[i] = 'V'; break;
				default:		break;
			}
		}
		
			
		if(carta.getRequisiti().getTipoObiettivo() == 1) {			// DIAGONALE
			
			buffer[rigaCentrale - 2][colonnaCentrale + 2] = regnChar[0];
			buffer[rigaCentrale][colonnaCentrale] = regnChar[0];
			buffer[rigaCentrale + 2][colonnaCentrale - 2] = regnChar[0];
			
			
			
		}else if(carta.getRequisiti().getTipoObiettivo() == 2) {			// L
			
			buffer[rigaCentrale - 2][colonnaCentrale - 1] = regnChar[0];
			buffer[rigaCentrale][colonnaCentrale - 1] = regnChar[1];
			buffer[rigaCentrale + 2][colonnaCentrale + 1] = regnChar[2];
			
			
			
		}else if(carta.getRequisiti().getTipoObiettivo() == 3) {			// TRIS
			
			
			Figura fig = carta.getRequisiti().getFigure()[0];
			char fig2 = 0;
			
			switch(fig) {
			
				case FOGLIA: 	fig2 = '₣'; break;
				case FARFALLA:	fig2 = 'f'; break;
				case FUNGO:		fig2 = 'Φ'; break;
				case LUPO:		fig2 = 'l'; break;
				case NULL:		fig2 = ' '; break;
			}

			buffer[rigaCentrale - 2][colonnaCentrale] = fig2;
			buffer[rigaCentrale + 2][colonnaCentrale - 2] = fig2;
			buffer[rigaCentrale + 2][colonnaCentrale + 2] = fig2;
			
			
			
		}else if(carta.getRequisiti().getTipoObiettivo() == 4) {			// OBJ
			
			Oggetto[] objs = carta.getRequisiti().getOggetti();
			char[] objs2 = new char[3];
			
			for(int i = 0; i < 3; i++) {
				
				switch(objs[i]) {
				
					case BOCCETTA: 	objs2[i] = 'b'; break;
					case PERGAMENA:	objs2[i] = 'p'; break;
					case PIUMA:		objs2[i] = 'π'; break;
					default:		break;
				}
			}
			
			if(objs[0] == objs[1]) {
				
				buffer[rigaCentrale - 1][colonnaCentrale] = objs2[0];
				buffer[rigaCentrale + 1][colonnaCentrale] = objs2[1];
				
			} else {
				
				buffer[rigaCentrale - 2][colonnaCentrale] 	= objs2[0];
				buffer[rigaCentrale][colonnaCentrale] 		= objs2[1];
				buffer[rigaCentrale + 2][colonnaCentrale]	= objs2[2];
				
			}
			
		}
		
	}
	
	
	
	
	
	private static void stampaCartaNelBuffer(Carta carta, char[][] buffer, int i, int j, int centroColonne, int centroRighe) {
		
		int posCentraleColonne = centroColonne + (j * 12);
		
		int posCentraleRighe = centroRighe + (i * 6);
		
		
		buffer[posCentraleRighe-4][posCentraleColonne-7] = '+';
		buffer[posCentraleRighe+4][posCentraleColonne-7] = '+';
		buffer[posCentraleRighe-4][posCentraleColonne+7] = '+';
		buffer[posCentraleRighe+4][posCentraleColonne+7] = '+';
		
		
		for(int i1 = 0; i1 < 7; i1++) {
			buffer[posCentraleRighe-4][posCentraleColonne-i1] = '-';
			buffer[posCentraleRighe+4][posCentraleColonne-i1] = '-';
			buffer[posCentraleRighe-4][posCentraleColonne+i1] = '-';
			buffer[posCentraleRighe+4][posCentraleColonne+i1] = '-';
			
		}
		
		for(int i2 = 0; i2 < 4; i2++) {
			buffer[posCentraleRighe-i2][posCentraleColonne-7] = '|';
			buffer[posCentraleRighe+i2][posCentraleColonne+7] = '|';
			buffer[posCentraleRighe+i2][posCentraleColonne-7] = '|';
			buffer[posCentraleRighe-i2][posCentraleColonne+7] = '|';
		}
		
		
		char reign = 0;
		
		switch(carta.getRegno()) {
		
			case ANIMALE:		reign = 'A'; break;
			case FUNGALE:		reign = 'F'; break;
			case INSETTALE:		reign = 'I'; break;
			case VEGETALE:		reign = 'V'; break;
			case NULL:			reign = ' '; break;
	
		}
		
		
		buffer[posCentraleRighe][posCentraleColonne] = reign;
		
		
		//stampami solo il riquadro esterno dell'angolo in alto a sinistra
		if(((carta.getVisibilita()[0] == 1)&&(carta.getPosizioni()[0] == 1)) || ((carta.getSovrapposizioni().get(0) == null)&&(carta.getVisibilita()[0] == 1))){
			
			buffer[posCentraleRighe - 3][posCentraleColonne - 5] = '|';
			buffer[posCentraleRighe - 2][posCentraleColonne - 6] = '-';
			buffer[posCentraleRighe - 2][posCentraleColonne - 5] = '+';
			//stampami il riquadro per contenere la figura/oggetto in alto a sinistra
		}

		
		
		//stampami solo il riquadro esterno dell'angolo in alto a destra
		if(((carta.getVisibilita()[1] == 1)&&(carta.getPosizioni()[1] == 1)) || ((carta.getSovrapposizioni().get(1) == null)&&(carta.getVisibilita()[1] == 1))) {
			
			buffer[posCentraleRighe - 3][posCentraleColonne + 5] = '|';
			buffer[posCentraleRighe - 2][posCentraleColonne + 6] = '-';
			buffer[posCentraleRighe - 2][posCentraleColonne + 5] = '+';
			//stampami il riquadro per contenere la figura/oggetto in alto a destra
		}
		
		//stampami solo il riquadro esterno dell'angolo in basso a sinistra
		if(((carta.getVisibilita()[2] == 1)&&(carta.getPosizioni()[2] == 1))|| ((carta.getSovrapposizioni().get(2) == null)&&(carta.getVisibilita()[2] == 1))) {
			
			buffer[posCentraleRighe + 3][posCentraleColonne - 5] = '|';
			buffer[posCentraleRighe + 2][posCentraleColonne - 6] = '-';
			buffer[posCentraleRighe + 2][posCentraleColonne - 5] = '+';
			//stampami il riquadro per contenere la figura/oggetto in basso a sinistra
		}
		
		
		//stampami solo il riquadro esterno dell'angolo in basso a destra
		if(((carta.getVisibilita()[3] == 1)&&(carta.getPosizioni()[3] == 1))|| ((carta.getSovrapposizioni().get(3) == null)&&(carta.getVisibilita()[3] == 1))) {
					
				buffer[posCentraleRighe + 3][posCentraleColonne + 5] = '|';
				buffer[posCentraleRighe + 2][posCentraleColonne + 6] = '-';
				buffer[posCentraleRighe + 2][posCentraleColonne + 5] = '+';
				//stampami il riquadro per contenere la figura/oggetto in basso a destra
		}

		
		// stampami figure e oggetti agli angoli
		
		for(int c = 0; c < 4; c++) {
			
			if((carta.getPosizioni()[c] == 1)&&(carta.getVisibilita()[c] == 1)) {
				
				
				char figura = 0;
				char oggetto = 0;
				
				switch(carta.getFigure().get(c)) {
				
					case FOGLIA: 	figura = '₣'; break;
					case FARFALLA:	figura = 'f'; break;
					case FUNGO:		figura = 'Φ'; break;
					case LUPO:		figura = 'l'; break;
					case NULL:		figura = ' '; break;
					
				}
				
				
				switch(c) {
				
					case 0:		buffer[posCentraleRighe - 3][posCentraleColonne - 6] = figura; break;
					case 1:		buffer[posCentraleRighe - 3][posCentraleColonne + 6] = figura; break;
					case 2:		buffer[posCentraleRighe + 3][posCentraleColonne - 6] = figura; break;
					case 3:		buffer[posCentraleRighe + 3][posCentraleColonne + 6] = figura; break;
				}
				
				switch(carta.getOggetti().get(c)) {
				
					case BOCCETTA: 	oggetto = 'b'; break;
					case PERGAMENA:	oggetto = 'p'; break;
					case PIUMA:		oggetto = 'π'; break;
					default:		if(figura == ' ') 
										oggetto = ' '; 
									else 
										oggetto = figura; 
									break;
				}
			
			
				switch(c) {
			
					case 0:		buffer[posCentraleRighe - 3][posCentraleColonne - 6] = oggetto; break;
					case 1:		buffer[posCentraleRighe - 3][posCentraleColonne + 6] = oggetto; break;
					case 2:		buffer[posCentraleRighe + 3][posCentraleColonne - 6] = oggetto; break;
					case 3:		buffer[posCentraleRighe + 3][posCentraleColonne + 6] = oggetto; break;
				}
				
				
				
				
				
			}
		}
		
		
		
		
		
		
		if(carta.getLatoScelto() == 1) {		// se si e' scelto di giocare il fronte della carta oro
			
			if(carta instanceof CartaOro) {
				
				char[] figs = new char[5];
				
				for(int c = 0; c < 5; c++) {
					
					switch(((CartaOro) carta).getRequisiti().getFigure()[c]) {
					
						case FOGLIA: 	figs[c] = '₣'; break;
						case FARFALLA:	figs[c] = 'f'; break;
						case FUNGO:		figs[c] = 'Φ'; break;
						case LUPO:		figs[c] = 'l'; break;
						case NULL:		figs[c] = ' '; break; 	
					
					}
				}
				
				char ogg = 0;
				
				switch(((CartaOro)carta).getRequisiti().getOggetto()) {
				
					case BOCCETTA:	ogg = 'b';		break;
					case PERGAMENA:	ogg = 'p';		break;
					case PIUMA:		ogg = 'π';		break;
					case ANGOLO:	ogg = '∟';		break;
					case NULL:		break;
				}
				
				if(((CartaOro) carta).getRequisiti().getFigure()[1] == Figura.NULL){
					buffer[posCentraleRighe + 3][posCentraleColonne] = figs[0];
					
				}else if(((CartaOro) carta).getRequisiti().getFigure()[2] == Figura.NULL) {
					buffer[posCentraleRighe + 3][posCentraleColonne - 1] = figs[0];
					buffer[posCentraleRighe + 3][posCentraleColonne + 1] = figs[1];
					
				}else if(((CartaOro) carta).getRequisiti().getFigure()[3] == Figura.NULL) {
					buffer[posCentraleRighe + 3][posCentraleColonne - 2] = figs[0];
					buffer[posCentraleRighe + 3][posCentraleColonne] = figs[1];
					buffer[posCentraleRighe + 3][posCentraleColonne + 2] = figs[2];
					
				}else if(((CartaOro) carta).getRequisiti().getFigure()[4] == Figura.NULL) {
					buffer[posCentraleRighe + 3][posCentraleColonne - 2] = figs[0];
					buffer[posCentraleRighe + 3][posCentraleColonne - 1] = figs[1];
					buffer[posCentraleRighe + 3][posCentraleColonne + 1] = figs[2];
					buffer[posCentraleRighe + 3][posCentraleColonne + 2] = figs[3];
					
				} else {
					buffer[posCentraleRighe + 3][posCentraleColonne - 2] = figs[0];
					buffer[posCentraleRighe + 3][posCentraleColonne - 1] = figs[1];
					buffer[posCentraleRighe + 3][posCentraleColonne] = figs[2];
					buffer[posCentraleRighe + 3][posCentraleColonne + 1] = figs[3];
					buffer[posCentraleRighe + 3][posCentraleColonne + 2] = figs[4];
				}
			
				
				if(((CartaOro) carta).getRequisiti().getOggetto() == Oggetto.NULL) 
					
					buffer[posCentraleRighe - 3][posCentraleColonne] = Integer.toString(carta.getPunti()).charAt(0);
				
				else {
					
					buffer[posCentraleRighe - 3][posCentraleColonne - 1] = Integer.toString(carta.getPunti()).charAt(0);
					buffer[posCentraleRighe - 3][posCentraleColonne + 1] = ogg;
				
				}
			}
			
		}
		
		
	}
	
	
	
	
	
	public static void stampaCartaIniziale(CartaIniziale carta, char[][] buffer, int centroRighe, int centroColonne) {
		
		buffer[centroRighe-4][centroColonne-7] = '+';
		buffer[centroRighe+4][centroColonne-7] = '+';
		buffer[centroRighe-4][centroColonne+7] = '+';
		buffer[centroRighe+4][centroColonne+7] = '+';
		
		for(int i = 0; i < 7; i++) {
			buffer[centroRighe-4][centroColonne-i] = '-';
			buffer[centroRighe+4][centroColonne+i] = '-';
			buffer[centroRighe+4][centroColonne-i] = '-';
			buffer[centroRighe-4][centroColonne+i] = '-';
		}
		
		for(int i = 0; i < 4; i++) {
			buffer[centroRighe-i][centroColonne-7] = '|';
			buffer[centroRighe+i][centroColonne+7] = '|';
			buffer[centroRighe+i][centroColonne-7] = '|';
			buffer[centroRighe-i][centroColonne+7] = '|';
		}
		
		
		if(carta.getLatoScelto() == 0) {
		
			if((carta.getVisibilita()[0] == 1)&&(carta.getPosizioni()[0] == 1)) {
				
				buffer[centroRighe-2][centroColonne-6] = '-';
				buffer[centroRighe-3][centroColonne-5] = '|';
				buffer[centroRighe-2][centroColonne-5] = '+';
				
				switch(carta.getFigure().get(0)) {
				
					case FOGLIA: 	buffer[centroRighe-3][centroColonne-6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-3][centroColonne-6] = 'f'; break;
					case FUNGO:		buffer[centroRighe-3][centroColonne-6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-3][centroColonne-6] = 'l'; break;
					case NULL:		buffer[centroRighe-3][centroColonne-6] = ' '; break;
					}
			}
			
			
			if((carta.getVisibilita()[1] == 1)&&(carta.getPosizioni()[1] == 1)) {
				
				buffer[centroRighe-2][centroColonne+6] = '-';
				buffer[centroRighe-3][centroColonne+5] = '|';
				buffer[centroRighe-2][centroColonne+5] = '+';
				
				switch(carta.getFigure().get(1)) {
				
					case FOGLIA: 	buffer[centroRighe-3][centroColonne+6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-3][centroColonne+6] = 'f'; break;
					case FUNGO:		buffer[centroRighe-3][centroColonne+6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-3][centroColonne+6] = 'l'; break;
					case NULL:		buffer[centroRighe-3][centroColonne+6] = ' '; break;
				}
			}
			
			
			if((carta.getVisibilita()[2] == 1)&&(carta.getPosizioni()[2] == 1)) {
				
				buffer[centroRighe+2][centroColonne-6] = '-';
				buffer[centroRighe+3][centroColonne-5] = '|';
				buffer[centroRighe+2][centroColonne-5] = '+';
				
				switch(carta.getFigure().get(2)) {
				
					case FOGLIA: 	buffer[centroRighe+3][centroColonne-6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+3][centroColonne-6] = 'f'; break;
					case FUNGO:		buffer[centroRighe+3][centroColonne-6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+3][centroColonne-6] = 'l'; break;
					case NULL:		buffer[centroRighe+3][centroColonne-6] = ' '; break;
				}
			}
			
			
			if((carta.getVisibilita()[3] == 1)&&(carta.getPosizioni()[3] == 1)) {
				
				buffer[centroRighe+2][centroColonne+6] = '-';
				buffer[centroRighe+3][centroColonne+5] = '|';
				buffer[centroRighe+2][centroColonne+5] = '+';
				
				switch(carta.getFigure().get(3)) {
				
					case FOGLIA: 	buffer[centroRighe+3][centroColonne+6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+3][centroColonne+6] = 'f'; break;
					case FUNGO:		buffer[centroRighe+3][centroColonne+6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+3][centroColonne+6] = 'l'; break;
					case NULL:		buffer[centroRighe+3][centroColonne+6] = ' '; break;
				}
			}	
			
			
			
//			STAMPA LE FIGURE CENTRALI ############################
			
			if(carta.getFigureFrontali()[1] == Figura.NULL) {
					switch(carta.getFigureFrontali()[0]) {
					
						case FOGLIA: 	buffer[centroRighe][centroColonne] = '₣'; break;
						case FARFALLA:	buffer[centroRighe][centroColonne] = 'f'; break;
						case FUNGO:		buffer[centroRighe][centroColonne] = 'Φ'; break;
						case LUPO:		buffer[centroRighe][centroColonne] = 'l'; break;
						case NULL:		buffer[centroRighe][centroColonne] = ' '; break;
				} 
			}
			
			
			else if(carta.getFigureFrontali()[2] == Figura.NULL) {
				switch(carta.getFigureFrontali()[0]) {
					
					case FOGLIA: 	buffer[centroRighe-1][centroColonne] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-1][centroColonne] = 'f'; break;
					case FUNGO:		buffer[centroRighe-1][centroColonne] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-1][centroColonne] = 'l'; break;
					case NULL:		buffer[centroRighe-1][centroColonne] = ' '; break;
				}
				
				switch(carta.getFigureFrontali()[1]) {
				
					case FOGLIA: 	buffer[centroRighe+1][centroColonne] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+1][centroColonne] = 'f'; break;
					case FUNGO:		buffer[centroRighe+1][centroColonne] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+1][centroColonne] = 'l'; break;
					case NULL:		buffer[centroRighe+1][centroColonne] = ' '; break;
				}
			}
			
			else {
				
				switch(carta.getFigureFrontali()[0]) {
				
					case FOGLIA: 	buffer[centroRighe-1][centroColonne] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-1][centroColonne] = 'f'; break;
					case FUNGO:		buffer[centroRighe-1][centroColonne] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-1][centroColonne] = 'l'; break;
					case NULL:		buffer[centroRighe-1][centroColonne] = ' '; break;
				}
			
				switch(carta.getFigureFrontali()[1]) {
			
					case FOGLIA: 	buffer[centroRighe][centroColonne] = '₣'; break;
					case FARFALLA:	buffer[centroRighe][centroColonne] = 'f'; break;
					case FUNGO:		buffer[centroRighe][centroColonne] = 'Φ'; break;
					case LUPO:		buffer[centroRighe][centroColonne] = 'l'; break;
					case NULL:		buffer[centroRighe][centroColonne] = ' '; break;
				}
				
				switch(carta.getFigureFrontali()[2]) {
				
					case FOGLIA: 	buffer[centroRighe+1][centroColonne] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+1][centroColonne] = 'f'; break;
					case FUNGO:		buffer[centroRighe+1][centroColonne] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+1][centroColonne] = 'l'; break;
					case NULL:		buffer[centroRighe+1][centroColonne] = ' '; break;
				}
		
			}
	
		}
		
		
		else if(carta.getLatoScelto() == 1) {
			
			if((carta.getVisibilitaRetro()[0] == 1)&&(carta.getPosizioniRetro()[0] == 1)) {
				
				buffer[centroRighe-2][centroColonne-6] = '-';
				buffer[centroRighe-3][centroColonne-5] = '|';
				buffer[centroRighe-2][centroColonne-5] = '+';
				
				switch(carta.getFigureRetro().get(0)) {
				
					case FOGLIA: 	buffer[centroRighe-3][centroColonne-6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-3][centroColonne-6] = 'f'; break;
					case FUNGO:		buffer[centroRighe-3][centroColonne-6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-3][centroColonne-6] = 'l'; break;
					case NULL:		buffer[centroRighe-3][centroColonne-6] = ' '; break;
					}
			}
			
			
			if((carta.getVisibilitaRetro()[1] == 1)&&(carta.getPosizioniRetro()[1] == 1)) {
				
				buffer[centroRighe-2][centroColonne+6] = '-';
				buffer[centroRighe-3][centroColonne+5] = '|';
				buffer[centroRighe-2][centroColonne+5] = '+';
				
				switch(carta.getFigureRetro().get(1)) {
				
					case FOGLIA: 	buffer[centroRighe-3][centroColonne+6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe-3][centroColonne+6] = 'f'; break;
					case FUNGO:		buffer[centroRighe-3][centroColonne+6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe-3][centroColonne+6] = 'l'; break;
					case NULL:		buffer[centroRighe-3][centroColonne+6] = ' '; break;
				}
			}
			
			
			if((carta.getVisibilitaRetro()[2] == 1)&&(carta.getPosizioniRetro()[2] == 1)) {
				
				buffer[centroRighe+2][centroColonne-6] = '-';
				buffer[centroRighe+3][centroColonne-5] = '|';
				buffer[centroRighe+2][centroColonne-5] = '+';
				
				switch(carta.getFigureRetro().get(2)) {
				
					case FOGLIA: 	buffer[centroRighe+3][centroColonne-6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+3][centroColonne-6] = 'f'; break;
					case FUNGO:		buffer[centroRighe+3][centroColonne-6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+3][centroColonne-6] = 'l'; break;
					case NULL:		buffer[centroRighe+3][centroColonne-6] = ' '; break;
				}
			}
			
			
			if((carta.getVisibilitaRetro()[3] == 1)&&(carta.getPosizioniRetro()[3] == 1)) {
				
				buffer[centroRighe+2][centroColonne+6] = '-';
				buffer[centroRighe+3][centroColonne+5] = '|';
				buffer[centroRighe+2][centroColonne+5] = '+';
				
				switch(carta.getFigureRetro().get(3)) {
				
					case FOGLIA: 	buffer[centroRighe+3][centroColonne+6] = '₣'; break;
					case FARFALLA:	buffer[centroRighe+3][centroColonne+6] = 'f'; break;
					case FUNGO:		buffer[centroRighe+3][centroColonne+6] = 'Φ'; break;
					case LUPO:		buffer[centroRighe+3][centroColonne+6] = 'l'; break;
					case NULL:		buffer[centroRighe+3][centroColonne+6] = ' '; break;
				}
			}	
		}	
	}
	
}
