public class Plateau {

    public static void plateauVierge(String[][] plateau) { //remplir le plateau
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plateau[i][j] = "_";
            }
        }
    }


    public static void afficherPlateau(String[][] plateau) { // afficher le plateau

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}