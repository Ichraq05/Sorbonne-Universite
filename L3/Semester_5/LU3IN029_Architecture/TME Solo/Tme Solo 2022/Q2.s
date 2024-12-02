.data

.text

len:
	addiu $29, $29, -8
	
	sw $31, 4($29) # variable c
	
	
	while:
	
	lui $4, 0x1001
	addu $5, $4, 0 # &str
	ori $6, $0, 0x0 # le 0x0 a la fin
	beq $6, $0, suite
	
	addiu $4 , $, 1
	addiu $31, $31, 1
	
	j while
	
	suite:
	lw $31, 4($29)
	addiu $29, $29, 8
	jr $31
	