/**
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model.condition;

import java.util.List;

/**
 * 
 * ֵ��������ʱ���ѯ�ӿ�
 *
 */
public interface DutyPersonSearchCond {
	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid();
	/**
	 * ֵ����IDȡ��
	 * @return ֵ����ID
	 */
	public String getDperuserid();
	
	/**
	 * �װ�ҹ��ȡ��
	 * @return �װ�ҹ��
	 */
	public String getDptype();
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDpertime();
	
	/**
	 * ֵ��ƻ�����ȡ��
	 * @return ֵ��ƻ�����
	 */
	public List<Integer> getDpidList();
}
