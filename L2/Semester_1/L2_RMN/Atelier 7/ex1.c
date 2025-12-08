#include <stdio.h>
#include <math.h>


int bitcommun_opt(double x, double y) {
    // Conversion des nombres en représentation entière binaire (en utilisant des cast vers un entier)
    int int_x = *(int*)&x;
    int int_y = *(int*)&y;

    // Création d'un masque pour extraire la mantisse (les 23 bits de la mantisse)
    unsigned int mantissa_mask = 0x007FFFFF;

    // Extraction des mantisses des deux nombres
    int mantissa_x = int_x & mantissa_mask;
    int mantissa_y = int_y & mantissa_mask;

    // Calcul de la valeur absolue de la différence des mantisses
    int diff_mantissa = abs(mantissa_x - mantissa_y);

    // Calcul de la mantisse maximale
    int max_mantissa = max(mantissa_x, mantissa_y);

    // Calcul du nombre de chiffres significatifs communs en utilisant les décalages
    int common_bits = 23 - __builtin_clz(diff_mantissa) - __builtin_clz(max_mantissa);

    return common_bits;
}

int main() {
    // Déclaration des tableaux x et y pour tester avec les valeurs de la vidéo
    double x[] = {1.41421356, 9.87452334, 10.07452334, -2.69998756};
    double y[] = {1.41427845, 9.87901342, 10.07901342, -2.70001234};
    
    // Boucle pour calculer et afficher le nombre de chiffres significatifs communs pour chaque paire de valeurs x et y
    for (int i = 0; i < 4; i++) {
        printf("bitcommun : Nombre de chiffres significatifs communs entre x et y : %.4f\n", bitcommun_opt(x[i], y[i]));
    }
    
    return 0;
}
