/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ���񹤵���ѯ�����ӿ�
 */
public interface IG933SearchCond {
	
	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid();
	
	/**
	 * ���񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfcode();
	
	/**
	 * ���񹤵�����IDȡ��
	 * 
	 * @return ���񹤵�����ID
	 */
	public String getSforgid();
	
	/**
	 * ���񹤵���¼��IDȡ��
	 * 
	 * @return ���񹤵���¼��ID
	 */
	public String getSfregisterid();
	
	/**
	 * ���񹤵���¼��NAMEȡ��
	 * 
	 * @return ���񹤵���¼��NAME
	 */
	public String getSfregistername();

	/**
	 * ���񹤵���¼��ʼʱ��ȡ��
	 * 
	 * @return ���񹤵���¼��ʼʱ��
	 */
	public String getSfinstimebegin();


	/**
	 * ���񹤵���¼����ʱ��ȡ��
	 * 
	 * @return ���񹤵���¼����ʱ��
	 */
	public String getSfinstimeend();
	
	/**
	 * ���񹤵���¼ʱ��ȡ��
	 * 
	 * @return ���񹤵���¼ʱ��
	 */
	public String getSftype();
	
	/**
	 * ���񹤵���¼����ȡ��
	 * 
	 * @return ���񹤵���¼����
	 */
	public String getSftitle();
	
	
	/**
	 * ���񹤵���¼״̬ȡ��
	 * 
	 * @return ���񹤵���¼״̬
	 */
	public String getSfstatus();
	
	/**
	 * ���񹤵�������NAMEȡ��
	 * 
	 * @return ���񹤵�������NAME
	 */
	public String getSfreportname();
	
	/**
	 * ���񹤵��Ǽ���NAMEȡ��
	 * 
	 * @return ���񹤵�������NAME
	 */
	public String getSfusername();
}
