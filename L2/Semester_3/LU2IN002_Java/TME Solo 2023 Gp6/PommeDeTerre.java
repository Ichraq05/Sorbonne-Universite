public class PommeDeTerre extends Tubercule{
    public PommeDeTerre(double poids, char infection){
        super(poids,infection);
    }

    public String toString(){
        return "Pomme de terrre | " + super.toString();
    }
    
}