package com.kgc.entity;

public class Person extends FatherTest implements java.io.Serializable{
	private int id;
	private String name;
	private String address="�ɹ�";
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("����setName�ķ���.....");
		this.name = name;
		
		System.out.println("���ڵ�������:"+this.name);
	}
	public String getAddress() {
		System.out.println("getAddress");
		return address;
	}
	public void setAddress(String address) {
		System.out.println("setAddress");
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
//	
	private Person(String name, String address, int message) {
		super();
		this.name = name;
		this.address = address;
		//this.message = message;
		System.out.println("ͨ���вι���ʵ����Person�����ʵ��");
	}
	public Person() {
		super();
		System.out.println("ͨ���޲ι���ʵ����Person�����ʵ��");
	}
//	
//	@Override
//	public String toString(){
//		return "{name="+name+" address="+address+" message="+message+"}";
//	}
}
