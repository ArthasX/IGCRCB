/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCond;

/**
  * ����: ���������Ϣ��DAO�ӿ�
  * ��������: ���������Ϣ��DAO�ӿ�
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public interface VIM07DAO extends BaseHibernateDAO<VIM07Info> {

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM07Info> findByCond(VIM07SearchCond cond, int start, int count);

}