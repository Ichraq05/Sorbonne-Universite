# Labyrinthe = Liste de colonnes. Case = (N, E, S, O, type)

def deplace(c: tuple[int, int], d: str) -> tuple[int, int]:
    x = c[0]
    y = c[1]
    if d == "N": return (x, y + 1)
    if d == "S": return (x, y - 1)
    if d == "E": return (x + 1, y)
    if d == "O": return (x - 1, y) # Ouest
    return c

def deplace_chemin(c: tuple[int, int], ch: list[str]) -> tuple[int, int]:
    # Version récursive
    if len(ch) == 0:
        return c
    else:
        # On fait un pas, et on continue avec le reste du chemin
        return deplace_chemin(deplace(c, ch[0]), ch[1:])

def deplace_possible(la: list[list], c: tuple[int, int], d: str) -> bool:
    x = c[0]
    y = c[1]
    largeur = len(la)
    hauteur = len(la[0])
    
    # On vérifie qu'on ne sort pas de la grille
    if x < 0 or x >= largeur or y < 0 or y >= hauteur:
        return False
        
    case = la[x][y] # (Nord, Est, Sud, Ouest, Type)
    
    # On vérifie si le mur est ouvert et si la case cible existe
    if d == "N": return case[0] and (y + 1 < hauteur)
    if d == "E": return case[1] and (x + 1 < largeur)
    if d == "S": return case[2] and (y - 1 >= 0)
    if d == "O": return case[3] and (x - 1 >= 0)
    return False

def chemin_possible(la: list[list], c: tuple[int, int], ch: list[str]) -> bool:
    if len(ch) == 0:
        return True
    
    if deplace_possible(la, c, ch[0]):
        # Si le pas est possible, on avance et on teste la suite
        return chemin_possible(la, deplace(c, ch[0]), ch[1:])
    return False

def est_solution(la: list[list], c: tuple[int, int], ch: list[str]) -> bool:
    x = c[0]
    y = c[1]
    
    # 1. On part d'une ENTREE
    if la[x][y][4] != "ENTREE":
        return False
        
    # 2. Le chemin ne prend pas de mur
    if not chemin_possible(la, c, ch):
        return False
        
    # 3. On arrive sur une SORTIE
    arrivee = deplace_chemin(c, ch)
    xa = arrivee[0]
    ya = arrivee[1]
    return la[xa][ya][4] == "SORTIE"