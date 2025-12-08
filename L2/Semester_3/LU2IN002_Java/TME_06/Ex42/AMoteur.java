public class AMoteur extends Vehicule{
    private double reservoire;
    private double niv_essence;

    public AMoteur(double reservoire, String marque){
        super(marque);
        this.reservoire = reservoire;
        this.niv_essence = 0;
    }

    public String toString(){
        return super.toString();
    }
    
    public void approvisionner(double nbLitres){
        niv_essence += nbLitres;
        if (niv_essence > reservoire){
            niv_essence = reservoire;
        }
    }

    public boolean enPanne(){
        return niv_essence == 0;
    }
}