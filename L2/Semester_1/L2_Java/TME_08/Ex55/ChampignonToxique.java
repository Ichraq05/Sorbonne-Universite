public class ChampignonToxique implements Toxique,Ramassable {
    private String nom;
    private double poids;

    public ChampignonToxique(String nom){
        this.nom = nom;
        this.poids = Math.random()*3;
    }

    public double getPoids(){
        return poids;
    }

    public boolean estToxique(){
        return true;
    }

    public String toString(){
        return String.format("%s %.2fkg",nom,poids);
    }
}