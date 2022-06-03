import sys
from bisect import bisect_left,bisect_right

input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
nums.sort()
check_n = int(input())
check_nums = list(map(int,input().split()))

for num in check_nums:
    left = bisect_left(nums,num)
    right = bisect_right(nums,num)

    print(right-left,end=' ')