package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 아이템 줍기
public class P87694 {

  public static void main(String[] args) {
    P87694 instance = new P87694();

    int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}; // 좌하단 x,y, 우상단 x,y
    int characterX = 1;
    int characterY = 3;
    int itemX = 7;
    int itemY = 8;

    System.out.println(instance.solution(rectangle, characterX, characterY, itemX, itemY));
  }

  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

    int[][] map = new int[102][102]; // 제약사항

    for (int[] rect: rectangle) {
      fill(map, rect[0] * 2, rect[1] * 2, rect[2] * 2, rect[3] * 2);
    }

    for (int[] rect: rectangle) {
      remove(map, rect[0] * 2, rect[1] * 2, rect[2] * 2, rect[3] * 2);
    }

    return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
  }

  // 직사각형 테두리 그리기
  public void fill(int[][] map, int x1, int y1, int x2, int y2) {
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (map[i][j] == 2) continue;
        map[i][j] = 1;
      }
    }
  }

  // 겹친 직사각형 내부 테두리 지우기
  public void remove(int[][] map, int x1, int y1, int x2, int y2) {
    for (int i = x1 + 1; i < x2; i++) {
      for (int j = y1 + 1; j < y2; j++) {
        map[i][j] = 2;
      }
    }
  }

  public int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[102][102];

    queue.offer(new int[]{characterX, characterY, 0});
    visited[characterX][characterY] = true;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];
      int dist = cur[2];

      if (x == itemX && y == itemY) {
        return dist;
      }

      // 상하 좌우
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102
            && map[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.offer(new int[]{nx, ny, dist + 1});
        }
      }
    }
    return -1;
  }
}
