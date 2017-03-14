/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����״̬ԾǨ�����������ʵ��
 *
 */
public class IG273SearchCondImpl implements IG273SearchCond{
	
	/** 
	 * ���̲����߱���Ȩ��ID 
	 */
	protected String ptdid;
	
	/**
	 * ����״̬ID��From��
	 */
	protected String fpsdid;
	
	/**
	 * ����״̬ID��To��
	 */
	protected String tpsdid;

	/**
	 * ����״̬ԾǨ��������
	 */
	protected String ptdname;
	
	/**
	 * ����״̬ԾǨ��������
	 */
	protected String ptdtype;
	
	/**
	 * ����״̬ԾǨ����
	 */
	protected String ptdcond;
	
	/**
	 * ����״̬ԾǨ������ģ��ƥ�䣩
	 */
	protected String ptdcond_like;
	
	/**
	 * ����״̬ȱʡԾǨ����
	 */
	protected boolean defaultRule;
	
	/**
	 * ����״̬��ȱʡԾǨ����
	 */
	protected boolean notDefaultRule;
	
	/** 
	 * ���̲����߱���Ȩ��ID 
	 */
	protected String ptdid_like;

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
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdname() {
		return ptdname;
	}

	/**
	 * ����״̬ԾǨ���������趨
	 * @param ptdname ����״̬ԾǨ��������
	 */
	public void setPtdname(String ptdname) {
		this.ptdname = ptdname;
	}
	
	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdtype() {
		return ptdtype;
	}

	/**
	 * ����״̬ԾǨ���������趨
	 * @param ptdtype ����״̬ԾǨ��������
	 */
	public void setPtdtype(String ptdtype) {
		this.ptdtype = ptdtype;
	}

	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond() {
		return ptdcond;
	}

	/**
	 * ����״̬ԾǨ�����趨
	 * @param ptdcond ����״̬ԾǨ����
	 */
	public void setPtdcond(String ptdcond) {
		this.ptdcond = ptdcond;
	}
	
	/**
	 * ����״̬ԾǨ������ģ��ƥ�䣩ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond_like() {
		return ptdcond_like;
	}

	/**
	 * ����״̬ԾǨ�����趨
	 * @param ptdcond_like ����״̬ԾǨ����
	 */
	public void setPtdcond_like(String ptdcond_like) {
		this.ptdcond_like = ptdcond_like;
	}

	/**
	 * ����״̬ȱʡԾǨ����ȡ��
	 * @return ����״̬ȱʡԾǨ����
	 */
	public boolean isDefaultRule() {
		return defaultRule;
	}

	/**
	 * ����״̬ȱʡԾǨ�����趨
	 * @param defaultRule ����״̬ȱʡԾǨ����
	 */
	public void setDefaultRule(boolean defaultRule) {
		this.defaultRule = defaultRule;
	}

	/**
	 * ����״̬��ȱʡԾǨ����ȡ��
	 * @return ����״̬��ȱʡԾǨ����
	 */
	public boolean isNotDefaultRule() {
		return notDefaultRule;
	}

	/**
	 * ����״̬��ȱʡԾǨ�����趨
	 * @param notDefaultRule ����״̬��ȱʡԾǨ����
	 */
	public void setNotDefaultRule(boolean notDefaultRule) {
		this.notDefaultRule = notDefaultRule;
	}

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * 
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPtdid_like() {
		return ptdid_like;
	}

	/**
	 * ���̲����߱���Ȩ��ID�趨
	 * 
	 * @param ptdid_like ���̲����߱���Ȩ��ID
	 */
	public void setPtdid_like(String ptdid_like) {
		this.ptdid_like = ptdid_like;
	}
	
}
