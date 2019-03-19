package leetcode.link;

import java.util.Random;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/14 14:28
 */
public class FindKthTail {

    private ListNode listNode;

    public FindKthTail(int size){
        for(int i=1; i<= size;i++){
            ListNode node = new ListNode(i);
            if (listNode == null){
                listNode = node;
            }else{
                ListNode tempNode = listNode;
                while (tempNode.next != null){
                    tempNode = tempNode.next;
                }
                tempNode.next = node;
            }
        }
    }


    private int num;

    public  ListNode findKthTail1(ListNode listNode,int k){
        num = k;

        if (listNode == null){
            return null;
        }

        ListNode preNode = findKthTail1(listNode.next,k);

        if (preNode != null){
            return preNode;
        }else {
            num--;
            if (num == 0){
                return listNode;
            }
            return null;
        }

    }

    /**
     * 双指针法
     * @param head 头指针
     * @param k
     * @return
     */
    public  ListNode findKthTail2(ListNode head,int k){
        if (head == null || k == 0){
            return null;
        }

        ListNode head1 = head;
        ListNode head2 = head;
        // 将指针1 移动k个位置
        for (int i=0;i<k;i++){
            if (head1 != null){
                head1 = head1.next;
            }else{
                return null;
            }
        }
        // 同时移动head1，head2  1个位置
        while (head1 != null){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head2;
    }

    public static void main(String[] args) {
        FindKthTail main = new FindKthTail(10);
        // ListNode kNode = main.findKthTail1(main.listNode,5);
        ListNode kNode = main.findKthTail2(main.listNode,5);
        System.out.println(kNode.val);
    }
}
