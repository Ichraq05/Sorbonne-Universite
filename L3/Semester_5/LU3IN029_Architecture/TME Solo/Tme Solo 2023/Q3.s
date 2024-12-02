.data

.text

est_palin:
	addiu $29, $29, -12 #$31 + 2 variable local
	sw $31, 8($29)
	
	sw $7, 0($29) # idx_deb
	sw $6, 4($29) # idx_fin
	addiu $6, $5, 0 
	
	while:
	
	slt $8, $6, $7 # 1 si idx_fin < idx_dbt
	bne $8, $0, fin_while
	
	#if
	add $11, $4, $7 # adresse str+idx_deb
	add $12, $4, $6 # adresse str+idx_fin
	lb $13, 0($11)
	lb $14, 0($12)

	bne $13, $14, alors
	
	#then
	addiu $7, $7, 1 #incremente idx_deb
	addiu $6, $6, -1 #incremente idx_fin
	
	j while
	
	alors:
	ori $2, $0, 0 #return 0
	j fin
	
	fin while:
	ori $2,$0, 1 #return 1
	
	fin:
	lw $31, 8($29)
	addiu $29, $29, 12
	jr $31