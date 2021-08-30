package pac1;

import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
     * 输出：[7,8,0,7]
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

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        /**
         * 由于是链表节点，且逆序进行相加
         * 故使用栈，分别存储两个链表
         */
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = null;
        // 进位符号
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            // 计算值
            int num = val1 + val2 + carry;
            // 进位
            carry = num / 10;
            // 真实的加值
            num = num % 10;
            // 头插法
            ListNode newNode = new ListNode(num);
            newNode.next = dummy;
            dummy = newNode;
        }
        return dummy;
    }
}
