package pro17683;

public class SolutionRef {

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (String musicinfo : musicinfos) {

            String[] info = musicinfo.split(",");
            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < t; j++) {
                    sb.append(info[3].charAt(j % (info[3].length())));
                }
                if (sb.toString().contains(m)) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
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

    }
}
