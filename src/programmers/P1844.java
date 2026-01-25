package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class P1844 {

  public static void main(String[] args) {
    P1844 instance = new P1844();

    int[][] maps = {
        {1,0,1,1,1},
        {1,0,1,0,1},
        {1,0,1,1,1},
        {1,1,1,0,1},
        {0,0,0,0,1}
    };
    System.out.println(instance.solution(maps));
  }

  public int solution(int[][] maps) {
    int answer = 0;

    int n = maps.length;        // 세로 (행 개수)
    int m = maps[0].length;     // 가로 (열 개수)
    boolean[][] visited = new boolean[n][m];

    // 큐에는 현재 좌표랑, 거리를 넣어줌
    Queue<int[]> queue = new LinkedList<>();
    visited[0][0] = true;
    queue.offer(new int[]{0, 0, 1}); // 현재 좌표: 0,0 거리: 1

    // BFS로 노드들을 탐색
    // visited가 아닌 경우에만 탐색 진행
    while (!queue.isEmpty()) {
      int[] cur =  queue.poll();
      int row = cur[0];      // 행 (y좌표)
      int col = cur[1];      // 열 (x좌표)
      int distance = cur[2];

      // 도착점 체크
      if (row == n - 1 && col == m - 1) {
        return distance;
      }

      // 상하좌우 탐색
      // 상 (row-1)
      if (row - 1 >= 0 && !visited[row-1][col] && maps[row-1][col] == 1) {
        visited[row-1][col] = true;
        queue.offer(new int[]{row-1, col, distance + 1});
      }

      // 하 (row+1)
      if (row + 1 < n && !visited[row+1][col] && maps[row+1][col] == 1) {
        visited[row+1][col] = true;
        queue.offer(new int[]{row+1, col, distance + 1});
      }

      // 좌 (col-1)
      if (col - 1 >= 0 && !visited[row][col-1] && maps[row][col-1] == 1) {
        visited[row][col-1] = true;
        queue.offer(new int[]{row, col-1, distance + 1});
      }

      // 우 (col+1)
      if (col + 1 < m && !visited[row][col+1] && maps[row][col+1] == 1) {
        visited[row][col+1] = true;
        queue.offer(new int[]{row, col+1, distance + 1});
      }
    }

    return -1;
  }
}
