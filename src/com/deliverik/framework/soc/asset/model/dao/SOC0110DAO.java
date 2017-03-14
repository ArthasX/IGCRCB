/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;

/**
  * ����: ����������ϵ��DAO�ӿ�
  * ��������: ����������ϵ��DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0110DAO extends BaseHibernateDAO<SOC0110Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0110Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0110Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0110SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0110Info> findByCond(
			final SOC0110SearchCond cond, final int start,
			final int count);
	
	/**
	 * ���ð�����ϵ����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0127Info> searchEiBelongRelationVW(final SOC0127SearchCond cond);
	
	/**
	 * ���ð�����ϵ����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(final SOC0127SearchCond cond);
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(final SOC0110SearchCond cond);
	
	/**
	 * ���ݸ���ѯ���д��ڵĹ�ϵ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond);
	
	/**
	 * ���ݶ����豸��ѯ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond);

	public void delByEiid(Integer eiid);

}