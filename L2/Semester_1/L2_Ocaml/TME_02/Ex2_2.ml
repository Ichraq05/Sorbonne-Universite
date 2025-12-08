(*_____________________________QUESTION 1_________________________________*)

let genere_list (n : int) : int list =
  if n <= 2 then
    []
  else 
    range_inter 2 n


let x = genere_list 1;;
let x = genere_list 4;;

(*_____________________________QUESTION 2_________________________________*)

let rec elimine (l : int list) (n : int) : int list =
  match l with
  | [] -> []
  | h :: t -> if h mod n = 0 then elimine t n  (* Si x est un multiple de n, ignorer x et continuer avec le reste de la liste. *)
              else h :: elimine t n  (* Sinon, conserver x et continuer avec le reste de la liste. *)

let x = elimine [1; 2; 3; 4; 5; 6] 3;;


(*_____________________________QUESTION 3_________________________________*)

let rec ecreme (l : int list) : int list =
  match l with
  | [] -> []
  | h :: t -> h :: ecreme (elimine t h)

let x = ecreme [2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12];;


(*_____________________________QUESTION 4_________________________________*)

let crible (n : int) : int list =
  ecreme(genere_list n)

let x = (crible 1);;
let x = (crible 20);;