.data

.text

len:
	addiu $29, $29, -8 #$31 + 1 variable local
	sw $31, 4($29)
	sw $0, 0($29) # ini c
	
	xor $2, $2, $2
	
	while:
	addi $6, $0, $4 # &str[c]
	lb $7, 0($6) # str[c]
	ori $8, $0, "\0"
	beq $7, $8, fin_while
	
	addiu $2, $2, 1 #incremente c
	
	j while
	
	fin_while:
	or $4, $2, $0
	ori $2, $0, 1
	syscall
	
	lw $31, 4($29)
	addiu $29, $29, 8
	jr $31