/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

/**
 * 
 * 关系图相关常量类
 *
 */
public final class EiRelationKeyWords {
	
	/** 系统 */	
	public static final String SYS = "999003001";
	
	/** 应用 */	
	public static final String APPLICATION = "999003002";
	
	/** 主机 */	
	public static final String HOST = "999001001";
	
	/** HBA卡 */	
	public static final String HBA = "999001002";
	
	/** HBA端口 */	
	public static final String HBAPORT = "999001003";
	
	/** 网络设备 */	
	public static final String NETDEVICE = "999001006";
	
	/** 存储交换机 */	
	public static final String SWITCH = "999001006001";
	
	/** 存储 */	
	public static final String STORAGE = "999001009";
	
	/** 前端口 */	
	public static final String FRONTPORT = "999001011";
	
	/** DISK */	
	public static final String DISK = "999001013";
	
	/** DA */	
	public static final String DA = "999001012";
	
	/** SANPORT */	
	public static final String SANPORT = "999001008";
	
	/** FA */	
	public static final String FA = "999001010";
	
	/** 业务系统-应用模块 */	
	public static final String EIR_ID_18 = "18";
	
	/** 应用-主机 */	
	public static final String EIR_ID_3 = "3";
	
	/** ===================物理通路=================== */	
		
	/** 主机-HBA卡 */	
	public static final String EIR_ID_201 = "201";
	
	/** HBA卡-HBA Port */	
	public static final String EIR_ID_202 = "202";
	
	/** HBA Port-SAN Port */	
	public static final String EIR_ID_203 = "203";
	
	/** SAN Port-SAN 模块 */	
	public static final String EIR_ID_204 = "204";
	
	/** SAN 模块-SAN 交换机 */	
	public static final String EIR_ID_205 = "205";
	
	/** SAN 交换机-SAN 模块 */	
	public static final String EIR_ID_206 = "206";
	
	/** SAN 模块-SAN Port */	
	public static final String EIR_ID_207 = "207";
	
	/** SAN Port-前端口 */	
	public static final String EIR_ID_208 = "208";
	
	/** 前端口-FA */	
	public static final String EIR_ID_209 = "209";
	
	/** FA-磁盘阵列 */	
	public static final String EIR_ID_210 = "210";
	
	/** 磁盘阵列-DA */	
	public static final String EIR_ID_211 = "211";
	
	/** DA-Disk */	
	public static final String EIR_ID_212 = "212";
	
	/** 主机-磁盘阵列 */	
	public static final String EIR_ID_222 = "222";
	
	/** 主机-Disk */	
	public static final String EIR_ID_230 = "230";
	
	/** 主机-前端口 */	
	public static final String EIR_ID_231 = "231";
	
	/** SAN 交换机-SAN Port */	
	public static final String EIR_ID_225 = "225";
			
	/** ===================逻辑通路=================== */	
	
	/** 主机-FS */	
	public static final String EIR_ID_213 = "213";
	
	/** 主机-LV */	
	public static final String EIR_ID_214 = "214";
	
	/** 主机-VG */	
	public static final String EIR_ID_215 = "215";
	
	/** FS-LV */	
	public static final String EIR_ID_216 = "216";
	
	/** LV-PV */	
	public static final String EIR_ID_217 = "217";
	
	/** PV-Meta */	
	public static final String EIR_ID_218 = "218";
	
	/** Meta-Hyper */	
	public static final String EIR_ID_219 = "219";
	
	/** Hyper-Disk */	
	public static final String EIR_ID_220 = "220";
	
	/** VG-PV */	
	public static final String EIR_ID_221 = "221";
	
	private EiRelationKeyWords() {
	}
	
}
