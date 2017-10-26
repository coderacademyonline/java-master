package java.data.structure.link;

import com.view02.Link.MyNode;

/**
 * 双端链表，始终保持着对尾结点的引用
 * @author Administrator
 *
 */
public class MyFirstLastLink {

	/**
	 * 头结点
	 */
	private MyNode first;
	
	private MyNode last;
	
	/**
	 * 构造方法
	 */
	public MyFirstLastLink(){
		first=null;
		last=null;
	}
	
	/**
	 * 在头结点后插入节点,如果链表为空，则设置尾结点为新增节点
	 * @param value
	 */
	public void insetFirst(long value){
		MyNode node=new MyNode(value);
		if (isEmpty()) {
			last=node;
		}
		node.next=first;
		first=node;
	}
	
	/**
	 * 插入结点，从尾结点插入
	 * @param value
	 */
	public void insertLast(long value){
		MyNode node=new MyNode(value);
		if (isEmpty()) {
			first=node;//若链表为空，则设置头结点为新增节点
		}else {
			last.next=node;//若链表不为空，则设置尾结点的下一个节点为新增结点
		}
		last=node;
	}
	
	/**
	 * 删除头结点后的节点,从头部开始删除
	 * 判断头结点是否有下一个结点，如果没有则设置为节点为null
	 * @return
	 */
	public MyNode deleteFirst(){
		MyNode temp=first;//头结点
		if (first.next==null) {
			last=null;
		}
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
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return first==null;
	}
}
