/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;

/**
  * ����: �ʲ�������̲�ѯ
  * ��������: �ʲ�������̲�ѯ
  * ������¼: 2014/03/13
  * �޸ļ�¼: 
  */
public interface IG500VWBL extends BaseBL {

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<IG500VWInfo> findByCond(IG500VWSearchCond cond);
}