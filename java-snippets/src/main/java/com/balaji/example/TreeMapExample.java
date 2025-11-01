package com.balaji.example;

import java.util.TreeMap;

/**
 * Examples of TreeMap usage.
 * TreeMap is a Red-Black tree based implementation of SortedMap. All operations are guaranteed to finish in O(lg n)
 * time. The map is sorted by natural ordering of keys or by the order specified by the comparator used in constructor.
 * Useful methods: firstKey(), lastKey(), ceilingKey(), floorKey(), subMap().
 * Source: <a href="https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/TreeMap.html">TreeMap - Oracle docs</a>
 *
 */
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> naturalMap = new TreeMap<>(); // Using TreeMap instead of SortedMap as class to have access
                                                            // to ceilingKey(), floorKey(), etc.

        naturalMap.put(7, "seven");
        naturalMap.put(88, "eighty-eight");
        naturalMap.put(2, "two");
        naturalMap.put(15, "fifteen");
        naturalMap.put(24, "twenty-four");
        naturalMap.put(-1, "minus one");

        System.out.println(naturalMap); // Prints: {-1=minus one, 2=two, 7=seven, 15=fifteen, 24=twenty-four, 88=eighty-eight}

        System.out.println(naturalMap.firstKey()); // Prints: -1
        System.out.println(naturalMap.lastKey()); // Prints: 88

        System.out.println(naturalMap.ceilingKey(10)); // Prints: 15
        System.out.println(naturalMap.ceilingKey(90)); // Prints: null

        System.out.println(naturalMap.floorKey(10)); // Prints: 7
        System.out.println(naturalMap.floorKey(-9)); // Prints: null

        System.out.println(naturalMap.subMap(5, 30)); // Prints: {7=seven, 15=fifteen, 24=twenty-four}

        System.out.println("\nReverse ordering using comparator in constructor");
        TreeMap<Integer, String> reverseMap = new TreeMap<>((a, b) -> (b-a));

        reverseMap.put(7, "seven");
        reverseMap.put(88, "eighty-eight");
        reverseMap.put(2, "two");
        reverseMap.put(15, "fifteen");
        reverseMap.put(24, "twenty-four");
        reverseMap.put(-1, "minus one");

        System.out.println(reverseMap); // Prints: {88=eighty-eight, 24=twenty-four, 15=fifteen, 7=seven, 2=two, -1=minus one}
    }
}
