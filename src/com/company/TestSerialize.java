package com.company;

import java.io.*;

/**
 * Created by pratap on 11/20/16.
 */
public class TestSerialize implements Serializable {

    String name;
    String pwd;
    TestSerialize test;

    TestSerialize(String n, String p, TestSerialize t) {
        name = n;
        pwd = p;
        test = t;
    }

    public static void main(String[] args) {
        TestSerialize t1 = new TestSerialize("User1", "Password1", null);
        t1.test = t1;
        try {
            FileOutputStream fos = new FileOutputStream("/Users/pratap/Desktop/Test.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t1);
            oos.close();
            fos.close();
            System.out.println("Serialization Complete!");

            FileInputStream fis = new FileInputStream("/Users/pratap/Desktop/Test.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            TestSerialize t2 = (TestSerialize) ois.readObject();
            fis.close();
            ois.close();
            System.out.println(t2.name + " - " + t2.pwd + " and " + t2.test.name + " - " + t2.test.pwd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
