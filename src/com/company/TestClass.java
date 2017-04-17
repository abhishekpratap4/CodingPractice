package com.company;

/**
 * Created by pratap on 1/25/17.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


class TestClass {
//    public static void main(String args[] ) throws Exception {
//        /*
//         * Read input from stdin and provide input before running
//         * Use either of these methods for input
//
//        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//        */
//        //Scanner
//        Scanner s = new Scanner(System.in);
//        int T = s.nextInt();
//        while(T > 0){
//            int N = s.nextInt();
//            int arr[] = new int[N];
//            for(int i = 0; i<N; i++){
//                arr[i] = s.nextInt();
//            }
//            System.out.print(contiguousArraySum(arr));
//            System.out.print(" ");
//            System.out.print(nonContiguousArraySum(arr));
//            T--;
//        }
//    }

    static int contiguousArraySum(int[] arr){
        int maxEndHere = arr[0];
        int maxSoFar = arr[0];

        for(int i = 1;i<arr.length;i++){
            maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    static int nonContiguousArraySum(int[] arr){
        boolean flag = false;
        int sum = 0;
        int max = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= 0){
                sum = sum + arr[i];
                flag = true;
            }
            else if(max < arr[i]){
                max = arr[i];
            }
        }
        if(!flag){
            // int max = arr[0];
            // for(int j = 1;j<arr.length;j++){
            //     if(max < arr[j]){
            //         max = arr[j];
            //     }
            // }
            sum = max;
        }
        return sum;
    }

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        int arr[][] = new int[M][N];
        int output = 0;
        boolean visited[][] = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for(int j = 0; j<N;j++){
                arr[i][j] = s.nextInt();
            }
        }

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                int max = 0;
                if(arr[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    max++;
                    DFS(arr,visited,i,j,M,N,max);
                }
                if (max > output){
                    output = max;
                }
            }
        }
        System.out.println(output);
    }

    static void DFS(int arr[][], boolean visited[][], int x, int y, int m, int n, int max){
        int xArr[] = {-1,-1,-1,0,0,1,1,1};
        int yArr[] = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0;i<8;i++){
            int x1 = x+xArr[i];
            int y1 = y+yArr[i];

            if(x1>=0 && y1>=0 && x1 <m && y1 <n && arr[x1][y1] == 1 && !visited[x1][y1]){
                visited[x1][y1] = true;
                max++;
                DFS(arr, visited, x1,y1,m,n,max);
            }
        }
    }
}

