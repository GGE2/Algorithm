n = int(input())
nums = []

for _ in range(n):
    num = int(input())
    nums.append(num)
nums.sort()
for i in nums:
    print(i)