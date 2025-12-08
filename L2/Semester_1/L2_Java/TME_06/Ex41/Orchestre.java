public class Orchestre{
    private Instrument []intstruments;
    private int nb_instruments;

    public Orchestre(int max_instruments){
        this.intstruments = new Instrument[max_instruments];
        this.nb_instruments = 0;
    }

    public void ajouterInstrument(Instrument x){
        if (nb_instruments < intstruments.length){
            intstruments[nb_instruments] = x;
            nb_instruments++;
        }
        else{
            System.out.println("\nL'orquestre est complet. Impossible d'ajouter plus d'instruments");
        }
    }

    void jouer(){
        System.out.println("L'orchestre joue :");
        for (int i = 0; i < nb_instruments; i++){
            intstruments[i].jouer();
        }
    }
}