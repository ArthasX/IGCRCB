/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
  * ����: ����ʲ�����������ӿ�
  * ��������: ����ʲ�����������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditEntityItemSearchCond {
	
	/**
	 * ����ʲ�����(1:����, 2:�޸�) ȡ��
	 * 
	 * @return ����ʲ�����
	 */
	public String getAucmptype();
	
	/**
	 * ����CI��ʶȡ��
	 * 
	 * @return ����CI��ʶ
	 */
	public List<String> getTopCIList();
}