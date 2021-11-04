package pro17683;

import java.util.ArrayList;

public class Solution {
    static class MusicInfo {
        String name;
        int time;

        public MusicInfo(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
    public String solution(String m, String[] musicinfos) {
        ArrayList<MusicInfo> arr = new ArrayList<>();
        m = edit(m);

        for (String musicinfo : musicinfos) {
            // 총 시간 구하기
            String[] split = musicinfo.split(",");
            String start = split[0];
            String end = split[1];

            String[] startSplit = start.split(":");
            String[] endSplit = end.split(":");

            int e = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);
            int s = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
            int r = e - s; // running time

            String name = split[2]; // 제목
            String sheet = split[3]; // 악보

            sheet = edit(sheet); // 악보의 샾을 모두 제거한다.

            StringBuilder sb = new StringBuilder();

            int divide = r / sheet.length();
            int remind = r % sheet.length();

            for (int i = 0; i < divide; i++) {
                sb.append(sheet);
            }

            int tmp = 0;
            for (int i = 0; i < sheet.length() && tmp < remind; i++) {
                sb.append(sheet.charAt(i));
                tmp++;
            }

            System.out.println(sb);
            if (sb.toString().contains(m)) {
                arr.add(new MusicInfo(name, r));
            }

//            // sb에 m이 있으며, m에도 #이 포함되어 있을 경우에는 바로 arr에 넣는다.
//            if (sb.toString().contains(m) && m.contains("#")) {
//                arr.add(new MusicInfo(name, r));
//                continue;
//            }
//
//            // 1. sb에 m만 있을 경우 실행한다.
//            if (sb.toString().contains(m)) {
//                int first = sb.indexOf(m); // 2. m이 처음 나오는 위치를 first에 지정한다.
//                while (first < sb.length()) {
//                    String sub = sb.substring(first); // 3. 그 위치부터 substring을 만들어 확인한다.
//                    if (sub.contains(m + '#')) { // 4. sub에 m+'#'이 있다면,
//                        first += m.length() + 1; // 5. 범위를 더 줄이기 위해 first를 변경하고, 다시 while 처음으로 간다.
//                    } else if (sub.contains(m)) { // 6. 만약 sub가 # 제외한 값만 갖는다면, 배열에 넣는다.
//                        arr.add(new MusicInfo(name, r));
//                        break;
//                    } else // 7. 줄인 결과 아무것도 없다면 이만 종료한다.
//                        break;
//                }
//            }
        }

        arr.sort((o1, o2) -> {
            if (o1.time == o2.time) {
                return 0;
            }
            return o2.time - o1.time;

        });

        if (arr.size() == 0) {
            return "(None)";
        }

        return arr.get(0).name;
    }

    private String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        System.out.println(s.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println(s.solution("ABC", new String[]{"13:00,13:05,WORLD,BABC#DEFABCD"}));
    }
}
