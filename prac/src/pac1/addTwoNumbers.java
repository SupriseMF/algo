package pac1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class addTwoNumbers {

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
