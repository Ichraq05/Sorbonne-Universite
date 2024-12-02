.data
	str: .space 20
	
.text 
	addiu $29, $29, -8 #2 variable local
	
	lui $4, 0x1001
	ori $5, $8, 20
	ori $2, $0, 8
	syscall
	
	lui $4, 0x1001
	jal len
	sw $2, 0($29)
	
	lui $4, 0x1001
	addu $5, $4, $2
	addiu $5, $5, -2
	jal est_palin
	sw $2, 4($29)
	
	lw $4, 4($29)
	ori $2, $0, 1
	syscall
	
	addiu $29, $29, 8
	ori $2, $0, 10
	syscall
	
len:


est_palin:
	
	 
	
	
	
	
	