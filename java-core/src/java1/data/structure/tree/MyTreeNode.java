package java1.data.structure.tree;

/**
 * 二叉树的节点
 * @author Administrator
 *
 */
public class MyTreeNode {

	/**
	 * 数据项，可以是一个对象
	 */
	protected long data;
	
	/**
	 * 字符型数据项
	 */
	protected String sData;
	/**
	 * 左子节点
	 */
	protected MyTreeNode leftChild;
	
	/**
	 * 右子节点
	 */
	protected MyTreeNode rightChild;
	
	/**
	 * 构造方法,可以存储多个
	 * @param value
	 */
	public MyTreeNode(long value,String sData){
		this.data=value;
		this.sData=sData;
	}
	
	/**
	 * 构造方法
	 * @param value
	 */
	public MyTreeNode(long value){
		this.data=value;
	}
}
