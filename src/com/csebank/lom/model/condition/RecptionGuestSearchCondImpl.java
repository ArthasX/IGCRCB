/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �Ӵ����˲�ѯ�ӿ�ʵ��
 *
 */
public class RecptionGuestSearchCondImpl implements RecptionGuestSearchCond {
	
	/** �Ӵ�����ID */
	protected Integer rid;

	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

}
