package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pratap on 5/4/17.
 */

class Employee implements Comparable<Employee> {
    String name;
    int age;

    public Employee(String s, int a) {
        name = s;
        age = a;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;
        }
    };
}

public class TestComparison {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Abhishek", 26));
        list.add(new Employee("Pratap", 25));
        list.add(new Employee("Singh", 29));
        list.add(new Employee("Raj", 22));
        list.add(new Employee("Kumar", 32));
        System.out.println(list);
        Collections.sort(list, Comparator.<Employee>reverseOrder());
        System.out.println(list);
        Collections.sort(list, Employee.ageComparator);
        System.out.println(list);
    }
}
