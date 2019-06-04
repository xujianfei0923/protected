package com.kgc.entity;

public class Person extends FatherTest implements java.io.Serializable{
	private int id;
	private String name;
	private String address="旧宫";
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
		System.out.println("调用setName的方法.....");
		this.name = name;
		
		System.out.println("现在的名字是:"+this.name);
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
		System.out.println("通过有参构造实例化Person类对象实例");
	}
	public Person() {
		super();
		System.out.println("通过无参构造实例化Person类对象实例");
	}
//	
//	@Override
//	public String toString(){
//		return "{name="+name+" address="+address+" message="+message+"}";
//	}
}
