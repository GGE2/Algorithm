import sys

n = int(sys.stdin.readline())
result=[]
i=666
while True:
    if '666' in str(i) or '6666' in str(i):
        result.append(i)
    i+=1
    if len(result)==n:
        break

print(result[n-1])