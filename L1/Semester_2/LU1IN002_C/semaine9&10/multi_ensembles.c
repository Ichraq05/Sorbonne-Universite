#include <stdio.h>
#include <stdlib.h>
#include "multi_ensembles.h"

void AfficherMultiEnsemble(element_t *liste) {
    printf("{");
    while (liste) {
        printf(" (%d, %d)", liste->valeur, liste->frequence);
        if (liste->suivant) printf(",");
        liste = liste->suivant;
    }
    printf(" }\n");
}

// Exercice 43

// Q1
element_t* Recherche_val(int val, element_t *liste) {
    while(liste) {
        if (liste->valeur == val) return liste;
        liste = liste->suivant;
    }
    return NULL;
}

// Q2
element_t* Ajout_tete_ensemble(element_t *liste, int val, int freq) {
    element_t *el = Recherche_val(val, liste);
    if (el) {
        el->frequence += freq;
        return liste;
    }
    element_t *nouv = malloc(sizeof(element_t));
    nouv->valeur = val;
    nouv->frequence = freq;
    nouv->suivant = liste;
    return nouv;
}

// Exercice 44 & 45

// Ex 44 Q1
element_t* Supprime_total_element_ensemble(element_t *liste, int val) {
    if (!liste) return NULL;
    if (liste->valeur == val) {
        element_t *tmp = liste->suivant;
        free(liste);
        return tmp; 
    }
    liste->suivant = Supprime_total_element_ensemble(liste->suivant, val);
    return liste;
}

// Ex 45 Q1
element_t* Ajout_ensemble_trie(element_t *liste, int val, int freq) {
    // Cas 1: Liste vide ou insertion en tête
    if (!liste || liste->valeur > val) {
        element_t *nouv = malloc(sizeof(element_t));
        nouv->valeur = val; nouv->frequence = freq;
        nouv->suivant = liste;
        return nouv;
    }
    if (liste->valeur == val) {
        liste->frequence += freq;
        return liste;

    liste->suivant = Ajout_ensemble_trie(liste->suivant, val, freq);
    return liste;
}


// Exercice 46 & 47
// Ex 46 Q1
int Inclus(element_t *e1, element_t *e2) {
    while (e1 && e2) {
        if (e1->valeur < e2->valeur) return 0;
        if (e1->valeur > e2->valeur) e2 = e2->suivant;
        else { 
            if (e1->frequence > e2->frequence) return 0;
            e1 = e1->suivant;
            e2 = e2->suivant;
        }
    }
    return (e1 == NULL);
}

// Ex 47 Q1
int taille(element_t *liste) {
    if (!liste) return 0;
    return liste->frequence + taille(liste->suivant);
}

// Ex 47 Q2
element_t* Supprime_frequence_inf_seuil(element_t *liste, int seuil) {
    if (!liste) return NULL;
    if (liste->frequence < seuil) {
        element_t *tmp = liste->suivant;
        free(liste);
        return Supprime_frequence_inf_seuil(tmp, seuil);
    }
    liste->suivant = Supprime_frequence_inf_seuil(liste->suivant, seuil);
    return liste;
}

// Ex 48 Q6
element_t* Intersection_triee(element_t *e1, element_t *e2) {
    if (!e1 || !e2) return NULL;
    
    if (e1->valeur < e2->valeur) return Intersection_triee(e1->suivant, e2);
    if (e1->valeur > e2->valeur) return Intersection_triee(e1, e2->suivant);
    
    // Valeurs égales
    element_t *res = malloc(sizeof(element_t));
    res->valeur = e1->valeur;
    res->frequence = (e1->frequence < e2->frequence) ? e1->frequence : e2->frequence;
    res->suivant = Intersection_triee(e1->suivant, e2->suivant);
    return res;
}