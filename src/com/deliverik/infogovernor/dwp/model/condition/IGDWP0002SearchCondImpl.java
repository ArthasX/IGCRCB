/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������Ϣ��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0002SearchCondImpl implements IGDWP0002SearchCond{

	/** �ƻ�ID */
	protected Integer planid;

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
}
