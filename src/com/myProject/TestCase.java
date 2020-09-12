package com.myProject;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;

class TestCase {
	@Test
	public void testSimHash() {
		File f = new File("test");
		String[] files = f.list();
		int cnt = 1;
		for(String file: files) {
			if(!file.equals("orig.txt")) {
				System.out.println("开始处理" + file);
				MainProcess.Process("test/orig.txt", "test/" + file, "ans/ans" + cnt + ".txt");
				cnt++;
			}
		}
	}

}
