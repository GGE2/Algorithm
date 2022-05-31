import sys

n = int(sys.stdin.readline())
compare = []
result = [0 for _ in range(n)]

for _ in range(n):
    h, t = map(int, sys.stdin.readline().split())
    compare.append((h,t))


for i in range(n-1):
    for j in range(i + 1,n):
        if compare[i][0] < compare[j][0] and compare[i][1] < compare[j][1]:
            result[i] += 1
        if compare[i][0]>compare[j][0] and compare[i][1] > compare[j][1]:
            result[j]+=1
for i in result:
    print(i+1)