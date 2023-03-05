package edu.kh.game.dto;

import java.util.Objects;

public class Place {
	
	/* 로비 1
	 * 강의실 2
	 * 화장실 4
	 * 탕비실 5
	 * 회장실 1
	 * 회의실 7(회의실6 + 대회의실)
	 * 강당 2
	 * 옥상정원 1
	 * 
	 * */
	
	// 아이템이 나오거나 좀비가 출현
	
	private String name;
	private int room;
	
	
	public Place() {
		super();
	}
	
	public Place(String name, int room) {
		super();
		this.name = name;
		this.room = room;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom() {
		this.room = room;
	}

	

	
	
}



















