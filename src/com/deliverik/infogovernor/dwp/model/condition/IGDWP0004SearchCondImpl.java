/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���������Ϣ��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0004SearchCondImpl implements IGDWP0004SearchCond{

	/** �ƻ�ID */
	protected Integer planid;
	
	/** ������ϢID */
	protected Integer prid;

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
}
