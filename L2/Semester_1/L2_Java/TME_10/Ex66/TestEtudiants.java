import java.util.ArrayList;

public class TestEtudiants {
    public static void main(String[] args) {
        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

        for (String arg : args) {
            try {
                // Tentative de conversion en entier
                int note = Integer.parseInt(arg);
                // Ajouter la note à l'étudiant précédemment créé
                if (!listeEtudiants.isEmpty()) {
                    Etudiant dernierEtudiant = listeEtudiants.get(listeEtudiants.size() - 1);
                    dernierEtudiant.entrerNote(note);
                } else {
                    System.out.println("Aucun étudiant créé pour ajouter la note : " + note);
                }
            } catch (NumberFormatException e) {
                // Si la conversion en entier échoue, c'est probablement un nom
                // Créer une nouvelle instance d'étudiant
                Etudiant nouvelEtudiant = new Etudiant(arg);
                listeEtudiants.add(nouvelEtudiant);
            } catch (TabNotesPleinException e) {
                System.out.println("Le tableau de notes de l'étudiant " + e.getNom() + " est plein");
            }
        }

        System.out.println("Les étudiants :");
        for (Etudiant etudiant : listeEtudiants) {
            System.out.println(etudiant.toString());
        }
    }
}

/* Q.1 --> Q.3
public class TestEtudiants {
    public static void main(String[] args) {
        for (String arg : args){
            try{
                // Tentative de conversion en entier
                int note = Integer.parseInt(arg);
                System.out.print(note + " est une note, ");
            }
            catch (NumberFormatException e){
                // Si la conversion en entier échoue, c'est probablement un nom
                System.out.print("\n" + arg + " est un nom, ");
            }
        }
        System.out.println();
    }
}
*/