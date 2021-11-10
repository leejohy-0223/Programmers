# [키패드 누르기](https://programmers.co.kr/learn/courses/30/lessons/67256)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- 왼 / 오른손 엄지 손가락에 가까운 키패드를 누르고, L또는 R을 출력한다.
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - map을 통해 숫자별로 좌표를 지정한다. 사실 *, #은 눌리지 않으므로 지정할 필요 없다.
   - 초기 left, right position을 저장하고, 들어오는 숫자마다 위치를 보고 L, R 결정 후 누른다.
   - 누르고 나서 L, R을 answer에 추가하고, 손가락 위치를 갱신한다.
   - Character.forDigit(int_value, radix)를 통해 real number를 얻을 수 있다.
  
