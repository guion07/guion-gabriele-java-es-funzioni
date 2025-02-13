import java.util.Scanner;

public class RiepilogoVendite {

    public static void main(String[] args) {

        int N = leggiNumeroProdotti();
        double ricavoTotale = 0;
        int[] venditeCategoria = new int[4];
        double[] ricavoCategoria = new double[4];

        for (int i = 0; i < N; i++) {
            int tipoProdotto = leggiTipoProdotto();
            double prezzo = leggiPrezzoProdotto();
            ricavoTotale = aggiornaRicavoTotale(ricavoTotale, prezzo);
            venditeCategoria = aggiornaVenditeCategoria(venditeCategoria, tipoProdotto);
            ricavoCategoria = aggiornaRicavoCategoria(ricavoCategoria, tipoProdotto, prezzo);
        }

        mostraRicavoTotale(ricavoTotale);
        mostraVenditePerCategoria(venditeCategoria, N);
        mostraRicavoPerCategoria(ricavoCategoria, ricavoTotale);
    }

    public static int leggiNumeroProdotti() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di prodotti venduti: ");
        return scanner.nextInt();
    }

    public static int leggiTipoProdotto() {
        Scanner scanner = new Scanner(System.in);
        int tipoProdotto;
        while (true) {
            System.out.print("Inserisci il tipo di prodotto (1=televisore, 2=frigorifero, 3=lavatrici, 4=altro): ");
            tipoProdotto = scanner.nextInt();
            if (tipoProdotto >= 1 && tipoProdotto <= 4) {
                return tipoProdotto;
            } else {
                System.out.println("Tipo prodotto non valido, riprova.");
            }
        }
    }

    public static double leggiPrezzoProdotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il prezzo del prodotto: ");
        return scanner.nextDouble();
    }

    public static double aggiornaRicavoTotale(double ricavoTotale, double prezzo) {
        return ricavoTotale + prezzo;
    }

    public static int[] aggiornaVenditeCategoria(int[] venditeCategoria, int tipoProdotto) {
        venditeCategoria[tipoProdotto - 1]++;
        return venditeCategoria;
    }

    public static double[] aggiornaRicavoCategoria(double[] ricavoCategoria, int tipoProdotto, double prezzo) {
        ricavoCategoria[tipoProdotto - 1] += prezzo;
        return ricavoCategoria;
    }

    public static void mostraRicavoTotale(double ricavoTotale) {
        System.out.println("\nRicavo totale delle vendite: " + ricavoTotale + " €");
    }

    public static void mostraVenditePerCategoria(int[] venditeCategoria, int N) {
        System.out.println("\nVendite per categoria (numero e percentuale rispetto al totale):");
        for (int i = 0; i < 4; i++) {
            double percentualeCategoria = ((double) venditeCategoria[i] / N) * 100;
            System.out.printf("%s: %d prodotti (%.2f%%)\n", getCategoria(i), venditeCategoria[i], percentualeCategoria);
        }
    }

    public static void mostraRicavoPerCategoria(double[] ricavoCategoria, double ricavoTotale) {
        System.out.println("\nRicavo per categoria (valore assoluto e percentuale rispetto al ricavo totale):");
        for (int i = 0; i < 4; i++) {
            double percentualeRicavo = (ricavoCategoria[i] / ricavoTotale) * 100;
            System.out.printf("%s: %.2f € (%.2f%%)\n", getCategoria(i), ricavoCategoria[i], percentualeRicavo);
        }
    }

    public static String getCategoria(int indice) {
        switch (indice) {
            case 0: return "Televisori";
            case 1: return "Frigoriferi";
            case 2: return "Lavatrici";
            case 3: return "Altro";
            default: return "Sconosciuto";
        }
    }
}
