package com.myProject;

public class TestException {
	public static void main(String[] args) {
        try{
            throw new MyException("这是空文本！");
        }catch(MyException e){
            e.printStackTrace();
        }
    }
}
