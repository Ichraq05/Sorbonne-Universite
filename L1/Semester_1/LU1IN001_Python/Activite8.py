def decompose_ligne(li: str, sep: str) -> list[str]:
    # On enlève le '\n' à la fin
    li_propre = li.strip()
    return li_propre.split(sep)

def enleve_guillemets(s: str) -> str:
    # Si la chaine commence et finit par ", on les retire
    if len(s) >= 2 and s[0] == '"' and s[-1] == '"':
        return s[1:-1]
    return s

def enleve_guillemets_ligne(li: list[str]) -> list[str]:
    res = []
    for elt in li:
        res.append(enleve_guillemets(elt))
    return res

def lignes_propres(lis: list[str], sep: str) -> list[list[str]]:
    res = []
    for ligne in lis:
        elements = decompose_ligne(ligne, sep)
        propres = enleve_guillemets_ligne(elements)
        res.append(propres)
    return res

def cherche_indice(e: str, li: list[str]) -> int:
    for i in range(len(li)):
        if li[i] == e:
            return i
    return None

def dictionnaire_compte(lis: list[list[str]], clef: str) -> dict:
    headers = lis[0]
    idx = cherche_indice(clef, headers)
    
    compte = {}
    # On commence à 1 pour sauter l'en-tête
    for i in range(1, len(lis)):
        ligne = lis[i]
        # Sécurité pour éviter les lignes vides
        if len(ligne) > idx:
            val = ligne[idx]
            if val in compte:
                compte[val] = compte[val] + 1
            else:
                compte[val] = 1
    return compte

def dictionnaire_somme(lis: list[list[str]], clef: str, valeur: str) -> dict:
    headers = lis[0]
    idx_clef = cherche_indice(clef, headers)
    idx_val = cherche_indice(valeur, headers)
    
    somme = {}
    for i in range(1, len(lis)):
        ligne = lis[i]
        if len(ligne) > max(idx_clef, idx_val):
            k = ligne[idx_clef]
            v = int(ligne[idx_val]) # Conversion en entier
            
            if k in somme:
                somme[k] = somme[k] + v
            else:
                somme[k] = v
    return somme