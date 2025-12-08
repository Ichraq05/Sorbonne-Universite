public class Test {
    public static void main(String[] args) {
        Marchandise m1 = new Marchandise(50.0);
        Marchandise m2 = new Marchandise(30.0);

        Date date1 = new Date(19, 1, 2025);
        System.out.println("Date1: " + date1);

        Perissable perissable1 = new Perissable(40.0, date1);
        System.out.println(perissable1);

        NonPerissable nonPerissable1 = new NonPerissable(60.0, "voiture");
        System.out.println(nonPerissable1);

        Navire navire = new Navire("France", 500.0);

        navire.ajouterMarchandise(m1);
        navire.ajouterMarchandise(m2);

        System.out.println("Poids total de la marchandise à bord du navire : " + navire.calculerPoidsCharge());
    }
}
