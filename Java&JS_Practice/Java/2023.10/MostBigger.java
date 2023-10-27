import java.util.Arrays;
import java.util.Comparator;

public class MostBigger {
    public String mostBigger(int[] numbers) {
        // int 배열을 문자열로 변환
        String[] numsAsStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numsAsStrings[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 조합하여 비교하기 위한 Comparator를 정의
        Arrays.sort(numsAsStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 두 문자열을 이어 붙인 경우를 비교
                String combination1 = s1 + s2;
                String combination2 = s2 + s1;
                return combination2.compareTo(combination1);
            }
        });

        // 문자열을 이어붙여서 가장 큰 수 생성
        StringBuilder result = new StringBuilder();
        for (String numAsString : numsAsStrings) {
            result.append(numAsString);
        }

        // 0이 여러 번 나올 경우를 처리하기 위해 예외 처리
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }

    public static void main(String[] args) {
      MostBigger mostBigger = new MostBigger();

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(mostBigger.mostBigger(numbers1)); // "6210"
        System.out.println(mostBigger.mostBigger(numbers2)); // "9534330"
    }
}
