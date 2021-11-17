# [n^2 배열 자르기](https://programmers.co.kr/learn/courses/30/lessons/87390)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- 주어진 배열을 이어 붙이며, left ~ right까지만 추출하는 문제이다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - left를 기준으로, 시작하는 sValue(startValue)와 startCount(시작하는 index)를 구한다.
   - left보다 같거나 크게 될경우부터, right와 같아질 때까지 배열을 채우고 반환한다.
  
- 접근 2(SolutionRef)
   - left(또는 right) / 2 + 1와 left % 2 + 1중 큰 수가 해당 인덱스에 써질 수가 된다.
   - LongStream.rangeClosed를 통해 left~right 값에 대해서만 위의 방법으로 처리를 진행하면 된다.
   - 허무하다.. ㅎㅎ
  
