public class Camion extends AMoteur {
    private double volume;

    public Camion(int volume, double reservoire, String moteur){
        super(reservoire,moteur);
        this.volume = volume;
    }

    public String toString(){
        return "Camion " + super.toString() + ", volume : " + volume + " kg";
    }

    public void transporter(String materiau, int km){
        if(super.enPanne()){
            System.out.println("Le camion " + super.id + " n'a plus d'essence !");
        }

        else{
            super.distance += km;
            System.out.println("Le camion " + super.id + " a transporté des " + materiau + " sur " + km + " km");
        }
    }
}