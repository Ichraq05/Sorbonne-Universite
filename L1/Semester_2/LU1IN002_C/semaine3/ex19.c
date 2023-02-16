// Q1
void min_max(int val, int *min, int *max) {
    if (val < *min) *min = val;
    if (val > *max) *max = val;
}

// Q2
void stats(int v1, int v2, int v3, int v4, int *min, int *max, float *moy) {
    // Initialisation
    *min = v1; *max = v1; 
    int somme = 0; int count = 0;
    
    // Logique simplifiée (tableau serait mieux, mais on suit l'énoncé variables)
    int t[4] = {v1, v2, v3, v4};
    
    if (v1 <= 0) { // Condition d'arrêt immédiat énoncé
       *min = -1; *max = -1; *moy = -1.0; return;
    }

    // Boucle manuelle sur les variables
    for(int i=0; i<4; i++) {
        if (t[i] <= 0) break; // On arrête si <= 0
        if (i==0) { *min=t[i]; *max=t[i]; } // Init premier élément valide
        else min_max(t[i], min, max);
        somme += t[i];
        count++;
    }
    
    if (count > 0) *moy = (float)somme / count;
}