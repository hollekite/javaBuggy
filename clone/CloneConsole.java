package com.clone;

public class CloneConsole {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		child child =new child();
		CloneTest test = new CloneTest(child);
		//ǳ��¡��
		CloneTest cloneTest = (CloneTest)test.clone();
		System.out.println("Դ����"+test+"Դ�����еĶ���"+test.getC());
		System.out.println("ǳ��¡�����"+cloneTest+"ǳ��¡�����еĶ���"+cloneTest.getC());
		/**
		 	��ӡ�����
		 		Դ����com.clone.CloneTest@7852e922Դ�����еĶ���com.clone.child@4e25154f
				ǳ��¡�����com.clone.CloneTest@70dea4eǳ��¡�����еĶ���com.clone.child@4e25154f
			ǳ��¡����Ȼ����ĵ�ַ��һ���ˣ����Ƕ����������Ķ���ĵ�ַȴ����һ���ģ�����Ǩ��¡ֻ�ܿ�¡һ�����������¡��㣬
			��Ҫ����д��clone()������ʵ�ֶԶ����еĶ���Ŀ�¡��
				ǳ��¡�ĳ������Դ�����еĶ�����������ϵ��������¡�����Դ���󻹻᳤��Ӱ�졣
		 */
		System.out.println("-----------------------------------");
		//���¡
		CloneTest cloneTest2 = (CloneTest)DeepClone.getCloneObj(test);
		System.out.println("Դ����"+test+"Դ�����еĶ���"+test.getC());
		System.out.println("ǳ��¡�����"+cloneTest2+"ǳ��¡�����еĶ���"+cloneTest2.getC());
		/**
	 	��ӡ�����
	 		Դ����com.clone.CloneTest@7852e922Դ�����еĶ���com.clone.child@4e25154f
			ǳ��¡�����com.clone.CloneTest@3d075dc0ǳ��¡�����еĶ���com.clone.child@214c265e
		���¡�����ĵ�ַ�Ͷ����еĶ���ĵ�ַҲ��һ���ˣ��������������Ŀ�¡��������¡�����Ķ����Դ������û��������ϵ��
		��һ���µĶ���
	 */
		
		
	
	}

}
