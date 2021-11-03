# [[3차]n진수 게임](https://programmers.co.kr/learn/courses/30/lessons/17687)
- Programmers 연습문제  
<br><br>

### 문제 정리
- N진수로 변환하여 앞에서부터 한자리씩 돌아가면서 말하는 게임을 만든다.

  <br><br>

### 문제 풀이
- 접근 1 (Solution) 
    - N진수로 변환해야 하므로, 대략적으로 stop 해야 할 10진수를 구한다.
    - 해당 수 까지 N진수 String을 만들고, 거기에서 answer를 추출하는 방식이다.
- 접근 2 (SolutionRef)
    - Integer.toString(number, radix)를 통해 입력되는 숫자를 해당 진수로 변경해준다. 아주 멋지다..
    - target Stringbuilder를 만들고, m*t(최대 봐야 하는 문자열 길이)보다 작을 경우 계속 문자열을 만들어서 넣어준다.
    - 해당 target으로부터 answer를 추출해낸다.

    

   