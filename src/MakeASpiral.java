import java.util.ArrayList;

public class MakeASpiral {
    public static void main(String[] args) {
        int size = 50;
        int[][] spiral = new int[size][size];
        for (int i = 0; i < size; i++) {
            spiral[0][i] = 1;
            spiral[size - 1][i] = 1;
        }
        spiral[1][size-1] = 1;
        spiral[size-2][size-1] = 1;
        spiral[size-2][0] = 1;
        for (int i = 0; i < size; i++) {
            spiral[0][i] = 1;
            spiral[size - 1][i] = 1;
        }



        for (int u = 0; u < size; u++) {
            for (int g = 0; g < size; g++)
                System.out.print(spiral[u][g]);
            System.out.println();
        }

    }
}
