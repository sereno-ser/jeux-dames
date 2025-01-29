public class Piece {
    public static void piece(String[][] plateau) {
        // Placer des pièces
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                // Placer les pièces uniquement sur les cases noires
                if ((i + j) % 2 == 0 && j != 0 && j != 1){  // Si la case est noire
                    if (i < 4) {
                        plateau[i][j] = "\u001B[31mB\u001B[0m";  // Placer une pièce noire sur les 3 premières lignes
                    } else if (i > 5) {
                        plateau[i][j] = "\u001B[34mW\u001B[0m";  // Placer une pièce blanche sur les 3 dernières lignes
                    }
                } 
            }
        }
    }
}
