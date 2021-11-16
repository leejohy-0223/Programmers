# [삼각 달팽이](https://programmers.co.kr/learn/courses/30/lessons/68645)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- 정삼각형의 모서리를 반시계방향으로 돌며, 숫자를 하나씩 쓴다.
- 마지막 숫자가 작성된 후, 1차원 배열에 위에서부터 출력한다.   
  <br><br>

### 문제 풀이
- 접근 (Solution)
   - 방향을 아래, 오른쪽, 대각선으로 하면서 결과를 입력한다.
   - 사이즈 및 i, j의 값 갱신에 유의한다.
   - 대각선 방향의 경우, i j는 항상 같은게 아닌, i=0, j=0일 경우에만 같게된다. 대각선은 매 round의 i, j값에 의존하므로, 이를 기준으로 대각선을 잡아야한다.
   - size가 1보다 큰 경우까지만 반복을 진행한다.