'''
문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.

Solution
문자열의 크기와 문자열을 입력받은다.
문자열을 리스트로 변환시키면 각 문자열이 리스트의 인자로 들어가고 sum()함수를 통해 리스트의 합을 구한다.
'''
import sys

_len = int(sys.stdin.readline().strip())
_arr = list(map(int,sys.stdin.readline().strip()))

print(sum(_arr))