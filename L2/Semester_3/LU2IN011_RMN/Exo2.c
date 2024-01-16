#include <stdio.h>
#include <math.h>

//  Groupe :
//  Alaa Alaboud
//  Gaoussou Diakite
//  Daouda Dicko
//  Ichraq Mohammad



// Fonction qui implémente l'algoritme de Horner pour évaluer un polynome
double horner(double *p, int n, double val) {
    double res = p[n]; // Initialise le résultat avec le coefficient de plus haut degrée
    for (int i = n - 1; i >= 0; i--) {
        res = res * val + p[i]; // Mise a jour du resultat en suivant le schema de Horner
    }
    return res; // Retourne le résultat final
}

// Fonction qui calcule la suite recurrente en utilisant l'algorithme de Horner
double suite_recurrence(double x, double alpha) {
    // Coefficients du polynôme pour la suite recurente
    double p[] = {4, -4 * alpha + 3, -alpha, -2 * alpha, 0, 0, 0, 0};
    return horner(p, 7, x); // Appelle la fonction Horner pour evaluer le polynome a la valeur specifiee
}

// Fonction qui calcule la dérivée numerique de la suite récurrente par rapport à x
double derivee(double x, double alpha) {
    double h = 1e-6; // Petit pas
    return (suite_recurrence(x + h, alpha) - suite_recurrence(x, alpha)) / h; // Calcul de la dérivée numerique
}

// Fonction qui étudie la convergence de la suite
void convergence(double x0, double alpha, double epsilon) {
    double xn = x0; // Initialise la valeur xn avec x0
    double xs = 0; // Initialise la valeur limite
    int n = 0; // Initialise le compteur
    double prev_diff = fabs(xn - xs); // Initialise la difference précedente
    double curr_diff; // Initialisela difference actuelle
    double variation_relative = 1; // Initialise la variation relative

    double a = xs; // Point fixe
    double f_prime_a = derivee(a, alpha); // Calcul de la dérivée de la suite récurrente en a

    do {
        xs = xn; // Mise a jour de la valeur limite avec la valeur précedente
        xn = suite_recurrence(xn, alpha); // Calcul de la valeur suivante de la suite
        n++; // Increment du compteur
        curr_diff = fabs(xn - xs); // Calcul de la difference actuelle

        double variation = round((curr_diff / prev_diff) * 10000) / 10000; // Calcul de la variation relative

        prev_diff = curr_diff; // Mise a jour de la difference precedente
        variation_relative = variation; // Mise a jour de la variation relative
    } while (curr_diff >= epsilon); // Verification de la condition de convergence

    if (f_prime_a != 0) {
        if (fabs(f_prime_a) < 1) {
            printf("Convergence lineaire, p = %.2f\n", fabs(f_prime_a)); // Affichage du type de convergence linéaire
        } else {
            printf("Convergence exponentielle, p = %.2f\n", 1.0 / fabs(f_prime_a)); // Affichage du type de convergence exponentielle
        }
    } else {
        printf("Convergence exponentielle, p = %.2f\n", variation_relative); // Affichage du type de convergence exponentielle
    }
}

int main() {
    double alpha, x0, epsilon;

    // Demander les valeurs de x0, alpha et epsilon a l'utilisateur
    printf("Entrez la valeur de x0 : ");
    scanf("%lf", &x0);
    printf("Entrez la valeur de alpha : ");
    scanf("%lf", &alpha);
    printf("Entrez la valeur de epsilon : ");
    scanf("%lf", &epsilon);

    // Appeler la fonction de convergence pour les valeurs specifiees
    convergence(x0, alpha, epsilon);

    return 0;
}
