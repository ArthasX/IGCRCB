/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04Info extends BaseModel {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public String getId();

	/**
	 * 设备名称取得
	 * @return name 设备名称
	 */
	public String getName();

	/**
	 * 显示IP取得
	 * @return ip 显示IP
	 */
	public String getIp();

	/**
	 * 显示MAC地址取得
	 * @return mac 显示MAC地址
	 */
	public String getMac();

	/**
	 * 设备类型取得
	 * @return type 设备类型
	 */
	public String getType();

	/**
	 * 资产ID取得
	 * @return eiid 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产大版本取得
	 * @return eiversion 资产大版本
	 */
	public Integer getEiversion();

	/**
	 * 资产小版本取得
	 * @return eismallVersion 资产小版本
	 */
	public Integer getEismallVersion();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();

	/**
	 * 更新时间取得
	 * @return updtime 更新时间
	 */
	public String getUpdtime();
	
	/**
     * 获取设备别名
     * @return 设备别名 
     */
    public String getDispname();
}
