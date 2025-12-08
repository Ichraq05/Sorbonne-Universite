# Makefile personnalisé de l'exercice 3, TD 1, Q.5

CC = gcc
CFLAGS = -Wall -Wextra
LDFLAGS =

all: test_ecosys ecosys

test_ecosys: main_tests.o ecosys.o
	$(CC) $(CFLAGS) $^ -o $@ $(LDFLAGS)

ecosys: main_ecosys.o ecosys.o
	$(CC) $(CFLAGS) $^ -o $@ $(LDFLAGS)

main_tests.o: main_tests.c ecosys.h
	$(CC) $(CFLAGS) -c $<

main_ecosys.o: main_ecosys.c ecosys.h
	$(CC) $(CFLAGS) -c $<

ecosys.o: ecosys.c ecosys.h
	$(CC) $(CFLAGS) -c $<

clean:
	rm -f test_ecosys ecosys *.o

.PHONY: all clean
