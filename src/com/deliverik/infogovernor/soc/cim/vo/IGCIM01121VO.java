/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * 概述: 采集查询之单命令详细查询VO
 * 功能描述: 采集查询之单命令详细查询VO
 * 创建记录: yanglongquan 2013-5-31
 * 修改记录: 
 */
public class IGCIM01121VO extends BaseVO {

	private static final long serialVersionUID = -7758047756094583642L;

	/** 采集结果集合 */
	protected List<CR01VWInfo> cr01List;
	
	/**命令*/
	protected String keys;
	
	/**表名字*/
	protected String tablename;
	
	/**对象名字*/
	protected String host;
	
	/**采集时间*/
	protected String collecttime;

	/**
	 * 采集结果集合取得
	 *
	 * @return cr01List 采集结果集合
	 */
	
	public List<CR01VWInfo> getCr01List() {
		return cr01List;
	}

	/**
	 * 采集结果集合设定
	 *
	 * @param cr01List 采集结果集合
	 */
	
	public void setCr01List(List<CR01VWInfo> cr01List) {
		this.cr01List = cr01List;
	}

	/**
	 * 命令取得
	 *
	 * @return keys 命令
	 */
	
	public String getKeys() {
		return keys;
	}

	/**
	 * 命令设定
	 *
	 * @param keys 命令
	 */
	
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * 表名字取得
	 *
	 * @return tablename 表名字
	 */
	
	public String getTablename() {
		return tablename;
	}

	/**
	 * 表名字设定
	 *
	 * @param tablename 表名字
	 */
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * 对象名字取得
	 *
	 * @return host 对象名字
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 对象名字设定
	 *
	 * @param host 对象名字
	 */
	
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 采集时间取得
	 *
	 * @return collecttime 采集时间
	 */
	
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * 采集时间设定
	 *
	 * @param collecttime 采集时间
	 */
	
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	
	
}
