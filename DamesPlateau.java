import java.util.Scanner;

public class DamesPlateau {

    public static void main(String[] args) {
        // Créer un tableau plateau de 8x8
        String[][] plateau = new String[8][8];

        // Initialiser le plateau vierge
        plateauVierge(plateau);

        // Placer les pièces
        piece(plateau);

        // Afficher le plateau
        afficherPlateau(plateau);

        mouvement(plateau);
    }

    public static void plateauVierge(String[][] plateau) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateau[i][j] = "_";  // Remplir chaque case avec un tiret
            }
        }
    }


    public static void afficherPlateau(String[][] plateau) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        mouvement(plateau);

    }


    public static void piece(String[][] plateau) {
        // Placer des pièces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Placer les pièces uniquement sur les cases noires
                if ((i + j) % 2 == 0){  // Si la case est noire
                    if (i < 3) {
                        plateau[i][j] = "B";  // Placer une pièce noire sur les 3 premières lignes
                    } else if (i > 4) {
                        plateau[i][j] = "W";  // Placer une pièce blanche sur les 3 dernières lignes
                    }
                }
            }
        }
    }

    public static void mouvement(String[][] plateau) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;

        while (boucle) {
            
            // Demander à l'utilisateur d'entrer les coordonnées du pion
            System.out.print("Entre les coordonnées de ton pion (par exemple, A1, C3) : ");
            String origine = scanner.nextLine();
            int ligneo = origine.charAt(1) - '1';
            int colonneo = origine.charAt(0) - 'A';
            
            if (plateau[ligneo][colonneo].equals("_")) {
                System.out.println("Il n'y a pas de pion sur cette case veuillez réessayer ");//ok

            } else {
                while (boucle) {
                    System.out.print("Entre les coordonnées d'arriver de ton pion (par exemple, D5, A3) : ");
                    String arrivé = scanner.nextLine();
                    int lignea = arrivé.charAt(1) - '1';
                    int colonnea = arrivé.charAt(0) - 'A';

                    if (plateau[lignea][colonnea] != "_") { //rajouter la condition de déplacement en fonction de qui joue
                        System.out.println("La case est deja occupée veuillez réessayer");
                    } else {
                        // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                        plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                        plateau[ligneo][colonneo] = "_";
                        boucle = false;
                        afficherPlateau(plateau);
                    }
                }
                
            }
        }

        scanner.close();


    }
}