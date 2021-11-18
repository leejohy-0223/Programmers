# [실패율](https://programmers.co.kr/learn/courses/30/lessons/42889)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 스테이지마다 실패율을 구하고, 실패율의 내림차순으로 스테이지를 출력한다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - compareTo는 무조건 int만 return 된다. 만약 비교 대상이 double일 경우, 조건문을 통해 적당한 값을 int로 리턴해야 한다.
   - double의 경우, 0이 아닌 수를 0으로 나누면 Infinity, 0을 0으로 나누거나, 숫자가 아닌 값은 NaN으로 결과가 저장된다.
   - 따라서 Double.isInfinite(x) / Double.isNaN(x)를 통해 해당 값이 유효한지 검사 후, isNaN일 경우 list에 저장 시 0을 넣어주었다.  