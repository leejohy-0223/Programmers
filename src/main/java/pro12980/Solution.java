package pro12980;

public class Solution {

    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 != 0) {
                n--;
                ans++;
                continue;
            }
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
