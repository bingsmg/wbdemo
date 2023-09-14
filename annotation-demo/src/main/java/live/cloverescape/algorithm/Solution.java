package live.cloverescape.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author weibb
 * @date 2023-08-17
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(3))));
        solution.traverse(solution.sortList(head));
    }

    public ListNode sortList(ListNode head) {
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return msort(head, tail);
    }

    private ListNode msort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return head;
        }
        ListNode mid = findM(head);
        ListNode secHead = mid.next;
        mid.next = null;
        ListNode res = merge(msort(head, mid), msort(secHead, tail));
        return res;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        dummy.next = head1;
        ListNode p1 = head1, p2 = head2, cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummy.next;
    }

    private ListNode findM(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        return null;
    }

    private void backtrack(char[] arr) {

    }

    private boolean isValid(String s) {
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}