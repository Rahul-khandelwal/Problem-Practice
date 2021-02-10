package practice.codechef;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/FRGTNLNG
 *
 * @author in-rahul.khandelwal
 */
public class ForgottenLanguage {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int t = 0; t < tests; t++) {
            int numOfWords = sc.nextInt();
            int numOfPhrases = sc.nextInt();
            var output = new String[numOfWords];
            Arrays.fill(output, "NO");

            var words = new String[numOfWords];
            for (int w = 0; w < numOfWords; w++) {
                words[w] = sc.next();
            }

            var phraseWords = new HashSet<>();

            for (int n = 0; n < numOfPhrases; n++) {
                int wordsInPhrase = sc.nextInt();

                for (int w = 0; w < wordsInPhrase; w++) {
                    phraseWords.add(sc.next());
                }
            }

            for (int w = 0; w < numOfWords; w++) {
                if (phraseWords.contains(words[w])) {
                    output[w] = "YES";
                }
            }

            System.out.println(String.join(" ", output));
        }
    }
}
