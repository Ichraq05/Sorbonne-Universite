#define N 3
// Q1
void init(char plateau[N][N]) {
    for(int i=0; i<N; i++)
        for(int j=0; j<N; j++)
            plateau[i][j] = '_';
}

// Q3
void jouer(char plateau[N][N], int joueur) {
    char pion = (joueur == 0) ? 'X' : 'O';
    int x, y;
    do {
        printf("Joueur %d (L C) : ", joueur);
        scanf("%d %d", &x, &y);
    } while (x < 0 || x >= N || y < 0 || y >= N || plateau[x][y] != '_');
    plateau[x][y] = pion;
}