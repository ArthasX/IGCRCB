/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;

/**
  * ����: ģ��ӳ���DAO�ӿ�
  * ��������: ģ��ӳ���DAO�ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateMappingDAO�����޸�ΪSOC0206DAO
  */
public interface SOC0206DAO extends BaseHibernateDAO<SOC0206Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0206Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0206Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0206SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0206Info> findByCond(
			final SOC0206SearchCond cond, final int start,
			final int count);
	/**����IDɾ��*/
	public Integer deleteByRtId(Integer rtId);
}