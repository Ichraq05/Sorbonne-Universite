public class TestProjet {
    public static void main(String[] args){
        System.out.println("Nombre de Personnes(s) : " + Personne.getNbPersonnes());

        Personne p1 = new Personne();
        Personne p2 = new Personne();
        System.out.println("Nouvel individu : " + p1.toString());
        System.out.println("Nouvel individu : " + p2.toString());

        System.out.println("\nNombre de Personnes(s) : " + Personne.getNbPersonnes());

        System.out.println("\nNombre de Trio(s) : " + Trio.getCpt());

        Trio t1 = new Trio();
        Trio t2 = new Trio();
        System.out.println(t1.toString());
        System.out.println(t2.toString());

        System.out.println("\nNombre de Trio(s) : " + Trio.getCpt());
        System.out.println("Nombre de Personne(s) : " + Personne.getNbPersonnes());

        System.out.println("\nNombre de ¨Projet(s) : " + Projet.getCpt());

        Projet pr1 = new Projet("P3X-774");
        Projet pr2 = new Projet();
        System.out.println(pr1.toString());
        System.out.println(pr2.toString());

        System.out.println("\nNombre de ¨Projet(s) : " + Projet.getCpt());
        System.out.println("Nombre de Trio(s) : " + Trio.getCpt());
        System.out.println("Nombre de Personne(s) : " + Personne.getNbPersonnes());
    }
}