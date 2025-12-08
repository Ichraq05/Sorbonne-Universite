public class Potager {
    private Legume []tab;

    public Potager(int nb_max){
        this.tab = new Potager[nb_max];
    }

    public bool estPlein(int nb_max){
        if (tab.length >= nb_max){
            return true;
        }
        return false;
    }

    public ajouter(){}
    
}