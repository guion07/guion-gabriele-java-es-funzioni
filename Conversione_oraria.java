import java.util.Scanner;
public class Conversione_oraria {
    public static void main(String[]args){
        int tempoInSecondi = leggiTempo();
        convertiTempo(tempoInSecondi);
    }

    public static int leggiTempo() {
        Scanner scanner = new Scanner(System.in);
        int tempo;
        
        while (true) {
            System.out.print("Inserisci il tempo in secondi (0-84600): ");
            tempo = scanner.nextInt();
            if (tempo >= 0 && tempo <= 84600) {
                return tempo;
            } else {
                System.out.println("Valore non valido. Per favore inserisci un valore tra 0 e 84600.");
            }
        }
    }

    public static void convertiTempo(int secondi) {
        int ore = secondi / 3600;
        int minuti = (secondi % 3600) / 60;
        int secondiRimanenti = secondi % 60;

        System.out.println(secondi + " secondi corrispondono a " + ore + " ore, " + minuti + " minuti e " + secondiRimanenti + " secondi.");
    }
}
