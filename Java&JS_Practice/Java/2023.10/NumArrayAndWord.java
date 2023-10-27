import java.util.HashMap;
import java.util.Map;

//1
public class NumArrayAndWord {
  public int solution(String s) {
    Map<String, String> wordToNumber = new HashMap<>();
    wordToNumber.put("zero", "0");
    wordToNumber.put("one", "1");
    wordToNumber.put("two", "2");
    wordToNumber.put("three", "3");
    wordToNumber.put("four", "4");
    wordToNumber.put("five", "5");
    wordToNumber.put("six", "6");
    wordToNumber.put("seven", "7");
    wordToNumber.put("eight", "8");
    wordToNumber.put("nine", "9");

    StringBuilder result = new StringBuilder();
    StringBuilder currentWord = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        // 현재 문자가 숫자인 경우, 결과에 추가
        result.append(c);
      } else {
        // 현재 문자가 영단어인 경우, 현재 단어에 추가
        currentWord.append(c);
        if (wordToNumber.containsKey(currentWord.toString())) {
          // 현재 단어가 영단어로 해석 가능한 경우, 결과에 추가하고 현재 단어 초기화
          result.append(wordToNumber.get(currentWord.toString()));
          currentWord.setLength(0);
        }
      }
    }

    return Integer.parseInt(result.toString());
  }
}


//2
class Solution {
    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}