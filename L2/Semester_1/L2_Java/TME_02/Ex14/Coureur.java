package Ex14;
import java.util.Random;

public class Coureur
{
    private int numDossard;
    private double tempsAu100;
    private boolean possedeTemoin;
    
    public Coureur (int numDossard)
    {
        this.numDossard = numDossard;
        this.tempsAu100 = 12 + Math.random() * (16-12);
        this.possedeTemoin = false;
    }

    public Coureur ()
    {
        this(new Random().nextInt(1000)+1);
    }

    public int getNumDossard()
    {
        return numDossard;
    }

    public double getTempsAu100()
    {
        return tempsAu100;
    }

    public boolean getPossedeTemoin()
    {
        return possedeTemoin;
    }

    public void setPossedeTemoin(boolean possedeTemoin)
    {
        this.possedeTemoin = possedeTemoin;
    }

    public String toString() {
        String description = "Coureur " + numDossard + " tempsAu100 : " + String.format("%.1f s au 100m ", tempsAu100) + " possedeTemoin : " + (possedeTemoin ? "oui" : "non");
        return description;
    }

    public void passeTemoin(Coureur c)
    {
        if (this.possedeTemoin)
        {
            this.possedeTemoin = false;
            c.setPossedeTemoin(true);
            System.out.println("\nMoi, coureur "+ this.numDossard + ", je passe le témoin au coureur " + c.getNumDossard());
        }
         else 
        {
            System.out.println("\nCoureur "+ this.numDossard+ ", je n'ai pas le témoin à passer.");
        }
    }

    public void courir()
    {
        if (this.possedeTemoin)
        {
            this.possedeTemoin = true;
            System.out.println("\nJe suis le coureur "+ this.numDossard +" et je cours.\n");
        }
        else
        {
            System.out.println("Je suis le coureur "+ this.numDossard +" et je ne cours pas.\n");
        }
    }

    //Q.1, Q.2, Q.3
    public void afficher() {
        System.out.println("\nNuméro de dossard : " + numDossard);
        System.out.println("Temps au 100 mètres : " + String.format("%.2f secondes", tempsAu100));
        System.out.println("Possède un témoin : " + possedeTemoin);
    }
}