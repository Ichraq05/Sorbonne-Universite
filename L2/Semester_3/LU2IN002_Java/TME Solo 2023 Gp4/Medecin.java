public class Medecin extends NonCombattant{
    private int soigne;

    public Medecin(String prenom,int intelligence){
        super(prenom, intelligence);
    }

    public void action(){
        soigne = super.getIntelligence()/2;
        System.out.println(super.toString() + ", classe : medecin" +" , soigne " + soigne + " heros");
    }

    public String toString(){
        return super.toString() + ", classe : medecin";
    }
}