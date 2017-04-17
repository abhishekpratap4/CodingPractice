package com.company;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pratap on 10/20/16.
 */
public class ChiefHopper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int buildingHeights[] = new int[N+1];
        buildingHeights[0] = 0;
        for (int i = 1; i <= N; i++) {
            buildingHeights[i] = scanner.nextInt();
        }
        findEnergy(buildingHeights);
    }

    private static void findEnergy(int[] buildingHeights) {
        int minEnergy = buildingHeights[1];
        while(true){
            boolean result = checkValidity(minEnergy, buildingHeights);
            if(result){
                System.out.print(minEnergy);
                break;
            } else {
                minEnergy++;
            }
        }
    }

    private static boolean checkValidity(int minEnergy, int[] buildingHeights) {
        for (int i = 1; i < buildingHeights.length; i++) {
            if (buildingHeights[i] > minEnergy) {
                minEnergy = minEnergy - (buildingHeights[i] - minEnergy);
            } else {
                minEnergy = minEnergy + (minEnergy - buildingHeights[i]);
            }

            if(minEnergy < 0){
                System.out.println(minEnergy);
                return false;
            }
        }
        System.out.println(minEnergy);
        return true;
    }
}
