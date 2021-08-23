package pac1;

import java.util.ArrayList;
import java.util.List;

public class reverseKGroup {

    /**
     * K个一组，翻转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 把链表节点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头节点。这个指针每次向前移动 k 步，直至链表结尾。
         * 对于每个分组，我们先判断它的长度是否大于等于 k。若是，我们就翻转这部分链表，否则不需要翻转。
         *
         *
         */
        // 记录初始head
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (head != null) {
            ListNode tail = prev;
            // 结束条件
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            ListNode next = tail.next;
            List<ListNode> reverse = reverse(head, tail);
            head = reverse.get(0);
            tail = reverse.get(1);
            // 子链表接回原链表
            prev.next = head;
            tail.next = next;

            // 后移
            prev = tail;
            head = tail.next;
        }

        return dummyHead.next;

    }

    /**
     * 翻转列表
     * @param head
     * @param tail
     * @return
     */
    private static List<ListNode> reverse(ListNode head, ListNode tail) {
        // 列表翻转后，prev位置 tail.next
        ListNode prev = tail.next;
        ListNode cur = head;
        // 只要prev还未指向tail，就继续交换
        while (prev != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        List<ListNode> res = new ArrayList<>();
        // 内部交换完成，拼接时：以头做尾，以尾做头
        res.add(tail);
        res.add(head);
        return res;

    }


    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 列表翻转后，prev位置 null
        ListNode prev = null;
        ListNode cur = head;
        // 只要prev还未指向tail（null），就继续交换
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            // prev指向当前位置
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(4, c);
        ListNode e = new ListNode(5, d);
        ListNode f = new ListNode(6, e);
//        ListNode res = reverseList(f);
        List<ListNode> list = reverse(f, d);
        ListNode res = list.get(0);
        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
