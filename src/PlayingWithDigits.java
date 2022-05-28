
public class PlayingWithDigits {
    public static void main(String[] args) {
        int n = 89;
        int p = 1;
        int sum = 0;
        char[] digits = String.valueOf(n).toCharArray();
        for (var d : digits) {
            sum += Math.pow(Integer.parseInt(String.valueOf(d)), p);
            p++;
        }
        System.out.println(sum%n==0?sum/n:-1);
    }

}
