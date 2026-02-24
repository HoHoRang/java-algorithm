package programmers;

// 피로도
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class P87946 {

  private static boolean[] visited;
  private static int max = 0;

  public static void main(String[] args) {
    P87946 instance = new P87946();

    int k = 80;
    int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

    System.out.println(instance.solution(k, dungeons));
  }

  public int solution(int k, int[][] dungeons) {
    visited = new boolean[dungeons.length];

    DFS(k, 0, dungeons);

    return max;
  }

  private static void DFS(int hp, int count, int[][] dungeons) {
    max = Math.max(max, count);

    for (int i = 0; i < dungeons.length; i++ ) {
      int required = dungeons[i][0];
      int consume = dungeons[i][1];

      if (!visited[i] && required <= hp) {
        visited[i] = true;

        DFS(hp - consume, count+1, dungeons);

        visited[i] = false;
      }
    }
  }
}
