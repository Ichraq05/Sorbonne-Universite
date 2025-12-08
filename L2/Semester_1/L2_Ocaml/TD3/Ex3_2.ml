(*_____________________________QUESTION 1_________________________________*)

let add_fst (c : (int * int)) : (int * int) =
  match c with
  | (x,y) -> (x+1,y)


let add_snd (c : (int * int)) : (int * int) =
  match c with
  | (x,y) -> (x,y+1)


let rec nb_of (l : char list) : int * int =
  match l with
  | [] -> (0,0)
  | h :: t -> if h = '<' then add_fst(nb_of t)
              else add_snd(nb_of t)

let x = (nb_of []);;
let x = (nb_of ['<';'<';'>';'<';'>';'>';'<']);;

(*_____________________________QUESTION 2_________________________________*)

let rec o_sup_f (l : char list) : bool =
  match nb_of(l) with
  | (x,y) -> x >= y

let x = (o_sup_f ['<';'<';'>';'<';'>';'>';'<']);;
let x = (o_sup_f ['<';'>';'<';'>';'>']);;
let x = (o_sup_f ['<';'<';'>';'>']);;


let rec all_o_sup_f (l : (char list) list) : bool =
  List.for_all (o_sup_f) l

let x = (all_o_sup_f []);;
let x = (all_o_sup_f [['<';'<';'>';'>']; ['<';'<';'>';'<';'>';'>';'<']]);;
let x = (all_o_sup_f [['<';'<';'>';'>']; ['<';'>';'<';'>';'>']]);;
