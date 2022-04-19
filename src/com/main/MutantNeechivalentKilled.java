package com.main;

public class MutantNeechivalentKilled {
    public static boolean func(int n, int[] s, int m, int d) throws Exception {
        checkConditions(n, s, m, d);
        return (sum(s, m - 1) * m) % d == 0;
    }

    private static void checkConditions(int n, int[] s, int m, int d) throws Exception {
        if (n < 1) {
            throw new Exception("n is lower than 1");
        }
        if (n >= 100) {
            throw new Exception("n is bigger than 99");
        }
        if (s.length == n) {
            throw new Exception("length of s is not equal with n");
        }
        if (m <= 1) {
            throw new Exception("m is lower or equal 1");
        }
        if (m >= n) {
            throw new Exception("m is bigger or equal n");
        }
        if (d <= 0) {
            throw new Exception("d is lower or equal 0");
        }
    }

    private static int sum(int[] arr, int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + arr[n - 1];
            n--;
        }
        return sum;
    }
}
