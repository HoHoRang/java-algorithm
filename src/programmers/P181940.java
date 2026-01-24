package programmers;

import java.util.Arrays;
import java.util.List;

// 문자열 곱하기
// https://school.programmers.co.kr/learn/courses/30/lessons/181940
public class P181940 {

  public static void main(String[] args) {
    P181940 solver = new P181940();

    List<TestCase> testCases = Arrays.asList(
        new TestCase("string", 3, "stringstringstring"),
        new TestCase("love", 10, "lovelovelovelovelovelovelovelovelovelove")
    );

    for (int i = 0; i < testCases.size(); i++) {
      TestCase tc = testCases.get(i);
      String result = solver.solution(tc.my_string, tc.k);
      boolean passed = result.equals(tc.expected);

      System.out.printf("Test %d: %s (expected: %s, got: %s)%n",
          i + 1, passed ? "PASS" : "FAIL", tc.expected, result);
    }
  }

  static class TestCase {
    String my_string;
    int k;
    String expected;

    TestCase(String my_string, int k, String expected) {
      this.my_string = my_string;
      this.k = k;
      this.expected = expected;
    }
  }

  public String solution(String my_string, int k) {
    String answer = "";

    for (int i = 0; i < k; i++) {
      answer = answer.concat(my_string);
    }

//    // 더 나은 답
//    return my_string.repeat(k);

    return answer;
  }
}