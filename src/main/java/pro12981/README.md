# [영어 끝말잇기](https://programmers.co.kr/learn/courses/30/lessons/12981)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 끝말잇기를 진행하며, 실패할 경우 해당 사람과, 그 사람 기준으로 몇번째 반복 시 실패했는지를 출력한다. 실패하는 사람 없을 경우 예외 처리도 해준다.
  <br><br>

### 문제 풀이
- 접근 1 (Solution)
   - Set을 이용한다. 
   - 횟수 % 인원 == 0일 경우, result[0]은 n이 되고, result[1]은 횟수 / 인원이다.
   - 횟수 % 인원 != 0일 경우, result[0]은 횟수 % 인원이 되고, result[1]은 (횟수 / 인원) + 1이다. 