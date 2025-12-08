public class TestOrchestre {
    public static void main(String[] args) {
        Orchestre q1 = new Orchestre(2);

        Guitare guitare1 = new Guitare("classique", 300, 4.5);
        System.out.println(guitare1.toString());
        guitare1.jouer();

        Guitare guitare2 = new Guitare("éléctrique", 225, 5.2);
        System.out.println("\n" + guitare2.toString());
        guitare2.jouer();

        Piano piano1 = new Piano(88, 3000, 325.4);
        System.out.println("\n" + piano1.toString());
        piano1.jouer();

        q1.ajouterInstrument(guitare1);
        q1.ajouterInstrument(piano1);
        q1.ajouterInstrument(guitare2);

        System.out.println();
        q1.jouer();
    }
    
}