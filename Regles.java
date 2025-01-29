import java.util.Scanner;

public class Regles {

    public static String changementDame(String[][] plateau, int colonnea, int colonneo, int lignea, int ligneo, int i) {
        if (i % 2 == 0) {
            if (plateau[lignea][colonnea] == "_") {
                if (lignea == 1) {
                    plateau[lignea][colonnea] = "\u001B[34mD\u001B[0m";
                }
            }
        } else {
            if (plateau[lignea][colonnea] == "_") {
                if (lignea == 10) {
                    plateau[lignea][colonnea] = "\u001B[31mD\u001B[0m";
                }
            }
        }
        return plateau[lignea][colonnea];
    }

    public static void mouvementDame(String[][] plateau, int ligneo, int colonneo, int i, boolean droit) {

        boolean droitCapture = false;
        boolean boucle = true;
        Scanner scanner = new Scanner(System.in);

        while (boucle) {
        
            System.out.print("Entre les coordonnées d'arriver de ton pion : ");
            String arrivé = scanner.nextLine();
            int lignea = arrivé.charAt(1) - '1';
            int colonnea = arrivé.charAt(0) - '?';

            if (arrivé.length() > 2) {
                lignea = 9;
            }

            for (int x = 0; x < 10-lignea; x++){

                if (i % 2 != 0) { //fix
                    if (plateau[ligneo + x][colonneo + x].equals("\u001B[34mW\u001B[0m" ) || plateau[ligneo + x][colonneo + x].equals("\u001B[34mD\u001B[0m" )  && plateau[ligneo + (x+1)][colonneo + (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo + x][colonneo - x].equals("\u001B[34mW\u001B[0m") || plateau[ligneo + x][colonneo - x].equals("\u001B[34mD\u001B[0m" ) &&  plateau[ligneo + (x+1)][colonneo - (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo - x][colonneo + x].equals("\u001B[34mW\u001B[0m") || plateau[ligneo - x][colonneo + x].equals("\u001B[34mD\u001B[0m" ) &&  plateau[ligneo - (x+1)][colonneo + (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo - x][colonneo - x].equals("\u001B[34mW\u001B[0m") || plateau[ligneo - x][colonneo - x].equals("\u001B[34mD\u001B[0m" ) &&  plateau[ligneo - (x+1)][colonneo - (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
    
                } else {

                    if (plateau[ligneo + x][colonneo + x].equals("\u001B[31mB\u001B[0m" ) || plateau[ligneo + x][colonneo + x].equals("\u001B[31mD\u001B[0m" )  && plateau[ligneo + (x+1)][colonneo + (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo + x][colonneo - x].equals("\u001B[31mB\u001B[0m") || plateau[ligneo + x][colonneo - x].equals("\u001B[31mD\u001B[0m" ) &&  plateau[ligneo + (x+1)][colonneo - (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo - x][colonneo + x].equals("\u001B[31mB\u001B[0m") || plateau[ligneo - x][colonneo + x].equals("\u001B[31mD\u001B[0m" ) &&  plateau[ligneo - (x+1)][colonneo + (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo - x][colonneo - x].equals("\u001B[31mB\u001B[0m") || plateau[ligneo - x][colonneo - x].equals("\u001B[31mD\u001B[0m" ) &&  plateau[ligneo - (x+1)][colonneo - (x+1)].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer un pion adverse !\u001B[0m");
                        droitCapture = true;
                    }
                }
            }

            if (droit && droitCapture) {

                plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                plateau[ligneo][colonneo] = "_";
                if (colonnea > colonneo && lignea < ligneo) {
                    plateau[lignea + 1][colonnea - 1] = "_";//fix
                    boucle = false;
                        
                } else if (colonnea < colonneo && lignea < ligneo) {
                    plateau[lignea + 1][colonnea + 1] = "_";//fix
                    boucle = false;
                        
                } else if (colonnea > colonneo && lignea > ligneo) {
                    plateau[lignea - 1][colonnea - 1] = "_";//fix
                    boucle = false;

                } else if (colonnea < colonneo && lignea > ligneo) {
                    plateau[lignea - 1][colonnea + 1] = "_";//fix
                    boucle = false;

                } else {
                    System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m");
                }
            } else if (droit && !droitCapture) {
                for (int x = 0; x < 10-lignea; x++) {
                    if (lignea == ligneo + x) {

                        if (colonnea == colonneo - x) {
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        } 
                        if (colonnea == colonneo + x) {
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        }
                        System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m"); 
                    } else if (lignea == ligneo - x) {

                        if (colonnea == colonneo - x) {
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        } 
                        if (colonnea == colonneo + x) {
                            plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                            plateau[ligneo][colonneo] = "_";
                            boucle = false;
                        }
                        System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m"); 
                    }
                }
            }
        }
    }
    

    public static void mouvement(String[][] plateau, int i) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;
        boolean droit = false;
        boolean droitCapture = false;
        
        //alterner entre les blancs et les noires 
        if (i % 2 == 0) {
            System.out.println("C'est au tour des Blancs de jouer ");
                
        } else {
            System.out.println("C'est au tour des Noirs de jouer");
        }

        while (boucle) {
            
            // Demander à l'utilisateur d'entrer les coordonnées du pion
            System.out.print("Entre les coordonnées du pion que tu veux déplacer : ");
            String origine = scanner.nextLine();
            int ligneo = origine.charAt(1) - '1';
            int colonneo = origine.charAt(0) - '?';

            if (origine.length() > 2) {
                ligneo = 9;
            }

            //Avertissements concernant le tour d'un pion
            if (i % 2 != 0) { 
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
            
            if (plateau[ligneo][colonneo] == "\u001B[34mD\u001B[0m" || plateau[ligneo][colonneo] == "\u001B[34mD\u001B[0m" ) {
                mouvementDame(plateau, ligneo, colonneo, i, droit);
            } else {

                //Donne l'indication et l'autorisation de Capturer. //erreur d'indexation instorer des limites
                if (i % 2 != 0) { 
                    if (plateau[ligneo + 1][colonneo + 1].equals("\u001B[34mW\u001B[0m" ) && plateau[ligneo + 2][colonneo + 2].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer le pion W !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo + 1][colonneo - 1].equals("\u001B[34mW\u001B[0m") &&  plateau[ligneo + 2][colonneo - 2].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer le pion W !\u001B[0m");
                        droitCapture = true;
                    }

                } else {
                    if (plateau[ligneo - 1][colonneo + 1].equals("\u001B[31mB\u001B[0m" ) && plateau[ligneo - 2][colonneo + 2].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer le pion B !\u001B[0m");
                        droitCapture = true;
                    }
                    if (plateau[ligneo - 1][colonneo - 1].equals("\u001B[31mB\u001B[0m") &&  plateau[ligneo - 2][colonneo - 2].equals("_")) {
                        System.out.println("\u001B[31mTu peux capturer le pion B !\u001B[0m");
                        droitCapture = true;
                    }
                }
                
                
                //Gestion de l'arrivé
                if (plateau[ligneo][colonneo].equals("_")) {
                    System.out.println("\u001B[31mAttention : Il n'y a pas de pion sur cette case !!\u001B[0m");
        
                } else if(droit == true && !droitCapture) {
                        
                    while (boucle) {

                        System.out.print("Entre les coordonnées d'arriver de ton pion : ");
                        String arrivé = scanner.nextLine();
                        int lignea = arrivé.charAt(1) - '1';
                        int colonnea = arrivé.charAt(0) - '?';

                        if (arrivé.length() > 2) {
                            lignea = 9;
                        }
                        
                        //Gestion des cas speciaux
                        if (plateau[lignea][colonnea] != "_") { 
                            System.out.println("\u001B[31mAttention : un pion est déja sur cette case !!\u001B[0m");
                        } else if (i % 2 == 0) {
                            if (lignea == ligneo - 1  && colonnea == colonneo + 1 || lignea == ligneo - 1 && colonnea == colonneo - 1 ){ //permet d'autoriser le déplacement en diagonal pour "W"
                                // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                                if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[34mD\u001B[0m") {

                                    plateau[lignea][colonnea] = "\u001B[34mD\u001B[0m";
                                    plateau[ligneo][colonneo] = "_";
                                    boucle = false;
    
                                } else if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[31mD\u001B[0m") {
    
                                    plateau[lignea][colonnea] = "\u001B[31mD\u001B[0m";
                                    plateau[ligneo][colonneo] = "_";
                                    boucle = false;
    
                                } else {
                                    plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                                    plateau[ligneo][colonneo] = "_";
                                    boucle = false;
                                }
                            } else {
                                System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m");
                            }
                            
                        } else if (lignea == ligneo + 1  && colonnea == colonneo + 1 || lignea == ligneo + 1  && colonnea == colonneo - 1 ){ //permet d'autoriser le déplacement en diagonal pour "B"
                            // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                            if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[34mD\u001B[0m") {

                                plateau[lignea][colonnea] = "\u001B[34mD\u001B[0m";
                                plateau[ligneo][colonneo] = "_";
                                boucle = false;

                            } else if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[31mD\u001B[0m") {

                                plateau[lignea][colonnea] = "\u001B[31mD\u001B[0m";
                                plateau[ligneo][colonneo] = "_";
                                boucle = false;

                            } else {
                                plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                                plateau[ligneo][colonneo] = "_";
                                boucle = false;
                            }

                        } else {
                            System.out.println("\u001B[31mAttention : ce déplacement n'est pas conforme aux règles !!\u001B[0m");
                        }
                        
                    }
                //Gestion de la capture et des cas speciaux
                } else if ( droit && droitCapture ){
                    while (boucle) {
                        System.out.print("Entre les coordonnées d'arriver de ton pion : ");
                        String arrivé = scanner.nextLine();
                        int lignea = arrivé.charAt(1) - '1';
                        int colonnea = arrivé.charAt(0) - '?';

                        if (arrivé.length() > 2) {
                            lignea = 9;
                        }
        
                        if (i % 2 == 0) {
                            if (lignea == ligneo - 2  && colonnea == colonneo + 2 || lignea == ligneo - 2 && colonnea == colonneo - 2 ){ //permet d'autoriser le déplacement en diagonal pour "W"
                                // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                                if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[34mD\u001B[0m") {

                                    plateau[lignea][colonnea] = "\u001B[34mD\u001B[0m";
                                    plateau[ligneo][colonneo] = "_";
                                    if (colonnea > colonneo) {
                                        plateau[ligneo - 1][colonneo + 1] = "_";
                                        System.out.println("Bravo");
                                    } else if (colonnea < colonneo) {
                                        plateau[ligneo - 1][colonneo - 1] = "_";
                                        System.out.println("Bravo");
                                    }
                                    
    
                                } else if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[31mD\u001B[0m") {
    
                                    plateau[lignea][colonnea] = "\u001B[31mD\u001B[0m";
                                    plateau[ligneo][colonneo] = "_";
                                    if (colonnea > colonneo) {
                                        plateau[ligneo - 1][colonneo + 1] = "_";
                                        System.out.println("Bravo");
                                    } else if (colonnea < colonneo) {
                                        plateau[ligneo - 1][colonneo - 1] = "_";
                                        System.out.println("Bravo");
                                    }
    
                                } else {
                                    plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                                    plateau[ligneo][colonneo] = "_";
                                    if (colonnea > colonneo) {
                                        plateau[ligneo - 1][colonneo + 1] = "_";
                                        System.out.println("Bravo");
                                    } else if (colonnea < colonneo) {
                                        plateau[ligneo - 1][colonneo - 1] = "_";
                                        System.out.println("Bravo");
                                    }
                                }
                                boucle = false;
                            } else {
                                System.out.println("\u001B[31mAttention : Tu dois manger le pion B !!\u001B[0m");
                            }
                            
                        } else if (lignea == ligneo + 2  && colonnea == colonneo + 2 || lignea == ligneo + 2  && colonnea == colonneo - 2 ){ //permet d'autoriser le déplacement en diagonal pour "B"
                            // ajouter le pion a sa nouvelle place et le supprimer a l'ancienne
                            if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[34mD\u001B[0m") {

                                plateau[lignea][colonnea] = "\u001B[34mD\u001B[0m";
                                plateau[ligneo][colonneo] = "_";
                                if (colonnea > colonneo) {
                                    plateau[ligneo + 1][colonneo + 1] = "_";
                                    System.out.println("Bravo");
                                } else if (colonnea < colonneo) {
                                    plateau[ligneo + 1][colonneo - 1] = "_";
                                    System.out.println("Bravo");
                                }
                                

                            } else if (changementDame(plateau, colonnea, colonneo, lignea, ligneo, i) == "\u001B[31mD\u001B[0m") {

                                plateau[lignea][colonnea] = "\u001B[31mD\u001B[0m";
                                plateau[ligneo][colonneo] = "_";
                                if (colonnea > colonneo) {
                                    plateau[ligneo + 1][colonneo + 1] = "_";
                                    System.out.println("Bravo");
                                } else if (colonnea < colonneo) {
                                    plateau[ligneo + 1][colonneo - 1] = "_";
                                    System.out.println("Bravo");
                                }

                            } else {
                                plateau[lignea][colonnea] = plateau[ligneo][colonneo];
                                plateau[ligneo][colonneo] = "_";
                                if (colonnea > colonneo) {
                                    plateau[ligneo + 1][colonneo + 1] = "_";
                                    System.out.println("Bravo");
                                } else if (colonnea < colonneo) {
                                    plateau[ligneo + 1][colonneo - 1] = "_";
                                    System.out.println("Bravo");
                                }
                            }
                            boucle = false;
                        } else {
                            System.out.println("\u001B[31mAttention : Tu dois manger le pion W !! \u001B[0m");
                        } 
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
        "Le jeu de dames est un jeu de stratégie classique qui oppose deux joueurs. Voici les règles principales du jeu de dames anglais (64 cases) :\n" +
        "\n" +
        "1. **But du jeu** :\n" +
        "   - Immobiliser ou capturer toutes les pièces de l'adversaire.\n" +
        "\n" +
        "2. **Le plateau** :\n" +
        "   - **Dames anglaises** : Plateau de 8x8 cases (64 cases).\n" +
        "   - Les cases sombres sont les seules utilisables. Les pièces y sont placées au début du jeu.\n" +
        "\n" +
        "3. **Les pièces** :\n" +
        "   - **Pions** : Les pièces de base qui avancent d'une case en diagonale.\n" +
        "   - **Dames** : Obtenues lorsqu'un pion atteint la dernière rangée de l'adversaire. Elles ont plus de liberté de mouvement (diagonales longues dans toutes les directions).\n" +
        "\n" +
        "4. **Placement initial** :\n" +
        "   - Chaque joueur dispose de 12 pions, placés sur les cases sombres des  premières rangées de leur côté.\n" +
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
