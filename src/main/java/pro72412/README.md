# [순위 검색](https://programmers.co.kr/learn/courses/30/lessons/72412)
- Programmers 연습문제  
  <br><br>

### 문제 정리
- query와 일치하는 info의 개수를 계산하여 반환하는 문제이다.
  <br><br>

### 문제 풀이
- 접근 1(Solution)
   - 단순히 query 전체와 info 전체를 비교하는 방식으로 진행했다.
   - query size = 100,000 & info size = 50,000에 해당하는 최악의 경우가 발생하게 되면 시간 초과가 발생한다.
   - query와 info를 내림차순으로 정렬한 후, query에 해당하는 value가 info에서 안나올 경우 stop하는 방식으로 구현했다. 이래도 실패
  

- 접근 2(SolutionRef)
   - Map<String, ArrayList<Integer>>를 이용한다.
   1. dfs를 통해, 해당 info에서 나올 수 있는 모든 경우의 수를 String으로 만들어 key로 저장한다. 총 16가지가 나온다.
   2. 해당 key는 다른 Info에서도 나올 수 있다. 따라서 동일 key일 경우 ArrayList에 해당 info의 score를 저장한다.
      이러한 방식으로 각 key를 만족하는 score들이 list에 줄줄이 붙게 된다.
   3. 이후 list를 오름차순으로 정렬한다.
   4. query 배열을 parsing하여 key를 만든다. 이것과 일치하는 ArrayList를 map으로부터 받아올 수 있게 된다.
   5. 해당 map을 대상으로 이분 탐색을 진행한다.(하한) 이 방식을 통해 최종 start는 score를 만족하는 첫번째 인덱스를 가리키게된다.
   6. 최종적으로, 해당 query를 만족하는 info는 (전체 ArrayList 사이즈 - 5에서 구한 start 인덱스)로 계산할 수 있다.
      - 예를 들어 list가 1, 2, 3, 4, 5, 6, 7이고 3 이상의 개수를 계산하고 싶다고 가정하자.
      - 이분 탐색을 통해 start는 인덱스 2(값은 3)을 찾게 된다.
      - 따라서 이를 만족하는 개수는 (전체 list 사이즈 7 - 인덱스 2 = 5)개이다.
      
      