/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���̲��нڵ�������ѯ����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0115Form extends BaseForm {

	/** 
	 * ���̲����߱���Ȩ��ID 
	 */
	protected String ptdid;
	
	/** ����ID */
	protected String pdid;
	
	/**
	 * ����״̬ID��From��
	 */
	protected String fpsdid;
	
	/**
	 * ����״̬ID��To��
	 */
	protected String tpsdid;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬ԾǨ����IDȡ��
	 * @return ����״̬ԾǨ����ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * ����״̬ԾǨ����ID�趨
	 * @param ptdid ����״̬ԾǨ����ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * ����״̬ID��From��ȡ��
	 * @return ����״̬ID��From��
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * ����״̬ID��From���趨
	 * @param fpsdid ����״̬ID��From��
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * ����״̬ID��To��ȡ��
	 * @return ����״̬ID��To��
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * ����״̬ID��To���趨
	 * @param tpsdid ����״̬ID��To��
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

}
