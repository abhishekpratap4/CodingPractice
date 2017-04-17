package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pratap on 11/13/16.
 */
public class JumpingProblem {
    static int Dx, Dy, J;

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int building[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                building[i][j] = s.nextInt();
            }
        }
         Dx = s.nextInt();
         Dy = s.nextInt();
         J = s.nextInt();

        floydWarshall(building, N, M);
    }

    private static void floydWarshall(int[][] building, int N, int M) {
        int NM = N * M;
        int dist[][] = new int[NM][NM];
        for (int i = 0; i < NM; i++) {
            for (int j = 0; j < NM; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (building[i][j] - building[i][j+1] <= J){

                    }

                }
            }

    }
}
