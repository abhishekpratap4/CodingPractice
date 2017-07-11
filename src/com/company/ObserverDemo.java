package com.company;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pratap on 5/7/17.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        MyInternet internet = new MyInternet();
        MyNewspaper newspaper = new MyNewspaper();

        MyLoan loan = new MyLoan("Savings", "ICICI", 4.0f);
        loan.addObserver(internet);
        loan.addObserver(newspaper);
        loan.setInterest(5.0f);
    }
}

class MyInternet implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Internet: " + o.toString());
    }
}

class MyNewspaper implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Newspaper: " + o.toString());
    }
}

class MyLoan extends Observable {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
        notifyObservers(null);
    }

    @Override
    public String toString() {
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append(this.getBank() + " -> ").append(this.getType() + " -> ").append(this.getInterest());
        return textBuilder.toString();
    }

    private String type;
    private String bank;
    private float interest;

    public MyLoan(String t, String b, float i) {
        type = t;
        bank = b;
        interest = i;
    }
}