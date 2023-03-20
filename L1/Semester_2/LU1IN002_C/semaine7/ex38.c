// Q1 & Q2
// Déclaration: int plateau[HAUTEUR][LARGEUR];
void afficher_plateau(int plateau[HAUTEUR][LARGEUR], char *colors[]) {
    // Effacer fenêtre
    CINI_fill_window("black"); 
    for(int i=0; i<HAUTEUR; i++) {
        for(int j=0; j<LARGEUR; j++) {
            if (plateau[i][j] != VIDE) {
                // Dessiner carré (suppose fonction helper ou draw_rect)
                // CINI_fill_rect(j*TAILLE, i*TAILLE, TAILLE, TAILLE, colors[plateau[i][j]]);
            }
        }
    }
}
// Q5 Descendre
int descendre(int plateau[HAUTEUR][LARGEUR], struct piece *p) {
    // Vérifier si p->pos_ligne + 1 est valide (collision ou bas)
    // Si valide: p->pos_ligne++; return 1;
    // Sinon: return 0;
}