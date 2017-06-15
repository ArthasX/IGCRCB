/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ�����ͳ�Ʒ�����ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ScienceOperationReportSearchCond {



	/**
	 * ������ȡ��
	 * @return pivarname ������
	 */
	public String getPivarname();

	/**
	 * ����ѡֵȡ��
	 * @return pidoptions ����ѡֵ
	 */
	public String getPidoptions();

	/**
	 * ���̷���ʱ��ȡ��
	 * @return propentime_like ���̷���ʱ��
	 */
	public String getPropentime_like();
	
	/**
	 * �������ͷ�Χȡ��
	 * @return prpdid_in �������ͷ�Χ
	 */
	public List<String> getPrpdid_in();
}
