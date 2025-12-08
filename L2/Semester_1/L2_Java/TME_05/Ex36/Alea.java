public class Alea {
    //Q.3. Constructeur privé pour empêcher l'instanciation
    private Alea(){
            
    }

    public static char lettre(){
        int x = (int)(Math.random()*26);
        return (char)('a' + x);
    }

    public static String chaine(){
        String res = "";
        for (int i = 0; i < 10; i++){
            res += Alea.lettre();
        }
        return res;
    }

    /*Q.2. Car elles ne dépendent pas des instances spécifiques de la classe Alea. 
    En d'autres termes, elles n'ont pas besoin d'accéder aux membres (variables d'instance) d'une instance particulière de la classe Alea,
    pour fonctionner correctement.*/

    public static void main(String[] args) {
        System.out.println("La chaine de 10 caracères aléatoire :\n" + Alea.chaine());
    }
}