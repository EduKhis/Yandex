import java.util.Scanner;

public class TestCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] csv = new String[N];
        String alphabet = "0abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < N; i++) {
            csv[i] = scanner.nextLine();
        }
        for (String i : csv) {
            String[] full_name_date = i.split(",");
            String full_name = full_name_date[0] + full_name_date[1] + full_name_date[2];
            int len_full_name = (int) full_name.chars().distinct().count();
            String d_m = full_name_date[3] + full_name_date[4];
            int sum_d_m = d_m.chars().map(Character::getNumericValue).sum();
            int index_first_char = alphabet.indexOf(Character.toLowerCase(full_name.charAt(0)));
            int result_decimal = len_full_name + sum_d_m * 64 + index_first_char * 256;
            String result_hexadecimal = Integer.toHexString(result_decimal).toUpperCase();
            if (result_hexadecimal.length() >= 3) {
                System.out.print(result_hexadecimal.substring(result_hexadecimal.length() - 3) + " ");
            } else {
                while (result_hexadecimal.length() < 3) {
                    result_hexadecimal = "0" + result_hexadecimal;
                }
                System.out.print(result_hexadecimal.substring(result_hexadecimal.length() - 3) + " ");
            }
        }
    }
}