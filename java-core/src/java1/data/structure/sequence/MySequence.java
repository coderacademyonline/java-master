package java1.data.structure.sequence;


/**
 * 顺序表的实现
 * @author Administrator
 *
 */
public class MySequence {

	/**
	 * 规定顺序表的最大长度为10
	 */
	private static final int MAXLEN=10;
	/**
	 * 保存顺序表的结构数组
	 */
	public MySeqNode[] mySeq=new MySeqNode[MAXLEN+1];
	/**
	 * 已存结点的数量
	 */
	private int seqLen;
	
	/**
	 * 初始化顺序表，即创建空的顺序表
	 */
	public void initMySequence(MySequence mySequence){
		mySequence.seqLen=0;
	}
	
	/**
	 * 获取数序表长度，即已存节点的数量
	 * @return
	 */
	public int getMySeqLen(MySequence mySequence){
		return mySequence.seqLen;
	}
	/**
	 * 插入结点，成功返回1，否则返回0
	 * @param mySeqNode  要插入的结点
	 * @param n 要插入的结点的位置
	 * @return
	 */
	public int insertSeq(MySequence mySequence,MySeqNode mySeqNode,int n){
		if (seqLen>=MAXLEN) {
			System.out.println("数序表已满，不可以插入结点！");
			return 0;
		}
		if(n<1||n>seqLen-1){
			System.out.println("插入结点的位置不对，不可以插入！");
			return 0;
		}
		for(int i=seqLen;i>=n;i--){
			mySeq[i+1]=mySeq[i];//n位置插入结点，那么n位置以后的结点都要向后移动，先从最后一个结点开始移动，一直到第n个结点
		}
		mySequence.mySeq[n]=mySeqNode;
		mySequence.seqLen++;
		return 1;
	}
	/**
	 * 追加结点
	 * @param mySeqNode 要追加的结点
	 * @return
	 */
	public int appendSeq(MySequence mySequence,MySeqNode mySeqNode){
		if (seqLen>=MAXLEN) {
			System.out.println("数序表已满，不可以插入结点！");
			return 0;
		}
		mySequence.mySeq[++seqLen]=mySeqNode;
		return 1;
	}
	
	/**
	 * 遍历所有的结点
	 */
	public void listSeq(MySequence mySequence){
		for (int i = 0; i < mySequence.seqLen; i++) {
			System.out.println("顺序表中的结点为："+mySequence.mySeq[i].key+"，"+mySequence.mySeq[i].name+","+mySequence.mySeq[i].age);
		}
	}
	
	/**
	 * 删除某一个位置上的结点
	 * @param mySequence
	 * @param n
	 * @return
	 */
	public int delSeqNode(MySequence mySequence,int n){
		if (n<1||n>mySequence.seqLen+1) {
			System.out.println("删除位置错误，不可删除结点。");
			return 0;
		}
		for (int i = n; i < mySequence.seqLen; i++) {
			mySequence.mySeq[i]=mySequence.mySeq[i++];//n以后的位置向前移动
		}
		mySequence.seqLen--;
		return 1;
	}
	/**
	 * 根据序列号返回结点
	 * @param mySequence
	 * @param n
	 * @return
	 */
	public MySeqNode getNodeByNum(MySequence mySequence,int n){
		if (n<1||n>mySequence.seqLen+1) {
			System.out.println("结点序号错误，不能返回节点！");
		    return null;
		}
		return mySequence.mySeq[n];
	}
	
	/**
	 * 根据关键字返回结点序列号
	 * @param mySequence
	 * @param key
	 * @return
	 */
	public int getNodeByKey(MySequence mySequence,String key){
		for (int i = 0; i < mySequence.seqLen; i++) {
			if ((mySequence.mySeq[i].key).equals(key)) {
				return i;
			}
		}
		return 0;
	}
}
