package com.myProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class InitString {
	
	//文件转换为字符串
	public static String TextToString(String file){
		File Path = new File(file);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path),"UTF-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();    
        } catch(Exception e) {
            e.printStackTrace();
        }
        return RemoveLebel(result.toString());
    }
	
	//清除输入字符串中除了文字逗号句号外的标签、回车等
	public static String RemoveLebel(String str) {
		str = Jsoup.clean(str, Whitelist.none());
		str = StringUtils.lowerCase(str);
		String[] strings = { " ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;" };
		for(String index: strings) {
			str = str.replaceAll(index, "");
		}
		return str;
	}
	
}
