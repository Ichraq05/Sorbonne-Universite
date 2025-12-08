import java.util.ArrayList;

public class Panier extends ArrayList<Ramassable>{
    private double poidsMax;

    public Panier(double poidsMax){
        this.poidsMax = poidsMax;
    }

    public double getPoids(){
        double poidsTotal = 0.0;
        for (Ramassable ramassable : this) {
            poidsTotal += ramassable.getPoids();
        }
        return poidsTotal;
    }

    @Override
    public boolean add(Ramassable ramassable){
        if(getPoids() + ramassable.getPoids() <= poidsMax){
            super.add(ramassable);
            System.out.println(ramassable + " est ajouté au panier");
            return true;
        }
        else{
            System.out.println(ramassable + " n'est pas ajouté au panier");
            return false;
        }
    }

    public int compterToxiques(){
        int nbToxique = 0;
        for (Ramassable ramassable : this){
            if(ramassable instanceof Toxique && ((Toxique)ramassable).estToxique()){
                nbToxique ++;
            }
        }
        return nbToxique;
    }

    public String toString() {
        int nombreObjets = this.size();
        int nombreToxiques = compterToxiques();
        double poidsTotal = getPoids();

        return String.format("Panier contenant %d objets, dont %d toxiques (%.2fkg sur %.1fkg)", 
        nombreObjets, nombreToxiques, poidsTotal, poidsMax);
    }

}