# [단어 변환](https://programmers.co.kr/learn/courses/30/lessons/43163)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요. 
<br><br>

### 문제 풀이
- 접근 (Solution)
   - 현재 선택된 단어와 비교 대상 단어의 차이가 1개만 날 경우에만 BFS를 돌리기 위해 큐에 넣는다.
   - 깊이가 깊어지면서 진행되며, 만약 target과 1단어 차이가 발생하는 경우가 발생하면, answer를 반환한다.
   - 매 새로운 큐의 단계(큐 사이즈 추출 후 그 사이즈에서만 돌림)마다 answer를 올린다.
   - 큐 안에서 return되지 않았다는 의미는 target까지 갈 수 없는 경우이다. 따라서 0을 반환한다.
    
