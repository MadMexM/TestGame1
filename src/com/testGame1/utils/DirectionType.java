package com.testGame1.utils;

public enum DirectionType {
	IDLE ("idle"),
	UP ("up"),
	DOWN ("down"),
	LEFT ("left"),
	RIGHT ("right");
	
	private String direction;
	
	DirectionType(String direction){
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}

}
