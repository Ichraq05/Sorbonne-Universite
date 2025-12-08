public class Pile {

    private Assiette []tab;
    private int nbA;

    public Pile(int tailleMax){
        this.tab = new Assiette[tailleMax];
        this.nbA = 0;
    }

    boolean estVide(){
        if (nbA == 0){
            return true;
        }
        return false;
    }

    boolean estPleine(){
        if (nbA == tab.length){
            return true;
        }
        return false;
    }

    void empiler(Assiette a){
        if (!(this.estPleine())){
            tab[nbA] = a;
            nbA ++;
        }
        else {
            System.out.println("La pile est pleine, impossible d'empiler.");
        }
    }

    Assiette depiler(){
        if(!(this.estVide())){
            nbA --;
            return tab[nbA];
        }
        else {
            System.out.println("La pile est vide, impossible de dépiler.");
            return null;
        }
    }

    public String toString() {
        if (nbA == 0) {
            return "Vide\n";
        }
        String contenu = "";
        for (int i = 0; i < nbA; i++) {
            contenu += "\\_____/ \n";
        }
        return contenu;
    }
}