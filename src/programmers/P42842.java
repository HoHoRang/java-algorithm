package programmers;

import java.util.Arrays;

// 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class P42842 {

  public static void main(String[] args) {
    P42842 instance = new P42842();

    int brown = 10;
    int yellow = 2;

    System.out.println(Arrays.toString(instance.solution(brown, yellow)));
  }

  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];

    int wholeTileNum = brown + yellow;

    // x * y = brown + yellow;
    // x >= y
    // brown >= 8
    // yellow >= 1

    for (int i = 1; i <= Math.sqrt(wholeTileNum); i++) {
      int y = i;
      int x = wholeTileNum / y;

      if ((x-2) * (y-2) == yellow) {
        answer[0] = x;
        answer[1] = y;
        break;
      }
    }

    return answer;
  }

}
