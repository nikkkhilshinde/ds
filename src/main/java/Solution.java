import leetcode.TreeNode;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.AudioFileWriter;
import java.io.*;
import java.util.*;

class Solution {
    // [1,4] [2, 7]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval:intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int prev = heights[0];
        int count = 0;
        for(int i = 1; i < heights.length; i++){
            if(prev < heights[i]){
                if((heights[i] - prev) <=    bricks){
                    bricks -= (heights[i] - prev);
                    count++;
                }else if(ladders > 0 ){
                    ladders -= 1;
                    count++;
                }else break;
            }else{
                count++;
            }
            prev = heights[i];
        }
        return count;
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File initialFile = new File("C:\\Users\\shind\\Desktop\\github\\ds\\src\\main\\java\\BabyElephantWalk60.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(initialFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        audioClip.start();
//        while (!playCompleted) {
//            // wait for the playback completes
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
//        audioClip.close();
//        audioStream.close();
//        FrameBuffer frameStream = new FrameBuffer(audioInputStream);
//        int frame = frameStream.numberFrames() - 1;
//
//
//        while (frame >= 0) {
//            System.out.println(Arrays.toString(frameStream.getFrame(frame)));
//            int write = audioFileWriter.write(frameStream.getFrame(frame), 0, frameStream.frameSize());
//            frame--;
//        }
//        furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1);
//        int a = 345;
//        int[] binary = new int[32];
//        List<Integer> list = new ArrayList<>();
//        list.is
//        for(int i = 1; i < 32; i++){
//            binary[32-i] = 1 & (a >> (i - 1));
//        }
//        for (int i = 0; i < 32; i++) {
//            System.out.print(binary[i] + " ");
//        }
//        int n = 123;
//        while(n > 0){
//            System.out.println(n % 2);
//            n /= 2;
//        }
//        Set<Integer> set = new LinkedHashSet<>();
//        Random random = new Random();
//        while (set.size() != 200) {
//            set.add(random.nextInt(300) + 1);
//        }
//        System.out.print("[");
//        set.forEach(item -> {
//            System.out.print(item + ",");
//        });
//        System.out.print("]");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        int[] n = new int[]{1, 2, 2};
        Set<Integer> set = new TreeSet<>();

        Map<String, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.addAll(queue1);
        String str = "";
        str.contains(str.charAt(0) + "");
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode front = queue.remove();
                System.out.print(front.val + " ");
                if (front.left != null) tempQueue.add(front.left);
                if (front.right != null) tempQueue.add(front.right);
            }
            System.out.println();
            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.remove());
            }
        }
        return new LinkedList<>();
    }
}