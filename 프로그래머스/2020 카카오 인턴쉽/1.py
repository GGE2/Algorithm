import sys

numbers = list(map(int,sys.stdin.readline().strip().split(',')))
print(numbers)
hand = "left"
answer=""

dic = {1:[0,0],2:[0,1],3:[0,2],
       4:[1,0],5:[1,1],6:[1,2],
       7:[2,0],8:[2,1],9:[2,2],
       '*':[3,0],0:[3,1],'#':[3,2]}
left = dic['*']
right = dic['#']


for i in numbers:
    current_num = dic[i]
    if i in [1,4,7]:
        answer+="L"
        left = dic[i]
    elif i in [3,6,9]:
        answer+='R'
        right = dic[i]
    else:
        left_dt = 0
        right_dt =  0
        for x,y,z in zip(left,right,current_num):
            left_dt += abs(x-z)
            right_dt += abs(y-z)
        if left_dt>right_dt:
            answer+='R'
            right = current_num
        elif left_dt<right_dt:
            answer+='L'
            left = current_num
        else:
            if hand=='left':
                answer+='L'
                left = current_num
            else:
                answer+='R'
                right = current_num