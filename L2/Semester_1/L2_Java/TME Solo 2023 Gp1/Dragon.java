public class Dragon extends EtreVivant{
    private boolean estGeant;

    public Dragon(boolean estGeant){
        super(estGeant ? 60 : 40);

    }

    public int getDegats(){
        return pointDeVie/3;
    }
    
}