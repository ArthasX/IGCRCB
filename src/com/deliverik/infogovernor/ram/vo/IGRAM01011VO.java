/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * �����������Ͳ�ѯ����֣�
 * 
 * @author tangzhen@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRAM01011VO extends BaseVO implements Serializable{
	
	/** �����������Ͳ�ѯ��� */
	protected List<IG380Info> ig380List;

	/**
	 * ig380Listȡ��
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 * ig380List�趨
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}



}


