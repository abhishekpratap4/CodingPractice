package com.company;

import java.util.Scanner;

/**
 * Created by pratap on 4/29/17.
 */
public class MissingBracketCombinations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        if (brackets.isEmpty())
            System.out.println(0);
        int missingType = Integer.parseInt(scanner.nextLine());
        if (missingType == 1) {
            System.out.print(processBracketsFromBack(brackets));
        } else if (missingType == 2) {
            System.out.print(processBracketsFromFront(brackets));
        } else {
            System.out.println(0);
        }
    }

    private static int processBracketsFromFront(String brackets) {
        int count = 0;
        for (int i = 0; i < brackets.length(); i++) {
            if (i + 1 < brackets.length() && brackets.charAt(i) == '(' && brackets.charAt(i + 1) == '(')
                count++;
            else if (i + 1 < brackets.length() && brackets.charAt(i) == ')' && brackets.charAt(i + 1) == '(')
                count++;
        }
        return count + 1;
    }

    private static int processBracketsFromBack(String brackets) {
        int count = 0;
        for (int i = brackets.length() - 1; i >= 0; i--) {
            if (i - 1 >= 0 && brackets.charAt(i) == ')' && brackets.charAt(i - 1) == ')')
                count++;
            else if (i - 1 >= 0 && brackets.charAt(i) == '(' && brackets.charAt(i - 1) == ')')
                count++;
        }
        return count + 1;
    }
}
