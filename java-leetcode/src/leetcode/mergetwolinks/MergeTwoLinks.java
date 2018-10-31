package leetcode.mergetwolinks;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/30 18:05
 */
public class MergeTwoLinks {

    public static void main(String[] args){
        MergeTwoLinks mergeTwoLinks = new MergeTwoLinks();
        Integer[] strs1 = {0,2,3};
        Integer[] strs2 = {1,3,4,6};
        ListNode l1 = mergeTwoLinks.createLink(strs1);
        System.out.println("构建第一个有序链表是：");
        mergeTwoLinks.display(l1);
        System.out.println();
        ListNode l2 = mergeTwoLinks.createLink(strs2);
        System.out.println("构建第二个有序链表是：");
        mergeTwoLinks.display(l2);
        System.out.println();
        System.out.println("合并之后的链表是：");
        System.out.println();
        ListNode listNode = mergeTwoLinks.mergeTwoLists(l1,l2);
        mergeTwoLinks.display(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int length1 = this.getLength(l1);
        int length2 = this.getLength(l2);
        ListNode currentNode = null;
        ListNode resultNode = null;
        if (length1 >= length2){
            currentNode = l2;
            resultNode = l1;
        }else{
            currentNode = l1;
            resultNode = l2;
        }

        while (currentNode != null){
            int val = currentNode.val;
            resultNode = this.insertNode(resultNode,val);
            currentNode = currentNode.next;
        }
        return resultNode;
    }

    private ListNode insertNode(ListNode l1,int val){
        ListNode currentNode = l1;
        if (currentNode == null){
            return null;
        }
        int headVal = currentNode.val;
        if (headVal > val){
            // 插入头结点
            ListNode newHead = new ListNode(val);
            newHead.next = currentNode;
            currentNode = newHead;
            l1 = currentNode;
            return l1;
        }
        while (currentNode != null){
             int currentVal = currentNode.val;
            if (currentNode.next == null){
                // 插入尾节点
                ListNode newNode = new ListNode(val);
                currentNode.next = newNode;
                return l1;
            }
             int nextVal = currentNode.next.val;
             if (currentVal <= val && val <= nextVal){
                 ListNode newNode = new ListNode(val);
                 newNode.next = currentNode.next;
                 currentNode.next = newNode;

                 return l1;
             }else{

                 currentNode = currentNode.next;
             }
        }
        return l1;
    }

    private int getLength(ListNode listNode){
        int length = 0;
        if (listNode == null){
            return length;
        }

        while (listNode != null){
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    public void display(ListNode headNode){
        ListNode currentNode = headNode;
        while (currentNode != null){
            System.out.print(currentNode.val);
            if(currentNode.next != null){
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
    }

    public ListNode createLink(Integer[] strs){
        ListNode listNode = null;
        for(Integer str : strs){
            ListNode tempNode = new ListNode(str);
            if (listNode == null){
                listNode = tempNode;
            }else{
                ListNode nextNode = listNode;
                while (nextNode.next != null){
                    nextNode = nextNode.next;
                }
                nextNode.next = tempNode;
            }
        }
        return listNode;
    }
}
