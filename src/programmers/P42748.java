package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42748 {

  public static void main(String[] args) {
    P42748 instance = new P42748();

    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    System.out.println(Arrays.toString(instance.solution(array, commands)));
  }

  public int[] solution(int[] array, int[][] commands) {
//    int[] answer = {};
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < commands.length; i++) {
      int[] subStr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
      answer.add(Arrays.stream(subStr).sorted().toArray()[commands[i][2]-1]);
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
