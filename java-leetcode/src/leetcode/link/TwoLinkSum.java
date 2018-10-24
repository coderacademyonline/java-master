package leetcode.link;

import java.math.BigDecimal;
import java.util.Random;

/**
 * <p>
 *     leetcode 第二题
 *      给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *      你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *      示例：
 *          输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *          输出：7 -> 0 -> 8
 *          原因：342 + 465 = 807
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/19 16:36
 */
public class TwoLinkSum {

    public static void  main(String[] args){
        ListNode headNode1 = null;
        ListNode headNode2 = null;
        for(int i=0; i<200;i++){
            int nodeNum =new Random().nextInt(9);
            int nodeNum2 = new Random().nextInt(9);
            ListNode node = new ListNode(nodeNum);
            ListNode node2 = new ListNode(nodeNum2);
            if (headNode1 == null){
                headNode1 = node;
                headNode2 = node2;
            }else{
                ListNode tempNode = headNode1;
                while (tempNode.next != null){
                    tempNode = tempNode.next;
                }
                tempNode.next = node;

                ListNode tempNode2 = headNode2;
                while (tempNode2.next != null){
                    tempNode2 = tempNode2.next;
                }
                tempNode2.next = node2;
            }
        }
        System.out.println("第一个链表：");
        TwoLinkSum.display(headNode1);
        System.out.println();
        System.out.println("第二个链表：");
        TwoLinkSum.display(headNode2);
        System.out.println();


        ListNode node=TwoLinkSum.addTwoNumbers(headNode1,headNode2);
        System.out.println();
        System.out.println("结果链表：");
        TwoLinkSum.display(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  reverseNode1 = TwoLinkSum.reverse(l1);
        ListNode  reverseNode2 = TwoLinkSum.reverse(l2);
        BigDecimal nodeNum1 = TwoLinkSum.reverseString(reverseNode1);
        BigDecimal nodeNum2 = TwoLinkSum.reverseString(reverseNode2);
        System.err.println("转换为long类型的值为："+nodeNum1);
        System.err.println("转换为long类型的值为："+nodeNum2);
        BigDecimal nodeNum = nodeNum1.add(nodeNum2);
        char[] nodes = String.valueOf(nodeNum).toCharArray();
        ListNode resultNode = null;
        for(char node:nodes){
            ListNode listNode = new ListNode(Integer.valueOf(String.valueOf(node)));
            if (resultNode == null){
                resultNode = listNode;
            }else{
                ListNode tempNode = resultNode;
                while (tempNode.next != null){
                    tempNode = tempNode.next;
                }
                tempNode.next = listNode;
            }
        }
        TwoLinkSum.display(resultNode);
        return TwoLinkSum.reverse(resultNode);
    }

    public static BigDecimal reverseString(ListNode node){
        ListNode currentNode = node;
        StringBuffer nodeStr = new StringBuffer();
        while (currentNode != null){
            nodeStr.append(currentNode.val);
            currentNode = currentNode.next;
        }

        return new BigDecimal(nodeStr.toString());
    }

    public static void display(ListNode headNode){
        ListNode currentNode = headNode;
        while (currentNode != null){
            System.out.print(currentNode.val);
            if(currentNode.next != null){
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pNode = head;
        ListNode qNode = head.next;
        ListNode rNode = null;
        ListNode tNode = head.next;
        while (qNode != null){
            rNode = qNode;
            qNode = qNode.next;
            rNode.next = pNode.next;
            pNode.next = rNode;
        }
        // 最后q必然指向NULL，所以返回了p作为新的头指针
        head = pNode.next;
        tNode.next = pNode;
        pNode.next = null;
        tNode = pNode;
        return head;
    }

    public static ListNode reverse1(ListNode node){
        ListNode previousNode = null;
        ListNode currentNode = node;
        ListNode headNode = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }
}
