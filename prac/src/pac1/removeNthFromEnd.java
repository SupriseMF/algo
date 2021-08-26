package pac1;

public class removeNthFromEnd {


    /**
     * 删除链表倒数第N个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 新建一个 虚拟节点,dummy.next = head
        ListNode dummy = new ListNode(0, head);
        // 快慢指针，均从head开始，其中快指针比慢指针多走N步
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除倒数第N个
        second.next = second.next.next;
        // 返回head
        return dummy.next;
    }
}
