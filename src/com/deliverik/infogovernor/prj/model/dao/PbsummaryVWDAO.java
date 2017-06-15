/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼDAO�ӿ�</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */

public interface PbsummaryVWDAO extends BaseHibernateDAO<Pbsummary>{
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Pbsummary> findByCond(final PbsummaryVWSearchCond cond, final int start, final int count);
}
