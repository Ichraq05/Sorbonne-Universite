(*_____________________________QUESTION 1_________________________________*)

let rec bin_to_int(i : int list) : int =
  match i with
  | [] -> raise (Invalid_argument "empty list")
  | [x] -> x 
  | h :: t -> h + 2 * (bin_to_int t)

let x=bin_to_int [0; 1; 1];;
let x=bin_to_int [1];;
let x=bin_to_int [1; 1; 0; 1; 0; 1];;


(*_____________________________QUESTION 2_________________________________*)

let rec int_to_bin(i : int) : int list =
  if i = 0 || i = 1 then
    [i]
  else 
    (i mod 2) :: int_to_bin (i/2)

let x = int_to_bin 0;;
let y = int_to_bin 6;;
let z = int_to_bin 1;;
let w = int_to_bin 43;;


(*_____________________________QUESTION 3_________________________________*)

let rec comp_bin (l : int list) (n : int) : int list =
  if n < List.length l then
    raise (Invalid_argument "empty list")
  else if n = List.length l then
    l
  else 
    comp_bin (l @ [0]) (n)

let x = comp_bin [1; 0] 2;;
let x = comp_bin [1; 0] 4;;
let x = comp_bin [0; 1; 1] 2;;