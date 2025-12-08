public class Menagerie {
    private Animal []animal;
    private int nb_animaux;
    
    public Menagerie(int max){
        this.animal = new Animal[max];
        this.nb_animaux = 0;
    }
    
    void ajouter(Animal a){
        if (nb_animaux < animal.length){
            animal[nb_animaux] = a;
            nb_animaux ++;
        }
        else{
            System.out.println("La menagerie est pleine, impossible d'ajouter un animal");
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < nb_animaux; i++){
            res += animal[i].toString() + "\n";
        }

        return res;
    }

    public void midi(){
        for(int i = 0 ; i < nb_animaux ; i++){
            animal[i].crier();
        }
    }

    public void vieillirTous(){
        for(int i = 0 ; i < nb_animaux ; i++){
            animal[i].vieillir();
        }
    }

    public static void main(String[] args) {
        Vache v1 = new Vache("V1");
        Boa b1 = new Boa("B1");

        System.out.println(v1.toString());
        System.out.println(b1.toString());

        Menagerie mena1 = new Menagerie(10);

        mena1.ajouter(v1);
        mena1.ajouter(b1);

        System.out.println(mena1.toString());

        mena1.midi();

        mena1.vieillirTous();
        
        System.out.println(mena1.toString());
    }
}