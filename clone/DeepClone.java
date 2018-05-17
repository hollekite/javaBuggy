package com.clone;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * ʵ�ֶ������ȿ�¡��������ֻ����һ��getCloneObj ��̬������ֻ��Ҫ����һ��������ɿ�¡����һ������
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
