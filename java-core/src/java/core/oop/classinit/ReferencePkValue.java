package java.core.oop.classinit;

import java.util.Arrays;

public class ReferencePkValue {

	public static void main(String[] args) {
		ReferencePkValue pkValue=new ReferencePkValue();
		String string="String";
		pkValue.changeString(string);
		System.out.println("String 传递后的值："+string);
		
		StringBuffer buffer=new StringBuffer("StringBuffer");
		pkValue.changeStringBuffer(buffer);
		System.out.println("StringBuffer 传递后的值为："+buffer);
		
		Integer integer=99;
		pkValue.changeInteger(integer);
		System.out.println("Integer 传递后的值为："+integer);
		
		String[] strings={"value","strings"};
		pkValue.changeArray(strings);
		System.out.println("StringArray 传递后的值为："+Arrays.asList(strings));
		
	}
	
	public void changeString(String str){
		str=str+" change";
	}
	
	public void changeStringBuffer(StringBuffer buffer){
		buffer.append(" change");
	}
	
	public void changeInteger(Integer i){
		i=i+1;
	}
	
	public void changeArray(String[] chars){
		chars[0]="change";
	}
}
