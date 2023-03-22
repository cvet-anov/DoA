package Lab1;
import java.util.Arrays;



public class IpAddresses {



    static final int maxL = 105, maxK = 105, MOD = 1000000007;

    static String S = null;

    static int[][] dp = new int[maxL][maxK];



    static private int mod_sum( int p, int q ){

        return (p + q) % IpAddresses.MOD;

    }



    static private boolean is_valid( String ip_field ){

        if( Integer.parseInt( ip_field ) > 255 ) return false;

        return ip_field.equals("0") || ip_field.charAt(0) != '0';

    }



    static private int solve( int idx, int k ){

        if( k == 0 ) return ( idx == S.length() ? 1 : 0 );

        if( idx == S.length() ) return 0;

        if( dp[idx][k] != -1 ) return dp[idx][k];

        int rv = 0;

        for( int i = 1 ; i <= 3 ; i++ ){

            if( idx+i > S.length() ) continue;

            String ip_field = S.substring( idx, idx+i );

            if( !is_valid( ip_field ) ) continue;

            rv = mod_sum( rv, solve( idx+i, k-1 ) );

        }

        return dp[idx][k] = rv;

    }



    static public int minTransformations( String S, int k ){

        for( int[] row: dp ) Arrays.fill( row, -1 );

        IpAddresses.S = S;

        return solve( 0, k );

    }



    static public void main( String[] args ){

        int result = minTransformations( "1234567", 3 );

    }



}

