public class Marchandise{
    private int id;
    private double poids;

    public Marchandise(double poids){
    this.id = (int)(Math.random()*1000)+1;
    this.poids = poids;
    }

    public double getPoids(){
        return poids;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "La marchandise " + this.id + " de poids " + this.poids;
    }   
    
}