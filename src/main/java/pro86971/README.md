# [전력망을 둘로 나누기](https://programmers.co.kr/learn/courses/30/lessons/86971)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- 연결된 노드를 2등분하여, 나눠진 두 그룹의 차이가 최소인 값을 구한다.
  <br><br>

### 문제 풀이
- 접근 (Solution) - 오답 : 가지가 많은 노드만 봐서는 안된다. 모든 노드를 확인할 필요가 있다.
- 접근 2(SolutionRef)  
  1. 양방향 연관관계를 설정한다.
  2. 모든 노드에 대해 for문을 돌린다.
      - 현재 노드와, 그것과 연결된 노드를 list<Remove>에 넣는다.
      - list에서 remove 노드를 꺼내, 양방향 연관관계를 지운 후 현재 상태에서 DFS를 한번 돌린다.
        이 때 list에서 지울 때는 index가 아닌 object를 지우기 위해 Integer.valueOf를 통해 int -> Integer로 변경해서 처리한다.
      - 반환 결과는 어느 한 그룹에 대한 DFS이다. 따라서 notCount된 집합을 n-count로 구한다.
      - answer와 abs(count - notCount)값의 최솟값으로 갱신한다.
      - 끊은 노드를 다시 연결한다.
