import java.util.ArrayList;

public class Foret {
    private Object [][]terrain;
    private int taille;
    

    public Foret(int taille){
        this.taille = taille;
        this.terrain = new Object[taille][taille];
    }

    public boolean placer(Object obj){
        int x = (int)(Math.random()*taille);
        int y = (int)(Math.random()*taille);
        if (terrain[x][y] == null){
            terrain[x][y] = obj;
            return true;
        }
        else{
            return false; //La case est deja occupé
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < taille; i++){
            res += "|";
            for (int j = 0; j < taille; j++){
                Object obj = terrain[i][j];
                if (obj != null){
                    res += obj.toString().charAt(0);
                }
                else{
                    res += ' ';
                }
            }
            res += "|\n";
        }
        return res;
    }

    public ArrayList<Champignon> ramasserChampignon(){
        ArrayList<Champignon> champignonsRamasses = new ArrayList<Champignon>();

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if(terrain[i][j] instanceof Champignon){
                    Champignon champignon = (Champignon)terrain[i][j];
                    champignonsRamasses.add(champignon);
                    terrain[i][j] = null;
                }
            }
        }
        return champignonsRamasses;
    }

    public ArrayList<Ramassable> ramasserTout(){
        ArrayList<Ramassable> ramassable = new ArrayList<Ramassable>();

        for (int i = 0; i < terrain.length; i++){
            for(int j = 0; j < terrain.length; j++){
                if((terrain[i][j]) instanceof Ramassable){
                    ramassable.add((Ramassable)terrain[i][j]);
                    terrain[i][j] = null;
                }
            }
        }
        return ramassable;
    }

    public void ramasser(Panier p){
        for (int i = 0; i < terrain.length; i++){
            for(int j = 0; j < terrain.length; j++){
                if((terrain[i][j]) instanceof Ramassable){
                    p.add((Ramassable)terrain[i][j]);
                    terrain[i][j] = null;
                }
            }
        }
    }
}