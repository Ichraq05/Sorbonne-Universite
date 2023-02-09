#include <stdio.h>

// Q1
int jours(int transmission, int population, float pourcentage) {
    int n_jours = 0;
    long contamines = 1; // Commence avec 1 malade
    long cible = (long)(population * (pourcentage / 100.0));

    while (contamines < cible && contamines < population) {
        contamines += contamines * transmission;
        n_jours++;
    }
    return n_jours;
}

// Q2
float pourcentage(int transmission, int population, int n_jours) {
    long contamines = 1;
    for (int i = 0; i < n_jours; i++) {
        contamines += contamines * transmission;
        if (contamines > population) contamines = population;
    }
    return ((float)contamines / population) * 100.0;
}