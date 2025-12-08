public class Legume {
    private double poids;
    private static int cpt = 0;
    protected int id;

    public Legume(double poids){
        this.poids = poids;
        id = cpt++;
    }

    public String toString(){
        return "Le légume " + id + ", pèse " + poids + "kg";
    }

    public double evaluer(double prixParKilo){
        return prix*PrixParKilo;
    }   
}