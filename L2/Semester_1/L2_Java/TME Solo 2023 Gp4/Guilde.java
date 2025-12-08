public class Guilde {
    private Heros []tab;
    private int nb_heros;

    public Guilde(int taille_max){
        this.tab = new Heros[taille_max];
        this.nb_heros = 0;
    }

    public void ajouterHeros(Heros h){
        if (nb_heros < tab.length){
            tab[nb_heros] = h;
            nb_heros++;
        }
        else{
            System.out.println("La guilde est pleine !");
        }
    }

    public void actionGuilde(){
        for (Heros x : tab){
            if (x!= null){
                x.action();
            }
        }
    }

    public String toString(){
        String res = "La guilde est composé de :\n";
        for (Heros x : tab){
            if (x!=null){
                res+=x.toString() + "\n";
            }
        }
        return res;
    }

}