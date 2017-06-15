/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;


/**
 * ��Ʊ���Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0117Form extends BaseForm implements RiskAuditDefResultVWSearchCond {
	
	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** ���������״̬ */
	protected String radstatus;
	
	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		if(raiid != null && raiid == 0) {
			raiid = null;
		}
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
	
	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radstatus ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

}
