package com.company.class06;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Title ShowComparator
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午5:11 2022/3/28
 **/

public class ShowComparator {
    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    // Id 比较器
    public static class IdComparator implements Comparator<Student> {
        // 如果返回负数,则认为第一个参数应该排在前面
        // 如果返回正数,则认为第二个参数应该排在前面
        // 如果返回0,则认为两个相等
        // 负 : o1
        // 正 : o2
        // 0 : 相等
        @Override
        public int compare(Student o1,Student o2) {
            if (o1.id < o2.id){
                return -1;
            }else if (o2.id < o1.id){
                return 1;
            }else {
                return 0;
            }
        }
    }
    // 年龄比较器
    public static class AgeComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age){
                return 1;
            }else if (o2.age < o1.age){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void printArray(int[] arr){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void printStudents(Student[] students){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].id + ", " + students[i].age);
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        int[] arr = {8,1,4,1,6,8,4,1,5,8,2,3,0};
//        printArray(arr);
//        Arrays.sort(arr);
//        printArray(arr);
//
//        Student s1 = new Student("张三",5,27);
//        Student s2 = new Student("张四",1,17);
//        Student s3 = new Student("张五",4,47);
//        Student s4 = new Student("张六",3,37);
//        Student s5 = new Student("张七",2,57);
//
//        Student[] students = {s1,s2,s3,s4,s5};
//        printStudents(students);
//        Arrays.sort(students,new IdComparator());
//        printStudents(students);
//
//        ArrayList<Student> arrayList = new ArrayList<>();
//        arrayList.add(s1);
//        arrayList.add(s2);
//        arrayList.add(s3);
//        arrayList.add(s4);
//        arrayList.add(s5);
//        for (Student s : arrayList){
//            System.out.println(s.name + ", " + s.id + ", " + s.age);
//        }
//        System.out.println("===============================");
//        arrayList.sort(new IdComparator());
//        for (Student s : arrayList){
//            System.out.println(s.name + ", " + s.id + ", " + s.age);
//        }
//
//        System.out.println("===============================");
//        System.out.println("===============================");
//        arrayList.sort(new AgeComparator());
//        for (Student s : arrayList){
//            System.out.println(s.name + ", " + s.id + ", " + s.age);
//        }

        //
        // 优先级队列 小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(2);
        heap.add(5);
        heap.add(7);
        heap.add(1);
        System.out.println(heap.peek()); // 获取最小值
        System.out.println("============");
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
        // 如何实现大根堆呢? 自己实现比较器
        System.out.println("大根堆");
        PriorityQueue<Integer> BigRootHeap = new PriorityQueue<>(new MyComparator());
        BigRootHeap.add(6);
        BigRootHeap.add(2);
        BigRootHeap.add(5);
        BigRootHeap.add(7);
        BigRootHeap.add(1);
        System.out.println(BigRootHeap.peek()); // 获取最小值
        System.out.println("============");
        while (!BigRootHeap.isEmpty()){
            System.out.println(BigRootHeap.poll());
        }


    }
    // 自定义比较器 , 用于实现大根堆
    public static class MyComparator implements Comparator<Integer>{
        // 负: 第一个在前
        // 正: 第二个在前
        // 0 : 相等
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2){
                return 1;
            }else if (o1>o2){
                return -1;
            } else {
                return 0;
            }
        }
    }
}
