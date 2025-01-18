import java.util.Scanner;

public class Regles {
    
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
                        Plateau.afficherPlateau(plateau);
                    }
                }
                
            }
        }

        scanner.close();


    }
}
