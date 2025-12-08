(*_____________________________QUESTION 1_________________________________*)

let rec add_freq (c : 'a) (l : ('a*int) list) : ('a*int) list = 
  match l with
  | [] -> [(c,1)]
  | (x,y) :: t -> if x=c then (x,y+1) :: t 
              else (x,y) :: add_freq c t

let x = (add_freq 'A' []);;            
let x = (add_freq 'A' [('D',1); ('E',1); ('A',5); ('B',3); ('C',1)]) ;;
let x = (add_freq 'H' [('D',1); ('E',1); ('A',5); ('B',3); ('C',1)]) ;;


(*_____________________________QUESTION 2_________________________________*)

let rec freq (l : 'a list) : ('a * int) list =
  match l with
  | [] -> []
  | h :: t -> add_freq h (freq t)

let x = freq ['A';'A';'B';'A';'C';'B';'A';'G';'H';'A';'A';'F';'E';'A';'D';'B';'A'];;