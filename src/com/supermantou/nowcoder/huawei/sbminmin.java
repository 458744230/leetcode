package com.supermantou.nowcoder.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sbminmin {
    public static void main(String[] args){
        int len;
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            len = scanner.nextInt();
            list.clear();
            for (int i = 0; i < len; i++) {
                list.add(scanner.nextInt());
            }
            list = list.stream().distinct().collect(Collectors.toList());
            Collections.sort(list);
            for (Integer i:list){
                System.out.println(i);
            }
        }
    }
}
