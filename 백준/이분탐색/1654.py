import sys


input = sys.stdin.readline

n, k = map(int,input().split())
nums = [int(input()) for _ in range(n)]
start,end = 1,max(nums)

while start<=end:
    lans=0
    mid = (end+start)//2

    for i in nums:
        lans+=i//mid

    if lans<k:
        end = mid-1
    else:
        start = mid+1

print(end)
