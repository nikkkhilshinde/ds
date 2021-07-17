package hascode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/hascode/a.txt"));
        int D = scanner.nextInt();
        int intersections = scanner.nextInt();
        int streets = scanner.nextInt();
        int cars = scanner.nextInt();
        int bonus = scanner.nextInt();

        Map<String, Integer> streetNameIntersections = new HashMap<>();
        int[][] graph = new int[intersections][intersections];
        for (int i = 0; i < streets; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            String streetName = scanner.next();
            int time = scanner.nextInt();
            graph[from][to] = time;
            streetNameIntersections.put(streetName, to);
        }
        Map<Integer, List<Integer>> carsRoute = new HashMap<>();
        for (int i = 0; i < cars; i++) {
            int totalRoutes = scanner.nextInt();
            List<Integer> routesList = new LinkedList<>();
            for (int j = 0; j < totalRoutes; j++) {
                routesList.add(streetNameIntersections.get(scanner.next()));
            }
            carsRoute.put(i, routesList);
        }
        carsRoute.forEach((key, value) -> {
            System.out.print(key + ":");

            for (int i = 0; i < value.size() - 1; i++) {
                System.out.print(graph[value.get(i)][value.get(i+1)] + "->");
            }
            System.out.println();
        });
    }
}
