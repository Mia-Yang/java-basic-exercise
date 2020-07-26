import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = args[0];
        String secondWordList = args[1];

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> firstList =  Arrays.stream(secondWordList.split(",")).map(String::toUpperCase).map(s->s.replace("", " ").trim()).collect(Collectors.toList());
        List<String> secondList =  Arrays.stream(firstWordList.split(",")).map(String::toUpperCase).map(s->s.replace("", " ").trim()).collect(Collectors.toList());

        for (String word:firstList){
            if (!word.matches("[A-Z ]+")) {
                throw new RuntimeException("input not valid");
            }
        }
        for (String word:secondList){
            if (!word.matches("[A-Z ]+")) {
                throw new RuntimeException("input not valid");
            }
        }

        List<String> result = firstList.stream().distinct().filter(secondList::contains).collect(Collectors.toList());
        return result;
    }
}
