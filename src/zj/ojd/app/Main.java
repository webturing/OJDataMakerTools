package zj.ojd.app;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = cin.next();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);

            } else {
                map.put(str, 1);
            }
        }
        Set<String> colors = map.keySet();
        Integer max = Collections.max(map.values());
        for (String color : colors) {
            if (map.get(color) == max) {
                System.out.println(color);
                break;
            }
        }

        cin.close();
    }
}

