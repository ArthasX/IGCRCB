/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: vCloud������־��������ʵ��
  * ��������: vCloud������־��������ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD04SearchCondImpl implements VCD04SearchCond {

	/** ��ĿID */
	protected Integer pid;

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