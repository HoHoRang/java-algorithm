package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class P42579 {

  public static void main(String[] args) {
    P42579 instance = new P42579();

    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
//    int[] results = {4, 1, 3, 0};

    int[] results = instance.solution(genres, plays);

    System.out.println(Arrays.toString(results));
  }

  public int[] solution(String[] genres, int[] plays) {
//    int[] answer = {};
    List<Integer> answer = new ArrayList<>();

    int songCount = plays.length;

    // 재생수 map 생성
    // {classic: [500(0), 150(2), 800(3)] -> [500, null, 150, 800, null]}
    // {pop: [600(1), 2500(4)] -> [null, 600, null, null, 2500]}
    Map<String, Integer[]> playMap = new HashMap<>();

    // 총 재생수 map 생성
    // {classic: 1450}
    // {pop: 3100}
    Map<String, Integer> totalMap = new HashMap<>();

    // map에 할당
    for(int i = 0; i < songCount; i++) {
      Integer[] value = playMap.getOrDefault(genres[i], new Integer[songCount]);
      value[i] = plays[i];
      playMap.put(genres[i], value);

      Integer count = totalMap.getOrDefault(genres[i], 0);
      count += plays[i];
      totalMap.put(genres[i], count);
    }

    // 총 재생수 map을 많이 재생한 순서대로
    // 그 안에서 최대 2개, 재생수 많은 곡의 index를 찾고 null로 업데이트
    totalMap.entrySet()
        .stream()
        .sorted((o1, o2) -> o2.getValue() - o1.getValue())
        .forEach((entry) -> {
          for (int i = 0; i < 2; i++) {
            Integer[] arr = playMap.get(entry.getKey());

            Integer max = Arrays.stream(arr).filter(Objects::nonNull).max(Integer::compareTo).orElse(0);

            IntStream.range(0, arr.length)
                .filter(v -> arr[v] == max)
                .findFirst()
                .ifPresent(v -> {
                  answer.add(v);
                  arr[v] = null;
                });
          }
        });

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
