package java.data.structure.tree;


/**
 * 二叉树
 * @author Administrator
 *
 */
public class MyTree {

	/**
	 * 根节点
	 */
	private MyTreeNode root;
	
	/**
	 * 插入节点
	 * 从根节点开始查找一个相应的节点，这个节点将成为新插入节点的父节点，
	 * 当父节点找到后，通过判断新节点的值比父节点的值的大小来决定是连接到左子节点还是右子节点
	 * @param value
	 */
	public void insertNode(long value){
		
		MyTreeNode node=new MyTreeNode(value);//封装节点
		MyTreeNode currentNode=root;//引用当前节点
		MyTreeNode parent;//父节点引用
		if (root==null) {
			root=node;
			return ;
		}else{
			while(true){
				//父节点引用当前节点
				parent=currentNode;
				//当前节点的值大于要插入的值，则将节点插入到当前节点的左节点
				if(currentNode.data>value){
					currentNode=currentNode.leftChild;
					if (currentNode==null) {
						parent.leftChild=node;
						return;
					}
				}else {
					currentNode=currentNode.rightChild;
					if (currentNode==null) {
						parent.rightChild=node;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 查找节点
	 * 从根节点开始查找，如果当前节点值比当前节点的值小，则继续查找其左子节点，否则查找其右子树。
	 * @param vlaue
	 */
	public MyTreeNode findNode(long value){
		MyTreeNode currNode=root;//引用当前节点从根节点开始
		
		//循环，只要查找的值不等于当前节点的数据项
		while(currNode.data != value){
		   //进行比较，比较当前查找值和当前节点的大小
             if(currNode.data>value){ //当前查找值比当前节点的数据值要小，那么应该向当前节点的左子节点查找
            	 currNode=currNode.leftChild;
             }else {      //当前查找值比当前节点的数据值要大，那么应该向当前节点的右子节点查找
				currNode=currNode.rightChild;
			}			
             if (currNode==null) {  //若查找不到，则返回null值
				return null;
			}
		}
		return currNode;
	}
	
	/**
	 * 删除节点
	 * @param value
	 */
	public boolean deleteNode(long value){
		
		MyTreeNode currNode=root;//引用当前节点从根节点开始
		
		MyTreeNode parent = root;//父节点引用
		
		boolean isLeft=true;
		//循环，只要查找的值不等于当前节点的数据项
		while(currNode.data != value){
		   //进行比较，比较当前查找值和当前节点的大小
			parent=currNode;
             if(currNode.data>value){ //当前查找值比当前节点的数据值要小，那么应该向当前节点的左子节点查找
            	 currNode=currNode.leftChild;
            	 isLeft=true;
             }else {      //当前查找值比当前节点的数据值要大，那么应该向当前节点的右子节点查找
				currNode=currNode.rightChild;
				isLeft=false;
			}			
             if (currNode==null) {  //若查找不到，则返回null值
				return false;
			}
		}
		
		if (currNode.leftChild==null&&currNode.rightChild==null) {
			if (currNode==root) {//删除根节点
				currNode=null;
			}else if (isLeft) {
				parent.leftChild=null;
			}else {
				parent.rightChild=null;
			}
		}else if (currNode.leftChild==null) {
			if(currNode==root){
				root=currNode.rightChild;
			}else if (isLeft) {
				parent.leftChild=currNode.rightChild;
			}else {
				parent.rightChild=currNode.rightChild;
			}
		}else if(currNode.rightChild==null){
			if (currNode==root) {
				root=currNode.leftChild;
			}else if (isLeft) {
				parent.leftChild=currNode.leftChild;
			}else {
				parent.rightChild=currNode.leftChild;
			}
		}else {
			MyTreeNode sucNode=getSucNode(currNode);
			if (sucNode==root) {
				root=sucNode;
			}else if (isLeft) {
				parent.leftChild=sucNode;
			}else {
				parent.rightChild=sucNode;
			}
			sucNode.leftChild=currNode.leftChild;
		}
			
		
		return true;
	}
	
	/**
	 * 查找删除节点的中序后继节点
	 * @param delNode
	 * @return
	 */
	public MyTreeNode getSucNode(MyTreeNode delNode){
		MyTreeNode sucNode=delNode;
		
		MyTreeNode sucParent=delNode;
		
		MyTreeNode currNode=delNode.rightChild;
		
		while(currNode!=null){
			sucParent=sucNode;
			sucNode=currNode;
			currNode=currNode.leftChild;
		}
		
		if (sucNode!=delNode.rightChild) {
			sucParent.leftChild=sucNode.rightChild;
			sucNode.rightChild=delNode.rightChild;
		}
		return sucNode;
	}
	
	
	/**
	 * 前序遍历
	 *（1）访问根节点
	 *（2）前序遍历左子树
	 *（3）前序遍历右子树
	 * @param localNode
	 */
	public void frontOrder(MyTreeNode localNode){
		if (localNode!=null) {
			//访问根节点
			System.out.println(localNode.data);
			//遍历左子树
			frontOrder(localNode.leftChild);
			//遍历右子树
			frontOrder(localNode.rightChild);
		}
	}
	
	/**
	 * 中序遍历:遍历出来的数是从小到大
	 *（1）中序遍历左子树
	 *（2）访问根节点
	 *（3）中序遍历右子树
	 * @param localNode
	 */
	public void inOrder(MyTreeNode localNode){
		if (localNode!=null) {
			//遍历左子树
			inOrder(localNode.leftChild);
			//访问根节点
			System.out.println(localNode.data);
			//遍历右子树
			inOrder(localNode.rightChild);
		}
	}
	
	/**
	 * 后序遍历
	 *（1）后序遍历左子树
	 *（2）后序遍历右子树
	 *（3）访问根节点
	 * @param localNode
	 */
	public void afterOrder(MyTreeNode localNode){
		if (localNode!=null) {
			//遍历左子树
			afterOrder(localNode.leftChild);
			//遍历右子树
			afterOrder(localNode.rightChild);
			//访问根节点
			System.out.println(localNode.data);
		}
	}
}
