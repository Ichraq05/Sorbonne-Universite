public class EtreVivant {
    protected final int id;
    private int pointDeVie;
    private static int cpt = 0;

    public EtreVivant(int pointDeVie){
        this.pointDeVie = pointDeVie;
        cpt++;
        this.id = cpt;
    }

    public void subirDegats(int degats){
        pointDeVie = pointDeVie - degats;
    }

    public boolean estPasKO(){
        if (pointDeVie > 0){
            return true;
        }
        return false;
    }

    public int getDegats(){
        return degats;
    }

    public int getPointDeVie(){
        return pointDeVie;
    }

}