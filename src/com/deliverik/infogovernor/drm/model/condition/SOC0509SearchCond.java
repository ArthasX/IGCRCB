/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * ����: Ԥ���½���Ϣ���������ӿ�
  * ��������: Ԥ���½���Ϣ���������ӿ�
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public interface SOC0509SearchCond {
	public String getEsyscoding_like();
	public List<String> getEsyscodingList();
	public String getEid() ;
	public String getCname();
	public String getPcid();
	//��������ѯ
	public String getEsyscoding();
}