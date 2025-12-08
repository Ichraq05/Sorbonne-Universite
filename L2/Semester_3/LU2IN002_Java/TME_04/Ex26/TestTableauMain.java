public class TestTableauMain{
    public static void main(String[] args) {
        //Récupère le nombre d'argument
        int nb_args = args.length;

        System.out.println("Il y a " + nb_args + " argument(s)");

        int i = 0;
        for (String x : args){
            System.out.println("args[" + i + "] = " + x);
            i++;
        }
    }
}