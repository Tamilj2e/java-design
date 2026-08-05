package design_patterns.practice;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));
        int[][] arr = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] split  = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        map.put(47,0);
        map.put(8,0);
        map.put(11,0);
        System.out.println(map.higherKey(48));

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(6);
        set.add(11);
        set.add(9);

//        System.out.println(set.);

    }
}
