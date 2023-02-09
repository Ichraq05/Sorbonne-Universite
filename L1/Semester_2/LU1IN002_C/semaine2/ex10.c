#include <cini.h>

// Q3 & Q4 combinées : Carré avec coordonnées variables
void carre(int x, int y, int taille) {
    for (int i = 0; i < taille; i++) {
        CINI_draw_pixel(x + i, y, "blue");          // Haut
        CINI_draw_pixel(x + i, y + taille, "green"); // Bas
        CINI_draw_pixel(x, y + i, "red");           // Gauche
        CINI_draw_pixel(x + taille, y + i, "black"); // Droite
    }
}

void carres_remontant(int l, int x, int y) {
    // Tant que le carré reste dans la fenêtre (supposée 400x400)
    while (x >= 0 && y >= 0) {
        carre(x, y, l);
        x -= 20;
        y -= 20;
    }
}