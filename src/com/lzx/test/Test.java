package com.lzx.test;


import com.lzx.datastructure.LinkedList;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList =new LinkedList<>();
        Random random = new Random(System.currentTimeMillis());
        System.out.println("----------------------添加数据----------------------");
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(10, 30);
            linkedList.add(i1);

        }
        System.out.println(linkedList);

        System.out.println(linkedList.reverse().toString());
        System.out.println(linkedList.findByBackward(3));
    }
}
