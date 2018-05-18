package com.clone;

public class CloneConsole {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		child child =new child();
		CloneTest test = new CloneTest(child);
		//浅克隆后
		CloneTest cloneTest = (CloneTest)test.clone();
		System.out.println("源对象："+test+"源对象中的对象："+test.getC());
		System.out.println("浅克隆后对象："+cloneTest+"浅克隆对象中的对象"+cloneTest.getC());
		/**
		 	打印结果：
		 		源对象：com.clone.CloneTest@7852e922源对象中的对象：com.clone.child@4e25154f
				浅克隆后对象：com.clone.CloneTest@70dea4e浅克隆对象中的对象com.clone.child@4e25154f
			浅克隆后虽然对象的地址不一样了，但是对象中所含的对象的地址却还是一样的，所以迁客隆只能克隆一层对象，如果想克隆多层，
			需要在重写的clone()方法中实现对对象中的对象的克隆。
				浅克隆的出对象和源对象中的对象还有依赖关系。操作克隆对象对源对象还会长生影响。
		 */
		System.out.println("-----------------------------------");
		//深克隆
		CloneTest cloneTest2 = (CloneTest)DeepClone.getCloneObj(test);
		System.out.println("源对象："+test+"源对象中的对象："+test.getC());
		System.out.println("浅克隆后对象："+cloneTest2+"浅克隆对象中的对象"+cloneTest2.getC());
		/**
	 	打印结果：
	 		源对象：com.clone.CloneTest@7852e922源对象中的对象：com.clone.child@4e25154f
			浅克隆后对象：com.clone.CloneTest@3d075dc0浅克隆对象中的对象com.clone.child@214c265e
		深克隆后对象的地址和对象中的对象的地址也不一样了，这样才是真正的克隆。这样克隆出来的对象和源对象是没有依赖关系的
		是一个新的对象。
	 */
		
		
	
	}

}
