/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ����ʲ����Ա��������ʵ��
  * ��������: ����ʲ����Ա��������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0101SearchCondImpl implements
		SOC0101SearchCond {
	
	/** �ʲ�ID */
	protected Integer eiid;

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
}