# [추석 트래픽](https://programmers.co.kr/learn/courses/30/lessons/17676)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 문제 이해가 조금 오래 걸렸다. 요점은 동 time slot에서 발생하는 트래픽의 최대 개수를 계산하는 것이다.
  <br><br>

### 문제 풀이
- 접근 1 (Solution)
     - String을 parsing해서 시작 시간, 종료 시간을 초 단위(소수점 3자리)로 나타낸다. 해당 값을 List에 Time 객체로 넣는다.
     - 종료 시간 + 1s와, 그 다음 트래픽의 시작 시간을 비교해서 종료시간이 클 경우에만 answer를 올린다.
     - 그 다음 트래픽의 시작 시간을 대상으로 비교가 진행되므로, 전 범위에 대해서 검사를 해야한다. 
