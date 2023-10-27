import random


def collatz(num):
    steps = 0
    while num != 1:
        print(num, end = " -> ")
        if num % 2 == 0:
            num = num // 2
        else:
            num = 3 * num + 1
        steps += 1
    print(f"1. \nFinished in {steps} steps\n")


def collatz_recursive(num, steps=0):
    if num == 1:
        print(f"1. \nFinished in {steps} steps\n")
    else:
        print(num, end=" -> ")
        if num % 2 == 0:
            collatz_recursive(num // 2, steps + 1)
        else:
            collatz_recursive(3 * num + 1, steps + 1)

if __name__ == '__main__':

    collatz(random.randint(2, 1000))
    collatz_recursive(random.randint(2, 1000))