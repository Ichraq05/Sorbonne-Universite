let rec sum_chiffres(n : int) : int =
    if n<11 then 
    n
    else 
    n-((n/10)*10) + sum_chiffres(n/10)

let x = sum_chiffres 456

let rec nb_chiffres (b : int) : int =
    if n<11 then 
    n
    else n-((n/10)*10)
    1 + sum_chiffres(n/10)

let x = sum_chiffres 456
    