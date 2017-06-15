/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.bl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置原数据相关常量
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGRAWCIType {
	
	private static Map<String, String> valueMap = new HashMap<String, String>();
	
	static{
		valueMap.put("logic", "逻辑属性");
		valueMap.put("physical", "硬件信息");
		valueMap.put("software", "软件信息");
		valueMap.put("mem", "内存信息");
		valueMap.put("part", "分区信息");
		valueMap.put("cpu", "CPU信息");
		valueMap.put("disk", "磁盘信息");
		valueMap.put("bus", "总线信息");
		valueMap.put("pci", "PCI扩展");
		valueMap.put("bios", "BIOS信息");
		valueMap.put("driver", "驱动信息");
		valueMap.put("if", "网卡信息");
		valueMap.put("os", "系统信息");
		valueMap.put("fs", "文件系统");
		valueMap.put("env", "环境变量");
		valueMap.put("hba", "HBA属性");
		valueMap.put("vg", "卷组信息");
		valueMap.put("pv", "卷组信息");
		valueMap.put("env", "环境变量");
		valueMap.put("IO", "IO设备");
		valueMap.put("map", "映射关系");
		valueMap.put("mc", "微码信息");
		valueMap.put("fc", "光纤接口");
		valueMap.put("vhost", "虚拟主机");
		valueMap.put("port", "端口");
		valueMap.put("da", "后端口");
		valueMap.put("ddm", "设备驱动");
		valueMap.put("array", "组信息");
		valueMap.put("fbvol", "分卷信息");
		valueMap.put("stgencl", "机箱信息");
		valueMap.put("hostconnect", "主机连接");
		valueMap.put("extpool", "扩展池");
		valueMap.put("volgrp", "卷组信息");
		//-------------------------------------ORACLE----------------------------------------------------------
		valueMap.put("ORACLE", "Oracle属性");
		valueMap.put("DB_NAME", "数据库信息");
		valueMap.put("DB_USER", "用户信息");
		valueMap.put("DB_TABLESPACE", "表空间信息");
		valueMap.put("DB_TABLE", "表属性信息");
		valueMap.put("DB_FILE", "数据库文件信息");
		//-------------------------------------VMWare----------------------------------------------------------
		valueMap.put("vmware", "VMWare属性");
		valueMap.put("datacenter", "数据中心信息");
		valueMap.put("cluster", "集群信息");
		valueMap.put("datastore", "数据存储信息");
		valueMap.put("host", "Esx主机信息");
		valueMap.put("lun", "Lun信息");
		valueMap.put("vm", "虚拟机信息");
		valueMap.put("datacenter", "数据中心信息");
		//-------------------------------------sybase----------------------------------------------------------
		valueMap.put("sybase", "Sybase属性");
		valueMap.put("Sybase", "Sybase数据库信息");
		valueMap.put("Device", "设备信息");
		valueMap.put("User", "用户信息");
		valueMap.put("Table", "表信息");
		//-------------------------------------informix----------------------------------------------------------
		valueMap.put("informix", "informix属性");
		valueMap.put("Informix", "Informix数据库信息");
		valueMap.put("Dbs", "数据文件信息");
		valueMap.put("Model Base", "库信息");
		valueMap.put("OnConfig", "OnConfig信息");
		//-------------------------------------informix----------------------------------------------------------
		valueMap.put("server", "Tuxedo服务信息");
		valueMap.put("domian", "domian信息");
		valueMap.put("group", "Group信息");
		valueMap.put("machine", "machine信息");
	}
	
	public static String getCategory(String arg){
		String value = "缺省";
		if(StringUtils.isNotEmpty(arg)){
			if(StringUtils.isNotEmpty(valueMap.get(arg))){
				value = valueMap.get(arg);
			}
		}
		return value;
	}
	
	public static String getKeys(String arg){
		StringBuffer value = new StringBuffer();
		if(StringUtils.isNotEmpty(arg)){
			String[] keys = arg.split(",");
			int index=0;
			for(String key:keys){
				if(index>0){
					value.append(",");
				}
				if(StringUtils.isNotEmpty(valueMap.get(key))){
					index++;
					value.append(valueMap.get(key));
				}
			}
		}
		return value.toString();
	}
}
