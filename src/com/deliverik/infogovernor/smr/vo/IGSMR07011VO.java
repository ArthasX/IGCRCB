/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * �����ڱ���VO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR07011VO  extends BaseVO implements Serializable {
	
	/** �������Ĳ����ڱ����б� */
	protected List<IG380Info> ig380List;

	/**
	 *�������Ĳ����ڱ����б�ȡ��
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 *�������Ĳ����ڱ����б��趨
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}
	
	
	

}
