import sys


input = sys.stdin.readline

n, k = map(int,input().split())
trees = list(map(int,input().split()))

start,end = 1,max(trees)

while start<=end:
    lens = 0
    mid = (end+start)//2

    for tree in trees:
        if mid<tree:
            lens+=tree-mid
        if lens>k:
            break
    if lens>=k:
        start = mid +1
    else:
        end = mid - 1


print(end)