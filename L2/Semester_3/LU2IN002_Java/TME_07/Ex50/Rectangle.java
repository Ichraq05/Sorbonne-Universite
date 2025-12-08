public class Rectangle extends Figure2D{
    double largeur, longueur;

    public Rectangle(double largeur, double longueur){
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double surface(){
        return largeur*longueur;
    }

    public double perimetre(){
        return (longueur + largeur)*2;
    }
    
}