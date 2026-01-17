import java.util.Arrays;
import java.util.List;

/**
 * klasa:   StringUtils
 * opis:    klasa zawiera narzedzia do obsługi typu łancuchowego String
 * metody:  vowelsCount - liczba samoglosek w podanym tekscie
 *          removeRepetitions - usuwa powtorzenia znakow obok siebie
 * autor:   00000000000
 *
 */
public class StringUtils {
    public static int vowelsCount(String text) {
        int count = 0;
        List<String> vowels = Arrays.asList("aąeęiouóyAĄEĘIOUÓY".split(""));
        for (int i = 0; i < text.length(); i++) {
            if (vowels.contains(String.valueOf(text.charAt(i)))) count++;
        }
        return count;
    }

    public static String removeRepetitions(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)) continue;
            result.append(text.charAt(i));
        }
        return result.toString();
    }
}
