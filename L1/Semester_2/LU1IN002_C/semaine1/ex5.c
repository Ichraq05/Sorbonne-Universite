#include <stdio.h>
#include <math.h> // Pour sqrt

// Q1: Fonction discriminant
int discriminant(int a, int b, int c) {
    return (b * b) - (4 * a * c);
}

// Q2: Affiche Racines
void afficheRacines(int a, int b, int c) {
    int delta = discriminant(a, b, c);
    if (delta < 0) {
        printf("Pas de racine réelle.\n");
    } else if (delta == 0) {
        double r = (double)-b / (2 * a);
        printf("Une racine double : %f\n", r);
    } else {
        double r1 = (-b - sqrt(delta)) / (2 * a);
        double r2 = (-b + sqrt(delta)) / (2 * a);
        printf("Deux racines : %f et %f\n", r1, r2);
    }
}

// Q3: Main
int main() {
    afficheRacines(-4, 4, 1);
    afficheRacines(-4, 6, 1);
    afficheRacines(-7, -5, -1);
    return 0;
}