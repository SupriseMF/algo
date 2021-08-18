package pac1;

public class getIntersectionNode {

    /**
     * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     *
     * 图示两个链表在节点 c1 开始相交：
     *
     *
     *
     * 题目数据 保证 整个链式结构中不存在环。
     *
     * 注意，函数返回结果后，链表必须 保持其原始结构
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * @param headA
     * @param headB
     * @return
     */

    /**
     * 空间复杂度 O(1)O(1) 时间复杂度为 O(n)O(n)
     *
     * 这里使用图解的方式，解释比较巧妙的一种实现。
     *
     * 根据题目意思
     * 如果两个链表相交，那么相交点之后的长度是相同的
     *
     * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
     * 为此，我们必须消除两个链表的长度差
     *
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        // 两个指针都跑 列表A和列表B的总长度， 后必定相遇（有相交）或都为null（不相交）
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        // 此时pA = pB
        return pA;
    }
}
