import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v = sc.nextLine();
        int a = Integer.parseInt(v);
        List<int[]> list_zakaz = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            String l = sc.nextLine();
            list_zakaz.add(convert2(l));
        }
        String v1 = sc.nextLine();
        int b = Integer.parseInt(v1);
        List<int[]> list_zapros = new ArrayList<>();
        while (b != 0) {
            String c = sc.nextLine();
            list_zapros.add(convert2(c));
            b -= 1;
        }
        test(list_zapros,list_zakaz);
    }

    static int[] convert2(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
    static void test (List<int[]> list_zapros, List<int[]> list_zakaz ) {
        for (int[] j : list_zapros) {
            int count = 0;
            int sum = 0;
            if (j[2] == 1) {
                for (int[] i : list_zakaz) {
                    if (j[0] <= i[0]
                            && j[1] >= i[0]) {
                        count = count + i[2];
                    }
                }
                System.out.print(count + " ");
            } else {
                for (int[] i : list_zakaz) {
                    if (j[0] <= i[1]
                            && j[1] >= i[1]) {
                        sum = sum + (i[1] - i[0]);

                    }
                }
                System.out.print(sum + " ");
            }
        }
    }
}
