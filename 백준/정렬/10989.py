import sys



n = int(sys.stdin.readline())
nums = [0]*10000

for _ in range(n):
    num = int(sys.stdin.readline())
    nums[num-1]+=1

for i in range(10000):
    if nums[i]!=0:
        for _ in range(nums[i]):
            print(i+1)