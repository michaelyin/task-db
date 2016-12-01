package net.wyun.qys.domain.localpolicy;

import java.util.EnumSet;

/**
 * when saving to DB, the ordinal number of the enum would be saved.
 * @author michael
 *
 */
public enum LPSourceType {
	工信厅(0), 
	财政厅(1),
	科技厅(2),
	能源局(3),
	其他(4)
	;
	
	int value;
	
	public int getValue() {
		return value;
	}

	LPSourceType(int value){
		this.value = value;
	}
	
	public static LPSourceType typeForValue(int value) {
		for (LPSourceType type : EnumSet.allOf(LPSourceType.class)) {
			if (type.getValue() == value) {
				return type;
			}
		}
		
		return 其他;
	}

}
