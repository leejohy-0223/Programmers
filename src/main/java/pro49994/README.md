# [방문 길이](https://programmers.co.kr/learn/courses/30/lessons/49994)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 방문하지 않은 루트일 경우를 count하는 문제이다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - A -> B로의 방문이 있을 경우, B -> A를 카운트하면 안된다.
   - 따라서 현재 노드 -> 새로운 노드의 루트 또는 새로운 노드 -> 현재 노드로의 길이 없을 때만 set에 양방향 루트를 추가한다.
   - set.size() / 2를 반환하면 된다.
    
