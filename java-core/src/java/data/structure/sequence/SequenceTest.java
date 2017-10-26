package java.data.structure.sequence;

public class SequenceTest {

	public static void main(String[] args) {
		MySequence mySequence=new MySequence();
	
	    mySequence.appendSeq(mySequence,new MySeqNode("001", "赵健伟", 25))	;
	    mySequence.appendSeq(mySequence,new MySeqNode("002", "詹冉", 25))	;
		mySequence.insertSeq(mySequence,new MySeqNode("003", "赵馨宁", 25),1);
		//System.out.println(mySequence.getMySeqLen());
		mySequence.delSeqNode(mySequence, 3);
		System.out.println(mySequence.getMySeqLen(mySequence));
		//mySequence.listSeq(mySequence);
	}
}
