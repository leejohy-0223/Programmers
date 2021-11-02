# [H-Index](https://programmers.co.kr/learn/courses/30/lessons/42747)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 과학자가 발표한 n편의 논문 중, h번 이상 인용된 논문이 h편 이상일 때 h의 최댓값을 구한다.

  <br><br>

### 문제 풀이
- 접근 (Solution)
   - 문제가 조금 이해가 안가서 여러번 읽었지만, 결국 h번 <= h편 이상 인용된 논문 수 중 가장 큰 수를 구한다.
     - 우선 reverse sorting을 진행한다.
     - 논문의 수가 나올 수 있는 최댓값이므로, 해당 수부터 하나씩 내리며 검사를 진행한다.
     - cnt가 조건에 맞다면, break를 걸어 최댓값을 출력하면 된다.