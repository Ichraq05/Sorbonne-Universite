public class Sorcier extends EtreVivant{
    private int intelligence;

    public Sorcier(int pointDeVie, int intelligence){
        super(pointDeVie);
        this.intelligence = intelligence;
    }

    public int getDegats(){
        return pointDeVie - (intelligence + ((int)((Math.random()*4)+2)));
    }
    
}