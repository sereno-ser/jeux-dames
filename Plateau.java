public class Plateau {

    public static void plateauVierge(String[][] plateau) { //remplir le plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = "_";
            }
        }
    }


    public static void afficherPlateau(String[][] plateau) { // afficher le plateau

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }

    }
}