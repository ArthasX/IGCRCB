/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集结果查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01SearchCond {

	/**
	 * 分区表名取得
	 * @return 分区表明
	 */
	public String getTablename();

	/**
	 * 设备标识取得
	 * @return 设备标识
	 */
	public String getHost() ;
	
	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getCollecttime();
	
	/**
	 * 采集命令取得
	 *
	 * @return command 采集命令
	 */
	
	public String getCommand();
	
	public String getIp();
	
	public String getServername();
	
	public String getServertype();
}
