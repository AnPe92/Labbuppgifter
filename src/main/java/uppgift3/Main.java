package uppgift3;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("\\S*[aeiou][a-zA-Z]*[aeiou]\\S*", Pattern.CASE_INSENSITIVE);




        List<String> words = List.of("Karta","Mobil","Datorstol","Kaffemugg","Katt","Hund","Tejp","ssssss", "Anton", "Aanaanas");

        List<String> wordsWithTwoVowels =
                words
                    .stream()
                    .filter(x -> pattern.matcher(x).matches())
                    .collect(Collectors.toList());

        System.out.println(wordsWithTwoVowels);





    }
}
