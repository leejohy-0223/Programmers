# [다음 큰 숫자](https://programmers.co.kr/learn/courses/30/lessons/12911)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 주어진 n보다 크며, 이진수로 변환 시 n과 1의 개수가 동일한 값을 출력한다.
  <br><br>

### 문제 풀이
- 접근 1.(Solution)
    - binaryString으로 변환 후 1의 개수를 count한다.
- 접근 2.(SolutionRef) : api 사용
    - Integer.bitCount = 2진수 변환 후, 1의 개수를 센다.
    + (추가) Integer.numberOfLeadingZeros(n) : n을 이진수로 변환한 후, 32bit 기준으로 hightest-order(leftmost) 1의 왼쪽에 0의 개수를 구한다.
      예를 들어, 170(10101010)의 경우 가장 큰 1이 맨 왼쪽 8번째이므로, 32 - 8 = 24를 리턴한다.
    + (추가) Integer.numberOfTrailingZeros(n) : 이번엔 가장 작은 1기준으로 오른쪽에 있는 0의 count를 계산한다.  