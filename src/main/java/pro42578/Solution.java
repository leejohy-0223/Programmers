package pro42578;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();
    static int answer;
    static int[] pm;
    static String[] arr;

    public int solution(String[][] clothes) {
        answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            String tmpKey = clothes[i][1];
//            map.put(tmpKey, map.getOrDefault(tmpKey,1));
            if (!map.containsKey(tmpKey)) {
                map.put(tmpKey, 1);
                continue;
            }
            map.put(tmpKey, map.get(tmpKey) + 1);
        }

        for (String s : map.keySet()) {
            answer *= (map.get(s) + 1);
        }

//        for (int i = 1; i <= arr.length; i++) {
//            pm = new int[i];
//            comb(0, 0, i);
//        }

//        if (map.size() == 30) {
//            return 1073741823;
//        }
        return answer - 1;
    }

//    private static void comb(int L, int S, int size) {
//        if (L == size) {
//            // combination 계산
//            int result = 1;
//            for (int i = 0; i < size; i++) {
//                result *= map.get(arr[pm[i]]);
//            }
//            answer += result;
//            return;
//        }
//
//        for (int i = S; i < arr.length; i++) {
//            pm[L] = i;
//            comb(L + 1, i + 1, size);
//        }
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] i1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(s.solution(i1));
    }

}
