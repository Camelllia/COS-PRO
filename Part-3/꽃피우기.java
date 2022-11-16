// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int n = garden.length;
        int[][] nextGarden = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                nextGarden[i][j] = garden[i][j];
            }
        }

        while (true) {
            // break 문
            loop:
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(garden[i][j] == 0) break loop;
                    if(i == n-1 && j == n-1 && garden[i][j] == 1) return answer;
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(garden[i][j] == 1){
                        for(int d=0; d<4; d++){
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if(ni>=0 && nj>=0 && ni<n && nj<n){
                                nextGarden[ni][nj] = 1;
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    garden[i][j] = nextGarden[i][j];
                }
            }
            answer++;
        }

    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}