.data 
	ch: .asciiz "123456"
	tab: .byte 0x31,0x32,0x33,0x34,0x35,0x36

.text 
	lui $8, 0x1001
	lw $9, 0($8)
	
	or $4,$0,$8
	ori $2, $0, 4
	#syscall
	
	ori $2, $0, 11
	or $4, $0, $9
	#syscall
	
	lb $16, 2($8)
	ori $2, $0, 1
	or $4, $0, $16
	#syscall
	
	lb $17, 2($8)
	ori $2, $0, 11
	or $4, $0, $17
	syscall
	
	ori $2, $0, 10
	syscall
	
