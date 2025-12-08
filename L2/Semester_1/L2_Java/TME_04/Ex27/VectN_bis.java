import java.util.Random;
import java.util.Arrays;

public class VectN_bis {

    private int []tab;

    private VectN_bis(int n){
        this.tab = new int[n];        
    }

    public VectN_bis(int n, int valMax){
        this(n);
        for (int i = 0; i < n; i++){
            tab[i] = (int)(Math.random()*valMax+1);
        }
    }

    public VectN_bis(){
        this(5,9);
    }

    public VectN_bis(int a, int b, int c){
        this.tab = new int[]{a, b, c};
    }

    public void affiche(){
        for (int x : this.tab){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public int somme(){
        int res = 0;
        for (int x : this.tab){
            res += x;
        }
        return res;
    }

    public String toString() {
        return Arrays.toString(tab);
    }

    int [] getTab(){
        return this.tab;
    }

    public int[] getTab2() {
        return Arrays.copyOf(tab, tab.length);
    }
    

    public static void main(String[] args) {
        VectN_bis a1 = new VectN_bis(5);
        VectN_bis a2 = new VectN_bis(3, 15);
        VectN_bis a3 = new VectN_bis();
        VectN_bis a4 = new VectN_bis(5, 7, 9);

        a1.affiche();
        a2.affiche();
        a3.affiche();
        a4.affiche();

        System.out.println("\na1 : " + a1.toString());
        System.out.println("a2 : " + a2.toString());
        System.out.println("a3 : " + a3.toString());
        System.out.println("a4 : " + a4.toString());

        System.out.println("\nSomme de a3 : " + a3.somme());

        VectN_bis vect = new VectN_bis (4, 5, 6);
        int[] tab=vect.getTab();
        tab[0] = 100;
        System.out.println("\nvect: " + vect);

        /*Avec cette modification, getTab renvoie une copie du tableau tab, et donc, lorsque vous modifiez tab, 
        le tableau original à l'intérieur de l'instance vect reste inchangé.*/
        VectN_bis vect2 = new VectN_bis(4, 5, 6);
        int[] tab2=vect2.getTab();
        tab[0] = 100;
        System.out.println("\nAprès modification:");
        System.out.println("vect: " + vect2);
        System.out.println("tab: " + Arrays.toString(tab));
    }

}