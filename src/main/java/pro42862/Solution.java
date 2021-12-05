package pro42862;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];

        //        Arrays.sort(lost);
        //        Arrays.sort(reserve);
        // 여유분 옷 하나씩 올리기
        for (int k : reserve) {
            clothes[k]++;
        }
        // 도난 옷 갱신
        for (int k : lost) {
            clothes[k]--;
        }

        for (int i=1; i<clothes.length; i++) {
            // 도난당했으나 0이라면 여벌이 있었던 친구이므로 continue
            if (clothes[i] >= 0) continue;

            // 도난 당했고, 여유분도 없었다면 빌려야 한다.
            // 앞사람 여유 있다면 먼저 빌리자.
            if (i - 1 > 0 && clothes[i - 1] > 0) {
                clothes[i]++;
                clothes[i - 1]--;
                continue;
            }
            // 앞 사람 여유 없다면 뒷사람한테도 물어보자
            if (i + 1 <= n && clothes[i + 1] > 0) {
                clothes[i]++;
                clothes[i + 1]--;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 0) {
                answer++;
            }
        }
        return answer;
    }
}
