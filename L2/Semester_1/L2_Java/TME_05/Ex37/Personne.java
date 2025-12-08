public class Personne {
    private String nom;
    private static int nbPersonnes;
    private static char lettre = 'A';

    public Personne(){
        this.nom = "Individu" + (char)('A' + nbPersonnes); //Si on veut les nombres et non les lettres --> this.nom = "Individu" + nbPersonnes;
        nbPersonnes++;
    }

    public static int getNbPersonnes(){
        return nbPersonnes;
    }

    public String toString(){
        return this.nom;
    }
    
}