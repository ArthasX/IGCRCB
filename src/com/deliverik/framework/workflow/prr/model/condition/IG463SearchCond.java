/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ��������ѯ�ӿ�
 */
public interface IG463SearchCond {
	/**
	 * ��Ȩ��IDȡ��
	 * 
	 * @return ��Ȩ��ID
	 */
	public String getPpwauthorizeuserid();
	
	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getPpwproxyusername();
	
	/**
	 * �����˴���ʱ�� ��ȡ��
	 * 
	 * @return �����˴���ʱ�� ��
	 */
	public String getPpwoptiontime_t();
	
	/**
	 * �����˴���ʱ�� ��ȡ��
	 * 
	 * @return �����˴���ʱ�� ��
	 */
	public String getPpwoptiontime_f();
	
	/**
	 * �رձ�ʶȡ��
	 * 
	 * @return �رձ�ʶ
	 */
	public String getPpwcloseflag();
	/**
	 * ����idȡ��
	 * 
	 * @return ����id
	 */
	public Integer getPpwprid();
	
	/**
	 * ������idȡ��
	 * 
	 * @return ������id
	 */
	public String getPpwproxyuserid();
	
	/**
	 * ���̱��ȡ��
	 * 
	 * @return ���̱��
	 */
	public String getPpwprserialnum();
}
