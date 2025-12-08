import java.util.ArrayList;

public class Etudiant {
    private int []notes = new int[5];
    private String nom;
    private int nbNotes = 0;
    private ArrayList<Etudiant> listEtudiants = new ArrayList<Etudiant>();
    private ArrayList<Integer> notes2 = new ArrayList<Integer>();

    public Etudiant(String nom){
        this.nom = nom;
    }

    public void entrerNote(int note) throws TabNotesPleinException {
        if (notes2.size() < 5) {
            notes2.add(note);
        } else {
            throw new TabNotesPleinException(nom);
        }
    }

    public String getNom() {
        return nom;
    }

    /* Q.1 --> Q.3
    public void enterNote(int note) throws TabNotesPleinException{
        if (nbNotes >= notes.length){
            throw new TabNotesPleinException("Impossible d'ajouter la note : " + note + " à l'étudiant " + this.nom + "\nLe nombre de notes max est atteintes.");
        }
        else{
            notes[nbNotes] = note;
            nbNotes++;
        }
    }
    */


    public String toString(){
        String res = "Etudiant : " + nom + "\nNotes : ";
        for (int x : notes){
            res += x + " ";
        }
        return res;
    }
}