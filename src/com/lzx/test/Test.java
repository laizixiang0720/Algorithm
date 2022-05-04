package com.lzx.test;


import com.lzx.datastructure.ArrayStack;
import com.lzx.datastructure.LinkedStack;
import com.lzx.datastructure.Stack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //LinkedList<Integer> linkedList =new LinkedList<>();
        Stack<Integer> stack=new LinkedStack<>();
        Random random = new Random(System.currentTimeMillis());
        System.out.println("----------------------添加数据----------------------");
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(10, 30);
            System.out.println(i1);
            stack.push(i1);
            //linkedList.add(i1);

        }
        ArrayList<Integer> a= new ArrayList<>();
        System.out.println("----------------------添加数据后----------------------");
        System.out.println(stack);
    }

}
