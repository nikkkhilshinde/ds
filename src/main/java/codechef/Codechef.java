package codechef;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int carsCount = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int[] speeds = new int[carsCount];
            int count = 1;
            for (int j = 0; j < carsCount; j++) {
                speeds[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int prev = speeds[0];
            for (int j = 1; j < carsCount; j++) {
                if(prev >= speeds[j]){
                    count++;
                }
                prev = speeds[j];
            }
            System.out.print(count + "\n");
        }
    }
}
