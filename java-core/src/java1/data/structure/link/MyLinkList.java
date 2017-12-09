package java1.data.structure.link;


/**
 * 链表，相当于火车
 * @author Administrator
 *
 */
public class MyLinkList {

	/**
	 * 头结点
	 */
	private MyNode first;
	
	/**
	 * 构造方法
	 */
	public MyLinkList(){
		first=null;
	}
	
	/**
	 * 在头结点后插入节点
	 * @param value
	 */
	public void insetFirst(long value){
		MyNode node=new MyNode(value);
		if (first==null) {
			first=node;
		}else {
			node.next=first;
			first=node;
		}	
	}
	/**
	 * 在尾结点后追加结点
	 * @param value
	 */
	public void insertEnd(long value){
		MyNode node=new MyNode(value);
		if (first==null) {
			first=node;  //链表为null时，即新增节点就是头结点
		}else {
			MyNode ntemp=first;
			while(ntemp.next!=null){//循环找到尾结点，等于null时跳出循环，即为尾结点
				ntemp=ntemp.next;
			}
			ntemp.next=node;
		}
	}
	
	/**
	 * 删除头结点后的节点
	 * @return
	 */
	public MyNode deleteFirst(){
		MyNode temp=first;//头结点
		first=temp.next;
		return temp;
	}
	
	/**
	 * 显示结点
	 */
	public void display(){
		MyNode currNode=first;
		while(currNode!=null){
			currNode.display();
			currNode=currNode.next;
		}
	}
	
	/**
	 * 查找方法
	 * @param value
	 * @return
	 */
	public MyNode find(long value){
		MyNode currNode=first;
		while(currNode!=null){
			if (currNode.data==value) {
				return currNode;
			}
			currNode=currNode.next;
		}
		return null;
	}
	/**
	 * 根据关键字key，在其中间插入一个结点value
	 * @param value
	 * @param key
	 */
	public void insertFindByKey(long value,long key){
		MyNode node=new MyNode(value);
		MyNode keyNode=find(key);
		if (keyNode==null) {
			System.out.println("未找到正确的插入位置！");
		}else {
			node.next=keyNode.next;
			keyNode.next=node;
		}
	}
	
	/**
	 * 删除
	 * @param value
	 * @return
	 */
	public MyNode delete(long value){
		MyNode currNode=first;
		MyNode previous=first;
		while(currNode.data!=value){
			if (currNode.next==null) {
				return null;
			}
			previous=currNode;
			currNode=currNode.next;
		}
 		if (currNode==first) {
			first=first.next;
		}else {
			previous.next=currNode.next;
		}
		return currNode;
	}
	/**
	 * 计算链表长度，即结点个数
	 * @return
	 */
	public int getLinkLength(){
		int length=0;
		MyNode currNode=first;
		while(currNode!=null){
			length++;
			currNode=currNode.next;
		}
		return length;
	}
}
