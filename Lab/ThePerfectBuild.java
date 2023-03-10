package Lab;

public class ThePerfectBuild {
    public static int getStrongness(String heroType, int gold, int n, String items) {
        int[] dp = new int[gold+1];
        String[] itemStr = items.split(",");
        int[][] item = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] attr = itemStr[i].split(";");
            for (int j = 0; j < 4; j++) {
                item[i][j] = Integer.parseInt(attr[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = item[i][0]; j <= gold; j++) {
                dp[j] = Math.max(dp[j], dp[j-item[i][0]] + calculateStrongness(heroType, item[i][1], item[i][2], item[i][3]));
            }
        }
        return dp[gold];
    }

    private static int calculateStrongness(String heroType, int strength, int agility, int intelligence) {
        if (heroType.equals("agility")) {
            return agility * 100 + intelligence * 10 + strength;
        } else if (heroType.equals("strength")) {
            return strength * 100 + agility * 10 + intelligence;
        } else {
            return intelligence * 100 + strength * 10 + agility;
        }
    }
}