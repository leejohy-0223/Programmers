# [올바른 괄호](https://programmers.co.kr/learn/courses/30/lessons/12909)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 올바른 괄호의 open / close를 확인
  <br><br>

### 문제 풀이
- 접근(Solution)
    - stack을 이용하여, c == ')'일 경우 조건을 통해 걸러낸다.
    - 모든 char 배열에 대해 stack에서 처리를 한 후, 마지막에 empty 상태이면 true를 반환, 아니면 false를 반환한다. 