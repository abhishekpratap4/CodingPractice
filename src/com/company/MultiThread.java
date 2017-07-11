package com.company;

/**
 * Created by pratap on 5/19/17.
 */
public class MultiThread {
    public static void main(String[] args) {
        Thread t1, t2;
        OddPrinter first = new OddPrinter();
        synchronized (first) {
            processThread(first, "firstThread");
        }
    }

    private static void processThread(OddPrinter first, String name) {
        Thread t = new Thread(first, name);
        t.start();
    }
}

class OddPrinter implements Runnable {
    public void run() {
        try {
            for (int n = 0; n <= 10; n++) {
                if ((n % 2) != 0)
                    System.out.println(" Odd Thread" + n);
                Thread.sleep(1000);
            }
            System.out.println("Exiting Odd Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}