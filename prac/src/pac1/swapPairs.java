package pac1;

public class swapPairs {

    public ListNode swapPairs(ListNode head) {

        // 终止条件
        if (head.next == null || head == null) {
            return head;
        }
        // 递归内逻辑
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        // 返回交换结果
        return next;
    }
}
