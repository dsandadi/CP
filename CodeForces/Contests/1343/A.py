'''

                            Online Python Interpreter.
                Code, Compile, Run and Debug python program online.
Write your code in this editor and press "Run" button to execute it.

'''
import math
T = int(input())

while T > 0:
    n = int(input())
    k = 2
    while n % (math.pow(2, k) - 1):
        k += 1
    print(int(n/(math.pow(2, k) - 1)))
    
    T -= 1
