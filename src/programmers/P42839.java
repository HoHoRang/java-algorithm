package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 소수 찾기(미완성)
public class P42839 {

  public static void main(String[] args) {
    P42839 instance = new P42839();

    String numbers = "17";
    System.out.println(instance.solution(numbers));
  }

  public int solution(String numbers) {
    int answer = 0;

    Set<Integer> set = new HashSet<>();

    String[] numList = numbers.split("");

    System.out.println(Arrays.toString(numList));

    return answer;
  }

  public boolean isPrimeNumber(int number) {
    for (int i = 2; i < number/2; i++) {
      if (number % i == 0) return false;
    }
    return true;
  }
}
