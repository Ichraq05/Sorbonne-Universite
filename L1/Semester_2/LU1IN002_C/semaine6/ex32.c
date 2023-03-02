// Q3 Recursive
int recherche_rec(int tab[], int taille, int el) {
    if (taille == 0) return 0;
    if (tab[0] == el) return 1;
    return recherche_rec(tab + 1, taille - 1, el);
}

// Q4 Trié (Dichotomie récursive)
int dicho_rec(int tab[], int debut, int fin, int el) {
    if (debut > fin) return 0;
    int milieu = (debut + fin) / 2;
    if (tab[milieu] == el) return 1;
    if (tab[milieu] > el) return dicho_rec(tab, debut, milieu - 1, el);
    return dicho_rec(tab, milieu + 1, fin, el);
}