package com.vector.util;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        try {
            System.out.println(arr[4]);
        } catch (Exception e) {
            System.out.println("呀数组下标越界了");
        }finally {
            System.out.println("无论上面代码是否执行成功，我都是必须执行的");
        }
    }
}
