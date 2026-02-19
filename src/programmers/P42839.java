package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class P42839 {

  public static void main(String[] args) {
    P42839 instance = new P42839();

    String numbers = "011";
    System.out.println(instance.solution(numbers));
  }

  Set<Integer> primeNumbers = new HashSet<>();

  public int solution(String numbers) {
    int answer = 0;

    String[] numList = numbers.split("");

    boolean[] visited = new boolean[numbers.length()]; // 각 숫자마다 방문여부

    System.out.println(Arrays.toString(numList));

    // 자리수
    for (int i = 0; i < numList.length; i++) {
      dfs(numbers, "", i+1, 0, visited);
    }

    answer = primeNumbers.size();

    return answer;
  }

  public void dfs(String numbers, String curNum, int length, int index, boolean[] visited) {
    if (length == index) {
      int num = Integer.parseInt(curNum);
      if (isPrimeNumber(num)) {
        primeNumbers.add(num);
      }
      return;
    }

    for (int i = 0; i < numbers.length(); i++) {
      if (visited[i]) continue;

      visited[i] = true;

      dfs(numbers, curNum + numbers.charAt(i), length, index+1, visited);

      visited[i] = false;
    }
    return;
  }

  // 소수 체크
  public boolean isPrimeNumber(int number) {
    if (number == 2) return true;
    if (number == 1 || number % 2 == 0) return false;

    for (int i = 3; i <= Math.sqrt(number); i+= 2) {
      if (number % i == 0) return false;
    }

    return true;
  }
}
