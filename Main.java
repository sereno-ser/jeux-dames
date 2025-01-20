public class Main {
    
    public static void main(String[] args) {
        
        String[][] plateau = new String[8][8];

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
