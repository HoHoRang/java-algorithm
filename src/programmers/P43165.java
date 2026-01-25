package programmers;

// 타겟 넘버
public class P43165 {

  public static void main(String[] args) {
    P43165 instance = new P43165();

    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    System.out.println(instance.solution(numbers, target));
  }

  public int solution(int[] numbers, int target) {
    int answer = 0;

    answer = dfs(numbers, target, 0, 0);

    return answer;
  }

  public int dfs(int[] numbers, int target, int index, int sum) {
    // 종료점 설정
    if (index == numbers.length) {
      return sum == target ? 1 : 0;
    }
    return dfs(numbers, target, index + 1, sum + numbers[index]) + dfs(numbers, target, index + 1, sum - numbers[index]);
  }
}
