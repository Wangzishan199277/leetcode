package leetcode;

import utils.ListNode;
//https://leetcode.com/problems/add-two-numbers/description/
//I forget to move l1 and l2 to the next in the while loop and cause "Time Limit Exceeded" error at the first time.
public class AddTwoNumbers {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            carry = 0;
            int temp = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            temp = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            end.next = new ListNode(temp);
            end = end.next;
        }
        if (carry == 1) {
            end.next = new ListNode(1);
        }
        return dummy.next;
    }
}
