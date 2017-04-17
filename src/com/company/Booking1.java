package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 2/17/17.
 */
public class Booking1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int square_count = 0, rect_count = 0, other_count = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.isEmpty())
                break;
            String arr[] = line.split(" ");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int C = Integer.parseInt(arr[2]);
            int D = Integer.parseInt(arr[3]);
            if (A <= 0 || B <=0 || C <=0 || D<=0)
                other_count++;
            else if(A == B && B == C && C == D)
                square_count++;
            else if(A == C && B == D )
                rect_count++;
            else
                other_count++;

        }
        System.out.println(square_count + " " + rect_count + " " + other_count);
    }
}
