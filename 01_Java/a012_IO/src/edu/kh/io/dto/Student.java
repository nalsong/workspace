package edu.kh.io.dto;

import java.io.Serializable;

public class Student implements Serializable{
								// 안쓰면 오류 java.io.NotSerializableException
	
	
	
	
	private String name;
	private int grade;
	private int classRoom;
	private int number;
	private char gender;
	
	public Student() {
		
	}
	
	public Student(String name, int grade, int classRoom, int number, char gender) {
		super();
		this.name = name;
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", classRoom=" + classRoom + ", number=" + number
				+ ", gender=" + gender + "]";
	}
	
	
	
	
	

}


















