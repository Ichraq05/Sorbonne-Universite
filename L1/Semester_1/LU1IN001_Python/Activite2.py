import math

def terme_leibniz(n: int) -> float:
    return ((-1)**n) / (2*n + 1)

def somme_leibniz(n: int) -> float:
    somme = 0.0
    for i in range(n):
        somme = somme + terme_leibniz(i)
    return somme

def approx_leibniz(n: int) -> float:
    # On multiplie par 4 car la somme vaut pi/4
    return 4 * somme_leibniz(n)

# Jeu de test (assert avec une tolérance pour les flottants)
assert terme_leibniz(0) == 1
assert abs(approx_leibniz(100) - math.pi) < 0.01