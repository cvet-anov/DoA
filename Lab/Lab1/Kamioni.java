package Lab1;
import java.util.Arrays;



public class Kamioni {



    private static final int maxN = 55;

    private static int[] items;

    private static boolean[] taken = new boolean[maxN];



    private static int solve(){



        Arrays.fill( taken, false );



        Arrays.sort( items );



        int trucks = 0;

        for( int i = items.length - 1 ; i >= 0 ; i-- ){

            if( taken[i] ) continue;

            trucks++;

            for( int j = i-1 ; j >= 0 ; j-- ){

                if( items[i] + items[j] <= 300 && !taken[j] ){

                    taken[j] = true;

                    break;

                }

            }

        }



        return trucks;



    }



    public static int min( int[] items ){

        Kamioni.items = items;

        return solve();

    }



}

