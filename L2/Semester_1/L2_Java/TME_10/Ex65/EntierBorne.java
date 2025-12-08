public class EntierBorne {
    private static final int MIN = -100;
    private static final int MAX = 100;
    private int valeur;

    public EntierBorne(int valeur) throws HorsBornesException{
        if (valeur < MIN) {
            throw new HorsBornesException("Entier trop petit : " + valeur);
        }
        else if(valeur > MAX){
            throw new HorsBornesException("Entier trop grand : " + valeur);
        }
        else {
            this.valeur = valeur;
        }
    }

    public String toString(){
        return "La valeur est : " + valeur;
    }

    public EntierBorne somme(EntierBorne eb) throws HorsBornesException{
        return new EntierBorne(this.valeur + eb.valeur);
    }

    public EntierBorne divPar(EntierBorne eb) throws HorsBornesException, DivisionParZeroException{
        if (eb.valeur == 0){
            throw new DivisionParZeroException("Division par 0");
        }
        return new EntierBorne(this.valeur/eb.valeur);
    }
    
}