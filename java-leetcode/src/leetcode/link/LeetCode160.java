package leetcode.link;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *     编写一个程序，找到两个单链表相交的起始节点。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/26 09:51
 */
public class LeetCode160 {

    /**
     * 思路：将环首尾相连，如果是相交，则他是一个环形链表，则找到环形链表的入口即可
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode nodeA = headA;
        while (nodeA.next != null){
            nodeA=nodeA.next;
        }
        nodeA.next = headB;
        // 接下来要找出环形的入口
        ListNode fast = headA;
        ListNode slow = headA;
        while (slow != null && fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                if (slow == null){
                    nodeA.next = null;
                    return null;
                }
                // 此时说明现在首尾相连后是一个环形链表，也可以判断出来是一个相交链表
                ListNode meetNode = slow;
                ListNode node = headA;
                while (meetNode != node){
                    meetNode = meetNode.next;
                    node = node.next;
                }
                nodeA.next = null;
                return meetNode;
            }
        }
        nodeA.next = null;
        return null;
    }

    /**
     * 思路：去掉两个链表的长度差值之后，循环两个指针，直到相等
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lengthA = 0;
        ListNode nodeA = headA;
        while (nodeA!=null){
            nodeA = nodeA.next;
            lengthA++;
        }

        int lengthB = 0;
        ListNode nodeB = headB;
        while (nodeB != null){
            nodeB = nodeB.next;
            lengthB++;
        }
        // 去掉链表的差长度，找到相同的起点
        ListNode pA = headA;
        ListNode pB = headB;
        if (lengthA>lengthB){
            int length = lengthA-lengthB;
            while (length >0){
                pA = pA.next;
                length--;
            }
        }else {
            int length = lengthB-lengthA;
            while (length>0){
                pB = pB.next;
                length--;
            }
        }
        while (pA!=null && pB!=null){
            if (pA == pB){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }
}
