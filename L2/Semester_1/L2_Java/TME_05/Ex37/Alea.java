public class Alea {
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

    public static void main(String[] args) {
        System.out.println("La chaine de 10 caracères aléatoire :\n" + Alea.chaine());
    }
}