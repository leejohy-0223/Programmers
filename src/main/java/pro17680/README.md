# [[1차]캐시](https://programmers.co.kr/learn/courses/30/lessons/17680)
- Programmers 연습문제  
<br><br>

### 문제 정리
- LRU 방식의 캐시 처리를 수행한다. 

  <br><br>

### 문제 풀이
- 접근 1 (Solution)
   - 큐를 이용해서 접근했다. 아무래도 중간에 값이 있을 경우 처리가 조금 곤란했지만, 반복을 통해 해결했다.
    
- 접근 2 (SolutionRef)
   - 링크드리스트를 이용해서 접근했다. 중간에 값이 있을 경우, list.remove를 통해 제거 여부를 확인할 수 있으며 제거도 가능하다.
   - 또한 pollFirst / pollLast / addFirst / addLast를 활용하여 dequeue처럼 사용할 수 있다.
    

   