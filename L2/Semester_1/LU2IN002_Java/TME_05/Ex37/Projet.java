public class Projet {
    private String nom;
    private Trio trio;
    private static int cpt = 0;

    public Projet(String n){
        this.nom = n;
        this.trio = new Trio();
        cpt ++;

    }

    public Projet(){
        this.nom = Alea.chaine();
        this.trio = new Trio();
        cpt++;
    }

    public static int getCpt(){
        return cpt;
    }

    public String toString(){
        return "Projet " + this.nom + " " + trio.toString();
    }
    
}