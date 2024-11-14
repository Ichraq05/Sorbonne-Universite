.data
	val: .word 15
	tab: .word 1, 20, 7, 6, 14, 9, 30, 22, -1

.text
	lui $8, 0x1001
	addiu $9, $8, 4
	
	xor $12, $12, $12
	
while:
	lw $10, 0($8)
	lw $12, 0($9)
	addiu $9, $9, 4
	bltz $9, suite
	
	slt $11, $12, $10
	beq $11, $0, else
	
	addiu $12, $12, 1
	
	else:
	j while
	
suite:
	or $4, $0, $12
	ori $2, $0, 1
	syscall
	
	ori $2, $0, 10
	syscall
