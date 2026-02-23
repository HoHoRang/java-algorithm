package methods;

import java.util.HashMap;

public class Stream {
  public static void main(String[] args) {
//    int[] arr = {1, 2, 3, 4, 5};

//    // 특정 값 찾기
//    int target = 3;
//    boolean found = Arrays.stream(arr).anyMatch(x -> x == target);
//    System.out.println(found);

//    // reduce 사용
//    int ret = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
//    System.out.println(ret);

//    // map, filter 사용
//    int[] ret = Arrays.stream(arr)
//        .filter(a -> a % 2 == 0)
//        .map(a -> a * 2)
//        .toArray();
//    for (int i: ret) {
//      System.out.println(i);
//    }

    // HashMap에서의 stream 사용
    HashMap<String, Integer> mp = new HashMap<>();
    mp.put("a", 1);
    mp.put("b", 2);
    mp.put("c", 3);

    mp.values().stream().forEach(e -> System.out.println(e));
    mp.keySet().stream().forEach(e -> System.out.println(e));
  }
}
