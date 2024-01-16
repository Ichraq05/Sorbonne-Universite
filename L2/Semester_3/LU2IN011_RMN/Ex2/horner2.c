#include <stdio.h>
#include <math.h>

// Fonction qui implémente l'algorithme de Horner pour évaluer un polynôme
double horner(double *p, int n, double val) {
    double result = p[n]; // Initialisation du résultat avec le coefficient de plus haut degré
    for (int i = n - 1; i >= 0; i--) {
        result = result * val + p[i]; // Mise à jour du résultat en suivant le schéma de Horner
    }
    return result; // Retourne le résultat final
}

// Fonction représentant la suite récurrente en utilisant Horner
double horner_scheme(double x, double alpha) {
    // Coefficients du polynôme pour la suite récurrente
    double p[] = {-2 * alpha * alpha, -4 * alpha + 3, -5 * alpha * alpha, -2 * alpha - 2, -alpha,
                  -3 * alpha + 2, 4, 0};

    // Appelle la fonction Horner pour évaluer le polynôme à la valeur spécifiée
    return horner(p, 7, x);
}

void convergence_analysis(double x0, double alpha, double epsilon) {
    double xn = x0;
    double xs = 1.000845742570146e+00; // Valeur limite attendue
    int n = 0;
    double prev_diff = fabs(xn - xs);
    double curr_diff;
    double ratio = 1;

    do {
        xn = horner_scheme(xn, alpha);
        n++;
        curr_diff = fabs(xn - xs);

        double new_ratio = curr_diff / prev_diff;

        if (new_ratio < 1e-4) {
            printf("Convergence rapide\n");
            return;
        } else if (curr_diff > prev_diff) {
            printf("Divergence\n");
            return;
        } else if (curr_diff < epsilon) {
            printf("Convergence\n");
            return;
        }

        prev_diff = curr_diff;
    } while (n < 100);

    printf("Convergence lente\n");
}

int main() {
    printf("1er cas : x0 = 2, alpha = 0.3, epsilon = 1e-14\n");
    convergence_analysis(2, 0.3, 1e-14);

    printf("\n2e cas : x0 = 5, alpha = 3.5, epsilon = 1e-14\n");
    convergence_analysis(5, 3.5, 1e-14);

    printf("\n3e cas : x0 = 0.5, alpha = 3.5, epsilon = 1e-14\n");
    convergence_analysis(0.5, 3.5, 1e-14);

    printf("\n4e cas : x0 = -3.0, alpha = 1.0, epsilon = 1e-14\n");
    convergence_analysis(-3.0, 1.0, 1e-14);

    printf("\n5e cas : x0 = 2.0, alpha = 1.0, epsilon = 1e-14\n");
    convergence_analysis(2.0, 1.0, 1e-14);

    return 0;
}
