package Ex15;
import java.util.Random;

public class Complexe 
{
    private double reelle;
    private double imag;

    public Complexe(double reelle, double imag) 
    {
        this.reelle = reelle;
        this.imag = imag;
    }

    public Complexe() 
    {
        Random random = new Random();
        this.reelle = -2 + random.nextDouble() * 4; 
        this.imag = -2 + random.nextDouble() * 4;   
    }

    // Accesseurs (getters) pour reelle et imag, si nécessaire
    public double getReelle() 
    {
        return reelle;
    }

    public double getImag() 
    {
        return imag;
    }

    public String toString() 
    {
        return reelle + " + " + imag + "i";
    }

    // Voir si le complexe est réel (partie imaginaire nulle)
    public boolean estReel() 
    {
        return imag == 0;
    }

    // Additionner deux complexes
    public Complexe addition(Complexe autre) 
    {
        double nouvelleReelle = this.reelle + autre.reelle;
        double nouvelleImag = this.imag + autre.imag;
        return new Complexe(nouvelleReelle, nouvelleImag);
    }

    // Multiplier deux complexes
    public Complexe multiplication(Complexe autre) 
    {
        double nouvelleReelle = (this.reelle * autre.reelle) - (this.imag * autre.imag);
        double nouvelleImag = (this.reelle * autre.imag) + (this.imag * autre.reelle);
        return new Complexe(nouvelleReelle, nouvelleImag);
    }
}

