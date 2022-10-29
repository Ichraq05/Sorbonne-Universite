def est_minuscule(c: str) -> bool:
    return 'a' <= c <= 'z'

def est_majuscule(c: str) -> bool:
    return 'A' <= c <= 'Z'

def caractere_decale(c: str, n: int) -> str:
    if est_minuscule(c):
        # On ramène 'a' à 0, on décale, modulo 26, puis on remet 'a'
        return chr(ord('a') + (ord(c) - ord('a') + n) % 26)
    elif est_majuscule(c):
        return chr(ord('A') + (ord(c) - ord('A') + n) % 26)
    else:
        return c

def ligne_chiffre_cesar(s: str, n: int) -> str:
    res = ""
    for char in s:
        res = res + caractere_decale(char, n)
    return res

def ligne_dechiffre_cesar(s: str, n: int) -> str:
    # Déchiffrer c'est décaler de -n
    return ligne_chiffre_cesar(s, -n)

def chiffre_fichier_cesar(nom: str, n: int) -> None:
    with open(nom + ".txt", "r") as f_in:
        with open(nom + "-cesar.txt", "w") as f_out:
            for ligne in f_in.readlines():
                f_out.write(ligne_chiffre_cesar(ligne, n))

def dechiffre_fichier_cesar(nom: str, n: int) -> None:
    with open(nom + "-cesar.txt", "r") as f_in:
        with open(nom + "-clair.txt", "w") as f_out:
            for ligne in f_in.readlines():
                f_out.write(ligne_dechiffre_cesar(ligne, n))