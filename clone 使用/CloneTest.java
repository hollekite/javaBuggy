package com.clone;

import java.io.Serializable;

public class CloneTest implements Serializable,Cloneable {

	//child ∂‘œÛ 
	private child c ;
	
	public child getC() {
		return c;
	}
	public void setC(child c) {
		this.c = c;
	}
	public CloneTest(child  c)
	{
		this.c = c;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	
	
}
