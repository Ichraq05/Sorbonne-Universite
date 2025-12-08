package Ex15;
public class TestComplexe {
    public static void main(String[] args) {

        Complexe iCarre = new Complexe(0, 1).multiplication(new Complexe(0, 1));
        Complexe resultat = new Complexe(1, 1).multiplication(new Complexe(2, 2));

        System.out.println("i^2 = " + iCarre);
        System.out.println("(1 + i) * (2 + 2i) = " + resultat);

        //Q.3 :
        Complexe complexe1 = new Complexe(1, 2);
        Complexe complexe2 = new Complexe(-2, 0);
        Complexe complexe3 = new Complexe(3, -4);

        System.out.println("\nComplexe 1 : " + complexe1);
        System.out.println("Complexe 2 : " + complexe2);
        System.out.println("Complexe 3 : " + complexe3);

        // Tester s'ils sont réels ou pas
        System.out.println("\nComplexe 1 est réel : " + complexe1.estReel());
        System.out.println("Complexe 2 est réel : " + complexe2.estReel());
        System.out.println("Complexe 3 est réel : " + complexe3.estReel());

        Complexe somme = complexe1.addition(complexe2);
        Complexe produit = complexe2.multiplication(complexe3);

        System.out.println("\nSomme de Comlexe 1 et Comlexe 2 : " + somme);
        System.out.println("Produit de Comlexe 2 et Comlexe 3 : " + produit);
    }
}

