package com.kgc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		try {
			testPackage("com.kgc.entity.Person");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 测试字段
	static void testField(String className) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		// 1)得到Class
		// Class clazz =Class.forName(className);//jdbc
//		Class clazz1 =String.class;	
//		Class clazz2 =new String().getClass();

		// 2)filed 显示所有的公有字段
//		Field [] fields=clazz.getFields();
//		for(Field f :fields) {
//			System.out.println(f.getName()+"--->"+f.getType());
//		}

		// 2）动态的修改某个字段 name
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance(); // 对象

		// 得到name字段
		Field addressField = clazz.getDeclaredField("address"); // 所有的
		addressField.setAccessible(true);

		// 输出name的值
		System.out.println("改前:" + addressField.get(obj));
		// 修改name--->张三
		addressField.set(obj, "中科电商谷");
		// 改后输出值
		System.out.println("改后:" + addressField.get(obj));

	}

	// 测试构造方法
	static void testConstructor(String className) throws ClassNotFoundException {
		// 1)得到某个类型的Class
		Class clazz = Class.forName(className);
		String clazzName=clazz.getSimpleName();
		// System.out.println(clazz.getSimpleName());  //Person
		// System.out.println(clazz.getName());  //com.kgc.entity.Person
		// 2)得到所有的构造方法
		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println("长度:" + constructors.length);
		for (Constructor c : constructors) {
			int count = c.getParameterCount();
			if (count == 0) {
				System.out.println("当前无参的构造方法:" + clazzName+"()");
			}else {
				Class[] types=c.getParameterTypes();
				System.out.print("当前"+count+"参的构造方法:" + clazzName+"(");  //1
				
				StringBuffer str = new StringBuffer();
				for(Class t :types) {
					str.append(t.getSimpleName()+",");
				}
				str.deleteCharAt(str.length()-1);
				
				System.out.print(str.toString()); //2
				
				System.out.println(")");   //3
			}
		}
	}

    //测试方法
	static void testMethod(String className) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
	 /*	//1)Class
		Class clazz =Class.forName(className);
		
		//2)得到所有的方法
		Method [] methods=clazz.getDeclaredMethods();
		System.out.println(methods.length);
		for(Method m :methods) {
			System.out.println(m.getName()+"-->"+m.getReturnType());
		}
	 
	 */
		
	  //2）得到某个方法，进行调用	
		Class clazz =Class.forName(className);
		Object obj =clazz.newInstance();
		
		//2.1)得到某个方法
		Method  method =clazz.getDeclaredMethod("setName", Class.forName("java.lang.String"));
				
				
	    //2.2)调用某个方法:  invoke 调用
		method.invoke(obj, "新名字");
	}

	static void testPackage(String className)throws Exception {
		Class clazz =Class.forName(className);
		
		//1)得到包信息
		Package p =clazz.getPackage();
		System.out.println(p.getName()+"....");
		
		//2)得到父类
		Class superClass=clazz.getSuperclass();
		System.out.println("父类:"+superClass.getSimpleName());
		
		//3)得到父接口
		Class [] interfaces=clazz.getInterfaces();
		for(Class i : interfaces) {
			System.out.println("接口的名字:"+i.getSimpleName());
		}
	}
}










