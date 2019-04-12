package com.supermantou.alii;

import java.util.Scanner;

public class Solution {
    private static double[][] dots = new double[5][2]; // 加一个哨兵
    private static double[][] lines = new double[4][4]; // 4条直线方程，Ax+By+C=0 , 第四个表示区域所在边
    public static void main(String args[]) {
        double x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        for (int i = 0; i < 4; i++) {
            dots[i][0] = scanner.nextDouble();
            dots[i][1] = scanner.nextDouble();
        }
        dots[4][0] = dots[0][0];
        dots[4][1] = dots[0][1];
        init_lines();
        if (is_in_area(x,y)){
            System.out.println("yes,0");
        }else {
            System.out.println("no,"+(int)(dist(x,y)+0.5));
            System.out.println("debug:"+dist(x,y));
        }
    }
    public static void init_lines(){
        for (int i = 0; i < 4; i++) {
            lines[i][0] = dots[i][1] - dots[i + 1][1];
            lines[i][1] = dots[i + 1][0] - dots[i][0];
            lines[i][2] = dots[i][0] * (dots[i + 1][1] + dots[i][1]) - dots[i][1] * (dots[i + 1][0] + dots[i][0]);
            lines[i][3] = lines[i][0] * lines[(i+2) % 4][0] + lines[i][1] * lines[(i+2) % 4][1] + lines[i][2];
            if (lines[i][3] > 0){
                lines[i][3] = 1;
            }else {
                lines[i][3] = -1;
            }
        }
    }
    public static boolean is_in_area(double x, double y){
        // 点在四条直线的区域侧，说明在区域内
        return is_in_side(x,y,0) && is_in_side(x,y,1) && is_in_side(x,y,2) && is_in_side(x,y,3);

    }
    public static boolean is_in_side(double x, double y,int i){
        // 判断点是否在直线包含区域的一侧
        double value = lines[i][0] * x + lines[i][1] * y + lines[i][2];
        if (value * lines[i][3] >= 0){
            return true;
        }else {
            return false;
        }
    }
    public static double dist(double x, double y){
        // 计算点到4条线段的最短距离并返回
        double[] dist = new double[4];
        for (int i = 0; i < 4; i++) {
            double cross = (dots[i+1][0] - dots[i][0]) *(x - dots[i][0]) +
                    (dots[i+1][1] - dots[i][1]) *(y - dots[i][1]);
            if (cross <= 0){
                // 点到线段i-i+1夹角大于90度，最短是到点i的距离
                dist[i] = Math.sqrt((x-dots[i][0])*(x-dots[i][0]) + (y-dots[i][0]) * (y-dots[i][0]));
            }else {
                double d2 = (dots[i+1][0] - dots[i][0]) * (dots[i+1][0] - dots[i][0]) +
                        (dots[i+1][1] - dots[i][1]) * (dots[i+1][1] - dots[i][1]) ;
                if (cross >= d2){
                    // 点到i+1的距离更近
                    dist[i] = Math.sqrt((x-dots[i+1][0])*(x-dots[i+1][0]) + (y-dots[i+1][1]) * (y-dots[i+1][1]));
                }else {
                    // 点到直线距离更近
                    double value = lines[i][0] * x + lines[i][1] * y + lines[i][2];
                    dist[i] = Math.abs(value) / Math.sqrt(lines[i][0]*lines[i][0] + lines[i][1]*lines[i][1]);
                }
            }
        }
        double min = dist[0];
        for (int i = 1; i < 4; i++) {
            if (dist[i] < min){
                min = dist[i];
            }
        }
        return min;
    }
}
