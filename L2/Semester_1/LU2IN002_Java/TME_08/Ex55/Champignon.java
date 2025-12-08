public class Champignon implements Ramassable{
    private String nom;
    private double poids;

    public Champignon(String nom){
        this.nom = nom;
        this.poids = Math.random()*3;
    }

    public double getPoids(){
        return poids;
    }

    public String toString(){
        return String.format("%s %.2fkg",nom,poids);
    }
}