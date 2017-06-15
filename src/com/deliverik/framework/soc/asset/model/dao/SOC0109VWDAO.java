package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCond;



/**
 * �ʲ�������ϢDAO�ӿ�
 * 
 */
public interface SOC0109VWDAO extends BaseHibernateDAO<SOC0109VWInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0109VWInfo> findAll();

	/**
	 * ������������
	 * @param cid ����
	 * @return �������
	 */
	public SOC0109VWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0109VWSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0109VWInfo> findByCond(final SOC0109VWSearchCond cond, final int start, final int count);

	/**
	 * ��ȡ���CID��
	 * @param cond
	 * @return
	 */
	public List<SOC0109VWInfo> findMaxCidByCond(final SOC0109VWSearchCond cond);
}
