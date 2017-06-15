/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.deliverik.infogovernor.nms.model.NMS02Info;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: NMSBL基类实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMSBaseBLImpl implements NMSBaseBL {
	
	/** 设备类型map */
	protected static Map<String, String> deviceTypeMap = new HashMap<String, String>();

	/** 组ID */
    public static Integer GROUPID_DEFAULT = 1;
    
    /** 任务类型：IP段 */
    public static String TaskType_IP = "1";
    
    /** 任务类型：子网 */
    public static String TaskType_SubNet = "2";
    
    /** 任务类型：指定路由 */
    public static String TaskType_Route = "3";
    
	/** 版本 */
	protected Integer version;
	
	static{
		deviceTypeMap.put("AIX主机", "0");
		deviceTypeMap.put("LINUX主机", "1");
		deviceTypeMap.put("WIN主机", "2");
		deviceTypeMap.put("交换机", "3");
		deviceTypeMap.put("路由器", "5");
		deviceTypeMap.put("计算机", "6");
	}

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * 获取统一唯一标识
	 * 
	 * @return
	 */
	public String getUUID() {
	    return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 生成SNMP信息表主键
	 * @param entity SNMP信息表实体
	 * @return SNMP信息表主键
	 */
	public String getSNMPID(NMS02Info entity){
		StringBuffer pk = new StringBuffer();
		pk.append(entity.getSnmpVersion());
		pk.append("_");
		pk.append(entity.getSnmpPort());
		pk.append("_");
		pk.append(entity.getReadCommit());
		pk.append("_");
		pk.append(entity.getWriteCommit());
		pk.append("_");
		pk.append(entity.getSnmpProxyIP());
		pk.append("_");
		pk.append(entity.getSnmpSecurityLevel());
		pk.append("_");
		pk.append(entity.getSnmpUser());
		pk.append("_");
		pk.append(entity.getSnmpSecurityContext());
		pk.append("_");
		pk.append(entity.getSnmpAuthType());
		pk.append("_");
		pk.append(entity.getSnmpPassword());
		pk.append("_");
		pk.append(entity.getSnmpPrivacyType());
		pk.append("_");
		pk.append(entity.getSnmpPrivacyPassPhrase());
		return pk.toString();
	}
	
	/**
	 * 主机类型标识取得
	 * @param type 主机类型
	 * @return 主机类型标识
	 */
	public String getDeviceType(String type){
		String str = deviceTypeMap.get(type);
		if(StringUtils.isEmpty(str)){
			return "";
		}else{
			return str;
		}
	}
}
