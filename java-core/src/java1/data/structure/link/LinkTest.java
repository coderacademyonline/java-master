package java1.data.structure.link;

public class LinkTest {

	public static void main(String[] args) {
		MyLinkList linkList=new MyLinkList();
		/*linkList.insetFirst(20);
		linkList.insetFirst(23);
		linkList.insetFirst(10);
		linkList.insetFirst(22);*/
		
		linkList.insertEnd(20);
		linkList.insertEnd(10);
		linkList.insertEnd(30);
		linkList.insertEnd(5);
		
		linkList.insertFindByKey(15, 10);
		
		linkList.display();
		
		//linkList.deleteFirst();
		
		
		
		//linkList.display();
		
		//linkList.find(10).display();;
		/*linkList.delete(23);
		System.out.println();
		linkList.display();*/
	}
}
