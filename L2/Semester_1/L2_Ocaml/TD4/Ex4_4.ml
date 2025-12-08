(*_____________________________QUESTION 1_________________________________*)

type value = B of bool | I of int

(*_____________________________QUESTION 2_________________________________*)

exception TYPE_ERROR of int

let not1 (v : value) : value =
  match v with 
  |B b-> B (not b)
  |I n -> raise (TYPE_ERROR n)

let x = not1 (B true);;
let x = not1 (I 4);;

(*_____________________________QUESTION 3_________________________________*)

let not2 (v : value) : value =
  match v with
  |B b -> not1 (B b)
  |I n -> not1 (B (n != 0))

let x = not2 (B true);;
let x = not2 (I 4);;
let x = not2 (I 0);;

(*_____________________________QUESTION 4_________________________________*)

exception DIV_BY_0 of int

let div1 (v1:value) (v2:value) : value =
  match v1,v2 with
  |(B b),_ -> raise (Invalid_argument "div")
  |_,(B b) -> raise (Invalid_argument "div")
  |(I n1),(I n2) -> if n2 = 0 then raise(DIV_BY_0 n1)
                    else (I (n1/n2))

let x = div1 (I 6) (I 3);;
let x = div1 (I 6) (I 0);;
let x = div1 (B false) (I 4);;
let x = div1 (B false) (I 0);;


(*_____________________________QUESTION 5_________________________________*)

let div2 (v1:value) (v2:value) : value option = 
  try
    match div1 v1 v2 with
    | I result -> Some (I result)
    | _ -> None 
  with
  | DIV_BY_0 _ -> None
  | Invalid_argument x -> raise (Invalid_argument x)
  
let x = div2 (I 6) (I 3);;
let x = div2 (I 6) (I 0);;
let x = div2 (B false) (I 4);;
let x = div2 (B false) (I 0);;

