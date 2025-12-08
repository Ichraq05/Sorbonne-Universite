public class Ellipse extends Figure2D {
    double grand;
    double petit;

    public Ellipse(double grand, double petit) {
        this.grand = grand;
        this.petit = petit;
    }

    public double surface() {
        return Math.PI * grand * petit;
    }

    public double perimetre() {
        return 2 * Math.PI * Math.sqrt((Math.pow(grand, 2) + Math.pow(petit, 2)) / 2);
    }
}