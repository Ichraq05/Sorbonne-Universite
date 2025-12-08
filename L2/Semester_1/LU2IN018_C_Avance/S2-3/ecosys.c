#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ecosys.h"

/* Parametres globaux de l’ecosysteme (externes dans le ecosys.h)*/
float p_ch_dir=0.3; //probabilite de changer de direction de deplacement
float p_reproduce_proie=0.2;
float p_reproduce_predateur=0.05;
int temps_repousse_herbe=-15;

/* PARTIE 1*/
/* Fourni: Part 1, exercice 4, question 2 */
Animal *creer_animal(int x, int y, float energie) {
  Animal *na = (Animal *)malloc(sizeof(Animal));
  assert(na);
  na->x = x;
  na->y = y;
  na->energie = energie;
  na->dir[0] = rand() % 3 - 1;
  na->dir[1] = rand() % 3 - 1;
  na->suivant = NULL;
  return na;
}


/* Fourni: Part 1, exercice 4, question 3 */
Animal *ajouter_en_tete_animal(Animal *liste, Animal *animal) {
  assert(animal);
  assert(!animal->suivant);

  // Ajoute l'animal en tête de liste
  animal->suivant = liste;
  return animal;
}

/* A faire. Part 1, exercice 6, question 2 */
void ajouter_animal(int x, int y,float energie, Animal **liste_animal) {
  // Vérifie que les coordonnées x et y sont positives et inférieures à SIZE_X et SIZE_Y 
  assert(x >= 0 && x < SIZE_X);
  assert(y >= 0 && y < SIZE_Y);

  // Crée un nouvel animal avec les coordonnées x, y
  Animal *nv_animal = creer_animal(x, y, energie);

  // Ajoute le nouvel animal en tête de la liste chaînée 
  nv_animal->suivant = *liste_animal;
  *liste_animal = nv_animal; // Avec cette ligne, nv_animal est le premier élément de la liste chaînée. 
}


/* A Faire. Part 1, exercice 5, question 5 */
void enlever_animal(Animal **liste, Animal *animal) {
  // Vérifie si la liste est vide
  if (*liste == NULL) {
    return; // Rien à faire si la liste est vide
  }

  // Si l'animal à supprimer est le premier de la liste
  if (*liste == animal) {
    // Met à jour la tête de liste pour sauter le premier animal
    *liste = animal->suivant;
    // Libère la mémoire de l'animal à supprimer
    free(animal);
    return;
  }

  /* Si l'animal à supprimer n'est pas le premier de la liste,
  Recherche de l'animal précédent */
  Animal *precedent = *liste;
  while (precedent && precedent->suivant != animal) {
    precedent = precedent->suivant;
  }

  // Si on a trouvé l'animal précédent, on met à jour les pointeurs
  if (precedent) {
    // MAJ des pointeurs pour sauter l'animal à supprimer
    precedent->suivant = animal->suivant;
    // Libère la mémoire de l'animal à supprimer
    free(animal);
  }
}


/* A Faire. Part 1, exercice 6, question 7 */
Animal* liberer_liste_animaux(Animal *liste) {
    while (liste) {
        Animal *temp = liste;  // Stocke l'élément actuel
        liste = liste->suivant;  // Avance dans la liste
        free(temp);  // Libère l'élément actuel
    }
    return NULL;
}

/* Fourni: part 1, exercice 4, question 4 */
unsigned int compte_animal_rec(Animal *la) {
  if (!la) return 0;
  return 1 + compte_animal_rec(la->suivant);
}

/* Fourni: part 1, exercice 4, question 4 */
unsigned int compte_animal_it(Animal *la) {
  int cpt=0;
  while (la) {
    ++cpt;
    la=la->suivant;
  }
  return cpt;
}



/* Part 1. Exercice 5, question 1, ATTENTION, ce code est susceptible de contenir des erreurs... */
void afficher_ecosys(Animal *liste_proie, Animal *liste_predateur) {
  unsigned int i, j;
  char ecosys[SIZE_X][SIZE_Y];
  Animal *pa=NULL;

  /* on initialise le tableau */
  for (i = 0; i < SIZE_X; ++i) {
    for (j = 0; j < SIZE_Y; ++j) {
      ecosys[i][j]=' ';
    }
  }
  /* on ajoute les proies */
  pa = liste_proie;
  while (pa) {
    /*assert(pa->x < SIZE_X && pa->y <SIZE_Y );*/ //Pour verifier que ca reste dans les limtes du monde
    if (pa->x >= 0 && pa->y >= 0 && pa->x < SIZE_X && pa->y < SIZE_Y) {
      ecosys[pa->x][pa->y] = '*';
    }
    pa = pa->suivant;
  }

  /* on ajoute les predateurs */
  pa = liste_predateur;
  while (pa) {
    /*assert(pa->x < SIZE_X && pa->y <SIZE_Y );*/ //Pour verifier que ca reste dans les limtes du monde
    if (pa->x >= 0 && pa->y >= 0 && pa->x < SIZE_X && pa->y < SIZE_Y) {
      if ((ecosys[pa->x][pa->y] == '@') || (ecosys[pa->x][pa->y] == '*')) {
        ecosys[pa->x][pa->y] = '@';
      } else {
        ecosys[pa->x][pa->y] = 'O';
      }
    }
    pa = pa->suivant;
  }


  /* on affiche le tableau */
  printf("+");
  for (j = 0; j < SIZE_Y; ++j) {
    printf("-");
  }  
  printf("+\n");
  for (i = 0; i < SIZE_X; ++i) {
    printf("|");
    for (j = 0; j < SIZE_Y; ++j) {
      putchar(ecosys[i][j]);
    }
    printf("|\n");
  }
  printf("+");
  for (j = 0; j<SIZE_Y; ++j) {
    printf("-");
  }
  printf("+\n");
  int nbproie=compte_animal_it(liste_proie);
  int nbpred=compte_animal_it(liste_predateur);
  
  printf("Nb proies : %5d\tNb predateurs : %5d\n", nbproie, nbpred);

}

