// Q1
typedef struct {
    char nom[11];
    float densite;
    float distance;
    int nb_satellites;
} planete;

// Q2
void affichePlanete(planete p) {
    printf("Nom: %s, Densité: %.2f, Dist: %.2f, Sats: %d\n", 
           p.nom, p.densite, p.distance, p.nb_satellites);
}