/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * ����: �����豸�˿ڼ��������ӿ�
  * ��������: �����豸�˿ڼ��������ӿ�
  * ������¼: 2013/12/30
  * �޸ļ�¼: 
  */
public interface NetDeviceSearchCond {
	/**
	 * eilabel_lk_devnameȡ��
	 *
	 * @return eilabel_lk_devname eilabel_lk_devname
	 */
	public String getEilabel_lk_devname();
	/**
	 * eilabel_lk_ipȡ��
	 *
	 * @return eilabel_lk_ip eilabel_lk_ip
	 */
	public String getEilabel_lk_ip();
	/**
	 * civalue_eqȡ��
	 *
	 * @return civalue_eq civalue_eq
	 */
	public String getCivalue_eq();
}