///programmers(카카오프렌즈 컬러링북) https://programmers.co.kr/learn/courses/30/lessons/1829
package pro1829;

public class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int m1, n1;
    int res = 1;
    int[][] tmp_pic;
    int st = 1;

    public int[] solution(int m, int n, int[][] picture) {

        tmp_pic = new int[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                tmp_pic[i][j] = picture[i][j];
            }
        }
        m1 = m;
        n1 = n;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(tmp_pic[i][j] != 0) {
                    int tmp = tmp_pic[i][j];
                    tmp_pic[i][j] = 0;
                    numberOfArea++;
                    DFS(i, j, tmp);
                    res = Math.max(res, st);
                    st = 1;
                }
            }
        }
        maxSizeOfOneArea = res;
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    void DFS(int x, int y, int check) {

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<m1 && ny>=0 && ny<n1 && tmp_pic[nx][ny] == check) {
                tmp_pic[nx][ny] = 0;
                st++;
                DFS(nx, ny, check);
            }
        }
    }
}
