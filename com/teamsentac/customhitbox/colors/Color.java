package com.teamsentac.customhitbox.colors;

import scala.tools.nsc.backend.icode.TypeKinds.ValueTypeKind;

public class Color {
	
	int value;
	String color;
	
	public Color(String color) {
		this.color = color;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return color;
	}

}
