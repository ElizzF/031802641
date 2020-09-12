package com.myProject;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MainProcess {
	public static void Process(String FilePath, String OtherFilePath, String OutputPath) {
		//���ı���Ϊ�ַ���
		String org = InitString.TextToString(FilePath);
		String otherOrg = InitString.TextToString(OtherFilePath);
		
		int maxLen = Math.max(org.length(), otherOrg.length());
		double ans;
		
		//�ж��Ƿ�С��500��С���������ƶȼ��㣬���ڵ���simHash����
		if(maxLen < 500) 
			ans = CosSimilarity.GetSimilarity(org, otherOrg);
		else 
			ans = SimHashSimilarity.GetSimilarity(org, otherOrg);
		
		//���
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
