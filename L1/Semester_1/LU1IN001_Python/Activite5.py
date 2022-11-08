# Un polynôme est une liste [a0, a1, a2...] correspondant à a0 + a1*X + ...

def degre(p: list[int]) -> int:
    d = 0
    # On cherche le plus grand indice avec un coefficient non nul
    for i in range(len(p)):
        if p[i] != 0:
            d = i
    return d

def somme(p1: list[int], p2: list[int]) -> list[int]:
    res = []
    # On parcourt jusqu'à la longueur maximale
    max_len = max(len(p1), len(p2))
    for i in range(max_len):
        val1 = 0
        val2 = 0
        if i < len(p1):
            val1 = p1[i]
        if i < len(p2):
            val2 = p2[i]
        res.append(val1 + val2)
    return res

def normalise(p: list[int]) -> list[int]:
    # On coupe la liste après le dernier coefficient non nul
    d = degre(p)
    # Cas particulier du polynôme nul ou vide
    if len(p) == 0 or (d == 0 and p[0] == 0):
        return []
    return p[:d+1]

def produit(p1: list[int], p2: list[int]) -> list[int]:
    if len(p1) == 0 or len(p2) == 0:
        return []
        
    # La taille du résultat est la somme des degrés + 1
    taille = (len(p1) - 1) + (len(p2) - 1) + 1
    res = [0] * (taille + 1)
    
    # Double boucle classique pour la distribution
    for i in range(len(p1)):
        for j in range(len(p2)):
            res[i+j] = res[i+j] + (p1[i] * p2[j])
            
    return normalise(res)