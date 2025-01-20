import java.util.Scanner;

public class Regles {

    public static void mouvement(String[][] plateau, int i) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;
        boolean droit = false;
        
        if (i % 2 == 0) {
            System.out.println("au tour des blancs");
                
         } else {
            System.out.println("au tour des noirs");
        }
        while (boucle) {
            
            // Demander à l'utilisateur d'entrer les coordonnées du pion
            System.out.print("Entre les coordonnées de ton pion (par exemple, A1, C3) : ");
            String origine = scanner.nextLine();
            int ligneo = origine.charAt(1) - '1';
            int colonneo = origine.charAt(0) - 'A';

            if (i % 2 != 0) { //si impaire donc Black
                if (plateau[ligneo][colonneo].equals("\u001B[34mW\u001B[0m")) {
                    System.out.println("C'est au tour des noirs de jouer réessaye.");
                } else {
                    droit = true;
                }
            } else {
                if (plateau[ligneo][colonneo].equals("\u001B[31mB\u001B[0m")) {
                    System.out.println("C'est au tour des blancs de jouer réessaye.");
                } else {
                    droit = true;
                }
            }
                
            if (plateau[ligneo][colonneo].equals("_")) {
                System.out.println("Il n'y a pas de pion sur cette case veuillez réessayer.");//ok
    
            } else if(droit == true) {
                    
                while (boucle) {
                    System.out.print("Entre les coordonnées d'arriver de ton pion (par exemple, D5, A3) : ");
                    String arrivé = scanner.nextLine();
                    int lignea = arrivé.charAt(1) - '1';
                    int colonnea = arrivé.charAt(0) - 'A';
    
                    if (plateau[lignea][colonnea] != "_") { //rajouter la condition de déplacement en fonction de qui joue
                        System.out.println("La case est deja occupée veuillez réessayer.");
                    } else if (i % 2 == 0) {
                        if (lignea == ligneo - 1  && colonnea == colonneo + 1 || lignea == ligneo - 1 && colonnea == colonneo - 1 ){
                            // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        }
                        System.out.println("jpp 1");
                    } else if (lignea == ligneo + 1  && colonnea == colonneo + 1 || lignea == ligneo + 1  && colonnea == colonneo - 1 ){
                        // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                        plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                        plateau[ligneo][colonneo] = "_";
                        boucle = false;
                    } else {
                        System.out.println("jpp");
                    }
                    
                }
                    
            }
        }
        // pas de scanner.close() sinon message d'erreur
    }
}
