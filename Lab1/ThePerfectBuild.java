package Lab1;
import java.util.Arrays;



public class ThePerfectBuild {



    final static int maxG = 100005, maxN = 55;

    static int[] price = new int[maxN];

    static int[] value = new int[maxN];

    final static String[] hero_types = {"strength", "agility", "intelligence"};

    final static int[][] dp = new int[maxG][maxN];

    static int N;



    private static int get_modifier( String type, int[] modifier ){

        for( int i = 0 ; i < 3 ; i++ ){

            if( type.equals( hero_types[i] ) ) return modifier[i];

        } return -1;

    }



    private static int strength_modifier( String type ){

        int[] modifier = {100, 1, 10};

        return get_modifier( type, modifier );

    }



    private static int agility_modifier( String type ){

        int[] modifier = {10, 100, 1};

        return get_modifier( type, modifier );

    }



    private static int intelligence_modifier( String type ){

        int[] modifier = {1, 10, 100};

        return get_modifier( type, modifier );

    }



    private static void set_item_prices( String item_input ){

        String[] item_raw_input = item_input.split(",");

        for( int i = 0 ; i < item_raw_input.length ; i++ ){

            String[] chunk = item_raw_input[i].split(";");

            price[i] = Integer.parseInt( chunk[0] );

        }

    }



    private static void set_item_values( String item_input, String hero_type ){

        int[] modifiers = {0, strength_modifier(hero_type), agility_modifier(hero_type), intelligence_modifier(hero_type)};

        String[] item_raw_input = item_input.split(",");

        for( int i = 0 ; i < item_raw_input.length ; i++ ){

            String[] chunk = item_raw_input[i].split(";");

            value[i] = 0;

            for( int j = 0 ; j < 4 ; j++ ){

                value[i] += modifiers[j] * Integer.parseInt( chunk[j] );

            }

        }

    }



    private static int solve( int gold, int idx ){

        if( gold == 0 || idx == N ) return 0;

        if( dp[gold][idx] != -1 ) return dp[gold][idx];

        return dp[gold][idx] = Math.max( ( gold >= price[idx] ? solve( gold-price[idx], idx ) + value[idx] : 0 ), solve( gold, idx+1 ) );

    }



    public static int getStrongness( String heroType, int gold, int n, String items ){

        for( int[] ints : dp ) Arrays.fill( ints, -1 );

        N = n;

        set_item_prices( items );

        set_item_values( items, heroType );

        return solve( gold, 0 );

    }



    // public static void main( String[] args ){

    //     System.out.println( getStrongness("intelligence", 17, 3, "8;9;10;6,9;7;3;11,7;9;5;11") );

    // }



}

