public class Chargement {
    public static void attendre(int temps) {
        try {
            Thread.sleep(temps);
         } catch (InterruptedException var5) {
            System.out.println("Une interruption est survenue : " + var5.getMessage());
         }
    }
}
