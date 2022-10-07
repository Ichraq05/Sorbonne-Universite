import random

def sujet(n: int) -> str:
    # On utilise une liste pour stocker les mots
    mots = ["Le chat", "Le chien", "Dagobert", "La voisine", "Annie", "L'ordinateur"]
    return mots[n-1]  # n est entre 1 et 6, l'indice entre 0 et 5

def verbe(n: int) -> str:
    mots = ["mange", "regarde", "detruit", "adore", "fabrique", "chasse"]
    return mots[n-1]

def cod(n: int) -> str:
    mots = ["une pomme", "un nuage", "du chocolat", "des escargots", "une enclume", "la lune"]
    return mots[n-1]

def lieu(n: int) -> str:
    mots = ["dans la cuisine", "dans la foret", "a Paris", "sur le toit", "en Allemagne", "au milieu d'un lac"]
    return mots[n-1]

def phrase(s: int, v: int, c: int, l: int) -> str:
    # Concaténation simple des morceaux
    return sujet(s) + " " + verbe(v) + " " + cod(c) + " " + lieu(l) + "."

def de6() -> int:
    # random() donne un float entre 0.0 et 1.0. On adapte pour avoir un entier [1,6]
    return int(random.random() * 6) + 1

def phrase_aleatoire() -> str:
    return phrase(de6(), de6(), de6(), de6())