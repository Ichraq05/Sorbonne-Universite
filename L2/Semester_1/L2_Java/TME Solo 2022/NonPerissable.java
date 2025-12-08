public class NonPerissable extends Marchandise{
    private String type;

    public NonPerissable(double poids, String type){
        super(poids);
        this.type = type;
    }

    public String toString(){
        return super.toString() + " de type " + type;
    }
}