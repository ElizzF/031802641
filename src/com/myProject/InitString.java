package com.myProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class InitString {
	
	//�ļ�ת��Ϊ�ַ���
	public static String TextToString(String file){
		File Path = new File(file);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path),"UTF-8"));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine()) != null) {//ʹ��readLine������һ�ζ�һ��
                result.append(System.lineSeparator() + s);
            }
            br.close();    
        } catch(Exception e) {
            e.printStackTrace();
        }
        return RemoveLebel(result.toString());
    }
	
	//��������ַ����г������ֶ��ž����ı�ǩ���س���
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
