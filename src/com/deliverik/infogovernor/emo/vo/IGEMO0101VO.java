/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 配置包含关系显示VO
 * 功能描述: 配置包含关系显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGEMO0101VO extends BaseVO implements Serializable{
	
	
	/**顶级SQL*/
	protected String initSQLStr;
	
	/**顶级会话*/
	protected String initSessionStr;
	
	/**资产ID*/
	protected String eid;
	
	/**
	 * 构造函数
	 * @param 
	 */
	public IGEMO0101VO(String initSQLStr,String initSessionStr,String eid) {
		this.initSQLStr = initSQLStr;
		this.initSessionStr = initSessionStr;
		this.eid = eid;
	}

	/**
	 * 构造方法
	 */
	public IGEMO0101VO() {
		super();
	}

	public String getInitSQLStr() {
		return initSQLStr;
	}

	public void setInitSQLStr(String initSQLStr) {
		this.initSQLStr = initSQLStr;
	}

	public String getInitSessionStr() {
		return initSessionStr;
	}

	public void setInitSessionStr(String initSessionStr) {
		this.initSessionStr = initSessionStr;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
}


