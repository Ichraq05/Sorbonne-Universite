public class Piano extends Instrument {
    private int touches;
    
    public Piano(int touches, int prix, double poids){
        super(prix, poids);
        this.touches = touches;
    }

    public String toString(){
        return "Piano --> " + touches + " touches, " + super.toString();
    }

    public void jouer(){
        System.out.println("Le piano joue");
    }
}