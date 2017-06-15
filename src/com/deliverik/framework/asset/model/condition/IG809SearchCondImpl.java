/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

import java.util.Set;

/**
 * 查询接口实现
 *
 */
public class IG809SearchCondImpl implements IG809SearchCond{

	/** 资产ID */
	protected Integer eiid;
	
	/** 关系图类型 */
	protected String eirftype;
	
	/** 关系图文件名 */
	protected String eirfname;
	
	/** 资产ID集合 */
	protected Set<Integer> eiidList;
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 关系图类型取得
	 * @return 关系图类型
	 */
	public String getEirftype() {
		return eirftype;
	}

	/**
	 * 关系图类型设定
	 * @param eirftype 关系图类型
	 */
	public void setEirftype(String eirftype) {
		this.eirftype = eirftype;
	}

	/**
	 * 关系图文件名取得
	 * @return 关系图文件名
	 */
	public String getEirfname() {
		return eirfname;
	}

	/**
	 * 关系图文件名设定
	 * @param eirfname 关系图文件名
	 */
	public void setEirfname(String eirfname) {
		this.eirfname = eirfname;
	}

	/**
	 * 资产ID集合取得
	 * @return 资产ID集合
	 */
	public Set<Integer> getEiidList() {
		return eiidList;
	}

	/**
	 * 资产ID集合设定
	 * @param eiidList 资产ID集合
	 */
	public void setEiidList(Set<Integer> eiidList) {
		this.eiidList = eiidList;
	}
	
}
