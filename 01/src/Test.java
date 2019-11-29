import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) l1 = new ListNode(0);
        l1.val += l2 == null ? 0 : l2.val;
        if (l1.val > 9) {
            l1.val = l1.val % 10;
            if (l1.next == null)
                l1.next = new ListNode(1);
            else
                l1.next.val += 1;
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        } else {
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        }
        return l1;
    }
}

//public class Test {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int y = in.nextInt();
//        Solution solution = new Solution();
//        ListNode l1 = new ListNode(x);
//        ListNode l2 = new ListNode(y);
//        System.out.println(solution.addTwoNumbers(l1, l2));
//    }
//
//}

//public class Test {
//    public static void main(String[] args) {
//        // 创建测试案例
//        ListNode listNode1 = new ListNode(5);
//        ListNode listNode2 = new ListNode(6);
//        ListNode listNode3 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//        ListNode listNode21 = new ListNode(2);
//        ListNode listNode22 = new ListNode(4);
//        ListNode listNode23 = new ListNode(3);
//        listNode21.next = listNode22;
//        listNode22.next = listNode23;
//
//        ListNode listNode31 = new ListNode(1);
//        ListNode listNode32 = new ListNode(1);
//
//        // 测试案例期望值
//        Integer[] expResult1 = new Integer[]{7, 0, 8};
//        Integer[] expResult3 = new Integer[]{2};
//
//
//        // 执行方法
//        Solution solution2 = new Solution();
//        ListNode result1 = solution2.addTwoNumbers(listNode1, listNode21);
//        ListNode result3 = solution2.addTwoNumbers(listNode31, listNode32);
//        System.out.println(result1);
//        // 判断期望值与实际值
////        Assert.assertArrayEquals(expResult1,result1.toArray().toArray());
////        Assert.assertArrayEquals(expResult3,result3.toArray().toArray());
//    }
//
//
//}
public class Test {
    public static void main(String[] args) {
        // 创建两个链表
        // 第一个链表: 1-> 8 -> 7 -> 6 (在做加法运算代表的是6781)
        ListNode l1 = new ListNode(6); // 这是第一个链表的第一个节点(不能用这个节点去往下加数据) // 必须有一个指针去往第一个节点上去加数据
        ListNode p = l1; // 这个指针节点会从链表的第一个节点一直往下走(直至最后一个节点)
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(8);
        p = p.next;
        p.next = new ListNode(1);
        // 第二个链表
        ListNode l2 = new ListNode(9);
        ListNode q = l2;
        q.next = new ListNode(9);
        q = q.next;
        q.next = new ListNode(9);
        q = q.next;
        q.next = new ListNode(9);
        Solution solution = new Solution();
        ListNode re = solution.addTwoNumbers(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }
}