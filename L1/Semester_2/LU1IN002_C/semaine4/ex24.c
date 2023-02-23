// Q1
int indiceInsert(int tab[], int nbEl, int taille, int el) {
    if (nbEl >= taille) return -1;
    for (int i = 0; i < nbEl; i++) {
        if (tab[i] == el) return -1; // Déjà présent
        if (tab[i] > el) return i;   // Place trouvée
    }
    return nbEl; // À la fin
}

// Q2
int insertElt(int tab[], int *nbEl, int taille, int el) {
    int idx = indiceInsert(tab, *nbEl, taille, el);
    if (idx == -1) return 0;
    
    // Décalage vers la droite
    for (int i = *nbEl; i > idx; i--) {
        tab[i] = tab[i-1];
    }
    tab[idx] = el;
    (*nbEl)++;
    return 1;
}