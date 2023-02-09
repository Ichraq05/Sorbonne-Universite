#include <cini.h>

// Q1
int position(int a, int b, int x, int y) {
    int y_droite = a * x + b;
    if (y < y_droite) return -1; // En-dessous (selon repère écran inversé ?) 
    // Attention : en repère écran (0,0 en haut à gauche), y augmente vers le bas.
    // L'énoncé suggère le repère classique mathématique visuellement fig 3, 
    // mais CINI utilise repère écran. 
    // Si on suit strict math: y > ax+b -> dessus.
    if (y == y_droite) return 0;
    return 1;
}

// Q2
void affiche(int a, int b, int w, int h) {
    for (int x = 0; x < w; x++) {
        for (int y = 0; y < h; y++) {
            // Logique selon repère mathématique inversé ou non, ici version simple:
            int p = position(a, b, x, y);
            if (p == 0) CINI_draw_pixel(x, y, "black");
            else if (p > 0) CINI_draw_pixel(x, y, "red"); // Au dessus
            else CINI_draw_pixel(x, y, "blue"); // En dessous
        }
    }
}