import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestAlch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v = sc.nextLine();
        int a = Integer.parseInt(v);
        List<int[]> ingredients = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            String l = sc.nextLine();
            ingredients.add(convert2(l));
        }
        String v1 = sc.nextLine();
        int b = Integer.parseInt(v1);
        List<int[]> request = new ArrayList<>();
        while (b != 0) {
            String c = sc.nextLine();
            request.add(convert2(c));
            b -= 1;
        }

    }
    static int[] convert2(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
