import math

# Point = (x, y) et Courbe = liste de Points

def longueur_courbe(c: list[tuple[float, float]]) -> float:
    dist_totale = 0.0
    # On relie le point i au point i+1
    for i in range(len(c) - 1):
        p1 = c[i]
        p2 = c[i+1]
        # Formule de la distance euclidienne
        dist = math.sqrt((p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)
        dist_totale = dist_totale + dist
    return dist_totale

def deplace(p: tuple[float, float], d: str, dist: float) -> tuple[float, float]:
    x = p[0]
    y = p[1]
    if d == "H": return (x, y + dist)
    if d == "B": return (x, y - dist)
    if d == "D": return (x + dist, y)
    if d == "G": return (x - dist, y)
    return p

def spirale(ori: tuple[float, float], dec: float, n: int) -> list[tuple[float, float]]:
    points = [ori]
    courant = ori
    directions = ["D", "H", "G", "B"]
    
    for i in range(1, n + 1):
        # Choix de la direction (cycle D, H, G, B)
        dir_idx = (i - 1) % 4
        direction = directions[dir_idx]
        
        # La distance augmente à chaque étape
        distance = i * dec
        
        nouveau = deplace(courant, direction, distance)
        points.append(nouveau)
        courant = nouveau
        
    return points