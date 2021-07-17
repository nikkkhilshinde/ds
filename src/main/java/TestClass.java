
import java.util.*;
import java.util.stream.IntStream;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {


    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        for(int i = 0; i < T ; i++){
            int n = Integer.parseInt(s.nextLine());
            char[][] matrix = new char[n][n];
            for (int j = 0; j < n; j++) {
                String line = s.nextLine();
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = line.charAt(k);
                }
            }
            boolean isHorizontallySymmetric = true;
            for (int j = 0; j <= n/2; j++) {
                for (int k = 0; k < n; k++) {
                    if(matrix[j][k] != matrix[n-j-1][k]){
                        isHorizontallySymmetric = false;
                        break;
                    }
                }
                if(!isHorizontallySymmetric) break;
            }

            boolean isVerticallySymmetric = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n/2; k++) {
                    if(matrix[j][k] != matrix[j][n-k-1]){
                        isVerticallySymmetric = false;
                        break;
                    }
                }
                if(!isVerticallySymmetric) break;
            }

            if(isHorizontallySymmetric && isHorizontallySymmetric){
                System.out.println("BOTH");
            }else if(isHorizontallySymmetric){
                System.out.println("HORIZONTAL");
            }else if(isVerticallySymmetric){
                System.out.println("VERTICAL");
            }else {
                System.out.println("NO");
            }
        }
    }
}
