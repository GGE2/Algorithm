import sys
from collections import Counter

n = int(sys.stdin.readline())
nums=[]

for _ in range(n):
    num = int(sys.stdin.readline())
    nums.append(num)

nums.sort()

print(round(sum(nums)/n))
print(nums[(n-1)//2])
cnt = Counter(nums).most_common(2)
if len(cnt)>1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])

print(nums[n-1]-nums[0])
