package leetcode.link;

/**
 * <p>
 *     给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *     例：
 *     输入: 1->1->1->2->3->3->3->3
        输出: 1->2->3
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/25 16:46
 */
public class LeetCode83 {

    public static void main(String[] args) {
        int[] datas = {1,1,1,2,3,3};
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
        LeetCode83 leetCode83 = new LeetCode83();
        leetCode83.display(leetCode83.deleteDuplicates(listNode));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1!=null && p1.next != null && p2 != null){
            if (p1.val == p2.val){
              // 删除p2
              p1.next = p1.next.next;
            }else{
                p1 = p1.next;
            }
            p2 = p2.next;

        }

        return head;
    }

    public void display(ListNode listNode){
        while (listNode != null){
            System.err.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
}
