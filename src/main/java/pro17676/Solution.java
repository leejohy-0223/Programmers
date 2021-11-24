package pro17676;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Time {
        double startSecond;
        double endSecond;

        public Time(double startSecond, double endSecond) {
            this.startSecond = startSecond;
            this.endSecond = endSecond;
        }
    }

    public int solution(String[] lines) {
        int answer = 1;
        List<Time> times = new ArrayList<>();

        for (String line : lines) {
            String[] s = line.split(" ");
            String T = s[2];
            String[] timeSplit = s[1].split(":");
            double endValue = 0;

            endValue += Double.parseDouble(timeSplit[0]) * 3600;
            endValue += Double.parseDouble(timeSplit[1]) * 60;
            endValue += Double.parseDouble(timeSplit[2]);

            double tValue = Double.parseDouble(T.substring(0, T.length() - 1));
            double startValue = endValue - (tValue - 0.001);
            if (startValue < 0) {
                startValue = 0;
            }
            times.add(new Time(startValue, endValue));
        }

        for (int i = 0; i < times.size() - 1; i++) {
            double endSecond = times.get(i).endSecond + 1;
            int count = 1;

            for (int j = i + 1; j < times.size(); j++) {
                Time tempTime = times.get(j);
                if (endSecond > tempTime.startSecond) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[] {
                "2016-09-15 00:00:02.002 0.001s",
                "2016-09-15 00:00:03.001 0.001s",
                }));
    }
}

// "2016-09-15 00:00:02.500 0.001s"