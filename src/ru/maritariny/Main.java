package ru.maritariny;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        long x = Long.parseLong(parts[0]);
        long y = Long.parseLong(parts[1]);

        //long x = 10;
        //long y = 20;
        System.out.println(countOfKeys(x, y));

        System.out.println(1L << solveHabr(x, y));
        reader.close();
    }

    public static long countOfKeys(long x, long y) {
        if (y % x != 0) {
            return 0;
        }
        if (x == y ) {
            return 1;
        }

        long d = y / x;

        Map<Long, Integer> factor = factorize(d);

        System.out.println(factor);
        int p = factor.size();

        return (long) Math.pow(2, p); // or 1L << p
    }

    public static Map factorize(long x) {

        Map<Long, Integer> map = new HashMap();

        for (int i = 2; i <= Math.sqrt(x) + 1; ++i) {
            int k = 0;
            while ((x % i) == 0) {
                x /= i;
                map.put((long) i, ++k);
            }
        }
        if (x != 1) {
            map.put(x, 1);
        }
        return map;
    }

    public static long nod(long a, long b) {
        long c = a % b;
        if (c == 0) {
            return b;
        }
        return nod(b, c);
        //if (b == 0) return a;
       // return nod(b, a % b);
    }
    public static long nok(long a, long b) {
        return a / nod(a, b) * b;
    }

    public static long solveHabr(long x, long y) {

        if (y % x != 0) {
            return 0;
        }
        y /= x;

        long ans = 0;
        for (long i = 2; i * i <= y; ++i) {
            if (y % i == 0) {
                ++ans;
                while (y % i == 0) {
                    y /= i;
                }
            }
        }
        if (y != 1) {
            ++ans;
        }
        return ans;
    }
}
