package Lab1;

import java.util.Arrays;



public class Roman {



    private final static int maxN = 505;

    private static int[] arr = new int[maxN];

    private static int[][] dp = new int[maxN][maxN];



    private static int solve( int idx, int k ){

        if( idx == arr.length ) return ( k == 0 ? 0 : Integer.MAX_VALUE );

        if( k == 0 ) return Integer.MAX_VALUE;

        if( dp[idx][k] != -1 ) return dp[idx][k];

        int rv = Integer.MAX_VALUE;

        int running_sum = 0;

        for( int i = 0 ; i+idx < arr.length ; i++ ){

            running_sum += arr[idx+i];

            rv = Math.min( rv, Math.max( running_sum, solve( idx+i+1, k-1 ) ) );

        }

        return dp[idx][k] = rv;

    }



    public static int countPages( int N, int K, int[] arr ) {

        for( int[] row: dp ) Arrays.fill( row, -1 );

        Roman.arr = arr;

        return solve( 0, K );

    }



}

