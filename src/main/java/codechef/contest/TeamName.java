package codechef.contest;

import java.util.Scanner;

public class TeamName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int j = 0; j < t; j++) {
            int seasons = scanner.nextInt();
            int[] q = new int[seasons];
            for (int i = 0; i < seasons; i++) {
                q[i] = scanner.nextInt();
            }
            int totalWatchTime = 0;
            for (int i = 0; i < seasons; i++) {
                int totalEpisodes = scanner.nextInt();
                totalWatchTime += scanner.nextInt();
                for (int k = 1; k < totalEpisodes; k++) {
                    totalWatchTime += scanner.nextInt() - q[i];
                }
            }
            System.out.println(totalWatchTime);
        }
    }
}
