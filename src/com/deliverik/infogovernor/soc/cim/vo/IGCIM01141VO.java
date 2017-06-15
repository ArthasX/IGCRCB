/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * 概述: 采集查询命令详细对比VO
 * 功能描述: 采集查询命令详细对比VO
 * 创建记录: zhangnan 2013-6-6
 * 修改记录: 
 */
public class IGCIM01141VO extends BaseVO {

	private static final long serialVersionUID = -7758047756094583642L;

	/** 采集结果集合版本1 */
	protected List<CR01VWInfo> cr01List1;
	
	/** 采集结果集合版本2 */
	protected List<CR01VWInfo> cr01List2;
	
	/**命令*/
	protected String keys;
	
	/**表名字*/
	protected String tablenames;
	
	/**对象名字*/
	protected String host;
	
	/**采集时间*/
	protected String collecttime;
	
	/** 版本日期1 */
	protected String collecttime1;
	
	/** 版本日期2 */
	protected String collecttime2;

	/**
	 * 采集结果集合取得
	 *
	 * @return cr01List 采集结果集合
	 */
	
	public List<CR01VWInfo> getCr01List1() {
		return cr01List1;
	}

	/**
	 * 采集结果集合设定
	 *
	 * @param cr01List 采集结果集合
	 */
	
	public void setCr01List1(List<CR01VWInfo> cr01List1) {
		this.cr01List1 = cr01List1;
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
	
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * 表名字设定
	 *
	 * @param tablename 表名字
	 */
	
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
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

	public List<CR01VWInfo> getCr01List2() {
		return cr01List2;
	}

	public void setCr01List2(List<CR01VWInfo> cr01List2) {
		this.cr01List2 = cr01List2;
	}

	public String getCollecttime1() {
		return collecttime1;
	}

	public void setCollecttime1(String collecttime1) {
		this.collecttime1 = collecttime1;
	}

	public String getCollecttime2() {
		return collecttime2;
	}

	public void setCollecttime2(String collecttime2) {
		this.collecttime2 = collecttime2;
	}
	
	
}
