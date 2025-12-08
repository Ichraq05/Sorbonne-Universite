#!/bin/bash

# Vérifier s'il y a au moins un paramètre 
if [ $# -lt 1 ]; then
    echo "Il manque un ou plusieurs paramètres"
    echo "Usage : ./pere.sh <nb_fils>"
    exit 1 
fi

# Nombre de fils passé en paramètre
nb_fils="$1"

echo "Je suis le père (PID $$)"

# Initialiser un compteur
compteur=1

# Boucle pour créer le nombre voulu de processus fils
while [ "$compteur" -le "$nb_fils" ]; do
    ./fils.sh "$compteur" &
    compteur=$((compteur + 1))
done

wait

echo "Toutes les exécutions de fils.sh sont terminées"

