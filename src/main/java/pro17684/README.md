# [[3차]압축](https://programmers.co.kr/learn/courses/30/lessons/17684)
- Programmers 연습문제  
<br><br>

### 문제 정리
- LZW 압축을 구현한다.
  <br><br>

### 문제 풀이
- 접근 1 (Solution)
    - 문제 자체는 쉬우나, 반복 구현이 조금 헷갈렸다.
    - left, right를 둘 다 사용해서 while이 안쪽 바깥쪽이 생기고, 조금 헷갈렸다.
    - 다양한 예외처리가 필요하다.
    
- 접근 2 (SolutionRef)
    - 외부에서 idx를 하나씩 올리고, 내부에서는 Stringbuilder를 통해 만들어진 문자열이 맵에 존재하면, idx를 또 올리는 방식으로 구현한다.
    - 맵에 존재하지 않을 경우, 현재까지의 Stringbuilder를 map에 저장하고, 이것보다 한자리 작은 문자열의 값을 저장한다.
    - 내부 while을 통해 idx의 값이 변했을 것이다. 현재 idx부터 다시 탐색이 필요하므로, idx--로 하나 내려주면 다음번 for문에서 다시 idx++를 통해 현재 idx부터 탐색을 할 수 있게 된다.
    

   