/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;
import com.deliverik.framework.soc.asset.model.dao.CicollecttaskDAO;

/**
  * ����: cicollecttaskҵ���߼�ʵ��
  * ��������: cicollecttaskҵ���߼�ʵ��
  * ������¼: 2013/07/05 ��ʡ
  * �޸ļ�¼: 
  */
public class CicollecttaskBLImpl extends BaseBLImpl implements
		CicollecttaskBL {

	/** cicollecttaskDAO�ӿ� */
	protected CicollecttaskDAO cicollecttaskDAO;
	
	/**
	 * cicollecttaskDAO�ӿ��趨
	 *
	 * @param cicollecttaskDAO cicollecttaskDAO�ӿ�
	 */
	public void setCicollecttaskDAO(CicollecttaskDAO cicollecttaskDAO) {
		this.cicollecttaskDAO = cicollecttaskDAO;
	}



	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CicollecttaskSearchCond cond) {
		return cicollecttaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond) {
		return cicollecttaskDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return cicollecttaskDAO.findByCond(cond, start, count);
	}



	
	public List<CicollecttaskInfo> findAllByCollectType(String collectType)
			throws Exception {

		return null;
	}
	
	public List<Integer> findResourceidByType(int type) throws Exception {
		return new ArrayList<Integer>();
	}
	
	public List<Integer> getTypeIdByName(final List<String> names){
		return cicollecttaskDAO.getTypeIdByName(names);
	}
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids){
		return cicollecttaskDAO.getResourceIdByType(typeids);
	}

	public List<String> getHQPlateformNameList() throws Exception {
		return cicollecttaskDAO.getPlateformNameList();
	}

}