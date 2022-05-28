import java.util.*;

public class CountOnesInASegment {
    public static void main(String[] args) {
        long left = 5;
        long right = 7;
        System.out.println(onesCount(right) - onesCount(left - 1));
    }

    private static long onesCount(long number) {
        String s = Long.toString(number, 2);
        long sum = 0;
        int degree = 0;
        var ones = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        for (int i = ones.length-1; i >=0 ; i--) {
            if (ones[i] == '1') {
                list.add(degree);
            }
            degree++;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * Math.pow(2, list.get(i) - 1) + i * Math.pow(2, list.get(i));
        }
        sum += list.size();

        return sum;
    }


}
