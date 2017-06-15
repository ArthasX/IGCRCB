/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.xml;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表流程对应XML文件名称管理类接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface XMLFileManager {
	
	/**
	 * 初始化
	 */
	public void init();

	/**
	 * 取得XML文件名称
	 * @param pdid 流程定义ID
	 * @return XML文件名称
	 */
	public String getFileName(String pdid);
	
	/**
	 * 取得XML文件目录
	 * @param pdid 流程定义ID
	 * @return 文件目录
	 */
	public String getDir(String pdid);
}
