import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BattleshipFieldValidator {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] battleField = {
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] aroundBattleField = new int[11][11];
        IntStream.range(0, 10).forEach(i -> System.arraycopy(battleField[i], 0, aroundBattleField[i], 0, 10));


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int k = 0;
                if (aroundBattleField[i][j] == 1) {
                    if (j != 0 && aroundBattleField[i + 1][j - 1] == 1)
                        return;
                    if (aroundBattleField[i][j + 1] == 1) {
                        while (aroundBattleField[i][j] == 1) {
                            aroundBattleField[i][j] += 1;
                            if (aroundBattleField[i + 1][j] == 1)
                                return;
                            k++;
                            j++;
                        }
                        if (aroundBattleField[i + 1][j] == 1)
                            return;
                        if (k > 4)
                            return;
                        map.compute(k, (key, v) -> v != null ? v += 1 : 1);
                    } else {
                        if (aroundBattleField[i + 1][j] == 1) {
                            int u = i;
                            while (aroundBattleField[u][j] == 1) {
                                aroundBattleField[u][j] += 1;
                                if (aroundBattleField[u][j + 1] == 1)
                                    return;
                                k++;
                                u++;
                            }
                            if (aroundBattleField[u][j + 1] == 1)
                                return;
                            if (k > 4)
                                return;
                            map.compute(k, (key, v) -> v != null ? v += 1 : 1);
                        } else {
                            if (aroundBattleField[i][j + 1] == 1 || aroundBattleField[i + 1][j] == 1 || aroundBattleField[i + 1][j + 1] == 1)
                                return;
                            k++;
                            aroundBattleField[i][j] += 1;
                            map.compute(k, (key, v) -> v != null ? v += 1 : 1);
                        }

                    }


                }
            }

        }

        map.values().forEach(System.out::println);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(aroundBattleField[i][j]);
            }
            System.out.println();
        }

        if (map.containsKey(1))
            if (map.get(1) == 4 && map.get(2) == 3 && map.get(3) == 2 && map.get(4) == 1)
                return;

        return;
    }
}
