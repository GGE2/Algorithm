import sys



n = int(sys.stdin.readline())
matrix = []


for _ in range(n):
    age,name = sys.stdin.readline().split()
    matrix.append((age,name))

matrix.sort(key = lambda x:x[0])

for va in matrix:
    print(f'{va[0]} {va[1]}')