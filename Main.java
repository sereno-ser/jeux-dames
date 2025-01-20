public class Main {
    
    public static void main(String[] args) {

        String reponse = Acceuil.acceuil(args);

        if (reponse.equals("y")) {
            
        } else {
            while (true) {   
                String autorisation = Regles.regle(args);
                if (autorisation.equals("y")) {
                    break;
                } 
            }
        }

        try {
            Thread.sleep(1000); // Pause de 1 secondes
        } catch (InterruptedException e) {
            System.out.println("Une interruption est survenue : " + e.getMessage());
        }

        System.out.println("Préparation du Jeux..."); //chargement
        System.out.println();

        try {
            Thread.sleep(3000); // Pause de 3 secondes
        } catch (InterruptedException e) {
            System.out.println("Une interruption est survenue : " + e.getMessage());
        }

        String[][] plateau = new String[10][10];
            
        // Initialiser le plateau vierge avec "_"
        Plateau.plateauVierge(plateau);
            
        // Placer les pièces
        Piece.piece(plateau);
            
        // Afficher le plateau
        Plateau.afficherPlateau(plateau);
            
        for (int i = 1; i >= 0; i++) { //Alterner les tours
                
            Regles.mouvement(plateau, i);
            Plateau.afficherPlateau(plateau);
                
        }
    }
}
