/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;

import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.GoutstockVWInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���õ�������VO
 *
 */
public class IGLOM02191VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Goutstock> goutstockList;
	
	private List<GoutstockVWInfo> goutstockVWList;

	public List<Goutstock> getGoutstockList() {
		return goutstockList;
	}

	public void setGoutstockList(List<Goutstock> goutstockList) {
		this.goutstockList = goutstockList;
	}

	public List<GoutstockVWInfo> getGoutstockVWList() {
		return goutstockVWList;
	}

	public void setGoutstockVWList(List<GoutstockVWInfo> goutstockVWList) {
		this.goutstockVWList = goutstockVWList;
	}

	
}
