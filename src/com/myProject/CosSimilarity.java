package com.myProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class CosSimilarity {
	//获得相似度
	public static double GetSimilarity(String str, String otherStr) {
		String[] Words = SeparateStr(str);
		String[] otherWords = SeparateStr(otherStr);
		
		Map<String, Integer> WordCount = Count(Words);
		Map<String, Integer> OtherWordCount = Count(otherWords);
		
		Set<String> Keys = new HashSet<String>(); //存储所有分词
		for(Map.Entry<String, Integer> entry: WordCount.entrySet()) {
			Keys.add(entry.getKey());
		}
		for(Map.Entry<String, Integer> entry: OtherWordCount.entrySet()) {
			Keys.add(entry.getKey());
		}
		
		double sum = 0.0, demoninator = 0.0, otherDemoninator = 0.0, numerator = 0.0;
		Iterator<String> it = Keys.iterator();
		while (it.hasNext()) {
			String temp = (String)it.next();
			if(WordCount.get(temp) == null || OtherWordCount.get(temp) == null) {
				if(WordCount.get(temp) != null) demoninator += WordCount.get(temp) * WordCount.get(temp);
				if(OtherWordCount.get(temp) != null) otherDemoninator += OtherWordCount.get(temp) * OtherWordCount.get(temp);
			}
			else {
				numerator += WordCount.get(temp) * OtherWordCount.get(temp);
				demoninator += WordCount.get(temp) * WordCount.get(temp);
				otherDemoninator += OtherWordCount.get(temp) * OtherWordCount.get(temp);
			}
        }
		sum = numerator / Math.sqrt(demoninator * otherDemoninator);
		return sum;
	}
	
	//分词
	public static String[] SeparateStr(String sentence) {
		List<Term> termList = StandardTokenizer.segment(sentence);
		String[] Split = termList.toString().split(",");
		
		for(int i = 0; i < Split.length; i++) {
			Split[i] = Split[i].replaceAll("[^\u4E00-\u9FA5]", "");  //去除除中文外所有符号
		}
		return Split;
	}
    
	//获得词频
	public static Map<String, Integer> Count(String[] words) {
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			if(word.trim().isEmpty()) continue;  //空格跳过
			if(wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
		
		return wordCount;
	}
}
