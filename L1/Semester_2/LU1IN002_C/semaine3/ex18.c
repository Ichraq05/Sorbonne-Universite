// Q1
void echange(int *a, int *b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

// Q2
void tri(int *a, int *b) {
    if (*a > *b) {
        echange(a, b);
    }
}

// Q3
void tri_3(int *a, int *b, int *c) {
    tri(a, b); // min est en a (entre a et b)
    tri(a, c); // min est sûr d'être en a
    tri(b, c); // trier les deux restants
}