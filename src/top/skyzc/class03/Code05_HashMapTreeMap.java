package com.company.class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Title Code05_HashMapTreeMap
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午4:18 2022/3/15
 **/

public class Code05_HashMapTreeMap {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("youzhengcai","Skyzc"); // 增
        System.out.println(map.containsKey("youzhengcai")); // 是否存在
        System.out.println(map.get("youzhengcai")); // 查
        map.put("youzhengcai","You"); // 改
        map.remove("youzhengcai"); // 删
        // 不管数据多少，增删改查都是常数时间 O(1)
        // 内部 String 按值传递

        TreeMap<Integer,String> treeMap1 = new TreeMap<>();
        treeMap1.put(3,"我是3");
        treeMap1.put(1,"我是3");
        treeMap1.put(2,"我是3");
        treeMap1.put(4,"我是3");
        treeMap1.put(5,"我是3");
        treeMap1.put(6,"我是3");
        treeMap1.put(8,"我是3");
        treeMap1.put(9,"我是3");

        System.out.println(treeMap1.containsKey(3));

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        // <=5 离5最近的 key
        System.out.println(treeMap1.floorKey(5));
        // >=5 离5最近的 key
        System.out.println(treeMap1.ceilingKey(5));
    }
}
