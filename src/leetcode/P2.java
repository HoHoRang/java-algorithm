package leetcode;

public class P2 {

  public static void main(String[] args) {
    P2 instance = new P2();

    ListNode l1 = new ListNode();
    ListNode l2 = new ListNode();

    System.out.println(instance.addTwoNumbers(l1, l2));
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curNode = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      carry = sum / 10;
      curNode.next = new ListNode(sum % 10);
      curNode = curNode.next;
    }

    return dummy.next;

//    long num1 = 0;
//    long num2 = 0;
//    long sum = 0;
//    ListNode result;
//    int multiply = 1;
//
//    do {
//      num1 = num1 + l1.val * multiply;
//      multiply *= 10;
//      l1 = l1.next;
//    }
//    while (l1 != null);
//
//    multiply = 1;
//
//    System.out.println(num1);
//
//    do {
//      num2 = num2 + l2.val * multiply;
//      multiply *= 10;
//      l2 = l2.next;
//    }
//    while (l2 != null);
//
//    System.out.println(num2);
//
//    sum = num1 + num2;
//
//    System.out.println(sum);
//
//    if (sum == 0) return new ListNode(0);
//
//    long rest = sum;
//    ListNode startNode = new ListNode(0);
//    ListNode curNode = startNode;
//
//    do {
//      ListNode nextNode = new ListNode();
//      nextNode.val = Math.toIntExact(rest % 10);
//      rest = rest / 10;
//      curNode.next = nextNode;
//      curNode = nextNode;
//    }
//    while (rest > 0);
//
//    return startNode.next;
  }
}
