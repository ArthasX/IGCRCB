/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: ��Դ���������Ϣ��������ʵ��
  * ��������: ��Դ���������Ϣ��������ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD03SearchCondImpl implements VCD03SearchCond {

	/** ��ĿID */
	protected Integer pid;
	
	/** ����ID */
	protected Integer prid;

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}