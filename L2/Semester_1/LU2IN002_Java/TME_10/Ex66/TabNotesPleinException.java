public class TabNotesPleinException extends Exception {
    private String nom;

    public TabNotesPleinException(String nom){
        super("Le tableau de notes de l'étudiant " + nom + " est plein");
        this.nom = nom;

    }

    public String getNom() {
        return nom;
    }
}