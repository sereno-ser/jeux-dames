public class Plateau {

    public static void plateauVierge(String[][] plateau) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = "_";  // Remplir chaque case avec un tiret
            }
        }
    }


    public static void afficherPlateau(String[][] plateau) { // pour pouvoir continuer a jouer 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        Regles.mouvement(plateau);

    }
}