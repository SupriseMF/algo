package pac1;

import java.time.temporal.Temporal;

public class OddEvenList {


    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 空间复杂度应为 O(1)
     * 时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，oddTail 为奇链表尾节点
        ListNode oddTail = head;

        // evenHead 为偶链表头结点
        ListNode evenHead = head.next;
        // evenTail 为偶链表尾节点
        ListNode evenTail = evenHead;


        while (oddTail.next != null && evenTail.next != null) {
            // 奇数tail指向偶数tail的下一个
            oddTail.next = evenTail.next;
            // 更新奇数tail
            oddTail = oddTail.next;

            // 偶数tail指向奇数tail的下一个
            evenTail.next = oddTail.next;
            // 更新偶数tail
            evenTail = evenTail.next;
        }
        // 最终要将奇数tail指向偶数head
        oddTail.next = evenHead;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;

    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 方法1：递归  时间复杂度O(M+N) 空间复杂度O(1)  ✔️
         * 方法2：小堆  时间复杂度O(M) 空间复杂度O(M)
         */
        // 递归边界
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res;
        ListNode next;
        if (l1.val < l2.val) {
            res = l1;
            next = l2;
        } else {
            res = l2;
            next = l1;
        }

        // 将较小的节点将入res，递归计算next
        res.next = mergeTwoLists(res.next, next);
        // 返回
        return res;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
