/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程缺省参与者变量权限查询条件实现
 *
 */
public class IG699SearchCondImpl implements IG699SearchCond{
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 主键
	 */
	protected String pdvid_like;
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPdvid_like() {
		return pdvid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param pdvid_like 主键
	 */
	public void setPdvid_like(String pdvid_like) {
		this.pdvid_like = pdvid_like;
	}
	
}
