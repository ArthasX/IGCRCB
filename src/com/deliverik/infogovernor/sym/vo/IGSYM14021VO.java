/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ������Ϣ����֣�
 * 
 */
@SuppressWarnings("serial")
public class IGSYM14021VO extends BaseVO implements Serializable{
	
	protected List<IG333Info> prstatusList;

	public List<IG333Info> getPrstatusList() {
		return prstatusList;
	}

	public void setPrstatusList(List<IG333Info> prstatusList) {
		this.prstatusList = prstatusList;
	}
	
	

}
