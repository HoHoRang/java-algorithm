package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 모의고사
public class P42840 {

  public static void main(String[] args) {
    P42840 instance = new P42840();

//    int[] answers = {1, 2, 3, 4, 5};
    int[] answers = {1, 3, 2, 4, 2};

    System.out.println(Arrays.toString(instance.solution(answers)));
  }

  public int[] solution(int[] answers) {
    int[] answer = {};

    int[] person1 = {1, 2, 3, 4, 5};
    int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    List<Integer> correct = new ArrayList<>(3);
    List<Integer> highScore = new ArrayList<>(3);

    correct.add(0);
    correct.add(0);
    correct.add(0);

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == person1[i % person1.length]) {
        correct.set(0, correct.get(0) + 1);
      }
      if (answers[i] == person2[i % person2.length]) {
        correct.set(1, correct.get(1) + 1);
      }
      if (answers[i] == person3[i % person3.length]) {
        correct.set(2, correct.get(2) + 1);
      }
    }

    int max = correct.stream().max(Integer::compareTo).orElse(0);

    IntStream.range(0, correct.size())
        .filter(index -> correct.get(index) == max)
        .forEach(index -> highScore.add(index+1));

    answer = highScore.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }
}
