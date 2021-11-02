# [스킬트리](https://programmers.co.kr/learn/courses/30/lessons/49993)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 정해진 스킬 순서대로 작성된 정상적인 스킬트리의 수를 반환한다.

  <br><br>

### 문제 풀이
- 접근 (Solution)
   - 스킬을 charArray로 변경 후, idx=0으로 맨 처음 시작점을 가리킨다.
   - 스킬트리 탐색을 수행한다. 이 때 skill에 포함되어있는 Character 대상으로만 체크를 진행한다.
   - 현재 가리키고 있는 인덱스는 선행되어야 할 스킬이다. 따라서 일치하면 idx를 올리고 다음 스킬을 가리킨다.
   - skill에 포함되어 있으나 현재 가리키는 인덱스가 아니라면 chk를 true로 변경하고 반복을 종료한다.
   - chk가 false인 스킬트리만을 대상으로 result count를 증가시킨다.