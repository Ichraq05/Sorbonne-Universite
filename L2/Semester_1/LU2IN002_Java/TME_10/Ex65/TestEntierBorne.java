public class TestEntierBorne {
    public static void main(String[] args) {
        int v1 = (int)(Math.random()*301-150);
        int v2 = (int)(Math.random()*2);

        System.out.println("ebX : " + v1);
        System.out.println("ebY : " + v2);
        System.out.println("Somme de ebX + ebY : " + (v1+v2));

        try{
            EntierBorne ebX = new EntierBorne(v1);
            EntierBorne ebY = new EntierBorne(v2);
            EntierBorne somme = ebX.somme(ebY);
            EntierBorne div = ebX.divPar(ebY);
        }
        catch (HorsBornesException e){
            System.out.println(e.getMessage());
        }
        catch (DivisionParZeroException e){
            System.out.println(e.getMessage());
        }

        /*
        Q.6 Si vous avez plusieurs blocs catch et qu'un bloc plus général est placé avant un bloc plus spécifique, 
        le bloc plus spécifique ne sera jamais atteint, car le bloc plus général capture toutes les exceptions qui correspondent à 
        la hiérarchie d'héritage. Cela peut entraîner une perte d'informations sur le type exact de l'exception.

        Cela signifie que si une exception est levée, elle sera d'abord capturée par le bloc catch(Exception e)
        même si elle correspond également au bloc catch(DivisionParZeroException e).
         */
    }
}