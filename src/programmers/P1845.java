package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// 폰켓몬
public class P1845 {

  public static void main(String[] args) {
    P1845 instance = new P1845();

    int[] nums = {3,1,2,3};

    System.out.println(instance.solution(nums));
  }

  public int solution(int[] nums) {
    int answer = 0;

    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

    int uniquePonketmons = set.size();
    int half = nums.length / 2;

    answer = Math.min(uniquePonketmons, half);

    return answer;
  }
}
