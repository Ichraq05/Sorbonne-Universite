#!/bin/bash
echo "Je suis le père (PID $$)"

# Boucle pour répété dix exécutions de fils.sh
for i in {1..10}; do
    ./fils.sh
done

wait

echo "Toutes les exécutions de fils.sh sont terminées"
