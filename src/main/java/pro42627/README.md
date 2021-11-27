# [디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627)
- Programmers 연습문제  
<br><br>

### 문제 정리
- 하드디스크에 들어오는 요청의 가장 작은 걸린시간 평균을 구하는 문제이다.
  <br><br>

### 문제 풀이
- 접근 1(Solution)
    - 기본 job list는 최초 1회만 start가 제일 빠른 job을 뽑기 위해 start 기준으로 sorting을 진행한다.
    - 현 endtime 기준, startTime이 작은 경우 Priority queue에 넣는다. PQ는 제일 짧은 작업을 먼저 수행한다.
    - 1회 수행 후 endTime은 변경된다. 따라서 pq를 clear 한 후 다시 담아야 한다.
    - 만약 endtime <= startTime인 경우에는 이미 정렬된 jobList의 맨 앞 값으로 갱신한다.