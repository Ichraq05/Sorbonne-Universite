.data
	   .align 2
	a: .space 4
	
	   .align 2
	b: .space 4

.text
	lui $7, 0x1001
	lw $8, 0($7)
	lw $9, 4($7)
	
	ori $2, $0, 5
	syscall
	or $8, $0, $2
	
	ori $2, $0, 5
	syscall
	or $9, $0, $2
	
	while:
	beq $8, $9, suite
	
	#if
	slt $11, $9, $8
	beq $11, $0, else
	
	sub $8, $8, $9
	sw $8, 0($7)
	
	j while
	
	else:
	
	sub $9, $9, $8
	sw $9, 4($7)
	j while
	
	suite:
	
	ori $2, $0, 1
	or $4, $0, $8
	syscall
	
	ori $2, $0, 10
	syscall
	
	
	
	
	
	
	

