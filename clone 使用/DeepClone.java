package com.clone;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * 实现对象的深度克隆，该类中只包含一个getCloneObj 静态方法，只需要传入一个对象，则可克隆出另一个对象
 * 
 */
public class DeepClone {
	

	public static Object getCloneObj(Object obj)
	{
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(arrayOutputStream);
		} catch (IOException e1) {
			
			try {
				objectOutputStream.close();
				arrayOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
		
		try {
			objectOutputStream.writeObject(obj);
		} catch (IOException e1) {
			try {
				objectOutputStream.close();
				arrayOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
		
		
		byte[] bts = arrayOutputStream.toByteArray();
		
		
		ObjectInputStream obj_inputStream  = null;
		
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bts);
		try {
			obj_inputStream = new ObjectInputStream(arrayInputStream);
				
			try {
				return obj_inputStream.readObject();
			} catch (ClassNotFoundException e) {
				
				try {
					obj_inputStream.close();
					arrayInputStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				
			}
				
		} catch (IOException e) {
			
			e.printStackTrace();
			try {
				obj_inputStream.close();
				arrayInputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		return null;
	}

}
