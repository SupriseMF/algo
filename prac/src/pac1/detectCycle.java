package pac1;

public class detectCycle {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     *
     * 说明：不允许修改给定的链表。
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        /**
         * O(1)空间
         * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。
         * 随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。如果链表中存在环，
         * 则 fast 指针最终将再次与 slow 指针在环中相遇。
         *
         * a = (n-1)b+c
         * a：head到入环点
         * b：入环点到slow与fast相遇点
         * c = 环长度 - b
         *
         * 当发现 slow 与 fast 相遇时，我们再额外使用一个指针ptr。
         * 起始，它指向头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。
         *
         */
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // 为null时说明无环
                return null;
            }

            // fast与slow相遇
            if (fast == slow) {
                // pre从head出发
                ListNode ptr = head;
                // slow与ptr一同运动，直至相遇
                while (ptr != slow) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                // 相遇点即为入环点
                return ptr;
            }

        }
        return null;
    }
}
