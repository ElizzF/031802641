package com.myProject;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainProcess {
	public static void Process(String FilePath, String OtherFilePath, String OutputPath) {
		//将文本变为字符串
		String org = InitString.TextToString(FilePath);
		String otherOrg = InitString.TextToString(OtherFilePath);
		
		int maxLen = Math.max(org.length(), otherOrg.length());
		double ans;
		
		//判断是否小于500，小于余弦相似度计算，大于等于simHash计算
		if(maxLen < 500) 
			ans = CosSimilarity.GetSimilarity(org, otherOrg);
		else 
			ans = SimHashSimilarity.GetSimilarity(org, otherOrg);
		
		//输出
		try {
			PrintStream mytxt=new PrintStream(OutputPath);
			PrintStream out=System.out;
			System.setOut(mytxt);
			System.out.print(String.format("%.2f", ans));
			System.setOut(out);
		 } catch(FileNotFoundException e) {
			e.printStackTrace();
		 }
		
		System.out.println(0);
	}
}
