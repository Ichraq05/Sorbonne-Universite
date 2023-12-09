int compte_mots(char *chaine) {
    int count = 0;
    int dans_mot = 0; // Booléen
    for (int i = 0; chaine[i] != '\0'; i++) {
        if (chaine[i] != ' ') {
            if (!dans_mot) {
                count++;
                dans_mot = 1;
            }
        } else {
            dans_mot = 0;
        }
    }
    return count;
}