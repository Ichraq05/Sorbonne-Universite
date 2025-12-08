package Ex14;
public class TestCoureur2 {
    //class TestCoureur {}
    public static void main(String[] args) {
        Coureur c1 = new Coureur();

        //Acces aux valeurs des variables d'instances grace aux accesseurs
        int numDossard = c1.getNumDossard();
        double tempsAu100 = c1.getTempsAu100();
        boolean possedeTemoin = c1.getPossedeTemoin();

        System.out.println("\nNuméro de dossard : " + numDossard);
        System.out.println("Temps au 100 mètres : " + String.format("%.3f secondes", tempsAu100));
        System.out.println("Possède un témoin : " + possedeTemoin);
        
        // Avant mutateur toString()
        System.out.println(c1.toString());
        
        //Changer la valeur de possedeTemoin grace au mutateur
        c1.setPossedeTemoin(true);
        System.out.println("\nPossède un témoin apres modif : " + c1.getPossedeTemoin());

        // Apres mutateur
        System.out.println(c1.toString());
    }
}
