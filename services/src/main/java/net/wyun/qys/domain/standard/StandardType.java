package net.wyun.qys.domain.standard;

import java.util.EnumSet;

public enum StandardType {
	安全(0), 
	车身及悬架(1),
	车轮(2),
	材料(3),
	灯光(4),
	底盘(5),
	汽车电子与电磁兼容(6),
	电器(7),
	防盗(8),
	回收利用(9),
	环保不含排放(10),
	节能(11),
	排放(12),
	制动(13),
	电动车辆(14),
	挂车(15),
	客车(16),
	专用车(17),
	液化石油气汽车(18),
	燃气汽车(19),
	仪表(20),
	其他(21);
	
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
		
		return 其他;
	}

}
