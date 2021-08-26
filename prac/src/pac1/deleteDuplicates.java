package pac1;

public class deleteDuplicates {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                ListNode headRight = head.next;
                head.next = headRight.next;
                headRight.next = null;
            } else {
                head = head.next;
            }

        }
        return first;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicatesRecursive(head.next);
        if(head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3, null);
        ListNode b = new ListNode(3, a);
        ListNode c = new ListNode(2, b);
        ListNode d = new ListNode(1, c);
        ListNode e = new ListNode(1, d);
        ListNode res = deleteDuplicatesRecursive(e);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
