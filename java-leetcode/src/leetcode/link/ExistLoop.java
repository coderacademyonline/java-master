package leetcode.link;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/14 15:44
 */
public class ExistLoop {

    private ListNode listNode;

    public ExistLoop(int size){
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

    /**
     * 双指针法判断链表是否有环
     * @param listNode
     * @return
     */
    public boolean isExistLoop(ListNode listNode){
        if (listNode == null){
            return false;
        }
        ListNode head1 = listNode;
        ListNode head2 = listNode;

        // 指针1每次走两步，指针2每次走一步
        while (head1.next != null & head2 != null){
            head1 = head1.next.next;
            head2 = head2.next;
            if (head1 == head2){
                return true;
            }
        }
        return false;
    }
}
