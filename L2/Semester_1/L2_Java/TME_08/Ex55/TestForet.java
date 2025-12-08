import java.util.ArrayList;

public class TestForet {
    public static void main(String[] args) {
        Foret foret = new Foret(10);

        for (int i = 0; i < 10; i++){
            double prob = Math.random()*100;
            if(prob < 30){
                Champignon pin = new Champignon("Pin");
                foret.placer(pin);
            }
            else{
                Champignon cepe = new Champignon("Cepe");
                foret.placer(cepe);
            }

        }

        for (int i = 0; i < 4; i++){
            ChampignonToxique amanite = new ChampignonToxique("Amanites");
            foret.placer(amanite);
        }

        System.out.println(foret.toString());

        Panier panier = new Panier(8.0);
        foret.ramasser(panier);

        System.out.println("\n" + panier.toString());
    }
    
}