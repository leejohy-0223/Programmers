package pro42583;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    static class Truck {
        int weight;
        int position;

        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        List<Truck> list = new ArrayList<>();

        int idx = 0;
        int w = 0;

        while (idx < truck_weights.length) {
            answer++;
            // 리스트의 트럭 포지션을 하나씩 낮춰준다.
            for (Truck t : list) {
                t.position--;
            }

            // 리스트의 맨 첫번째 position이 0일 경우, 무게를 줄이고 list에서 제거한다.
            if (!list.isEmpty() && list.get(0).position == 0) {
                w -= list.get(0).weight;
                list.remove(0);
            }

            if(w + truck_weights[idx] <= weight) {
                w += truck_weights[idx];
                list.add(new Truck(truck_weights[idx], bridge_length));
                idx++;
            }
        }
        // 마지막 인덱스가 올라온 후, 탈출 시간을 더해준다.
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(i);
    }
}
