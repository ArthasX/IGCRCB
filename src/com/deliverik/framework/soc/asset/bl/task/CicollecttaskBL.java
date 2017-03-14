/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;

/**
  * ����: cicollecttaskҵ���߼��ӿ�
  * ��������: cicollecttaskҵ���߼��ӿ�
  * ������¼: 2013/07/05
  * �޸ļ�¼: 
  */
public interface CicollecttaskBL extends BaseBL {




	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CicollecttaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond, int start,
			int count);

	public List<Integer> findResourceidByType(int type) throws Exception;
	
	public List<Integer> getTypeIdByName(final List<String> names);
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids);
	
	public List<String> getHQPlateformNameList()throws Exception;

}