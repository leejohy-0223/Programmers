# [카펫](https://programmers.co.kr/learn/courses/30/lessons/42842)
- Programmers 연습문제  
<br><br>

### 문제 정리
- brown, yellow 개수를 기반으로 카펫의 크기를 추측하는 문제이다.

  <br><br>

### 문제 풀이
- 접근 (Solution)
   - brown을 기준으로 완전 탐색을 진행하며 풀 수 있는 문제이다.
   - (brown / 2)를 가로, 세로로 분할한 후 넓이를 구하고, brown의 개수를 뺀 결과가 yellow와 일치하면 return 하면 된다.
    