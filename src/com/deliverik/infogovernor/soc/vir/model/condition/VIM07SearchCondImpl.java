/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: ���������Ϣ���������ʵ��
  * ��������: ���������Ϣ���������ʵ��
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public class VIM07SearchCondImpl implements VIM07SearchCond {

	/** ����ID */
	protected Integer prid;
	
	/** ��ĿID */
	protected Integer pid;

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
}