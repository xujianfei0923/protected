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

	// �����ֶ�
	static void testField(String className) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		// 1)�õ�Class
		// Class clazz =Class.forName(className);//jdbc
//		Class clazz1 =String.class;	
//		Class clazz2 =new String().getClass();

		// 2)filed ��ʾ���еĹ����ֶ�
//		Field [] fields=clazz.getFields();
//		for(Field f :fields) {
//			System.out.println(f.getName()+"--->"+f.getType());
//		}

		// 2����̬���޸�ĳ���ֶ� name
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance(); // ����

		// �õ�name�ֶ�
		Field addressField = clazz.getDeclaredField("address"); // ���е�
		addressField.setAccessible(true);

		// ���name��ֵ
		System.out.println("��ǰ:" + addressField.get(obj));
		// �޸�name--->����
		addressField.set(obj, "�пƵ��̹�");
		// �ĺ����ֵ
		System.out.println("�ĺ�:" + addressField.get(obj));

	}

	// ���Թ��췽��
	static void testConstructor(String className) throws ClassNotFoundException {
		// 1)�õ�ĳ�����͵�Class
		Class clazz = Class.forName(className);
		String clazzName=clazz.getSimpleName();
		// System.out.println(clazz.getSimpleName());  //Person
		// System.out.println(clazz.getName());  //com.kgc.entity.Person
		// 2)�õ����еĹ��췽��
		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println("����:" + constructors.length);
		for (Constructor c : constructors) {
			int count = c.getParameterCount();
			if (count == 0) {
				System.out.println("��ǰ�޲εĹ��췽��:" + clazzName+"()");
			}else {
				Class[] types=c.getParameterTypes();
				System.out.print("��ǰ"+count+"�εĹ��췽��:" + clazzName+"(");  //1
				
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

    //���Է���
	static void testMethod(String className) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
	 /*	//1)Class
		Class clazz =Class.forName(className);
		
		//2)�õ����еķ���
		Method [] methods=clazz.getDeclaredMethods();
		System.out.println(methods.length);
		for(Method m :methods) {
			System.out.println(m.getName()+"-->"+m.getReturnType());
		}
	 
	 */
		
	  //2���õ�ĳ�����������е���	
		Class clazz =Class.forName(className);
		Object obj =clazz.newInstance();
		
		//2.1)�õ�ĳ������
		Method  method =clazz.getDeclaredMethod("setName", Class.forName("java.lang.String"));
				
				
	    //2.2)����ĳ������:  invoke ����
		method.invoke(obj, "������");
	}

	static void testPackage(String className)throws Exception {
		Class clazz =Class.forName(className);
		
		//1)�õ�����Ϣ
		Package p =clazz.getPackage();
		System.out.println(p.getName()+"....");
		
		//2)�õ�����
		Class superClass=clazz.getSuperclass();
		System.out.println("����:"+superClass.getSimpleName());
		
		//3)�õ����ӿ�
		Class [] interfaces=clazz.getInterfaces();
		for(Class i : interfaces) {
			System.out.println("�ӿڵ�����:"+i.getSimpleName());
		}
	}
}










