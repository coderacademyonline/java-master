package java.data.structure.link;


/**
 * 双向链表，每个节点除了保存了对下一个节点的引用，同时还保存这对前一个节点的引用
 * @author Administrator
 *
 */
public class MyDoubleLink {

	/**
	 * 头结点
	 */
	private MyNode first;
	
	private MyNode last;
	
	/**
	 * 构造方法
	 */
	public MyDoubleLink(){
		first=null;
		last=null;
	}
	
	/**
	 * 在头结点后插入节点，如果为空，则设置新增节点为尾结点，如果不为空，还需要设置头结点的前一个节点为新增结点
	 * @param value
	 */
	public void insetFirst(long value){
		MyNode node=new MyNode(value);
		if (isEmpty()) {
			last=node;
		}else{
			first.previous=node;
		}
		node.next=first;
		first=node;
	}
	
	/**
	 * 插入结点，从尾结点插入,
	 * @param value
	 */
	public void insertLast(long value){
		MyNode node=new MyNode(value);
		if (isEmpty()) {
			first=node;//若链表为空，则设置头结点为新增节点
		}else {
			last.next=node;//若链表不为空，则设置尾结点的下一个节点为新增结点,同时设置新增加的节点的前指针指向为尾结点
			node.previous=last;
		}
		last=node;
	}
	/**
	 * 在关键字之后插入结点
	 * @param value
	 * @param key
	 */
	public void insertFindByKey(long value,long key){
		MyNode curNode=find(key);
		if (curNode==null) {
			System.out.println("未找到插入结点的位置");
		}else {
			MyNode node=new MyNode(value);//要插入的结点
			node.previous=curNode;
			node.next=curNode.next;
			node.previous.next=node;
			node.next.previous=node;
		}
	}
	
	/**
	 * 删除头结点后的节点,从头部开始删除
	 * @return
	 */
	public MyNode deleteFirst(){
		MyNode temp=first;//头结点
		if (first.next==null) {
			last=null;
		}else {
			first.next.previous=null;
		}
		first=temp.next;
		return temp;
	}
	
	/**
	 * 删除结点，从尾结点删除
	 * 如果头结点后没有其他结点，则设置头结点为null。
	 * 否则设置尾结点的前一个结点的next为null。
	 * 设置尾结点为其前一个结点。
	 * @return
	 */
	public MyNode deleteLast(){
		MyNode temp=last;
		if (first.next==null) {
			first=null;
		}else {
			last.previous.next=null;
		}
		last=last.previous;//将last的前一个节点设置为尾结点。
		return temp;
	}
	/**
	 * 根据关键字删除结点
	 * @param key
	 */
	public void deleteByKey(long key){
		MyNode node=find(key);
		if (node==null) {
			System.out.println("未找到要删除的结点");
		}else {
			node.previous.next=node.next;
			node.next.previous=node.previous;
		}
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
		while(currNode.data!=value){
			if (currNode.next==null) {
				return null;
			}
			currNode=currNode.next;
		}
 		if (currNode==first) {
			first=first.next;
		}else {
			currNode.previous.next=currNode.next;
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
