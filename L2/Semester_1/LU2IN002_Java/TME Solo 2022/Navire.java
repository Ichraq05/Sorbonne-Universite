public class Navire {
    private Marchandise []tab;
    private static int cpt = 0;
    private int id;
    private double charge;
    private double capacite;
    private String pays;    
    private int nb_mar;

    public Navire(String pays, double capacite){
        this.pays = pays;
        this.capacite = capacite;
        this.tab = new Marchandise[10];
        this.charge = 0;
        this.id = cpt++;
        this.nb_mar = 0;
    }

    public Navire (double capacite){
        this("None", capacite);
    }

    public double calculerPoidsCharge(){
        double res = 0;
        for(Marchandise x : tab){
            if (x != null) {
                res += x.getPoids();
            }
        }
        return res;
    }

    public void ajouterMarchandise(Marchandise m){
        if (nb_mar < tab.length && (calculerPoidsCharge() + m.getPoids()) <= capacite){
            tab[nb_mar] = m;
            nb_mar++;
            System.out.println("La marchandise" + m.getId() + "a été ajouté au navire");
        }
        else if (nb_mar >= tab.length){
            System.out.println("La limite est atteinte, il n'y a plus de place pour ajouter de la marchandise.");
        }
        else{
            System.out.println("Le navire est saturé.");
        }
    }

    
}