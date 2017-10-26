package java.data.structure.link;

public class TestFirstLastLink {

	public static void main(String[] args) {
		MyFirstLastLink firstLastLink=new MyFirstLastLink();
		/*firstLastLink.insetFirst(23);
		firstLastLink.insetFirst(21);
		firstLastLink.insetFirst(12);
		firstLastLink.insetFirst(4);*/
		
		firstLastLink.insertLast(21);
		firstLastLink.insertLast(1);
		firstLastLink.insertLast(12);
		
		firstLastLink.display();
		
		firstLastLink.deleteFirst();
		
		firstLastLink.deleteFirst();
		
		firstLastLink.display();

	}

}
