package com.balaji.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Examples of java record, introduced in Java 14.
 * Source: <a href="https://docs.oracle.com/en/java/javase/24/language/records.html">records - Oracle Docs</a>
 */
public class RecordExample {
    // This is equivalent to creating an AccountDetails class with private final fields name, id, and income
    // with getters name(), id(), and income(). This also creates an equals and hashcode methods which
    // specify that two records are equal if they are of same type and contain equal values, and a toString()
    // method.
    private record AccountDetail(String name, String id, int income){}

    // Adding a compact constructor that has checks, at the end of the constructor field assignment is
    // automatically added.
    private record AccountWithConstructor(String name, String id, int income) {
        public AccountWithConstructor{
            if(income < 0) {
                String message = String.format("Income should be positive, income = %s", income);
                throw new IllegalArgumentException(message);
            }
        }
    }

    public static void main(String[] args) {
        AccountDetail one = new AccountDetail("One", "001", 100);
        AccountDetail two = new AccountDetail("Two", "002", 150);

        AccountDetail duplicate = new AccountDetail("One", "001", 100);

        // one.name = "Changed"; Will not compile as field values are final.
        System.out.println(one.name()); // Prints: One
        System.out.println(one.income*2); // Prints: 200
        System.out.println(one.toString()); // Prints: AccountDetail[name=One, id=001, income=100]

        System.out.println(one.equals(two)); // Prints: false
        System.out.println(one.equals(duplicate)); // Prints: true

        Set<AccountDetail> accountSet = new HashSet<>();
        accountSet.add(one);
        accountSet.add(two);
        accountSet.add(duplicate);

        // Duplicate is not added.
        System.out.println(accountSet); // Prints: [AccountDetail[name=One, id=001, income=100], AccountDetail[name=Two, id=002, income=150]]

        try {
            AccountWithConstructor negative = new AccountWithConstructor("Sample", "008", -20);
            System.out.println(negative.toString()); // never executed as constructor throws an IllegalArgumentException.
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage()); // Prints: Income should be positive, income = -20
        }
    }
}