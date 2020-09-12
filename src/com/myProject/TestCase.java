package com.myProject;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;

class TestCase {
	@Test
	public void testSimHash() {
		File f = new File("tests");
		String[] files = f.list();
		int cnt = 1;
		for(String file: files) {
			if(!file.equals("orig.txt") && !file.equals("short_orig.txt") && !file.equals("short_orig_other.txt")) {
				System.out.println("simHash开始处理：" + file);
				MainProcess.Process("tests/orig.txt", "tests/" + file, "ans/ans" + cnt + ".txt");
				cnt++;
			}
		}
	}
	
	@Test
	public void testCos() { 
		System.out.println("cos开始处理：" + "tests/short_orig_other.txt");
		MainProcess.Process("tests/short_orig.txt", "tests/short_orig_other.txt", "ans/short_ans.txt");
		
	}
}
