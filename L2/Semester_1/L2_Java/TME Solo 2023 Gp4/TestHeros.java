public class TestHeros {
    public static void main(String[] args) {
        Guilde g1 = new Guilde(10);

        Guerrier guer1 = new Guerrier("William", 8, "epee");
        Guerrier guer2 = new Guerrier("Astrid", 7, "marteau");

        g1.ajouterHeros(guer1);
        g1.ajouterHeros(guer2);

        System.out.println(g1.toString());

        g1.actionGuilde();

        System.out.println();

        Medecin m1 = new Medecin("Xun", 9);
        g1.ajouterHeros(m1);

        System.out.println(g1.toString());

        g1.actionGuilde();
    }
   
}