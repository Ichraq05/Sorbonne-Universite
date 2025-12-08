public class TestFigure {
    public static void main(String[] args) {
        Figure2D tab[] = new Figure2D[4];
        
        Rectangle r1 = new Rectangle(4,5);
        Carre c1 = new Carre(4);
        Ellipse e1 = new Ellipse (6,3);
        Cercle ce1 = new Cercle(5);

        tab[0] = r1;
        tab[1] = c1;
        tab[2] = e1;
        tab[3] = ce1;

        for (Figure2D x : tab){
            System.out.println("Surface : " + x.surface() + ", Perimetre : " + x.perimetre());
        }
    }   
}