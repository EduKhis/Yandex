
import java.util.*;
import java.util.stream.Collectors;

public class TestRocket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v = sc.nextLine();
        int a = Integer.parseInt(v);
        List<String[]> fly = new ArrayList<>();
        while (a != 0) {
            String l = sc.nextLine();
            String[] ar = l.split(" ");
            fly.add(ar);
            a -= 1;
        }
        Map<Integer, List<String[]>> map1 = fly.stream()
                .collect(Collectors.groupingBy(w->Integer.parseInt(w[3])));

        Map<Integer, List<String[]>> sortedMap = new TreeMap<>(map1);

        Set<Map.Entry<Integer,List<String[]>>> set = sortedMap.entrySet();
        for (Map.Entry<Integer,List<String[]>> i : set) {
            List<String[]>list = new ArrayList<>();
            int finish = 0;

            for (String[] j: i.getValue()) {
                String[]array = new String[2];
                int min = Integer.parseInt(j[0])*24*60+Integer.parseInt(j[1])*60+Integer.parseInt(j[2]);
                array[0]= String.valueOf(min);
                array[1]=j[4];
                list.add(array);
            }
            List<String[]>list2 =list.stream().sorted(Comparator.comparing(x->x[0])).toList();
            int a1 =0;
            int c1 = 0;
            for (String[] j : list2) {
                if (j[1].equals("A")) {
                    a1 = Integer.parseInt(j[0]);
                    c1=0;
                }
                if ((j[1].equals("C")||j[1].equals("S"))&& a1!=Integer.parseInt(j[0])) {
                    c1 = Integer.parseInt(j[0]);
                    finish = finish+(c1-a1);
                    a1=0;
                    c1=0;
                }
            }
            System.out.print(finish+" ");
        }
    }
}


