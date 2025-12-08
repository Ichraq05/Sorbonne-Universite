package Ex14;
public class TestCoureur3 {
    public static void main(String[] args) {
        Coureur coureur1 = new Coureur(1);
        Coureur coureur2 = new Coureur(2);
        Coureur coureur3 = new Coureur(3);
        
        // Coureur 1 possède initialement le témoin
        coureur1.courir();
        coureur1.setPossedeTemoin(true);
        
        // Afficher l'état initial des coureurs
        System.out.println("État initial :\n");
        System.out.println(coureur1);
        System.out.println(coureur2);
        System.out.println(coureur3);
        
        // Coureur 1 passe le témoin à coureur 2
        coureur1.passeTemoin(coureur2);
        
        // Afficher l'état après le passage du témoin
        System.out.println("État après le passage du témoin :\n");
        System.out.println(coureur1);
        System.out.println(coureur2);
        System.out.println(coureur3);
        
        // Coureur 2 tente de passer le témoin, mais il ne l'a pas
        coureur1.passeTemoin(coureur2);

        coureur2.courir();
        coureur3.courir();
    }
}


