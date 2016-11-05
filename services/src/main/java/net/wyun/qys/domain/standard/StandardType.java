package net.wyun.qys.domain.standard;

import java.util.EnumSet;

public enum StandardType {
	IMB(0), 
    Postnet(1),
    Planet(2),
    Unknown(3);
	
	int value;
	
	public int getValue() {
		return value;
	}

	StandardType(int value){
		this.value = value;
	}
	
	public static StandardType typeForValue(int value) {
		for (StandardType type : EnumSet.allOf(StandardType.class)) {
			if (type.getValue() == value) {
				return type;
			}
		}
		
		return Unknown;
	}

}
