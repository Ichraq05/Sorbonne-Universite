public class Velo extends Vehicule{
    private int vitesse;
    
    public Velo(int vitesse, String marque){
        super(marque);
        this.vitesse = vitesse;
    }

    public String toString(){
        return "Velo " + super.toString() + " sans moteur, " + vitesse + " vitesses";
    }

    public void transporter(String depart, String arrivee){
        System.out.println("Le vélo " + super.id + " se déplace de " + depart + " à " + arrivee );
    }

}