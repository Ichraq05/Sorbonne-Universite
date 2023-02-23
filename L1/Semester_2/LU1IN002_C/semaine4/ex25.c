// Q1
void placeElt(float tab[], int i) {
    float temp = tab[i];
    int j = i;
    // On remonte tant que l'élément précédent est plus grand
    while (j > 0 && tab[j - 1] > temp) {
        tab[j] = tab[j - 1];
        j--;
    }
    tab[j] = temp;
}

// Q2 Main
// Boucle for (i=1; i < taille; i++) placeElt(tab, i);