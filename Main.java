public class Main {
    
    public static void main(String[] args) {
        // Créer un tableau plateau de 8x8
        String[][] plateau = new String[8][8];

        // Initialiser le plateau vierge
        Plateau.plateauVierge(plateau);

        // Placer les pièces
        Piece.piece(plateau);

        // Afficher le plateau
        Plateau.afficherPlateau(plateau);

        Regles.mouvement(plateau);
    }

}
