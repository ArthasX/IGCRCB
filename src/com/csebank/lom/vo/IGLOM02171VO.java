/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ��Ʒ����VO
 *
 */
public class IGLOM02171VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Goutstock> goutstockList;

	public List<Goutstock> getGoutstockList() {
		return goutstockList;
	}

	public void setGoutstockList(List<Goutstock> goutstockList) {
		this.goutstockList = goutstockList;
	}

}
