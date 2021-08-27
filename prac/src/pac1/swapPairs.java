package pac1;

public class swapPairs {


    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        // 终止条件
        if (head == null ||head.next == null) {
            return head;
        }
        // 递归内逻辑
        ListNode next = head.next;
        // 交换
        head.next = swapPairs(next.next);
        next.next = head;
        // 返回交换结果 next 即是交换后的位置
        return next;
    }
}
