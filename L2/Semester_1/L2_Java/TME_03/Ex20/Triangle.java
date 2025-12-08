package Ex20;

public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point a, Point b, Point c) {
        pointA = a;
        pointB = b;
        pointC = c;
    }

    public Triangle() {
        pointA = new Point();
        pointB = new Point();
        pointC = new Point();
    }

    public String toString() {
        return "{" + pointA + ";" + pointB + ";" + pointC + "}";
    }

    public double getPerimetre() {
        // Calcul des distances entre les points
        double dist_AB = pointA.distance(pointB);
        double dist_BC = pointB.distance(pointC);
        double dist_CA = pointC.distance(pointA);

        // Calcul du périmètre
        double perimetre = dist_AB + dist_BC + dist_CA;
        return perimetre;
    }

    public Triangle(Triangle t1) {
        this.pointA = new Point(t1.pointA);
        this.pointB = new Point(t1.pointB);
        this.pointC = new Point(t1.pointC);
    }
    
    //Q.7 :
    // Méthode, tester l'égalité entre deux triangles
    public boolean equals(Triangle t2) {
        boolean p_equal = this.pointA.equals(t2.pointA) &&
                             this.pointB.equals(t2.pointB) &&
                             this.pointC.equals(t2.pointC);
        return p_equal;
    }
}

