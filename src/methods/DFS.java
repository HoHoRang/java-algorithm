package methods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
  // 인접 노드를 저장하기 위한 리스트
  private static List<List<Integer>> adj;
  // DFS에서 사용하기 위한 방문여부
  private static boolean[] visited;
  // BFS에서 사용하기 위한 방문여부 + 거리
  private static int[] visited2;

  // DFS(재귀)
  private static void DFS(int here) {
    // 먼저 해당 노드 방문 처리
    visited[here] = true;
    System.out.println(here + " ");
    // 인접한 노드 중 방문하지 않은 노드에 대해 DFS 처리
    for (int v: adj.get(here)) {
      if (!visited[v]) {
        DFS(v);
      }
    }
  }

  // BFS(큐)
  private static void BFS(int here) {
    // 너비 우선 탐색을 위한 큐 선언
    Queue<Integer> queue = new LinkedList<>();
    // 먼저 첫번째 노드 방문 처리 및 거리 1로 설정
    visited2[here] = 1;
    // 첫번째 노드 큐에 추가
    queue.add(here);
    while (!queue.isEmpty()) {
      here = queue.poll();
      System.out.println(here + " ");
      // 인접한 노드 중 방문하지 않은 노드에 대해 방문 및 거리를 1 늘려서 설정하고 큐에 추가
      for (int v: adj.get(here)) {
        if (visited2[v] == 0) {
          visited2[v] = visited2[here] + 1;
          queue.add(v);
        }
      }
    }
  }

  public static void main(String[] args) {
    int num = 5;
    adj = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(0);
    adj.get(1).add(3);
    adj.get(1).add(4);
    visited = new boolean[num];
    DFS(0);
    System.out.print("\n");
    visited2 = new int[num];
    BFS(0);
  }
}
