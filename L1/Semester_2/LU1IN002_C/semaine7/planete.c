#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nom[11]; // 10 caractères au maximum + '\0'
    float densite;
    float distance; // en millions de kilomètres
    int nb_satellites;
} planete;


// Q2: Affiche une seule planète
void affichePlanete(planete p) {
    printf("Nom: %s | Densité: %.2f | Distance au soleil: %.2f M km | Satellites: %d\n", 
           p.nom, p.densite, p.distance, p.nb_satellites);
}

// Q3: Affiche toutes les planètes d'un tableau
void afficheToutesPlanetes(planete tab[], int taille) {
    printf("\n--- Affichage de %d planètes ---\n", taille);
    for (int i = 0; i < taille; i++) {
        affichePlanete(tab[i]); // Appel à la fonction Q2
    }
}

// Q4: Modifie la densité (passage par pointeur)
void modifieDensite(planete *p, float nouvelle_densite) {
    p->densite = nouvelle_densite;
}

int main() {
    // Création de quelques planètes
    planete terre;
    strcpy(terre.nom, "Terre");
    terre.densite = 5.51;
    terre.distance = 149.6;
    terre.nb_satellites = 1;

    planete mars = {"Mars", 3.93, 227.9, 2};

    planete systeme_solaire[2] = {terre, mars};

    afficheToutesPlanetes(systeme_solaire, 2);

    // Test de modification
    modifieDensite(&terre, 6.00);
    printf("\n--- Après modification de la Terre ---\n");
    affichePlanete(terre);

    return 0;
}