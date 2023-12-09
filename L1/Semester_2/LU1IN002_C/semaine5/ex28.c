#define NB_AMIS 4
#define NB_JOURS 7

// Q1
void init_frais(float tab[NB_AMIS][NB_JOURS]) {
    for(int i=0; i<NB_AMIS; i++)
        for(int j=0; j<NB_JOURS; j++)
            tab[i][j] = 0.0;
}

// Q2
void ecrit_comptes(float tab[NB_AMIS][NB_JOURS], int jour) {
    int montant = 30 + rand() % 21; // 30 à 50
    int payeur = rand() % NB_AMIS;
    float part = (float)montant / NB_AMIS;
    
    for(int i=0; i<NB_AMIS; i++) {
        if (i == payeur) tab[i][jour] = montant - part;
        else tab[i][jour] = -part;
    }
}