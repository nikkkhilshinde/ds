package leetcode.LinkedList;


public class BinaryToDecimal {
    private static class DecimalSolution {
        private int data;
        private int pow;

        public DecimalSolution(int data, int pow) {
            this.data = data;
            this.pow = pow;
        }
    }

    public DecimalSolution getDecimalValue(ListNode head) {
        if (head.next == null) {
            return new DecimalSolution((int) (head.val * Math.pow(2, 0)), 0);
        } else {
            DecimalSolution decimalSolution = getDecimalValue(head.next);
            return new DecimalSolution(
                    (int) (head.val * Math.pow(2, decimalSolution.pow + 1) + decimalSolution.data),
                    decimalSolution.pow + 1);
        }
    }
}
