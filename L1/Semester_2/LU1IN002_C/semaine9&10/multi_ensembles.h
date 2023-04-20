#ifndef MULTI_ENSEMBLES_H
#define MULTI_ENSEMBLES_H

#include <stdlib.h> 

// Structure pour multi-ensemble (valeur + fréquence)
typedef struct _element_t element_t;
struct _element_t {
    int valeur;
    int frequence;
    element_t *suivant;
};

// Fonctions utilitaires
element_t* Recherche_val(int val, element_t *liste); // Ex 43 Q1
void AfficherMultiEnsemble(element_t *liste);

// Semaine 9
element_t* Ajout_tete_ensemble(element_t *liste, int val, int freq);
element_t* Supprime_total_element_ensemble(element_t *liste, int val);
element_t* Ajout_ensemble_trie(element_t *liste, int val, int freq);

// Semaine 9
int Inclus(element_t *e1, element_t *e2);

// Semaine 10
int taille(element_t *liste); 
element_t* Supprime_frequence_inf_seuil(element_t *liste, int seuil);
element_t* Intersection_triee(element_t *e1, element_t *e2);

#endif // MULTI_ENSEMBLES_H