package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 10/8/16.
 */
public class PowerProblem {

     static void checkIfYCanBeExpressedInPowerOfX() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

         // compute log(y)/log(x) to get the power of x
        double result = Math.log10(y) / Math.log10(x);

         // to check if the returned result is integer or not
         System.out.print(Math.rint(result) == result ? true: false);
         //System.out.println(result%1==0);

    }

}
