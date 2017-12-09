package java1.data.structure.link;

public class TestDoubleLink {

	public static void main(String[] args) {
		MyDoubleLink doubleLink=new MyDoubleLink();
		doubleLink.insertLast(23);
		doubleLink.insertLast(1);
		doubleLink.insertLast(12);
		doubleLink.insertLast(3);
		
		doubleLink.display();
		
		//doubleLink.insertFindByKey(100, 1);
		//doubleLink.deleteLast();
		doubleLink.deleteByKey(1);
		doubleLink.display();

	}

}
