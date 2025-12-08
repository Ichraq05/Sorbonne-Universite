public class Tubercule extends Legume{
    private char infection;
    
    public Tubercule(double poids, char infection){
        super(poids);
        this.infection = (char)('G' + ((int)(Math.random)*5));
    }

    public double facteurInfection(char infection){
        return 1-0.14*(infection - 'G');
    }

    public String toString(){
        return super.toString() + ", infection = " + infection;
    }

    public double evaluer(double prixParKilo){
        return facteurInfection(infection) * poids * prixParKilo;
    }
}