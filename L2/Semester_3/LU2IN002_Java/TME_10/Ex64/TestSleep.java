import java.util.InputMismatchException;
import java.util.Scanner;

//Il faut compiler dans le terminal avec javac, java...

public class TestSleep {
    public static void main(String[] args){ //throws InterruptedException <-- Q.2 De ce fait on a pas a gérer l'execption ici localement
        Scanner scanner  = new Scanner(System.in);
        try{
            System.out.print("Enter un nombres de secondes : ");
            int x = scanner.nextInt();

            if(x < 0){
                System.out.println("Le nombre doit être positif");
            }
            else{
                System.out.println(String.format("Attente de %d secondes", x));
                Thread.sleep(x*1000);
                System.out.println("Fin de l'attente");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Le nombre est mal formé");
        }
        catch (InterruptedException e){
            System.out.println("Interruption pendant l'attente");
        }
        scanner.close();
    }
    
}