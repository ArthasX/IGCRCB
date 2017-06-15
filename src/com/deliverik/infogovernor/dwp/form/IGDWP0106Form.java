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
 * Description: �ճ������ƻ����̷���ҳ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0106Form extends BaseForm{

	/** �ƻ�ID */
	protected Integer planid;
	
	/** ������ϢID */
	protected Integer prid;
	
	/** ������Ϣ���� */
	protected String[] participants;

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
	 * ������ϢIDȡ��
	 * @return prid ������ϢID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������ϢID�趨
	 * @param prid ������ϢID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return participants ������Ϣ����
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * ������Ϣ�����趨
	 * @param participants ������Ϣ����
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
}
