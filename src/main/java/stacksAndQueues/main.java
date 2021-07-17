package stacksAndQueues;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Enter number of automakers");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter names and ratings of the automakers ( Ex. Hyundai 1 )");
        String[] names = new String[n];
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            names[i] = input[0];
            ratings[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < ratings.length - 1; i++)
            for (int j = 0; j < ratings.length - i - 1; j++)
                if (ratings[j] > ratings[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = ratings[j];
                    ratings[j] = ratings[j + 1];
                    ratings[j + 1] = temp;

                    String tempName = names[i];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }

        while (true) {
            System.out.println("a. Display All Automakers with their ratings in ascending order ");
            System.out.println("b. Display All Automakers with their ratings in descending order ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    for (int i = 0; i < n; i++) {
                        System.out.println(names[i] + " : " + ratings[i]);
                    }
                    break;
                case "b":
                    for (int i = n - 1; i >= 0; i--) {
                        System.out.println(names[i] + " : " + ratings[i]);
                    }
                    break;
            }
        }
    }
}
