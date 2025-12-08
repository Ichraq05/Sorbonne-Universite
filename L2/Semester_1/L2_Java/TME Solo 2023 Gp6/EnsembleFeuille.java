public class EnsembleFeuille extends Legume{
    private double degreGivre;

    public EnsembleFeuille(double poids, double degreGivre){
        super(poids);
        this.degreGivre = Math.random()*1;
    }

    public double evaluer(double prixParKilo){
        return (1-degreGivre)*poids*prixParKilo;
    }

    public String toString(){
        return super.toString() + ", degré Givre : " + (degreGivre*100);
    }
    
}