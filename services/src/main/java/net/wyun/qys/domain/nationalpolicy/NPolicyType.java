package net.wyun.qys.domain.nationalpolicy;

import java.util.EnumSet;

public enum NPolicyType {
	法律体系(0), 
	产业政策(1),
	规划(2),
	准入(3),
	投资(4),
	研发(5),
	生产(6),
	财税(7),
	金融(8),
	保险(9),
	新能源(10),
	环保(11),
	安全(12),
	进出口(13),
	反垄断(14),
	销售(15),
	二手车(16),
	后市场(17),
	汽车服务业(18),
	用车服务(19),
	回收利用(20),
	采购管理(21),
	检测(22),
	注册登记(23),
	综合管理(24),
	其他(25);
	
	int value;
	
	public int getValue() {
		return value;
	}

	NPolicyType(int value){
		this.value = value;
	}
	
	public static NPolicyType typeForValue(int value) {
		for (NPolicyType type : EnumSet.allOf(NPolicyType.class)) {
			if (type.getValue() == value) {
				return type;
			}
		}
		
		return 其他;
	}

}
