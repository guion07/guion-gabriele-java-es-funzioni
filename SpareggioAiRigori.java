import java.util.Random;

public class SpareggioAiRigori {

    public static void main(String[] args) {
        Random random = new Random();

        String squadra1 = "Squadra A";
        String squadra2 = "Squadra B";
        int goalSquadra1 = 0;
        int goalSquadra2 = 0;
        int tiriSquadra1 = 0;
        int tiriSquadra2 = 0;

        System.out.println("Inizia lo spareggio ai rigori!\n");

        for (int i = 1; i <= 5; i++) {
            System.out.println(squadra1 + " tira il rigore " + i);
            if (rigoreEffettuato(random)) {
                goalSquadra1++;
                System.out.println("Goal! Totale " + squadra1 + ": " + goalSquadra1 + " goal");
            } else {
                System.out.println("Parato! Totale " + squadra1 + ": " + goalSquadra1 + " goal");
            }
            tiriSquadra1++;

            System.out.println(squadra2 + " tira il rigore " + i);
            if (rigoreEffettuato(random)) {
                goalSquadra2++;
                System.out.println("Goal! Totale " + squadra2 + ": " + goalSquadra2 + " goal");
            } else {
                System.out.println("Parato! Totale " + squadra2 + ": " + goalSquadra2 + " goal");
            }
            tiriSquadra2++;
        }

        if (goalSquadra1 != goalSquadra2) {
            stampaRisultatoFinale(squadra1, squadra2, goalSquadra1, goalSquadra2, tiriSquadra1, tiriSquadra2);
            return;
        }

        System.out.println("\nParità dopo 5 tiri ciascuno. Si prosegue con i tiri supplementari.");

        int turno = 1;
        while (goalSquadra1 == goalSquadra2) {
            System.out.println("\nTurno supplementare " + turno + " - " + squadra1 + " tira");
            if (rigoreEffettuato(random)) {
                goalSquadra1++;
                System.out.println("Goal! Totale " + squadra1 + ": " + goalSquadra1 + " goal");
            } else {
                System.out.println("Parato! Totale " + squadra1 + ": " + goalSquadra1 + " goal");
            }
            tiriSquadra1++;

            System.out.println("\nTurno supplementare " + turno + " - " + squadra2 + " tira");
            if (rigoreEffettuato(random)) {
                goalSquadra2++;
                System.out.println("Goal! Totale " + squadra2 + ": " + goalSquadra2 + " goal");
            } else {
                System.out.println("Parato! Totale " + squadra2 + ": " + goalSquadra2 + " goal");
            }
            tiriSquadra2++;

            turno++;
        }

        stampaRisultatoFinale(squadra1, squadra2, goalSquadra1, goalSquadra2, tiriSquadra1, tiriSquadra2);
    }

    public static boolean rigoreEffettuato(Random random) {
        return random.nextInt(2) == 1;
    }

    public static void stampaRisultatoFinale(String squadra1, String squadra2, int goalSquadra1, int goalSquadra2, int tiriSquadra1, int tiriSquadra2) {
        System.out.println("\nRisultato finale:");
        System.out.println(squadra1 + " ha fatto " + goalSquadra1 + " goal in " + tiriSquadra1 + " tiri.");
        System.out.println(squadra2 + " ha fatto " + goalSquadra2 + " goal in " + tiriSquadra2 + " tiri.");

        if (goalSquadra1 > goalSquadra2) {
            System.out.println(squadra1 + " ha vinto!");
        } else {
            System.out.println(squadra2 + " ha vinto!");
        }
    }
}
