package pac1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        // 默认增序
        // 最小堆实现
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            // 优先级队列中取出 当前list.size中最小的
            ListNode nextNode = pq.poll();
            // 拼接上
            // cur后移
            curr.next = nextNode;
            curr = curr.next;
            // 如果链表未到头，继续存放
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
//        int[] n = {88, 58, 70, 20, 55, 49, 52, 17, 19, 7};
        for (int i = 0; i < 10; i++) {
            int j = (int) (Math.random() * 100);
            pq.add(j);
//            pq.add(n[i]);
        }
        if (pq.size() > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println(pq.poll());
            }
        }



    }
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
