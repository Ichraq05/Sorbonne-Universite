public class Guitare extends Instrument{
    private String type;

    public Guitare(String type, int prix, double poids){
        super(prix,poids);
        this.type = type;
    }

    public String toString(){
        return "Guitare --> type : " + type + ", " + super.toString();
    }

    public void jouer(){
        System.out.println("La guitarre " + type + " joue");
    }
    
}