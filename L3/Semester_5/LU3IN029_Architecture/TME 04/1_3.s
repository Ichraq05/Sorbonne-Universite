.data
	o1: .byte 0x31
	o2: .byte 0x32
	o3: .byte 0x33
	o4: .byte 0x34

	mot1 : .word 0xAABBCCDD

.text
	lui $8, 0x1001
	lw $9, 0($8)
	lw $10, 4($8)

	ori $2, $0, 10
	syscall
