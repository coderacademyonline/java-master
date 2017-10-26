package java.core.io.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件操作
 * @author zhaojw_420
 *
 */
public class MyFile {

	private static final String PATH="D:"+File.separator+"myapp";
	
	@Test
	public  void createFile() throws IOException {
		String path=PATH+File.separator+"myfile"+File.separator+"file"+File.separator+"myfile.txt";
		File file=new File(path);
		if (file.getParentFile()!=null) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	public void listFiles(File file) {
		
		if (file.isDirectory()) {
			File[] files=file.listFiles();
			for (File ff : files) {
				listFiles(ff);
			}
		}
		System.out.println(file);
	}
	@Test
	public void getFile() {
		File file=new File(PATH);
		listFiles(file);
	}
}
