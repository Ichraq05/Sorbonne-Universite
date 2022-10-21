# Fonction fournie pour l'exercice
def divise(k: int, n: int) -> bool:
    return n % k == 0

def est_parfait_simulee(n: int) -> bool:
    print("=== Evaluation de : 'est_parfait_simulee(" + str(n) + ")' ===")
    s = 0
    i = 1
    print("debut de boucle, s = " + str(s) + " i = " + str(i))
    print("======================")
    
    while i != n:
        if divise(i, n):
            s = s + i
        
        print("fin du tour " + str(i))
        print("s = " + str(s))
        print("i = " + str(i+1)) # i vaudra i+1 au début du prochain tour
        print("=============")
        
        i = i + 1
        
    print("sortie de boucle, s = " + str(s) + " et n = " + str(n))
    return n == s