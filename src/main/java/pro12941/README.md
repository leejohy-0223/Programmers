# [최솟값 만들기](https://programmers.co.kr/learn/courses/30/lessons/12941)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 두 배열에서 곱을 통해 최종 값이 최솟값이 되도록 만들자.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - 처음에는 int[] 배열을 reverse로 만들기 위해 stream을 사용했으나, 효율성에서 시간초과가 발생했다.
   - 그냥 A, B를 정렬하고, A는 맨 앞부터 / B는 맨 뒤부터 곱하면서 더해주면 더 빨라진다.