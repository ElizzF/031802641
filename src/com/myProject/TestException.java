package com.myProject;

public class TestException {
	public static void main(String[] args) {
        try{
            throw new MyException("���ǿ��ı���");
        }catch(MyException e){
            e.printStackTrace();
        }
    }
}
