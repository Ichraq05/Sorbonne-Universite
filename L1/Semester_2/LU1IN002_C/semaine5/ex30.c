// Q2 Compression
int compress_tab(int tab_brut[], int tab_compress[]) {
    int i = 0, j = 0;
    while (tab_brut[i] != -1) {
        int val = tab_brut[i];
        int count = 1;
        while (tab_brut[i+1] == val) {
            count++;
            i++;
        }
        if (count >= 2) {
            tab_compress[j++] = count;
            tab_compress[j++] = val;
        } else {
            tab_compress[j++] = val;
        }
        i++;
    }
    tab_compress[j] = -1;
    return j;
}