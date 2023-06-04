
1. 
public class A{
	private B b;
}


public class B{
	private String f1;
	private int f2;
}


2. 
public class Test1{
	private Test2 t2;
	
	public Test3 method1(){
		Test3 t3 = new Reset3();
		return t3;
	}
}


public class Test2{
		private int f1;
}



public class Test3{
	private String str;

	public String getStr(){
		return str;
	}

	public void setStr(String str){
		this.str = str;
	}
}


3. 
public abstract class Parent{
	public void parentMethod(){
		
	}
	protected abstract void print();
}


public class Child extends Parent{
	private String name;

	public void childMethod(){
		...
	}
	protected void print(){
		...
	}
}


4. 

public abstract class Shape{
	public void draw(){}
	public void erase(){}
	public int getLength(){}
	protected abstract double getArea();
}

public interface Resizable{
	public abstract void resize();
}


public class Triangle extends Shape implements Resizable{
	public boolean isEquilateral(){}	
	protected double getArea(){}
	public void resize(){}

}


public class Rectangle extends Shape implements Resizable{
	public boolean isSquare(){}
	protected double getArea(){}
	pulbic void resize(){}
}


5. 

public class Student{
	private String name;
	private int age;
}

public class ClassRoom{
	private Student student;

	public ClassRoom(Student std){
		this.std = std;
	}
}




6.
public class Book{
	private String title;
	private String author;
}

public class Library{
	private Book book;

	public Library(){
		this.book = new Book();
	}
}



7.

public class Employee{
	private String name;
}

public class Product{
	private String pName;
	private int price;
}

public class Shop{
	private Product product;
	private Employee emp;

	public Shop(Product p){
		this.Product = p;
		this.emp = new Employee();
	}
}



8. 
public class abstract Coffee{
	public String beans;
}


public class Option{
	private int shot;
	private String ice;
	private int syrup;
}


public class CafeLatte extends Coffee{
	private String temperature;
	private int price;

	public void drink{
		Option option = new Option();
	}
}


public class Cafe{
	private String name;
	private String address;
	private CafeLatte latte;

	public Cafe(CafeLatte latte){
		this.latte = latte;
	}

}









