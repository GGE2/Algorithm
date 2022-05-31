import sys



n = int(sys.stdin.readline())
matrix = []


for _ in range(n):
    x,y = map(int,sys.stdin.readline().split())
    matrix.append((x,y))

matrix.sort(key = lambda x:(x[0],x[1]))

for va in matrix:
    print(f'{va[0]} {va[1]}')

