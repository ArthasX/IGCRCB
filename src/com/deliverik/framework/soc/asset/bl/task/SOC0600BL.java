/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;
import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;

/**
  * ����: �ʲ�������̲�ѯ
  * ��������: �ʲ�������̲�ѯ
  * ������¼: 2014/03/13
  * �޸ļ�¼: 
  */
public interface SOC0600BL extends BaseBL {

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<SOC0600Info> findByCond(SOC0600SearchCond cond);
}