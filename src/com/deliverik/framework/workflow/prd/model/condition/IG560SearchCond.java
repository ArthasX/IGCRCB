/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * ����: ����״̬��˽�б�Ĭ��ֵ����������ӿ� ��������: ����״̬��˽�б�Ĭ��ֵ����������ӿ� ������¼: 2015/02/07 �޸ļ�¼:
 */
public interface IG560SearchCond {
	public String getPidid_q();

	public String getPsdid_q();

	public String getPidid_l();

	public String getPsdid_l();

	public String getUsedToAll();
	public String gettOrpsdid();
	/**  
	 * ��ȡpsdid  
	 * @return psdid 
	 */
	public String getPsdid();
}