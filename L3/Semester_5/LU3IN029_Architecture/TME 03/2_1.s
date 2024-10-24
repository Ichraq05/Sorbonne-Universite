.data 

.text 
ori $8, $0, 137
ori $2, $0, 1
or $4, $0, $8
syscall

ori $8, $0, 65534
or $4, $0, $8
syscall
