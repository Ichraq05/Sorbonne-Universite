package Ex14;
public class TestCoureur {
        //class TestCoureur {}
    public static void main(String[] args) {
    
        //Q.1, Q.2, Q.3
        Coureur c1 = new Coureur();
        Coureur c2 = new Coureur();
        Coureur c3 = new Coureur();
        Coureur c4 = new Coureur();
    
        //Methode avec la fonction affiche tout en bas
        c1.afficher();
        c2.afficher();
        c3.afficher();
        c4.afficher();
    
        //Q.6 :
        double temps_Total = c1.getTempsAu100() + c2.getTempsAu100() + c3.getTempsAu100() + c4.getTempsAu100();
    
        System.out.println(String.format("\nTemps total au 400m des 4 coureurs : %.2f", temps_Total));
    }
}
