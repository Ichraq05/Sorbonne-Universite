public class Trio {
    private Personne []tab;
    private static int cpt = 0;
    private int numero;

    public Trio(){
        cpt ++;
        numero = cpt;

        tab = new Personne[3];
        for (int i = 0; i < 3; i++){
            tab[i] = new Personne();
        }
    }

    public static int getCpt(){
        return cpt;
    }

    public String toString(){
        return "Trio " + numero + " : " + tab[0].toString() + " " + tab[1].toString() + " " + tab[2].toString();
    }
    
}