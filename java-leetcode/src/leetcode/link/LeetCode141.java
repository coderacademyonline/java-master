package leetcode.link;

/**
 * <p>
 *     给定一个链表，判断链表中是否有环。

    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     输入：head = [1,2], pos = 0
     输出：true
     解释：链表中有一个环，其尾部连接到第一个节点。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/25 18:37
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow !=null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow!=null && fast!=null && slow == fast){
                return true;
            }
        }

        return false;
    }
}
