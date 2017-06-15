/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程相关资产实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessInfoEntityInfo {

	/**
	 * 资产ID取得
	 * @return eiid 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产版本号取得
	 * @return eiversion 资产版本号
	 */
	public Integer getEiversion();
	
	/**
	 * 资产名称取得
	 * @return einame 资产名称
	 */
	public String getEiname();
	
	public String getFingerPrint();
	
}
