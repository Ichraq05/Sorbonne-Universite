// Q1
void init_temp(float tab[], int taille) {
    for (int i = 0; i < taille; i++) {
        // Tirage entre -200 et 300, divisé par 10 -> -20.0 à 30.0
        tab[i] = (rand() % 501 - 200) / 10.0;
    }
}

// Q2
float moy_temp(float tab[], int taille) {
    float somme = 0;
    for (int i = 0; i < taille; i++) somme += tab[i];
    return somme / taille;
}