// Q2
int supprimer_lignes(int plateau[HAUTEUR][LARGEUR], int *score) {
    int lignes_sup = 0;
    // Parcourir lignes, si ligne pleine -> supprimer et décaler
    // Mettre à jour lignes_sup
    
    // Calcul score
    if (lignes_sup == 1) *score += 40 * (niveau + 1);
    else if (lignes_sup == 2) *score += 100 * (niveau + 1);
    // ...
    return lignes_sup;
}