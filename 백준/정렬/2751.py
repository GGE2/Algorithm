import sys
n = int(input())
nums = []

for _ in range(n):
    num = int(sys.stdin.readline())
    nums.append(num)
nums.sort()
for i in nums:
    print(i)
