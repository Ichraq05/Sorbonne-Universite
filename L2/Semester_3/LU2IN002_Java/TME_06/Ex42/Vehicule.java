public class Vehicule {
    private static int cpt = 0;
    protected int id;
    private String marque;
    protected double distance;

    public Vehicule(String marque){
        this.marque = marque;
        this.distance = 0.0;
        cpt++;
        id = cpt;
    }

    public static int getCpt(){
        return cpt;
    }

    public String toString(){
        return id + " de marque : " + marque;
    }

    public void rouler(double dist){
        distance += dist;
        System.out.println(this.toString() + " a roulé " + dist + " km" );
    }
}