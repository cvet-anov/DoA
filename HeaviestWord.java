

public class HeaviestWord {
    public static int findVocals(String word) {
        int vocal = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                vocal++;
            }
        }
        System.out.format("%s %d\n",word,vocal);
        return vocal;
    }
    public static String heaviest(String[] words) {
        int maxvocal = 0;
        int index = 0;
        int max=findVocals(words[0]);
        for (int i = 0; i < words.length-1; i++) {
            max=Math.max(max, findVocals(words[i+1]));
        }
        for (int i=0;i<words.length;i++)
        {
            if (findVocals(words[i])==max)
            {
                return words[i];
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String[] words = {"akjqwhe", "asdasd", "qwe", "asde", "asdasd", "qweqwe","af", "qqqqqqq", "aeoi"};
        String longestString = heaviest(words);
        System.out.format("heaviest string: '%s'\n", longestString);
    }
}
