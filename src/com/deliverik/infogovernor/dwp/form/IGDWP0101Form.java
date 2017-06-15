/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ѯForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0101Form extends BaseForm{

	/** ��ʼʱ�䣺�� */
	protected String startdate_from;
	
	/** ��ʼʱ�䣺�� */
	protected String startdate_to;
	
	/** �ƻ�ID */
	protected Integer planid;
	
	/** ���������ʶ */
	protected String single;
	
	/** ��������ID */
	protected String puserid;

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_from ��ʼʱ�䣺��
	 */
	public String getStartdate_from() {
		return startdate_from;
	}

	/**
	 * ��ʼʱ�䣺���趨
	 * @param startdate_from ��ʼʱ�䣺��
	 */
	public void setStartdate_from(String startdate_from) {
		this.startdate_from = startdate_from;
	}

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_to ��ʼʱ�䣺��
	 */
	public String getStartdate_to() {
		return startdate_to;
	}

	/**
	 * ��ʼʱ�䣺���趨
	 * @param startdate_to ��ʼʱ�䣺��
	 */
	public void setStartdate_to(String startdate_to) {
		this.startdate_to = startdate_to;
	}

	/**
	 * �ƻ�IDȡ��
	 * @return planid �ƻ�ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * �ƻ�ID�趨
	 * @param planid �ƻ�ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * ���������ʶȡ��
	 * @return single ���������ʶ
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * ���������ʶ�趨
	 * @param single ���������ʶ
	 */
	public void setSingle(String single) {
		this.single = single;
	}

	/**
	 * ��������IDȡ��
	 * @return puserid ��������ID
	 */
	public String getPuserid() {
		return puserid;
	}

	/**
	 * ��������ID�趨
	 * @param puserid ��������ID
	 */
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}
}