# 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
# 입력 :5
#     *
#    **
#   ***
#  ****
# *****


a =int(input())
for len in range(1,a+1):
    for i in range(a-len):
        print(' ', end = '')
    for j in range(len):
        print('*', end='')
    print('')


