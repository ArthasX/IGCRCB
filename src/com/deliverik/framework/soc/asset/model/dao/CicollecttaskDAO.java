/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.math.BigInteger;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;

/**
  * ����: cicollecttaskDAO�ӿ�
  * ��������: cicollecttaskDAO�ӿ�
  * ������¼: 2013/07/05
  * �޸ļ�¼: 
  */
public interface CicollecttaskDAO extends BaseHibernateDAO<CicollecttaskInfo> {


	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CicollecttaskInfo> findByCond(
			final CicollecttaskSearchCond cond, final int start,
			final int count);

	
	public Integer getSearchCount(CicollecttaskSearchCond cond);
	
	public List<Integer> getTypeIdByName(final List<String> names);
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids);
	
	public List<String> getPlateformNameList()throws Exception;

}