/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.GoutstockVWInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 物品管理VO
 *
 */
public class IGLOM02121VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Goutstock> goutstockList;
	
	private List<GoutstockVWInfo> goutstockVWList;
	
	

	/**
	 * @return the goutstockVWList
	 */
	public List<GoutstockVWInfo> getGoutstockVWList() {
		return goutstockVWList;
	}

	/**
	 * @param goutstockVWList the goutstockVWList to set
	 */
	public void setGoutstockVWList(List<GoutstockVWInfo> goutstockVWList) {
		this.goutstockVWList = goutstockVWList;
	}

	public List<Goutstock> getGoutstockList() {
		return goutstockList;
	}

	public void setGoutstockList(List<Goutstock> goutstockList) {
		this.goutstockList = goutstockList;
	}

}
