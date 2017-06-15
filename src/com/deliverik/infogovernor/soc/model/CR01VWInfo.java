/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集数据信息表接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01VWInfo extends BaseModel{

	/**
	 * 主机标识取得
	 * @return 主机标识
	 */
	public String getHost();

	/**
	 * 采集时间取得
	 * @return 采集时间
	 */
	public String getCollecttime();

	/**
	 * 采集命令取得
	 * @return 采集命令
	 */
	public String getCommand();

	/**
	 * 采集结果顺序取得
	 * @return 采集结果顺序
	 */
	public Integer getCdataorder();

	/**
	 * 采集结果取得
	 * @return 采集结果
	 */
	public String getCdata();

	/**
	 * 保存时间取得
	 * @return 保存时间
	 */
	public String getInserttime();
	
	/**
	 * 结果分类取得
	 * @return 结果分类
	 */
	public String getCategory();

	/**
	 * 关键字取得
	 * @return 关键字
	 */
	public String getKeys();
	
	/**
	 * 平台IP获得
	 * @return
	 */
	public String getIp();
	
	/**
	 * server名取得
	 * @return
	 */
	public String getServername();
	
	/**
	 * server类型取得
	 * @return
	 */
	public String getServertype();
}
