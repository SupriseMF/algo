package pac1;

public class addTwoNumbers {


    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 时间复杂度O(N)
         * 空间复杂度O(1) 返回值不计入空间复杂度
         */

        // result的头尾节点
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 从头到尾，若遇null，则取值0
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            // 拼接链表
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            // 判断l1、l2是否到头
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(9, a);
        ListNode c = new ListNode(9, b);

        ListNode d = new ListNode(9, null);
        ListNode e = new ListNode(9, d);
        ListNode f = new ListNode(9, e);

        ListNode res = addTwoNumbers(c, f);
        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
        System.out.print("null");
        System.out.println();

    }
}
