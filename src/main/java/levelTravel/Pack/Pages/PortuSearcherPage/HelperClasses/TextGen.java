package levelTravel.Pack.Pages.PortuSearcherPage.HelperClasses;

import java.util.*;

public class TextGen {

    public static void main(String[] args) {

        String s = "However, conversely there is no way to explicitly set the seed so it can be difficult to reproduce results in situations where that is useful such as testing or saving game states or similar. In those situations, the pre-Java 1.7 technique shown below can be used.";
        //System.out.println(ParsExecutor.stringRandomParsing(s, 5));
        System.out.println(Spliterator.splitAndGenAnyText(100));
        System.out.println(Spliterator.splitAndGenAnyText(500));

    }


}

class Spliterator {

    //Дописать! Придумать как метод будет понимать, что:
    // 1)Если перед ним было 2 согласных/гласных(буквы с индексом 0/1), то тогда делаем i--.
    // 2)Добавить проверку на то, что если остается посл. символ по указанному кол-ву, то ставить точку.
    static String splitAndGenAnyText(int countOfSymbols) {
        Random random = new Random();
        String vocabulary = "a b c d e f g h i j k l m n o p q r s t u v w x y z . , ? !";
        ArrayList<String> vocabularyList = new ArrayList<>();
        String resultString = "";
        String[] letters = vocabulary.split(" ");
        for (String s : letters) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u") || s.equals("y")) {
                vocabularyList.add(0, s);
            } else if (s.equals(".") || s.equals(",") || s.equals("?") || s.equals("!")) {
                vocabularyList.add(2, s);
            } else {
                vocabularyList.add(1, s);
            }
        }
        for (int i = 0; i < countOfSymbols; i++) {
            String s = vocabularyList.get(random.nextInt(30));
            boolean b = s.equals(".") || s.equals("?") || s.equals("!") || s.equals(",");
            if (resultString.endsWith(".") || resultString.endsWith("?") || resultString.endsWith("!")) {
                if (b) {
                    i--;
                } else {
                    resultString = resultString.concat(" ");
                    resultString = resultString.concat(s.toUpperCase());
                }
            } else if (resultString.endsWith(",")) {
                if (b){
                    i--;
                } else {
                    resultString = resultString.concat(" ");
                    resultString = resultString.concat(s);
                }
            } else if (resultString.length() == 0) {
                if (b) {
                    i--;
                } else {
                    resultString = resultString.concat(s.toUpperCase());
                }
            } else if (resultString.endsWith(s.concat(s))) {
                i--;
            } else {
                resultString = resultString.concat(s);
            }
        }
        return resultString;
    }
}

class ParsExecutor {

    static String stringRandomParsing(String anyText, int needWordCount) {

        ArrayList<String> startStringList = new ArrayList<>();
        ArrayList<String> finishStringList = new ArrayList<>();
        Random random = new Random();
        String ss = "Result = ";
        String pattern = "\\s+|,\\s*";
        String[] userStrings = anyText.split(pattern);
        for (String s : userStrings) {
            String word = s.toLowerCase();
            startStringList.add(word);
        }
        if (needWordCount <= startStringList.size()) {
            for (int i = 0; i < needWordCount; i++) {
                String s = startStringList.get(random.nextInt(startStringList.size() - 1));
                if (finishStringList.contains(s)) {
                    i--;
                } else {
                    finishStringList.add(s);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Please enter correct needWordCount!");
        }
        return ss.concat(finishStringList.toString());
    }
}
