package pro17680;

import java.util.LinkedList;

public class SolutionRef {

    public int solution(int cacheSize, String[] cities) {

        LinkedList<String> list = new LinkedList<>();
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (String city : cities) {
            String s = city.toLowerCase();

            // list에 포함되어있어 삭제가 가능해진다면,
            if (list.remove(s)) {
                list.addLast(s);
                answer += 1;
                continue;
            }

            // cache miss
            int currentSize = list.size();
            if (currentSize == cacheSize) {
                list.pollFirst();
            }

            list.addLast(s);
            answer += 5;
        }

        return answer;
    }
}
