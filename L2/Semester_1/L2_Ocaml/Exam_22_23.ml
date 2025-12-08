(*EXERCICE 1*)

(*_____________________________QUESTION 3_________________________________*)

let rec comp_bin (l : bin) (n : int) : bin = 
  match l,n with
  |[],0 -> l
  |[],n -> false :: (comp_bin [](n-1))
  |h :: t,n -> if n=0 then raise (Invalid_argument "comp_bin")
                else h :: (comp_bin t (n-1))

