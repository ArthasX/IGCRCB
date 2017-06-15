/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import com.deliverik.infogovernor.nms.model.NMS02Info;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: NMSBL基类接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMSBaseBL{

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion();

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version);
	
	/**
     * 获取统一唯一标识
     * 
     * @return
     */
    public String getUUID();
    
    /**
	 * 生成SNMP信息表主键
	 * @param entity SNMP信息表实体
	 * @return SNMP信息表主键
	 */
	public String getSNMPID(NMS02Info entity);
	
	/**
	 * 主机类型标识取得
	 * @param type 主机类型
	 * @return 主机类型标识
	 */
	public String getDeviceType(String type);
}
