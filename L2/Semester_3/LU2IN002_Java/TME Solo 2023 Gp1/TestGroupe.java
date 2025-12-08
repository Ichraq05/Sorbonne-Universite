public class TestGroupe {
    public static void main(String[] args) {
        Groupe []groupeSorcier = new Groupe(10);
        Sorcier s1 = new Sorcier(20, 5);
        Sorcier s2 = new Sorcier(20, 10);
        Sorcier s3 = new Sorcier(20, 7);
        groupeSorcier.ajouter(s1);
        groupeSorcier.ajouter(s2);
        groupeSorcier.ajouter(s3);

        Groupe []groupeDragon = new Groupe(3);
        Dragon d1 = new Dragon(true);
        Dragon d2 = new Dragon(false);
        groupeDragon.ajouter(d1);
        groupeDragon.ajouter(d2);
    }
    
}