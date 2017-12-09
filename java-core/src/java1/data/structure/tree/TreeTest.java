package java1.data.structure.tree;

import java.util.Scanner;

public class TreeTest {

	static final int MAXLEN=20;
	static Scanner input=new Scanner(System.in);
	CBTType InitTree(){
		CBTType node;
		if((node=new CBTType())!=null){
			System.out.println("请先输入一个根节点数据：");
			node.data=input.next();
			node.left=null;
			node.right=null;
			if (node!=null) {
				return node;
			}else {
				return null;
			}
		}
		return null;
	}
	
	void AddTreeNode(CBTType treeNode){
		CBTType pnode,parent;
		String data;
		int menusel;
		if ((pnode=new CBTType())!=null) {
			System.out.println("输入二叉树结点数据：");
			
			pnode.data=input.next();
			pnode.left=null;
			pnode.right=null;
			
			System.out.println("输入该结点的父节点数据：");
			data=input.next();
			
			parent=TreeFindNode(treeNode, data);
			if (parent==null) {
				System.out.println("未找到该结点父节点！");
				pnode=null;
				return;
			}
			System.out.println("1.添加该结点左子树\n2.添加该结点右子树");
			do {
				menusel=input.nextInt();
				if (menusel==1 || menusel==2) {
					if (parent==null) {
						System.out.println("不存在父节点，请先设置父节点");
					}else {
						switch (menusel) {
						case 1:
							if (parent.left!=null) {
								System.out.println("该父节点左子树已存在！");
							}else {
								parent.left=pnode;
							}
							
							break;
                        case 2:
                        	if (parent.right!=null) {
								System.out.println("该父节点右子树已存在");
							}else {
								parent.right=pnode;
							}
                        	break;
						default:
							System.out.println("无效参数");
							break;
						}
					}
				}
			} while (menusel!=1 && menusel!=2);
			
		}
	}
	
	CBTType TreeFindNode(CBTType treeNode,String data){
		CBTType ptr;
		if (treeNode==null) {
			return null;
		}else {
			if (treeNode.data.equals(data)) {
				return treeNode;
			}else {
				if((ptr=TreeFindNode(treeNode.left, data))!=null){
					return ptr;
				}
				else if ((ptr=TreeFindNode(treeNode.right, data))!=null) {
				    return ptr;	
				}else {
					return null;
				}
			}
		}
	}
	
	CBTType TreeLeftNode(CBTType treeNode){
		if (treeNode!=null) {
			return treeNode.left;
		}else {
			return null;
		}
	}
	
	CBTType TreeRightNode(CBTType treeNode){
		if (treeNode!=null) {
			return treeNode.right;
		}else {
			return null;
		}
	}
	
	int TreeIsEmpty(CBTType treeNode){
		if (treeNode!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	int TreeDepth(CBTType treeNode){
		int depleft,depright;
		if (treeNode==null) {
			return 0;
		}else {
			String data=treeNode.data;
			depleft=TreeDepth(treeNode.left);
			String data2=treeNode.data;
			depright=TreeDepth(treeNode.right);
			String data3=treeNode.data;
			if (depleft>depright) {
				return depleft+1;
			}else {
				return depright+1;
			}
		}
	}
	
	void ClearTree(CBTType treeNode){
		if (treeNode!=null) {
			ClearTree(treeNode.left);
			ClearTree(treeNode.right);
			treeNode=null;
		}
	}
	
	void TreeNodeDaTa(CBTType treeNode){
		System.out.print(treeNode.data+" ");
	}
	
	void LevelTree(CBTType treeNode){
		CBTType p;
		CBTType[] q=new CBTType[MAXLEN];
		int head=0,tail=0;
		if (treeNode!=null) {
			tail=(tail+1)%MAXLEN;
			q[tail]=treeNode;
		}
		while(head!=tail){
			head=(head+1)%MAXLEN;
			p=q[head];
			TreeNodeDaTa(p);
			if (p.left!=null) {
				tail=(tail+1)%MAXLEN;
				q[tail]=p.left;
			}
			if (p.right!=null) {
				tail=(tail+1)%MAXLEN;
				q[tail]=p.right;
			}
		}
	}
	
	void DLRTree(CBTType treeNode){
		if (treeNode!=null) {
			TreeNodeDaTa(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	void LDRTree(CBTType treeNode){
		if (treeNode!=null) {
			LDRTree(treeNode.left);
			TreeNodeDaTa(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	void LRDTree(CBTType treeNode){
		if (treeNode!=null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			TreeNodeDaTa(treeNode);
		}
	}
	
	public static void main(String[] args) {
		CBTType root=null;
		int menusel;
		TreeTest treeTest=new TreeTest();
		root=treeTest.InitTree();
		do {
			System.out.println("请选择菜单添加二叉树的结点");
			System.out.println("0.退出");
			System.out.println("1.添加二叉树结点");
			menusel=input.nextInt();
			switch (menusel) {
			case 1:
				treeTest.AddTreeNode(root);
				break;
		    case 0:
		    	break;
			default:
				break;
			}
		} while (menusel != 0);

		do {
			System.out.println("请选择菜单遍历二叉树，输入0表示退出：");
			System.out.print("1.先序遍历DLR\t");
			System.out.println("2.中序遍历LDR");
			System.out.print("3.后序遍历LRD\t");
			System.out.println("4.按层遍历");
			menusel=input.nextInt();
			switch (menusel) {
			case 0:
				break;
            case 1:
            	    System.out.println("先序遍历的结果：");
                    treeTest.DLRTree(root);
                    break;
            case 2:
            	    System.out.println("中序遍历的结果：");
            	    treeTest.LDRTree(root);
            	    break;
            case 3:
            	   System.out.println("后序遍历的结果：");
            	   treeTest.LRDTree(root);
            	   break;
            case 4:
            	   System.out.println("按层遍历的结果：");
            	   treeTest.LevelTree(root);
            	   break;
			default:
				   System.out.println("无效的参数");
				break;
			}
		} while (menusel != 0);
		
		System.out.println("二叉树的深度为："+treeTest.TreeDepth(root));
		
		
		treeTest.ClearTree(root);
		root=null;
	}

}

class CBTType{
	String data;
	CBTType left;
	CBTType right;
}