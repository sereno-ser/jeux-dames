import java.util.Scanner;

public class Regles {

    public static void mouvement(String[][] plateau, int i) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;
        boolean droit = false;
        
        if (i % 2 == 0) {
            System.out.println("C'est au tour des Blancs de jouer ");
                
         } else {
            System.out.println("C'est au tour des Noirs de jouer");
        }
        while (boucle) {
            
            // Demander à l'utilisateur d'entrer les coordonnées du pion
            System.out.print("Entre les coordonnées de ton pion (par exemple, A1, C3) : ");
            String origine = scanner.nextLine();
            int ligneo = origine.charAt(1) - '1';
            int colonneo = origine.charAt(0) - 'A';

            if (i % 2 != 0) { //si impaire donc Black
                if (plateau[ligneo][colonneo].equals("\u001B[34mW\u001B[0m")) {
                    System.out.println("\u001B[31mAttention : C'est au tour des Noirs de jouer !\u001B[0m");
                } else {
                    droit = true;
                }
            } else {
                if (plateau[ligneo][colonneo].equals("\u001B[31mB\u001B[0m")) {
                    System.out.println("\u001B[31mAttention : C'est au tour des Blancs de jouer !\u001B[0m");
                } else {
                    droit = true;
                }
            }
                
            if (plateau[ligneo][colonneo].equals("_")) {
                System.out.println("\u001B[31mAttention : Il n'y a pas de pion sur cette case !!\u001B[0m");
    
            } else if(droit == true) {
                    
                while (boucle) {
                    System.out.print("Entre les coordonnées d'arriver de ton pion (par exemple, D5, A3) : ");
                    String arrivé = scanner.nextLine();
                    int lignea = arrivé.charAt(1) - '1';
                    int colonnea = arrivé.charAt(0) - 'A';
    
                    if (plateau[lignea][colonnea] != "_") { //rajouter la condition de déplacement en fonction de qui joue
                        System.out.println("\\u001B[31mAttention : un pion est déja sur cette case !!\\u001B[0m");
                    } else if (i % 2 == 0) {
                        if (lignea == ligneo - 1  && colonnea == colonneo + 1 || lignea == ligneo - 1 && colonnea == colonneo - 1 ){ //permet d'autoriser le déplacement en diagonal pour "W"
                            // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        }
                        System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m");
                    } else if (lignea == ligneo + 1  && colonnea == colonneo + 1 || lignea == ligneo + 1  && colonnea == colonneo - 1 ){ //permet d'autoriser le déplacement en diagonal pour "B"
                        // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                        plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                        plateau[ligneo][colonneo] = "_";
                        boucle = false;
                    } else {
                        System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m");
                    }
                    
                }
                    
            }
        }
        // pas de scanner.close() sinon message d'erreur
    }

    public static String regle(String[] args) {
        
        System.err.println("\n" +
        "============================\n" +
        "   RÈGLES DU JEU DE DAMES   \n" +
        "============================\n" +
        "\n" +
        "Le jeu de dames est un jeu de stratégie classique qui oppose deux joueurs. Voici les règles principales du jeu de dames international (100 cases). Certaines règles s'appliquent également au jeu de dames anglais (64 cases) :\n" +
        "\n" +
        "1. **But du jeu** :\n" +
        "   - Immobiliser ou capturer toutes les pièces de l'adversaire.\n" +
        "\n" +
        "2. **Le plateau** :\n" +
        "   - **Dames internationales** : Plateau de 10x10 cases (100 cases).\n" +
        "   - **Dames anglaises** : Plateau de 8x8 cases (64 cases).\n" +
        "   - Les cases sombres sont les seules utilisables. Les pièces y sont placées au début du jeu.\n" +
        "\n" +
        "3. **Les pièces** :\n" +
        "   - **Pions** : Les pièces de base qui avancent d'une case en diagonale.\n" +
        "   - **Dames** : Obtenues lorsqu'un pion atteint la dernière rangée de l'adversaire. Elles ont plus de liberté de mouvement (diagonales longues dans toutes les directions).\n" +
        "\n" +
        "4. **Placement initial** :\n" +
        "   - Chaque joueur dispose de 20 pions (12 en dames anglaises), placés sur les cases sombres des 4 premières rangées de leur côté.\n" +
        "\n" +
        "5. **Déroulement du jeu** :\n" +
        "   - **Déplacements** :\n" +
        "     - Pions : Avancent en diagonale d'une case vers l'avant.\n" +
        "     - Dames : Peuvent se déplacer en diagonale de plusieurs cases, dans toutes les directions (avant et arrière), si le chemin est libre.\n" +
        "   - **Captures** :\n" +
        "     - Un pion ou une dame peut \"sauter\" par-dessus une pièce adverse et atterrir sur une case libre derrière pour capturer cette pièce.\n" +
        "     - **Obligation de capture** : Si un joueur peut capturer, il doit le faire.\n" +
        "     - Si plusieurs captures sont possibles, le joueur peut choisir son chemin, mais doit capturer le maximum de pièces.\n" +
        "     - Dames : Capturent de la même façon que les pions, mais peuvent sauter à distance sur une case libre.\n" +
        "\n" +
        "6. **Promotion en dame** :\n" +
        "   - Un pion atteint la dernière rangée adverse est promu en dame. On l'identifie souvent en empilant une autre pièce dessus.\n" +
        "\n" +
        "7. **Fin de la partie** :\n" +
        "   - **Victoire** : Un joueur capture ou bloque toutes les pièces adverses.\n" +
        "   - **Nul** : Si aucun joueur ne peut gagner (par exemple : trop peu de pièces pour capturer ou immobiliser l'autre joueur).\n" +
        "\n" +
        "============================\n" +
        " Bonne chance et amusez-vous !\n" +
        "============================\n");


        System.out.print("As-tu bien compris les règles ? (N/y) : ");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        System.out.println();
        return reponse;
    }
}
