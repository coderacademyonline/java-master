package java.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileRead {

	public static void main(String[] args) throws IOException {
		String path="d:"+File.separator+"temp"+File.separator+"file.txt";
		File file=new File(path);
		System.out.println(file.exists());
	    InputStream input=new FileInputStream(file);
		int len=2014;
	    byte[] data=new byte[len];
		int index=0;
		int temp=0;
		while((input.read(data,index,len))!=-1) {
			
			System.out.println(new String(data, index, len));
			index++;
		}
		
		
		input.close();
	}
}
