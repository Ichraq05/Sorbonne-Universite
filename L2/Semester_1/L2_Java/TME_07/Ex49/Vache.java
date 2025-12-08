public class Vache extends APattes{
    private double lait;

    public Vache(String nom, int age){
        super(nom,age,4);
        this.lait= Math.random()*25 +5;
    }

    public Vache(String nom){
        super(nom,4);
        this.lait= Math.random()*25 +5;
    }

    public void crier(){
        System.out.println("La vache meugle");
    }

    public String toString(){
        return super.toString() + ", est une vache qui produit " + this.lait + " litres de lait";
    }
}