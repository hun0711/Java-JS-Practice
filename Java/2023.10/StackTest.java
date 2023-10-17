import java.util.Stack;

public class StackTest {
    public static boolean Question(String s) {
        Stack<Character> stack = new Stack<>(); //스택 생성

        for (char bracket : s.toCharArray()) {
            if (bracket == '[') {
                stack.push(bracket);
            } else if (bracket == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // `[`와 `]` 이외의 문자가 포함되어있거나 괄호가 매칭되지 않음
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 모든 괄호가 매칭됨
    }

    public static void main(String[] args) {
        String input1 = "[[[]]]";
        String input2 = "[[][";

        if (Question(input1)) {
            System.out.println("올바른 괄호");
        } else {
            System.out.println("올바르지 않은 괄호");
        }

        if (Question(input2)) {
            System.out.println("올바른 괄호");
        } else {
            System.out.println("올바르지 않은 괄호");
        }
    }
}
