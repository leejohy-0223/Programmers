# [불량 사용자](https://programmers.co.kr/learn/courses/30/lessons/64064)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- banned Id의 패턴을 이용해서, 가능한 ban Id를 user Id 리스트로부터 찾는 문제이다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - (자신을 포함하지 않는) 순열을 사용한다.
   - 매 permu 호출마다, banID 패턴과 userId패턴이 일치하는지 확인 후, List에 해당 id를 넣는다.
   - 이 때 banId의 *를 .으로 변경한다. 정규식에서 .은 아무거나를 의미하므로, 이걸로 변경해서 체크를 진행한다.
   - banId와 동일한 길이의 리스트가 형성되었을 경우, Set<ArrayList>에 있는 값과 containsAll 비교를 진행한다. 없을 경우 set에 추가한다.
   - 최종으로 set의 크기를 출력하면 된다.
   - List를 계속 가변할 경우, Set에 저장 시점에서 clone 후 set에 넣어야 한다. 안그러면 list가 바뀌어도 set의 크기는 계속 1로 유지된다. list자체를 계속 참고하고 있기 때문에 변경도 set에 반영이 되어버리기 때문이다.  
   - 정규 표현식 참고 :  https://coding-factory.tistory.com/529
   - 얕은 복사, 깊은 복사 참고 : https://hianna.tistory.com/567 