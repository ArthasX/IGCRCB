/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;
/**
 * ����: �¼����������ϲ�ѯҵ���߼��ӿ�
 * ��������: �¼����������ϲ�ѯҵ���߼��ӿ�
 * ������¼: 2017/08/02
 * �޸ļ�¼: 
 */
public interface EventAndProblemVWBL extends BaseBL{

	/**
	 * ��ѯ�¼�������
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<EventAndProblemVWInfo> findByCond( EventAndProblemVWSearchCond cond,  int start,  int count);
	
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount( EventAndProblemVWSearchCond cond);
}
