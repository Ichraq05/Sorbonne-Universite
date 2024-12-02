.data
	str: .asciiz "abcba"
	ok: .asciiz "oui"
	ko: .asciiz "non"
	
.text
	addiu $29, $29, -16 #2 param et 2 variable local
	lui $4, 0x1001 #str
	j len
	sw $2, 0($29) #recupere la valeur de retour dans n
	
	lui $4, 0x1001
	ori $5, $2, 0
	j est_palin
	sw $2, 4($29)#recupere la valeur de retour dans res
	
	#if
	ori $7, $0, 1
	bne $5,$0, then # if res ==1 alors, sinon
	
	lui $4, 0x1001
	lw $6, 4($4)  
	ori $2, $0, 5
	syscall #affiche ok
	
	j aff
	
	then:
	lw $7, 8($4)
	ori $2, $0, 5
	syscall #affiche ko
	
	aff:
	
	addiu $29, $29, 16
	ori $2, $0, 10
	syscall
	
len:
	addiu $29, $29, 0
	sw $31, 0($29)
	lw $31, 0($29)
	addiu $29, $29, 0
	jr $31

est_palin:
	addiu $29, $29, 0
	sw $31, 0($29)
	lw $31, 0($29)
	addiu $29, $29, 0
	jr $31
	
	
	
	
	
	
	
	
	