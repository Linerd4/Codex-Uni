import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean uscire = false;

        while (!uscire) {
            System.out.println("Menu di Partenza:");
            System.out.println("1. Nuova Partita");
            System.out.println("2. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inizia una nuova partita!");
                    break;
                case 2:
                    System.out.println("Arrivederci!");
                    uscire = true; 
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
