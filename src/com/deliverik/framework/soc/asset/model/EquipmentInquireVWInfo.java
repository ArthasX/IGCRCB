/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-01-31
 * 修改记录：
 */
public interface EquipmentInquireVWInfo {
	
	/**
	 *设备主键取得
	 * @return 设备主键
	 */
	public Integer getEiid();
	/**
	 *类型名称取得
	 * @return 类型名称
	 */
	public String getEname() ;
	
	/**
	 *设备名称取得
	 * @return 设备名称
	 */
	public String getEiname();
	
	/**
	 *业务系统取得
	 * @return 业务系统
	 */
	public String getBusinesssys();
	
	/**
	 *IP地址取得
	 * @return IP地址
	 */
	public String getIp();
	
	/**
	 *型号取得
	 * @return 型号
	 */
	public String getPattern();
	
	/**
	 *机柜中位置取得
	 * @return 机柜中位置
	 */
	public String getSite();
	
	/**
	 *所属机柜取得
	 * @return 所属机柜
	 */
	public String getComputerContainer();
	
	/**
	 *所属机房取得
	 * @return 所属机房
	 */
	public String getComputerroom();
	
	/**
	 * 所属机柜Id取得
	 *
	 * @param computerContainerId 所属机柜Id
	 */
	public Integer getComputerContainerId();
	
	 /**
     * 设备编号取得
     *
     * @return eilabel 设备编号
     */
    public String getEilabel();
    /**
     * 所属机房Id取得
     *
     * @return computerroomId 所属机房Id
     */
    public Integer getComputerroomId();
}
