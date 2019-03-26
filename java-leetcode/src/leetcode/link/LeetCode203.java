package leetcode.link;

/**
 * <p>
 *     删除链表中等于给定值 val 的所有节点。
     示例:
     输入: 1->2->6->3->4->5->6, val = 6
     输出: 1->2->3->4->5
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/26 18:16
 */
public class LeetCode203 {

    public static void main(String[] args) {
        int[] datas = {1,2,2,1};
        ListNode listNode = null;
        for(int data:datas){
            ListNode thisNode = new ListNode(data);
            if (listNode == null){
                listNode = thisNode;
            }else {
                ListNode tempNode = listNode;
                while (tempNode.next != null){
                    tempNode = tempNode.next;
                }
                tempNode.next = thisNode;
            }
        }
        LeetCode203 leetCode203 = new LeetCode203();
        leetCode203.display(leetCode203.removeElements(listNode,2));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode currNode = head;
        ListNode preNode = head;
        while (currNode != null){
            if (currNode.val == val){
                if (currNode == head){
                    // 删除头结点
                    head = head.next;
                }else {
                    preNode.next = currNode.next;
                    currNode = head;
                    continue;
                }
            }
            preNode = currNode;
            currNode = currNode.next;
        }

        return head;
    }


    public ListNode removeElements1(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
    }

    public void display(ListNode listNode){
        while (listNode != null){
            System.err.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
}
