package net.wyun.qys.domain.standard;

import java.util.EnumSet;

public enum StandardType {
	安全(1), 
	车身及悬架(2),
	车轮(3),
	材料(4),
	灯光(5),
	底盘(6),
	汽车电子与电磁兼容(7),
	电器(8),
	防盗(9),
	回收利用(10),
	环保不含排放(11),
	节能(12),
	排放(13),
	制动(14),
	电动车辆(15),
	挂车(16),
	客车(17),
	专用车(18),
	液化石油气汽车(19),
	燃气汽车(20),
	仪表(21),
	其他(22);
	
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
