(*_____________________________QUESTION 1_________________________________
Pour créer un environnement E1 où la liaison (y, 6) est incluse,
définissez une variable y avec la valeur 6 dans l'environnement courant.
*)


(*_____________________________QUESTION 2_________________________________*)

let y = 6 in
let foo(x : int) : int =
  x + y

(*2e Methode*)
let y = 6 in
let foo(x : int) : int =
  x + y in
foo


(*_____________________________QUESTION 3_________________________________*)

let z = foo(4);;

(*2e Methode*)
let y = 6 in
let foo(x : int) : int =
  x + y in
foo 4


(*_____________________________QUESTION 4/5_________________________________*)

let y = 18 in
let foo(x : int) : int = 
  x + y in
foo 4


(*_____________________________QUESTION 6_________________________________

Voici un exemple en OCaml qui illustre la portée statique (portée lexicale) lors de l'application d'une fonction à un argument :

```
let x = 10 in
let my_function y = x + y in

let x = 5 in (* Redéfinition de x *)

let result = my_function 3 in
print_int result;
```

Dans cet exemple, nous avons deux déclarations de la variable `x`. 
Cependant, la fonction `my_function` a été définie dans un environnement où `x` vaut 10. 
Lorsque nous appelons `my_function 3`, elle utilise la valeur de `x` de l'environnement de sa définition, c'est-à-dire 10,
et le résultat affiché est `13`, pas `8` (qui serait la valeur de `x` dans le second environnement).

Cela montre que la portée statique signifie que la fonction se souvient de la valeur de `x` au moment de sa définition,
même si `x` est redéfini dans un autre contexte.
*)