void clear_screen() {
  printf("\x1b[2J\x1b[1;1H");  /* code ANSI X3.4 pour effacer l'ecran */
}

/* PARTIE 2*/

/* A Faire */
void ecrire_ecosys(const char *nom_fichier, Animal *liste_predateur, Animal *liste_proie){

  //on ouvre le fichier en mode ecriture
  FILE *file = fopen(nom_fichier, "w");

  //on y ecrit
  fprintf(file, "<proies>\n");
  Animal * l1 = liste_proie;
  while(l1){
    fprintf(file, "x=%d y=%d dir=[%d %d] e=%f\n",l1->x,l1->y,l1->dir[0],l1->dir[1],l1->energie);
    l1=l1->suivant;
  }
  fprintf(file, "</proies>\n<predateurs>\n");
  Animal * l2 = liste_predateur;
  while(l2){
    fprintf(file, "x=%d y=%d dir=[%d %d] e=%f\n",l2->x,l2->y,l2->dir[0],l2->dir[1],l2->energie);
    l2=l2->suivant;
  }
  fprintf(file, "</predateurs>\n");

  fclose(file);
}

/* A Faire */
void lire_ecosys(const char *nom_fichier, Animal **liste_predateur, Animal **liste_proie){

  //on ouvre le fichier en mode lecture
  FILE *file = fopen(nom_fichier, "r");

  //en cas d'erreur
  if (file == NULL) {
    printf("erreur fichier non ouvrable (ou non existant).\n");
    return;
  }

  //une variable pour indiquer si le fichier est vide
  int vide = 1;

  char line[200]; 

  while (fgets(line, sizeof(line), file) != NULL) {

    //on est entré dans la boucle donc le fichier n'est pas vide
    vide = 0;
    if (strcmp(line, "<proies>\n") == 0){
      while (fgets(line, sizeof(line), file) != NULL && strcmp(line, "</proies>\n") != 0){
        int x,y,dx,dy;
        float energie;
        sscanf(line, "x=%d y=%d dir=[%d %d] e=%f\n", &x, &y, &dx, &dy, &energie);
        ajouter_animal(x,y,energie,liste_proie);
        (*liste_proie)->dir[0]=dx;
        (*liste_proie)->dir[1]=dy;
      }
    }
    if (strcmp(line, "<predateurs>\n") == 0){
      while (fgets(line, sizeof(line), file) != NULL && strcmp(line, "</predateurs>\n") != 0){
        int x,y,dx,dy;
        float energie;
        sscanf(line, "x=%d y=%d dir=[%d %d] e=%f\n", &x, &y, &dx, &dy, &energie);
        ajouter_animal(x,y,energie,liste_predateur);
        (*liste_predateur)->dir[0]=dx;
        (*liste_predateur)->dir[1]=dy;
      }
    }
  }

  //si le fichier est vide
  if(vide){
    printf("le fichier %s est vide\n",nom_fichier);
  }

  fclose(file);
}

/* Part 2. Exercice 4, question 1 */
void bouger_animaux(Animal *la) {
    while (la) {  // Parcours de la liste des animaux tant que que c'est pas = NULL

        // Vérifie si l'animal change de direction avec une proba p_ch_dir
        if (rand() * 1.0 / RAND_MAX < p_ch_dir) {
            int old_dir_x = la->dir[0];
            int old_dir_y = la->dir[1];

            // Choisit une nouvelle direction différente de l'ancienne
            while (la->dir[0] == old_dir_x && la->dir[1] == old_dir_y) {
                // Génère une nouvelle direction en x : -1, 0 ou 1
                la->dir[0] = rand() % 3 - 1;

                // Génère une nouvelle direction en y : -1, 0 ou 1
                la->dir[1] = rand() % 3 - 1;
            }
        }

        // Met à jour les coordonnées en appliquant la direction (monde torique)
        la->x = (la->x + la->dir[0] + SIZE_X) % SIZE_X;
        la->y = (la->y + la->dir[1] + SIZE_Y) % SIZE_Y;

        // Vérifie que les coordonnées restent dans les limites du monde
        assert(la->x >= 0 && la->y >= 0 && la->x < SIZE_X && la->y < SIZE_Y);

        la = la->suivant;  // Passe à l'animal suivant dans la liste
    }
}


