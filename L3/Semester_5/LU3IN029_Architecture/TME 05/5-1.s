.data	
	.align 2
	p: .space 4
	
	.align 2
	q: .space 4

.text
	lui $7, 0x1001
	lw $8, 0($7)
	lw $9, 4($7)
	
	ori $2, $0, 5
	syscall
	add $8, $0, $2
	
	ori $2, $0, 5
	syscall
	add $9, $0, $2
	
	xor, $11, $11, $11
	
	for:
	slt $10, $8, $9 #si p < q, $10 vaut 1
	beq $10, $0, suite
	
	add $11, $11, $8
	addi $8, $8, 1
	sw $8, 0($7)
	j for
	
	suite:
	ori $2, $0, 1
	or $4, $0, $11
	syscall
	
	ori $2, $0, 10
	syscall
	
	
	
	
	
	
	
	
	
	