package hackercup;

import java.util.Scanner;

/**
 * Created by pratap on 1/7/17.
 */
public class ProgressPie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i = 1;
        while (i <= T) {
            int P = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String color = determineColor(P, X, Y);
            System.out.format("Case #%d: %s\n", i, color);
            i++;
        }
    }

    public static String determineColor(int P, int X, int Y) {
        if (P == 0)
            return "white";
        else if (X == 50 && Y == 50)
            return "black";

        double distance = Math.sqrt((50.0 - X) * (50.0 - X) + (50.0 - Y) * (50.0 - Y));

        System.out.println("Distance is : " + distance);

        int radius = 50;

        double distDiff = Math.abs(radius - distance);

        System.out.println("Distance diff is : " + distDiff);

        if (distance > radius && distDiff > 0.000001)
            return "white";

        double progressAngleDegree = (P / 100.0) * 360.0;

        System.out.println("Progress angle is : " + progressAngleDegree);

        double slope = (50.0 - Y) / (50.0 - X);

        double slopeDegree = Math.toDegrees(Math.atan(slope));

        System.out.println("Slope is : " + slopeDegree);

        double estimatedProgressDegree = 0.0;


        if (slopeDegree == 90.0)
            estimatedProgressDegree = 180;
        else if (slopeDegree < 90 && X >= 50) {
            estimatedProgressDegree = 90 - slopeDegree;
        } else if (slopeDegree < 90 && X < 50) {
            estimatedProgressDegree = 270 - slopeDegree;
        } else if (slopeDegree > 90 && X >= 50) {
            estimatedProgressDegree = 270 - slopeDegree;
        } else if (slopeDegree > 90 && X < 50) {
            estimatedProgressDegree = 450 - slopeDegree;
        }

        System.out.println("Estimated progress angle is : " + estimatedProgressDegree);

        if (estimatedProgressDegree > progressAngleDegree) {
            return "white";
        }

        return "black";
    }
}
