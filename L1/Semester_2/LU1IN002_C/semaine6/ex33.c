// Q1
int est_deb(char *s1, char *s2) {
    if (*s1 == '\0') return 1; // Fin de s1 atteinte = succès
    if (*s2 == '\0') return 0; // s2 fini avant s1 = échec
    if (*s1 != *s2) return 0;
    return est_deb(s1 + 1, s2 + 1);
}

// Q2
int est_incluse(char *s1, char *s2) {
    if (*s1 == '\0') return 1; // Chaine vide incluse partout
    if (*s2 == '\0') return 0;
    if (est_deb(s1, s2)) return 1;
    return est_incluse(s1, s2 + 1);
}