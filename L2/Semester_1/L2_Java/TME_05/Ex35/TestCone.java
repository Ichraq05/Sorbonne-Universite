public class TestCone {
    public static void main(String[] args) {
        System.out.println("Nombre de Cones créés: " + Cone.getNbCones());

        Cone c1 = new Cone(5.4,7.2);
        Cone c2 = new Cone();

        /*
        System.out.println(c1.toString());
        System.err.println(c2.toString());
        */

        System.out.println(String.format("Cone = %.2f, h = %.2f, V = %.2f", c1.getR(), c1.getH(), c1.getVolume()));
        System.out.println(String.format("Cone = %.2f, h = %.2f, V = %.2f", c2.getR(), c2.getH(), c2.getVolume()));
    

        System.out.println("Nombre de Cones créés : " + Cone.getNbCones());
    }   
}