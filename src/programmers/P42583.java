package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class P42583 {

  public static void main(String[] args) {
    P42583 solution = new P42583();

    System.out.println("solution= " + solution.solution(2, 10,
        new int[]{7, 4, 5, 6}));
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int time = 0;

    Queue<Integer> trucks = new LinkedList<>(); // 현재 다리 위 트럭들
    int trucksWeightOnBridge = 0; // 다리 위 트럭 무게
    int truckIndex = 0; // 올라가야 할 트럭 인덱스
    int endTruckIndex = 0; // 곧 통과할 트럭 인덱스
    int[] truckEndTimes = new int[truck_weights.length]; // 각 트럭이 다리를 통과하는 시간

    // 반복문
    while (true) {
      // 모든 트럭이 건넜으면 종료
      if (truckIndex >= truck_weights.length && trucks.size() == 0) {
        System.out.println("all trucks passed");
        break;
      }

      // 시간 증가
      time++;

      // 빠져나간 트럭이 있으면 큐에서 제거하고, 다리 위 트럭 무게 업데이트
      if (endTruckIndex < truck_weights.length && truckEndTimes[endTruckIndex] != 0 && time >= truckEndTimes[endTruckIndex]) {
        trucks.poll();
        trucksWeightOnBridge -= truck_weights[endTruckIndex];

        endTruckIndex++;
      }

      // 순서대로 트럭을 꺼내서 다리에 올리는데, 버틸 수 있는 무게일 때만
      int availableWeight = weight - trucksWeightOnBridge;

      // 트럭이 올라갈 수 없으면 다음 시간으로 이동
      if (availableWeight < 0) {
        continue;
      }

      // 모든 트럭이 올라가 있으면 다음 시간으로
      if (truckIndex >= truck_weights.length) {
        continue;
      }

      int nextTruck = truck_weights[truckIndex];

      // 다음 트럭이 올라갈 수 있는 무게인지
      if (availableWeight >= nextTruck) {
        // 다리 위로 트럭 이동
        trucks.offer(nextTruck);
        trucksWeightOnBridge += nextTruck;
        truckEndTimes[truckIndex] = time + bridge_length; // 해당 트럭이 다리를 통과하는 시간 ex. [3, 5, 6, 8]
        truckIndex++;
      }
    }

    return time;
  }
}
