public class Perissable extends Marchandise {
    private Date date;

    public Perissable(double poids, Date date){
        super(poids);
        this.date = date;
    }

    public String toString(){
        return super.toString() + " est perissable le " + date;
    }
    
}