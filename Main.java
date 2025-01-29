public class Main {
    
    public static void main(String[] args) {

        String reponse = Acceuil.acceuil(args);
        boolean check = true;

        // commencer a jouer
        if (reponse.equals("y")) {
            
        } else {
            while (true) {   
                String autorisation = Regles.regle(args);
                if (autorisation.equals("y")) {
                    break;
                } 
            }
        }

        // Chargement du jeu
        Chargement.attendre(1000);

        System.out.println("Préparation du Jeux..."); //chargement
        System.out.println();

        Chargement.attendre(2000);

        //Créer le plateau
        String[][] plateau = new String[15][15];
            
        // Initialiser le plateau vierge avec "_"
        Plateau.plateauVierge(plateau);
            
        // Placer les pièces
        Piece.piece(plateau);
            
        // Afficher le plateau
        Plateau.afficherPlateau(plateau);
            
        //Alterner les tours
        for (int i = 1; i >= 0; i++) { 
                
            Regles.mouvement(plateau, i);
            Plateau.afficherPlateau(plateau);
            check = Plateau.check(plateau);
            if (!check) {
                break;
            }
        }
    }
}
