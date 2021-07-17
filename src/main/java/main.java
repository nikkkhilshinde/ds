import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        int[] queue = {1, 5, 1, 3, 4};
//     minimumBribe(queue);
        System.out.println(superDigit("0", 0));
    }

    static int superDigit(String n, int k) {
        if(k == 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < n.length(); i++) {
            total += Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        if(total == 0 ){
            return 0;
        }
        if ((total * k) > 9) {
            return superDigit(String.valueOf(total * k), 1);
        } else {
            return total * k;
        }
    }

    private static void minimumBribe(int[] queue) {
        int totalSwaps = 0;
        boolean isTooChaotic = false;
        for (int i = 0; i < queue.length; i++) {
            HashMap<Integer, Integer> swapCounter = new HashMap<>();
            int oldSwap = totalSwaps;
            for (int j = 0; j < queue.length - i - 1; j++) {
                if (queue[j] > queue[j + 1]) {
                    int temp = queue[j + 1];
                    queue[j + 1] = queue[j];
                    if (swapCounter.containsKey(queue[j])) {
                        int counter = swapCounter.get(queue[j]);
                        counter++;
                        if (counter > 2) {
                            isTooChaotic = true;
                            break;
                        }
                        swapCounter.put(queue[j], counter);
                    } else {
                        swapCounter.put(queue[j], 1);
                    }
                    totalSwaps++;
                    queue[j] = temp;
                }
            }
            if (isTooChaotic || oldSwap == totalSwaps) {
                break;
            }
        }

        if (isTooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(totalSwaps);
        }
    }
}
