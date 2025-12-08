public class Instrument { //2e méthode, public abstract class Instrument
    private int prix;
    private double poids;

    public Instrument(int prix, double poids){
        this.prix = prix;
        this.poids = poids;
    }

    public String toString(){
        return "poids : "+ poids + " kg, prix : "+ prix + " eruos";
    }

    public void jouer(){
        System.out.println("L'instrument joue");
    }

    // public abstract jouer(); <-- 2e methode, déclarer comme abstraite pour que orchestre accède aux instruments (guitare, piano ...)
    
}