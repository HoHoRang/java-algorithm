package programmers;

import java.util.HashMap;
import java.util.Map;

public class P42576 {

  public static void main(String[] args) {
    P42576 instance = new P42576();

    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    String result = "leo";

    System.out.println(instance.solution(participant, completion));
  }


  public String solution(String[] participant, String[] completion) {
    Map<String, Integer> map = new HashMap<>();

    for (String name: participant) {
      if (!map.containsKey(name)) {
        map.put(name, 1);
      } else {
        map.put(name, map.get(name) + 1);
      }
    }

    for (String name: completion) {
      if (!map.containsKey(name)) {
        map.put(name, 1);
      } else {
        map.put(name, map.get(name) + 1);
      }
    }

    return map.keySet().stream().filter((s) -> map.get(s) % 2 != 0).findFirst().orElse("");
  }
}
