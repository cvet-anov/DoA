package Lab1;
import java.util.Arrays;



public class Transform {



    private static final int maxN = 55;

    private static int[] A = null;

    private static int[] B = null;



    private static int solve( int a_idx, int b_idx ){

        int rv = 0;

        for( int i = 0 ; i < A.length ; i++ ){

            rv += Math.abs( A[a_idx] - B[b_idx] );

            a_idx++;

            b_idx++;

            if( b_idx == A.length ) b_idx = 0;

        }

        return rv;

    }



    private static int solve(){

        int rv = Integer.MAX_VALUE;

        for( int i = 0 ; i < A.length ; i++ ){

            rv = Integer.min( rv, solve( 0, i ) + i );

        }

        return rv;

    }



    public static int count( int[] A, int[] B ){

        Transform.A = A;

        Transform.B = B;

        return solve();

    }



}

