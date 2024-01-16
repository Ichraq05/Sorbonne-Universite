#include <stdio.h>
#include <math.h>

int main() {
    double x0, alpha, epsilon;
    printf("Entrez la valeur initiale x0 : ");
    scanf("%lf", &x0);
    printf("Entrez la valeur de alpha : ");
    scanf("%lf", &alpha);
    printf("Entrez la valeur de epsilon : ");
    scanf("%lf", &epsilon);

    double x = x0;
    double x_prev = 0.0;
    int n = 0;

    do {
        x_prev = x;
        x = alpha * x + 1.0; // Suite calculée avec le schéma de Horner
        n++;
    } while (n <= 12 && fabs(x - x_prev) >= epsilon);

    printf("La suite s'est arrêtée sur x%d = %.15e\n", n, x);

    return 0;
}
