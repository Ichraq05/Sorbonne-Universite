package Ex20;

public class TestTriangle
{
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        System.out.println("Points :");
        System.out.println("p1 = " + p1.toString());
        System.out.println("p2 = " + p2.toString());

        double distance = p1.distance(p2);
        System.out.println(String.format("Distance entre les 2 points : %.1f", distance));

        //Q.4 : 
        Point p3 = new Point();
        System.out.println("p3 = " + p3.toString());

        System.out.println("\nTriangle :");

        Triangle t1 = new Triangle(p1, p2, p3);
        System.out.println("t1 = " + t1.toString());

        double perimetre = t1.getPerimetre();
        System.out.println(String.format("Perimetre : %.1f", perimetre));


        //Q.5, Q.6 :
        Triangle t2 = new Triangle(t1);
        System.out.println("\nApres creation copie t2 :");
        System.out.println("t1 = " + t1.toString());
        System.out.println("t2 = " + t2.toString());

        p1.deplaceToi(2.0,4.0);

        System.out.println("\nApres modification de p1 dans t1 :");
        System.out.println("t1 = " + t1.toString());
        System.out.println("t2 = " + t2.toString());

        //Q.7
        boolean areEqual = t1.equals(t2);
        System.out.println("\nLes deux triangles sont-ils égaux ? " + areEqual);
    }
}