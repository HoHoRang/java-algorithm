package methods;

//import java.util.Arrays;
//import java.util.Collections;

import java.util.Arrays;

class Pair {
  int y;
  int x;
  public Pair(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class ArraySort {
  public static void main(String[] args) {
//    // 오름차순
//    int a[] = {1, 3, 2, 1, 5};
//    Arrays.sort(a);
//    // 내림차순
//    Integer[] a = {1, 3, 2, 1, 5};
//    Arrays.sort(a, Collections.reverseOrder());
//    for (int i = 0; i < a.length; i++) {
//      System.out.println(a[i]);
//    }

    Pair[] a = {
        new Pair(1, 2),
        new Pair(3, 4),
        new Pair(2, 5),
        new Pair(10, 23),
        new Pair(10, 55),
    };

    // 1순위: y는 오름차순, 2순위: x는 내림차순
    Arrays.sort(a, (p1, p2) -> (p1.y == p2.y) ? Integer.compare(p2.x, p1.x) : Integer.compare(p1.y, p2.y));

    for(Pair pair: a) {
      System.out.println(pair.y + " " + pair.x);
    }
  }
}
