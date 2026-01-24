package programmers;

import java.util.Arrays;
import java.util.List;

// 공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/181936
public class P181936 {
  public static void main(String[] args) {
    P181936 solver = new P181936();

    List<TestCase> testCases = Arrays.asList(
        new TestCase(60, 2, 3, 1),
        new TestCase(55, 10, 5, 0)
    );

    for (int i = 0; i < testCases.size(); i++) {
      TestCase tc = testCases.get(i);
      int result = solver.solution(tc.number, tc.n, tc.m);
      boolean passed = result == tc.result;

      System.out.printf("Test %d: %s (expected: %s, got: %s)%n",
          i + 1, passed ? "PASS" : "FAIL", tc.result, result);
    }
  }

  static class TestCase {
    int number;
    int n;
    int m;
    int result;

    TestCase(int number, int n, int m, int result) {
      this.number = number;
      this.n = n;
      this.m = m;
      this.result = result;
    }
  }

  public int solution(int number, int n, int m) {
    int answer = 0;

    if (number % n == 0 && number % m == 0) {
      answer = 1;
    } else {
      answer = 0;
    }

    return answer;
  }
}
