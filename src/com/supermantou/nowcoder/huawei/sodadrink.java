package com.supermantou.nowcoder.huawei;

import java.util.Scanner;

public class sodadrink {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext() && (n = scanner.nextInt()) != 0) {
            int time = 0, remain;
            remain = n % 3;
            n /= 3;
            while (n > 0) {
                time += n;
                n += remain;
                remain = n % 3;
                n /= 3;
            }
            if (remain == 2) {
                time++;//可以借以一瓶
            }
            System.out.print(time);
            System.out.print("\n");
        }
    }
}
