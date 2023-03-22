package Lab;

public class HeaviestWord {
    public static String heaviest(String[] words) {
        int maxVowels = 0;
        int flag=0;
        String lastword="";
        String heaviestWord = "";

        for (String word : words) {
            int numVowels = 0;

            for (char c : word.toCharArray()) {
                if ("aeiouy".indexOf(c) != -1) {
                    numVowels++;
                }
            }
            lastword=word;
            if (numVowels > maxVowels || (numVowels == maxVowels && word.compareTo(heaviestWord) < 0)) {
                flag=1;
                maxVowels = numVowels;
                heaviestWord = word;
            }
        }

        if (flag==0){
            return lastword;
        }
        else
            return heaviestWord;
    }
}
