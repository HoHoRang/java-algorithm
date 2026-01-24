package programmers;

import java.util.HashMap;
import java.util.Map;

// 의상
public class P42578 {

  public static void main(String[] args) {
    P42578 instance = new P42578();

    String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
//    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    System.out.println(instance.solution(clothes));
  }

  public int solution(String[][] clothes) {
    int answer = 0;

    Map<String, Integer> map = new HashMap<>();

    // {eyewear=1, headgear=2}
    for (String[] cloth: clothes) {
      map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
    }

    // 부위별 갯수를 곱한 수 - 1
    answer += map
        .values()
        .stream()
        .map(v -> v + 1)
        .reduce(1, (a, b) -> a * b) - 1;

    return answer;
  }
}
