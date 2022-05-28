import java.util.HashMap;


public class Sections {
    public static void main(String[] args) {

        HashMap<Long,Integer> hashMap = new HashMap<>();

//        long z = 64;
//        long sum = 0;
//        for (long i = 1; z * z * z >= i * i; i++) {
//            for (long j = 1; z * z * z >= i * i * j * j && j != i; j++)
//                if (z * z * z == i * i * j * j) {
//                    sum++;
//                    System.out.println(i + "____" + j);
//                    i++;
//                    break;
//                }
//        }
        long z = 2019;
        long i = 2;
        while (z!=1) {
            if (z % i == 0) {
                z = z / i;
                hashMap.compute(i, (k, v) -> (v == null) ? 1 : v+1);
                i = 1;

            }
            i++;
        }

        int output = 1;
        for(var v:hashMap.values())
        {
            if(v==1)
                output=0;
            v=v*3/2;
            if(v%2==1)
                v++;
            output = output * v.intValue();
            System.out.println(v);
        }

        System.out.println(output);
    }
}
