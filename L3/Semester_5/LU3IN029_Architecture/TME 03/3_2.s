.data 

.text 
	ori $2, $0, 5
	syscall
	add $9, $0, $2
	ori $2, $0, 5
	syscall
	add $10, $0, $2
	div $9, $10

	mflo $11
	mfhi $12

	mult $11, $10
	mflo $14
	addu $13, $14, $12

	or $4, $0, $13

	ori $2, $0, 1
	syscall
