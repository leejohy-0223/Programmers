///programmers(가장 큰 수) https://programmers.co.kr/learn/courses/30/lessons/42746

package pro42746;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

//        list.sort((o1, o2) -> ((o2 + o1).compareTo(o1 + o2))); // o2 + o1이 더 크면 내림차순, 아니면 오름차순, 즉 앞에가 더 크면 내림차 아니면 오름차

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

//        Collections.sort(list);
        int count = 0;
        for (String s : list) {
            if(s.equals("0")) count++;
            answer.append(s).append(" ");
        }

        if (count == list.size()) {
            return "0";
        }

        return answer.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.solution(new int[]{5, 580, 57, 50, 560, 588, 58, -10, -20, -120});
//        String ans = s.solution(new int[]{5, 580, 57, 50, 560, 588, 58});
//        String ans = s.solution(new int[]{58, 588, 56});
//        String ans = s.solution(new int[]{3, 30, 34, 5, 9});
//        String ans = s.solution(new int[]{979, 97, 978, 81,818,817});
//        String ans = s.solution(new int[]{0, 0, 0});
//        String ans = s.solution(new int[]{0, 0, 0});
//        String ans = s.solution(new int[]{2, 5});


        System.out.println(ans);
    }
}
