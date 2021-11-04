# [네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 서로 연결된 집합을 네트워크라고 한다. 집합, 즉 네트워크의 개수를 구한다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - 양방향 연결 된 배열이 주어진다. 따라서 BFS로 체크안된 노드에 대해서, 탐색을 진행한다.
   - 체크는 주어진 배열을 0 ~ N까지 모두 돌려보면 된다. 체크 안된 노드가 있으면 체크하고 queue에 넣는다.
  