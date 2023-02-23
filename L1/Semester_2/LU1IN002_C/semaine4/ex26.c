// Q1 Prototype
int* fusion(int tab1[], int t1, int tab2[], int t2);

// Q2
int* fusion(int tab1[], int t1, int tab2[], int t2) {
    int *res = malloc((t1 + t2) * sizeof(int));
    int i1 = 0, i2 = 0, i = 0;
    
    while (i1 < t1 && i2 < t2) {
        if (tab1[i1] < tab2[i2]) res[i++] = tab1[i1++];
        else res[i++] = tab2[i2++];
    }
    // Finir les restes
    while (i1 < t1) res[i++] = tab1[i1++];
    while (i2 < t2) res[i++] = tab2[i2++];
    
    return res;
}