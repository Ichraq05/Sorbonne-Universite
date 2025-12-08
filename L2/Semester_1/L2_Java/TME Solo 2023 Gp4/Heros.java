public abstract class Heros {
    protected final int id;
    protected String prenom;
    private static int cpt = 0;

    public Heros(String prenom){
        this.prenom = prenom;
        cpt++;
        this.id = cpt;
    }

    public abstract void action();

    public String toString(){return prenom;}
    
}