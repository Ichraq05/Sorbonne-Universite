public class TestAlea {
    public static void main(String[] args) {
        //Alea a = new Alea(); --> Ca ne marche pas car il est affiché que le constructeur Alea n'est pas visible (car private).
         System.out.println("La chaine de 10 caracères aléatoire :\n" + Alea.chaine());
    }
}

