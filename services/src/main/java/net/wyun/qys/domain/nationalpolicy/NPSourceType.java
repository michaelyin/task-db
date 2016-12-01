package net.wyun.qys.domain.nationalpolicy;

import java.util.EnumSet;

/**
 * when saving to DB, the ordinal number of the enum would be saved.
 * @author michael
 *
 */
public enum NPSourceType {
	国务院(0), 
	发改委(1),
	工信部(2),
	财政部(3),
	科技部(4),
	能源局(5),
	北京市(6),
	上海市(7),
	其他(8)
	;
	
	int value;
	
	public int getValue() {
		return value;
	}

	NPSourceType(int value){
		this.value = value;
	}
	
	public static NPSourceType typeForValue(int value) {
		for (NPSourceType type : EnumSet.allOf(NPSourceType.class)) {
			if (type.getValue() == value) {
				return type;
			}
		}
		
		return 其他;
	}

}