/* Part 2. Exercice 4, question 3 */
void reproduce(Animal **liste_animal, float p_reproduce) {
    // Vérifie si la liste d'animaux est valide et non vide
    if (liste_animal && *liste_animal) {
        // Pointeur vers le parent, commence par le premier animal de la liste
        Animal *parent = *liste_animal;

        // Parcours de la liste des animaux
        while (parent != NULL) {
            // Vérifie si le parent se reproduit avec une probabilité p_reproduce
            if (rand() * 1.0 / RAND_MAX < p_reproduce) {
                // Crée un nouvel animal à la position légèrement décalée du parent
                Animal *enfant = creer_animal(parent->x + 1, parent->y + 1, parent->energie / 2);

                // Divise l'énergie du parent par 2
                parent->energie /= 2;

                // Ajoute le nouvel animal en tête de la liste
                *liste_animal = ajouter_en_tete_animal(*liste_animal, enfant);
            }

            // Passe à l'animal suivant dans la liste
            parent = parent->suivant;
        }
    }
}


/* Part 2. Exercice 6, question 1 */
void rafraichir_proies(Animal **liste_proie, int monde[SIZE_X][SIZE_Y]) {
    // Les proies bougent
    bouger_animaux(*liste_proie);

    // Parcours la liste de proies
    Animal *proie = *liste_proie;
    Animal *proie_suivante;

    while (proie != NULL) {
        // Baisser l'énergie de la proie de 1 par déplacement
        proie->energie--;

        // Si la proie est sur une case avec de l'herbe, elle en mange
        if (monde[proie->x][proie->y] > 0) {
            proie->energie += monde[proie->x][proie->y];  // Gagne de l'énergie équivalent à la quantité d'herbe sur la case
            monde[proie->x][proie->y] = temps_repousse_herbe;  // Temps rénitialisé pour l'herbe
        }

        // Si l'énergie de la proie est <= à 0, on la supprime
        if (proie->energie <= 0) {
            proie_suivante = proie->suivant;
            enlever_animal(liste_proie, proie);
            proie = proie_suivante;
        } else {
            // Sinon, passer à la proie suivante dans la liste
            proie = proie->suivant;
        }
    }

    // Appel la fonction de reproduction des proies
    reproduce(liste_proie, p_reproduce_proie);
}


/* Part 2. Exercice 7, question 1 */
Animal *animal_en_XY(Animal *l, int x, int y) {
    while (l != NULL) {
        if (l->x == x && l->y == y) {
            // Une proie a été trouvée aux coordonnées (x, y)
            return l;
        }
        l = l->suivant;
    }
    
    // Aucune proie trouvée aux coordonnées (x, y)
    return NULL;
}

/* Part 2. Exercice 7, question 2 */
void rafraichir_predateurs(Animal **liste_predateur, Animal **liste_proie) {
    // Les prédateurs bougent
    bouger_animaux(*liste_predateur);

    // Parcours la liste de prédateurs
    Animal *predateur = *liste_predateur;
    Animal *predateur_suivant;

    while (predateur != NULL) {
        // Baisse l'énergie du prédateur de 1 par déplacement
        predateur->energie--;

        // Vérifie s'il y a une proie sur la même case que le prédateur
        Animal *proie_sur_case = animal_en_XY(*liste_proie, predateur->x, predateur->y);

        if (proie_sur_case != NULL) {
            // Le prédareur mange la proie et augmente son énergie, on supprime aussi la proie mangé
            predateur->energie += proie_sur_case->energie;
            enlever_animal(liste_proie, proie_sur_case);
        }

        // Si l'énergie du prédateur est <= à 0, on le supprime
        if (predateur->energie <= 0) {
            predateur_suivant = predateur->suivant;
            enlever_animal(liste_predateur, predateur);
            predateur = predateur_suivant;
        } else {
            // Sinon, passe au prédateur suivant dans la liste
            predateur = predateur->suivant;
        }
    }

    // Appel la fonction de reproduction des prédateurs
    reproduce(liste_predateur, p_reproduce_predateur);
}


/* Part 2. Exercice 5, question 2 */
void rafraichir_monde(int monde[SIZE_X][SIZE_Y]) {
    for (int i = 0; i < SIZE_X; ++i) {
        for (int j = 0; j < SIZE_Y; ++j) {
            monde[i][j]++;  // Incrémente la quantité d'herbe dans chaque case
        }
    }
}


