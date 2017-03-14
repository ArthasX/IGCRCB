/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

/**
  * 概述: 告警规则模板表检索条件接口
  * 功能描述: 告警规则模板表检索条件接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00004SearchCond {
	
	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid();
	/**
	 * 规则模板名称取得
	 * @作者 zhaoyong
	 */
	public String getRuletempname();
	/**
	 * 模板状态取得
	 * @作者 zhaoyong
	 */
	public Integer getTempstate();
	/**
	 * 删除id取得
	 * @作者 zhaoyong
	 */
	public String[] getDeleteId();
	
	/**
	 * 设备类型取得
	 */
	public String getTypeid();
	
	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition();
	
	/**
	 * 创建时间取得
	 */
	public String getCreatetime();
	
	/**
	 * 描述取得
	 */
	public String getTempdesc();
	
	/**
	 * 模板状态取得
	 * @作者 zhaoyong
	 */
	public Integer getTempstates();
	
	/**
	 * 模板ID列表
	 * @return
	 */
	public List<Integer> getTempidList();
	
	/**
	 * 描述
	 * @return
	 */
	public String getSummary();
}