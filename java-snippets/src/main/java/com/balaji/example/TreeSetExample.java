package com.balaji.example;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Example for usage of TreeSet.
 * TreeSet is an implementation of OrderedSet which is backed by TreeMap, which implements a variant of balanced tree
 * possibly Red-Black tree or AVL tree.
 * TreeSet orders set based on natural ordering of elements or the ordering can be set by a Comparator. It offers
 * ordered iterators and ceiling() and floor() functions. All operations are guaranteed to finish in O(lg n) time.
 * Source: <a href="https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/util/TreeSet.html">TreeSet - Oracle docs</a>
 */
public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> naturalOrder = new TreeSet<>();
        naturalOrder.add(22);
        naturalOrder.add(10);
        naturalOrder.add(60);
        naturalOrder.add(-5);
        naturalOrder.add(44);
        naturalOrder.add(83);

        System.out.println("natural order to string");
        System.out.println(naturalOrder); // Prints: [-5, 10, 22, 44, 60, 83]

        System.out.println("\nInorder iterator:");
        Iterator<Integer> inorderIterator = naturalOrder.iterator();
        while(inorderIterator.hasNext()) {
            System.out.println(inorderIterator.next()); // Prints: -5 \n 10 \n 22 \n 44 \n 60 \n 83
        }

        System.out.println("\nDescending iterator:");
        Iterator<Integer> reverseIterator = naturalOrder.descendingIterator();
        while(reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next()); // Prints: 83 \n 60 \n 44 \n 22 \n 10 \n -5
        }

        System.out.println("\nceiling()");
        System.out.println(naturalOrder.ceiling(15)); // Prints: 22
        System.out.println(naturalOrder.ceiling(100)); // Prints: null

        System.out.println("\nfloor()");
        System.out.println(naturalOrder.floor(50)); // Prints: 44
        System.out.println(naturalOrder.floor(-50)); // Prints: null

        System.out.println("\nReverse order with constructor:");
        TreeSet<Integer> reverseOrder = new TreeSet<>((a, b) -> (b-a));
        reverseOrder.add(50);
        reverseOrder.add(10);
        reverseOrder.add(100);
        reverseOrder.add(11);
        reverseOrder.add(47);

        System.out.println(reverseOrder.toString()); // Prints: [100, 50, 47, 11, 10]
    }
}
