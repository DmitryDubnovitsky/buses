package com.efftech.spring.domain;



import java.util.Vector;


public class VectorId {
	
	private static VectorId vectore=new VectorId();
	
	private VectorId(){
		
	}

	public static VectorId getInstance()
	{
		return vectore;
		
	}
	private Vector<Long>vector;

	public Vector<Long> getVector() {
		return vector;
	}

	public void setVector(Vector<Long> vector) {
		this.vector = vector;
	}
	
	
	
}
