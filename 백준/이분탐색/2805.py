import sys


input = sys.stdin.readline

n, k = map(int,input().split())
trees = list(map(int,input().split()))

start,end = 1,max(trees)

while start<end:
    mid = (end-start)//2

    lens = 0

    for tree in trees:

        value = tree-mid
        if value>0:
            lens+=value
        if value>k:
            break
    if lens<k:
        end = mid-1
    else:
        start = mid +1
